package ru.ld.geometry;

import ru.ld.geometry.figures.Rectangle;
import ru.ld.geometry.figures.Square;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square (7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));

        Rectangle.printRectanglArea(3.0, 5.0);
        Rectangle.printRectanglArea(7.0, 9.0);


     }

}



