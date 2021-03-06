/*
 *    Geotoolkit.org - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2008-2012, Open Source Geospatial Foundation (OSGeo)
 *    (C) 2009-2012, Geomatys
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
package org.geotoolkit.referencing.operation.transform;

import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.awt.geom.AffineTransform;
import net.jcip.annotations.ThreadSafe;

import org.opengis.parameter.ParameterValueGroup;
import org.opengis.parameter.ParameterDescriptorGroup;
import org.opengis.referencing.operation.MathTransform2D;

import org.opengis.referencing.operation.Matrix;
import org.apache.sis.io.wkt.Formatter;
import org.apache.sis.io.wkt.FormattableObject;
import org.geotoolkit.util.Utilities;
import org.apache.sis.util.logging.Logging;
import org.apache.sis.util.collection.WeakHashSet;
import org.apache.sis.internal.referencing.WKTUtilities;
import org.apache.sis.referencing.operation.transform.MathTransforms;
import org.geotoolkit.io.wkt.Formattable;
import org.apache.sis.internal.referencing.j2d.AffineTransform2D;
import org.apache.sis.parameter.Parameterized;

import org.apache.sis.referencing.operation.matrix.AffineTransforms2D;
import static org.apache.sis.util.ArgumentChecks.ensureNonNull;
import static org.geotoolkit.internal.InternalUtilities.adjustForRoundingError;


/**
 * @deprecated Moved to Apache SIS as {@link org.apache.sis.referencing.operation.transform.AbstractMathTransform}.
 */
