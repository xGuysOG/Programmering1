package splittekst_opg3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Split tekst");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfInput = new TextField();
    private final TextField txfFName = new TextField();
    private final TextField txfLName = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(txfInput, 0, 0, 2, 1);
        pane.add(txfFName, 0, 1);
        pane.add(txfLName, 1, 1);

        Button btnSwap = new Button("Split");
        pane.add(btnSwap, 0, 2);
        GridPane.setMargin(btnSwap, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnSwap.setOnAction(event -> this.swapAction());
    }

    // -------------------------------------------------------------------------

    private void swapAction() {
        String input = txfInput.getText().trim();
        String[] split = input.split(" ");

        if (split.length > 1) {
            txfFName.setText(split[0]);
            txfLName.setText(split[1]);
        }
    }
}
