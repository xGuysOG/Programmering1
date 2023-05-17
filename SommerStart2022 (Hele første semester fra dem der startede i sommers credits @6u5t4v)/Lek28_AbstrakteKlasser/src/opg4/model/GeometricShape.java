package opg4.model;

public abstract class GeometricShape {
    private double xPos, yPos;

    public GeometricShape(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public abstract void display();

    public abstract double size();

    public void translate(double x, double y) {
        this.xPos += x;
        this.yPos += y;
    }

    public void setXPos(double xPos) {
        this.xPos = xPos;
    }

    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }
}
