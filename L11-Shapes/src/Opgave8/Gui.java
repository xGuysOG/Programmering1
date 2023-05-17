package Opgave8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
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
        createCircle(pane,200,200,130,2, Color.BLACK, Color.TRANSPARENT);
        createEllipse(pane, 150, 150, 30 ,20 , Color.BLACK);
        createEllipse(pane, 250, 150, 30 ,20 , Color.BLACK);
        createCircle(pane,150,150,15,2, Color.BLACK, Color.BLACK);
        createCircle(pane,250,150,15,2, Color.BLACK, Color.BLACK);

        createTriangle(pane, 175, 225, 225,225, 200, 170, Color.BLACK, Color.TRANSPARENT);

        Arc arc2 = new Arc(200, 190, 80, 80, 230, 80);
        arc2.setFill(Color.WHITE);
        arc2.setType(ArcType.OPEN);
        arc2.setStroke(Color.BLACK);
        arc2.setStrokeWidth(2);
        pane.getChildren().add(arc2);


    }

    public void createEllipse(Pane pane, int x, int y, int with, int height, Color color) {
        Ellipse e1 = new Ellipse(x,y,with,height);
        e1.setFill(Color.TRANSPARENT);
        e1.setStrokeWidth(2);
        e1.setStroke(color);
        pane.getChildren().add(e1);
    }

    public void createTriangle(Pane pane, double point1x, double point1y, double point2x, double point2y, double point3x, double point3y, Color color, Color fillColor) {
        Polygon polygon = new Polygon(point1x, point1y, point2x ,point2y, point3x, point3y);
        // Polyline polygon = new Polyline(points);
        polygon.setFill(fillColor);
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

    public void createCircle(Pane pane, int x, int y, int r, double strokeWidth, Color strokeColor, Color fillColor) {
        Circle circle1 = new Circle();
        circle1.setCenterX(x);
        circle1.setCenterY(y);
        circle1.setRadius(r);
        circle1.setStrokeWidth(strokeWidth);
        circle1.setStroke(strokeColor);
        circle1.setFill(fillColor);
        pane.getChildren().add(circle1);
    }
}
