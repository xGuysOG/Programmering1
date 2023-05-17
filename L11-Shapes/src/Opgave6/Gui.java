package Opgave6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane) {
        createLine(pane, 40, 350, 210, 350, 2 ,Color.BLACK);
        createLine(pane, 210, 350, 340, 350, 5 ,Color.GREEN);
        createCircle(pane, 300, 100, 30, 2, Color.BLACK);
        createRectangle(pane, 90, (350 - 120), 120, 120, Color.RED);
        createRectangle(pane, 120, (350 - 100), 40, 40, Color.BLACK);
        createTriangle(pane, 60, 230, 240, 230, 150, 120, Color.GREEN);


    }

    public void createTriangle(Pane pane, double point1x, double point1y, double point2x, double point2y, double point3x, double point3y, Color color) {
        Polygon polygon = new Polygon(point1x, point1y, point2x ,point2y, point3x, point3y);
        // Polyline polygon = new Polyline(points);
        polygon.setFill(color);
        polygon.setStroke(color);
        pane.getChildren().add(polygon);
    }

    public void createLine(Pane pane, int xStart, int yStart, int xEnd, int yEnd, int strokeWidth, Color color) {
        Line line2 = new Line(xStart, yStart, xEnd, yEnd);
        line2.setStrokeWidth(strokeWidth);
        line2.setStroke(color);
        pane.getChildren().add(line2);
    }
    public void createRectangle(Pane pane, int xPos, int yPos, int width, int height, Color color) {
        Rectangle r1 = new Rectangle(xPos, yPos, width, height);
        r1.setStroke(color);
        r1.setFill(color);
        pane.getChildren().add(r1);
    }

    public void createCircle(Pane pane, int x, int y, int r, double strokeWidth, Color strokeColor) {
        Circle circle1 = new Circle();
        circle1.setCenterX(x);
        circle1.setCenterY(y);
        circle1.setRadius(r);
        circle1.setStrokeWidth(strokeWidth);
        circle1.setStroke(strokeColor);
        circle1.setFill(Color.YELLOW);
        pane.getChildren().add(circle1);
    }
}
