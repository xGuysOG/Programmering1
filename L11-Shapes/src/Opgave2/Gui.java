package Opgave2;

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
        Rectangle rectangle = new Rectangle(25, 100, 100, 60);
        rectangle.setStroke(Color.BLUE);
        rectangle.setFill(Color.BLUE);
        pane.getChildren().add(rectangle);
        Text text1 = new Text(45, 135, "Casper");
        text1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        text1.setStroke(Color.RED);
        text1.setFill(Color.RED);
        pane.getChildren().add(text1);



    }
}
