package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Inner class to represent Feet measurement
    public static class Feet {
        private final double value;

        public Feet(double value) {

            this.value = value;
        }

        public double getValue(){
            return value;
        }

        @Override
        public boolean equals(Object obj) {

            // 1. Reference check
            if (this == obj) return true;

            // 2. Null check
            if (obj == null) return false;

            // 3. Type check
            if (this.getClass() != obj.getClass()) return false;

            // 4. Safe cast
            Feet other = (Feet) obj;

            // 5. Value comparison using Double.compare()
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Main method to demonstrate Feet equality check
    public static void main(String[] args) {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);

        System.out.println("Input: "+feet1.getValue()+" ft and "+feet2.getValue()+" ft");
        System.out.println("Output: Equal (" + feet1.equals(feet2) + ")");
    }
}