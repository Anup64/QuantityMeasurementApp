package com.apps.quantitymeasurement;
public class QuantityMeasurementApp {

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    /**
     * Immutable Length value object
     */
    public static class Length {

        private final double value;
        private final LengthUnit unit;
        private static final double EPSILON = 1e-4;

        public Length(double value, LengthUnit unit) {

            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be finite");
            }
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }

            this.value = value;
            this.unit = unit;
        }

        private double toBaseUnit() {
            return value * unit.getFactor();
        }

        public Length convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }
            double baseValue = toBaseUnit();
            double converted = baseValue / targetUnit.getFactor();
            return new Length(converted, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Length other = (Length) obj;
            return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    /* ===================== REQUIRED APIs ===================== */

    // Equality API
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // Comparison API
    public static boolean demonstrateLengthComparison(
            double v1, LengthUnit u1,
            double v2, LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);
        return demonstrateLengthEquality(l1, l2);
    }

    // Conversion API (raw values)
    public static Length demonstrateLengthConversion(
            double value, LengthUnit from, LengthUnit to) {

        Length length = new Length(value, from);
        return length.convertTo(to);
    }

    // Conversion API (overloaded – instance)
    public static Length demonstrateLengthConversion(
            Length length, LengthUnit to) {

        return length.convertTo(to);
    }

    /* ===================== MAIN ===================== */

    public static void main(String[] args) {

        System.out.println("Input: convert(1.0, FEET, INCHES)");
        System.out.println("Output: " +
                demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES).value);
        System.out.println();

        System.out.println("Input: convert(3.0, YARDS, FEET)");
        System.out.println("Output: " +
                demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET).value);
        System.out.println();

        System.out.println("Input: convert(36.0, INCHES, YARDS)");
        System.out.println("Output: " +
                demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARDS).value);
        System.out.println();

        System.out.println("Input: convert(1.0, CENTIMETERS, INCHES)");
        System.out.println("Output: " +
                demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES).value);
        System.out.println();

        System.out.println("Input: convert(0.0, FEET, INCHES)");
        System.out.println("Output: " +
                demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCHES).value);
    }

}
