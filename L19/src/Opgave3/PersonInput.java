package Opgave3;

import Opgave1.Person;
import demotwowindows.Movie;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInput extends Stage {

    public PersonInput(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField titleField = new TextField();
    private final TextField nameField = new TextField();

    private final CheckBox cbx = new CheckBox();
    private Person person = null;

    private void initContent(GridPane pane) {
//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblTitle = new Label("Name:");
        pane.add(lblTitle, 0, 0);

        Label lblActor = new Label("Title:");
        pane.add(lblActor, 0, 1);

        pane.add(nameField, 1, 0);

        pane.add(titleField, 1, 1);

        pane.add(cbx, 1, 2);
        cbx.setText("Senior");

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 3, 2, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void cancelAction() {
        titleField.clear();
        nameField.clear();
        nameField.requestFocus();
        cbx.setSelected(false);
        person = null;
        PersonInput.this.hide();
    }

    private void okAction() {
        String name = nameField.getText().trim();
        String title = titleField.getText().trim();
        boolean isSenior = cbx.isSelected();

        if (name.length() > 0 && title.length() > 0) {
            person = new Person(name, title, isSenior);
            nameField.clear();
            titleField.clear();
            nameField.requestFocus();
            PersonInput.this.hide();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Create person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type name, title and select if senior");
            alert.show();
        }
    }

    // -------------------------------------------------------------------------

    public Person getPerson() {
        return person;
    }

    public void clearPerson() {
        person = null;
    }
}
