package Opgave7orEX2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class UI extends Application {


    ArrayList<Person> persons = new ArrayList<>();
    Label nameLabel = new Label("Name:");
    Label ageLabel = new Label("Age:");
    Button okButton = new Button("OK");
    TextField ageField = new TextField();
    TextField nameField = new TextField();
    ListView<Person> personListView = new ListView<>();
    Label errorLabel = new Label();
    @Override
    public void start(Stage stage) {
        stage.setTitle("Excerise 7");
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        personListView.getItems().addAll(persons);
        VBox leftPane = new VBox(personListView);

        GridPane rightPane = new GridPane();
        rightPane.setHgap(10);
        rightPane.setVgap(10);
        rightPane.setAlignment(Pos.CENTER);
        rightPane.add(nameLabel, 0, 0);
        rightPane.add(nameField, 1, 0);
        rightPane.add(ageLabel, 0, 1);
        rightPane.add(ageField, 1, 1);
        rightPane.add(okButton, 1, 2);
        okButton.setOnAction(event -> this.okButton());
        rightPane.add(errorLabel, 0, 3, 2, 1);

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(leftPane);
        mainPane.setRight(rightPane);
        mainPane.setPadding(new Insets(10));

        Scene scene = new Scene(mainPane, 600, 400);

        stage.setTitle("Person App");
        stage.setScene(scene);
        stage.show();
    }

    private void okButton() {
        String name = nameField.getText();
        String ageText = ageField.getText();

        // Validate the name field
        if (name.isEmpty()) {
            errorLabel.setText("Name cannot be empty");
            nameField.setStyle("-fx-border-color: red;");
            return;
        }

        // Validate the age field
        int age;
        try {
            age = Integer.parseInt(ageText);
            if (age < 0) {
                errorLabel.setText("Age cannot be negative");
                ageField.setStyle("-fx-border-color: red;");
                return;
            }
        } catch (NumberFormatException e) {
            errorLabel.setText("Age must be an integer");
            ageField.setStyle("-fx-border-color: red;");
            return;
        }

        // Add the person and update the list view
        Person person = new Person(age, name);
        persons.add(person);
        personListView.getItems().add(person);

        // Clear the form
        nameField.setText("");
        ageField.setText("");
    }

}
