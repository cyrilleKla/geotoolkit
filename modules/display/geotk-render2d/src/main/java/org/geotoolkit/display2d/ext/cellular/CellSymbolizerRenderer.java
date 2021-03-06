/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2013-2014, Geomatys
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotoolkit.display2d.ext.cellular;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.RenderedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import org.apache.sis.geometry.GeneralEnvelope;
import org.apache.sis.math.Statistics;
import org.geotoolkit.coverage.grid.GridCoverage2D;
import org.geotoolkit.display.PortrayalException;
import org.geotoolkit.display2d.canvas.RenderingContext2D;
import org.geotoolkit.display2d.container.stateless.DefaultCachedRule;
import org.geotoolkit.display2d.container.stateless.StatelessContextParams;
import org.geotoolkit.display2d.primitive.ProjectedCoverage;
import org.geotoolkit.display2d.primitive.ProjectedFeature;
import org.geotoolkit.display2d.primitive.ProjectedGeometry;
import org.geotoolkit.display2d.primitive.ProjectedObject;
import org.geotoolkit.display2d.style.CachedRule;
import org.geotoolkit.display2d.style.renderer.AbstractCoverageSymbolizerRenderer;
import org.geotoolkit.display2d.style.renderer.SymbolizerRenderer;
import org.geotoolkit.display2d.style.renderer.SymbolizerRendererService;
import org.geotoolkit.feature.simple.DefaultSimpleFeature;
import org.geotoolkit.filter.identity.DefaultFeatureId;
import org.geotoolkit.geometry.jts.JTS;
import org.geotoolkit.referencing.CRS;
import org.geotoolkit.referencing.operation.matrix.XAffineTransform;
import org.apache.sis.internal.referencing.j2d.AffineTransform2D;
import org.apache.sis.util.ObjectConverters;
import org.geotoolkit.feature.Feature;
import org.geotoolkit.feature.type.AttributeDescriptor;
import org.geotoolkit.feature.type.FeatureType;
import org.geotoolkit.feature.type.PropertyDescriptor;
import org.opengis.filter.Filter;
import org.opengis.geometry.Envelope;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.MathTransform2D;
import org.opengis.referencing.operation.TransformException;
import org.opengis.util.FactoryException;
import org.apache.sis.util.UnconvertibleObjectException;
import org.apache.sis.util.logging.Logging;
import org.geotoolkit.feature.simple.SimpleFeatureType;

/**
 * TODO : For features, compute statistics only if input symbolizer needs
 *  it, and compute them only on required fields.
 * 
 * @author Johann Sorel (Geomatys)
 */
public class CellSymbolizerRenderer extends AbstractCoverageSymbolizerRenderer<CachedCellSymbolizer>{

    private static final GeometryFactory GF = new GeometryFactory();

    public CellSymbolizerRenderer(SymbolizerRendererService service,
            CachedCellSymbolizer symbol, RenderingContext2D context) {
        super(service, symbol, context);
    }