@ThreadSafe
@Deprecated
public abstract class AbstractMathTransform2D extends org.apache.sis.referencing.operation.transform.AbstractMathTransform2D_tmp
        implements org.geotoolkit.io.wkt.Formattable, Serializable
{
    static final double IDENTITY_TOLERANCE = 1E-9;

    /**
     * Constructs a default math transform.
     */
    protected AbstractMathTransform2D() {
    }

    /**
     * Unwraps the given object if it is expected to be an inverse transform.
     * This is used for assertions only.
     */
    private static Object unwrap(final Object object, final boolean inverse) {
        return inverse ? ((Inverse) object).inverse() : object;
    }

    /**
     * Returns the parameter descriptors for this math transform, or {@code null} if unknown.
     * The default implementation returns the descriptor associated to the object returned
     * by {@link #getUnmarshalledParameters} if there is one, or {@code null} otherwise.
     */
    @Override
    public ParameterDescriptorGroup getParameterDescriptors() {
        final Parameters parameters = getUnmarshalledParameters();
        return (parameters != null) ? parameters.getParameterDescriptors() : null;
    }

    // Do NOT override getParameterValues() in this class.  This is usually not appropriate
    // because if the ParsedParameters object declares "normalize" and "denormalize" affine
    // transforms, they need to be taken in account in a way that only the subclass know.

    /**
     * Returns the parameters of this transform as a tuple of (<cite>normalize</cite> &ndash;
     * <cite>non-linear kernel</cite> &ndash; <cite>denormalize</cite>) transforms. The default
     * implementation returns {@code null} in all case, which means that there is no such tuple.
     * <p>
     * This method is used mostly for Geotk implementation of map projections.
     * Most users should consider this method as internal to Geotk mechanic.
     *
     * @return The tuple of (<cite>normalize</cite> &ndash; <cite>non-linear kernel</cite>
     *         &ndash; <cite>denormalize</cite>) transforms, or {@code null} if none.
     * @level advanced
     */
    protected Parameters getUnmarshalledParameters() {
        return null;
    }

    /**
     * The parameters of the enclosing transform as a tuple of (<cite>normalize</cite> &ndash;
     * <cite>non-linear kernel</cite> &ndash; <cite>denormalize</cite>) transforms. The normalize
     * and denormalize parts must be {@linkplain AffineTransform affine transforms}. The non-linear
     * part in the middle is conceptually the enclosing {@link AbstractMathTransform2D}. However
     * this {@code Parameters} class does not keep a reference to the enclosing transform because
     * parameters are typically unmarshalled before the transform is instantiated.
     * <p>
     * This object is used mostly for Geotk implementation of map projections, where the
     * kernel is a {@linkplain org.geotoolkit.referencing.operation.projection.UnitaryProjection
     * unitary projection}. See the {@linkplain org.geotoolkit.referencing.operation.projection
     * projection package} for details.
     *
     * {@note Serialization of this class is appropriate for short-term storage or RMI use, but may
     *        not be compatible with future versions. For long term storage, WKT (Well Know Text) or
     *        XML are more appropriate.}
     *
     * @author Martin Desruisseaux (Geomatys)
     * @version 3.00
     *
     * @since 3.00
     * @level advanced
     * @module
     *
     * @todo Rename as DeclaredParameters?
     */
    protected abstract static class Parameters extends FormattableObject implements Parameterized, Serializable {
        /**
         * For cross-version compatibility.
         */
        private static final long serialVersionUID = 4899134192407586472L;

        /**
         * The pool of affine transforms created in this running JVM. It is worth to share
         * references to existing objects because a few typical affine transforms will be
         * shared by many projections. For example many projections will use the transform
         * that do nothing else than converting decimal degrees to radians.
         * <p>
         * Note that the {@code Parameters} class does not use any factory for creating
         * {@link AffineTransform2D} instances, which make ineffective the pool provided
         * by those factories.
         */
        private static final WeakHashSet<AffineTransform2D> POOL =
                new WeakHashSet<>(AffineTransform2D.class);

        /**
         * The descriptor that represents this tuple as a whole. The parameter values may take
         * effect in either the {@linkplain #normalize(boolean) normalize/denormalize} transforms
         * or in the kernel.
         *
         * {@note The definition of "kernel" is left to implementors. In the particular case of
         *        map projections, kernel are subclasses of <code>UnitaryProjection</code>}.
         */
        private final ParameterDescriptorGroup descriptor;

        /**
         * The affine transform to be applied before (<cite>normalize</cite>) and after
         * (<cite>denormalize</cite>) the kernel operation. On {@code Parameters} construction,
         * those affines are initially identity transforms. Subclasses should set the coefficients
         * according their parameter values. When all coefficients are set to their final value,
         * the affine transforms will be replaced by immutable instances.
         *
         * @see #normalize(boolean)
         */
        private AffineTransform normalize, denormalize;

        /**
         * Creates a new {@code Parameters}. The descriptor argument shall describe the parameters
         * of this tuple as a whole, including the affine transforms applied before and after the
         * kernel. Subclasses shall initialize those {@linkplain #normalize(boolean)
         * normalize/denormalize} affine transforms when they have enough information for doing so.
         *
         * @param descriptor The descriptor that represents this tuple as a whole.
         */
        protected Parameters(final ParameterDescriptorGroup descriptor) {
            ensureNonNull("descriptor", descriptor);
            this.descriptor = descriptor;
            normalize   = new AffineTransform();
            denormalize = new AffineTransform();
        }

        /**
         * The affine transforms to be applied before or after the kernel operation. Those affines
         * are initially identity transforms. Subclasses should invoke this method at construction
         * time (or at some time close to construction) in order to set the affine coefficients.
         *
         * {@note The normalize/denormalize affine transforms will stop being mutable when the
         *        <code>createConcatenatedTransform(MathTransform2D)</code> method is invoked
         *        for the first time.}
         *
         * @param norm {@code true} for fetching the <cite>normalize</cite> transform to apply
         *        before the kernel, or {@code false} for the <cite>denormalize</cite> transform
         *        to apply after the kernel.
         * @return The requested normalize ({@code true}) or denormalize ({@code false}) transform.
         */
        public final AffineTransform normalize(final boolean norm) {
            return norm ? normalize : denormalize;
        }

        /**
         * Creates a chain of {@linkplain ConcatenatedTransform concatenated transforms} from the
         * <cite>normalize</cite> transform, the given kernel and the <cite>denormalize</cite>
         * transform. The {@linkplain #normalize(boolean) normalize/denormalize} transforms are
         * replaced by immutable instances of {@link AffineTransform2D} the first time this method
         * is invoked, since they will be injected in the chain of concatenated transforms.
         *
         * @param  kernel The (usually non-linear) kernel.
         * @return The concatenation of (<cite>normalize</cite> &ndash; the given kernel &ndash;
         *         <cite>denormalize</cite>) transforms.
         */
        public MathTransform2D createConcatenatedTransform(final MathTransform2D kernel) {
            AffineTransform2D n,d;
            synchronized (this) {
                if (denormalize instanceof AffineTransform2D) {
                    n = (AffineTransform2D) normalize;
                    d = (AffineTransform2D) denormalize;
                } else {
                    n = new AffineTransform2D(normalize);
                    d = new AffineTransform2D(denormalize);
                    normalize   = n = POOL.unique(n);
                    denormalize = d = POOL.unique(d);
                }
            }
            return MathTransforms.concatenate(n, kernel, d);
        }

        /**
         * Returns the descriptor that represents this tuple as a whole. The parameter values
         * may take effect in either the {@linkplain #normalize(boolean) normalize/denormalize}
         * transforms or in the kernel.
         *
         * {@note The definition of "kernel" is left to implementors. In the particular case of
         *        map projections, kernel are subclasses of <code>UnitaryProjection</code>}.
         *
         * @return The description of the parameters.
         */
        @Override
        public ParameterDescriptorGroup getParameterDescriptors() {
            return descriptor;
        }

        /**
         * Returns the parameters that describe this tuple as a whole.
         * Changes to the returned parameters will not affect this object.
         *
         * @return A copy of the parameter values.
         */
        @Override
        public abstract ParameterValueGroup getParameterValues();

        /**
         * Returns a hash code value for this object. This value is
         * implementation-dependent and may change in any future version.
         */
        @Override
        public int hashCode() {
            return Utilities.hash(normalize, denormalize.hashCode()) ^ (int) serialVersionUID;
        }

        /**
         * Compares the given object with the parameters for equality.
         *
         * @param  object The object to compare with the parameters.
         * @return {@code true} if the given object is equal to this one.
         */
        @Override
        public boolean equals(final Object object) {
            if (object != null && object.getClass() == getClass()) {
                final Parameters that = (Parameters) object;
                return Objects.equals(descriptor,  that.descriptor) &&
                       Objects.equals(normalize,   that.normalize)  &&
                       Objects.equals(denormalize, that.denormalize);
            }
            return false;
        }

        /**
         * Process to the WKT formatting of the forward transform. The content is inferred
         * from the parameter values returned by the {@link #getParameterValues()} method.
         *
         * <p>The referencing framework may invoke this class instead than the one declared in the enclosing
         * {@link AbstractMathTransform2D} class when the later is an element of a concatenated transforms chain.
         * This is because in such case, the transforms immediately before and after the enclosing transform are
         * expected to be derived from the {@link #normalize(boolean) normalize/denormalize} transforms respectively.
         * The tuple of those 3 transforms makes the full transform described by this {@code Parameters} object.</p>
         *
         * @return {@code "PARAM_MT"}.
         */
        @Override
        public String formatTo(final Formatter formatter) {
            final ParameterValueGroup parameters = getParameterValues();
            WKTUtilities.appendName(parameters.getDescriptor(), formatter, null);
            WKTUtilities.append(parameters, formatter);
            return "PARAM_MT";
        }

        /**
         * Formats the <cite>Well Known Text</cite> for the inverse of the transform that would be built
         * from the enclosing {@code Parameters}.
         */
        final class InverseWKT extends FormattableObject implements Parameterized, Formattable {
            /**
             * Creates a new object to be formatted instead than the enclosing transform.
             */
            InverseWKT() {
            }

            /**
             * Returns the parameters descriptor.
             */
            @Override
            public ParameterDescriptorGroup getParameterDescriptors() {
                return Parameters.this.getParameterDescriptors();
            }

            /**
             * Returns the parameter values.
             */
            @Override
            public ParameterValueGroup getParameterValues() {
                return Parameters.this.getParameterValues();
            }

            /**
             * Process to the WKT formatting of the inverse transform.
             */
            @Override
            public String formatTo(final Formatter formatter) {
                formatter.append(Parameters.this);
                return "INVERSE_MT";
            }
        }
    }

    /**
     * Given a transformation chain, replaces the elements around {@code this} transform by
     * alternative objects to use when formatting WKT. The replacement is performed in-place
     * in the given list. The index of {@code this} transform is given by {@code index}.
     * <p>
     * This method shall replace only the previous element and the few next elements that need
     * to be changed as a result of the previous change. This method is not expected to continue
     * the iteration after the changes that are of direct concern to this object.
     *
     * @param  transforms The full chain of concatenated transforms.
     * @param  index      The index of this transform in the {@code transforms} chain.
     * @param  inverse    Always {@code false}, except if we are formatting the inverse transform.
     * @return Index of the last transform processed. Iteration should continue at that index + 1.
     */
    @Override
    protected final int beforeFormat(final List<Object> transforms, int index, final boolean inverse) {
        assert unwrap(transforms.get(index), inverse) == this;
        final Parameters parameters = getUnmarshalledParameters();
        if (parameters == null) {
            return index;
        }
        /*
         * We expect affine transforms before and after this unitary projection. Extracts those
         * affine transforms now. If one or both are missing, we will treat null as an identity
         * transform. We will not replace the elements in the list before new values for those
         * affine transforms have been fully calculated.
         */
        AffineTransform before = null;
        AffineTransform after  = null;
        if (index != 0) {
            final Object candidate = transforms.get(index - 1);
            if (candidate instanceof AffineTransform) {
                before = (AffineTransform) candidate;
            }
        }
        if (index+1 < transforms.size()) {
            final Object candidate = transforms.get(index + 1);
            if (candidate instanceof AffineTransform) {
                after = (AffineTransform) candidate;
            }
        }
        final boolean hasBefore = (before != null);
        final boolean hasAfter  = (after  != null);
        /*
         * We assume that the "before" affine contains the normalize operation to be applied
         * before the projection. However it may contains more than just this normalization,
         * because it may have been concatenated with any user-defined transform (for example
         * in order to apply a change of axis order). We need to separate the "user-defined"
         * part from the "normalize" part.
         */
        AffineTransform2D userDefined = new AffineTransform2D(parameters.normalize(!inverse), true);
        if (!inverse) try {
            userDefined.invert();
        } catch (java.awt.geom.NoninvertibleTransformException e) {
            // Should never happen. But if it does, we abandon the attempt to change
            // the list elements and will format the objects in their "raw" format.
            unexpectedException(e);
            return index;
        }
        if (hasBefore) {
            userDefined.concatenate(before);
        }
        /*
         * At this point "userDefined" is the affine transform to show to user instead of the
         * "before" affine transform. Replaces "before" by "userDefined" locally (but not yet
         * in the list), or set it to null (meaning that it will be removed from the list) if
         * it is identity, which happen quite often. Note that in the former (non-null) case,
         * the coefficients are often either 0 or 1 since the transform is often for changing
         * axis order, so it is worth to attempt rounding coefficents.
         */
        if (isIdentity(userDefined)) {
            before = null;
            userDefined.setTransform(parameters.normalize(inverse));
        } else {
            roundIfAlmostInteger(userDefined, false);
            userDefined.forcePositiveZeros();
            userDefined.freeze();
            before = userDefined;
            userDefined = new AffineTransform2D(parameters.normalize(inverse), true);
        }
        /*
         * The above code assigned a new value to "userDefined" in an opportunist way. The new
         * value will be the "after" affine transform,  to be calculated in a way similar than
         * the "before" affine. Note that if this operation fails, we will rollback everything
         * we did in this method (i.e. we do not touch the transforms list at all).
         */
        if (!inverse) try {
            userDefined.invert();
        } catch (java.awt.geom.NoninvertibleTransformException e) {
            unexpectedException(e);
            return index;
        }
        if (hasAfter) {
            userDefined.preConcatenate(after);
        }
        if (isIdentity(userDefined)) {
            after = null;
        } else {
            roundIfAlmostInteger(userDefined, true);
            userDefined.forcePositiveZeros();
            userDefined.freeze();
            after = userDefined;
        }
        /*
         * At this point we have computed all the affine transforms to show to the user.
         * We can replace the elements in the list. The transform referenced by this is
         * usually a UnitaryProjection, to be replaced by a Parameters.WKT instance in
         * order to format real parameter values (semi-major axis, scale factor, etc.)
         * instead than a semi-major axis length of 1.
         */
        if (before == null) {
            if (hasBefore) {
                final Object old = transforms.remove(--index);
                assert (old instanceof AffineTransform);
            }
        } else {
            if (hasBefore) {
                final Object old = transforms.set(index-1, before);
                assert (old instanceof AffineTransform);
            } else {
                transforms.add(index++, before);
            }
        }
        if (true) { // This condition is just for isolating the local variables in this block.
            final Object old = transforms.set(index, inverse ? parameters.new InverseWKT() : parameters);
            assert unwrap(old, inverse) == this : old.getClass();
        }
        if (after == null) {
            if (hasAfter) {
                final Object old = transforms.remove(index + 1);
                assert (old instanceof AffineTransform);
            }
        } else {
            index++;
            if (hasAfter) {
                final Object old = transforms.set(index, after);
                assert (old instanceof AffineTransform);
            } else {
                transforms.add(index, after);
            }
        }
        return index;
    }

    /**
     * To be removed after the port to Apache SIS.
     */
    private static boolean isIdentity(final AffineTransform2D tr) {
        Matrix m = tr.getMatrix();
        if (m == null) {
            m = AffineTransforms2D.toMatrix(tr);
        }
        return org.apache.sis.referencing.operation.matrix.Matrices.isIdentity(m, IDENTITY_TOLERANCE);
    }

    /**
     * Rounds the coefficients in the affine transform if they are almost integers.
     * This method rounds any coefficients for which the difference to the nearest
     * integers is smaller than a few ULP. In addition the translation terms are
     * rounded if they are close to an integer within some tolerance value.
     * <p>
     * The tolerance value depends on whatever the transform is a "normalize" transform
     * applied before a "unitary projection", or a denormalize transform applied after.
     * In the first case, source coordinates are arbitrary and destination coordinates
     * are expected to be around the [-1 .. +1] range (this is approximative; we are
     * just talking about order of magnitude). So we need a tolerance value for numbers
     * in that range, which is the purpose of {@code IDENTITY_TOLERANCE}.
     * <p>
     * In the second case, the target coordinates are arbitrary and the source coordinates
     * are expected to be around the [-1 .. +1] range. The tolerance value must be scaled
     * by a factor of approximatively the same magnitude than the one used for scaling the
     * coordinates.
     *
     * @param tr The affine transform for which to round the coefficients.
     * @param scale {@code true} if we should scale the tolerance threshold as described
     *        in the above documentation.
     */
    private static void roundIfAlmostInteger(final AffineTransform tr, final boolean scale) {
        final double[] c = new double[6];
        tr.getMatrix(c);
        for (int i=0; i<c.length; i++) {
            double m = adjustForRoundingError(c[i]);
            if (i >= 4) { // Translation terms.
                final double r = Math.rint(m);
                double tolerance = IDENTITY_TOLERANCE;
                if (scale) {
                    tolerance *= Math.hypot(c[i-4], c[i-2]);
                }
                if (Math.abs(m - r) <= tolerance) {
                    m = r;
                }
            }
            c[i] = m;
        }
        tr.setTransform(c[0], c[1], c[2], c[3], c[4], c[5]);
    }

    /**
     * Logs a warning about a non-invertible transform. This method may be invoked during WKT
     * formatting. This error should never occur, but it still possible to recover from this
     * error and getting the WKT can help to debug.
     */
    private static void unexpectedException(final java.awt.geom.NoninvertibleTransformException e) {
        Logging.recoverableException(AbstractMathTransform2D.class /*ConcatenatedTransform.class*/, "formatWKT", e);
    }

    @Deprecated
    protected static double rollLongitude(double x, final double bound) {
        return AbstractMathTransform.rollLongitude(x, bound);
    }
}
