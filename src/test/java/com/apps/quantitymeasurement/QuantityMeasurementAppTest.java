package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(
                new Length(1.0, LengthUnit.FEET),
                new Length(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testInchesEquality() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(
                new Length(1.0, LengthUnit.INCHES),
                new Length(1.0, LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInchesComparision() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(
                1.0, LengthUnit.FEET,
                12.0, LengthUnit.INCHES));
    }

    @Test
    public void testFeetInequality() {
        assertFalse(QuantityMeasurementApp.demonstrateLengthComparison(
                1.0, LengthUnit.FEET,
                2.0, LengthUnit.FEET));
    }

    @Test
    public void referenceEqualitySameObject() {
        Length length = new Length(2.0, LengthUnit.FEET);
        assertTrue(length.equals(length));
    }

    @Test
    public void equalsReturnsFalseForNull() {
        assertFalse(new Length(1.0, LengthUnit.FEET).equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    /* ===== UC5 Conversion Tests ===== */

    @Test
    public void convertFeetToInches() {
        Length actual =
                QuantityMeasurementApp.demonstrateLengthConversion(
                        3.0, LengthUnit.FEET, LengthUnit.INCHES);

        Length expected = new Length(36.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(actual, expected));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length lengthInYards = new Length(2.0, LengthUnit.YARDS);

        Length actual =
                QuantityMeasurementApp.demonstrateLengthConversion(
                        lengthInYards, LengthUnit.INCHES);

        Length expected = new Length(72.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(actual, expected));
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        Length actual =
                QuantityMeasurementApp.demonstrateLengthConversion(
                        1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);

        Length expected = new Length(0.393701, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(actual, expected));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(
                3.0, LengthUnit.FEET,
                1.0, LengthUnit.YARDS));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(
                30.48, LengthUnit.CENTIMETERS,
                1.0, LengthUnit.FEET));
    }
}
