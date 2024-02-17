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
    void calculateSquarePerimetr(){
        Assertions.assertEquals(81.97560612767678, new Triangle(16.0, 13.0, 13.0).squareTriangle());

    }
/* Нельзя создать треугольник с отрицательной стороной/*

 */
    @Test
    void cannotCreateTriangleWithNegativeSide(){
        try {
            new Triangle(-5.0, 10.0, 10.0);
            Assertions.fail();

        }catch(IllegalArgumentException exeption){
            //ok
        }




    }
    /*Сумма двух любых сторон должна быть не меньше третьей стороны*/
    @Test
    void violationTringleInequality(){
        try {
            new Triangle(5.0, 8.0, 15.0);
            Assertions.fail();
        }catch(IllegalArgumentException exeption){
            //ok
        }
        }
    }



