package opg4;

import opg4.model.*;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Square square = new Square(30, 100, 50);
        Rectangle rectangle = new Rectangle(15, 150, 50, 30);
        Circle circle = new Circle(50, 200, 15);
        Ellipse ellipse = new Ellipse(70, 120, 10, 20);

        ArrayList<GeometricShape> shapes = new ArrayList<>();
        shapes.add(square);
        shapes.add(rectangle);
        shapes.add(circle);
        shapes.add(ellipse);

        for (GeometricShape shape : shapes) {
            shape.display();
        }
    }
}
