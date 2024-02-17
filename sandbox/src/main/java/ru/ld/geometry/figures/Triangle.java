package ru.ld.geometry.figures;

public record Triangle(double a, double b, double c) {

    /*метод расчета периметра треугольника*/
    public double countTriangle(){
       return this.a + this.b + this.c;
   }
   /*метод расчета площади треугольника*/
    public double squareTriangle() {
        double p = (countTriangle()) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /* 3.1 создания треугольника с отрицательной длиной стороны
    * 3.2 неравенство треугольника*/
    public Triangle {
        if (a < 0 || b < 0 || c < 0){
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        else if ((a + b) > c || (a + c) > b || (c + b) > a ){
            throw new IllegalArgumentException("Violation Triangle inequality");
        }
    }

}
