package Opgave4;

public class Rectangle {
	double width;
	double height;

	public Rectangle() {
		width = 1;
		height = 1;
	} 

	public Rectangle(double newWidth, double newHeight) {
		width = newWidth;
		height = newHeight;
	}

	double getArea() {
		return width * height; 
	}

	double getPerimeter() {
		return 2 * (width + height);
	}
	
    @Override
    public String toString() {
        return String.format("Employee(%s, %s)", width, height);
    }
}