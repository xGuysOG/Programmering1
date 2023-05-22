package countup_opg4;

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
        stage.setTitle("Tæl op");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfCounter = new TextField("50");
    private final Button btnIncrease = new Button("+");
    private final Button btnDecrease = new Button("-");

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Number:");
        pane.add(lblName, 0, 1);

        pane.add(txfCounter, 1, 1, 2, 1);

        pane.add(btnIncrease, 3, 0);
//        GridPane.setMargin(btnIncrease, new Insets(10, 10, 0, 10));
        btnIncrease.setOnAction(event -> this.increaseAction());

        pane.add(btnDecrease, 3, 2);
//        GridPane.setMargin(btnDecrease, new Insets(10, 10, 10, 10));
        btnDecrease.setOnAction(event -> this.decreaseAction());
    }

    // -------------------------------------------------------------------------

    private void increaseAction() {
        int number = Integer.parseInt(txfCounter.getText().trim());
//        number++;
        txfCounter.setText(String.valueOf(++number));
    }

    private void decreaseAction() {
        int number = Integer.parseInt(txfCounter.getText().trim());
//        number--;
        txfCounter.setText(String.valueOf(--number));
    }
}
