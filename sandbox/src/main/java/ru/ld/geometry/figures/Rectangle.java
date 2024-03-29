package ru.ld.geometry.figures;

public record Rectangle(double a, double b) {
    public static void printRectanglArea(double a, double b) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", a, b, rectanglArea(a, b));
        System.out.println(text );
    }

    private static double rectanglArea(double a, double b) {
        return a * b;
    }
}
