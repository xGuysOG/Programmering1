package opg5;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Boys and Girls");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

//        personInputWindow = new PersonInputWindow("Add Person", stage);
    }


    private final ToggleGroup group = new ToggleGroup();
    private final TextField txtField = new TextField();
    private ArrayList<String> boys = new ArrayList<>();
    private ArrayList<String> girls = new ArrayList<>();
    private ListView<String> listView = new ListView<>();


    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        HBox rBBox = new HBox();
        pane.add(rBBox, 1, 0);

        RadioButton btnBoys = new RadioButton("Boys");
        rBBox.getChildren().add(btnBoys);
        btnBoys.setUserData(boys);
        btnBoys.setToggleGroup(group);
        btnBoys.setOnAction(event -> setList());
        btnBoys.setSelected(true);
        listView.getItems().setAll(initBoys());

        RadioButton btnGirls = new RadioButton("Girls");
        rBBox.getChildren().add(btnGirls);
        btnGirls.setUserData(girls);
        btnGirls.setToggleGroup(group);
        btnGirls.setOnAction(event -> setList());

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 1);
        GridPane.setValignment(lblNames, VPos.TOP);

        pane.add(listView, 1, 1);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 2);

        pane.add(txtField, 1, 2);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 2);
        btnAdd.setOnAction(e -> addPerson());

        ChangeListener<String> listener = (ov, oldString, newString) -> this.selectionChanged();
        listView.getSelectionModel().selectedItemProperty().addListener(listener);
    }

    public void addPerson() {
        String name = txtField.getText().trim();
        if (name.length() > 0) {
            RadioButton rb = (RadioButton) group.getSelectedToggle();
            ArrayList<String> list = (ArrayList<String>) rb.getUserData();
            list.add(name);
            listView.getItems().setAll(list);

            txtField.clear();
        }
    }

    private void setList() {
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        ArrayList<String> list = (ArrayList<String>) rb.getUserData();
        listView.getItems().setAll(list);
    }

    private ArrayList<String> initBoys() {
        boys.add("gustav");
        return boys;
    }

    private void selectionChanged() {
        String selected = listView.getSelectionModel().getSelectedItem();
        if (selected != null) {

        } else {
            // Clear fields
        }
    }
}
