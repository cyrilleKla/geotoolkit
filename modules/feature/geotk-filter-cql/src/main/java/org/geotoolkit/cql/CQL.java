/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2012, Geomatys
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
package org.geotoolkit.cql;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.geotoolkit.factory.FactoryFinder;
import org.geotoolkit.factory.Hints;
import org.geotoolkit.gui.swing.tree.Trees;
import org.opengis.filter.Filter;
import org.opengis.filter.FilterFactory2;
import org.opengis.filter.expression.Expression;
import org.opengis.filter.expression.PropertyName;

/**
 *
 * @author Johann Sorel (Geomatys)
 */
public final class CQL {

    private static final GeometryFactory GF = new GeometryFactory();
    
    private CQL() {}
    
    private static Object compileExpression(String cql) {
        try {
            //lexer splits input into tokens
            final ANTLRStringStream input = new ANTLRStringStream(cql);
            final TokenStream tokens = new CommonTokenStream(new CQLLexer(input));

            //parser generates abstract syntax tree
            final CQLParser parser = new CQLParser(tokens);
            final CQLParser.expression_return retexp = parser.expression();
            
            return retexp;
            
        } catch (RecognitionException e) {
            throw new IllegalStateException("Recognition exception is never thrown, only declared.");
        }
    }
    
    private static Object compileFilter(String cql) {
        try {
            //lexer splits input into tokens
            final ANTLRStringStream input = new ANTLRStringStream(cql);
            final TokenStream tokens = new CommonTokenStream(new CQLLexer(input));

            //parser generates abstract syntax tree
            final CQLParser parser = new CQLParser(tokens);
            final CQLParser.filter_return retfilter = parser.filter();
            
            return retfilter;
            
        } catch (RecognitionException e) {
            throw new IllegalStateException("Recognition exception is never thrown, only declared.");
        }
    }
    
    public static CommonTree compile(String cql) {
        final Object obj =compileExpression(cql);
        
        CommonTree tree = null;
        if(obj instanceof CQLParser.expression_return){
            tree = (CommonTree)((CQLParser.expression_return)obj).tree;
        }else if(obj instanceof CQLParser.filter_return){
            tree = (CommonTree)((CQLParser.filter_return)obj).tree;
        }
        
        return tree;
    }
    
    public static Expression parseExpression(String cql) throws CQLException{
        final Object obj = compileExpression(cql);
        
        CommonTree tree = null;
        Expression result = null;
        if(obj instanceof CQLParser.expression_return){
            tree = (CommonTree)((CQLParser.expression_return)obj).tree;
            final FilterFactory2 ff = (FilterFactory2) FactoryFinder
                    .getFilterFactory(new Hints(Hints.FILTER_FACTORY,FilterFactory2.class));
            result = convertExpression(tree, ff);
        }
        
        return result;
    }
    
    public static Filter parseFilter(String cql) throws CQLException{
        cql = cql.trim();
        
        //bypass parsing for inclusive filter
        if(cql.isEmpty() || "*".equals(cql)){
            return Filter.INCLUDE;
        }
        
        final Object obj = compileFilter(cql);
        
        CommonTree tree = null;
        Filter result = null;
        if(obj instanceof CQLParser.filter_return){
            tree = (CommonTree)((CQLParser.filter_return)obj).tree;
            final FilterFactory2 ff = (FilterFactory2) FactoryFinder
                    .getFilterFactory(new Hints(Hints.FILTER_FACTORY,FilterFactory2.class));
            result = convertFilter(tree, ff);
        }
        
        return result;
    }
    
    
    public static String write(Filter filter){
        final StringBuilder sb = new StringBuilder();
        filter.accept(FilterToCQLVisitor.INSTANCE,sb);
        return sb.toString();
    }
    
    public static String write(Expression exp){
        final StringBuilder sb = new StringBuilder();
        exp.accept(FilterToCQLVisitor.INSTANCE,sb);
        return sb.toString();
    }
    
    /**
     * Generate a nice looking tree representation of the tree.
     */
    public static String toString(CommonTree tree){
        if(tree == null) return null;        
        final DefaultMutableTreeNode node = explore(tree);
        return Trees.toString(node);
    }
    