    /**
     * This symbolizer works with groups when it's features.
     *
     * @param graphics
     * @throws PortrayalException
     */
    @Override
    public void portray(Iterator<? extends ProjectedObject> graphics) throws PortrayalException {
        if(symbol.getCachedRule() == null){
            return;
        }
        //calculate the cells
        final int cellSize = symbol.getSource().getCellSize();
        final AffineTransform trs = renderingContext.getDisplayToObjective();
        final double objCellSize = XAffineTransform.getScale(trs) * cellSize;

        //find min and max cols/rows
        final Envelope env = renderingContext.getCanvasObjectiveBounds2D();
        final CoordinateReferenceSystem crs = env.getCoordinateReferenceSystem();
        final int minCol = (int)(env.getMinimum(0) / objCellSize);
        final int maxCol = (int)((env.getMaximum(0) / objCellSize)+0.5);
        final int minRow = (int)(env.getMinimum(1) / objCellSize);
        final int maxRow = (int)((env.getMaximum(1) / objCellSize)+0.5);
        final int nbRow = maxRow - minRow;
        final int nbCol = maxCol - minCol;

        //create all cell contours
        final Polygon[][] contours = new Polygon[nbRow][nbCol];
        for(int r=0; r<nbRow; r++){
            for(int c=0; c<nbCol; c++){
                final double minx = (minCol+c) * objCellSize;
                final double maxx = minx + objCellSize;
                final double miny = (minRow+r) * objCellSize;
                final double maxy = miny + objCellSize;
                contours[r][c] = GF.createPolygon(new Coordinate[]{
                    new Coordinate(minx, miny),
                    new Coordinate(minx, maxy),
                    new Coordinate(maxx, maxy),
                    new Coordinate(maxx, miny),
                    new Coordinate(minx, miny),
                });
                JTS.setCRS(contours[r][c],crs);
            }
        }


        FeatureType baseType = null;
        SimpleFeatureType cellType = null;
        String[] numericProperties = null;
        Statistics[][][] stats = null;

        try{
            while(graphics.hasNext()){
                final ProjectedObject obj = graphics.next();
                final ProjectedFeature projFeature = (ProjectedFeature) obj;
                if(baseType==null){
                    //we expect all features to have the same type
                    baseType = projFeature.getCandidate().getType();
                    cellType = CellSymbolizer.buildCellType(baseType,crs);

                    final List<String> props = new ArrayList<>();
                    for(PropertyDescriptor desc : baseType.getDescriptors()){
                        if(desc instanceof AttributeDescriptor){
                            final AttributeDescriptor att = (AttributeDescriptor) desc;
                            final Class binding = att.getType().getBinding();
                            if(Number.class.isAssignableFrom(binding) || String.class.isAssignableFrom(binding)){
                                props.add(att.getLocalName());
                            }
                        }
                    }
                    numericProperties = props.toArray(new String[props.size()]);
                    stats = new Statistics[numericProperties.length][nbRow][nbCol];
                    for(int i=0;i<numericProperties.length;i++){
                        for(int j=0;j<nbRow;j++){
                            for(int k=0;k<nbCol;k++){
                                stats[i][j][k] = new Statistics("");
                            }
                        }
                    }
                }
                final ProjectedGeometry pg = projFeature.getGeometry(geomPropertyName);
                final Geometry[] geoms = pg.getObjectiveGeometryJTS();

                //find in which cell it intersects
                int row=-1;
                int col=-1;
                loop:
                for(Geometry g : geoms){
                    if(g==null) continue;
                    for(int r=0;r<nbRow;r++){
                        for(int c=0;c<nbCol;c++){
                            if (contours[r][c].intersects(g)){
                                row = r;
                                col = c;
                                break loop;
                            }
                        }
                    }
                }

                //fill stats
                if(row!=-1){
                    final Feature feature = projFeature.getCandidate();
                    for(int i=0;i<numericProperties.length;i++){
                        final Object value = feature.getProperty(numericProperties[i]).getValue();
                        try {
                            final Number num = ObjectConverters.convert(value, Number.class);
                            if (num != null) {
                                stats[i][row][col].accept(num.doubleValue());
                            }
                        } catch (UnconvertibleObjectException e) {
                            Logging.recoverableException(CellSymbolizerRenderer.class, "portray", e);
                            // TODO - do we really want to ignore?
                        }
                    }
                }
            }
        }catch(TransformException ex){
            throw new PortrayalException(ex);
        }

        if(numericProperties==null){
            //nothing in the iterator
            return;
        }

        //render the cell features
        final Object[] values = new Object[2+7*numericProperties.length];
        final Feature feature = new DefaultSimpleFeature(cellType, new DefaultFeatureId("cell-n"), values, false);
        final StatelessContextParams params = new StatelessContextParams(renderingContext.getCanvas(), null);
        params.update(renderingContext);
        final ProjectedFeature pf = new ProjectedFeature(params,feature);

        final DefaultCachedRule renderers = new DefaultCachedRule(new CachedRule[]{symbol.getCachedRule()},renderingContext);
        
        //expand the search area by the maximum symbol size
        float symbolsMargin = renderers.getMargin(null, renderingContext);
        if(symbolsMargin==0) symbolsMargin = 300f;
        if(symbolsMargin>0 && params.objectiveJTSEnvelope!=null){
            params.objectiveJTSEnvelope = new com.vividsolutions.jts.geom.Envelope(params.objectiveJTSEnvelope);
            params.objectiveJTSEnvelope.expandBy(symbolsMargin);
        }
        
        for(int r=0;r<nbRow;r++){
            for(int c=0;c<nbCol;c++){
                pf.setCandidate(feature);

                values[0] = contours[r][c].getCentroid();
                JTS.setCRS( ((Geometry)values[0]), crs);
                values[1] = contours[r][c];
                int k=1;
                for(int b=0,n=numericProperties.length;b<n;b++){
                    values[++k] = stats[b][r][c].count();
                    values[++k] = stats[b][r][c].minimum();
                    values[++k] = stats[b][r][c].mean();
                    values[++k] = stats[b][r][c].maximum();
                    values[++k] = stats[b][r][c].span();
                    values[++k] = stats[b][r][c].rms();
                    values[++k] = stats[b][r][c].sum();
                }

                renderCellFeature(feature, pf, renderers);
                pf.setCandidate(null);
            }
        }

    }

