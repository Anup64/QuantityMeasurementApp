package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-5;

    // ---------------- SAME UNIT ADDITION ----------------

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch() {
        Length l1 = new Length(6.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(6.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertEquals(new Length(12.0, Length.LengthUnit.INCHES), result);
    }

    // ---------------- CROSS UNIT ADDITION ----------------

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertEquals(new Length(24.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertEquals(new Length(2.0, Length.LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {
        Length l1 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertEquals(5.08, result.getValue(), EPSILON);
        assertEquals(Length.LengthUnit.CENTIMETERS, result.getUnit());
    }

    // ---------------- COMMUTATIVITY ----------------

    @Test
    public void testAddition_Commutativity() {
        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        Length result1 = QuantityMeasurementApp.demonstrateLengthAddition(a, b);
        Length result2 = QuantityMeasurementApp.demonstrateLengthAddition(b, a);

        assertEquals(
                result1.convertTo(Length.LengthUnit.INCHES),
                result2.convertTo(Length.LengthUnit.INCHES)
        );
    }

    // ---------------- ZERO / IDENTITY ----------------

    @Test
    public void testAddition_WithZero() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(0.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertEquals(new Length(5.0, Length.LengthUnit.FEET), result);
    }

    // ---------------- NEGATIVE VALUES ----------------

    @Test
    public void testAddition_NegativeValues() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
    }

    // ---------------- NULL VALIDATION ----------------

    @Test
    public void testAddition_NullSecondOperand() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.demonstrateLengthAddition(l1, null)
        );
    }

    // ---------------- LARGE VALUES ----------------

    @Test
    public void testAddition_LargeValues() {
        Length l1 = new Length(1e6, Length.LengthUnit.FEET);
        Length l2 = new Length(1e6, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertEquals(new Length(2e6, Length.LengthUnit.FEET), result);
    }

    // ---------------- SMALL VALUES ----------------

    @Test
    public void testAddition_SmallValues() {
        Length l1 = new Length(0.001, Length.LengthUnit.FEET);
        Length l2 = new Length(0.002, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertEquals(0.003, result.getValue(), EPSILON);
    }
}
