/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2008 - 2012, Geomatys
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */


package org.geotoolkit.gml.xml.v321;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.gml._3 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CircleByCenterPoint_QNAME = new QName("http://www.opengis.net/gml/3.2", "CircleByCenterPoint");
    private final static QName _Sphere_QNAME = new QName("http://www.opengis.net/gml/3.2", "Sphere");
    private final static QName _AbstractParametricCurveSurface_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractParametricCurveSurface");
    private final static QName _SolidArrayProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "solidArrayProperty");
    private final static QName _AbstractSurfacePatch_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractSurfacePatch");
    private final static QName _TemporalDatumProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "temporalDatumProperty");
    private final static QName _CartesianCSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "cartesianCSRef");
    private final static QName _RangeMeaning_QNAME = new QName("http://www.opengis.net/gml/3.2", "rangeMeaning");
    private final static QName _MultiPointDomain_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiPointDomain");
    private final static QName _DirectedObservation_QNAME = new QName("http://www.opengis.net/gml/3.2", "DirectedObservation");
    private final static QName _GeneralConversionRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "generalConversionRef");
    private final static QName _ConcatenatedOperation_QNAME = new QName("http://www.opengis.net/gml/3.2", "ConcatenatedOperation");
    private final static QName _UsesAffineCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesAffineCS");
    private final static QName _QuantityTypeReference_QNAME = new QName("http://www.opengis.net/gml/3.2", "quantityTypeReference");
    private final static QName _CoordinateSystemRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "coordinateSystemRef");
    private final static QName _CompositeCurve_QNAME = new QName("http://www.opengis.net/gml/3.2", "CompositeCurve");
    private final static QName _UsesVerticalDatum_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesVerticalDatum");
    private final static QName _UserDefinedCSProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "userDefinedCSProperty");
    private final static QName _BoundedBy_QNAME = new QName("http://www.opengis.net/gml/3.2", "boundedBy");
    private final static QName _AbstractSingleCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractSingleCRS");
    private final static QName _ModifiedCoordinate_QNAME = new QName("http://www.opengis.net/gml/3.2", "modifiedCoordinate");
    private final static QName _AbstractCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractCRS");
    private final static QName _OperationParameterGroup_QNAME = new QName("http://www.opengis.net/gml/3.2", "OperationParameterGroup");
    private final static QName _ArcString_QNAME = new QName("http://www.opengis.net/gml/3.2", "ArcString");
    private final static QName _TopoPoint_QNAME = new QName("http://www.opengis.net/gml/3.2", "TopoPoint");
    private final static QName _UsesObliqueCartesianCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesObliqueCartesianCS");
    private final static QName _MultiExtentOf_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiExtentOf");
    private final static QName _MethodFormula_QNAME = new QName("http://www.opengis.net/gml/3.2", "methodFormula");
    private final static QName _GeodeticDatum_QNAME = new QName("http://www.opengis.net/gml/3.2", "GeodeticDatum");
    private final static QName _Status_QNAME = new QName("http://www.opengis.net/gml/3.2", "status");
    private final static QName _MultiSurfaceDomain_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiSurfaceDomain");
    private final static QName _CompoundCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "CompoundCRS");
    private final static QName _DirectedNode_QNAME = new QName("http://www.opengis.net/gml/3.2", "directedNode");
    private final static QName _TopoPrimitiveMember_QNAME = new QName("http://www.opengis.net/gml/3.2", "topoPrimitiveMember");
    private final static QName _AbstractScalarValueList_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractScalarValueList");
    private final static QName _AbstractReference_QNAME = new QName("http://www.opengis.net/gml/3.2", "abstractReference");
    private final static QName _MultiPoint_QNAME = new QName("http://www.opengis.net/gml/3.2", "MultiPoint");
    private final static QName _MultiSurfaceCoverage_QNAME = new QName("http://www.opengis.net/gml/3.2", "MultiSurfaceCoverage");
    private final static QName _PolarCSProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "polarCSProperty");
    private final static QName _TargetElement_QNAME = new QName("http://www.opengis.net/gml/3.2", "targetElement");
    private final static QName _Parameter_QNAME = new QName("http://www.opengis.net/gml/3.2", "parameter");
    private final static QName _AxisDirection_QNAME = new QName("http://www.opengis.net/gml/3.2", "axisDirection");
    private final static QName _GeodeticDatumRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "geodeticDatumRef");
    private final static QName _Vector_QNAME = new QName("http://www.opengis.net/gml/3.2", "vector");
    private final static QName _DefinedByConversion_QNAME = new QName("http://www.opengis.net/gml/3.2", "definedByConversion");
    private final static QName _OperationMethod_QNAME = new QName("http://www.opengis.net/gml/3.2", "OperationMethod");
    private final static QName _DmsAngle_QNAME = new QName("http://www.opengis.net/gml/3.2", "dmsAngle");
    private final static QName _Count_QNAME = new QName("http://www.opengis.net/gml/3.2", "Count");
    private final static QName _Direction_QNAME = new QName("http://www.opengis.net/gml/3.2", "direction");
    private final static QName _Target_QNAME = new QName("http://www.opengis.net/gml/3.2", "target");
    private final static QName _AbstractGeneralConversion_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractGeneralConversion");
    private final static QName _VerticalCSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "verticalCSRef");
    private final static QName _TimeCSProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "timeCSProperty");
    private final static QName _PolarCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "PolarCS");
    private final static QName _EnvelopeWithTimePeriod_QNAME = new QName("http://www.opengis.net/gml/3.2", "EnvelopeWithTimePeriod");
    private final static QName _ArcByBulge_QNAME = new QName("http://www.opengis.net/gml/3.2", "ArcByBulge");
    private final static QName _TopoVolume_QNAME = new QName("http://www.opengis.net/gml/3.2", "TopoVolume");
    private final static QName _Group_QNAME = new QName("http://www.opengis.net/gml/3.2", "group");
    private final static QName _ValuesOfGroup_QNAME = new QName("http://www.opengis.net/gml/3.2", "valuesOfGroup");
    private final static QName _MappingRule_QNAME = new QName("http://www.opengis.net/gml/3.2", "MappingRule");
    private final static QName _CompoundCRSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "compoundCRSRef");
    private final static QName _Formula_QNAME = new QName("http://www.opengis.net/gml/3.2", "formula");
    private final static QName _DataSourceReference_QNAME = new QName("http://www.opengis.net/gml/3.2", "dataSourceReference");
    private final static QName _Origin_QNAME = new QName("http://www.opengis.net/gml/3.2", "origin");
    private final static QName _PointMembers_QNAME = new QName("http://www.opengis.net/gml/3.2", "pointMembers");
    private final static QName _ImageCRSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "imageCRSRef");
    private final static QName _Degrees_QNAME = new QName("http://www.opengis.net/gml/3.2", "degrees");
    private final static QName _Quantity_QNAME = new QName("http://www.opengis.net/gml/3.2", "Quantity");
    private final static QName _Minutes_QNAME = new QName("http://www.opengis.net/gml/3.2", "minutes");
    private final static QName _ImageDatumRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "imageDatumRef");
    private final static QName _DataBlock_QNAME = new QName("http://www.opengis.net/gml/3.2", "DataBlock");
    private final static QName _File_QNAME = new QName("http://www.opengis.net/gml/3.2", "File");
    private final static QName _IntegerValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "integerValue");
    private final static QName _AffineCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "AffineCS");
    private final static QName _OperationVersion_QNAME = new QName("http://www.opengis.net/gml/3.2", "operationVersion");
    private final static QName _DefinitionMember_QNAME = new QName("http://www.opengis.net/gml/3.2", "definitionMember");
    private final static QName _LocationReference_QNAME = new QName("http://www.opengis.net/gml/3.2", "locationReference");
    private final static QName _SurfaceArrayProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "surfaceArrayProperty");
    private final static QName _MultiSurfaceProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiSurfaceProperty");
    private final static QName _UsesEllipsoid_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesEllipsoid");
    private final static QName _TopoSurface_QNAME = new QName("http://www.opengis.net/gml/3.2", "TopoSurface");
    private final static QName _UsesImageDatum_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesImageDatum");
    private final static QName _Cone_QNAME = new QName("http://www.opengis.net/gml/3.2", "Cone");
    private final static QName _EllipsoidalCSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "ellipsoidalCSRef");
    private final static QName _CompositeValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "CompositeValue");
    private final static QName _ReferenceSystemRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "referenceSystemRef");
    private final static QName _TimeReferenceSystem_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeReferenceSystem");
    private final static QName _ImageDatum_QNAME = new QName("http://www.opengis.net/gml/3.2", "ImageDatum");
    private final static QName _EngineeringDatum_QNAME = new QName("http://www.opengis.net/gml/3.2", "EngineeringDatum");
    private final static QName _AbstractMetaData_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractMetaData");
    private final static QName _TimePosition_QNAME = new QName("http://www.opengis.net/gml/3.2", "timePosition");
    private final static QName _AbstractRing_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractRing");
    private final static QName _BaseGeographicCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "baseGeographicCRS");
    private final static QName _DirectedTopoSolid_QNAME = new QName("http://www.opengis.net/gml/3.2", "directedTopoSolid");
    private final static QName _TemporalCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "TemporalCS");
    private final static QName _UsesTemporalDatum_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesTemporalDatum");
    private final static QName _ArcStringByBulge_QNAME = new QName("http://www.opengis.net/gml/3.2", "ArcStringByBulge");
    private final static QName _TransformationRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "transformationRef");
    private final static QName _TemporalDatum_QNAME = new QName("http://www.opengis.net/gml/3.2", "TemporalDatum");
    private final static QName _MultiPointProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiPointProperty");
    private final static QName _TimeEdge_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeEdge");
    private final static QName _PixelInCell_QNAME = new QName("http://www.opengis.net/gml/3.2", "pixelInCell");
    private final static QName _MultiCenterLineOf_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiCenterLineOf");
    private final static QName _MovingObjectStatus_QNAME = new QName("http://www.opengis.net/gml/3.2", "MovingObjectStatus");
    private final static QName _Ellipsoid_QNAME = new QName("http://www.opengis.net/gml/3.2", "Ellipsoid");
    private final static QName _MultiPointCoverage_QNAME = new QName("http://www.opengis.net/gml/3.2", "MultiPointCoverage");
    private final static QName _DynamicFeature_QNAME = new QName("http://www.opengis.net/gml/3.2", "DynamicFeature");
    private final static QName _UsesSphericalCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesSphericalCS");
    private final static QName _Dictionary_QNAME = new QName("http://www.opengis.net/gml/3.2", "Dictionary");
    private final static QName _DescriptionReference_QNAME = new QName("http://www.opengis.net/gml/3.2", "descriptionReference");
    private final static QName _BaseCurve_QNAME = new QName("http://www.opengis.net/gml/3.2", "baseCurve");
    private final static QName _GeneralTransformationRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "generalTransformationRef");
    private final static QName _AbstractGeneralDerivedCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractGeneralDerivedCRS");
    private final static QName _BaseGeodeticCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "baseGeodeticCRS");
    private final static QName _UserDefinedCSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "userDefinedCSRef");
    private final static QName _PrimeMeridianRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "primeMeridianRef");
    private final static QName _PointMember_QNAME = new QName("http://www.opengis.net/gml/3.2", "pointMember");
    private final static QName _IncludesParameter_QNAME = new QName("http://www.opengis.net/gml/3.2", "includesParameter");
    private final static QName _ValueArray_QNAME = new QName("http://www.opengis.net/gml/3.2", "ValueArray");
    private final static QName _Position_QNAME = new QName("http://www.opengis.net/gml/3.2", "position");
    private final static QName _UserDefinedCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "UserDefinedCS");
    private final static QName _CylindricalCSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "cylindricalCSRef");
    private final static QName _AbstractSurface_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractSurface");
    private final static QName _FeatureMembers_QNAME = new QName("http://www.opengis.net/gml/3.2", "featureMembers");
    private final static QName _DerivedCRSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "derivedCRSRef");
    private final static QName _BaseSurface_QNAME = new QName("http://www.opengis.net/gml/3.2", "baseSurface");
    private final static QName _TimeOrdinalReferenceSystem_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeOrdinalReferenceSystem");
    private final static QName _LineString_QNAME = new QName("http://www.opengis.net/gml/3.2", "LineString");
    private final static QName _TopoSurfaceProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "topoSurfaceProperty");
    private final static QName _Observation_QNAME = new QName("http://www.opengis.net/gml/3.2", "Observation");
    private final static QName _BaseUnit_QNAME = new QName("http://www.opengis.net/gml/3.2", "BaseUnit");
    private final static QName _UsesGeodeticDatum_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesGeodeticDatum");
    private final static QName _UsesTemporalCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesTemporalCS");
    private final static QName _CompositeSolid_QNAME = new QName("http://www.opengis.net/gml/3.2", "CompositeSolid");
    private final static QName _Envelope_QNAME = new QName("http://www.opengis.net/gml/3.2", "Envelope");
    private final static QName _UnitOfMeasure_QNAME = new QName("http://www.opengis.net/gml/3.2", "unitOfMeasure");
    private final static QName _UsesTimeCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesTimeCS");
    private final static QName _ParameterValueGroup_QNAME = new QName("http://www.opengis.net/gml/3.2", "ParameterValueGroup");
    private final static QName _MaximalComplex_QNAME = new QName("http://www.opengis.net/gml/3.2", "maximalComplex");
    private final static QName _LinearRing_QNAME = new QName("http://www.opengis.net/gml/3.2", "LinearRing");
    private final static QName _DefinitionCollection_QNAME = new QName("http://www.opengis.net/gml/3.2", "DefinitionCollection");
    private final static QName _CylindricalCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "CylindricalCS");
    private final static QName _AbstractGML_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractGML");
    private final static QName _MultiSolidProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiSolidProperty");
    private final static QName _DynamicFeatureCollection_QNAME = new QName("http://www.opengis.net/gml/3.2", "DynamicFeatureCollection");
    private final static QName _Identifier_QNAME = new QName("http://www.opengis.net/gml/3.2", "identifier");
    private final static QName _BSpline_QNAME = new QName("http://www.opengis.net/gml/3.2", "BSpline");
    private final static QName _UsesCartesianCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesCartesianCS");
    private final static QName _SourceCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "sourceCRS");
    private final static QName _AffineCSProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "affineCSProperty");
    private final static QName _StatusReference_QNAME = new QName("http://www.opengis.net/gml/3.2", "statusReference");
    private final static QName _SourceDimensions_QNAME = new QName("http://www.opengis.net/gml/3.2", "sourceDimensions");
    private final static QName _TopoComplex_QNAME = new QName("http://www.opengis.net/gml/3.2", "TopoComplex");
    private final static QName _MultiGeometry_QNAME = new QName("http://www.opengis.net/gml/3.2", "MultiGeometry");
    private final static QName _CoordinateSystem_QNAME = new QName("http://www.opengis.net/gml/3.2", "coordinateSystem");
    private final static QName _CoverageMappingRule_QNAME = new QName("http://www.opengis.net/gml/3.2", "CoverageMappingRule");
    private final static QName _PolygonPatches_QNAME = new QName("http://www.opengis.net/gml/3.2", "polygonPatches");
    private final static QName _MultiCurveProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiCurveProperty");
    private final static QName _OperationParameterGroupRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "operationParameterGroupRef");
    private final static QName _MultiPosition_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiPosition");
    private final static QName _VerticalDatumRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "verticalDatumRef");
    private final static QName _OrientableCurve_QNAME = new QName("http://www.opengis.net/gml/3.2", "OrientableCurve");
    private final static QName _DefinitionRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "definitionRef");
    private final static QName _SurfaceMember_QNAME = new QName("http://www.opengis.net/gml/3.2", "surfaceMember");
    private final static QName _Solid_QNAME = new QName("http://www.opengis.net/gml/3.2", "Solid");
    private final static QName _DataSource_QNAME = new QName("http://www.opengis.net/gml/3.2", "dataSource");
    private final static QName _MultiCurveCoverage_QNAME = new QName("http://www.opengis.net/gml/3.2", "MultiCurveCoverage");
    private final static QName _AssociationName_QNAME = new QName("http://www.opengis.net/gml/3.2", "associationName");
    private final static QName _MultiSolidDomain_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiSolidDomain");
    private final static QName _Category_QNAME = new QName("http://www.opengis.net/gml/3.2", "Category");
    private final static QName _MultiSolid_QNAME = new QName("http://www.opengis.net/gml/3.2", "MultiSolid");
    private final static QName _AbstractTimePrimitive_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractTimePrimitive");
    private final static QName _Track_QNAME = new QName("http://www.opengis.net/gml/3.2", "track");
    private final static QName _TimeTopologyComplex_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeTopologyComplex");
    private final static QName _ArcByCenterPoint_QNAME = new QName("http://www.opengis.net/gml/3.2", "ArcByCenterPoint");
    private final static QName _PosList_QNAME = new QName("http://www.opengis.net/gml/3.2", "posList");
    private final static QName _MetaDataProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "metaDataProperty");
    private final static QName _TimeInterval_QNAME = new QName("http://www.opengis.net/gml/3.2", "timeInterval");
    private final static QName _AbstractOperation_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractOperation");
    private final static QName _UsesValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesValue");
    private final static QName _GenericMetaData_QNAME = new QName("http://www.opengis.net/gml/3.2", "GenericMetaData");
    private final static QName _CategoryList_QNAME = new QName("http://www.opengis.net/gml/3.2", "CategoryList");
    private final static QName _GridDomain_QNAME = new QName("http://www.opengis.net/gml/3.2", "gridDomain");
    private final static QName _DoubleOrNilReasonTupleList_QNAME = new QName("http://www.opengis.net/gml/3.2", "doubleOrNilReasonTupleList");
    private final static QName _IncludesSingleCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "includesSingleCRS");
    private final static QName _AbstractTimeTopologyPrimitive_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractTimeTopologyPrimitive");
    private final static QName _Array_QNAME = new QName("http://www.opengis.net/gml/3.2", "Array");
    private final static QName _CurveMembers_QNAME = new QName("http://www.opengis.net/gml/3.2", "curveMembers");
    private final static QName _LocationName_QNAME = new QName("http://www.opengis.net/gml/3.2", "locationName");
    private final static QName _Pos_QNAME = new QName("http://www.opengis.net/gml/3.2", "pos");
    private final static QName _AbstractObject_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractObject");
    private final static QName _GeocentricCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "GeocentricCRS");
    private final static QName _AbstractGriddedSurface_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractGriddedSurface");
    private final static QName _ValueProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "valueProperty");
    private final static QName _Exterior_QNAME = new QName("http://www.opengis.net/gml/3.2", "exterior");
    private final static QName _CartesianCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "CartesianCS");
    private final static QName _VerticalCRSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "verticalCRSRef");
    private final static QName _AbstractGeometricPrimitive_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractGeometricPrimitive");
    private final static QName _DefaultCodeSpace_QNAME = new QName("http://www.opengis.net/gml/3.2", "defaultCodeSpace");
    private final static QName _AbstractTopology_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractTopology");
    private final static QName _TopoCurve_QNAME = new QName("http://www.opengis.net/gml/3.2", "TopoCurve");
    private final static QName _GeometryMember_QNAME = new QName("http://www.opengis.net/gml/3.2", "geometryMember");
    private final static QName _TimeCoordinateSystem_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeCoordinateSystem");
    private final static QName _Null_QNAME = new QName("http://www.opengis.net/gml/3.2", "Null");
    private final static QName _ProjectedCRSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "projectedCRSRef");
    private final static QName _TimeNode_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeNode");
    private final static QName _Curve_QNAME = new QName("http://www.opengis.net/gml/3.2", "Curve");
    private final static QName _SemiMajorAxis_QNAME = new QName("http://www.opengis.net/gml/3.2", "semiMajorAxis");
    private final static QName _MultiEdgeOf_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiEdgeOf");
    private final static QName _TimePeriod_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimePeriod");
    private final static QName _AbstractCurve_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractCurve");
    private final static QName _EngineeringDatumRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "engineeringDatumRef");
    private final static QName _AbstractValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractValue");
    private final static QName _Clothoid_QNAME = new QName("http://www.opengis.net/gml/3.2", "Clothoid");
    private final static QName _TemporalCRSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "temporalCRSRef");
    private final static QName _EllipsoidProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "ellipsoidProperty");
    private final static QName _ReversePropertyName_QNAME = new QName("http://www.opengis.net/gml/3.2", "reversePropertyName");
    private final static QName _ComponentReferenceSystem_QNAME = new QName("http://www.opengis.net/gml/3.2", "componentReferenceSystem");
    private final static QName _AbstractTimeSlice_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractTimeSlice");
    private final static QName _ResultOf_QNAME = new QName("http://www.opengis.net/gml/3.2", "resultOf");
    private final static QName _CubicSpline_QNAME = new QName("http://www.opengis.net/gml/3.2", "CubicSpline");
    private final static QName _AbstractDiscreteCoverage_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractDiscreteCoverage");
    private final static QName _DerivedCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "DerivedCRS");
    private final static QName _GreenwichLongitude_QNAME = new QName("http://www.opengis.net/gml/3.2", "greenwichLongitude");
    private final static QName _TargetCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "targetCRS");
    private final static QName _CenterLineOf_QNAME = new QName("http://www.opengis.net/gml/3.2", "centerLineOf");
    private final static QName _EngineeringCRSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "engineeringCRSRef");
    private final static QName _OperationMethodRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "operationMethodRef");
    private final static QName _Tin_QNAME = new QName("http://www.opengis.net/gml/3.2", "Tin");
    private final static QName _Face_QNAME = new QName("http://www.opengis.net/gml/3.2", "Face");
    private final static QName _TopoCurveProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "topoCurveProperty");
    private final static QName _TimeOrdinalEra_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeOrdinalEra");
    private final static QName _DefinitionProxy_QNAME = new QName("http://www.opengis.net/gml/3.2", "DefinitionProxy");
    private final static QName _Seconds_QNAME = new QName("http://www.opengis.net/gml/3.2", "seconds");
    private final static QName _DomainSet_QNAME = new QName("http://www.opengis.net/gml/3.2", "domainSet");
    private final static QName _MultiSurface_QNAME = new QName("http://www.opengis.net/gml/3.2", "MultiSurface");
    private final static QName _MinimumOccurs_QNAME = new QName("http://www.opengis.net/gml/3.2", "minimumOccurs");
    private final static QName _Angle_QNAME = new QName("http://www.opengis.net/gml/3.2", "angle");
    private final static QName _AxisAbbrev_QNAME = new QName("http://www.opengis.net/gml/3.2", "axisAbbrev");
    private final static QName _TopoPrimitiveMembers_QNAME = new QName("http://www.opengis.net/gml/3.2", "topoPrimitiveMembers");
    private final static QName _IncludesValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "includesValue");
    private final static QName _ProjectedCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "ProjectedCRS");
    private final static QName _CurveMember_QNAME = new QName("http://www.opengis.net/gml/3.2", "curveMember");
    private final static QName _DecimalMinutes_QNAME = new QName("http://www.opengis.net/gml/3.2", "decimalMinutes");
    private final static QName _Value_QNAME = new QName("http://www.opengis.net/gml/3.2", "value");
    private final static QName _TargetDimensions_QNAME = new QName("http://www.opengis.net/gml/3.2", "targetDimensions");
    private final static QName _ObliqueCartesianCSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "obliqueCartesianCSRef");
    private final static QName _TimeCalendar_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeCalendar");
    private final static QName _RectifiedGrid_QNAME = new QName("http://www.opengis.net/gml/3.2", "RectifiedGrid");
    private final static QName _AbstractTimeObject_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractTimeObject");
    private final static QName _MultiCurveDomain_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiCurveDomain");
    private final static QName _SphericalCSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "sphericalCSRef");
    private final static QName _CoordinateOperationRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "coordinateOperationRef");
    private final static QName _RectifiedGridCoverage_QNAME = new QName("http://www.opengis.net/gml/3.2", "RectifiedGridCoverage");
    private final static QName _BooleanValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "booleanValue");
    private final static QName _TopoComplexProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "topoComplexProperty");
    private final static QName _Interior_QNAME = new QName("http://www.opengis.net/gml/3.2", "interior");
    private final static QName _FeatureCollection_QNAME = new QName("http://www.opengis.net/gml/3.2", "FeatureCollection");
    private final static QName _Location_QNAME = new QName("http://www.opengis.net/gml/3.2", "location");
    private final static QName _TemporalCSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "temporalCSRef");
    private final static QName _SubComplex_QNAME = new QName("http://www.opengis.net/gml/3.2", "subComplex");
    private final static QName _MinimumValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "minimumValue");
    private final static QName _TopoPointProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "topoPointProperty");
    private final static QName _Conversion_QNAME = new QName("http://www.opengis.net/gml/3.2", "Conversion");
    private final static QName _CrsRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "crsRef");
    private final static QName _ValueList_QNAME = new QName("http://www.opengis.net/gml/3.2", "valueList");
    private final static QName _UsesOperation_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesOperation");
    private final static QName _ValueOfParameter_QNAME = new QName("http://www.opengis.net/gml/3.2", "valueOfParameter");
    private final static QName _UsesPrimeMeridian_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesPrimeMeridian");
    private final static QName _AbstractGeneralOperationParameterRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "abstractGeneralOperationParameterRef");
    private final static QName _MultiGeometryProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiGeometryProperty");
    private final static QName _MultiCenterOf_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiCenterOf");
    private final static QName _TupleList_QNAME = new QName("http://www.opengis.net/gml/3.2", "tupleList");
    private final static QName _AbstractScalarValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractScalarValue");
    private final static QName _MultiCurve_QNAME = new QName("http://www.opengis.net/gml/3.2", "MultiCurve");
    private final static QName _Coordinates_QNAME = new QName("http://www.opengis.net/gml/3.2", "coordinates");
    private final static QName _UsesEngineeringDatum_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesEngineeringDatum");
    private final static QName _GeographicCRSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "geographicCRSRef");
    private final static QName _PointArrayProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "pointArrayProperty");
    private final static QName _UsesParameter_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesParameter");
    private final static QName _AbstractFeatureCollection_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractFeatureCollection");
    private final static QName _Bag_QNAME = new QName("http://www.opengis.net/gml/3.2", "Bag");
    private final static QName _TimeCalendarEra_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeCalendarEra");
    private final static QName _EllipsoidalCSProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "ellipsoidalCSProperty");
    private final static QName _Scope_QNAME = new QName("http://www.opengis.net/gml/3.2", "scope");
    private final static QName _ConversionToPreferredUnit_QNAME = new QName("http://www.opengis.net/gml/3.2", "conversionToPreferredUnit");
    private final static QName _OffsetCurve_QNAME = new QName("http://www.opengis.net/gml/3.2", "OffsetCurve");
    private final static QName _EllipsoidalCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "EllipsoidalCS");
    private final static QName _CurveArrayProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "curveArrayProperty");
    private final static QName _AbstractContinuousCoverage_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractContinuousCoverage");
    private final static QName _GridFunction_QNAME = new QName("http://www.opengis.net/gml/3.2", "GridFunction");
    private final static QName _Duration_QNAME = new QName("http://www.opengis.net/gml/3.2", "duration");
    private final static QName _PointRep_QNAME = new QName("http://www.opengis.net/gml/3.2", "pointRep");
    private final static QName _CenterOf_QNAME = new QName("http://www.opengis.net/gml/3.2", "centerOf");
    private final static QName _DirectedFace_QNAME = new QName("http://www.opengis.net/gml/3.2", "directedFace");
    private final static QName _EngineeringCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "EngineeringCRS");
    private final static QName _PriorityLocation_QNAME = new QName("http://www.opengis.net/gml/3.2", "priorityLocation");
    private final static QName _GmlProfileSchema_QNAME = new QName("http://www.opengis.net/gml/3.2", "gmlProfileSchema");
    private final static QName _SphericalCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "SphericalCS");
    private final static QName _UsesSingleOperation_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesSingleOperation");
    private final static QName _Triangle_QNAME = new QName("http://www.opengis.net/gml/3.2", "Triangle");
    private final static QName _TopoSolid_QNAME = new QName("http://www.opengis.net/gml/3.2", "TopoSolid");
    private final static QName _AbstractAssociationRole_QNAME = new QName("http://www.opengis.net/gml/3.2", "abstractAssociationRole");
    private final static QName _CartesianCSProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "cartesianCSProperty");
    private final static QName _GeocentricCRSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "geocentricCRSRef");
    private final static QName _MultiLocation_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiLocation");
    private final static QName _AbstractFeature_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractFeature");
    private final static QName _Transformation_QNAME = new QName("http://www.opengis.net/gml/3.2", "Transformation");
    private final static QName _TrianglePatches_QNAME = new QName("http://www.opengis.net/gml/3.2", "trianglePatches");
    private final static QName _TimeClock_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeClock");
    private final static QName _FeatureProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "featureProperty");
    private final static QName _LinearCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "LinearCS");
    private final static QName _AbstractTopoPrimitive_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractTopoPrimitive");
    private final static QName _SingleCRSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "singleCRSRef");
    private final static QName _IndirectEntry_QNAME = new QName("http://www.opengis.net/gml/3.2", "indirectEntry");
    private final static QName _VerticalCSProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "verticalCSProperty");
    private final static QName _Bezier_QNAME = new QName("http://www.opengis.net/gml/3.2", "Bezier");
    private final static QName _OperationParameterProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "operationParameterProperty");
    private final static QName _OperationParameterRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "operationParameterRef");
    private final static QName _AbstractGeneralTransformation_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractGeneralTransformation");
    private final static QName _DirectedObservationAtDistance_QNAME = new QName("http://www.opengis.net/gml/3.2", "DirectedObservationAtDistance");
    private final static QName _Patches_QNAME = new QName("http://www.opengis.net/gml/3.2", "patches");
    private final static QName _UsesEllipsoidalCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesEllipsoidalCS");
    private final static QName _EdgeOf_QNAME = new QName("http://www.opengis.net/gml/3.2", "edgeOf");
    private final static QName _GeometryMembers_QNAME = new QName("http://www.opengis.net/gml/3.2", "geometryMembers");
    private final static QName _LinearCSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "linearCSRef");
    private final static QName _DictionaryEntry_QNAME = new QName("http://www.opengis.net/gml/3.2", "dictionaryEntry");
    private final static QName _LocationKeyWord_QNAME = new QName("http://www.opengis.net/gml/3.2", "LocationKeyWord");
    private final static QName _ImageDatumProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "imageDatumProperty");
    private final static QName _ImageCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "ImageCRS");
    private final static QName _UsesCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesCS");
    private final static QName _AbstractSingleOperation_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractSingleOperation");
    private final static QName _LinearCSProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "linearCSProperty");
    private final static QName _VerticalCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "VerticalCRS");
    private final static QName _TimeInstant_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeInstant");
    private final static QName _Grid_QNAME = new QName("http://www.opengis.net/gml/3.2", "Grid");
    private final static QName _AbstractGeometry_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractGeometry");
    private final static QName _AbstractTimeGeometricPrimitive_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractTimeGeometricPrimitive");
    private final static QName _Cylinder_QNAME = new QName("http://www.opengis.net/gml/3.2", "Cylinder");
    private final static QName _Segments_QNAME = new QName("http://www.opengis.net/gml/3.2", "segments");
    private final static QName _SingleOperationRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "singleOperationRef");
    private final static QName _Subject_QNAME = new QName("http://www.opengis.net/gml/3.2", "subject");
    private final static QName _Method_QNAME = new QName("http://www.opengis.net/gml/3.2", "method");
    private final static QName _IntegerValueList_QNAME = new QName("http://www.opengis.net/gml/3.2", "integerValueList");
    private final static QName _AnchorPoint_QNAME = new QName("http://www.opengis.net/gml/3.2", "anchorPoint");
    private final static QName _GeodesicString_QNAME = new QName("http://www.opengis.net/gml/3.2", "GeodesicString");
    private final static QName _UsesMethod_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesMethod");
    private final static QName _Definition_QNAME = new QName("http://www.opengis.net/gml/3.2", "Definition");
    private final static QName _PrimeMeridianProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "primeMeridianProperty");
    private final static QName _FeatureMember_QNAME = new QName("http://www.opengis.net/gml/3.2", "featureMember");
    private final static QName _GeodeticDatumProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "geodeticDatumProperty");
    private final static QName _ValueComponents_QNAME = new QName("http://www.opengis.net/gml/3.2", "valueComponents");
    private final static QName _QuantityType_QNAME = new QName("http://www.opengis.net/gml/3.2", "quantityType");
    private final static QName _LocationString_QNAME = new QName("http://www.opengis.net/gml/3.2", "LocationString");
    private final static QName _UsesAxis_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesAxis");
    private final static QName _AbstractGeometricAggregate_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractGeometricAggregate");
    private final static QName _SphericalCSProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "sphericalCSProperty");
    private final static QName _BaseCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "baseCRS");
    private final static QName _SolidMembers_QNAME = new QName("http://www.opengis.net/gml/3.2", "solidMembers");
    private final static QName _Circle_QNAME = new QName("http://www.opengis.net/gml/3.2", "Circle");
    private final static QName _CurveProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "curveProperty");
    private final static QName _PrimeMeridian_QNAME = new QName("http://www.opengis.net/gml/3.2", "PrimeMeridian");
    private final static QName _VerticalDatumProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "verticalDatumProperty");
    private final static QName _ConventionalUnit_QNAME = new QName("http://www.opengis.net/gml/3.2", "ConventionalUnit");
    private final static QName _SurfaceMembers_QNAME = new QName("http://www.opengis.net/gml/3.2", "surfaceMembers");
    private final static QName _VerticalCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "VerticalCS");
    private final static QName _Description_QNAME = new QName("http://www.opengis.net/gml/3.2", "description");
    private final static QName _GeometricComplex_QNAME = new QName("http://www.opengis.net/gml/3.2", "GeometricComplex");
    private final static QName _UsesVerticalCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "usesVerticalCS");
    private final static QName _OperationRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "operationRef");
    private final static QName _TriangulatedSurface_QNAME = new QName("http://www.opengis.net/gml/3.2", "TriangulatedSurface");
    private final static QName _StringValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "stringValue");
    private final static QName _AbstractGeneralOperationParameter_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractGeneralOperationParameter");
    private final static QName _AbstractDatum_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractDatum");
    private final static QName _QuantityExtent_QNAME = new QName("http://www.opengis.net/gml/3.2", "QuantityExtent");
    private final static QName _LineStringSegment_QNAME = new QName("http://www.opengis.net/gml/3.2", "LineStringSegment");
    private final static QName _AbstractCoordinateSystem_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractCoordinateSystem");
    private final static QName _CompositeSurface_QNAME = new QName("http://www.opengis.net/gml/3.2", "CompositeSurface");
    private final static QName _PassThroughOperationRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "passThroughOperationRef");
    private final static QName _SolidProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "solidProperty");
    private final static QName _CoordinateSystemAxisRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "coordinateSystemAxisRef");
    private final static QName _GridCoverage_QNAME = new QName("http://www.opengis.net/gml/3.2", "GridCoverage");
    private final static QName _ValidTime_QNAME = new QName("http://www.opengis.net/gml/3.2", "validTime");
    private final static QName _UnitDefinition_QNAME = new QName("http://www.opengis.net/gml/3.2", "UnitDefinition");
    private final static QName _SuperComplex_QNAME = new QName("http://www.opengis.net/gml/3.2", "superComplex");
    private final static QName _CoverageFunction_QNAME = new QName("http://www.opengis.net/gml/3.2", "coverageFunction");
    private final static QName _MultiSolidCoverage_QNAME = new QName("http://www.opengis.net/gml/3.2", "MultiSolidCoverage");
    private final static QName _ConversionProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "conversionProperty");
    private final static QName _RangeSet_QNAME = new QName("http://www.opengis.net/gml/3.2", "rangeSet");
    private final static QName _Members_QNAME = new QName("http://www.opengis.net/gml/3.2", "members");
    private final static QName _PolyhedralSurface_QNAME = new QName("http://www.opengis.net/gml/3.2", "PolyhedralSurface");
    private final static QName _Name_QNAME = new QName("http://www.opengis.net/gml/3.2", "name");
    private final static QName _RectifiedGridDomain_QNAME = new QName("http://www.opengis.net/gml/3.2", "rectifiedGridDomain");
    private final static QName _TemporalCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "TemporalCRS");
    private final static QName _Remarks_QNAME = new QName("http://www.opengis.net/gml/3.2", "remarks");
    private final static QName _CategoryExtent_QNAME = new QName("http://www.opengis.net/gml/3.2", "CategoryExtent");
    private final static QName _RangeParameters_QNAME = new QName("http://www.opengis.net/gml/3.2", "rangeParameters");
    private final static QName _Measure_QNAME = new QName("http://www.opengis.net/gml/3.2", "measure");
    private final static QName _RealizationEpoch_QNAME = new QName("http://www.opengis.net/gml/3.2", "realizationEpoch");
    private final static QName _ConcatenatedOperationRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "concatenatedOperationRef");
    private final static QName _QuantityList_QNAME = new QName("http://www.opengis.net/gml/3.2", "QuantityList");
    private final static QName _CountList_QNAME = new QName("http://www.opengis.net/gml/3.2", "CountList");
    private final static QName _TemporalDatumRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "temporalDatumRef");
    private final static QName _ParameterValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "ParameterValue");
    private final static QName _PolygonPatch_QNAME = new QName("http://www.opengis.net/gml/3.2", "PolygonPatch");
    private final static QName _AbstractCoordinateOperation_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractCoordinateOperation");
    private final static QName _Boolean_QNAME = new QName("http://www.opengis.net/gml/3.2", "Boolean");
    private final static QName _AbstractSolid_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractSolid");
    private final static QName _AffinePlacement_QNAME = new QName("http://www.opengis.net/gml/3.2", "AffinePlacement");
    private final static QName _Axis_QNAME = new QName("http://www.opengis.net/gml/3.2", "axis");
    private final static QName _SurfaceProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "surfaceProperty");
    private final static QName _AbstractCurveSegment_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractCurveSegment");
    private final static QName _AbstractImplicitGeometry_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractImplicitGeometry");
    private final static QName _Surface_QNAME = new QName("http://www.opengis.net/gml/3.2", "Surface");
    private final static QName _MaximumOccurs_QNAME = new QName("http://www.opengis.net/gml/3.2", "maximumOccurs");
    private final static QName _AbstractStrictAssociationRole_QNAME = new QName("http://www.opengis.net/gml/3.2", "abstractStrictAssociationRole");
    private final static QName _Shell_QNAME = new QName("http://www.opengis.net/gml/3.2", "Shell");
    private final static QName _AbstractTimeComplex_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractTimeComplex");
    private final static QName _Point_QNAME = new QName("http://www.opengis.net/gml/3.2", "Point");
    private final static QName _AbstractCoverage_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractCoverage");
    private final static QName _GeodeticCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "GeodeticCRS");
    private final static QName _Using_QNAME = new QName("http://www.opengis.net/gml/3.2", "using");
    private final static QName _OperationParameter_QNAME = new QName("http://www.opengis.net/gml/3.2", "OperationParameter");
    private final static QName _Arc_QNAME = new QName("http://www.opengis.net/gml/3.2", "Arc");
    private final static QName _DynamicMembers_QNAME = new QName("http://www.opengis.net/gml/3.2", "dynamicMembers");
    private final static QName _PassThroughOperation_QNAME = new QName("http://www.opengis.net/gml/3.2", "PassThroughOperation");
    private final static QName _EllipsoidRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "ellipsoidRef");
    private final static QName _VerticalDatum_QNAME = new QName("http://www.opengis.net/gml/3.2", "VerticalDatum");
    private final static QName _TimeCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "TimeCS");
    private final static QName _DatumRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "datumRef");
    private final static QName _PointProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "pointProperty");
    private final static QName _ValueFile_QNAME = new QName("http://www.opengis.net/gml/3.2", "valueFile");
    private final static QName _PolarCSRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "polarCSRef");
    private final static QName _AbstractGeneralParameterValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "AbstractGeneralParameterValue");
    private final static QName _Node_QNAME = new QName("http://www.opengis.net/gml/3.2", "Node");
    private final static QName _GeographicCRS_QNAME = new QName("http://www.opengis.net/gml/3.2", "GeographicCRS");
    private final static QName _ConversionRef_QNAME = new QName("http://www.opengis.net/gml/3.2", "conversionRef");
    private final static QName _AbstractInlineProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "abstractInlineProperty");
    private final static QName _Edge_QNAME = new QName("http://www.opengis.net/gml/3.2", "Edge");
    private final static QName _ValueComponent_QNAME = new QName("http://www.opengis.net/gml/3.2", "valueComponent");
    private final static QName _GeneralOperationParameter_QNAME = new QName("http://www.opengis.net/gml/3.2", "generalOperationParameter");
    private final static QName _RoughConversionToPreferredUnit_QNAME = new QName("http://www.opengis.net/gml/3.2", "roughConversionToPreferredUnit");
    private final static QName _CatalogSymbol_QNAME = new QName("http://www.opengis.net/gml/3.2", "catalogSymbol");
    private final static QName _DerivedUnit_QNAME = new QName("http://www.opengis.net/gml/3.2", "DerivedUnit");
    private final static QName _DmsAngleValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "dmsAngleValue");
    private final static QName _ExtentOf_QNAME = new QName("http://www.opengis.net/gml/3.2", "extentOf");
    private final static QName _CountExtent_QNAME = new QName("http://www.opengis.net/gml/3.2", "CountExtent");
    private final static QName _DirectedEdge_QNAME = new QName("http://www.opengis.net/gml/3.2", "directedEdge");
    private final static QName _CoordinateSystemAxis_QNAME = new QName("http://www.opengis.net/gml/3.2", "CoordinateSystemAxis");
    private final static QName _DerivedCRSType_QNAME = new QName("http://www.opengis.net/gml/3.2", "derivedCRSType");
    private final static QName _ParameterValueProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "parameterValueProperty");
    private final static QName _Ring_QNAME = new QName("http://www.opengis.net/gml/3.2", "Ring");
    private final static QName _TopoVolumeProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "topoVolumeProperty");
    private final static QName _Rectangle_QNAME = new QName("http://www.opengis.net/gml/3.2", "Rectangle");
    private final static QName _DerivationUnitTerm_QNAME = new QName("http://www.opengis.net/gml/3.2", "derivationUnitTerm");
    private final static QName _CylindricalCSProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "cylindricalCSProperty");
    private final static QName _EngineeringDatumProperty_QNAME = new QName("http://www.opengis.net/gml/3.2", "engineeringDatumProperty");
    private final static QName _ObliqueCartesianCS_QNAME = new QName("http://www.opengis.net/gml/3.2", "ObliqueCartesianCS");
    private final static QName _History_QNAME = new QName("http://www.opengis.net/gml/3.2", "history");
    private final static QName _Polygon_QNAME = new QName("http://www.opengis.net/gml/3.2", "Polygon");
    private final static QName _MultiCoverage_QNAME = new QName("http://www.opengis.net/gml/3.2", "multiCoverage");
    private final static QName _SolidMember_QNAME = new QName("http://www.opengis.net/gml/3.2", "solidMember");
    private final static QName _Geodesic_QNAME = new QName("http://www.opengis.net/gml/3.2", "Geodesic");
    private final static QName _Member_QNAME = new QName("http://www.opengis.net/gml/3.2", "member");
    private final static QName _MaximumValue_QNAME = new QName("http://www.opengis.net/gml/3.2", "maximumValue");
    private final static QName _AnchorDefinition_QNAME = new QName("http://www.opengis.net/gml/3.2", "anchorDefinition");
    private final static QName _OrientableSurface_QNAME = new QName("http://www.opengis.net/gml/3.2", "OrientableSurface");
    private final static QName _BooleanList_QNAME = new QName("http://www.opengis.net/gml/3.2", "BooleanList");
    private final static QName _CoordOperation_QNAME = new QName("http://www.opengis.net/gml/3.2", "coordOperation");
    private final static QName _GridTypeLimits_QNAME = new QName("http://www.opengis.net/gml/3.2", "limits");
    private final static QName _GridTypeAxisLabels_QNAME = new QName("http://www.opengis.net/gml/3.2", "axisLabels");
    private final static QName _GridTypeAxisName_QNAME = new QName("http://www.opengis.net/gml/3.2", "axisName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.gml._3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LocationPropertyType }
     * 
     */
    public LocationPropertyType createLocationPropertyType() {
        return new LocationPropertyType();
    }

    /**
     * Create an instance of {@link DynamicFeatureCollectionType }
     * 
     */
    public DynamicFeatureCollectionType createDynamicFeatureCollectionType() {
        return new DynamicFeatureCollectionType();
    }

    /**
     * Create an instance of {@link SolidType }
     * 
     */
    public SolidType createSolidType() {
        return new SolidType();
    }

    /**
     * Create an instance of {@link CompositeSolidType }
     * 
     */
    public CompositeSolidType createCompositeSolidType() {
        return new CompositeSolidType();
    }

    /**
     * Create an instance of {@link ArcStringType }
     * 
     */
    public ArcStringType createArcStringType() {
        return new ArcStringType();
    }

    /**
     * Create an instance of {@link ObliqueCartesianCSType }
     * 
     */
    public ObliqueCartesianCSType createObliqueCartesianCSType() {
        return new ObliqueCartesianCSType();
    }

    /**
     * Create an instance of {@link PriorityLocationPropertyType }
     * 
     */
    public PriorityLocationPropertyType createPriorityLocationPropertyType() {
        return new PriorityLocationPropertyType();
    }

    /**
     * Create an instance of {@link PointType }
     * 
     */
    public PointType createPointType() {
        return new PointType();
    }

    /**
     * Create an instance of {@link SphericalCSPropertyType }
     * 
     */
    public SphericalCSPropertyType createSphericalCSPropertyType() {
        return new SphericalCSPropertyType();
    }

    /**
     * Create an instance of {@link CompositeCurveType }
     * 
     */
    public CompositeCurveType createCompositeCurveType() {
        return new CompositeCurveType();
    }

    /**
     * Create an instance of {@link DirectedTopoSolidPropertyType }
     * 
     */
    public DirectedTopoSolidPropertyType createDirectedTopoSolidPropertyType() {
        return new DirectedTopoSolidPropertyType();
    }

    /**
     * Create an instance of {@link DirectedObservationType }
     * 
     */
    public DirectedObservationType createDirectedObservationType() {
        return new DirectedObservationType();
    }

    /**
     * Create an instance of {@link SolidPropertyType }
     * 
     */
    public SolidPropertyType createSolidPropertyType() {
        return new SolidPropertyType();
    }

    /**
     * Create an instance of {@link ProjectedCRSPropertyType }
     * 
     */
    public ProjectedCRSPropertyType createProjectedCRSPropertyType() {
        return new ProjectedCRSPropertyType();
    }

    /**
     * Create an instance of {@link CircleType }
     * 
     */
    public CircleType createCircleType() {
        return new CircleType();
    }

    /**
     * Create an instance of {@link SpeedType }
     * 
     */
    public SpeedType createSpeedType() {
        return new SpeedType();
    }

    /**
     * Create an instance of {@link TopoCurveType }
     * 
     */
    public TopoCurveType createTopoCurveType() {
        return new TopoCurveType();
    }

    /**
     * Create an instance of {@link TimeInstantType }
     * 
     */
    public TimeInstantType createTimeInstantType() {
        return new TimeInstantType();
    }

    /**
     * Create an instance of {@link EngineeringDatumType }
     * 
     */
    public EngineeringDatumType createEngineeringDatumType() {
        return new EngineeringDatumType();
    }

    /**
     * Create an instance of {@link RectangleType }
     * 
     */
    public RectangleType createRectangleType() {
        return new RectangleType();
    }

    /**
     * Create an instance of {@link ImageCRSPropertyType }
     * 
     */
    public ImageCRSPropertyType createImageCRSPropertyType() {
        return new ImageCRSPropertyType();
    }

    /**
     * Create an instance of {@link UserDefinedCSPropertyType }
     * 
     */
    public UserDefinedCSPropertyType createUserDefinedCSPropertyType() {
        return new UserDefinedCSPropertyType();
    }

    /**
     * Create an instance of {@link TopoComplexType }
     * 
     */
    public TopoComplexType createTopoComplexType() {
        return new TopoComplexType();
    }

    /**
     * Create an instance of {@link PassThroughOperationPropertyType }
     * 
     */
    public PassThroughOperationPropertyType createPassThroughOperationPropertyType() {
        return new PassThroughOperationPropertyType();
    }

    /**
     * Create an instance of {@link MovingObjectStatusType }
     * 
     */
    public MovingObjectStatusType createMovingObjectStatusType() {
        return new MovingObjectStatusType();
    }

    /**
     * Create an instance of {@link BaseUnitType }
     * 
     */
    public BaseUnitType createBaseUnitType() {
        return new BaseUnitType();
    }

    /**
     * Create an instance of {@link MeasureOrNilReasonListType }
     * 
     */
    public MeasureOrNilReasonListType createMeasureOrNilReasonListType() {
        return new MeasureOrNilReasonListType();
    }

    /**
     * Create an instance of {@link SurfacePropertyType }
     * 
     */
    public SurfacePropertyType createSurfacePropertyType() {
        return new SurfacePropertyType();
    }

    /**
     * Create an instance of {@link TopoSurfaceType }
     * 
     */
    public TopoSurfaceType createTopoSurfaceType() {
        return new TopoSurfaceType();
    }

    /**
     * Create an instance of {@link GridLengthType }
     * 
     */
    public GridLengthType createGridLengthType() {
        return new GridLengthType();
    }

    /**
     * Create an instance of {@link SequenceRuleType }
     * 
     */
    public SequenceRuleType createSequenceRuleType() {
        return new SequenceRuleType();
    }

    /**
     * Create an instance of {@link ConversionType }
     * 
     */
    public ConversionType createConversionType() {
        return new ConversionType();
    }

    /**
     * Create an instance of {@link ObliqueCartesianCSPropertyType }
     * 
     */
    public ObliqueCartesianCSPropertyType createObliqueCartesianCSPropertyType() {
        return new ObliqueCartesianCSPropertyType();
    }

    /**
     * Create an instance of {@link QuantityExtentType }
     * 
     */
    public QuantityExtentType createQuantityExtentType() {
        return new QuantityExtentType();
    }

    /**
     * Create an instance of {@link ConversionPropertyType }
     * 
     */
    public ConversionPropertyType createConversionPropertyType() {
        return new ConversionPropertyType();
    }

    /**
     * Create an instance of {@link ParameterValueType }
     * 
     */
    public ParameterValueType createParameterValueType() {
        return new ParameterValueType();
    }

    /**
     * Create an instance of {@link SecondDefiningParameter }
     * 
     */
    public SecondDefiningParameter createSecondDefiningParameter() {
        return new SecondDefiningParameter();
    }

    /**
     * Create an instance of {@link CoordinatesType }
     * 
     */
    public CoordinatesType createCoordinatesType() {
        return new CoordinatesType();
    }

    /**
     * Create an instance of {@link FeatureCollectionType }
     * 
     */
    public FeatureCollectionType createFeatureCollectionType() {
        return new FeatureCollectionType();
    }

    /**
     * Create an instance of {@link GeodeticCRSPropertyType }
     * 
     */
    public GeodeticCRSPropertyType createGeodeticCRSPropertyType() {
        return new GeodeticCRSPropertyType();
    }

    /**
     * Create an instance of {@link EnvelopeWithTimePeriodType }
     * 
     */
    public EnvelopeWithTimePeriodType createEnvelopeWithTimePeriodType() {
        return new EnvelopeWithTimePeriodType();
    }

    /**
     * Create an instance of {@link GeodeticCRSType }
     * 
     */
    public GeodeticCRSType createGeodeticCRSType() {
        return new GeodeticCRSType();
    }

    /**
     * Create an instance of {@link InlinePropertyType }
     * 
     */
    public InlinePropertyType createInlinePropertyType() {
        return new InlinePropertyType();
    }

    /**
     * Create an instance of {@link GeodesicType }
     * 
     */
    public GeodesicType createGeodesicType() {
        return new GeodesicType();
    }

    /**
     * Create an instance of {@link VolumeType }
     * 
     */
    public VolumeType createVolumeType() {
        return new VolumeType();
    }

    /**
     * Create an instance of {@link ValueArrayType }
     * 
     */
    public ValueArrayType createValueArrayType() {
        return new ValueArrayType();
    }

    /**
     * Create an instance of {@link OffsetCurveType }
     * 
     */
    public OffsetCurveType createOffsetCurveType() {
        return new OffsetCurveType();
    }

    /**
     * Create an instance of {@link ImageCRSType }
     * 
     */
    public ImageCRSType createImageCRSType() {
        return new ImageCRSType();
    }

    /**
     * Create an instance of {@link TopoPrimitiveMemberType }
     * 
     */
    public TopoPrimitiveMemberType createTopoPrimitiveMemberType() {
        return new TopoPrimitiveMemberType();
    }

    /**
     * Create an instance of {@link DomainOfValidity }
     * 
     */
    public DomainOfValidity createDomainOfValidity() {
        return new DomainOfValidity();
    }

    /**
     * Create an instance of {@link LinearCSPropertyType }
     * 
     */
    public LinearCSPropertyType createLinearCSPropertyType() {
        return new LinearCSPropertyType();
    }

    /**
     * Create an instance of {@link CountPropertyType }
     * 
     */
    public CountPropertyType createCountPropertyType() {
        return new CountPropertyType();
    }

    /**
     * Create an instance of {@link LinearCSType }
     * 
     */
    public LinearCSType createLinearCSType() {
        return new LinearCSType();
    }

    /**
     * Create an instance of {@link LengthType }
     * 
     */
    public LengthType createLengthType() {
        return new LengthType();
    }

    /**
     * Create an instance of {@link QuantityPropertyType }
     * 
     */
    public QuantityPropertyType createQuantityPropertyType() {
        return new QuantityPropertyType();
    }

    /**
     * Create an instance of {@link DerivedUnitType }
     * 
     */
    public DerivedUnitType createDerivedUnitType() {
        return new DerivedUnitType();
    }

    /**
     * Create an instance of {@link TimeNodeType }
     * 
     */
    public TimeNodeType createTimeNodeType() {
        return new TimeNodeType();
    }

    /**
     * Create an instance of {@link TopoVolumeType }
     * 
     */
    public TopoVolumeType createTopoVolumeType() {
        return new TopoVolumeType();
    }

    /**
     * Create an instance of {@link PolygonPatchType }
     * 
     */
    public PolygonPatchType createPolygonPatchType() {
        return new PolygonPatchType();
    }

    /**
     * Create an instance of {@link ShellType }
     * 
     */
    public ShellType createShellType() {
        return new ShellType();
    }

    /**
     * Create an instance of {@link GeneralConversionPropertyType }
     * 
     */
    public GeneralConversionPropertyType createGeneralConversionPropertyType() {
        return new GeneralConversionPropertyType();
    }

    /**
     * Create an instance of {@link TimeTopologyComplexPropertyType }
     * 
     */
    public TimeTopologyComplexPropertyType createTimeTopologyComplexPropertyType() {
        return new TimeTopologyComplexPropertyType();
    }

    /**
     * Create an instance of {@link VerticalCSPropertyType }
     * 
     */
    public VerticalCSPropertyType createVerticalCSPropertyType() {
        return new VerticalCSPropertyType();
    }

    /**
     * Create an instance of {@link VerticalCRSPropertyType }
     * 
     */
    public VerticalCRSPropertyType createVerticalCRSPropertyType() {
        return new VerticalCRSPropertyType();
    }

    /**
     * Create an instance of {@link RelatedTimeType }
     * 
     */
    public RelatedTimeType createRelatedTimeType() {
        return new RelatedTimeType();
    }

    /**
     * Create an instance of {@link MultiCurvePropertyType }
     * 
     */
    public MultiCurvePropertyType createMultiCurvePropertyType() {
        return new MultiCurvePropertyType();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link ImageDatumType }
     * 
     */
    public ImageDatumType createImageDatumType() {
        return new ImageDatumType();
    }

    /**
     * Create an instance of {@link CircleByCenterPointType }
     * 
     */
    public CircleByCenterPointType createCircleByCenterPointType() {
        return new CircleByCenterPointType();
    }

    /**
     * Create an instance of {@link TimeTopologyPrimitivePropertyType }
     * 
     */
    public TimeTopologyPrimitivePropertyType createTimeTopologyPrimitivePropertyType() {
        return new TimeTopologyPrimitivePropertyType();
    }

    /**
     * Create an instance of {@link DefinitionProxyType }
     * 
     */
    public DefinitionProxyType createDefinitionProxyType() {
        return new DefinitionProxyType();
    }

    /**
     * Create an instance of {@link TopoCurvePropertyType }
     * 
     */
    public TopoCurvePropertyType createTopoCurvePropertyType() {
        return new TopoCurvePropertyType();
    }

    /**
     * Create an instance of {@link GridFunctionType }
     * 
     */
    public GridFunctionType createGridFunctionType() {
        return new GridFunctionType();
    }

    /**
     * Create an instance of {@link TemporalDatumType }
     * 
     */
    public TemporalDatumType createTemporalDatumType() {
        return new TemporalDatumType();
    }

    /**
     * Create an instance of {@link TimePrimitivePropertyType }
     * 
     */
    public TimePrimitivePropertyType createTimePrimitivePropertyType() {
        return new TimePrimitivePropertyType();
    }

    /**
     * Create an instance of {@link SingleOperationPropertyType }
     * 
     */
    public SingleOperationPropertyType createSingleOperationPropertyType() {
        return new SingleOperationPropertyType();
    }

    /**
     * Create an instance of {@link BooleanPropertyType }
     * 
     */
    public BooleanPropertyType createBooleanPropertyType() {
        return new BooleanPropertyType();
    }

    /**
     * Create an instance of {@link TopoSurfacePropertyType }
     * 
     */
    public TopoSurfacePropertyType createTopoSurfacePropertyType() {
        return new TopoSurfacePropertyType();
    }

    /**
     * Create an instance of {@link FileType }
     * 
     */
    public FileType createFileType() {
        return new FileType();
    }

    /**
     * Create an instance of {@link ConcatenatedOperationPropertyType }
     * 
     */
    public ConcatenatedOperationPropertyType createConcatenatedOperationPropertyType() {
        return new ConcatenatedOperationPropertyType();
    }

    /**
     * Create an instance of {@link DynamicFeatureMemberType }
     * 
     */
    public DynamicFeatureMemberType createDynamicFeatureMemberType() {
        return new DynamicFeatureMemberType();
    }

    /**
     * Create an instance of {@link GeocentricCRSType }
     * 
     */
    public GeocentricCRSType createGeocentricCRSType() {
        return new GeocentricCRSType();
    }

    /**
     * Create an instance of {@link OrientableSurfaceType }
     * 
     */
    public OrientableSurfaceType createOrientableSurfaceType() {
        return new OrientableSurfaceType();
    }

    /**
     * Create an instance of {@link UnitDefinitionType }
     * 
     */
    public UnitDefinitionType createUnitDefinitionType() {
        return new UnitDefinitionType();
    }

    /**
     * Create an instance of {@link DefinitionType }
     * 
     */
    public DefinitionType createDefinitionType() {
        return new DefinitionType();
    }

    /**
     * Create an instance of {@link TransformationType }
     * 
     */
    public TransformationType createTransformationType() {
        return new TransformationType();
    }

    /**
     * Create an instance of {@link DiscreteCoverageType }
     * 
     */
    public DiscreteCoverageType createDiscreteCoverageType() {
        return new DiscreteCoverageType();
    }

    /**
     * Create an instance of {@link KnotPropertyType }
     * 
     */
    public KnotPropertyType createKnotPropertyType() {
        return new KnotPropertyType();
    }

    /**
     * Create an instance of {@link ParameterValueGroupType }
     * 
     */
    public ParameterValueGroupType createParameterValueGroupType() {
        return new ParameterValueGroupType();
    }

    /**
     * Create an instance of {@link FaceOrTopoSolidPropertyType }
     * 
     */
    public FaceOrTopoSolidPropertyType createFaceOrTopoSolidPropertyType() {
        return new FaceOrTopoSolidPropertyType();
    }

    /**
     * Create an instance of {@link PointPropertyType }
     * 
     */
    public PointPropertyType createPointPropertyType() {
        return new PointPropertyType();
    }

    /**
     * Create an instance of {@link CompoundCRSPropertyType }
     * 
     */
    public CompoundCRSPropertyType createCompoundCRSPropertyType() {
        return new CompoundCRSPropertyType();
    }

    /**
     * Create an instance of {@link TriangleType }
     * 
     */
    public TriangleType createTriangleType() {
        return new TriangleType();
    }

    /**
     * Create an instance of {@link ObservationType }
     * 
     */
    public ObservationType createObservationType() {
        return new ObservationType();
    }

    /**
     * Create an instance of {@link PolygonType }
     * 
     */
    public PolygonType createPolygonType() {
        return new PolygonType();
    }

    /**
     * Create an instance of {@link GeodeticDatumPropertyType }
     * 
     */
    public GeodeticDatumPropertyType createGeodeticDatumPropertyType() {
        return new GeodeticDatumPropertyType();
    }

    /**
     * Create an instance of {@link CodeType }
     * 
     */
    public CodeType createCodeType() {
        return new CodeType();
    }

    /**
     * Create an instance of {@link TopoPrimitiveArrayAssociationType }
     * 
     */
    public TopoPrimitiveArrayAssociationType createTopoPrimitiveArrayAssociationType() {
        return new TopoPrimitiveArrayAssociationType();
    }

    /**
     * Create an instance of {@link CurvePropertyType }
     * 
     */
    public CurvePropertyType createCurvePropertyType() {
        return new CurvePropertyType();
    }

    /**
     * Create an instance of {@link TopoSolidType }
     * 
     */
    public TopoSolidType createTopoSolidType() {
        return new TopoSolidType();
    }

    /**
     * Create an instance of {@link KnotType }
     * 
     */
    public KnotType createKnotType() {
        return new KnotType();
    }

    /**
     * Create an instance of {@link EnvelopeType }
     * 
     */
    public EnvelopeType createEnvelopeType() {
        return new EnvelopeType();
    }

    /**
     * Create an instance of {@link ValuePropertyType }
     * 
     */
    public ValuePropertyType createValuePropertyType() {
        return new ValuePropertyType();
    }

    /**
     * Create an instance of {@link OperationParameterGroupType }
     * 
     */
    public OperationParameterGroupType createOperationParameterGroupType() {
        return new OperationParameterGroupType();
    }

    /**
     * Create an instance of {@link GeometricComplexType }
     * 
     */
    public GeometricComplexType createGeometricComplexType() {
        return new GeometricComplexType();
    }

    /**
     * Create an instance of {@link EngineeringDatumPropertyType }
     * 
     */
    public EngineeringDatumPropertyType createEngineeringDatumPropertyType() {
        return new EngineeringDatumPropertyType();
    }

    /**
     * Create an instance of {@link HistoryPropertyType }
     * 
     */
    public HistoryPropertyType createHistoryPropertyType() {
        return new HistoryPropertyType();
    }

    /**
     * Create an instance of {@link Count }
     * 
     */
    public Count createCount() {
        return new Count();
    }

    /**
     * Create an instance of {@link EllipsoidType }
     * 
     */
    public EllipsoidType createEllipsoidType() {
        return new EllipsoidType();
    }

    /**
     * Create an instance of {@link TimePeriodPropertyType }
     * 
     */
    public TimePeriodPropertyType createTimePeriodPropertyType() {
        return new TimePeriodPropertyType();
    }

    /**
     * Create an instance of {@link RectifiedGridType }
     * 
     */
    public RectifiedGridType createRectifiedGridType() {
        return new RectifiedGridType();
    }

    /**
     * Create an instance of {@link MultiGeometryPropertyType }
     * 
     */
    public MultiGeometryPropertyType createMultiGeometryPropertyType() {
        return new MultiGeometryPropertyType();
    }

    /**
     * Create an instance of {@link TimeCSType }
     * 
     */
    public TimeCSType createTimeCSType() {
        return new TimeCSType();
    }

    /**
     * Create an instance of {@link AngleChoiceType }
     * 
     */
    public AngleChoiceType createAngleChoiceType() {
        return new AngleChoiceType();
    }

    /**
     * Create an instance of {@link BagType }
     * 
     */
    public BagType createBagType() {
        return new BagType();
    }

    /**
     * Create an instance of {@link BezierType }
     * 
     */
    public BezierType createBezierType() {
        return new BezierType();
    }

    /**
     * Create an instance of {@link ReferenceType }
     * 
     */
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }

    /**
     * Create an instance of {@link DirectPositionType }
     * 
     */
    public DirectPositionType createDirectPositionType() {
        return new DirectPositionType();
    }

    /**
     * Create an instance of {@link GridType }
     * 
     */
    public GridType createGridType() {
        return new GridType();
    }

    /**
     * Create an instance of {@link DegreesType }
     * 
     */
    public DegreesType createDegreesType() {
        return new DegreesType();
    }

    /**
     * Create an instance of {@link DatumPropertyType }
     * 
     */
    public DatumPropertyType createDatumPropertyType() {
        return new DatumPropertyType();
    }

    /**
     * Create an instance of {@link StringOrRefType }
     * 
     */
    public StringOrRefType createStringOrRefType() {
        return new StringOrRefType();
    }

    /**
     * Create an instance of {@link TemporalDatumPropertyType }
     * 
     */
    public TemporalDatumPropertyType createTemporalDatumPropertyType() {
        return new TemporalDatumPropertyType();
    }

    /**
     * Create an instance of {@link VerticalDatumPropertyType }
     * 
     */
    public VerticalDatumPropertyType createVerticalDatumPropertyType() {
        return new VerticalDatumPropertyType();
    }

    /**
     * Create an instance of {@link TimeOrdinalReferenceSystemType }
     * 
     */
    public TimeOrdinalReferenceSystemType createTimeOrdinalReferenceSystemType() {
        return new TimeOrdinalReferenceSystemType();
    }

    /**
     * Create an instance of {@link BSplineType }
     * 
     */
    public BSplineType createBSplineType() {
        return new BSplineType();
    }

    /**
     * Create an instance of {@link Quantity }
     * 
     */
    public Quantity createQuantity() {
        return new Quantity();
    }

    /**
     * Create an instance of {@link CoordinateSystemPropertyType }
     * 
     */
    public CoordinateSystemPropertyType createCoordinateSystemPropertyType() {
        return new CoordinateSystemPropertyType();
    }

    /**
     * Create an instance of {@link CartesianCSType }
     * 
     */
    public CartesianCSType createCartesianCSType() {
        return new CartesianCSType();
    }

    /**
     * Create an instance of {@link ConcatenatedOperationType }
     * 
     */
    public ConcatenatedOperationType createConcatenatedOperationType() {
        return new ConcatenatedOperationType();
    }

    /**
     * Create an instance of {@link OrientableCurveType }
     * 
     */
    public OrientableCurveType createOrientableCurveType() {
        return new OrientableCurveType();
    }

    /**
     * Create an instance of {@link DataBlockType }
     * 
     */
    public DataBlockType createDataBlockType() {
        return new DataBlockType();
    }

    /**
     * Create an instance of {@link TopoSolidPropertyType }
     * 
     */
    public TopoSolidPropertyType createTopoSolidPropertyType() {
        return new TopoSolidPropertyType();
    }

    /**
     * Create an instance of {@link TimePeriodType }
     * 
     */
    public TimePeriodType createTimePeriodType() {
        return new TimePeriodType();
    }

    /**
     * Create an instance of {@link LinearRingPropertyType }
     * 
     */
    public LinearRingPropertyType createLinearRingPropertyType() {
        return new LinearRingPropertyType();
    }

    /**
     * Create an instance of {@link SphericalCSType }
     * 
     */
    public SphericalCSType createSphericalCSType() {
        return new SphericalCSType();
    }

    /**
     * Create an instance of {@link MultiGeometryType }
     * 
     */
    public MultiGeometryType createMultiGeometryType() {
        return new MultiGeometryType();
    }

    /**
     * Create an instance of {@link TopoComplexPropertyType }
     * 
     */
    public TopoComplexPropertyType createTopoComplexPropertyType() {
        return new TopoComplexPropertyType();
    }

    /**
     * Create an instance of {@link CompositeValueType }
     * 
     */
    public CompositeValueType createCompositeValueType() {
        return new CompositeValueType();
    }

    /**
     * Create an instance of {@link DefinitionBaseType }
     * 
     */
    public DefinitionBaseType createDefinitionBaseType() {
        return new DefinitionBaseType();
    }

    /**
     * Create an instance of {@link ProjectedCRSType }
     * 
     */
    public ProjectedCRSType createProjectedCRSType() {
        return new ProjectedCRSType();
    }

    /**
     * Create an instance of {@link FormulaCitation }
     * 
     */
    public FormulaCitation createFormulaCitation() {
        return new FormulaCitation();
    }

    /**
     * Create an instance of {@link CurveType }
     * 
     */
    public CurveType createCurveType() {
        return new CurveType();
    }

    /**
     * Create an instance of {@link OperationParameterPropertyType }
     * 
     */
    public OperationParameterPropertyType createOperationParameterPropertyType() {
        return new OperationParameterPropertyType();
    }

    /**
     * Create an instance of {@link TimePositionType }
     * 
     */
    public TimePositionType createTimePositionType() {
        return new TimePositionType();
    }

    /**
     * Create an instance of {@link CartesianCSPropertyType }
     * 
     */
    public CartesianCSPropertyType createCartesianCSPropertyType() {
        return new CartesianCSPropertyType();
    }

    /**
     * Create an instance of {@link DirectedFacePropertyType }
     * 
     */
    public DirectedFacePropertyType createDirectedFacePropertyType() {
        return new DirectedFacePropertyType();
    }

    /**
     * Create an instance of {@link TopoVolumePropertyType }
     * 
     */
    public TopoVolumePropertyType createTopoVolumePropertyType() {
        return new TopoVolumePropertyType();
    }

    /**
     * Create an instance of {@link TimeClockPropertyType }
     * 
     */
    public TimeClockPropertyType createTimeClockPropertyType() {
        return new TimeClockPropertyType();
    }

    /**
     * Create an instance of {@link TimeCalendarType }
     * 
     */
    public TimeCalendarType createTimeCalendarType() {
        return new TimeCalendarType();
    }

    /**
     * Create an instance of {@link DirectionPropertyType }
     * 
     */
    public DirectionPropertyType createDirectionPropertyType() {
        return new DirectionPropertyType();
    }

    /**
     * Create an instance of {@link IndirectEntryType }
     * 
     */
    public IndirectEntryType createIndirectEntryType() {
        return new IndirectEntryType();
    }

    /**
     * Create an instance of {@link GeometricPrimitivePropertyType }
     * 
     */
    public GeometricPrimitivePropertyType createGeometricPrimitivePropertyType() {
        return new GeometricPrimitivePropertyType();
    }

    /**
     * Create an instance of {@link SurfacePatchArrayPropertyType }
     * 
     */
    public SurfacePatchArrayPropertyType createSurfacePatchArrayPropertyType() {
        return new SurfacePatchArrayPropertyType();
    }

    /**
     * Create an instance of {@link AbstractSolidType }
     * 
     */
    public AbstractSolidType createAbstractSolidType() {
        return new AbstractSolidType();
    }

    /**
     * Create an instance of {@link ProcedurePropertyType }
     * 
     */
    public ProcedurePropertyType createProcedurePropertyType() {
        return new ProcedurePropertyType();
    }

    /**
     * Create an instance of {@link TemporalCSType }
     * 
     */
    public TemporalCSType createTemporalCSType() {
        return new TemporalCSType();
    }

    /**
     * Create an instance of {@link ConversionToPreferredUnitType }
     * 
     */
    public ConversionToPreferredUnitType createConversionToPreferredUnitType() {
        return new ConversionToPreferredUnitType();
    }

    /**
     * Create an instance of {@link TimeReferenceSystemType }
     * 
     */
    public TimeReferenceSystemType createTimeReferenceSystemType() {
        return new TimeReferenceSystemType();
    }

    /**
     * Create an instance of {@link PolarCSType }
     * 
     */
    public PolarCSType createPolarCSType() {
        return new PolarCSType();
    }

    /**
     * Create an instance of {@link ClothoidType.RefLocation }
     * 
     */
    public ClothoidType.RefLocation createClothoidTypeRefLocation() {
        return new ClothoidType.RefLocation();
    }

    /**
     * Create an instance of {@link CRSPropertyType }
     * 
     */
    public CRSPropertyType createCRSPropertyType() {
        return new CRSPropertyType();
    }

    /**
     * Create an instance of {@link MultiPointType }
     * 
     */
    public MultiPointType createMultiPointType() {
        return new MultiPointType();
    }

    /**
     * Create an instance of {@link TimeType }
     * 
     */
    public TimeType createTimeType() {
        return new TimeType();
    }

    /**
     * Create an instance of {@link TimeCSPropertyType }
     * 
     */
    public TimeCSPropertyType createTimeCSPropertyType() {
        return new TimeCSPropertyType();
    }

    /**
     * Create an instance of {@link DerivedCRSPropertyType }
     * 
     */
    public DerivedCRSPropertyType createDerivedCRSPropertyType() {
        return new DerivedCRSPropertyType();
    }

    /**
     * Create an instance of {@link TemporalCRSPropertyType }
     * 
     */
    public TemporalCRSPropertyType createTemporalCRSPropertyType() {
        return new TemporalCRSPropertyType();
    }

    /**
     * Create an instance of {@link FeaturePropertyType }
     * 
     */
    public FeaturePropertyType createFeaturePropertyType() {
        return new FeaturePropertyType();
    }

    /**
     * Create an instance of {@link VectorType }
     * 
     */
    public VectorType createVectorType() {
        return new VectorType();
    }

    /**
     * Create an instance of {@link EllipsoidalCSType }
     * 
     */
    public EllipsoidalCSType createEllipsoidalCSType() {
        return new EllipsoidalCSType();
    }

    /**
     * Create an instance of {@link TopoPointType }
     * 
     */
    public TopoPointType createTopoPointType() {
        return new TopoPointType();
    }

    /**
     * Create an instance of {@link DictionaryEntryType }
     * 
     */
    public DictionaryEntryType createDictionaryEntryType() {
        return new DictionaryEntryType();
    }

    /**
     * Create an instance of {@link TimeOrdinalEraPropertyType }
     * 
     */
    public TimeOrdinalEraPropertyType createTimeOrdinalEraPropertyType() {
        return new TimeOrdinalEraPropertyType();
    }

    /**
     * Create an instance of {@link OperationMethodPropertyType }
     * 
     */
    public OperationMethodPropertyType createOperationMethodPropertyType() {
        return new OperationMethodPropertyType();
    }

    /**
     * Create an instance of {@link PolarCSPropertyType }
     * 
     */
    public PolarCSPropertyType createPolarCSPropertyType() {
        return new PolarCSPropertyType();
    }

    /**
     * Create an instance of {@link AbstractGriddedSurfaceType.Rows2 .Row }
     * 
     */
    public AbstractGriddedSurfaceType.Rows2 .Row createAbstractGriddedSurfaceTypeRows2Row() {
        return new AbstractGriddedSurfaceType.Rows2 .Row();
    }

    /**
     * Create an instance of {@link TargetPropertyType }
     * 
     */
    public TargetPropertyType createTargetPropertyType() {
        return new TargetPropertyType();
    }

    /**
     * Create an instance of {@link CurveArrayPropertyType }
     * 
     */
    public CurveArrayPropertyType createCurveArrayPropertyType() {
        return new CurveArrayPropertyType();
    }

    /**
     * Create an instance of {@link MultiSolidType }
     * 
     */
    public MultiSolidType createMultiSolidType() {
        return new MultiSolidType();
    }

    /**
     * Create an instance of {@link EdgeType }
     * 
     */
    public EdgeType createEdgeType() {
        return new EdgeType();
    }

    /**
     * Create an instance of {@link MultiSolidPropertyType }
     * 
     */
    public MultiSolidPropertyType createMultiSolidPropertyType() {
        return new MultiSolidPropertyType();
    }

    /**
     * Create an instance of {@link TimeEdgeType }
     * 
     */
    public TimeEdgeType createTimeEdgeType() {
        return new TimeEdgeType();
    }

    /**
     * Create an instance of {@link SecondDefiningParameterType }
     * 
     */
    public SecondDefiningParameterType createSecondDefiningParameterType() {
        return new SecondDefiningParameterType();
    }

    /**
     * Create an instance of {@link UserDefinedCSType }
     * 
     */
    public UserDefinedCSType createUserDefinedCSType() {
        return new UserDefinedCSType();
    }

    /**
     * Create an instance of {@link AffineCSType }
     * 
     */
    public AffineCSType createAffineCSType() {
        return new AffineCSType();
    }

    /**
     * Create an instance of {@link GeodesicStringType }
     * 
     */
    public GeodesicStringType createGeodesicStringType() {
        return new GeodesicStringType();
    }

    /**
     * Create an instance of {@link RingType }
     * 
     */
    public RingType createRingType() {
        return new RingType();
    }

    /**
     * Create an instance of {@link OperationPropertyType }
     * 
     */
    public OperationPropertyType createOperationPropertyType() {
        return new OperationPropertyType();
    }

    /**
     * Create an instance of {@link EngineeringCRSPropertyType }
     * 
     */
    public EngineeringCRSPropertyType createEngineeringCRSPropertyType() {
        return new EngineeringCRSPropertyType();
    }

    /**
     * Create an instance of {@link GeometryArrayPropertyType }
     * 
     */
    public GeometryArrayPropertyType createGeometryArrayPropertyType() {
        return new GeometryArrayPropertyType();
    }

    /**
     * Create an instance of {@link EllipsoidPropertyType }
     * 
     */
    public EllipsoidPropertyType createEllipsoidPropertyType() {
        return new EllipsoidPropertyType();
    }

    /**
     * Create an instance of {@link CoordinateOperationAccuracy }
     * 
     */
    public CoordinateOperationAccuracy createCoordinateOperationAccuracy() {
        return new CoordinateOperationAccuracy();
    }

    /**
     * Create an instance of {@link AreaType }
     * 
     */
    public AreaType createAreaType() {
        return new AreaType();
    }

    /**
     * Create an instance of {@link LineStringSegmentArrayPropertyType }
     * 
     */
    public LineStringSegmentArrayPropertyType createLineStringSegmentArrayPropertyType() {
        return new LineStringSegmentArrayPropertyType();
    }

    /**
     * Create an instance of {@link LinearRingType }
     * 
     */
    public LinearRingType createLinearRingType() {
        return new LinearRingType();
    }

    /**
     * Create an instance of {@link EngineeringCRSType }
     * 
     */
    public EngineeringCRSType createEngineeringCRSType() {
        return new EngineeringCRSType();
    }

    /**
     * Create an instance of {@link TemporalCSPropertyType }
     * 
     */
    public TemporalCSPropertyType createTemporalCSPropertyType() {
        return new TemporalCSPropertyType();
    }

    /**
     * Create an instance of {@link ConeType }
     * 
     */
    public ConeType createConeType() {
        return new ConeType();
    }

    /**
     * Create an instance of {@link ScaleType }
     * 
     */
    public ScaleType createScaleType() {
        return new ScaleType();
    }

    /**
     * Create an instance of {@link DictionaryType }
     * 
     */
    public DictionaryType createDictionaryType() {
        return new DictionaryType();
    }

    /**
     * Create an instance of {@link CoordinateSystemAxisPropertyType }
     * 
     */
    public CoordinateSystemAxisPropertyType createCoordinateSystemAxisPropertyType() {
        return new CoordinateSystemAxisPropertyType();
    }

    /**
     * Create an instance of {@link MeasureListType }
     * 
     */
    public MeasureListType createMeasureListType() {
        return new MeasureListType();
    }

    /**
     * Create an instance of {@link RangeSetType }
     * 
     */
    public RangeSetType createRangeSetType() {
        return new RangeSetType();
    }

    /**
     * Create an instance of {@link TimeIntervalLengthType }
     * 
     */
    public TimeIntervalLengthType createTimeIntervalLengthType() {
        return new TimeIntervalLengthType();
    }

    /**
     * Create an instance of {@link CompositeSurfaceType }
     * 
     */
    public CompositeSurfaceType createCompositeSurfaceType() {
        return new CompositeSurfaceType();
    }

    /**
     * Create an instance of {@link UnitOfMeasureType }
     * 
     */
    public UnitOfMeasureType createUnitOfMeasureType() {
        return new UnitOfMeasureType();
    }

    /**
     * Create an instance of {@link AbstractRingPropertyType }
     * 
     */
    public AbstractRingPropertyType createAbstractRingPropertyType() {
        return new AbstractRingPropertyType();
    }

    /**
     * Create an instance of {@link NodePropertyType }
     * 
     */
    public NodePropertyType createNodePropertyType() {
        return new NodePropertyType();
    }

    /**
     * Create an instance of {@link ImageDatumPropertyType }
     * 
     */
    public ImageDatumPropertyType createImageDatumPropertyType() {
        return new ImageDatumPropertyType();
    }

    /**
     * Create an instance of {@link FormulaType }
     * 
     */
    public FormulaType createFormulaType() {
        return new FormulaType();
    }

    /**
     * Create an instance of {@link TimeCalendarEraPropertyType }
     * 
     */
    public TimeCalendarEraPropertyType createTimeCalendarEraPropertyType() {
        return new TimeCalendarEraPropertyType();
    }

    /**
     * Create an instance of {@link DomainSetType }
     * 
     */
    public DomainSetType createDomainSetType() {
        return new DomainSetType();
    }

    /**
     * Create an instance of {@link DerivationUnitTermType }
     * 
     */
    public DerivationUnitTermType createDerivationUnitTermType() {
        return new DerivationUnitTermType();
    }

    /**
     * Create an instance of {@link AbstractGriddedSurfaceType.Rows2 }
     * 
     */
    public AbstractGriddedSurfaceType.Rows2 createAbstractGriddedSurfaceTypeRows2() {
        return new AbstractGriddedSurfaceType.Rows2();
    }

    /**
     * Create an instance of {@link TopoPointPropertyType }
     * 
     */
    public TopoPointPropertyType createTopoPointPropertyType() {
        return new TopoPointPropertyType();
    }

    /**
     * Create an instance of {@link GeodeticDatumType }
     * 
     */
    public GeodeticDatumType createGeodeticDatumType() {
        return new GeodeticDatumType();
    }

    /**
     * Create an instance of {@link CodeListType }
     * 
     */
    public CodeListType createCodeListType() {
        return new CodeListType();
    }

    /**
     * Create an instance of {@link ArrayType }
     * 
     */
    public ArrayType createArrayType() {
        return new ArrayType();
    }

    /**
     * Create an instance of {@link ValueArrayPropertyType }
     * 
     */
    public ValueArrayPropertyType createValueArrayPropertyType() {
        return new ValueArrayPropertyType();
    }

    /**
     * Create an instance of {@link CylinderType }
     * 
     */
    public CylinderType createCylinderType() {
        return new CylinderType();
    }

    /**
     * Create an instance of {@link MeasureType }
     * 
     */
    public MeasureType createMeasureType() {
        return new MeasureType();
    }

    /**
     * Create an instance of {@link SurfaceArrayPropertyType }
     * 
     */
    public SurfaceArrayPropertyType createSurfaceArrayPropertyType() {
        return new SurfaceArrayPropertyType();
    }

    /**
     * Create an instance of {@link MultiCurveType }
     * 
     */
    public MultiCurveType createMultiCurveType() {
        return new MultiCurveType();
    }

    /**
     * Create an instance of {@link FaceType }
     * 
     */
    public FaceType createFaceType() {
        return new FaceType();
    }

    /**
     * Create an instance of {@link SphereType }
     * 
     */
    public SphereType createSphereType() {
        return new SphereType();
    }

    /**
     * Create an instance of {@link PrimeMeridianPropertyType }
     * 
     */
    public PrimeMeridianPropertyType createPrimeMeridianPropertyType() {
        return new PrimeMeridianPropertyType();
    }

    /**
     * Create an instance of {@link ClothoidType }
     * 
     */
    public ClothoidType createClothoidType() {
        return new ClothoidType();
    }

    /**
     * Create an instance of {@link MetaDataPropertyType }
     * 
     */
    public MetaDataPropertyType createMetaDataPropertyType() {
        return new MetaDataPropertyType();
    }

    /**
     * Create an instance of {@link VerticalCSType }
     * 
     */
    public VerticalCSType createVerticalCSType() {
        return new VerticalCSType();
    }

    /**
     * Create an instance of {@link CodeWithAuthorityType }
     * 
     */
    public CodeWithAuthorityType createCodeWithAuthorityType() {
        return new CodeWithAuthorityType();
    }

    /**
     * Create an instance of {@link LineStringSegmentType }
     * 
     */
    public LineStringSegmentType createLineStringSegmentType() {
        return new LineStringSegmentType();
    }

    /**
     * Create an instance of {@link TimeClockType }
     * 
     */
    public TimeClockType createTimeClockType() {
        return new TimeClockType();
    }

    /**
     * Create an instance of {@link ArcType }
     * 
     */
    public ArcType createArcType() {
        return new ArcType();
    }

    /**
     * Create an instance of {@link GenericMetaDataType }
     * 
     */
    public GenericMetaDataType createGenericMetaDataType() {
        return new GenericMetaDataType();
    }

    /**
     * Create an instance of {@link TransformationPropertyType }
     * 
     */
    public TransformationPropertyType createTransformationPropertyType() {
        return new TransformationPropertyType();
    }

    /**
     * Create an instance of {@link TimeCalendarPropertyType }
     * 
     */
    public TimeCalendarPropertyType createTimeCalendarPropertyType() {
        return new TimeCalendarPropertyType();
    }

    /**
     * Create an instance of {@link CategoryPropertyType }
     * 
     */
    public CategoryPropertyType createCategoryPropertyType() {
        return new CategoryPropertyType();
    }

    /**
     * Create an instance of {@link LineStringType }
     * 
     */
    public LineStringType createLineStringType() {
        return new LineStringType();
    }

    /**
     * Create an instance of {@link PrimeMeridianType }
     * 
     */
    public PrimeMeridianType createPrimeMeridianType() {
        return new PrimeMeridianType();
    }

    /**
     * Create an instance of {@link DMSAngleType }
     * 
     */
    public DMSAngleType createDMSAngleType() {
        return new DMSAngleType();
    }

    /**
     * Create an instance of {@link ConventionalUnitType }
     * 
     */
    public ConventionalUnitType createConventionalUnitType() {
        return new ConventionalUnitType();
    }

    /**
     * Create an instance of {@link NodeOrEdgePropertyType }
     * 
     */
    public NodeOrEdgePropertyType createNodeOrEdgePropertyType() {
        return new NodeOrEdgePropertyType();
    }

    /**
     * Create an instance of {@link CubicSplineType }
     * 
     */
    public CubicSplineType createCubicSplineType() {
        return new CubicSplineType();
    }

    /**
     * Create an instance of {@link TimeOrdinalEraType }
     * 
     */
    public TimeOrdinalEraType createTimeOrdinalEraType() {
        return new TimeOrdinalEraType();
    }

    /**
     * Create an instance of {@link CoverageFunctionType }
     * 
     */
    public CoverageFunctionType createCoverageFunctionType() {
        return new CoverageFunctionType();
    }

    /**
     * Create an instance of {@link PassThroughOperationType }
     * 
     */
    public PassThroughOperationType createPassThroughOperationType() {
        return new PassThroughOperationType();
    }

    /**
     * Create an instance of {@link TimeEdgePropertyType }
     * 
     */
    public TimeEdgePropertyType createTimeEdgePropertyType() {
        return new TimeEdgePropertyType();
    }

    /**
     * Create an instance of {@link GeographicCRSType }
     * 
     */
    public GeographicCRSType createGeographicCRSType() {
        return new GeographicCRSType();
    }

    /**
     * Create an instance of {@link AffineCSPropertyType }
     * 
     */
    public AffineCSPropertyType createAffineCSPropertyType() {
        return new AffineCSPropertyType();
    }

    /**
     * Create an instance of {@link AbstractGeneralOperationParameterPropertyType }
     * 
     */
    public AbstractGeneralOperationParameterPropertyType createAbstractGeneralOperationParameterPropertyType() {
        return new AbstractGeneralOperationParameterPropertyType();
    }

    /**
     * Create an instance of {@link DirectedEdgePropertyType }
     * 
     */
    public DirectedEdgePropertyType createDirectedEdgePropertyType() {
        return new DirectedEdgePropertyType();
    }

    /**
     * Create an instance of {@link DirectedNodePropertyType }
     * 
     */
    public DirectedNodePropertyType createDirectedNodePropertyType() {
        return new DirectedNodePropertyType();
    }

    /**
     * Create an instance of {@link TimeInstantPropertyType }
     * 
     */
    public TimeInstantPropertyType createTimeInstantPropertyType() {
        return new TimeInstantPropertyType();
    }

    /**
     * Create an instance of {@link AffinePlacementType }
     * 
     */
    public AffinePlacementType createAffinePlacementType() {
        return new AffinePlacementType();
    }

    /**
     * Create an instance of {@link PointArrayPropertyType }
     * 
     */
    public PointArrayPropertyType createPointArrayPropertyType() {
        return new PointArrayPropertyType();
    }

    /**
     * Create an instance of {@link ArcByBulgeType }
     * 
     */
    public ArcByBulgeType createArcByBulgeType() {
        return new ArcByBulgeType();
    }

    /**
     * Create an instance of {@link DynamicFeatureType }
     * 
     */
    public DynamicFeatureType createDynamicFeatureType() {
        return new DynamicFeatureType();
    }

    /**
     * Create an instance of {@link VerticalCRSType }
     * 
     */
    public VerticalCRSType createVerticalCRSType() {
        return new VerticalCRSType();
    }

    /**
     * Create an instance of {@link AbstractGeneralParameterValuePropertyType }
     * 
     */
    public AbstractGeneralParameterValuePropertyType createAbstractGeneralParameterValuePropertyType() {
        return new AbstractGeneralParameterValuePropertyType();
    }

    /**
     * Create an instance of {@link GridEnvelopeType }
     * 
     */
    public GridEnvelopeType createGridEnvelopeType() {
        return new GridEnvelopeType();
    }

    /**
     * Create an instance of {@link CurveSegmentArrayPropertyType }
     * 
     */
    public CurveSegmentArrayPropertyType createCurveSegmentArrayPropertyType() {
        return new CurveSegmentArrayPropertyType();
    }

    /**
     * Create an instance of {@link TemporalCRSType }
     * 
     */
    public TemporalCRSType createTemporalCRSType() {
        return new TemporalCRSType();
    }

    /**
     * Create an instance of {@link CylindricalCSPropertyType }
     * 
     */
    public CylindricalCSPropertyType createCylindricalCSPropertyType() {
        return new CylindricalCSPropertyType();
    }

    /**
     * Create an instance of {@link GridLimitsType }
     * 
     */
    public GridLimitsType createGridLimitsType() {
        return new GridLimitsType();
    }

    /**
     * Create an instance of {@link GeographicCRSPropertyType }
     * 
     */
    public GeographicCRSPropertyType createGeographicCRSPropertyType() {
        return new GeographicCRSPropertyType();
    }

    /**
     * Create an instance of {@link GeneralTransformationPropertyType }
     * 
     */
    public GeneralTransformationPropertyType createGeneralTransformationPropertyType() {
        return new GeneralTransformationPropertyType();
    }

    /**
     * Create an instance of {@link FeatureArrayPropertyType }
     * 
     */
    public FeatureArrayPropertyType createFeatureArrayPropertyType() {
        return new FeatureArrayPropertyType();
    }

    /**
     * Create an instance of {@link CompoundCRSType }
     * 
     */
    public CompoundCRSType createCompoundCRSType() {
        return new CompoundCRSType();
    }

    /**
     * Create an instance of {@link net.opengis.gml._3.Boolean }
     * 
     */
    public org.geotoolkit.gml.xml.v321.Boolean createBoolean() {
        return new org.geotoolkit.gml.xml.v321.Boolean();
    }

    /**
     * Create an instance of {@link GeometricComplexPropertyType }
     * 
     */
    public GeometricComplexPropertyType createGeometricComplexPropertyType() {
        return new GeometricComplexPropertyType();
    }

    /**
     * Create an instance of {@link TinType }
     * 
     */
    public TinType createTinType() {
        return new TinType();
    }

    /**
     * Create an instance of {@link TimeNodePropertyType }
     * 
     */
    public TimeNodePropertyType createTimeNodePropertyType() {
        return new TimeNodePropertyType();
    }

    /**
     * Create an instance of {@link MultiSurfacePropertyType }
     * 
     */
    public MultiSurfacePropertyType createMultiSurfacePropertyType() {
        return new MultiSurfacePropertyType();
    }

    /**
     * Create an instance of {@link OperationMethodType }
     * 
     */
    public OperationMethodType createOperationMethodType() {
        return new OperationMethodType();
    }

    /**
     * Create an instance of {@link TimeCalendarEraType }
     * 
     */
    public TimeCalendarEraType createTimeCalendarEraType() {
        return new TimeCalendarEraType();
    }

    /**
     * Create an instance of {@link CategoryExtentType }
     * 
     */
    public CategoryExtentType createCategoryExtentType() {
        return new CategoryExtentType();
    }

    /**
     * Create an instance of {@link TinType.ControlPoint }
     * 
     */
    public TinType.ControlPoint createTinTypeControlPoint() {
        return new TinType.ControlPoint();
    }

    /**
     * Create an instance of {@link MultiPointPropertyType }
     * 
     */
    public MultiPointPropertyType createMultiPointPropertyType() {
        return new MultiPointPropertyType();
    }

    /**
     * Create an instance of {@link OperationParameterType }
     * 
     */
    public OperationParameterType createOperationParameterType() {
        return new OperationParameterType();
    }

    /**
     * Create an instance of {@link GeocentricCRSPropertyType }
     * 
     */
    public GeocentricCRSPropertyType createGeocentricCRSPropertyType() {
        return new GeocentricCRSPropertyType();
    }

    /**
     * Create an instance of {@link SurfaceType }
     * 
     */
    public SurfaceType createSurfaceType() {
        return new SurfaceType();
    }

    /**
     * Create an instance of {@link DirectPositionListType }
     * 
     */
    public DirectPositionListType createDirectPositionListType() {
        return new DirectPositionListType();
    }

    /**
     * Create an instance of {@link ArcStringByBulgeType }
     * 
     */
    public ArcStringByBulgeType createArcStringByBulgeType() {
        return new ArcStringByBulgeType();
    }

    /**
     * Create an instance of {@link CoordinateSystemAxisType }
     * 
     */
    public CoordinateSystemAxisType createCoordinateSystemAxisType() {
        return new CoordinateSystemAxisType();
    }

    /**
     * Create an instance of {@link ResultType }
     * 
     */
    public ResultType createResultType() {
        return new ResultType();
    }

    /**
     * Create an instance of {@link NodeType }
     * 
     */
    public NodeType createNodeType() {
        return new NodeType();
    }

    /**
     * Create an instance of {@link ArcByCenterPointType }
     * 
     */
    public ArcByCenterPointType createArcByCenterPointType() {
        return new ArcByCenterPointType();
    }

    /**
     * Create an instance of {@link TimeCoordinateSystemType }
     * 
     */
    public TimeCoordinateSystemType createTimeCoordinateSystemType() {
        return new TimeCoordinateSystemType();
    }

    /**
     * Create an instance of {@link BoundingShapeType }
     * 
     */
    public BoundingShapeType createBoundingShapeType() {
        return new BoundingShapeType();
    }

    /**
     * Create an instance of {@link DerivedCRSType }
     * 
     */
    public DerivedCRSType createDerivedCRSType() {
        return new DerivedCRSType();
    }

    /**
     * Create an instance of {@link ShellPropertyType }
     * 
     */
    public ShellPropertyType createShellPropertyType() {
        return new ShellPropertyType();
    }

    /**
     * Create an instance of {@link OperationParameterGroupPropertyType }
     * 
     */
    public OperationParameterGroupPropertyType createOperationParameterGroupPropertyType() {
        return new OperationParameterGroupPropertyType();
    }

    /**
     * Create an instance of {@link MultiSurfaceType }
     * 
     */
    public MultiSurfaceType createMultiSurfaceType() {
        return new MultiSurfaceType();
    }

    /**
     * Create an instance of {@link CoordinateOperationPropertyType }
     * 
     */
    public CoordinateOperationPropertyType createCoordinateOperationPropertyType() {
        return new CoordinateOperationPropertyType();
    }

    /**
     * Create an instance of {@link SolidArrayPropertyType }
     * 
     */
    public SolidArrayPropertyType createSolidArrayPropertyType() {
        return new SolidArrayPropertyType();
    }

    /**
     * Create an instance of {@link EllipsoidalCSPropertyType }
     * 
     */
    public EllipsoidalCSPropertyType createEllipsoidalCSPropertyType() {
        return new EllipsoidalCSPropertyType();
    }

    /**
     * Create an instance of {@link GeometryPropertyType }
     * 
     */
    public GeometryPropertyType createGeometryPropertyType() {
        return new GeometryPropertyType();
    }

    /**
     * Create an instance of {@link DirectedObservationAtDistanceType }
     * 
     */
    public DirectedObservationAtDistanceType createDirectedObservationAtDistanceType() {
        return new DirectedObservationAtDistanceType();
    }

    /**
     * Create an instance of {@link CodeOrNilReasonListType }
     * 
     */
    public CodeOrNilReasonListType createCodeOrNilReasonListType() {
        return new CodeOrNilReasonListType();
    }

    /**
     * Create an instance of {@link DirectionVectorType }
     * 
     */
    public DirectionVectorType createDirectionVectorType() {
        return new DirectionVectorType();
    }

    /**
     * Create an instance of {@link AssociationRoleType }
     * 
     */
    public AssociationRoleType createAssociationRoleType() {
        return new AssociationRoleType();
    }

    /**
     * Create an instance of {@link DirectionDescriptionType }
     * 
     */
    public DirectionDescriptionType createDirectionDescriptionType() {
        return new DirectionDescriptionType();
    }

    /**
     * Create an instance of {@link MappingRuleType }
     * 
     */
    public MappingRuleType createMappingRuleType() {
        return new MappingRuleType();
    }

    /**
     * Create an instance of {@link CylindricalCSType }
     * 
     */
    public CylindricalCSType createCylindricalCSType() {
        return new CylindricalCSType();
    }

    /**
     * Create an instance of {@link ArrayAssociationType }
     * 
     */
    public ArrayAssociationType createArrayAssociationType() {
        return new ArrayAssociationType();
    }

    /**
     * Create an instance of {@link VerticalDatumType }
     * 
     */
    public VerticalDatumType createVerticalDatumType() {
        return new VerticalDatumType();
    }

    /**
     * Create an instance of {@link RingPropertyType }
     * 
     */
    public RingPropertyType createRingPropertyType() {
        return new RingPropertyType();
    }

    /**
     * Create an instance of {@link AngleType }
     * 
     */
    public AngleType createAngleType() {
        return new AngleType();
    }

    /**
     * Create an instance of {@link SingleCRSPropertyType }
     * 
     */
    public SingleCRSPropertyType createSingleCRSPropertyType() {
        return new SingleCRSPropertyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CircleByCenterPointType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CircleByCenterPoint", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "ArcByCenterPoint")
    public JAXBElement<CircleByCenterPointType> createCircleByCenterPoint(CircleByCenterPointType value) {
        return new JAXBElement<CircleByCenterPointType>(_CircleByCenterPoint_QNAME, CircleByCenterPointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SphereType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Sphere", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGriddedSurface")
    public JAXBElement<SphereType> createSphere(SphereType value) {
        return new JAXBElement<SphereType>(_Sphere_QNAME, SphereType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractParametricCurveSurfaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractParametricCurveSurface", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSurfacePatch")
    public JAXBElement<AbstractParametricCurveSurfaceType> createAbstractParametricCurveSurface(AbstractParametricCurveSurfaceType value) {
        return new JAXBElement<AbstractParametricCurveSurfaceType>(_AbstractParametricCurveSurface_QNAME, AbstractParametricCurveSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "solidArrayProperty")
    public JAXBElement<SolidArrayPropertyType> createSolidArrayProperty(SolidArrayPropertyType value) {
        return new JAXBElement<SolidArrayPropertyType>(_SolidArrayProperty_QNAME, SolidArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractSurfacePatchType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractSurfacePatch")
    public JAXBElement<AbstractSurfacePatchType> createAbstractSurfacePatch(AbstractSurfacePatchType value) {
        return new JAXBElement<AbstractSurfacePatchType>(_AbstractSurfacePatch_QNAME, AbstractSurfacePatchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "temporalDatumProperty")
    public JAXBElement<TemporalDatumPropertyType> createTemporalDatumProperty(TemporalDatumPropertyType value) {
        return new JAXBElement<TemporalDatumPropertyType>(_TemporalDatumProperty_QNAME, TemporalDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CartesianCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "cartesianCSRef")
    public JAXBElement<CartesianCSPropertyType> createCartesianCSRef(CartesianCSPropertyType value) {
        return new JAXBElement<CartesianCSPropertyType>(_CartesianCSRef_QNAME, CartesianCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeWithAuthorityType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "rangeMeaning")
    public JAXBElement<CodeWithAuthorityType> createRangeMeaning(CodeWithAuthorityType value) {
        return new JAXBElement<CodeWithAuthorityType>(_RangeMeaning_QNAME, CodeWithAuthorityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiPointDomain", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "domainSet")
    public JAXBElement<DomainSetType> createMultiPointDomain(DomainSetType value) {
        return new JAXBElement<DomainSetType>(_MultiPointDomain_QNAME, DomainSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedObservationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "DirectedObservation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Observation")
    public JAXBElement<DirectedObservationType> createDirectedObservation(DirectedObservationType value) {
        return new JAXBElement<DirectedObservationType>(_DirectedObservation_QNAME, DirectedObservationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneralConversionPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "generalConversionRef")
    public JAXBElement<GeneralConversionPropertyType> createGeneralConversionRef(GeneralConversionPropertyType value) {
        return new JAXBElement<GeneralConversionPropertyType>(_GeneralConversionRef_QNAME, GeneralConversionPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConcatenatedOperationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ConcatenatedOperation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateOperation")
    public JAXBElement<ConcatenatedOperationType> createConcatenatedOperation(ConcatenatedOperationType value) {
        return new JAXBElement<ConcatenatedOperationType>(_ConcatenatedOperation_QNAME, ConcatenatedOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AffineCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesAffineCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "affineCSProperty")
    public JAXBElement<AffineCSPropertyType> createUsesAffineCS(AffineCSPropertyType value) {
        return new JAXBElement<AffineCSPropertyType>(_UsesAffineCS_QNAME, AffineCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "quantityTypeReference")
    public JAXBElement<ReferenceType> createQuantityTypeReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_QuantityTypeReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "coordinateSystemRef")
    public JAXBElement<CoordinateSystemPropertyType> createCoordinateSystemRef(CoordinateSystemPropertyType value) {
        return new JAXBElement<CoordinateSystemPropertyType>(_CoordinateSystemRef_QNAME, CoordinateSystemPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeCurveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CompositeCurve", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurve")
    public JAXBElement<CompositeCurveType> createCompositeCurve(CompositeCurveType value) {
        return new JAXBElement<CompositeCurveType>(_CompositeCurve_QNAME, CompositeCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesVerticalDatum", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "verticalDatumProperty")
    public JAXBElement<VerticalDatumPropertyType> createUsesVerticalDatum(VerticalDatumPropertyType value) {
        return new JAXBElement<VerticalDatumPropertyType>(_UsesVerticalDatum_QNAME, VerticalDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDefinedCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "userDefinedCSProperty")
    public JAXBElement<UserDefinedCSPropertyType> createUserDefinedCSProperty(UserDefinedCSPropertyType value) {
        return new JAXBElement<UserDefinedCSPropertyType>(_UserDefinedCSProperty_QNAME, UserDefinedCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BoundingShapeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "boundedBy")
    public JAXBElement<BoundingShapeType> createBoundedBy(BoundingShapeType value) {
        return new JAXBElement<BoundingShapeType>(_BoundedBy_QNAME, BoundingShapeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractSingleCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCRS")
    public JAXBElement<AbstractCRSType> createAbstractSingleCRS(AbstractCRSType value) {
        return new JAXBElement<AbstractCRSType>(_AbstractSingleCRS_QNAME, AbstractCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "modifiedCoordinate")
    public JAXBElement<BigInteger> createModifiedCoordinate(BigInteger value) {
        return new JAXBElement<BigInteger>(_ModifiedCoordinate_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<AbstractCRSType> createAbstractCRS(AbstractCRSType value) {
        return new JAXBElement<AbstractCRSType>(_AbstractCRS_QNAME, AbstractCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterGroupType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "OperationParameterGroup", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeneralOperationParameter")
    public JAXBElement<OperationParameterGroupType> createOperationParameterGroup(OperationParameterGroupType value) {
        return new JAXBElement<OperationParameterGroupType>(_OperationParameterGroup_QNAME, OperationParameterGroupType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArcStringType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ArcString", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurveSegment")
    public JAXBElement<ArcStringType> createArcString(ArcStringType value) {
        return new JAXBElement<ArcStringType>(_ArcString_QNAME, ArcStringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoPointType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TopoPoint")
    public JAXBElement<TopoPointType> createTopoPoint(TopoPointType value) {
        return new JAXBElement<TopoPointType>(_TopoPoint_QNAME, TopoPointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObliqueCartesianCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesObliqueCartesianCS")
    public JAXBElement<ObliqueCartesianCSPropertyType> createUsesObliqueCartesianCS(ObliqueCartesianCSPropertyType value) {
        return new JAXBElement<ObliqueCartesianCSPropertyType>(_UsesObliqueCartesianCS_QNAME, ObliqueCartesianCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiExtentOf")
    public JAXBElement<MultiSurfacePropertyType> createMultiExtentOf(MultiSurfacePropertyType value) {
        return new JAXBElement<MultiSurfacePropertyType>(_MultiExtentOf_QNAME, MultiSurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "methodFormula", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "formula")
    public JAXBElement<CodeType> createMethodFormula(CodeType value) {
        return new JAXBElement<CodeType>(_MethodFormula_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodeticDatumType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "GeodeticDatum", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractDatum")
    public JAXBElement<GeodeticDatumType> createGeodeticDatum(GeodeticDatumType value) {
        return new JAXBElement<GeodeticDatumType>(_GeodeticDatum_QNAME, GeodeticDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "status")
    public JAXBElement<StringOrRefType> createStatus(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_Status_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiSurfaceDomain", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "domainSet")
    public JAXBElement<DomainSetType> createMultiSurfaceDomain(DomainSetType value) {
        return new JAXBElement<DomainSetType>(_MultiSurfaceDomain_QNAME, DomainSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompoundCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CompoundCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCRS")
    public JAXBElement<CompoundCRSType> createCompoundCRS(CompoundCRSType value) {
        return new JAXBElement<CompoundCRSType>(_CompoundCRS_QNAME, CompoundCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedNodePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "directedNode")
    public JAXBElement<DirectedNodePropertyType> createDirectedNode(DirectedNodePropertyType value) {
        return new JAXBElement<DirectedNodePropertyType>(_DirectedNode_QNAME, DirectedNodePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoPrimitiveMemberType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "topoPrimitiveMember")
    public JAXBElement<TopoPrimitiveMemberType> createTopoPrimitiveMember(TopoPrimitiveMemberType value) {
        return new JAXBElement<TopoPrimitiveMemberType>(_TopoPrimitiveMember_QNAME, TopoPrimitiveMemberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractScalarValueList", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractValue")
    public JAXBElement<Object> createAbstractScalarValueList(Object value) {
        return new JAXBElement<Object>(_AbstractScalarValueList_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "abstractReference")
    public JAXBElement<ReferenceType> createAbstractReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_AbstractReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "MultiPoint", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometricAggregate")
    public JAXBElement<MultiPointType> createMultiPoint(MultiPointType value) {
        return new JAXBElement<MultiPointType>(_MultiPoint_QNAME, MultiPointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiscreteCoverageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "MultiSurfaceCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractDiscreteCoverage")
    public JAXBElement<DiscreteCoverageType> createMultiSurfaceCoverage(DiscreteCoverageType value) {
        return new JAXBElement<DiscreteCoverageType>(_MultiSurfaceCoverage_QNAME, DiscreteCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolarCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "polarCSProperty")
    public JAXBElement<PolarCSPropertyType> createPolarCSProperty(PolarCSPropertyType value) {
        return new JAXBElement<PolarCSPropertyType>(_PolarCSProperty_QNAME, PolarCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "targetElement")
    public JAXBElement<String> createTargetElement(String value) {
        return new JAXBElement<String>(_TargetElement_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "parameter")
    public JAXBElement<AbstractGeneralOperationParameterPropertyType> createParameter(AbstractGeneralOperationParameterPropertyType value) {
        return new JAXBElement<AbstractGeneralOperationParameterPropertyType>(_Parameter_QNAME, AbstractGeneralOperationParameterPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeWithAuthorityType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "axisDirection")
    public JAXBElement<CodeWithAuthorityType> createAxisDirection(CodeWithAuthorityType value) {
        return new JAXBElement<CodeWithAuthorityType>(_AxisDirection_QNAME, CodeWithAuthorityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodeticDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "geodeticDatumRef")
    public JAXBElement<GeodeticDatumPropertyType> createGeodeticDatumRef(GeodeticDatumPropertyType value) {
        return new JAXBElement<GeodeticDatumPropertyType>(_GeodeticDatumRef_QNAME, GeodeticDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VectorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "vector")
    public JAXBElement<VectorType> createVector(VectorType value) {
        return new JAXBElement<VectorType>(_Vector_QNAME, VectorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneralConversionPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "definedByConversion", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "conversionProperty")
    public JAXBElement<GeneralConversionPropertyType> createDefinedByConversion(GeneralConversionPropertyType value) {
        return new JAXBElement<GeneralConversionPropertyType>(_DefinedByConversion_QNAME, GeneralConversionPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationMethodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "OperationMethod", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<OperationMethodType> createOperationMethod(OperationMethodType value) {
        return new JAXBElement<OperationMethodType>(_OperationMethod_QNAME, OperationMethodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DMSAngleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "dmsAngle")
    public JAXBElement<DMSAngleType> createDmsAngle(DMSAngleType value) {
        return new JAXBElement<DMSAngleType>(_DmsAngle_QNAME, DMSAngleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Count }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Count", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractScalarValue")
    public JAXBElement<Count> createCount(Count value) {
        return new JAXBElement<Count>(_Count_QNAME, Count.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectionPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "direction")
    public JAXBElement<DirectionPropertyType> createDirection(DirectionPropertyType value) {
        return new JAXBElement<DirectionPropertyType>(_Direction_QNAME, DirectionPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TargetPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "target")
    public JAXBElement<TargetPropertyType> createTarget(TargetPropertyType value) {
        return new JAXBElement<TargetPropertyType>(_Target_QNAME, TargetPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralConversionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractGeneralConversion", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractOperation")
    public JAXBElement<AbstractGeneralConversionType> createAbstractGeneralConversion(AbstractGeneralConversionType value) {
        return new JAXBElement<AbstractGeneralConversionType>(_AbstractGeneralConversion_QNAME, AbstractGeneralConversionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "verticalCSRef")
    public JAXBElement<VerticalCSPropertyType> createVerticalCSRef(VerticalCSPropertyType value) {
        return new JAXBElement<VerticalCSPropertyType>(_VerticalCSRef_QNAME, VerticalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "timeCSProperty")
    public JAXBElement<TimeCSPropertyType> createTimeCSProperty(TimeCSPropertyType value) {
        return new JAXBElement<TimeCSPropertyType>(_TimeCSProperty_QNAME, TimeCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolarCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "PolarCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<PolarCSType> createPolarCS(PolarCSType value) {
        return new JAXBElement<PolarCSType>(_PolarCS_QNAME, PolarCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnvelopeWithTimePeriodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "EnvelopeWithTimePeriod", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Envelope")
    public JAXBElement<EnvelopeWithTimePeriodType> createEnvelopeWithTimePeriod(EnvelopeWithTimePeriodType value) {
        return new JAXBElement<EnvelopeWithTimePeriodType>(_EnvelopeWithTimePeriod_QNAME, EnvelopeWithTimePeriodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArcByBulgeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ArcByBulge", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "ArcStringByBulge")
    public JAXBElement<ArcByBulgeType> createArcByBulge(ArcByBulgeType value) {
        return new JAXBElement<ArcByBulgeType>(_ArcByBulge_QNAME, ArcByBulgeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoVolumeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TopoVolume")
    public JAXBElement<TopoVolumeType> createTopoVolume(TopoVolumeType value) {
        return new JAXBElement<TopoVolumeType>(_TopoVolume_QNAME, TopoVolumeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterGroupPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "group")
    public JAXBElement<OperationParameterGroupPropertyType> createGroup(OperationParameterGroupPropertyType value) {
        return new JAXBElement<OperationParameterGroupPropertyType>(_Group_QNAME, OperationParameterGroupPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterGroupPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "valuesOfGroup", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "group")
    public JAXBElement<OperationParameterGroupPropertyType> createValuesOfGroup(OperationParameterGroupPropertyType value) {
        return new JAXBElement<OperationParameterGroupPropertyType>(_ValuesOfGroup_QNAME, OperationParameterGroupPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "MappingRule")
    public JAXBElement<StringOrRefType> createMappingRule(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_MappingRule_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompoundCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "compoundCRSRef")
    public JAXBElement<CompoundCRSPropertyType> createCompoundCRSRef(CompoundCRSPropertyType value) {
        return new JAXBElement<CompoundCRSPropertyType>(_CompoundCRSRef_QNAME, CompoundCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "formula")
    public JAXBElement<CodeType> createFormula(CodeType value) {
        return new JAXBElement<CodeType>(_Formula_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "dataSourceReference")
    public JAXBElement<ReferenceType> createDataSourceReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_DataSourceReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "origin")
    public JAXBElement<XMLGregorianCalendar> createOrigin(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Origin_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "pointMembers")
    public JAXBElement<PointArrayPropertyType> createPointMembers(PointArrayPropertyType value) {
        return new JAXBElement<PointArrayPropertyType>(_PointMembers_QNAME, PointArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "imageCRSRef")
    public JAXBElement<ImageCRSPropertyType> createImageCRSRef(ImageCRSPropertyType value) {
        return new JAXBElement<ImageCRSPropertyType>(_ImageCRSRef_QNAME, ImageCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DegreesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "degrees")
    public JAXBElement<DegreesType> createDegrees(DegreesType value) {
        return new JAXBElement<DegreesType>(_Degrees_QNAME, DegreesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Quantity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Quantity", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractScalarValue")
    public JAXBElement<Quantity> createQuantity(Quantity value) {
        return new JAXBElement<Quantity>(_Quantity_QNAME, Quantity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "minutes")
    public JAXBElement<Integer> createMinutes(Integer value) {
        return new JAXBElement<Integer>(_Minutes_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "imageDatumRef")
    public JAXBElement<ImageDatumPropertyType> createImageDatumRef(ImageDatumPropertyType value) {
        return new JAXBElement<ImageDatumPropertyType>(_ImageDatumRef_QNAME, ImageDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataBlockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "DataBlock", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<DataBlockType> createDataBlock(DataBlockType value) {
        return new JAXBElement<DataBlockType>(_DataBlock_QNAME, DataBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "File", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<FileType> createFile(FileType value) {
        return new JAXBElement<FileType>(_File_QNAME, FileType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "integerValue")
    public JAXBElement<BigInteger> createIntegerValue(BigInteger value) {
        return new JAXBElement<BigInteger>(_IntegerValue_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AffineCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AffineCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<AffineCSType> createAffineCS(AffineCSType value) {
        return new JAXBElement<AffineCSType>(_AffineCS_QNAME, AffineCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "operationVersion")
    public JAXBElement<String> createOperationVersion(String value) {
        return new JAXBElement<String>(_OperationVersion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryEntryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "definitionMember", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "dictionaryEntry")
    public JAXBElement<DictionaryEntryType> createDefinitionMember(DictionaryEntryType value) {
        return new JAXBElement<DictionaryEntryType>(_DefinitionMember_QNAME, DictionaryEntryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "locationReference")
    public JAXBElement<ReferenceType> createLocationReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_LocationReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfaceArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "surfaceArrayProperty")
    public JAXBElement<SurfaceArrayPropertyType> createSurfaceArrayProperty(SurfaceArrayPropertyType value) {
        return new JAXBElement<SurfaceArrayPropertyType>(_SurfaceArrayProperty_QNAME, SurfaceArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiSurfaceProperty")
    public JAXBElement<MultiSurfacePropertyType> createMultiSurfaceProperty(MultiSurfacePropertyType value) {
        return new JAXBElement<MultiSurfacePropertyType>(_MultiSurfaceProperty_QNAME, MultiSurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesEllipsoid", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "ellipsoidProperty")
    public JAXBElement<EllipsoidPropertyType> createUsesEllipsoid(EllipsoidPropertyType value) {
        return new JAXBElement<EllipsoidPropertyType>(_UsesEllipsoid_QNAME, EllipsoidPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoSurfaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TopoSurface")
    public JAXBElement<TopoSurfaceType> createTopoSurface(TopoSurfaceType value) {
        return new JAXBElement<TopoSurfaceType>(_TopoSurface_QNAME, TopoSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesImageDatum", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "imageDatumProperty")
    public JAXBElement<ImageDatumPropertyType> createUsesImageDatum(ImageDatumPropertyType value) {
        return new JAXBElement<ImageDatumPropertyType>(_UsesImageDatum_QNAME, ImageDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Cone", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGriddedSurface")
    public JAXBElement<ConeType> createCone(ConeType value) {
        return new JAXBElement<ConeType>(_Cone_QNAME, ConeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ellipsoidalCSRef")
    public JAXBElement<EllipsoidalCSPropertyType> createEllipsoidalCSRef(EllipsoidalCSPropertyType value) {
        return new JAXBElement<EllipsoidalCSPropertyType>(_EllipsoidalCSRef_QNAME, EllipsoidalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeValueType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CompositeValue", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractValue")
    public JAXBElement<CompositeValueType> createCompositeValue(CompositeValueType value) {
        return new JAXBElement<CompositeValueType>(_CompositeValue_QNAME, CompositeValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "referenceSystemRef")
    public JAXBElement<CRSPropertyType> createReferenceSystemRef(CRSPropertyType value) {
        return new JAXBElement<CRSPropertyType>(_ReferenceSystemRef_QNAME, CRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeReferenceSystemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeReferenceSystem", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<TimeReferenceSystemType> createTimeReferenceSystem(TimeReferenceSystemType value) {
        return new JAXBElement<TimeReferenceSystemType>(_TimeReferenceSystem_QNAME, TimeReferenceSystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageDatumType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ImageDatum", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractDatum")
    public JAXBElement<ImageDatumType> createImageDatum(ImageDatumType value) {
        return new JAXBElement<ImageDatumType>(_ImageDatum_QNAME, ImageDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EngineeringDatumType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "EngineeringDatum", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractDatum")
    public JAXBElement<EngineeringDatumType> createEngineeringDatum(EngineeringDatumType value) {
        return new JAXBElement<EngineeringDatumType>(_EngineeringDatum_QNAME, EngineeringDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractMetaDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractMetaData", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<AbstractMetaDataType> createAbstractMetaData(AbstractMetaDataType value) {
        return new JAXBElement<AbstractMetaDataType>(_AbstractMetaData_QNAME, AbstractMetaDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimePositionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "timePosition")
    public JAXBElement<TimePositionType> createTimePosition(TimePositionType value) {
        return new JAXBElement<TimePositionType>(_TimePosition_QNAME, TimePositionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractRingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractRing", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<AbstractRingType> createAbstractRing(AbstractRingType value) {
        return new JAXBElement<AbstractRingType>(_AbstractRing_QNAME, AbstractRingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeographicCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "baseGeographicCRS")
    public JAXBElement<GeographicCRSPropertyType> createBaseGeographicCRS(GeographicCRSPropertyType value) {
        return new JAXBElement<GeographicCRSPropertyType>(_BaseGeographicCRS_QNAME, GeographicCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedTopoSolidPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "directedTopoSolid")
    public JAXBElement<DirectedTopoSolidPropertyType> createDirectedTopoSolid(DirectedTopoSolidPropertyType value) {
        return new JAXBElement<DirectedTopoSolidPropertyType>(_DirectedTopoSolid_QNAME, DirectedTopoSolidPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TemporalCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<TemporalCSType> createTemporalCS(TemporalCSType value) {
        return new JAXBElement<TemporalCSType>(_TemporalCS_QNAME, TemporalCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesTemporalDatum", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "temporalDatumProperty")
    public JAXBElement<TemporalDatumPropertyType> createUsesTemporalDatum(TemporalDatumPropertyType value) {
        return new JAXBElement<TemporalDatumPropertyType>(_UsesTemporalDatum_QNAME, TemporalDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArcStringByBulgeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ArcStringByBulge", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurveSegment")
    public JAXBElement<ArcStringByBulgeType> createArcStringByBulge(ArcStringByBulgeType value) {
        return new JAXBElement<ArcStringByBulgeType>(_ArcStringByBulge_QNAME, ArcStringByBulgeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransformationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "transformationRef")
    public JAXBElement<TransformationPropertyType> createTransformationRef(TransformationPropertyType value) {
        return new JAXBElement<TransformationPropertyType>(_TransformationRef_QNAME, TransformationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalDatumType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TemporalDatum", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractDatum")
    public JAXBElement<TemporalDatumType> createTemporalDatum(TemporalDatumType value) {
        return new JAXBElement<TemporalDatumType>(_TemporalDatum_QNAME, TemporalDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiPointProperty")
    public JAXBElement<MultiPointPropertyType> createMultiPointProperty(MultiPointPropertyType value) {
        return new JAXBElement<MultiPointPropertyType>(_MultiPointProperty_QNAME, MultiPointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeEdgeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeEdge", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTimeTopologyPrimitive")
    public JAXBElement<TimeEdgeType> createTimeEdge(TimeEdgeType value) {
        return new JAXBElement<TimeEdgeType>(_TimeEdge_QNAME, TimeEdgeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeWithAuthorityType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "pixelInCell")
    public JAXBElement<CodeWithAuthorityType> createPixelInCell(CodeWithAuthorityType value) {
        return new JAXBElement<CodeWithAuthorityType>(_PixelInCell_QNAME, CodeWithAuthorityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiCenterLineOf")
    public JAXBElement<MultiCurvePropertyType> createMultiCenterLineOf(MultiCurvePropertyType value) {
        return new JAXBElement<MultiCurvePropertyType>(_MultiCenterLineOf_QNAME, MultiCurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MovingObjectStatusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "MovingObjectStatus", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTimeSlice")
    public JAXBElement<MovingObjectStatusType> createMovingObjectStatus(MovingObjectStatusType value) {
        return new JAXBElement<MovingObjectStatusType>(_MovingObjectStatus_QNAME, MovingObjectStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Ellipsoid", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<EllipsoidType> createEllipsoid(EllipsoidType value) {
        return new JAXBElement<EllipsoidType>(_Ellipsoid_QNAME, EllipsoidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiscreteCoverageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "MultiPointCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractDiscreteCoverage")
    public JAXBElement<DiscreteCoverageType> createMultiPointCoverage(DiscreteCoverageType value) {
        return new JAXBElement<DiscreteCoverageType>(_MultiPointCoverage_QNAME, DiscreteCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DynamicFeatureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "DynamicFeature", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<DynamicFeatureType> createDynamicFeature(DynamicFeatureType value) {
        return new JAXBElement<DynamicFeatureType>(_DynamicFeature_QNAME, DynamicFeatureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SphericalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesSphericalCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "sphericalCSProperty")
    public JAXBElement<SphericalCSPropertyType> createUsesSphericalCS(SphericalCSPropertyType value) {
        return new JAXBElement<SphericalCSPropertyType>(_UsesSphericalCS_QNAME, SphericalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Dictionary", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<DictionaryType> createDictionary(DictionaryType value) {
        return new JAXBElement<DictionaryType>(_Dictionary_QNAME, DictionaryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "descriptionReference")
    public JAXBElement<ReferenceType> createDescriptionReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_DescriptionReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "baseCurve")
    public JAXBElement<CurvePropertyType> createBaseCurve(CurvePropertyType value) {
        return new JAXBElement<CurvePropertyType>(_BaseCurve_QNAME, CurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneralTransformationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "generalTransformationRef")
    public JAXBElement<GeneralTransformationPropertyType> createGeneralTransformationRef(GeneralTransformationPropertyType value) {
        return new JAXBElement<GeneralTransformationPropertyType>(_GeneralTransformationRef_QNAME, GeneralTransformationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralDerivedCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractGeneralDerivedCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSingleCRS")
    public JAXBElement<AbstractGeneralDerivedCRSType> createAbstractGeneralDerivedCRS(AbstractGeneralDerivedCRSType value) {
        return new JAXBElement<AbstractGeneralDerivedCRSType>(_AbstractGeneralDerivedCRS_QNAME, AbstractGeneralDerivedCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodeticCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "baseGeodeticCRS")
    public JAXBElement<GeodeticCRSPropertyType> createBaseGeodeticCRS(GeodeticCRSPropertyType value) {
        return new JAXBElement<GeodeticCRSPropertyType>(_BaseGeodeticCRS_QNAME, GeodeticCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDefinedCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "userDefinedCSRef")
    public JAXBElement<UserDefinedCSPropertyType> createUserDefinedCSRef(UserDefinedCSPropertyType value) {
        return new JAXBElement<UserDefinedCSPropertyType>(_UserDefinedCSRef_QNAME, UserDefinedCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrimeMeridianPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "primeMeridianRef")
    public JAXBElement<PrimeMeridianPropertyType> createPrimeMeridianRef(PrimeMeridianPropertyType value) {
        return new JAXBElement<PrimeMeridianPropertyType>(_PrimeMeridianRef_QNAME, PrimeMeridianPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "pointMember")
    public JAXBElement<PointPropertyType> createPointMember(PointPropertyType value) {
        return new JAXBElement<PointPropertyType>(_PointMember_QNAME, PointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "includesParameter", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "parameter")
    public JAXBElement<AbstractGeneralOperationParameterPropertyType> createIncludesParameter(AbstractGeneralOperationParameterPropertyType value) {
        return new JAXBElement<AbstractGeneralOperationParameterPropertyType>(_IncludesParameter_QNAME, AbstractGeneralOperationParameterPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValueArrayType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ValueArray", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "CompositeValue")
    public JAXBElement<ValueArrayType> createValueArray(ValueArrayType value) {
        return new JAXBElement<ValueArrayType>(_ValueArray_QNAME, ValueArrayType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "position")
    public JAXBElement<PointPropertyType> createPosition(PointPropertyType value) {
        return new JAXBElement<PointPropertyType>(_Position_QNAME, PointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDefinedCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "UserDefinedCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<UserDefinedCSType> createUserDefinedCS(UserDefinedCSType value) {
        return new JAXBElement<UserDefinedCSType>(_UserDefinedCS_QNAME, UserDefinedCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CylindricalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "cylindricalCSRef")
    public JAXBElement<CylindricalCSPropertyType> createCylindricalCSRef(CylindricalCSPropertyType value) {
        return new JAXBElement<CylindricalCSPropertyType>(_CylindricalCSRef_QNAME, CylindricalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractSurfaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractSurface", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometricPrimitive")
    public JAXBElement<AbstractSurfaceType> createAbstractSurface(AbstractSurfaceType value) {
        return new JAXBElement<AbstractSurfaceType>(_AbstractSurface_QNAME, AbstractSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeatureArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "featureMembers")
    public JAXBElement<FeatureArrayPropertyType> createFeatureMembers(FeatureArrayPropertyType value) {
        return new JAXBElement<FeatureArrayPropertyType>(_FeatureMembers_QNAME, FeatureArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DerivedCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "derivedCRSRef")
    public JAXBElement<DerivedCRSPropertyType> createDerivedCRSRef(DerivedCRSPropertyType value) {
        return new JAXBElement<DerivedCRSPropertyType>(_DerivedCRSRef_QNAME, DerivedCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "baseSurface")
    public JAXBElement<SurfacePropertyType> createBaseSurface(SurfacePropertyType value) {
        return new JAXBElement<SurfacePropertyType>(_BaseSurface_QNAME, SurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeOrdinalReferenceSystemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeOrdinalReferenceSystem", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "TimeReferenceSystem")
    public JAXBElement<TimeOrdinalReferenceSystemType> createTimeOrdinalReferenceSystem(TimeOrdinalReferenceSystemType value) {
        return new JAXBElement<TimeOrdinalReferenceSystemType>(_TimeOrdinalReferenceSystem_QNAME, TimeOrdinalReferenceSystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LineStringType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "LineString", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurve")
    public JAXBElement<LineStringType> createLineString(LineStringType value) {
        return new JAXBElement<LineStringType>(_LineString_QNAME, LineStringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoSurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "topoSurfaceProperty")
    public JAXBElement<TopoSurfacePropertyType> createTopoSurfaceProperty(TopoSurfacePropertyType value) {
        return new JAXBElement<TopoSurfacePropertyType>(_TopoSurfaceProperty_QNAME, TopoSurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObservationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Observation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<ObservationType> createObservation(ObservationType value) {
        return new JAXBElement<ObservationType>(_Observation_QNAME, ObservationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseUnitType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "BaseUnit", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "UnitDefinition")
    public JAXBElement<BaseUnitType> createBaseUnit(BaseUnitType value) {
        return new JAXBElement<BaseUnitType>(_BaseUnit_QNAME, BaseUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodeticDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesGeodeticDatum", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "geodeticDatumProperty")
    public JAXBElement<GeodeticDatumPropertyType> createUsesGeodeticDatum(GeodeticDatumPropertyType value) {
        return new JAXBElement<GeodeticDatumPropertyType>(_UsesGeodeticDatum_QNAME, GeodeticDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesTemporalCS")
    public JAXBElement<TemporalCSPropertyType> createUsesTemporalCS(TemporalCSPropertyType value) {
        return new JAXBElement<TemporalCSPropertyType>(_UsesTemporalCS_QNAME, TemporalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeSolidType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CompositeSolid", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSolid")
    public JAXBElement<CompositeSolidType> createCompositeSolid(CompositeSolidType value) {
        return new JAXBElement<CompositeSolidType>(_CompositeSolid_QNAME, CompositeSolidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnvelopeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Envelope", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<EnvelopeType> createEnvelope(EnvelopeType value) {
        return new JAXBElement<EnvelopeType>(_Envelope_QNAME, EnvelopeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnitOfMeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "unitOfMeasure")
    public JAXBElement<UnitOfMeasureType> createUnitOfMeasure(UnitOfMeasureType value) {
        return new JAXBElement<UnitOfMeasureType>(_UnitOfMeasure_QNAME, UnitOfMeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesTimeCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "timeCSProperty")
    public JAXBElement<TimeCSPropertyType> createUsesTimeCS(TimeCSPropertyType value) {
        return new JAXBElement<TimeCSPropertyType>(_UsesTimeCS_QNAME, TimeCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterValueGroupType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ParameterValueGroup", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeneralParameterValue")
    public JAXBElement<ParameterValueGroupType> createParameterValueGroup(ParameterValueGroupType value) {
        return new JAXBElement<ParameterValueGroupType>(_ParameterValueGroup_QNAME, ParameterValueGroupType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoComplexPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "maximalComplex")
    public JAXBElement<TopoComplexPropertyType> createMaximalComplex(TopoComplexPropertyType value) {
        return new JAXBElement<TopoComplexPropertyType>(_MaximalComplex_QNAME, TopoComplexPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinearRingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "LinearRing", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractRing")
    public JAXBElement<LinearRingType> createLinearRing(LinearRingType value) {
        return new JAXBElement<LinearRingType>(_LinearRing_QNAME, LinearRingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "DefinitionCollection", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<DictionaryType> createDefinitionCollection(DictionaryType value) {
        return new JAXBElement<DictionaryType>(_DefinitionCollection_QNAME, DictionaryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CylindricalCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CylindricalCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<CylindricalCSType> createCylindricalCS(CylindricalCSType value) {
        return new JAXBElement<CylindricalCSType>(_CylindricalCS_QNAME, CylindricalCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGMLType }{@code >}}
     * 
     
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractGML", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<AbstractGMLType> createAbstractGML(AbstractGMLType value) {
        return new JAXBElement<AbstractGMLType>(_AbstractGML_QNAME, AbstractGMLType.class, null, value);
    }*/

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSolidPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiSolidProperty")
    public JAXBElement<MultiSolidPropertyType> createMultiSolidProperty(MultiSolidPropertyType value) {
        return new JAXBElement<MultiSolidPropertyType>(_MultiSolidProperty_QNAME, MultiSolidPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DynamicFeatureCollectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "DynamicFeatureCollection", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "DynamicFeature")
    public JAXBElement<DynamicFeatureCollectionType> createDynamicFeatureCollection(DynamicFeatureCollectionType value) {
        return new JAXBElement<DynamicFeatureCollectionType>(_DynamicFeatureCollection_QNAME, DynamicFeatureCollectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeWithAuthorityType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "identifier")
    public JAXBElement<CodeWithAuthorityType> createIdentifier(CodeWithAuthorityType value) {
        return new JAXBElement<CodeWithAuthorityType>(_Identifier_QNAME, CodeWithAuthorityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BSplineType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "BSpline", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurveSegment")
    public JAXBElement<BSplineType> createBSpline(BSplineType value) {
        return new JAXBElement<BSplineType>(_BSpline_QNAME, BSplineType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CartesianCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesCartesianCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "cartesianCSProperty")
    public JAXBElement<CartesianCSPropertyType> createUsesCartesianCS(CartesianCSPropertyType value) {
        return new JAXBElement<CartesianCSPropertyType>(_UsesCartesianCS_QNAME, CartesianCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "sourceCRS")
    public JAXBElement<CRSPropertyType> createSourceCRS(CRSPropertyType value) {
        return new JAXBElement<CRSPropertyType>(_SourceCRS_QNAME, CRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AffineCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "affineCSProperty")
    public JAXBElement<AffineCSPropertyType> createAffineCSProperty(AffineCSPropertyType value) {
        return new JAXBElement<AffineCSPropertyType>(_AffineCSProperty_QNAME, AffineCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "statusReference")
    public JAXBElement<ReferenceType> createStatusReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_StatusReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "sourceDimensions")
    public JAXBElement<BigInteger> createSourceDimensions(BigInteger value) {
        return new JAXBElement<BigInteger>(_SourceDimensions_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoComplexType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TopoComplex", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTopology")
    public JAXBElement<TopoComplexType> createTopoComplex(TopoComplexType value) {
        return new JAXBElement<TopoComplexType>(_TopoComplex_QNAME, TopoComplexType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiGeometryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "MultiGeometry", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometricAggregate")
    public JAXBElement<MultiGeometryType> createMultiGeometry(MultiGeometryType value) {
        return new JAXBElement<MultiGeometryType>(_MultiGeometry_QNAME, MultiGeometryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "coordinateSystem")
    public JAXBElement<CoordinateSystemPropertyType> createCoordinateSystem(CoordinateSystemPropertyType value) {
        return new JAXBElement<CoordinateSystemPropertyType>(_CoordinateSystem_QNAME, CoordinateSystemPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MappingRuleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CoverageMappingRule", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<MappingRuleType> createCoverageMappingRule(MappingRuleType value) {
        return new JAXBElement<MappingRuleType>(_CoverageMappingRule_QNAME, MappingRuleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePatchArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "polygonPatches", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "patches")
    public JAXBElement<SurfacePatchArrayPropertyType> createPolygonPatches(SurfacePatchArrayPropertyType value) {
        return new JAXBElement<SurfacePatchArrayPropertyType>(_PolygonPatches_QNAME, SurfacePatchArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiCurveProperty")
    public JAXBElement<MultiCurvePropertyType> createMultiCurveProperty(MultiCurvePropertyType value) {
        return new JAXBElement<MultiCurvePropertyType>(_MultiCurveProperty_QNAME, MultiCurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "operationParameterGroupRef")
    public JAXBElement<OperationParameterPropertyType> createOperationParameterGroupRef(OperationParameterPropertyType value) {
        return new JAXBElement<OperationParameterPropertyType>(_OperationParameterGroupRef_QNAME, OperationParameterPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiPosition")
    public JAXBElement<MultiPointPropertyType> createMultiPosition(MultiPointPropertyType value) {
        return new JAXBElement<MultiPointPropertyType>(_MultiPosition_QNAME, MultiPointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "verticalDatumRef")
    public JAXBElement<VerticalDatumPropertyType> createVerticalDatumRef(VerticalDatumPropertyType value) {
        return new JAXBElement<VerticalDatumPropertyType>(_VerticalDatumRef_QNAME, VerticalDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrientableCurveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "OrientableCurve", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurve")
    public JAXBElement<OrientableCurveType> createOrientableCurve(OrientableCurveType value) {
        return new JAXBElement<OrientableCurveType>(_OrientableCurve_QNAME, OrientableCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "definitionRef")
    public JAXBElement<ReferenceType> createDefinitionRef(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_DefinitionRef_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "surfaceMember")
    public JAXBElement<SurfacePropertyType> createSurfaceMember(SurfacePropertyType value) {
        return new JAXBElement<SurfacePropertyType>(_SurfaceMember_QNAME, SurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Solid", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSolid")
    public JAXBElement<SolidType> createSolid(SolidType value) {
        return new JAXBElement<SolidType>(_Solid_QNAME, SolidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "dataSource")
    public JAXBElement<StringOrRefType> createDataSource(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_DataSource_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiscreteCoverageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "MultiCurveCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractDiscreteCoverage")
    public JAXBElement<DiscreteCoverageType> createMultiCurveCoverage(DiscreteCoverageType value) {
        return new JAXBElement<DiscreteCoverageType>(_MultiCurveCoverage_QNAME, DiscreteCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "associationName")
    public JAXBElement<String> createAssociationName(String value) {
        return new JAXBElement<String>(_AssociationName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiSolidDomain", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "domainSet")
    public JAXBElement<DomainSetType> createMultiSolidDomain(DomainSetType value) {
        return new JAXBElement<DomainSetType>(_MultiSolidDomain_QNAME, DomainSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Category }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Category", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractScalarValue")
    public JAXBElement<Category> createCategory(Category value) {
        return new JAXBElement<Category>(_Category_QNAME, Category.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSolidType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "MultiSolid", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometricAggregate")
    public JAXBElement<MultiSolidType> createMultiSolid(MultiSolidType value) {
        return new JAXBElement<MultiSolidType>(_MultiSolid_QNAME, MultiSolidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimePrimitiveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractTimePrimitive", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTimeObject")
    public JAXBElement<AbstractTimePrimitiveType> createAbstractTimePrimitive(AbstractTimePrimitiveType value) {
        return new JAXBElement<AbstractTimePrimitiveType>(_AbstractTimePrimitive_QNAME, AbstractTimePrimitiveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HistoryPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "track", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "history")
    public JAXBElement<HistoryPropertyType> createTrack(HistoryPropertyType value) {
        return new JAXBElement<HistoryPropertyType>(_Track_QNAME, HistoryPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeTopologyComplexType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeTopologyComplex", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTimeComplex")
    public JAXBElement<TimeTopologyComplexType> createTimeTopologyComplex(TimeTopologyComplexType value) {
        return new JAXBElement<TimeTopologyComplexType>(_TimeTopologyComplex_QNAME, TimeTopologyComplexType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArcByCenterPointType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ArcByCenterPoint", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurveSegment")
    public JAXBElement<ArcByCenterPointType> createArcByCenterPoint(ArcByCenterPointType value) {
        return new JAXBElement<ArcByCenterPointType>(_ArcByCenterPoint_QNAME, ArcByCenterPointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectPositionListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "posList")
    public JAXBElement<DirectPositionListType> createPosList(DirectPositionListType value) {
        return new JAXBElement<DirectPositionListType>(_PosList_QNAME, DirectPositionListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetaDataPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "metaDataProperty")
    public JAXBElement<MetaDataPropertyType> createMetaDataProperty(MetaDataPropertyType value) {
        return new JAXBElement<MetaDataPropertyType>(_MetaDataProperty_QNAME, MetaDataPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeIntervalLengthType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "timeInterval")
    public JAXBElement<TimeIntervalLengthType> createTimeInterval(TimeIntervalLengthType value) {
        return new JAXBElement<TimeIntervalLengthType>(_TimeInterval_QNAME, TimeIntervalLengthType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractOperation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSingleOperation")
    public JAXBElement<AbstractCoordinateOperationType> createAbstractOperation(AbstractCoordinateOperationType value) {
        return new JAXBElement<AbstractCoordinateOperationType>(_AbstractOperation_QNAME, AbstractCoordinateOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValuePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesValue", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "parameterValueProperty")
    public JAXBElement<AbstractGeneralParameterValuePropertyType> createUsesValue(AbstractGeneralParameterValuePropertyType value) {
        return new JAXBElement<AbstractGeneralParameterValuePropertyType>(_UsesValue_QNAME, AbstractGeneralParameterValuePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericMetaDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "GenericMetaData", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractMetaData")
    public JAXBElement<GenericMetaDataType> createGenericMetaData(GenericMetaDataType value) {
        return new JAXBElement<GenericMetaDataType>(_GenericMetaData_QNAME, GenericMetaDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeOrNilReasonListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CategoryList", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractScalarValueList")
    public JAXBElement<CodeOrNilReasonListType> createCategoryList(CodeOrNilReasonListType value) {
        return new JAXBElement<CodeOrNilReasonListType>(_CategoryList_QNAME, CodeOrNilReasonListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "gridDomain", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "domainSet")
    public JAXBElement<DomainSetType> createGridDomain(DomainSetType value) {
        return new JAXBElement<DomainSetType>(_GridDomain_QNAME, DomainSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "doubleOrNilReasonTupleList")
    public JAXBElement<List<String>> createDoubleOrNilReasonTupleList(List<String> value) {
        return new JAXBElement<List<String>>(_DoubleOrNilReasonTupleList_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "includesSingleCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "componentReferenceSystem")
    public JAXBElement<SingleCRSPropertyType> createIncludesSingleCRS(SingleCRSPropertyType value) {
        return new JAXBElement<SingleCRSPropertyType>(_IncludesSingleCRS_QNAME, SingleCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimeTopologyPrimitiveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractTimeTopologyPrimitive", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTimePrimitive")
    public JAXBElement<AbstractTimeTopologyPrimitiveType> createAbstractTimeTopologyPrimitive(AbstractTimeTopologyPrimitiveType value) {
        return new JAXBElement<AbstractTimeTopologyPrimitiveType>(_AbstractTimeTopologyPrimitive_QNAME, AbstractTimeTopologyPrimitiveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Array", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGML")
    public JAXBElement<ArrayType> createArray(ArrayType value) {
        return new JAXBElement<ArrayType>(_Array_QNAME, ArrayType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurveArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "curveMembers")
    public JAXBElement<CurveArrayPropertyType> createCurveMembers(CurveArrayPropertyType value) {
        return new JAXBElement<CurveArrayPropertyType>(_CurveMembers_QNAME, CurveArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "locationName")
    public JAXBElement<CodeType> createLocationName(CodeType value) {
        return new JAXBElement<CodeType>(_LocationName_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectPositionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "pos")
    public JAXBElement<DirectPositionType> createPos(DirectPositionType value) {
        return new JAXBElement<DirectPositionType>(_Pos_QNAME, DirectPositionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
    
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractObject")
    public JAXBElement<Object> createAbstractObject(Object value) {
        return new JAXBElement<Object>(_AbstractObject_QNAME, Object.class, null, value);
    } */

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeocentricCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "GeocentricCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSingleCRS")
    public JAXBElement<GeocentricCRSType> createGeocentricCRS(GeocentricCRSType value) {
        return new JAXBElement<GeocentricCRSType>(_GeocentricCRS_QNAME, GeocentricCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGriddedSurfaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractGriddedSurface", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractParametricCurveSurface")
    public JAXBElement<AbstractGriddedSurfaceType> createAbstractGriddedSurface(AbstractGriddedSurfaceType value) {
        return new JAXBElement<AbstractGriddedSurfaceType>(_AbstractGriddedSurface_QNAME, AbstractGriddedSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValuePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "valueProperty")
    public JAXBElement<ValuePropertyType> createValueProperty(ValuePropertyType value) {
        return new JAXBElement<ValuePropertyType>(_ValueProperty_QNAME, ValuePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "exterior")
    public JAXBElement<AbstractRingPropertyType> createExterior(AbstractRingPropertyType value) {
        return new JAXBElement<AbstractRingPropertyType>(_Exterior_QNAME, AbstractRingPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CartesianCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CartesianCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<CartesianCSType> createCartesianCS(CartesianCSType value) {
        return new JAXBElement<CartesianCSType>(_CartesianCS_QNAME, CartesianCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "verticalCRSRef")
    public JAXBElement<VerticalCRSPropertyType> createVerticalCRSRef(VerticalCRSPropertyType value) {
        return new JAXBElement<VerticalCRSPropertyType>(_VerticalCRSRef_QNAME, VerticalCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeometricPrimitiveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractGeometricPrimitive", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometry")
    public JAXBElement<AbstractGeometricPrimitiveType> createAbstractGeometricPrimitive(AbstractGeometricPrimitiveType value) {
        return new JAXBElement<AbstractGeometricPrimitiveType>(_AbstractGeometricPrimitive_QNAME, AbstractGeometricPrimitiveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "defaultCodeSpace")
    public JAXBElement<String> createDefaultCodeSpace(String value) {
        return new JAXBElement<String>(_DefaultCodeSpace_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTopologyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractTopology", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGML")
    public JAXBElement<AbstractTopologyType> createAbstractTopology(AbstractTopologyType value) {
        return new JAXBElement<AbstractTopologyType>(_AbstractTopology_QNAME, AbstractTopologyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoCurveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TopoCurve")
    public JAXBElement<TopoCurveType> createTopoCurve(TopoCurveType value) {
        return new JAXBElement<TopoCurveType>(_TopoCurve_QNAME, TopoCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeometryPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "geometryMember")
    public JAXBElement<GeometryPropertyType> createGeometryMember(GeometryPropertyType value) {
        return new JAXBElement<GeometryPropertyType>(_GeometryMember_QNAME, GeometryPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCoordinateSystemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeCoordinateSystem", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "TimeReferenceSystem")
    public JAXBElement<TimeCoordinateSystemType> createTimeCoordinateSystem(TimeCoordinateSystemType value) {
        return new JAXBElement<TimeCoordinateSystemType>(_TimeCoordinateSystem_QNAME, TimeCoordinateSystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Null")
    public JAXBElement<List<String>> createNull(List<String> value) {
        return new JAXBElement<List<String>>(_Null_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProjectedCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "projectedCRSRef")
    public JAXBElement<ProjectedCRSPropertyType> createProjectedCRSRef(ProjectedCRSPropertyType value) {
        return new JAXBElement<ProjectedCRSPropertyType>(_ProjectedCRSRef_QNAME, ProjectedCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeNodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeNode", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTimeTopologyPrimitive")
    public JAXBElement<TimeNodeType> createTimeNode(TimeNodeType value) {
        return new JAXBElement<TimeNodeType>(_TimeNode_QNAME, TimeNodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Curve", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurve")
    public JAXBElement<CurveType> createCurve(CurveType value) {
        return new JAXBElement<CurveType>(_Curve_QNAME, CurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "semiMajorAxis")
    public JAXBElement<MeasureType> createSemiMajorAxis(MeasureType value) {
        return new JAXBElement<MeasureType>(_SemiMajorAxis_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiEdgeOf")
    public JAXBElement<MultiCurvePropertyType> createMultiEdgeOf(MultiCurvePropertyType value) {
        return new JAXBElement<MultiCurvePropertyType>(_MultiEdgeOf_QNAME, MultiCurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimePeriodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimePeriod", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTimeGeometricPrimitive")
    public JAXBElement<TimePeriodType> createTimePeriod(TimePeriodType value) {
        return new JAXBElement<TimePeriodType>(_TimePeriod_QNAME, TimePeriodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCurveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractCurve", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometricPrimitive")
    public JAXBElement<AbstractCurveType> createAbstractCurve(AbstractCurveType value) {
        return new JAXBElement<AbstractCurveType>(_AbstractCurve_QNAME, AbstractCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EngineeringDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "engineeringDatumRef")
    public JAXBElement<EngineeringDatumPropertyType> createEngineeringDatumRef(EngineeringDatumPropertyType value) {
        return new JAXBElement<EngineeringDatumPropertyType>(_EngineeringDatumRef_QNAME, EngineeringDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractValue", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<Object> createAbstractValue(Object value) {
        return new JAXBElement<Object>(_AbstractValue_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClothoidType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Clothoid", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurveSegment")
    public JAXBElement<ClothoidType> createClothoid(ClothoidType value) {
        return new JAXBElement<ClothoidType>(_Clothoid_QNAME, ClothoidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "temporalCRSRef")
    public JAXBElement<TemporalCRSPropertyType> createTemporalCRSRef(TemporalCRSPropertyType value) {
        return new JAXBElement<TemporalCRSPropertyType>(_TemporalCRSRef_QNAME, TemporalCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ellipsoidProperty")
    public JAXBElement<EllipsoidPropertyType> createEllipsoidProperty(EllipsoidPropertyType value) {
        return new JAXBElement<EllipsoidPropertyType>(_EllipsoidProperty_QNAME, EllipsoidPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "reversePropertyName")
    public JAXBElement<String> createReversePropertyName(String value) {
        return new JAXBElement<String>(_ReversePropertyName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "componentReferenceSystem")
    public JAXBElement<SingleCRSPropertyType> createComponentReferenceSystem(SingleCRSPropertyType value) {
        return new JAXBElement<SingleCRSPropertyType>(_ComponentReferenceSystem_QNAME, SingleCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimeSliceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractTimeSlice", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGML")
    public JAXBElement<AbstractTimeSliceType> createAbstractTimeSlice(AbstractTimeSliceType value) {
        return new JAXBElement<AbstractTimeSliceType>(_AbstractTimeSlice_QNAME, AbstractTimeSliceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "resultOf")
    public JAXBElement<ResultType> createResultOf(ResultType value) {
        return new JAXBElement<ResultType>(_ResultOf_QNAME, ResultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CubicSplineType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CubicSpline", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurveSegment")
    public JAXBElement<CubicSplineType> createCubicSpline(CubicSplineType value) {
        return new JAXBElement<CubicSplineType>(_CubicSpline_QNAME, CubicSplineType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiscreteCoverageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractDiscreteCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoverage")
    public JAXBElement<DiscreteCoverageType> createAbstractDiscreteCoverage(DiscreteCoverageType value) {
        return new JAXBElement<DiscreteCoverageType>(_AbstractDiscreteCoverage_QNAME, DiscreteCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DerivedCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "DerivedCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeneralDerivedCRS")
    public JAXBElement<DerivedCRSType> createDerivedCRS(DerivedCRSType value) {
        return new JAXBElement<DerivedCRSType>(_DerivedCRS_QNAME, DerivedCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AngleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "greenwichLongitude")
    public JAXBElement<AngleType> createGreenwichLongitude(AngleType value) {
        return new JAXBElement<AngleType>(_GreenwichLongitude_QNAME, AngleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "targetCRS")
    public JAXBElement<CRSPropertyType> createTargetCRS(CRSPropertyType value) {
        return new JAXBElement<CRSPropertyType>(_TargetCRS_QNAME, CRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "centerLineOf")
    public JAXBElement<CurvePropertyType> createCenterLineOf(CurvePropertyType value) {
        return new JAXBElement<CurvePropertyType>(_CenterLineOf_QNAME, CurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EngineeringCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "engineeringCRSRef")
    public JAXBElement<EngineeringCRSPropertyType> createEngineeringCRSRef(EngineeringCRSPropertyType value) {
        return new JAXBElement<EngineeringCRSPropertyType>(_EngineeringCRSRef_QNAME, EngineeringCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationMethodPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "operationMethodRef")
    public JAXBElement<OperationMethodPropertyType> createOperationMethodRef(OperationMethodPropertyType value) {
        return new JAXBElement<OperationMethodPropertyType>(_OperationMethodRef_QNAME, OperationMethodPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TinType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Tin", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "TriangulatedSurface")
    public JAXBElement<TinType> createTin(TinType value) {
        return new JAXBElement<TinType>(_Tin_QNAME, TinType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Face", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTopoPrimitive")
    public JAXBElement<FaceType> createFace(FaceType value) {
        return new JAXBElement<FaceType>(_Face_QNAME, FaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoCurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "topoCurveProperty")
    public JAXBElement<TopoCurvePropertyType> createTopoCurveProperty(TopoCurvePropertyType value) {
        return new JAXBElement<TopoCurvePropertyType>(_TopoCurveProperty_QNAME, TopoCurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeOrdinalEraType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeOrdinalEra")
    public JAXBElement<TimeOrdinalEraType> createTimeOrdinalEra(TimeOrdinalEraType value) {
        return new JAXBElement<TimeOrdinalEraType>(_TimeOrdinalEra_QNAME, TimeOrdinalEraType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefinitionProxyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "DefinitionProxy", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<DefinitionProxyType> createDefinitionProxy(DefinitionProxyType value) {
        return new JAXBElement<DefinitionProxyType>(_DefinitionProxy_QNAME, DefinitionProxyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "seconds")
    public JAXBElement<BigDecimal> createSeconds(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Seconds_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "domainSet")
    public JAXBElement<DomainSetType> createDomainSet(DomainSetType value) {
        return new JAXBElement<DomainSetType>(_DomainSet_QNAME, DomainSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "MultiSurface", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometricAggregate")
    public JAXBElement<MultiSurfaceType> createMultiSurface(MultiSurfaceType value) {
        return new JAXBElement<MultiSurfaceType>(_MultiSurface_QNAME, MultiSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "minimumOccurs")
    public JAXBElement<BigInteger> createMinimumOccurs(BigInteger value) {
        return new JAXBElement<BigInteger>(_MinimumOccurs_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AngleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "angle")
    public JAXBElement<AngleType> createAngle(AngleType value) {
        return new JAXBElement<AngleType>(_Angle_QNAME, AngleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "axisAbbrev")
    public JAXBElement<CodeType> createAxisAbbrev(CodeType value) {
        return new JAXBElement<CodeType>(_AxisAbbrev_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoPrimitiveArrayAssociationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "topoPrimitiveMembers")
    public JAXBElement<TopoPrimitiveArrayAssociationType> createTopoPrimitiveMembers(TopoPrimitiveArrayAssociationType value) {
        return new JAXBElement<TopoPrimitiveArrayAssociationType>(_TopoPrimitiveMembers_QNAME, TopoPrimitiveArrayAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValuePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "includesValue", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "parameterValueProperty")
    public JAXBElement<AbstractGeneralParameterValuePropertyType> createIncludesValue(AbstractGeneralParameterValuePropertyType value) {
        return new JAXBElement<AbstractGeneralParameterValuePropertyType>(_IncludesValue_QNAME, AbstractGeneralParameterValuePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProjectedCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ProjectedCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeneralDerivedCRS")
    public JAXBElement<ProjectedCRSType> createProjectedCRS(ProjectedCRSType value) {
        return new JAXBElement<ProjectedCRSType>(_ProjectedCRS_QNAME, ProjectedCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "curveMember")
    public JAXBElement<CurvePropertyType> createCurveMember(CurvePropertyType value) {
        return new JAXBElement<CurvePropertyType>(_CurveMember_QNAME, CurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "decimalMinutes")
    public JAXBElement<BigDecimal> createDecimalMinutes(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DecimalMinutes_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "value")
    public JAXBElement<MeasureType> createValue(MeasureType value) {
        return new JAXBElement<MeasureType>(_Value_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "targetDimensions")
    public JAXBElement<BigInteger> createTargetDimensions(BigInteger value) {
        return new JAXBElement<BigInteger>(_TargetDimensions_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObliqueCartesianCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "obliqueCartesianCSRef")
    public JAXBElement<ObliqueCartesianCSPropertyType> createObliqueCartesianCSRef(ObliqueCartesianCSPropertyType value) {
        return new JAXBElement<ObliqueCartesianCSPropertyType>(_ObliqueCartesianCSRef_QNAME, ObliqueCartesianCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCalendarType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeCalendar", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "TimeReferenceSystem")
    public JAXBElement<TimeCalendarType> createTimeCalendar(TimeCalendarType value) {
        return new JAXBElement<TimeCalendarType>(_TimeCalendar_QNAME, TimeCalendarType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RectifiedGridType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "RectifiedGrid", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Grid")
    public JAXBElement<RectifiedGridType> createRectifiedGrid(RectifiedGridType value) {
        return new JAXBElement<RectifiedGridType>(_RectifiedGrid_QNAME, RectifiedGridType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimeObjectType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractTimeObject", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGML")
    public JAXBElement<AbstractTimeObjectType> createAbstractTimeObject(AbstractTimeObjectType value) {
        return new JAXBElement<AbstractTimeObjectType>(_AbstractTimeObject_QNAME, AbstractTimeObjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiCurveDomain", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "domainSet")
    public JAXBElement<DomainSetType> createMultiCurveDomain(DomainSetType value) {
        return new JAXBElement<DomainSetType>(_MultiCurveDomain_QNAME, DomainSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SphericalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "sphericalCSRef")
    public JAXBElement<SphericalCSPropertyType> createSphericalCSRef(SphericalCSPropertyType value) {
        return new JAXBElement<SphericalCSPropertyType>(_SphericalCSRef_QNAME, SphericalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateOperationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "coordinateOperationRef")
    public JAXBElement<CoordinateOperationPropertyType> createCoordinateOperationRef(CoordinateOperationPropertyType value) {
        return new JAXBElement<CoordinateOperationPropertyType>(_CoordinateOperationRef_QNAME, CoordinateOperationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiscreteCoverageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "RectifiedGridCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractDiscreteCoverage")
    public JAXBElement<DiscreteCoverageType> createRectifiedGridCoverage(DiscreteCoverageType value) {
        return new JAXBElement<DiscreteCoverageType>(_RectifiedGridCoverage_QNAME, DiscreteCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "booleanValue")
    public JAXBElement<java.lang.Boolean> createBooleanValue(java.lang.Boolean value) {
        return new JAXBElement<java.lang.Boolean>(_BooleanValue_QNAME, java.lang.Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoComplexPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "topoComplexProperty")
    public JAXBElement<TopoComplexPropertyType> createTopoComplexProperty(TopoComplexPropertyType value) {
        return new JAXBElement<TopoComplexPropertyType>(_TopoComplexProperty_QNAME, TopoComplexPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "interior")
    public JAXBElement<AbstractRingPropertyType> createInterior(AbstractRingPropertyType value) {
        return new JAXBElement<AbstractRingPropertyType>(_Interior_QNAME, AbstractRingPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeatureCollectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "FeatureCollection", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<FeatureCollectionType> createFeatureCollection(FeatureCollectionType value) {
        return new JAXBElement<FeatureCollectionType>(_FeatureCollection_QNAME, FeatureCollectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "location")
    public JAXBElement<LocationPropertyType> createLocation(LocationPropertyType value) {
        return new JAXBElement<LocationPropertyType>(_Location_QNAME, LocationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "temporalCSRef")
    public JAXBElement<TemporalCSPropertyType> createTemporalCSRef(TemporalCSPropertyType value) {
        return new JAXBElement<TemporalCSPropertyType>(_TemporalCSRef_QNAME, TemporalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoComplexPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "subComplex")
    public JAXBElement<TopoComplexPropertyType> createSubComplex(TopoComplexPropertyType value) {
        return new JAXBElement<TopoComplexPropertyType>(_SubComplex_QNAME, TopoComplexPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "minimumValue")
    public JAXBElement<Double> createMinimumValue(Double value) {
        return new JAXBElement<Double>(_MinimumValue_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoPointPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "topoPointProperty")
    public JAXBElement<TopoPointPropertyType> createTopoPointProperty(TopoPointPropertyType value) {
        return new JAXBElement<TopoPointPropertyType>(_TopoPointProperty_QNAME, TopoPointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConversionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Conversion", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeneralConversion")
    public JAXBElement<ConversionType> createConversion(ConversionType value) {
        return new JAXBElement<ConversionType>(_Conversion_QNAME, ConversionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "crsRef")
    public JAXBElement<CRSPropertyType> createCrsRef(CRSPropertyType value) {
        return new JAXBElement<CRSPropertyType>(_CrsRef_QNAME, CRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "valueList")
    public JAXBElement<MeasureListType> createValueList(MeasureListType value) {
        return new JAXBElement<MeasureListType>(_ValueList_QNAME, MeasureListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateOperationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesOperation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "coordOperation")
    public JAXBElement<CoordinateOperationPropertyType> createUsesOperation(CoordinateOperationPropertyType value) {
        return new JAXBElement<CoordinateOperationPropertyType>(_UsesOperation_QNAME, CoordinateOperationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "valueOfParameter", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "operationParameterProperty")
    public JAXBElement<OperationParameterPropertyType> createValueOfParameter(OperationParameterPropertyType value) {
        return new JAXBElement<OperationParameterPropertyType>(_ValueOfParameter_QNAME, OperationParameterPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrimeMeridianPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesPrimeMeridian", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "primeMeridianProperty")
    public JAXBElement<PrimeMeridianPropertyType> createUsesPrimeMeridian(PrimeMeridianPropertyType value) {
        return new JAXBElement<PrimeMeridianPropertyType>(_UsesPrimeMeridian_QNAME, PrimeMeridianPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "abstractGeneralOperationParameterRef")
    public JAXBElement<AbstractGeneralOperationParameterPropertyType> createAbstractGeneralOperationParameterRef(AbstractGeneralOperationParameterPropertyType value) {
        return new JAXBElement<AbstractGeneralOperationParameterPropertyType>(_AbstractGeneralOperationParameterRef_QNAME, AbstractGeneralOperationParameterPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiGeometryPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiGeometryProperty")
    public JAXBElement<MultiGeometryPropertyType> createMultiGeometryProperty(MultiGeometryPropertyType value) {
        return new JAXBElement<MultiGeometryPropertyType>(_MultiGeometryProperty_QNAME, MultiGeometryPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiCenterOf")
    public JAXBElement<MultiPointPropertyType> createMultiCenterOf(MultiPointPropertyType value) {
        return new JAXBElement<MultiPointPropertyType>(_MultiCenterOf_QNAME, MultiPointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinatesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "tupleList")
    public JAXBElement<CoordinatesType> createTupleList(CoordinatesType value) {
        return new JAXBElement<CoordinatesType>(_TupleList_QNAME, CoordinatesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractScalarValue", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractValue")
    public JAXBElement<Object> createAbstractScalarValue(Object value) {
        return new JAXBElement<Object>(_AbstractScalarValue_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "MultiCurve", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometricAggregate")
    public JAXBElement<MultiCurveType> createMultiCurve(MultiCurveType value) {
        return new JAXBElement<MultiCurveType>(_MultiCurve_QNAME, MultiCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinatesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "coordinates")
    public JAXBElement<CoordinatesType> createCoordinates(CoordinatesType value) {
        return new JAXBElement<CoordinatesType>(_Coordinates_QNAME, CoordinatesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EngineeringDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesEngineeringDatum", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "engineeringDatumProperty")
    public JAXBElement<EngineeringDatumPropertyType> createUsesEngineeringDatum(EngineeringDatumPropertyType value) {
        return new JAXBElement<EngineeringDatumPropertyType>(_UsesEngineeringDatum_QNAME, EngineeringDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeographicCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "geographicCRSRef")
    public JAXBElement<GeographicCRSPropertyType> createGeographicCRSRef(GeographicCRSPropertyType value) {
        return new JAXBElement<GeographicCRSPropertyType>(_GeographicCRSRef_QNAME, GeographicCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "pointArrayProperty")
    public JAXBElement<PointArrayPropertyType> createPointArrayProperty(PointArrayPropertyType value) {
        return new JAXBElement<PointArrayPropertyType>(_PointArrayProperty_QNAME, PointArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesParameter", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "generalOperationParameter")
    public JAXBElement<AbstractGeneralOperationParameterPropertyType> createUsesParameter(AbstractGeneralOperationParameterPropertyType value) {
        return new JAXBElement<AbstractGeneralOperationParameterPropertyType>(_UsesParameter_QNAME, AbstractGeneralOperationParameterPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractFeatureCollectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractFeatureCollection", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<AbstractFeatureCollectionType> createAbstractFeatureCollection(AbstractFeatureCollectionType value) {
        return new JAXBElement<AbstractFeatureCollectionType>(_AbstractFeatureCollection_QNAME, AbstractFeatureCollectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BagType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Bag", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGML")
    public JAXBElement<BagType> createBag(BagType value) {
        return new JAXBElement<BagType>(_Bag_QNAME, BagType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCalendarEraType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeCalendarEra")
    public JAXBElement<TimeCalendarEraType> createTimeCalendarEra(TimeCalendarEraType value) {
        return new JAXBElement<TimeCalendarEraType>(_TimeCalendarEra_QNAME, TimeCalendarEraType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ellipsoidalCSProperty")
    public JAXBElement<EllipsoidalCSPropertyType> createEllipsoidalCSProperty(EllipsoidalCSPropertyType value) {
        return new JAXBElement<EllipsoidalCSPropertyType>(_EllipsoidalCSProperty_QNAME, EllipsoidalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "scope")
    public JAXBElement<String> createScope(String value) {
        return new JAXBElement<String>(_Scope_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConversionToPreferredUnitType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "conversionToPreferredUnit")
    public JAXBElement<ConversionToPreferredUnitType> createConversionToPreferredUnit(ConversionToPreferredUnitType value) {
        return new JAXBElement<ConversionToPreferredUnitType>(_ConversionToPreferredUnit_QNAME, ConversionToPreferredUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffsetCurveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "OffsetCurve", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurveSegment")
    public JAXBElement<OffsetCurveType> createOffsetCurve(OffsetCurveType value) {
        return new JAXBElement<OffsetCurveType>(_OffsetCurve_QNAME, OffsetCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidalCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "EllipsoidalCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<EllipsoidalCSType> createEllipsoidalCS(EllipsoidalCSType value) {
        return new JAXBElement<EllipsoidalCSType>(_EllipsoidalCS_QNAME, EllipsoidalCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurveArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "curveArrayProperty")
    public JAXBElement<CurveArrayPropertyType> createCurveArrayProperty(CurveArrayPropertyType value) {
        return new JAXBElement<CurveArrayPropertyType>(_CurveArrayProperty_QNAME, CurveArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractContinuousCoverageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractContinuousCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<AbstractContinuousCoverageType> createAbstractContinuousCoverage(AbstractContinuousCoverageType value) {
        return new JAXBElement<AbstractContinuousCoverageType>(_AbstractContinuousCoverage_QNAME, AbstractContinuousCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GridFunctionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "GridFunction", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<GridFunctionType> createGridFunction(GridFunctionType value) {
        return new JAXBElement<GridFunctionType>(_GridFunction_QNAME, GridFunctionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "pointRep")
    public JAXBElement<PointPropertyType> createPointRep(PointPropertyType value) {
        return new JAXBElement<PointPropertyType>(_PointRep_QNAME, PointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "centerOf")
    public JAXBElement<PointPropertyType> createCenterOf(PointPropertyType value) {
        return new JAXBElement<PointPropertyType>(_CenterOf_QNAME, PointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedFacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "directedFace")
    public JAXBElement<DirectedFacePropertyType> createDirectedFace(DirectedFacePropertyType value) {
        return new JAXBElement<DirectedFacePropertyType>(_DirectedFace_QNAME, DirectedFacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EngineeringCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "EngineeringCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSingleCRS")
    public JAXBElement<EngineeringCRSType> createEngineeringCRS(EngineeringCRSType value) {
        return new JAXBElement<EngineeringCRSType>(_EngineeringCRS_QNAME, EngineeringCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PriorityLocationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "priorityLocation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "location")
    public JAXBElement<PriorityLocationPropertyType> createPriorityLocation(PriorityLocationPropertyType value) {
        return new JAXBElement<PriorityLocationPropertyType>(_PriorityLocation_QNAME, PriorityLocationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "gmlProfileSchema")
    public JAXBElement<String> createGmlProfileSchema(String value) {
        return new JAXBElement<String>(_GmlProfileSchema_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SphericalCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "SphericalCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<SphericalCSType> createSphericalCS(SphericalCSType value) {
        return new JAXBElement<SphericalCSType>(_SphericalCS_QNAME, SphericalCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateOperationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesSingleOperation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "coordOperation")
    public JAXBElement<CoordinateOperationPropertyType> createUsesSingleOperation(CoordinateOperationPropertyType value) {
        return new JAXBElement<CoordinateOperationPropertyType>(_UsesSingleOperation_QNAME, CoordinateOperationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TriangleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Triangle", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSurfacePatch")
    public JAXBElement<TriangleType> createTriangle(TriangleType value) {
        return new JAXBElement<TriangleType>(_Triangle_QNAME, TriangleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoSolidType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TopoSolid", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTopoPrimitive")
    public JAXBElement<TopoSolidType> createTopoSolid(TopoSolidType value) {
        return new JAXBElement<TopoSolidType>(_TopoSolid_QNAME, TopoSolidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociationRoleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "abstractAssociationRole")
    public JAXBElement<AssociationRoleType> createAbstractAssociationRole(AssociationRoleType value) {
        return new JAXBElement<AssociationRoleType>(_AbstractAssociationRole_QNAME, AssociationRoleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CartesianCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "cartesianCSProperty")
    public JAXBElement<CartesianCSPropertyType> createCartesianCSProperty(CartesianCSPropertyType value) {
        return new JAXBElement<CartesianCSPropertyType>(_CartesianCSProperty_QNAME, CartesianCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeocentricCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "geocentricCRSRef")
    public JAXBElement<GeocentricCRSPropertyType> createGeocentricCRSRef(GeocentricCRSPropertyType value) {
        return new JAXBElement<GeocentricCRSPropertyType>(_GeocentricCRSRef_QNAME, GeocentricCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiLocation")
    public JAXBElement<MultiPointPropertyType> createMultiLocation(MultiPointPropertyType value) {
        return new JAXBElement<MultiPointPropertyType>(_MultiLocation_QNAME, MultiPointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractFeatureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractFeature", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGML")
    public JAXBElement<AbstractFeatureType> createAbstractFeature(AbstractFeatureType value) {
        return new JAXBElement<AbstractFeatureType>(_AbstractFeature_QNAME, AbstractFeatureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransformationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Transformation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeneralTransformation")
    public JAXBElement<TransformationType> createTransformation(TransformationType value) {
        return new JAXBElement<TransformationType>(_Transformation_QNAME, TransformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePatchArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "trianglePatches", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "patches")
    public JAXBElement<SurfacePatchArrayPropertyType> createTrianglePatches(SurfacePatchArrayPropertyType value) {
        return new JAXBElement<SurfacePatchArrayPropertyType>(_TrianglePatches_QNAME, SurfacePatchArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeClockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeClock", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "TimeReferenceSystem")
    public JAXBElement<TimeClockType> createTimeClock(TimeClockType value) {
        return new JAXBElement<TimeClockType>(_TimeClock_QNAME, TimeClockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "featureProperty")
    public JAXBElement<FeaturePropertyType> createFeatureProperty(FeaturePropertyType value) {
        return new JAXBElement<FeaturePropertyType>(_FeatureProperty_QNAME, FeaturePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinearCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "LinearCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<LinearCSType> createLinearCS(LinearCSType value) {
        return new JAXBElement<LinearCSType>(_LinearCS_QNAME, LinearCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTopoPrimitiveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractTopoPrimitive", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTopology")
    public JAXBElement<AbstractTopoPrimitiveType> createAbstractTopoPrimitive(AbstractTopoPrimitiveType value) {
        return new JAXBElement<AbstractTopoPrimitiveType>(_AbstractTopoPrimitive_QNAME, AbstractTopoPrimitiveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "singleCRSRef")
    public JAXBElement<SingleCRSPropertyType> createSingleCRSRef(SingleCRSPropertyType value) {
        return new JAXBElement<SingleCRSPropertyType>(_SingleCRSRef_QNAME, SingleCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndirectEntryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "indirectEntry")
    public JAXBElement<IndirectEntryType> createIndirectEntry(IndirectEntryType value) {
        return new JAXBElement<IndirectEntryType>(_IndirectEntry_QNAME, IndirectEntryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "verticalCSProperty")
    public JAXBElement<VerticalCSPropertyType> createVerticalCSProperty(VerticalCSPropertyType value) {
        return new JAXBElement<VerticalCSPropertyType>(_VerticalCSProperty_QNAME, VerticalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BezierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Bezier", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "BSpline")
    public JAXBElement<BezierType> createBezier(BezierType value) {
        return new JAXBElement<BezierType>(_Bezier_QNAME, BezierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "operationParameterProperty")
    public JAXBElement<OperationParameterPropertyType> createOperationParameterProperty(OperationParameterPropertyType value) {
        return new JAXBElement<OperationParameterPropertyType>(_OperationParameterProperty_QNAME, OperationParameterPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "operationParameterRef")
    public JAXBElement<OperationParameterPropertyType> createOperationParameterRef(OperationParameterPropertyType value) {
        return new JAXBElement<OperationParameterPropertyType>(_OperationParameterRef_QNAME, OperationParameterPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralTransformationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractGeneralTransformation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractOperation")
    public JAXBElement<AbstractGeneralTransformationType> createAbstractGeneralTransformation(AbstractGeneralTransformationType value) {
        return new JAXBElement<AbstractGeneralTransformationType>(_AbstractGeneralTransformation_QNAME, AbstractGeneralTransformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedObservationAtDistanceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "DirectedObservationAtDistance", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "DirectedObservation")
    public JAXBElement<DirectedObservationAtDistanceType> createDirectedObservationAtDistance(DirectedObservationAtDistanceType value) {
        return new JAXBElement<DirectedObservationAtDistanceType>(_DirectedObservationAtDistance_QNAME, DirectedObservationAtDistanceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePatchArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "patches")
    public JAXBElement<SurfacePatchArrayPropertyType> createPatches(SurfacePatchArrayPropertyType value) {
        return new JAXBElement<SurfacePatchArrayPropertyType>(_Patches_QNAME, SurfacePatchArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesEllipsoidalCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "ellipsoidalCSProperty")
    public JAXBElement<EllipsoidalCSPropertyType> createUsesEllipsoidalCS(EllipsoidalCSPropertyType value) {
        return new JAXBElement<EllipsoidalCSPropertyType>(_UsesEllipsoidalCS_QNAME, EllipsoidalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "edgeOf")
    public JAXBElement<CurvePropertyType> createEdgeOf(CurvePropertyType value) {
        return new JAXBElement<CurvePropertyType>(_EdgeOf_QNAME, CurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeometryArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "geometryMembers")
    public JAXBElement<GeometryArrayPropertyType> createGeometryMembers(GeometryArrayPropertyType value) {
        return new JAXBElement<GeometryArrayPropertyType>(_GeometryMembers_QNAME, GeometryArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinearCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "linearCSRef")
    public JAXBElement<LinearCSPropertyType> createLinearCSRef(LinearCSPropertyType value) {
        return new JAXBElement<LinearCSPropertyType>(_LinearCSRef_QNAME, LinearCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryEntryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "dictionaryEntry")
    public JAXBElement<DictionaryEntryType> createDictionaryEntry(DictionaryEntryType value) {
        return new JAXBElement<DictionaryEntryType>(_DictionaryEntry_QNAME, DictionaryEntryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "LocationKeyWord")
    public JAXBElement<CodeType> createLocationKeyWord(CodeType value) {
        return new JAXBElement<CodeType>(_LocationKeyWord_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "imageDatumProperty")
    public JAXBElement<ImageDatumPropertyType> createImageDatumProperty(ImageDatumPropertyType value) {
        return new JAXBElement<ImageDatumPropertyType>(_ImageDatumProperty_QNAME, ImageDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ImageCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSingleCRS")
    public JAXBElement<ImageCRSType> createImageCRS(ImageCRSType value) {
        return new JAXBElement<ImageCRSType>(_ImageCRS_QNAME, ImageCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "coordinateSystem")
    public JAXBElement<CoordinateSystemPropertyType> createUsesCS(CoordinateSystemPropertyType value) {
        return new JAXBElement<CoordinateSystemPropertyType>(_UsesCS_QNAME, CoordinateSystemPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractSingleOperation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateOperation")
    public JAXBElement<AbstractCoordinateOperationType> createAbstractSingleOperation(AbstractCoordinateOperationType value) {
        return new JAXBElement<AbstractCoordinateOperationType>(_AbstractSingleOperation_QNAME, AbstractCoordinateOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinearCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "linearCSProperty")
    public JAXBElement<LinearCSPropertyType> createLinearCSProperty(LinearCSPropertyType value) {
        return new JAXBElement<LinearCSPropertyType>(_LinearCSProperty_QNAME, LinearCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "VerticalCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSingleCRS")
    public JAXBElement<VerticalCRSType> createVerticalCRS(VerticalCRSType value) {
        return new JAXBElement<VerticalCRSType>(_VerticalCRS_QNAME, VerticalCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeInstantType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeInstant", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTimeGeometricPrimitive")
    public JAXBElement<TimeInstantType> createTimeInstant(TimeInstantType value) {
        return new JAXBElement<TimeInstantType>(_TimeInstant_QNAME, TimeInstantType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GridType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Grid", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractImplicitGeometry")
    public JAXBElement<GridType> createGrid(GridType value) {
        return new JAXBElement<GridType>(_Grid_QNAME, GridType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}}
     * 
     
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractGeometry", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGML")
    public JAXBElement<AbstractGeometryType> createAbstractGeometry(AbstractGeometryType value) {
        return new JAXBElement<AbstractGeometryType>(_AbstractGeometry_QNAME, AbstractGeometryType.class, null, value);
    }*/

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimeGeometricPrimitiveType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractTimeGeometricPrimitive", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTimePrimitive")
    public JAXBElement<AbstractTimeGeometricPrimitiveType> createAbstractTimeGeometricPrimitive(AbstractTimeGeometricPrimitiveType value) {
        return new JAXBElement<AbstractTimeGeometricPrimitiveType>(_AbstractTimeGeometricPrimitive_QNAME, AbstractTimeGeometricPrimitiveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CylinderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Cylinder", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGriddedSurface")
    public JAXBElement<CylinderType> createCylinder(CylinderType value) {
        return new JAXBElement<CylinderType>(_Cylinder_QNAME, CylinderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurveSegmentArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "segments")
    public JAXBElement<CurveSegmentArrayPropertyType> createSegments(CurveSegmentArrayPropertyType value) {
        return new JAXBElement<CurveSegmentArrayPropertyType>(_Segments_QNAME, CurveSegmentArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleOperationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "singleOperationRef")
    public JAXBElement<SingleOperationPropertyType> createSingleOperationRef(SingleOperationPropertyType value) {
        return new JAXBElement<SingleOperationPropertyType>(_SingleOperationRef_QNAME, SingleOperationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TargetPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "subject", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "target")
    public JAXBElement<TargetPropertyType> createSubject(TargetPropertyType value) {
        return new JAXBElement<TargetPropertyType>(_Subject_QNAME, TargetPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationMethodPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "method")
    public JAXBElement<OperationMethodPropertyType> createMethod(OperationMethodPropertyType value) {
        return new JAXBElement<OperationMethodPropertyType>(_Method_QNAME, OperationMethodPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link BigInteger }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "integerValueList")
    public JAXBElement<List<BigInteger>> createIntegerValueList(List<BigInteger> value) {
        return new JAXBElement<List<BigInteger>>(_IntegerValueList_QNAME, ((Class) List.class), null, ((List<BigInteger> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "anchorPoint", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "anchorDefinition")
    public JAXBElement<CodeType> createAnchorPoint(CodeType value) {
        return new JAXBElement<CodeType>(_AnchorPoint_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodesicStringType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "GeodesicString", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurveSegment")
    public JAXBElement<GeodesicStringType> createGeodesicString(GeodesicStringType value) {
        return new JAXBElement<GeodesicStringType>(_GeodesicString_QNAME, GeodesicStringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationMethodPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesMethod", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "method")
    public JAXBElement<OperationMethodPropertyType> createUsesMethod(OperationMethodPropertyType value) {
        return new JAXBElement<OperationMethodPropertyType>(_UsesMethod_QNAME, OperationMethodPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefinitionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Definition", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGML")
    public JAXBElement<DefinitionType> createDefinition(DefinitionType value) {
        return new JAXBElement<DefinitionType>(_Definition_QNAME, DefinitionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrimeMeridianPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "primeMeridianProperty")
    public JAXBElement<PrimeMeridianPropertyType> createPrimeMeridianProperty(PrimeMeridianPropertyType value) {
        return new JAXBElement<PrimeMeridianPropertyType>(_PrimeMeridianProperty_QNAME, PrimeMeridianPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "featureMember")
    public JAXBElement<FeaturePropertyType> createFeatureMember(FeaturePropertyType value) {
        return new JAXBElement<FeaturePropertyType>(_FeatureMember_QNAME, FeaturePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodeticDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "geodeticDatumProperty")
    public JAXBElement<GeodeticDatumPropertyType> createGeodeticDatumProperty(GeodeticDatumPropertyType value) {
        return new JAXBElement<GeodeticDatumPropertyType>(_GeodeticDatumProperty_QNAME, GeodeticDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValueArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "valueComponents")
    public JAXBElement<ValueArrayPropertyType> createValueComponents(ValueArrayPropertyType value) {
        return new JAXBElement<ValueArrayPropertyType>(_ValueComponents_QNAME, ValueArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "quantityType")
    public JAXBElement<StringOrRefType> createQuantityType(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_QuantityType_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "LocationString")
    public JAXBElement<StringOrRefType> createLocationString(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_LocationString_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemAxisPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesAxis", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "axis")
    public JAXBElement<CoordinateSystemAxisPropertyType> createUsesAxis(CoordinateSystemAxisPropertyType value) {
        return new JAXBElement<CoordinateSystemAxisPropertyType>(_UsesAxis_QNAME, CoordinateSystemAxisPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeometricAggregateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractGeometricAggregate", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometry")
    public JAXBElement<AbstractGeometricAggregateType> createAbstractGeometricAggregate(AbstractGeometricAggregateType value) {
        return new JAXBElement<AbstractGeometricAggregateType>(_AbstractGeometricAggregate_QNAME, AbstractGeometricAggregateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SphericalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "sphericalCSProperty")
    public JAXBElement<SphericalCSPropertyType> createSphericalCSProperty(SphericalCSPropertyType value) {
        return new JAXBElement<SphericalCSPropertyType>(_SphericalCSProperty_QNAME, SphericalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleCRSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "baseCRS")
    public JAXBElement<SingleCRSPropertyType> createBaseCRS(SingleCRSPropertyType value) {
        return new JAXBElement<SingleCRSPropertyType>(_BaseCRS_QNAME, SingleCRSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "solidMembers")
    public JAXBElement<SolidArrayPropertyType> createSolidMembers(SolidArrayPropertyType value) {
        return new JAXBElement<SolidArrayPropertyType>(_SolidMembers_QNAME, SolidArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CircleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Circle", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Arc")
    public JAXBElement<CircleType> createCircle(CircleType value) {
        return new JAXBElement<CircleType>(_Circle_QNAME, CircleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "curveProperty")
    public JAXBElement<CurvePropertyType> createCurveProperty(CurvePropertyType value) {
        return new JAXBElement<CurvePropertyType>(_CurveProperty_QNAME, CurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrimeMeridianType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "PrimeMeridian", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<PrimeMeridianType> createPrimeMeridian(PrimeMeridianType value) {
        return new JAXBElement<PrimeMeridianType>(_PrimeMeridian_QNAME, PrimeMeridianType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "verticalDatumProperty")
    public JAXBElement<VerticalDatumPropertyType> createVerticalDatumProperty(VerticalDatumPropertyType value) {
        return new JAXBElement<VerticalDatumPropertyType>(_VerticalDatumProperty_QNAME, VerticalDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConventionalUnitType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ConventionalUnit", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "UnitDefinition")
    public JAXBElement<ConventionalUnitType> createConventionalUnit(ConventionalUnitType value) {
        return new JAXBElement<ConventionalUnitType>(_ConventionalUnit_QNAME, ConventionalUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfaceArrayPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "surfaceMembers")
    public JAXBElement<SurfaceArrayPropertyType> createSurfaceMembers(SurfaceArrayPropertyType value) {
        return new JAXBElement<SurfaceArrayPropertyType>(_SurfaceMembers_QNAME, SurfaceArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "VerticalCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<VerticalCSType> createVerticalCS(VerticalCSType value) {
        return new JAXBElement<VerticalCSType>(_VerticalCS_QNAME, VerticalCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "description")
    public JAXBElement<StringOrRefType> createDescription(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_Description_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeometricComplexType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "GeometricComplex", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometry")
    public JAXBElement<GeometricComplexType> createGeometricComplex(GeometricComplexType value) {
        return new JAXBElement<GeometricComplexType>(_GeometricComplex_QNAME, GeometricComplexType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "usesVerticalCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "verticalCSProperty")
    public JAXBElement<VerticalCSPropertyType> createUsesVerticalCS(VerticalCSPropertyType value) {
        return new JAXBElement<VerticalCSPropertyType>(_UsesVerticalCS_QNAME, VerticalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "operationRef")
    public JAXBElement<OperationPropertyType> createOperationRef(OperationPropertyType value) {
        return new JAXBElement<OperationPropertyType>(_OperationRef_QNAME, OperationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TriangulatedSurface", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Surface")
    public JAXBElement<SurfaceType> createTriangulatedSurface(SurfaceType value) {
        return new JAXBElement<SurfaceType>(_TriangulatedSurface_QNAME, SurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "stringValue")
    public JAXBElement<String> createStringValue(String value) {
        return new JAXBElement<String>(_StringValue_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractGeneralOperationParameter", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<AbstractGeneralOperationParameterType> createAbstractGeneralOperationParameter(AbstractGeneralOperationParameterType value) {
        return new JAXBElement<AbstractGeneralOperationParameterType>(_AbstractGeneralOperationParameter_QNAME, AbstractGeneralOperationParameterType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractDatumType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractDatum", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<AbstractDatumType> createAbstractDatum(AbstractDatumType value) {
        return new JAXBElement<AbstractDatumType>(_AbstractDatum_QNAME, AbstractDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantityExtentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "QuantityExtent", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractValue")
    public JAXBElement<QuantityExtentType> createQuantityExtent(QuantityExtentType value) {
        return new JAXBElement<QuantityExtentType>(_QuantityExtent_QNAME, QuantityExtentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LineStringSegmentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "LineStringSegment", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCurveSegment")
    public JAXBElement<LineStringSegmentType> createLineStringSegment(LineStringSegmentType value) {
        return new JAXBElement<LineStringSegmentType>(_LineStringSegment_QNAME, LineStringSegmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateSystemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractCoordinateSystem", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<AbstractCoordinateSystemType> createAbstractCoordinateSystem(AbstractCoordinateSystemType value) {
        return new JAXBElement<AbstractCoordinateSystemType>(_AbstractCoordinateSystem_QNAME, AbstractCoordinateSystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeSurfaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CompositeSurface", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSurface")
    public JAXBElement<CompositeSurfaceType> createCompositeSurface(CompositeSurfaceType value) {
        return new JAXBElement<CompositeSurfaceType>(_CompositeSurface_QNAME, CompositeSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PassThroughOperationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "passThroughOperationRef")
    public JAXBElement<PassThroughOperationPropertyType> createPassThroughOperationRef(PassThroughOperationPropertyType value) {
        return new JAXBElement<PassThroughOperationPropertyType>(_PassThroughOperationRef_QNAME, PassThroughOperationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "solidProperty")
    public JAXBElement<SolidPropertyType> createSolidProperty(SolidPropertyType value) {
        return new JAXBElement<SolidPropertyType>(_SolidProperty_QNAME, SolidPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemAxisPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "coordinateSystemAxisRef")
    public JAXBElement<CoordinateSystemAxisPropertyType> createCoordinateSystemAxisRef(CoordinateSystemAxisPropertyType value) {
        return new JAXBElement<CoordinateSystemAxisPropertyType>(_CoordinateSystemAxisRef_QNAME, CoordinateSystemAxisPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiscreteCoverageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "GridCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractDiscreteCoverage")
    public JAXBElement<DiscreteCoverageType> createGridCoverage(DiscreteCoverageType value) {
        return new JAXBElement<DiscreteCoverageType>(_GridCoverage_QNAME, DiscreteCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimePrimitivePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "validTime")
    public JAXBElement<TimePrimitivePropertyType> createValidTime(TimePrimitivePropertyType value) {
        return new JAXBElement<TimePrimitivePropertyType>(_ValidTime_QNAME, TimePrimitivePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnitDefinitionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "UnitDefinition", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<UnitDefinitionType> createUnitDefinition(UnitDefinitionType value) {
        return new JAXBElement<UnitDefinitionType>(_UnitDefinition_QNAME, UnitDefinitionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoComplexPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "superComplex")
    public JAXBElement<TopoComplexPropertyType> createSuperComplex(TopoComplexPropertyType value) {
        return new JAXBElement<TopoComplexPropertyType>(_SuperComplex_QNAME, TopoComplexPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoverageFunctionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "coverageFunction", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<CoverageFunctionType> createCoverageFunction(CoverageFunctionType value) {
        return new JAXBElement<CoverageFunctionType>(_CoverageFunction_QNAME, CoverageFunctionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiscreteCoverageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "MultiSolidCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractDiscreteCoverage")
    public JAXBElement<DiscreteCoverageType> createMultiSolidCoverage(DiscreteCoverageType value) {
        return new JAXBElement<DiscreteCoverageType>(_MultiSolidCoverage_QNAME, DiscreteCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneralConversionPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "conversionProperty")
    public JAXBElement<GeneralConversionPropertyType> createConversionProperty(GeneralConversionPropertyType value) {
        return new JAXBElement<GeneralConversionPropertyType>(_ConversionProperty_QNAME, GeneralConversionPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RangeSetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "rangeSet")
    public JAXBElement<RangeSetType> createRangeSet(RangeSetType value) {
        return new JAXBElement<RangeSetType>(_RangeSet_QNAME, RangeSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayAssociationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "members")
    public JAXBElement<ArrayAssociationType> createMembers(ArrayAssociationType value) {
        return new JAXBElement<ArrayAssociationType>(_Members_QNAME, ArrayAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "PolyhedralSurface", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Surface")
    public JAXBElement<SurfaceType> createPolyhedralSurface(SurfaceType value) {
        return new JAXBElement<SurfaceType>(_PolyhedralSurface_QNAME, SurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "name")
    public JAXBElement<CodeType> createName(CodeType value) {
        return new JAXBElement<CodeType>(_Name_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "rectifiedGridDomain", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "domainSet")
    public JAXBElement<DomainSetType> createRectifiedGridDomain(DomainSetType value) {
        return new JAXBElement<DomainSetType>(_RectifiedGridDomain_QNAME, DomainSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TemporalCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSingleCRS")
    public JAXBElement<TemporalCRSType> createTemporalCRS(TemporalCRSType value) {
        return new JAXBElement<TemporalCRSType>(_TemporalCRS_QNAME, TemporalCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "remarks")
    public JAXBElement<String> createRemarks(String value) {
        return new JAXBElement<String>(_Remarks_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryExtentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CategoryExtent", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractValue")
    public JAXBElement<CategoryExtentType> createCategoryExtent(CategoryExtentType value) {
        return new JAXBElement<CategoryExtentType>(_CategoryExtent_QNAME, CategoryExtentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociationRoleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "rangeParameters")
    public JAXBElement<AssociationRoleType> createRangeParameters(AssociationRoleType value) {
        return new JAXBElement<AssociationRoleType>(_RangeParameters_QNAME, AssociationRoleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "measure")
    public JAXBElement<MeasureType> createMeasure(MeasureType value) {
        return new JAXBElement<MeasureType>(_Measure_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "realizationEpoch")
    public JAXBElement<XMLGregorianCalendar> createRealizationEpoch(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_RealizationEpoch_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConcatenatedOperationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "concatenatedOperationRef")
    public JAXBElement<ConcatenatedOperationPropertyType> createConcatenatedOperationRef(ConcatenatedOperationPropertyType value) {
        return new JAXBElement<ConcatenatedOperationPropertyType>(_ConcatenatedOperationRef_QNAME, ConcatenatedOperationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureOrNilReasonListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "QuantityList", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractScalarValueList")
    public JAXBElement<MeasureOrNilReasonListType> createQuantityList(MeasureOrNilReasonListType value) {
        return new JAXBElement<MeasureOrNilReasonListType>(_QuantityList_QNAME, MeasureOrNilReasonListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CountList", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractScalarValueList")
    public JAXBElement<List<String>> createCountList(List<String> value) {
        return new JAXBElement<List<String>>(_CountList_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "temporalDatumRef")
    public JAXBElement<TemporalDatumPropertyType> createTemporalDatumRef(TemporalDatumPropertyType value) {
        return new JAXBElement<TemporalDatumPropertyType>(_TemporalDatumRef_QNAME, TemporalDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterValueType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ParameterValue", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeneralParameterValue")
    public JAXBElement<ParameterValueType> createParameterValue(ParameterValueType value) {
        return new JAXBElement<ParameterValueType>(_ParameterValue_QNAME, ParameterValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolygonPatchType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "PolygonPatch", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSurfacePatch")
    public JAXBElement<PolygonPatchType> createPolygonPatch(PolygonPatchType value) {
        return new JAXBElement<PolygonPatchType>(_PolygonPatch_QNAME, PolygonPatchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractCoordinateOperation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<AbstractCoordinateOperationType> createAbstractCoordinateOperation(AbstractCoordinateOperationType value) {
        return new JAXBElement<AbstractCoordinateOperationType>(_AbstractCoordinateOperation_QNAME, AbstractCoordinateOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link net.opengis.gml._3.Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Boolean", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractScalarValue")
    public JAXBElement<org.geotoolkit.gml.xml.v321.Boolean> createBoolean(org.geotoolkit.gml.xml.v321.Boolean value) {
        return new JAXBElement<org.geotoolkit.gml.xml.v321.Boolean>(_Boolean_QNAME, org.geotoolkit.gml.xml.v321.Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractSolidType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractSolid", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometricPrimitive")
    public JAXBElement<AbstractSolidType> createAbstractSolid(AbstractSolidType value) {
        return new JAXBElement<AbstractSolidType>(_AbstractSolid_QNAME, AbstractSolidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AffinePlacementType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AffinePlacement", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<AffinePlacementType> createAffinePlacement(AffinePlacementType value) {
        return new JAXBElement<AffinePlacementType>(_AffinePlacement_QNAME, AffinePlacementType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemAxisPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "axis")
    public JAXBElement<CoordinateSystemAxisPropertyType> createAxis(CoordinateSystemAxisPropertyType value) {
        return new JAXBElement<CoordinateSystemAxisPropertyType>(_Axis_QNAME, CoordinateSystemAxisPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "surfaceProperty")
    public JAXBElement<SurfacePropertyType> createSurfaceProperty(SurfacePropertyType value) {
        return new JAXBElement<SurfacePropertyType>(_SurfaceProperty_QNAME, SurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCurveSegmentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractCurveSegment", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<AbstractCurveSegmentType> createAbstractCurveSegment(AbstractCurveSegmentType value) {
        return new JAXBElement<AbstractCurveSegmentType>(_AbstractCurveSegment_QNAME, AbstractCurveSegmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractImplicitGeometry", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometry")
    public JAXBElement<AbstractGeometryType> createAbstractImplicitGeometry(AbstractGeometryType value) {
        return new JAXBElement<AbstractGeometryType>(_AbstractImplicitGeometry_QNAME, AbstractGeometryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Surface", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSurface")
    public JAXBElement<SurfaceType> createSurface(SurfaceType value) {
        return new JAXBElement<SurfaceType>(_Surface_QNAME, SurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "maximumOccurs")
    public JAXBElement<BigInteger> createMaximumOccurs(BigInteger value) {
        return new JAXBElement<BigInteger>(_MaximumOccurs_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociationRoleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "abstractStrictAssociationRole")
    public JAXBElement<AssociationRoleType> createAbstractStrictAssociationRole(AssociationRoleType value) {
        return new JAXBElement<AssociationRoleType>(_AbstractStrictAssociationRole_QNAME, AssociationRoleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShellType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Shell", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<ShellType> createShell(ShellType value) {
        return new JAXBElement<ShellType>(_Shell_QNAME, ShellType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimeComplexType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractTimeComplex", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTimeObject")
    public JAXBElement<AbstractTimeComplexType> createAbstractTimeComplex(AbstractTimeComplexType value) {
        return new JAXBElement<AbstractTimeComplexType>(_AbstractTimeComplex_QNAME, AbstractTimeComplexType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Point", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeometricPrimitive")
    public JAXBElement<PointType> createPoint(PointType value) {
        return new JAXBElement<PointType>(_Point_QNAME, PointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCoverageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractFeature")
    public JAXBElement<AbstractCoverageType> createAbstractCoverage(AbstractCoverageType value) {
        return new JAXBElement<AbstractCoverageType>(_AbstractCoverage_QNAME, AbstractCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodeticCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "GeodeticCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSingleCRS")
    public JAXBElement<GeodeticCRSType> createGeodeticCRS(GeodeticCRSType value) {
        return new JAXBElement<GeodeticCRSType>(_GeodeticCRS_QNAME, GeodeticCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcedurePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "using")
    public JAXBElement<ProcedurePropertyType> createUsing(ProcedurePropertyType value) {
        return new JAXBElement<ProcedurePropertyType>(_Using_QNAME, ProcedurePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "OperationParameter", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractGeneralOperationParameter")
    public JAXBElement<OperationParameterType> createOperationParameter(OperationParameterType value) {
        return new JAXBElement<OperationParameterType>(_OperationParameter_QNAME, OperationParameterType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArcType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Arc", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "ArcString")
    public JAXBElement<ArcType> createArc(ArcType value) {
        return new JAXBElement<ArcType>(_Arc_QNAME, ArcType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DynamicFeatureMemberType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "dynamicMembers")
    public JAXBElement<DynamicFeatureMemberType> createDynamicMembers(DynamicFeatureMemberType value) {
        return new JAXBElement<DynamicFeatureMemberType>(_DynamicMembers_QNAME, DynamicFeatureMemberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PassThroughOperationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "PassThroughOperation", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSingleOperation")
    public JAXBElement<PassThroughOperationType> createPassThroughOperation(PassThroughOperationType value) {
        return new JAXBElement<PassThroughOperationType>(_PassThroughOperation_QNAME, PassThroughOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ellipsoidRef")
    public JAXBElement<EllipsoidPropertyType> createEllipsoidRef(EllipsoidPropertyType value) {
        return new JAXBElement<EllipsoidPropertyType>(_EllipsoidRef_QNAME, EllipsoidPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalDatumType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "VerticalDatum", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractDatum")
    public JAXBElement<VerticalDatumType> createVerticalDatum(VerticalDatumType value) {
        return new JAXBElement<VerticalDatumType>(_VerticalDatum_QNAME, VerticalDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "TimeCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<TimeCSType> createTimeCS(TimeCSType value) {
        return new JAXBElement<TimeCSType>(_TimeCS_QNAME, TimeCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "datumRef")
    public JAXBElement<DatumPropertyType> createDatumRef(DatumPropertyType value) {
        return new JAXBElement<DatumPropertyType>(_DatumRef_QNAME, DatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "pointProperty")
    public JAXBElement<PointPropertyType> createPointProperty(PointPropertyType value) {
        return new JAXBElement<PointPropertyType>(_PointProperty_QNAME, PointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "valueFile")
    public JAXBElement<String> createValueFile(String value) {
        return new JAXBElement<String>(_ValueFile_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolarCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "polarCSRef")
    public JAXBElement<PolarCSPropertyType> createPolarCSRef(PolarCSPropertyType value) {
        return new JAXBElement<PolarCSPropertyType>(_PolarCSRef_QNAME, PolarCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValueType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "AbstractGeneralParameterValue", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractObject")
    public JAXBElement<AbstractGeneralParameterValueType> createAbstractGeneralParameterValue(AbstractGeneralParameterValueType value) {
        return new JAXBElement<AbstractGeneralParameterValueType>(_AbstractGeneralParameterValue_QNAME, AbstractGeneralParameterValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Node", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTopoPrimitive")
    public JAXBElement<NodeType> createNode(NodeType value) {
        return new JAXBElement<NodeType>(_Node_QNAME, NodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeographicCRSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "GeographicCRS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSingleCRS")
    public JAXBElement<GeographicCRSType> createGeographicCRS(GeographicCRSType value) {
        return new JAXBElement<GeographicCRSType>(_GeographicCRS_QNAME, GeographicCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConversionPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "conversionRef")
    public JAXBElement<ConversionPropertyType> createConversionRef(ConversionPropertyType value) {
        return new JAXBElement<ConversionPropertyType>(_ConversionRef_QNAME, ConversionPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InlinePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "abstractInlineProperty")
    public JAXBElement<InlinePropertyType> createAbstractInlineProperty(InlinePropertyType value) {
        return new JAXBElement<InlinePropertyType>(_AbstractInlineProperty_QNAME, InlinePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EdgeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Edge", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractTopoPrimitive")
    public JAXBElement<EdgeType> createEdge(EdgeType value) {
        return new JAXBElement<EdgeType>(_Edge_QNAME, EdgeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValuePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "valueComponent")
    public JAXBElement<ValuePropertyType> createValueComponent(ValuePropertyType value) {
        return new JAXBElement<ValuePropertyType>(_ValueComponent_QNAME, ValuePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "generalOperationParameter", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "parameter")
    public JAXBElement<AbstractGeneralOperationParameterPropertyType> createGeneralOperationParameter(AbstractGeneralOperationParameterPropertyType value) {
        return new JAXBElement<AbstractGeneralOperationParameterPropertyType>(_GeneralOperationParameter_QNAME, AbstractGeneralOperationParameterPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConversionToPreferredUnitType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "roughConversionToPreferredUnit")
    public JAXBElement<ConversionToPreferredUnitType> createRoughConversionToPreferredUnit(ConversionToPreferredUnitType value) {
        return new JAXBElement<ConversionToPreferredUnitType>(_RoughConversionToPreferredUnit_QNAME, ConversionToPreferredUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "catalogSymbol")
    public JAXBElement<CodeType> createCatalogSymbol(CodeType value) {
        return new JAXBElement<CodeType>(_CatalogSymbol_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DerivedUnitType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "DerivedUnit", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "UnitDefinition")
    public JAXBElement<DerivedUnitType> createDerivedUnit(DerivedUnitType value) {
        return new JAXBElement<DerivedUnitType>(_DerivedUnit_QNAME, DerivedUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DMSAngleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "dmsAngleValue")
    public JAXBElement<DMSAngleType> createDmsAngleValue(DMSAngleType value) {
        return new JAXBElement<DMSAngleType>(_DmsAngleValue_QNAME, DMSAngleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "extentOf")
    public JAXBElement<SurfacePropertyType> createExtentOf(SurfacePropertyType value) {
        return new JAXBElement<SurfacePropertyType>(_ExtentOf_QNAME, SurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CountExtent", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractValue")
    public JAXBElement<List<String>> createCountExtent(List<String> value) {
        return new JAXBElement<List<String>>(_CountExtent_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedEdgePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "directedEdge")
    public JAXBElement<DirectedEdgePropertyType> createDirectedEdge(DirectedEdgePropertyType value) {
        return new JAXBElement<DirectedEdgePropertyType>(_DirectedEdge_QNAME, DirectedEdgePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemAxisType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "CoordinateSystemAxis", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "Definition")
    public JAXBElement<CoordinateSystemAxisType> createCoordinateSystemAxis(CoordinateSystemAxisType value) {
        return new JAXBElement<CoordinateSystemAxisType>(_CoordinateSystemAxis_QNAME, CoordinateSystemAxisType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeWithAuthorityType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "derivedCRSType")
    public JAXBElement<CodeWithAuthorityType> createDerivedCRSType(CodeWithAuthorityType value) {
        return new JAXBElement<CodeWithAuthorityType>(_DerivedCRSType_QNAME, CodeWithAuthorityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValuePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "parameterValueProperty")
    public JAXBElement<AbstractGeneralParameterValuePropertyType> createParameterValueProperty(AbstractGeneralParameterValuePropertyType value) {
        return new JAXBElement<AbstractGeneralParameterValuePropertyType>(_ParameterValueProperty_QNAME, AbstractGeneralParameterValuePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Ring", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractRing")
    public JAXBElement<RingType> createRing(RingType value) {
        return new JAXBElement<RingType>(_Ring_QNAME, RingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoVolumePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "topoVolumeProperty")
    public JAXBElement<TopoVolumePropertyType> createTopoVolumeProperty(TopoVolumePropertyType value) {
        return new JAXBElement<TopoVolumePropertyType>(_TopoVolumeProperty_QNAME, TopoVolumePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RectangleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Rectangle", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSurfacePatch")
    public JAXBElement<RectangleType> createRectangle(RectangleType value) {
        return new JAXBElement<RectangleType>(_Rectangle_QNAME, RectangleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DerivationUnitTermType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "derivationUnitTerm")
    public JAXBElement<DerivationUnitTermType> createDerivationUnitTerm(DerivationUnitTermType value) {
        return new JAXBElement<DerivationUnitTermType>(_DerivationUnitTerm_QNAME, DerivationUnitTermType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CylindricalCSPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "cylindricalCSProperty")
    public JAXBElement<CylindricalCSPropertyType> createCylindricalCSProperty(CylindricalCSPropertyType value) {
        return new JAXBElement<CylindricalCSPropertyType>(_CylindricalCSProperty_QNAME, CylindricalCSPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EngineeringDatumPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "engineeringDatumProperty")
    public JAXBElement<EngineeringDatumPropertyType> createEngineeringDatumProperty(EngineeringDatumPropertyType value) {
        return new JAXBElement<EngineeringDatumPropertyType>(_EngineeringDatumProperty_QNAME, EngineeringDatumPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObliqueCartesianCSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "ObliqueCartesianCS", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractCoordinateSystem")
    public JAXBElement<ObliqueCartesianCSType> createObliqueCartesianCS(ObliqueCartesianCSType value) {
        return new JAXBElement<ObliqueCartesianCSType>(_ObliqueCartesianCS_QNAME, ObliqueCartesianCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HistoryPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "history")
    public JAXBElement<HistoryPropertyType> createHistory(HistoryPropertyType value) {
        return new JAXBElement<HistoryPropertyType>(_History_QNAME, HistoryPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolygonType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Polygon", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSurface")
    public JAXBElement<PolygonType> createPolygon(PolygonType value) {
        return new JAXBElement<PolygonType>(_Polygon_QNAME, PolygonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "multiCoverage")
    public JAXBElement<MultiSurfacePropertyType> createMultiCoverage(MultiSurfacePropertyType value) {
        return new JAXBElement<MultiSurfacePropertyType>(_MultiCoverage_QNAME, MultiSurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "solidMember")
    public JAXBElement<SolidPropertyType> createSolidMember(SolidPropertyType value) {
        return new JAXBElement<SolidPropertyType>(_SolidMember_QNAME, SolidPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodesicType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "Geodesic", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "GeodesicString")
    public JAXBElement<GeodesicType> createGeodesic(GeodesicType value) {
        return new JAXBElement<GeodesicType>(_Geodesic_QNAME, GeodesicType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociationRoleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "member")
    public JAXBElement<AssociationRoleType> createMember(AssociationRoleType value) {
        return new JAXBElement<AssociationRoleType>(_Member_QNAME, AssociationRoleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "maximumValue")
    public JAXBElement<Double> createMaximumValue(Double value) {
        return new JAXBElement<Double>(_MaximumValue_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "anchorDefinition")
    public JAXBElement<CodeType> createAnchorDefinition(CodeType value) {
        return new JAXBElement<CodeType>(_AnchorDefinition_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrientableSurfaceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "OrientableSurface", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractSurface")
    public JAXBElement<OrientableSurfaceType> createOrientableSurface(OrientableSurfaceType value) {
        return new JAXBElement<OrientableSurfaceType>(_OrientableSurface_QNAME, OrientableSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "BooleanList", substitutionHeadNamespace = "http://www.opengis.net/gml/3.2", substitutionHeadName = "AbstractScalarValueList")
    public JAXBElement<List<String>> createBooleanList(List<String> value) {
        return new JAXBElement<List<String>>(_BooleanList_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateOperationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "coordOperation")
    public JAXBElement<CoordinateOperationPropertyType> createCoordOperation(CoordinateOperationPropertyType value) {
        return new JAXBElement<CoordinateOperationPropertyType>(_CoordOperation_QNAME, CoordinateOperationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GridLimitsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "limits", scope = GridType.class)
    public JAXBElement<GridLimitsType> createGridTypeLimits(GridLimitsType value) {
        return new JAXBElement<GridLimitsType>(_GridTypeLimits_QNAME, GridLimitsType.class, GridType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "axisLabels", scope = GridType.class)
    public JAXBElement<List<String>> createGridTypeAxisLabels(List<String> value) {
        return new JAXBElement<List<String>>(_GridTypeAxisLabels_QNAME, ((Class) List.class), GridType.class, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "axisName", scope = GridType.class)
    public JAXBElement<String> createGridTypeAxisName(String value) {
        return new JAXBElement<String>(_GridTypeAxisName_QNAME, String.class, GridType.class, value);
    }
    
    public JAXBElement<?> buildAnyGeometry(final Object value) {
        if (value instanceof PointType) {
            return createPoint((PointType) value);

        } else if (value instanceof MultiPointType) {
            return createMultiPoint((MultiPointType) value);

        } else if (value instanceof MultiSurfaceType) {
            return createMultiSurface((MultiSurfaceType) value);

        } else if (value instanceof MultiCurveType) {
            return createMultiCurve((MultiCurveType) value);

        } else if (value instanceof CompositeCurveType) {
            return createCompositeCurve((CompositeCurveType) value);

        } else if (value instanceof CurveType) {
            return createCurve((CurveType) value);

        } else if (value instanceof LineStringType) {
            return createLineString((LineStringType) value);

        } else if (value instanceof EnvelopeType) {
            return createEnvelope((EnvelopeType) value);

        } else if (value instanceof MultiGeometryType) {
            return createMultiGeometry((MultiGeometryType) value);

        } else if (value instanceof PolygonType) {
            return createPolygon((PolygonType) value);

        } else if (value instanceof RingType) {
            return createRing((RingType) value);
        
        } else if (value != null) {
            throw new IllegalArgumentException("unexpected geometry type:" + value.getClass().getName());
        }
        return null;
    }

}
