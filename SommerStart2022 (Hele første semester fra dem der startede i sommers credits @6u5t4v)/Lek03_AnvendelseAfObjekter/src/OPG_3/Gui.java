package OPG_3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);
        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Circle head = new Circle(200, 200, 100);
        head.setFill(Color.BEIGE);
        head.setStroke(Color.BLACK);
        pane.getChildren().add(head);

        Circle eye1 = new Circle(150, 160, 20);
        eye1.setFill(Color.WHITE);
        eye1.setStroke(Color.BLACK);
        pane.getChildren().add(eye1);

        Circle pupil1 = new Circle(150, 160, 10);
        pane.getChildren().add(pupil1);

        Ellipse ear1 = new Ellipse(100, 150, 10,30);
        ear1.setFill(Color.BEIGE);
        pane.getChildren().add(ear1);

        Ellipse ear2 = new Ellipse(300, 150, 10,30);
        ear2.setFill(Color.BEIGE);
        pane.getChildren().add(ear2);

        Circle eye2 = new Circle(250, 160, 20);
        eye2.setFill(Color.WHITE);
        eye2.setStroke(Color.BLACK);
        pane.getChildren().add(eye2);

        Circle pupil2 = new Circle(250, 160, 10);
        pane.getChildren().add(pupil2);

        Circle mouth = new Circle(200, 250, 30);
        pane.getChildren().add(mouth);

        Ellipse tongue = new Ellipse(200, 265, 15, 20);
        tongue.setFill(Color.RED);
        pane.getChildren().add(tongue);
    }
}
