package Opgave4;

import Opgave1.Person;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Opgave4 extends Application {

    public Person person;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Excerise 4");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<String> personList = new ListView();
    private final TextField nameField = new TextField();
    ArrayList<String> boys = new ArrayList<>();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label names = new Label("Names: ");
        pane.add(names, 0, 0);
        GridPane.setValignment(names, VPos.TOP);
        pane.add(personList, 1, 0);
        personList.setPrefHeight(200);
        personList.setPrefWidth(230);
        personList.setEditable(false);

        Label nameText = new Label("Name: ");
        pane.add(nameText, 0, 2);

        pane.add(nameField, 1, 2);
        nameField.setEditable(true);

        Button addButton = new Button("Add");
        pane.add(addButton, 2, 2);
        addButton.setOnAction(event -> this.addBoy());

        personList.getItems().setAll(this.initNames());


    }
    // ------------------------------------------------------------------------

    private void addBoy() {
        String name = nameField.getText().trim();
        if (name.length() > 0) {
            boys.add(name);
            personList.getItems().setAll(boys);
            nameField.clear();
        }
    }
    private ArrayList<String> initNames() {
        boys.add("Ole");
        boys.add("Jens");
        boys.add("Jørgen");
        boys.add("Lars");
        boys.add("Jacob");
        boys.add("Allan");
        boys.add("Victor");
        boys.add("Alexander");
        boys.add("Simon");
        return boys;
    }

}