    @Override
    public void portray(final ProjectedCoverage projectedCoverage) throws PortrayalException {

        if(symbol.getCachedRule() == null){
            return;
        }

        final GridCoverage2D coverage;
        try {
            coverage = getObjectiveCoverage(projectedCoverage);
        } catch (Exception ex) {
            throw new PortrayalException(ex);
        }
        if(coverage == null){
            LOGGER.log(Level.WARNING, "Reprojected coverage is null.");
            return;
        }

        final MathTransform2D gridToCRS = coverage.getGridGeometry().getGridToCRS2D();

        Envelope env = renderingContext.getCanvasObjectiveBounds2D();
        final AffineTransform tr;
        try {
            // TODO: handle the case where gridToCRS is not affine.
            tr = ((AffineTransform) gridToCRS).createInverse();
            env = CRS.transform(new AffineTransform2D(tr), env);

            final MathTransform trans = renderingContext.getMathTransform(renderingContext.getDisplayCRS(), coverage.getCoordinateReferenceSystem2D());
            if(trans instanceof AffineTransform){
                tr.concatenate((AffineTransform)trans);
            }else{
                //TODO try to find a better way to calculate the step
                //currently make a fake affinetransform using the difference between envelopes.
                final AffineTransform dispToObjective = renderingContext.getDisplayToObjective();
                final AffineTransform objToCoverage   = calculateAverageAffine(renderingContext, coverage);
                tr.concatenate(dispToObjective);
                tr.concatenate(objToCoverage);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, ex.getMessage(),ex);
            return;
        }


        //calculate decimation factor
        final int cellSize = symbol.getSource().getCellSize();
        Point2D delta = new Point2D.Double(cellSize, 0);
        delta = tr.deltaTransform(delta, delta);
        final int decimateX = length(delta);
        delta.setLocation(0, cellSize);
        delta = tr.deltaTransform(delta, delta);
        final int decimateY = length(delta);

        final Rectangle2D shp = new Rectangle2D.Double(env.getMinimum(0) / decimateX, env.getMinimum(1) / decimateY, 
                                                       env.getSpan(0)    / decimateX, env.getSpan(1)    / decimateY);
        final RenderedImage image = coverage.getRenderedImage();
        final int nbBand = image.getSampleModel().getNumBands();

        //prepare the cell feature type
        final SimpleFeatureType cellType = CellSymbolizer.buildCellType(coverage);
        final Object[] values = new Object[1+7*nbBand];
        final Feature feature = new DefaultSimpleFeature(cellType, new DefaultFeatureId("cell-n"), values, false);
        final StatelessContextParams params = new StatelessContextParams(renderingContext.getCanvas(), null);
        params.update(renderingContext);
        final ProjectedFeature pf = new ProjectedFeature(params,feature);

        //iterator on image
        final CellIterator ite = new CellIterator(image,decimateX,decimateY);
        final DefaultCachedRule renderers = new DefaultCachedRule(new CachedRule[]{symbol.getCachedRule()},renderingContext);
        
        //expand the search area by the maximum symbol size
        float symbolsMargin = renderers.getMargin(null, renderingContext);
        if(symbolsMargin==0) symbolsMargin = 300f;
        if(symbolsMargin>0 && params.objectiveJTSEnvelope!=null){
            params.objectiveJTSEnvelope = new com.vividsolutions.jts.geom.Envelope(params.objectiveJTSEnvelope);
            params.objectiveJTSEnvelope.expandBy(symbolsMargin);
        }

        //force image interpolation here
        Object oldValue = g2d.getRenderingHint(RenderingHints.KEY_INTERPOLATION);
        if(oldValue == null) oldValue = RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        renderingContext.getRenderingHints().put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        while(ite.next()){
            if(monitor.stopRequested()) break;
            if(!ite.visible(shp)) continue;
            final Point2D point = ite.position();
            pf.clearDataCache();
            try {
                final Point2D obj = gridToCRS.transform(point, null);
                final Statistics[] stats = ite.statistics();

                values[0] = GF.createPoint(new Coordinate(obj.getX(), obj.getY()));
                int k=0;
                for(int b=0,n=nbBand;b<n;b++){
                    values[++k] = stats[b].count();
                    values[++k] = stats[b].minimum();
                    values[++k] = stats[b].mean();
                    values[++k] = stats[b].maximum();
                    values[++k] = stats[b].span();
                    values[++k] = stats[b].rms();
                    values[++k] = stats[b].sum();
                }

                renderCellFeature(feature, pf, renderers);

            } catch (TransformException ex) {
                LOGGER.log(Level.INFO, ex.getMessage(),ex);
            }
        }

        //restore image interpolation
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,oldValue);
        renderingContext.getRenderingHints().put(RenderingHints.KEY_INTERPOLATION,oldValue);

    }

    private void renderCellFeature(Feature feature, final ProjectedFeature pf, DefaultCachedRule renderers) throws PortrayalException{
        boolean painted = false;
        for(int i=0; i<renderers.elseRuleIndex; i++){
            final CachedRule rule = renderers.rules[i];
            final Filter ruleFilter = rule.getFilter();
            //test if the rule is valid for this feature
            if (ruleFilter == null || ruleFilter.evaluate(feature)) {
                painted = true;
                for (final SymbolizerRenderer renderer : renderers.renderers[i]) {
                    renderer.portray(pf);
                }
            }
        }

        //the feature hasn't been painted, paint it with the 'else' rules
        if(!painted){
            for(int i=renderers.elseRuleIndex; i<renderers.rules.length; i++){
                final CachedRule rule = renderers.rules[i];
                final Filter ruleFilter = rule.getFilter();
                //test if the rule is valid for this feature
                if (ruleFilter == null || ruleFilter.evaluate(feature)) {
                    for (final SymbolizerRenderer renderer : renderers.renderers[i]) {
                        renderer.portray(pf);
                    }
                }
            }
        }
    }

    private AffineTransform calculateAverageAffine(final RenderingContext2D context,
            final GridCoverage2D coverage) throws FactoryException, TransformException{

        final MathTransform trs = context.getMathTransform(context.getObjectiveCRS(),coverage.getCoordinateReferenceSystem2D() );

        final Envelope refEnv = context.getCanvasObjectiveBounds();
        final GeneralEnvelope coverageEnv = CRS.transform(trs, refEnv);

        final double objX = refEnv.getSpan(0);
        final double objY = refEnv.getSpan(1);
        final double covX = coverageEnv.getMaximum(0)-coverageEnv.getMinimum(0);
        final double covY = coverageEnv.getMaximum(1)-coverageEnv.getMinimum(1);
        final double scaleX = covX/objX;
        final double scaleY = covY/objY;

        AffineTransform aff = new AffineTransform();
        aff.setToScale(scaleX,scaleY);
        return aff;
    }

    /**
     * Evaluate the lenght of the given vector.
     *
     * @param delta : vector to evaluate
     * @return integer : lenght of the vector rounded at the above integer
     */
    private static int length(final Point2D delta) {
        return Math.max(1, (int) Math.ceil(Math.hypot(delta.getX(), delta.getY())));
    }

    /**
     * {@inheritDoc }
     * <br>
     * Note : do nothing only return coverageSource.
     * In attempt to particulary comportement if exist.
     */
    @Override
    protected GridCoverage2D prepareCoverageToResampling(GridCoverage2D coverageSource, CachedCellSymbolizer symbolizer) {
        return coverageSource;
    }
}
