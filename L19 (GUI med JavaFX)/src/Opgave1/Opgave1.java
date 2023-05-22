package Opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave1 extends Application {

    public Person person;

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

    private final TextField nameField = new TextField();
    private final TextField titleField = new TextField();
//    private final TextArea personArea = new TextArea();

    private final ListView personList = new ListView();
    private final CheckBox cbx = new CheckBox();
    private final Button createButton = new Button("Create");
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);


        Label nameText = new Label("Name:");
        pane.add(nameText,0,0);
        pane.add(nameField, 1, 0);
        nameField.setEditable(true);

        Label titleText = new Label("Title:");
        pane.add(titleText,0,1);
        pane.add(titleField, 1, 1);
        titleField.setEditable(true);

        pane.add(cbx, 1, 2);
        cbx.setText("Senior");

        Button updateButton = new Button("Add person");
        pane.add(updateButton, 2, 2);
        updateButton.setOnAction(event -> this.addPerson());

        Label studentInfoText = new Label("Persons:");
        pane.add(studentInfoText, 0, 3);
        pane.add(personList, 1, 3);
        personList.setPrefHeight(200);
        personList.setPrefWidth(180);
        personList.setEditable(false);




    }
    // ------------------------------------------------------------------------

    private void addPerson() {
        String name = nameField.getText().trim();
        String title = titleField.getText().trim();
        if (name.length() < 1 || title.length() < 1) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Name or title field mising");
            errorAlert.setContentText("Big error");
            errorAlert.showAndWait();
        } else {
            boolean isSenior = cbx.isSelected();
            Person person = new Person(name, title, isSenior);
            personList.getItems().add(person);
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setHeaderText("Person added");
            errorAlert.setContentText("The person: " + name + " has been added to the list");
            errorAlert.showAndWait();
        }
    }

}
