package combinenames_opg1;

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
        stage.setTitle("Kombiner Navne");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfFName = new TextField();
    private final TextField txfLName = new TextField();
    private final TextField txfResult = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(txfFName, 0, 0, 2, 1);
        pane.add(txfLName, 2, 0, 2, 1);
        pane.add(txfResult, 0, 1, 6, 1);

        // add a button to the pane (at col=1, row=1)
        Button btnCombine = new Button("Kombiner");
        pane.add(btnCombine, 0, 2);
        GridPane.setMargin(btnCombine, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnCombine.setOnAction(event -> this.combineAction());
    }

    // -------------------------------------------------------------------------

    private void combineAction() {
        String fName = txfFName.getText().trim();
        String lName = txfLName.getText().trim();

        txfResult.setText(fName + " " + lName);
    }
}
