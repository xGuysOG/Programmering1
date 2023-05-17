package Opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Excerise 1");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField firstName = new TextField();
    private final TextField lastName = new TextField();

    private final TextField fullName = new TextField();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label firstText = new Label("First name:");
        pane.add(firstText, 0, 0);
        pane.add(firstName, 0, 1);
        firstName.setEditable(true);

        Label lastText = new Label("Last name:");
        pane.add(lastText, 2, 0);
        pane.add(lastName, 2, 1);
        lastName.setEditable(true);

        Label fullText = new Label("Full name");

        pane.add(fullText, 0, 2);
        pane.add(fullName, 0, 3,3,1);
        fullName.setEditable(false);

        Button combineButton = new Button("Combine");
        pane.add(combineButton, 2, 4);
//        GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

        // connect a method to the button
        combineButton.setOnAction(event -> this.combineAction());
    }
    private void combineAction() {
        String name = firstName.getText() + " " + lastName.getText();
        fullName.setText(name);
    }
    // ------------------------------------------------------------------------
}
