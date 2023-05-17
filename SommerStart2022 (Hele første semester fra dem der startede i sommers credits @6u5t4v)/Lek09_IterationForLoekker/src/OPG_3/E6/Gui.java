package OPG_3.E6;

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
        int strokeY = 150;
        int strokeWidth = 180;

        gc.strokeLine(0, strokeY, strokeWidth, strokeY);

        int between = strokeWidth / 11;
        int tick = 0;

        for (int x = 15; x < strokeWidth; x += between) {
            if (x % 5 == 0) {
                gc.strokeLine(x, 140, x, 160);
                gc.fillText(tick + "", x, 170);
                tick += 5;
            } else {
                gc.strokeLine(x, 145, x, 155);
            }
        }

        int x = 190;
        double xSize = 5;
        double ySize = 2.5;

        gc.strokeLine(strokeWidth, strokeY, x, strokeY);
        gc.strokeLine(x, strokeY, x - xSize, strokeY + ySize);
        gc.strokeLine(x, strokeY, x - xSize, strokeY - ySize);
    }
}
