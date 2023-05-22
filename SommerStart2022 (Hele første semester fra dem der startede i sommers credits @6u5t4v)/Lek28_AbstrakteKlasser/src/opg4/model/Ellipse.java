package opg4.model;

public class Ellipse extends GeometricShape {
    private double r1, r2;

    public Ellipse(double xPos, double yPos, double r1, double r2) {
        super(xPos, yPos);
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public double size() {
        return Math.PI * (r1 * r2);
    }

    @Override
    public void display() {
        double areal = size();
        System.out.println("Ellipse(" + r1 + "," + r2 + ") med Areal: " + areal + " lokeret i punkt (" + getXPos() + "," + getYPos() + ")");
    }
}
