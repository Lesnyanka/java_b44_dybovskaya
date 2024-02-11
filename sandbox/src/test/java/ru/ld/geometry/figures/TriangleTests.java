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


}
