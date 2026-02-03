package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testEqualityFeetToFeetSameValue() {
        assertTrue(new Length(1.0, LengthUnit.FEET)
                .equals(new Length(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        assertTrue(new Length(1.0, LengthUnit.INCHES)
                .equals(new Length(1.0, LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        assertTrue(new Length(12.0, LengthUnit.INCHES)
                .equals(new Length(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        assertTrue(new Length(1.0, LengthUnit.FEET)
                .equals(new Length(12.0, LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        assertFalse(new Length(1.0, LengthUnit.FEET)
                .equals(new Length(2.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        assertFalse(new Length(1.0, LengthUnit.INCHES)
                .equals(new Length(2.0, LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_SameReference() {
        Length length = new Length(1.0, LengthUnit.FEET);
        assertTrue(length.equals(length));
    }

    @Test
    public void testEquality_NullComparison() {
        assertFalse(new Length(1.0, LengthUnit.FEET).equals(null));
    }

    @Test
    public void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Length(1.0, null));
    }
}