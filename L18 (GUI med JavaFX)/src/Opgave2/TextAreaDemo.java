package Opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Excerise 2");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField numberField = new TextField();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        numberField.setMaxWidth(50);
        Label numberText = new Label("Number:");
        pane.add(numberText, 0, 1);
        pane.add(numberField, 1, 1);
        numberField.setEditable(false);
        numberField.setText("1");

        Button incButton = new Button("Inc");
        pane.add(incButton, 3, 0);

        Button decButton = new Button("Dec");
        pane.add(decButton, 3, 2);
//        GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

        // connect a method to the button
        incButton.setOnAction(event -> this.incAction());
        decButton.setOnAction(event -> this.decAction());
    }
    // ------------------------------------------------------------------------

    private void incAction() {
        int amount = Integer.parseInt(numberField.getText()) + 1;
        numberField.setText(String.valueOf(amount));
    }

    private void decAction() {
        int amount = Integer.parseInt(numberField.getText()) - 1;
        numberField.setText(String.valueOf(amount));
    }
}
