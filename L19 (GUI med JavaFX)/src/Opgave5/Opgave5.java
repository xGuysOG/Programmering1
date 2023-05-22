package Opgave5;

import Opgave1.Person;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Opgave5 extends Application {

    public Person person;

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

    private final ListView<String> personList = new ListView();
    private final TextField nameField = new TextField();
    ArrayList<String> boys = new ArrayList<>();
    ArrayList<String> girls = new ArrayList<>();

    private final ToggleGroup group = new ToggleGroup();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        girls = this.initGirls();
        boys = this.initBoys();
        HBox box = new HBox();
        pane.add(box, 1, 0);
        //Radio button here
        RadioButton boysButton = new RadioButton();
        box.getChildren().add(boysButton);
        boysButton.setText("Boys");
        boysButton.setPrefWidth(70);
        // make the radio button remember its own color
        boysButton.setUserData(boys);
        // ensure that only one radio button is in selected state
        boysButton.setToggleGroup(group);
        // set the method to execute when a radio button is selected
        boysButton.setOnAction(event -> this.selectGender());

        RadioButton girlsButton = new RadioButton();
        box.getChildren().add(girlsButton);
        girlsButton.setText("Girls");
        girlsButton.setPrefWidth(70);
        // make the radio button remember its own color
        girlsButton.setUserData(girls);
        // ensure that only one radio button is in selected state
        girlsButton.setToggleGroup(group);
        // set the method to execute when a radio button is selected
        girlsButton.setOnAction(event -> this.selectGender());

        Label names = new Label("Names: ");
        pane.add(names, 0, 1);
        GridPane.setValignment(names, VPos.TOP);
        pane.add(personList, 1, 1);
        personList.setPrefHeight(200);
        personList.setPrefWidth(230);
        personList.setEditable(false);

        Label nameText = new Label("Name: ");
        pane.add(nameText, 0, 2);

        pane.add(nameField, 1, 2);
        nameField.setEditable(true);

        Button addButton = new Button("Add");
        pane.add(addButton, 2, 2);
        addButton.setOnAction(event -> this.addChild());

        girlsButton.setSelected(true);
        personList.getItems().addAll(girls);
//        personList.getItems().setAll(this.initNames());


    }
    // ------------------------------------------------------------------------

    private void selectGender() {
        personList.getItems().clear();
        RadioButton button = (RadioButton) group.getSelectedToggle();
        personList.getItems().setAll((ArrayList<String>) button.getUserData());
    }
    private void addChild() {
        String name = nameField.getText().trim();
        if (name.length() > 0) {
            personList.getItems().clear();
            RadioButton button = (RadioButton) group.getSelectedToggle();
            ArrayList<String> test = (ArrayList<String>) button.getUserData();
            test.add(name);
            personList.getItems().setAll(test);
            nameField.clear();
        }
    }
    private ArrayList<String> initBoys() {
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

    private ArrayList<String> initGirls() {
        girls.add("Jane");
        girls.add("Eva");
        girls.add("Lene");
        girls.add("Mette");
        girls.add("Tine");
        girls.add("Line");
        girls.add("Lone");
        girls.add("Alberte");
        girls.add("Pia");
        return girls;
    }

}