    /**
     * Create a TreeNode for the given tree. method is recursive.
     */
    private static DefaultMutableTreeNode explore(CommonTree tree){
        final DefaultMutableTreeNode node = new DefaultMutableTreeNode(tree);
        
        final List children = tree.getChildren();
        
        if(children != null){
            for(Object child : children){
                final DefaultMutableTreeNode n = explore((CommonTree)child);
                node.add(n);
            }
        }
        return node;
    }
    
    /**
     * Convert the given tree in an Expression.
     */
    private static Expression convertExpression(CommonTree tree, FilterFactory2 ff) throws CQLException{
        
        if(tree.getType() < 0){
            throw new CQLException("Unreconized expression : type="+tree.getType()+" text=" + tree.getText());
        }
        
        final int type = tree.getType();
        if(CQLParser.PROPERTY_NAME == type){
            //strip start and end "
            final String text = tree.getText();
            return ff.property(text.substring(1, text.length()-1));
        }else if(CQLParser.INT == type){
            return ff.literal(Integer.valueOf(tree.getText()));
        }else if(CQLParser.FLOAT == type){
            return ff.literal(Double.valueOf(tree.getText()));
        }else if(CQLParser.UNARY == type){
            final String negText = tree.getText();
            final Expression val = convertExpression((CommonTree)tree.getChild(0), ff);
            if("-".equals(negText)){
                final Number n = val.evaluate(null, Number.class);
                if(n instanceof Integer){
                    return ff.literal(-n.intValue());
                }else{
                    return ff.literal(-n.doubleValue());
                }
            }
            
            return val;
        }else if(CQLParser.EXP_ADD == type){
            final String operand = tree.getChild(0).getText();            
            final Expression left = convertExpression((CommonTree)tree.getChild(1), ff);
            final Expression right = convertExpression((CommonTree)tree.getChild(2), ff);
            if("+".equals(operand)){
                return ff.add(left,right);
            }else if("-".equals(operand)){
                return ff.subtract(left,right);
            }
        }else if(CQLParser.EXP_MUL == type){
            final String operand = tree.getChild(0).getText();            
            final Expression left = convertExpression((CommonTree)tree.getChild(1), ff);
            final Expression right = convertExpression((CommonTree)tree.getChild(2), ff);
            if("*".equals(operand)){
                return ff.multiply(left,right);
            }else if("/".equals(operand)){
                return ff.divide(left,right);
            }
        }else if(CQLParser.TEXT == type){
            //strip start and end '
            final String text = tree.getText();
            return ff.literal(text.substring(1, text.length()-1));
//        }else if(CQLParser.OPERATOR == type){
//            final String text = tree.getText();
//            final Expression left = convertExpression((CommonTree)tree.getChild(0), ff);
//            final Expression right = convertExpression((CommonTree)tree.getChild(1), ff);
//            if("+".equals(text)){
//                return ff.add(left,right);
//            }else if("-".equals(text)){
//                return ff.subtract(left,right);
//            }else if("*".equals(text)){
//                return ff.multiply(left,right);
//            }else if("/".equals(text)){
//                return ff.divide(left,right);
//            }
        }else if(CQLParser.NAME == type){
            String name = tree.getText();
            if(tree.getChildCount() == 0){
                //handle as property name
                return ff.property(name);
            }
            
            //handle as a function
            final List<Expression> exps = new ArrayList<Expression>();
            for(int i=1,n=tree.getChildCount()-1;i<n;i++){ //skip first and last ( )
                final CommonTree ct = (CommonTree) tree.getChild(i);
                exps.add(convertExpression(ct, ff));
            }
            return ff.function(name, exps.toArray(new Expression[exps.size()]));
        }
        
        // GEOMETRY TYPES ------------------------------------------------------
        else if(CQLParser.POINT == type){
            final CoordinateSequence cs = parseSequence((CommonTree)tree.getChild(0));
            final Geometry geom = GF.createPoint(cs);
            return ff.literal(geom);
        }else if(CQLParser.LINESTRING == type){
            final CoordinateSequence cs = parseSequence((CommonTree)tree.getChild(0));
            final Geometry geom = GF.createLineString(cs);
            return ff.literal(geom);
        }else if(CQLParser.POLYGON == type){
            final CommonTree serie = (CommonTree)tree.getChild(0);
            final LinearRing contour = GF.createLinearRing(parseSequence((CommonTree)serie.getChild(0)));
            final int n = serie.getChildCount();
            final LinearRing[] holes = new LinearRing[n-1];
            for(int i=1; i<n; i++){
                holes[i-1] = GF.createLinearRing(parseSequence((CommonTree)serie.getChild(i)));
            }
            final Geometry geom = GF.createPolygon(contour,holes);
            return ff.literal(geom);
        }else if(CQLParser.MPOINT == type){
            final CoordinateSequence cs = parseSequence((CommonTree)tree.getChild(0));
            final Geometry geom = GF.createMultiPoint(cs);
            return ff.literal(geom);
        }else if(CQLParser.MLINESTRING == type){
            final CommonTree series = (CommonTree) tree.getChild(0);
            final int n = series.getChildCount();
            final LineString[] strings = new LineString[n];
            for(int i=0; i<n; i++){
                strings[i] = GF.createLineString(parseSequence((CommonTree)series.getChild(i)));
            }            
            final Geometry geom = GF.createMultiLineString(strings);
            return ff.literal(geom);
        }else if(CQLParser.MPOLYGON == type){
            final int n = tree.getChildCount();
            final Polygon[] polygons = new Polygon[n];
            for(int i=0; i<n; i++){
                final CommonTree polyTree = (CommonTree) tree.getChild(i);
                final LinearRing contour = GF.createLinearRing(parseSequence((CommonTree)polyTree.getChild(0)));
                final int hn = polyTree.getChildCount();
                final LinearRing[] holes = new LinearRing[hn-1];
                for(int j=1; j<hn; j++){
                    holes[j-1] = GF.createLinearRing(parseSequence((CommonTree)polyTree.getChild(j)));
                }
                final Polygon geom = GF.createPolygon(contour,holes);
                polygons[i] = geom;
            }            
            final Geometry geom = GF.createMultiPolygon(polygons);
            return ff.literal(geom);
        }
        
        throw new CQLException("Unreconized expression : type="+tree.getType()+" text=" + tree.getText());
    }
    
