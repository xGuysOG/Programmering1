package OPG_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
        Rectangle rect = new Rectangle(70, 70, 250, 50);
        pane.getChildren().add(rect);

        rect.setFill(Color.RED);

        double centerTextX = (rect.getX() / 2) + rect.getX();
        double centerTextY = (rect.getY() / 2) + rect.getY();


        Text name = new Text(centerTextX, centerTextY, "Gustav");

        name.setTextAlignment(TextAlignment.CENTER);
        name.setFill(Color.BEIGE);
        name.setScaleX(3);
        name.setScaleY(3);

        pane.getChildren().add(name);
    }
}
