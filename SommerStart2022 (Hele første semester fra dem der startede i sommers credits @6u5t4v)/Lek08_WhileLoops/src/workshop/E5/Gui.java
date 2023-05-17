package workshop.E5;

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
        String str = "Datamatiker";

        int charAmount = 1;
        int y = 10;

        while (charAmount <= str.length()) {
            String letters = str.substring(0, charAmount);

            gc.fillText(letters, 20, y);
            y += 13;

            charAmount++;
        }

//        String b = "";
//
//        int index = 0;
////        int y = 10;
//
//        while (index < s.length()) {
//            b += s.charAt(index);
//
//            gc.setFill(Color.DARKORANGE);
//            gc.fillText(b, 20, y);
//
//            y += 15;
//            index++;
//        }
    }
}
