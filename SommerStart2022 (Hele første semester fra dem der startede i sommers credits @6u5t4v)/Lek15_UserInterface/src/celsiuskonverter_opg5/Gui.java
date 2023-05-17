package celsiuskonverter_opg5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Konverter Grader");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfInput = new TextField("0");
    private final TextField txfOutput = new TextField("-17.77777777777778");
    private final Button btnToCelsius = new Button("Celsius");
    private final Button btnToFahrenheit = new Button("Fahrenheit");

    private final Label label = new Label("Celsius");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(txfInput, 0, 0, 2, 1);

        pane.add(label, 0, 1);

        txfOutput.setEditable(false);
        pane.add(txfOutput, 1, 1);

        pane.add(btnToCelsius, 0, 2);
        GridPane.setMargin(btnToCelsius, new Insets(10, 10, 0, 10));
        btnToCelsius.setOnAction(event -> this.toCelsiusAction());

        pane.add(btnToFahrenheit, 1, 2);
        GridPane.setMargin(btnToFahrenheit, new Insets(10, 10, 0, 10));
        btnToFahrenheit.setOnAction(event -> this.toFahrenheitAction());
    }

    // -------------------------------------------------------------------------

    private void toCelsiusAction() {
        if (!txfInput.getText().isEmpty()) {
            double fahrenheit = Double.parseDouble(txfInput.getText().trim());
            double celsius = (double) 5 / 9 * (fahrenheit - 32);
            label.setText("Celsius");
            txfOutput.setText("" + celsius);
        }
    }

    private void toFahrenheitAction() {
        if (!txfInput.getText().isEmpty()) {
            double celsius = Double.parseDouble(txfInput.getText().trim());

            double fahrenheit = (double) 9 / 5 * celsius + 32;
            label.setText("Fahrenheit");
            txfOutput.setText("" + fahrenheit);
        }
    }
}
