package opg4.model;

public class Rectangle extends GeometricShape {
    private double length, width;

    public Rectangle(double xPos, double yPos, double length, double width) {
        super(xPos, yPos);
        this.length = length;
        this.width = width;
    }

    @Override
    public double size() {
        return width * length;
    }

    @Override
    public void display() {
        double areal = size();
        System.out.println("Rektangel(" + length + "," + width + ") med Areal: " + areal + " lokeret i punkt (" + getXPos() + "," + getYPos() + ")");
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
