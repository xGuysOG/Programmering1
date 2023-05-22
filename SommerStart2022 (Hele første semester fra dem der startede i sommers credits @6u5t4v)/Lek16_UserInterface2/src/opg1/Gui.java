package opg1;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    }

    private TextField txfName = new TextField();
    private TextField txfTitle = new TextField();
    private CheckBox chbSenior = new CheckBox("Senior");

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

        Label labelName = new Label("Name:");
        pane.add(labelName, 0, 0);
        pane.add(txfName, 1, 0);
        Label labelTitle = new Label("Title:");
        pane.add(labelTitle, 0, 1);
        pane.add(txfTitle, 1, 1);
        pane.add(chbSenior, 1, 2);

        Button btnAdd = new Button("Add Person");
        pane.add(btnAdd, 2, 2);

        Label labelPersons = new Label("Persons:");
        pane.add(labelPersons, 0, 3);
        pane.add(listView, 1, 3);

        ChangeListener<Person> listener = (ov, oldString, newString) -> this.selectionChanged();
        listView.getSelectionModel().selectedItemProperty().addListener(listener);

        btnAdd.setOnAction(e -> addPerson());
    }

    public void addPerson() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();

        if (!name.isEmpty() && !title.isEmpty()) {
            boolean isSenior = chbSenior.isSelected();
            persons.add(new Person(name, title, isSenior));
            listView.getItems().setAll(persons);
            clearFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing Fields");
            alert.setHeaderText("missing input in name or title");
            alert.setContentText("Type the name and title of the person");
            alert.show();
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
        } else {
            clearFields();
        }
    }

    private void clearFields() {
        txfName.clear();
        txfTitle.clear();
        chbSenior.setSelected(false);
    }
}
