package app;

import java.text.DecimalFormat;

public class Rounder {

    // Метод округления веса
    public static String roundWeight(double value) {
        // Шаблон для веса, до 3-х знаков после
        // десятичного разделителя
        DecimalFormat df = new DecimalFormat("0.000");
        return df.format(value);
    }

    // Метод округления цены
    public static String roundPrice(double value) {
        // Шаблон для цены, до 2-х знаков после
        // десятичного разделителя
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(value);
    }
}
