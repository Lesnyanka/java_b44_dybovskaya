package ru.ld.geometry.figures;

public record Square(double side) {

    
    public static void printSquareArea(Square s) {
        System.out.println("Площадь квадрата со стороной " + s.side + " = " + s.area());
     }

    public static double squareArea(double a) {
        return a * a;
    }




    public double area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return 4 * this.side;
    }
}
