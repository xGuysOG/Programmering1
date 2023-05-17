package Opgave7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Gui extends Application {
    public static int currentStage = 1;

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
        createCircle(pane, 70, 440, 60, 2, Color.BLACK);
        if (currentStage >= 1) {
            createLine(pane , 70 ,380, 70, 20, 2, Color.BLACK);
        }
        if (currentStage >= 2) {
            createCircle(pane, 70, 440, 60, 2, Color.BLACK);
        }
        if (currentStage >= 3) {
            createLine(pane , 70 ,380, 70, 20, 2, Color.BLACK);
        }
        if (currentStage >= 4) {
            createLine(pane, 70, 20, 250, 20, 2, Color.BLACK);
        }

        if (currentStage >= 5) {
            createLine(pane, 250, 20, 250, 50, 2, Color.BLACK);
        }
        if (currentStage >= 6) {
            createCircle(pane, 250, 80, 30, 2, Color.BLACK);
        }
        if (currentStage >= 7) {
            createLine(pane, 250, 110, 250, 230, 2, Color.BLACK);
        }
        if (currentStage >= 8) {
            createLine(pane, 250, 130, 160, 200, 2, Color.BLACK);
        }
        if (currentStage >= 9) {
            createLine(pane, 250, 130, 340, 200, 2, Color.BLACK);
        }
        if (currentStage >= 10) {
            createLine(pane, 250, 230, 190, 310, 2, Color.BLACK);
        }
        if (currentStage >= 11) {
            createLine(pane, 250, 230, 310, 310, 2, Color.BLACK);
        }
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
        circle1.setFill(Color.TRANSPARENT);
        pane.getChildren().add(circle1);
    }
}
