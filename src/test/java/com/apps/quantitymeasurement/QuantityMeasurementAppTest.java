package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    // 1
    @Test
    public void testEquality_YardToYard_SameValue() {
        assertTrue(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(1.0, LengthUnit.YARDS)));
    }

    // 2
    @Test
    public void testEquality_YardToYard_DifferentValue() {
        assertFalse(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(2.0, LengthUnit.YARDS)));
    }

    // 3
    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(3.0, LengthUnit.FEET)));
    }

    // 4
    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        assertTrue(new Length(3.0, LengthUnit.FEET)
                .equals(new Length(1.0, LengthUnit.YARDS)));
    }

    // 5
    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        assertTrue(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(36.0, LengthUnit.INCHES)));
    }

    // 6
    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        assertTrue(new Length(36.0, LengthUnit.INCHES)
                .equals(new Length(1.0, LengthUnit.YARDS)));
    }

    // 7
    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        assertFalse(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(2.0, LengthUnit.FEET)));
    }

    // 8
    @Test
    public void testEquality_centimetersToInches_EquivalentValue() {
        assertTrue(new Length(1.0, LengthUnit.CENTIMETERS)
                .equals(new Length(0.393701, LengthUnit.INCHES)));
    }

    // 9
    @Test
    public void testEquality_centimetersToFeet_NonEquivalentValue() {
        assertFalse(new Length(1.0, LengthUnit.CENTIMETERS)
                .equals(new Length(1.0, LengthUnit.FEET)));
    }

    // 10
    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    // 11
    @Test
    public void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Length(1.0, null));
    }

    // 12
    @Test
    public void testEquality_YardSameReference() {
        Length yard = new Length(2.0, LengthUnit.YARDS);
        assertTrue(yard.equals(yard));
    }

    // 13
    @Test
    public void testEquality_YardNullComparison() {
        assertFalse(new Length(1.0, LengthUnit.YARDS).equals(null));
    }

    // 14
    @Test
    public void testEquality_CentimetersWithNullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Length(1.0, null));
    }

    // 15
    @Test
    public void testEquality_CentimetersSameReference() {
        Length cm = new Length(2.0, LengthUnit.CENTIMETERS);
        assertTrue(cm.equals(cm));
    }

    // 16
    @Test
    public void testEquality_CentimetersNullComparison() {
        assertFalse(new Length(1.0, LengthUnit.CENTIMETERS).equals(null));
    }

    // 17
    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        Length yard = new Length(2.0, LengthUnit.YARDS);
        Length feet = new Length(6.0, LengthUnit.FEET);
        Length inches = new Length(72.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
}