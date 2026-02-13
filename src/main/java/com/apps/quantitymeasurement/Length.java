package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // Base unit = INCHES
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert to base unit (inches)
    private double convertToBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    // Convert base inches to target unit
    private double convertFromBaseToTargetUnit(double baseValue, LengthUnit targetUnit) {
        return baseValue / targetUnit.getConversionFactor();
    }

    // UC6 Addition
    public Length add(Length thatLength) {

        if (thatLength == null)
            throw new IllegalArgumentException("Length cannot be null");

        double thisInches = this.convertToBaseUnit();
        double thatInches = thatLength.convertToBaseUnit();

        double sumInInches = thisInches + thatInches;

        double resultValue = convertFromBaseToTargetUnit(sumInInches, this.unit);

        // resultValue = Math.round(resultValue * 100.0) / 100.0;
        double normalized=Math.round(resultValue*1_000_000.0)/1_000_000.0;

        return new Length(normalized, this.unit);
    }

    // UC5 Conversion support
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double base = convertToBaseUnit();
        double converted = convertFromBaseToTargetUnit(base, targetUnit);

        converted = Math.round(converted * 100.0) / 100.0;

        return new Length(converted, targetUnit);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Length)) return false;

        Length other = (Length) o;

        double diff = Math.abs(
                this.convertToBaseUnit() - other.convertToBaseUnit()
        );

        return diff < 1e-6;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}

