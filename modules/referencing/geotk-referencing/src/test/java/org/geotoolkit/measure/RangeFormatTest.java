/*
 *    Geotoolkit.org - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 *
 *    (C) 2009, Open Source Geospatial Foundation (OSGeo)
 *    (C) 2009, Geomatys
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
package org.geotoolkit.measure;

import java.util.Locale;
import java.text.NumberFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import javax.measure.unit.SI;

import org.geotoolkit.util.Range;
import org.geotoolkit.util.NumberRange;
import org.geotoolkit.util.MeasurementRange;

import org.junit.*;
import static org.junit.Assert.*;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.NEGATIVE_INFINITY;


/**
 * Tests parsing and formatting done by the {@link RangeFormat} class.
 *
 * @author Martin Desruisseaux (Geomatys)
 * @version 3.06
 *
 * @since 3.06
 */
public final class RangeFormatTest {
    /**
     * The format being tested.
     */
    private RangeFormat format;

    /**
     * The position of the minimal value and maximal value fields.
     */
    private FieldPosition minPos, maxPos;

    /**
     * The position during parsing.
     */
    private ParsePosition parsePos;

    /**
     * Formats the given range.
     */
    private String format(final Range<?> range) {
        final String s1 = format.format(range, new StringBuffer(), minPos).toString();
        final String s2 = format.format(range, new StringBuffer(), maxPos).toString();
        assertEquals("Two consecutive formats produced different results.", s1, s2);
        return s1;
    }

    /**
     * Parses the given text and ensure that there is only whitespace or underscore after the last
     * parse position. Also verifies that there is no underscore before the parse position. This
     * assume that the underscore is not allowed to appears in the valid portion of the text.
     */
    private Range<?> parse(final String text) {
        parsePos.setIndex(0);
        final Range<?> range = format.parse(text, parsePos);
        assertEquals("Index position shall be modified on parse success, and only parse success.", parsePos.getIndex()      == 0, range == null);
        assertEquals("Error position shall be defined on parse failure, and only parse failure",   parsePos.getErrorIndex() >= 0, range == null);
        if (range != null) {
            int i = parsePos.getIndex();
            assertTrue("The parse method parsed a character that it shouldn't have accepted.", text.lastIndexOf('_', i-1) < 0);
            while (i < text.length()) {
                final char c = text.charAt(i++);
                assertTrue("Looks like that the parse method didn't parsed everything.",
                           Character.isWhitespace(c) || c == '_');
            }
        }
        return range;
    }

    /**
     * Tests the {@link RangeFormat#format} method with numbers.
     */
    @Test
    public void testFormatNumber() {
        format = new RangeFormat(Locale.CANADA);
        minPos = new FieldPosition(RangeFormat.MIN_VALUE_FIELD | NumberFormat.INTEGER_FIELD);
        maxPos = new FieldPosition(RangeFormat.MAX_VALUE_FIELD | NumberFormat.INTEGER_FIELD);

        // Closed range
        assertEquals("[-10 … 20]", format(NumberRange.create(-10, 20)));
        assertEquals("minPos.beginIndex", 2, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   4, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 7, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   9, maxPos.getEndIndex());

        // Open range
        assertEquals("(-3 … 4)", format(NumberRange.create(-3, false, 4, false)));
        assertEquals("minPos.beginIndex", 2, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   3, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 6, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   7, maxPos.getEndIndex());

        // Half-open range
        assertEquals("[2 … 8)", format(NumberRange.create(2, true, 8, false)));
        assertEquals("minPos.beginIndex", 1, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   2, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 5, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   6, maxPos.getEndIndex());

        // Half-open range
        assertEquals("(40 … 90]", format(NumberRange.create(40, false, 90, true)));
        assertEquals("minPos.beginIndex", 1, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   3, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 6, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   8, maxPos.getEndIndex());

        // Single value
        assertEquals("300", format(NumberRange.create(300, 300)));
        assertEquals("minPos.beginIndex", 0, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   3, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 0, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   3, maxPos.getEndIndex());

        // Empty range
        assertEquals("[]", format(NumberRange.create(300, true, 300, false)));
        assertEquals("minPos.beginIndex", 1, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   1, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 1, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   1, maxPos.getEndIndex());

        // Negative infinity
        assertEquals("[-∞ … 30]", format(NumberRange.create(Double.NEGATIVE_INFINITY, 30)));
        assertEquals("minPos.beginIndex", 2, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   3, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 6, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   8, maxPos.getEndIndex());

        // Positive infinity
        assertEquals("[50 … ∞]", format(NumberRange.create(50, Double.POSITIVE_INFINITY)));
        assertEquals("minPos.beginIndex", 1, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   3, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 6, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   7, maxPos.getEndIndex());

        // Positive infinities
        assertEquals("[-∞ … ∞]", format(NumberRange.create(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)));
        assertEquals("minPos.beginIndex", 2, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   3, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 6, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   7, maxPos.getEndIndex());

        // Positive infinity with integers
        assertEquals("[50 … ∞)", format(new NumberRange<Integer>(Integer.class, 50, null)));
        assertEquals("minPos.beginIndex", 1, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   3, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 6, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   7, maxPos.getEndIndex());

        // Negative infinity with integers
        assertEquals("(-∞ … 40]", format(new NumberRange<Integer>(Integer.class, null, 40)));
        assertEquals("minPos.beginIndex", 2, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   3, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 6, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   8, maxPos.getEndIndex());

        // Measurement
        assertEquals("[-10 … 20] m", format(MeasurementRange.create(-10, 20, SI.METRE)));
        assertEquals("minPos.beginIndex", 2, minPos.getBeginIndex());
        assertEquals("minPos.endIndex",   4, minPos.getEndIndex());
        assertEquals("maxPos.beginIndex", 7, maxPos.getBeginIndex());
        assertEquals("maxPos.endIndex",   9, maxPos.getEndIndex());

        maxPos = new FieldPosition(RangeFormat.UNIT_FIELD);
        assertEquals("[-1 … 2] km", format(MeasurementRange.create(-1, 2, SI.KILO(SI.METRE))));
        assertEquals("unitPos.beginIndex", 9, maxPos.getBeginIndex());
        assertEquals("unitPos.endIndex",  11, maxPos.getEndIndex());
    }

