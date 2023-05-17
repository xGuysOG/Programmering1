package Opgave5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Excerise 5");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField nameField = new TextField();
    private final TextArea nameArea = new TextArea();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label nameText = new Label("Name:");
        pane.add(nameText, 0, 0);
        pane.add(nameField, 0, 1);
        nameField.setEditable(true);

        Button addButton = new Button("Add");
        pane.add(addButton, 0, 2);
        addButton.centerShapeProperty();
        GridPane.setMargin(addButton, new Insets(0, 0, 0, 70));
        addButton.setOnAction(event -> this.fillAction());

        pane.add(nameArea, 0, 3);
        nameArea.setPrefRowCount(7);
        nameArea.setPrefWidth(190);
        nameArea.setEditable(false);

    }

    public void fillAction() {
        StringBuilder stringBuilder = new StringBuilder(nameArea.getText());
        stringBuilder.append(nameField.getText() + "\n");
        nameField.setText("");
        nameArea.setText(stringBuilder.toString());
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("A text area is often used for output.\n");
        sb.append("This text has so many lines\n");
        sb.append("that a scrollbar is added to the right, \n");
        sb.append("as you can see for yourself.\n");
        sb.append("You will have to scroll down\n");
        sb.append("to see the last line.\n");
        sb.append("\n\n\n\n");
        sb.append("This is the last line.");
        return sb.toString();
    }
    // ------------------------------------------------------------------------
}
