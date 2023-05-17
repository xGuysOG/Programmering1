package Opgave5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
        createCircle(pane, 140, 150, 30, 3, Color.BLUE);
        createCircle(pane, 200, 150, 30, 3, Color.BLACK);
        createCircle(pane, 260, 150, 30, 3, Color.RED);
        createCircle(pane, 170, 180, 30, 3, Color.YELLOW);
        createCircle(pane, 230, 180, 30, 3, Color.GREEN);


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
