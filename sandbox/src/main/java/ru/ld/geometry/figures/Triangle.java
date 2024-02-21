package ru.ld.geometry.figures;

import java.util.Objects;

public record Triangle(double a, double b, double c) {

    /*метод расчета периметра треугольника*/
    public double countTriangle() {
        return this.a + this.b + this.c;
    }

    /*метод расчета площади треугольника*/
    public double squareTriangle() {
        double p = (countTriangle()) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /* 3.1 создания треугольника с отрицательной длиной стороны
   3. Нарушается неравенство треугольника
   */
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a < 0 || b < 0 || c < 0){
            throw new IllegalArgumentException("Triangle side should be non-negative");
        } else if ((a + b) < c || (a + c) < b || (c + b) < a ){
            throw new IllegalArgumentException("Violation Triangle inequality");
        }




    }


    /*4.1 Сравнение треугольников*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.c, this.c) == 0)
                || (Double.compare(triangle.a, this.b) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.c, this.c) == 0)
                || (Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.c, this.b) == 0)
                || (Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.b) == 0)
                || (Double.compare(triangle.a, this.b) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.a) == 0)
                || (Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.c, this.a) == 0);

    }

    @Override
    public int hashCode() {
        return 1;
    }
}
