package opg2;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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

    private ArrayList<Person> persons = new ArrayList<>();
    private ListView<Person> listView = new ListView<>();

    private Person current = null;

    private void initContent(GridPane pane) {
        listView.getItems().setAll(initPeople());

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Button btnAdd = new Button("Add Person");
        pane.add(btnAdd, 1, 0);
        GridPane.setValignment(btnAdd, VPos.TOP);
        GridPane.setMargin(btnAdd, new Insets(10, 10, 0, 10));

        pane.add(listView, 0, 0);

        ChangeListener<Person> listener = (ov, oldString, newString) -> this.selectionChanged();
        listView.getSelectionModel().selectedItemProperty().addListener(listener);

        btnAdd.setOnAction(e -> addPerson());
    }

    public void addPerson() {
        personInputWindow.showAndWait();

        if (personInputWindow.getActualPerson() != null) {
            persons.add(personInputWindow.getActualPerson());
            listView.getItems().setAll(persons);
        }
    }

    private ArrayList<Person> initPeople() {
        persons.add(new Person("Gustav", "Studerende", false));
        return persons;
    }

    private void selectionChanged() {
        Person selected = listView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            current = selected;
        }
    }
}