    /**
     * Tests the parsing method on ranges of numbers. This test fixes the type to
     * {@code Integer.class}.  A different test will let the parser determine the
     * type itself.
     */
    @Test
    public void testParseInteger() {
        format   = new RangeFormat(Locale.CANADA, Integer.class);
        parsePos = new ParsePosition(0);

        assertEquals(NumberRange.create(-10,         20       ), parse("[-10 … 20]" ));
        assertEquals(NumberRange.create( -3, false,   4, false), parse("( -3 …  4) "));
        assertEquals(NumberRange.create(  2, true,    8, false), parse("  [2 …  8) _"));
        assertEquals(NumberRange.create( 40, false,  90, true ), parse(" (40 … 90]_"));
        assertEquals(NumberRange.create(300,        300       ), parse(" 300_"));
        assertEquals(NumberRange.create(300,        300       ), parse("[300]"));
        assertEquals(NumberRange.create(300, false, 300, false), parse("(300)"));
        assertEquals(NumberRange.create(  0, true,    0, false), parse("[]"));
    }

    /**
     * Tests the parsing method on ranges of numbers. This test fixes the type to
     * {@code Double.class}.   A different test will let the parser determine the
     * type itself.
     */
    @Test
    public void testParseDouble() {
        format   = new RangeFormat(Locale.CANADA, Double.class);
        parsePos = new ParsePosition(0);

        assertEquals(NumberRange.create(-10.0,             20.0), parse("[-10 … 20]" ));
        assertEquals(NumberRange.create(NEGATIVE_INFINITY, 30.0), parse("[-∞ … 30]"));
        assertEquals(NumberRange.create(50.0, POSITIVE_INFINITY), parse("[50 … ∞]"));
    }

    /**
     * Tests the parsing method on ranges of numbers where the type is inferred automatically.
     */
    @Test
    @SuppressWarnings("cast")
    public void testParseAuto() {
        format   = new RangeFormat(Locale.CANADA);
        parsePos = new ParsePosition(0);

        assertEquals(NumberRange.create((byte)    -10, (byte)    20), parse("[  -10 …    20]" ));
        assertEquals(NumberRange.create((short) -1000, (short) 2000), parse("[-1000 …  2000]" ));
        assertEquals(NumberRange.create((int)      10, (int)  40000), parse("[   10 … 40000]" ));
        assertEquals(NumberRange.create((int)       1, (int)  50000), parse("[ 1.00 … 50000]" ));
        assertEquals(NumberRange.create((float)   8.5, (float)    4), parse("[ 8.50 …     4]" ));
    }
}
