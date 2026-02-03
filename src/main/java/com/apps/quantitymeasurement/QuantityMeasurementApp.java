package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    /*
     * Enum representing supported length units.
     * Base unit is INCHES.
     */
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    /**
     * Generic Length class applying DRY principle.
     */
    public static class Length {

        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        private double convertToBaseUnit() {
            return value * unit.getConversionFactor();
        }

        public boolean compare(Length that) {
            return Double.compare(
                    this.convertToBaseUnit(),
                    that.convertToBaseUnit()
            ) == 0;
        }

        @Override
        public boolean equals(Object obj) {

            // Same reference
            if (this == obj) {
                return true;
            }

            // Null or different class
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            Length other = (Length) obj;
            return compare(other);
        }
    }

    // ---------- Demo Methods ----------

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void demonstrateFeetEquality() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);

        System.out.println("Input: Quantity(1.0, \"feet\") and Quantity(1.0, \"feet\")");
        System.out.println("Output: Equal (" + feet1.equals(feet2) + ")");
    }

    public static void demonstrateInchesEquality() {
        Length inch1 = new Length(1.0, LengthUnit.INCHES);
        Length inch2 = new Length(1.0, LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, \"inch\") and Quantity(1.0, \"inch\")");
        System.out.println("Output: Equal (" + inch1.equals(inch2) + ")");
    }

    public static void demonstrateFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, \"feet\") and Quantity(12.0, \"inches\")");
        System.out.println("Output: Equal (" + feet.equals(inches) + ")");
    }

    // ---------- Main Method ----------

    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}