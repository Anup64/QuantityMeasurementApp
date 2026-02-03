package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Inner class to represent Feet measurement
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {

            // Reference check
            if (this == obj) {
                return true;
            }

            // Null and type check
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            // Safe casting
            Feet other = (Feet) obj;

            // Value comparison
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Inner class to represent Inches measurement
    public static class Inches {

        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {

            // Reference check
            if (this == obj) {
                return true;
            }

            // Null and type check
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            // Safe casting
            Inches other = (Inches) obj;

            // Value comparison
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Static method to demonstrate Feet equality
    public static void demonstrateFeetEquality() {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        boolean result = feet1.equals(feet2);

        System.out.println("Input: " + feet1.getValue() + " ft and " + feet2.getValue() + " ft");
        System.out.println("Output: Equal (" + result + ")");
    }

    // Static method to demonstrate Inches equality
    public static void demonstrateInchesEquality() {

        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(1.0);

        boolean result = inch1.equals(inch2);

        System.out.println("Input: " + inch1.getValue() + " inch and " + inch2.getValue() + " inch");
        System.out.println("Output: Equal (" + result + ")");
    }

    // Main method
    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}
