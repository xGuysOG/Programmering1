package Opgave6;

import Opgave1.Person;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Opgave6 extends Application {

    public Person person;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Excerise 6");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    // -------------------------------------------------------------------------

    Slider redSlider = new Slider(0, 255,0);
    Slider greenSlider = new Slider(0, 255,0);
    Slider blueSlider = new Slider(0, 255,0);


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        Label red = new Label("Red: ");
        pane.add(red, 0, 0);
        Label green = new Label("Green: ");
        pane.add(green, 0, 1);
        Label blue = new Label("Blue: ");
        pane.add(blue, 0, 2);
        pane.add(redSlider, 1,0);
        redSlider.valueProperty().addListener(event -> this.sliderValueChanged(pane));
        pane.add(greenSlider, 1,1);
        greenSlider.valueProperty().addListener(event -> this.sliderValueChanged(pane));
        pane.add(blueSlider, 1,2);
        blueSlider.valueProperty().addListener(event -> this.sliderValueChanged(pane));

    }
    // ------------------------------------------------------------------------

    private void sliderValueChanged(GridPane pane) {

        int redValue = (int) redSlider.getValue();
        int greenValue = (int) greenSlider.getValue();
        int blueValue = (int) blueSlider.getValue();

        // Set the background color of the grid pane
        String color = String.format("#%02X%02X%02X", redValue, greenValue, blueValue);

        pane.setStyle("-fx-background: " + color);
    }

}
