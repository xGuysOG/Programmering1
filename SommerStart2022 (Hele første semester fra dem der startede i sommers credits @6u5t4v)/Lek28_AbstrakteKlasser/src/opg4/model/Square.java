package opg4.model;

public class Square extends Rectangle {
    private double side;

    public Square(double xPos, double yPos, double side) {
        super(xPos, yPos, side, side);
        this.side = side;
    }

    @Override
    public void display() {
        double areal = size();
        System.out.println("Kvadrat(" + side + ") med Areal: " + areal + " lokeret i punkt (" + getXPos() + "," + getYPos() + ")");
    }
}
