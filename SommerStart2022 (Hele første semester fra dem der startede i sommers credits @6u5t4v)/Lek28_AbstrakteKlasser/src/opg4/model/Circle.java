package opg4.model;

public class Circle extends Ellipse {
    private final double radius;

    public Circle(double xPos, double yPos, double radius) {
        super(xPos, yPos, radius, radius);
        this.radius = radius;
    }

    @Override
    public void display() {
        double areal = size();
        System.out.println("Cirkel(" + radius + ") med Areal: " + areal + " lokeret i punkt (" + getXPos() + "," + getYPos() + ")");
    }
}
