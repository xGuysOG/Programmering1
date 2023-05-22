package Opgave4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Excerise 4");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField celciusField = new TextField();
    private final TextField fahrenheitField = new TextField();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label celText = new Label("Celcius:");
        pane.add(celText, 0, 0);
        pane.add(celciusField, 1, 0);
        celciusField.setEditable(true);

        Label fahText = new Label("Fahrenheit:");
        pane.add(fahText, 0, 1);
        pane.add(fahrenheitField, 1, 1);
        fahrenheitField.setEditable(true);


        Button combineButton = new Button("Calculate");
        pane.add(combineButton, 1, 3);
        combineButton.centerShapeProperty();
        GridPane.setMargin(combineButton, new Insets(0, 0, 0, 40));
        combineButton.setOnAction(event -> this.calculateInterest());

    }
    // ------------------------------------------------------------------------
    private void calculateInterest() {
        if (celciusField.getText().length() > 0 && fahrenheitField.getText().length() > 0) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error temp in both");
            errorAlert.setContentText("You need 1 empty side to calculate the temps, im now clearing them all for you");
            errorAlert.showAndWait();
            celciusField.setText("");
            fahrenheitField.setText("");
            return;
        }
        else if (celciusField.getText().length() > 0) {
            double celcius = Double.parseDouble(celciusField.getText());
            //F=9/5*C+32
            double fahrenheit = ((celcius*9)/5)+32;
            fahrenheitField.setText(String.valueOf(fahrenheit));
        }

        else if (fahrenheitField.getText().length() > 0) {
            double fahrenheit = Double.parseDouble(fahrenheitField.getText());
            //F=9/5*C+32
            double celcius = ((fahrenheit - 32)*5)/9;
            celciusField.setText(String.valueOf(celcius));
        }

    }
}
