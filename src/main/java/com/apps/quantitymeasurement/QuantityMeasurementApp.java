package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public enum LengthUnit {

        FEET(12.0),            // 1 foot = 12 inches
        INCHES(1.0),           // base unit
        YARDS(36.0),           // 1 yard = 36 inches
        CENTIMETERS(0.393701); // 1 cm = 0.393701 inches

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

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

        @Override
        public boolean equals(Object obj) {

            // Same reference check
            if (this == obj) {
                return true;
            }

            // Null and type check
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            Length other = (Length) obj;

            // Compare converted values
            return Double.compare(
                    this.convertToBaseUnit(),
                    other.convertToBaseUnit()
            ) == 0;
        }
    }

    // ----------------------------------------------------
    // Helper method to print output
    // ----------------------------------------------------
    public static void printResult(double v1, LengthUnit u1,
                                   double v2, LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        System.out.println(
                "Input: Quantity (" + v1 + ", " + u1 + ") and Quantity(" + v2 + ", " + u2 + ")"
        );
        System.out.println("Output: Equal (" + l1.equals(l2) + ")");
        System.out.println();
    }

    // ----------------------------------------------------
    // Main method –
    // ----------------------------------------------------
    public static void main(String[] args) {

        printResult(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET);

        printResult(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES);

        printResult(2.0, LengthUnit.YARDS, 2.0, LengthUnit.YARDS);

        printResult(2.0, LengthUnit.CENTIMETERS, 2.0, LengthUnit.CENTIMETERS);

        printResult(1.0, LengthUnit.CENTIMETERS, 0.393701, LengthUnit.INCHES);
    }
}