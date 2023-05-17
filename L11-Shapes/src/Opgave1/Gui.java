package Opgave1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
        int right = 100;
        Color color = Color.YELLOW;
        Circle circle = new Circle(120 + right, 120 + right, 30);
        circle.setFill(color);
        circle.setStroke(color);
        pane.getChildren().add(circle);

        Rectangle rectangle = new Rectangle(25, 80, 60, 30);
        rectangle.setStroke(color);
        rectangle.setFill(color);
        pane.getChildren().add(rectangle);

        Line line1 = new Line(160, 200, 200, 220);
        line1.setStrokeWidth(5);
        line1.setStroke(color);
        pane.getChildren().add(line1);

    }
}
