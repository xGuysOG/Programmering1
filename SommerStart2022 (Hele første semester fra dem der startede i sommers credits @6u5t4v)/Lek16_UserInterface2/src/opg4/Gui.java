package opg4;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import opg2.PersonInputWindow;

import java.util.ArrayList;

public class Gui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Person Adminstration");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        personInputWindow = new PersonInputWindow("Add Person", stage);
    }

    PersonInputWindow personInputWindow;

    private ArrayList<String> boys = new ArrayList<>();
    private ListView<String> listView = new ListView<>();


    private void initContent(GridPane pane) {
        listView.getItems().setAll(initBoys());

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Button btnAdd = new Button("Add Person");
        pane.add(btnAdd, 2, 2);

        pane.add(listView, 1, 3);

        ChangeListener<String> listener = (ov, oldString, newString) -> this.selectionChanged();
        listView.getSelectionModel().selectedItemProperty().addListener(listener);

        btnAdd.setOnAction(e -> addPerson());
    }

    public void addPerson() {
        if (personInputWindow.getActualPerson() != null) {
            boys.add("something");
            listView.getItems().setAll(boys);
        }
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
