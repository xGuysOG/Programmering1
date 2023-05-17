package swap_opg2;

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
        stage.setTitle("Swap frame");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfUpper = new TextField();
    private final TextField txfLower = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(txfUpper, 0, 0, 2, 1);
        pane.add(txfLower, 0, 1, 2, 1);

        Button btnSwap = new Button("Ombyt");
        pane.add(btnSwap, 0, 2);
        GridPane.setMargin(btnSwap, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnSwap.setOnAction(event -> this.swapAction());
    }

    // -------------------------------------------------------------------------

    private void swapAction() {
        String upper = txfUpper.getText().trim();
        String lower = txfLower.getText().trim();

        txfUpper.setText(lower);
        txfLower.setText(upper);
    }
}
