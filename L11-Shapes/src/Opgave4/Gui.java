package Opgave4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
        createCircle(pane, 200, 150, 50, 13);
        createCircle(pane, 200, 150, 30, 13);
        createCircle(pane, 200, 150, 5, 13);



    }

    public void createCircle(Pane pane, int x, int y, int r, double strokeWidth) {
        Circle circle1 = new Circle();
        circle1.setCenterX(x);
        circle1.setCenterY(y);
        circle1.setRadius(r);
        circle1.setStrokeWidth(strokeWidth);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);
        pane.getChildren().add(circle1);
    }
}
