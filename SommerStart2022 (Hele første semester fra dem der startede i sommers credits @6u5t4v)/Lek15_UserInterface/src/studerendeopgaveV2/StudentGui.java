package studerendeopgaveV2;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class StudentGui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Administrer studerende");
        GridPane pane = new GridPane();
        this.initStudents();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Student> lvwStudents = new ListView<>();
    private final ArrayList<Student> students = new ArrayList<>();

    private final TextField txfName = new TextField();
    private final TextField txAge = new TextField();
    private final CheckBox chkActive = new CheckBox();
    private final TextArea txAInf = new TextArea();
    private final Button btnBirthday = new Button("Fødselsdag");
    private final Button btnAdd = new Button("Opret");
    private final Button btnSave = new Button("Gem");
    private final Button btnGet = new Button("Hent");
    private final Button btnDelete = new Button("Slet");

    private Student studerende = null;

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(lvwStudents, 0, 0, 2, 1);

        lvwStudents.getItems().setAll(students);
//        lvwStudents.setMaxHeight(60);

        txAInf.setEditable(false);
        txAInf.setPrefWidth(200);
        txAInf.setPrefHeight(60);
        pane.add(txAInf, 2, 0, 4, 2);

        Label lblName = new Label("Navn");
        pane.add(lblName, 0, 2);
        Label lblAge = new Label("Alder");
        pane.add(lblAge, 0, 3);
        Label lblActive = new Label("Aktiv");
        pane.add(lblActive, 0, 4);

        pane.add(txfName, 1, 2);
        pane.add(txAge, 1, 3);
        pane.add(chkActive, 1, 4);

        // add a buttons to the pane
        pane.add(btnBirthday, 2, 2);
        btnBirthday.setDisable(true);
        btnBirthday.setOnAction(event -> birthday());

        pane.add(btnAdd, 0, 5);

        btnSave.setDisable(true);
        pane.add(btnSave, 1, 5);

        btnGet.setDisable(true);
        pane.add(btnGet, 0, 1);

        GridPane.setMargin(btnGet, new Insets(10, 10, 0, 10));

        pane.add(btnDelete, 1, 1);
        btnDelete.setDisable(true);
        GridPane.setMargin(btnDelete, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());
        btnSave.setOnAction(event -> this.saveAction());
        btnGet.setOnAction(event -> this.getAction());
        btnDelete.setOnAction(event -> this.deleteAction());

        ChangeListener<Student> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwStudents.getSelectionModel().selectedItemProperty().addListener(listener);

//        ListChangeListener<Student> listListener = (list) -> this.updateList();
//        lvwStudents.getItems().addListener(listListener);
    }

    private void selectionChanged() {
        Student selected = lvwStudents.getSelectionModel().getSelectedItem();
        if (selected != null) {
//            studerende = selected;
            txAInf.setText(getDescription(selected));
            btnDelete.setDisable(false);
            btnGet.setDisable(false);
        } else {
            txAInf.clear();
            btnDelete.setDisable(false);
            btnGet.setDisable(false);
            btnSave.setDisable(true);
        }
    }

    private void initStudents() {
        students.add(new Student("Gustav", 21));
        students.add(new Student("Emil", 69));
        students.add(new Student("Jens", 420));
        students.add(new Student("Lars", 69420));
        students.add(new Student("Mads", 1337));
    }

    private void birthday() {
        Student student = lvwStudents.getSelectionModel().getSelectedItem();

        if (student != null) {
            student.increaseAge();
        }
    }

    private void addAction() {
        final String name = txfName.getText().trim();
        final String ageStr = txAge.getText().trim();

        if (name.length() > 0 && ageStr.length() > 0) {
            int age = Integer.parseInt(ageStr);
            Student student = new Student(name, age, chkActive.isSelected());

            students.add(student);
            updateList();

            lvwStudents.getSelectionModel().selectLast();

            clearFields();

            btnGet.setDisable(false);
            btnAdd.setDisable(true);
            btnBirthday.setDisable(false);
        }
    }

    private void saveAction() {
        if (studerende != null) {
            studerende.setName(txfName.getText().trim());
            studerende.setActive(chkActive.isSelected());
            studerende.setAge(Integer.parseInt(txAge.getText().trim()));

            clearFields();
            txAInf.setText(getDescription(studerende));
            btnSave.setDisable(true);
            btnDelete.setDisable(true);
            btnGet.setDisable(false);
            btnBirthday.setDisable(false);
        }
    }

    private void getAction() {
        Student student = lvwStudents.getSelectionModel().getSelectedItem();

        if (student != null) {
            txfName.setText(student.getName());
            txAge.setText("" + student.getAge());
            chkActive.setSelected(student.isActive());

            studerende = student;

            btnSave.setDisable(false);
            btnDelete.setDisable(false);
            btnGet.setDisable(true);
            btnBirthday.setDisable(true);
        }
    }

    //
    private void deleteAction() {
        Student student = lvwStudents.getSelectionModel().getSelectedItem();

        if (student != null) {
            students.remove(student);
            updateList();

            clearFields();
            txAInf.clear();

            btnDelete.setDisable(true);
            btnSave.setDisable(true);
            btnGet.setDisable(true);
            btnBirthday.setDisable(true);
            btnAdd.setDisable(false);
        }
    }

    private void clearFields() {
        txfName.clear();
        txAge.clear();
        chkActive.setSelected(false);
    }

    private String getDescription(Student student) {
        String result = "Ingen studerende gemt";
        if (student != null) {
            result = student.description();
        }
        return result;
    }

    private void updateList() {
        lvwStudents.getItems().setAll(students);
    }
}
