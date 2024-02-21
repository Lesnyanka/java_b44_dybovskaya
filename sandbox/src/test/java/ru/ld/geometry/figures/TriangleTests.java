package ru.ld.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void calculatePerimetrTriangle() {
        var s = new Triangle(10.0, 6.0, 6.0);
        double result = s.countTriangle();
        Assertions.assertEquals(22.0, result);
    }

    @Test
    void calculateSquarePerimetr() {
        Assertions.assertEquals(81.97560612767678, new Triangle(16.0, 13.0, 13.0).squareTriangle());

    }


    /* 3.1 Исключение при попытке создать треугольник с отрицательной длиной стороны,*/

    @Test
    void cannotCreativeTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 8.0, 15.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
        }

    }

    /* 3.2 Нарушается неравенство треугольника*/

    @Test
    void violationTriangleInequality() {
        try {
            new Triangle(5.0, 8.0, 15.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ok
        }
    }




    /* 4.1 Сравнение треугольников*/

    @Test
    void compareTriangles() {
        var tri1 = new Triangle(6.0, 7.0, 10.0);
        var tri2 = new Triangle(6.0, 10.0, 7.0);
        var tri3 = new Triangle(7.0, 6.0, 10.0);
        var tri4 = new Triangle(7.0, 10.0, 6.0);
        var tri5 = new Triangle(10.0, 7.0, 6.0);
        var tri6 = new Triangle(10.0, 6.0, 7.0);
        Assertions.assertEquals(tri1, tri2);
        Assertions.assertEquals(tri1, tri3);
        Assertions.assertEquals(tri2, tri3);
        Assertions.assertEquals(tri4, tri5);
        Assertions.assertEquals(tri5, tri6);
        Assertions.assertEquals(tri3, tri6);

    }


}



