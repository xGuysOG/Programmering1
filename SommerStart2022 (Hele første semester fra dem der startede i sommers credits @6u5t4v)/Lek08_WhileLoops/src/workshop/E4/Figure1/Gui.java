package workshop.E4.Figure1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent() {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc) {
        int x = 100;
        int y = 100;
        int circles = 5;

        double radiusIncrement = (gc.getCanvas().getWidth() / 2) / circles;
        double radius = radiusIncrement;

        while (circles > 0) {
            gc.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
            radius += radiusIncrement;

            circles--;
        }
    }

}
