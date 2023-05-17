package Opgave3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        createCircle(pane, 200, 150, 50);

        createCircle(pane, 180, 135, 6);

        createCircle(pane, 220, 135, 6);

        Line line2 = new Line(180, 170, 220, 170);
        line2.setStrokeWidth(2);
        line2.setStroke(Color.BLACK);
        pane.getChildren().add(line2);



    }

    public void createCircle(Pane pane, int x, int y, int r) {
        Circle circle1 = new Circle();
        circle1.setCenterX(x);
        circle1.setCenterY(y);
        circle1.setRadius(r);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);
        pane.getChildren().add(circle1);
    }
}
