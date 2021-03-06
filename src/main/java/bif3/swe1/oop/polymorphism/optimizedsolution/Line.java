package bif3.swe1.oop.polymorphism.optimizedsolution;

public class Line extends Shape implements ShapeCompositionInterface {
    private int x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1);
    }

    @Override
    public double getArea() {
        return 0;   // ???, a line does not have an area
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt( (x2-x)*(x2-x) + (y2-y)*(y2-y) );
    }

    @Override
    public void printShapeType() {
        System.out.printf("I'm a Line from %d,%d to %d,%d\n", x, y, x2, y2);
    }
}
