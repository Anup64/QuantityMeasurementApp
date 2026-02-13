package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        return length1.add(length2);
    }

    public static void main(String[] args) {

        printAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(2.0, Length.LengthUnit.FEET)
        );

        printAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );

        printAddition(
                new Length(12.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.FEET)
        );

        printAddition(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET)
        );

        printAddition(
                new Length(36.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.YARDS)
        );

        printAddition(
                new Length(2.54, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.INCHES)
        );

        printAddition(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(0.0, Length.LengthUnit.INCHES)
        );

        printAddition(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(-2.0, Length.LengthUnit.FEET)
        );
    }

    private static void printAddition(Length l1, Length l2) {

        Length result = demonstrateLengthAddition(l1, l2);

        System.out.println("Input: add(" + l1 + ", " + l2 + ")");
        System.out.println("Output: " + result);
        System.out.println();
    }

}
