package Opgave3;

import Opgave1.Person;
import demotwowindows.Movie;
import demotwowindows.MovieInputWindow;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class Opgave3 extends Application {

    public Person person;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Excerise 3");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        personWindow = new PersonInput("Create a person", stage);
    }

    // -------------------------------------------------------------------------

    private final ListView personList = new ListView();
    private PersonInput personWindow;
    ArrayList<String> boys = new ArrayList<>();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Button addButton = new Button("Add person");
        pane.add(addButton, 2, 1);
        addButton.setOnAction(event -> this.addPerson());

        Label studentInfoText = new Label("Persons");
        pane.add(studentInfoText, 0, 0);
        pane.add(personList, 0, 1);
        personList.setPrefHeight(200);
        personList.setPrefWidth(230);
        personList.setEditable(false);




    }
    // ------------------------------------------------------------------------

    private void addPerson() {
        personWindow.showAndWait();

        // wait for the dialog to close ...

        if (personWindow.getPerson() != null) {
            Person person = personWindow.getPerson();
            personList.getItems().add(person);
        }
    }

}