    private static CoordinateSequence parseSequence(CommonTree tree){
        final int size = tree.getChildCount()/2;
        final Coordinate[] coords = new Coordinate[size];
        for(int i=0,j=0;i<size;i++,j+=2){
            coords[i] = new Coordinate(
                    Double.valueOf(tree.getChild(j).getText()), 
                    Double.valueOf(tree.getChild(j+1).getText()));
        }
        return GF.getCoordinateSequenceFactory().create(coords);
    }
    
    
    /**
     * Convert the given tree in a Filter.
     */
    private static Filter convertFilter(CommonTree tree, FilterFactory2 ff) throws CQLException{
        
        if(!(tree.token != null && tree.token.getTokenIndex() >= 0)){
            throw new CQLException("Unreconized filter : type="+tree.getType()+" text=" + tree.getText());
        }
        
        final int type = tree.getType();
        if(CQLParser.COMPARE == type){
            final String text = tree.getText();
            final Expression left = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression right = convertExpression((CommonTree)tree.getChild(1), ff);
            
            if("=".equals(text)){
                return ff.equals(left, right);
            }else if("<>".equals(text)){
                return ff.notEqual(left, right);
            }else if(">".equals(text)){
                return ff.greater(left,right);
            }else if("<".equals(text)){
                return ff.less(left,right);
            }else if(">=".equals(text)){
                return ff.greaterOrEqual(left,right);
            }else if("<=".equals(text)){
                return ff.lessOrEqual(left,right);
            }else if("<=".equals(text)){
                return ff.lessOrEqual(left,right);
            }else if("like".equalsIgnoreCase(text)){
                return ff.like(left, right.evaluate(null, String.class));
            }
        }else if(CQLParser.ISNULL == type){
            final Expression exp = convertExpression((CommonTree)tree.getChild(0), ff);
            return ff.isNull(exp);
        }else if(CQLParser.BETWEEN == type){
            final Expression exp1 = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression exp2 = convertExpression((CommonTree)tree.getChild(1), ff);
            final Expression exp3 = convertExpression((CommonTree)tree.getChild(2), ff);
            return ff.between(exp1, exp2, exp3);
        }else if(CQLParser.IN == type){
            final Expression val = convertExpression((CommonTree)tree.getChild(0), ff);            
            final int nbchild = tree.getChildCount();
            final List<Expression> exps = new ArrayList<Expression>();
            for(int i=1; i<nbchild; i++){
                exps.add(convertExpression((CommonTree)tree.getChild(i), ff));
            }
            
            final int size = exps.size();
            if(size == 0){
                return Filter.EXCLUDE;
            }else if(size == 1){
                return ff.equals(val, exps.get(0));
            }else{
                final List<Filter> filters = new ArrayList<Filter>();
                for(Expression exp : exps){
                    filters.add(ff.equals(val, exp));
                }
                return ff.or(filters);
            }            
        }else if(CQLParser.AND == type){
            final List<Filter> filters = new ArrayList<Filter>();
            final int nbchild = tree.getChildCount();
            for(int i=0; i<nbchild; i++){
                filters.add(convertFilter((CommonTree)tree.getChild(i), ff));
            }
            return ff.and(filters);
        }else if(CQLParser.OR == type){
            final List<Filter> filters = new ArrayList<Filter>();
            final int nbchild = tree.getChildCount();
            for(int i=0; i<nbchild; i++){
                filters.add(convertFilter((CommonTree)tree.getChild(i), ff));
            }
            return ff.or(filters);
        }else if(CQLParser.NOT == type){
            final Filter sub = convertFilter((CommonTree)tree.getChild(0), ff);
            return ff.not(sub);
        }else if(CQLParser.BBOX == type){
            final String exp = ((PropertyName)convertExpression((CommonTree)tree.getChild(0), ff)).getPropertyName();
            final double v1 = Double.valueOf(tree.getChild(1).getText());
            final double v2 = Double.valueOf(tree.getChild(2).getText());
            final double v3 = Double.valueOf(tree.getChild(3).getText());
            final double v4 = Double.valueOf(tree.getChild(4).getText());
            String crs = null;
            if(tree.getChildCount()>5){
                crs = convertExpression((CommonTree)tree.getChild(5), ff).evaluate(null, String.class);
            }            
            return ff.bbox(exp, v1,v2,v3,v4,crs);
        }else if(CQLParser.BEYOND == type){
            final Expression exp1 = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression exp2 = convertExpression((CommonTree)tree.getChild(1), ff);  
            return ff.beyond(exp1,exp2,0,"");
        }else if(CQLParser.CONTAINS == type){
            final Expression exp1 = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression exp2 = convertExpression((CommonTree)tree.getChild(1), ff);  
            return ff.contains(exp1,exp2);
        }else if(CQLParser.CROSS == type){
            final Expression exp1 = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression exp2 = convertExpression((CommonTree)tree.getChild(1), ff);  
            return ff.crosses(exp1,exp2);
        }else if(CQLParser.DISJOINT == type){
            final Expression exp1 = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression exp2 = convertExpression((CommonTree)tree.getChild(1), ff);  
            return ff.disjoint(exp1,exp2);
        }else if(CQLParser.DWITHIN == type){
            final Expression exp1 = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression exp2 = convertExpression((CommonTree)tree.getChild(1), ff);  
            return ff.dwithin(exp1,exp2,0,"");
        }else if(CQLParser.EQUALS == type){
            final Expression exp1 = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression exp2 = convertExpression((CommonTree)tree.getChild(1), ff);  
            return ff.equal(exp1,exp2);
        }else if(CQLParser.INTERSECT == type){
            final Expression exp1 = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression exp2 = convertExpression((CommonTree)tree.getChild(1), ff);  
            return ff.intersects(exp1,exp2);
        }else if(CQLParser.OVERLAP == type){
            final Expression exp1 = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression exp2 = convertExpression((CommonTree)tree.getChild(1), ff);  
            return ff.overlaps(exp1,exp2);
        }else if(CQLParser.TOUCH == type){
            final Expression exp1 = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression exp2 = convertExpression((CommonTree)tree.getChild(1), ff);  
            return ff.touches(exp1,exp2);
        }else if(CQLParser.WITHIN == type){
            final Expression exp1 = convertExpression((CommonTree)tree.getChild(0), ff);
            final Expression exp2 = convertExpression((CommonTree)tree.getChild(1), ff);  
            return ff.within(exp1,exp2);
        }
        
        throw new CQLException("Unreconized filter : type="+tree.getType()+" text=" + tree.getText());
        
    }
    
}
