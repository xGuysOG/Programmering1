package OPG_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

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
        Color clr = Color.YELLOW;
        double moveX = 100;

        Rectangle rect = new Rectangle(70, 70, 100, 50);
        rect.setTranslateX(moveX);
        rect.setY(100);
        rect.setFill(clr);
        pane.getChildren().add(rect);

        Circle circle = new Circle(200, 100, 40);
        circle.setTranslateX(moveX);
        circle.setFill(clr);
        pane.getChildren().add(circle);

        Line line = new Line(300, 300, 150, 150);
        line.setFill(clr);
        circle.setTranslateX(moveX);
        pane.getChildren().add(line);
    }
}
