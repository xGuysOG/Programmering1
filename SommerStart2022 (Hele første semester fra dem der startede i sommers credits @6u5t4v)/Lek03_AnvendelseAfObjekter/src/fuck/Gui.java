package fuck;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.Random;

public class Gui extends Application {

    private AnimationTimer timer;
    private Stage stage;
    private boolean paused;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        Pane root = this.initContent();
        Scene scene = new Scene(root);
        scene.setOnMousePressed(we->{
            if(we.getButton() == MouseButton.PRIMARY){
                paused = !paused;
            }
        });
        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);

        stage.setOnCloseRequest(we -> {
            timer.stop();
            System.out.println("Stopped");
        });

        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Random rand = new Random();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(paused) return;

                double randX = rand.nextDouble(stage.getWidth());
                double randY = rand.nextDouble(stage.getHeight());

                Types type = Types.values()[(int) (rand.nextDouble(Types.values().length))];
                Color color = Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble());

                Shape shape = null;
                switch (type) {
                    case RECT -> {
                        double randWidth = rand.nextDouble(15, type.maxSize[0]);
                        double randHeight = rand.nextDouble(15, type.maxSize[1]);

                        shape = new Rectangle(randX, randY, randWidth, randHeight);
                    }
                    case CIRCLE -> {
                        double randRadius = rand.nextDouble(15, type.maxSize[0]);

                        shape = new Circle(randX, randY, randRadius);
                    }
                }
                shape.setFill(color);

                pane.getChildren().add(shape);
            }
        };
        timer.start();
    }


}
