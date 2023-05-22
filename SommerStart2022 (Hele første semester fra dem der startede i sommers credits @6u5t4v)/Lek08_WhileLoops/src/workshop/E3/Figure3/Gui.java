package workshop.E3.Figure3;

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
        final int amount = 5;

        final double maxWidth = 180;
        double width = maxWidth / amount;

        final int topY = 20;
        final int bottomY = 180;
        final double deltaY = bottomY - topY;
        double y = topY;

        double x1;
        double x2;

        while (width <= maxWidth) {
            x1 = 100 - (width / 2);
            x2 = 100 + (width / 2);

            System.out.println(y);
            gc.strokeLine(x1, y, x2, y);

            y += deltaY / (amount - 1);
            width += maxWidth / amount;
        }
    }

}
