package ru.ld.geometry.figures;

public record Triangle(double a, double b, double c) {

   public double countTriangle(){
       return this.a + this.b + this.c;
   }

    public double squareTriangle() {
        double p = (countTriangle()) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
