package OPG_4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
        Circle ring2 = new Circle(200, 200, 125);
        pane.getChildren().add(ring2);
        ring2.setFill(Color.BLACK);

        Circle ring3 = new Circle(200, 200, 100);
        pane.getChildren().add(ring3);
        ring3.setFill(Color.WHITE);

        Circle ring4 = new Circle(200, 200, 75);
        pane.getChildren().add(ring4);
        ring4.setFill(Color.BLACK);

        Circle ring5 = new Circle(200, 200, 50);
        pane.getChildren().add(ring5);
        ring5.setFill(Color.WHITE);

        Circle ring6 = new Circle(200, 200, 25);
        pane.getChildren().add(ring6);
        ring6.setFill(Color.BLACK);
    }
}
