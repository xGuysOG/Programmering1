package Opgave6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {

    public Student storedStudent;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Excerise 6");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField nameField = new TextField();
    private final TextField ageField = new TextField();
    private final TextArea studentArea = new TextArea();
    private final CheckBox cbx = new CheckBox();
    private final Button createButton = new Button("Create");
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label studentInfoText = new Label("Student info:");
        pane.add(studentInfoText, 0, 0);
        pane.add(studentArea, 0, 1);
        studentArea.setPrefRowCount(8);
        studentArea.setPrefWidth(250);
        studentArea.setEditable(false);

        Label nameText = new Label("Name:");
        pane.add(nameText,0,2);
        pane.add(nameField, 0, 2);
        nameField.setEditable(true);
        GridPane.setMargin(nameField, new Insets(0, 60, 0, 40));


        Label ageText = new Label("Age:");
        pane.add(ageText,0,3);
        pane.add(ageField, 0, 3);
        ageField.setEditable(true);
        GridPane.setMargin(ageField, new Insets(0, 100, 0, 40));

        Button incButton = new Button("Inc");
        pane.add(incButton, 0, 3);
        GridPane.setMargin(incButton, new Insets(0, 0, 0, 200));
        incButton.setOnAction(event -> this.incAge());

        Button resetButton = new Button("Reset");
        pane.add(resetButton, 0, 3);
        GridPane.setMargin(resetButton, new Insets(0, 0, 0, 240));
        resetButton.setOnAction(event -> this.reset());

        pane.add(cbx, 0, 4);
        GridPane.setMargin(cbx, new Insets(0, 0, 0, 40));
        Label checkboxText = new Label("Active:");
        pane.add(checkboxText,0,4);

        pane.add(createButton, 0, 5);
        GridPane.setMargin(createButton, new Insets(0, 0, 0, 30));
        createButton.setOnAction(event -> this.createUser());

        Button updateButton = new Button("Update");
        pane.add(updateButton, 0, 5);
        GridPane.setMargin(updateButton, new Insets(0, 0, 0, 115));
        updateButton.setOnAction(event -> this.updateUser());

        Button deleteButton = new Button("Delete");
        pane.add(deleteButton, 0, 5);
        GridPane.setMargin(deleteButton, new Insets(0, 0, 0, 200));
        deleteButton.setOnAction(event -> this.deleteUser());

    }
    // ------------------------------------------------------------------------

    private void reset() {
        if (storedStudent != null) {
            ageField.setText(String.valueOf(storedStudent.getAge()));
            nameField.setText(storedStudent.getName());
            cbx.setSelected(storedStudent.isActive());
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("No student stored");
            errorAlert.setContentText("You need to create a user before trying to get data from it");
            errorAlert.showAndWait();
        }
    }
    private void incAge() {
        if (ageField.getText().length() > 0) {
            int age = Integer.parseInt(ageField.getText()) + 1;
            ageField.setText(String.valueOf(age));

        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error you need to input a number in the age field");
            errorAlert.setContentText("you need to input a number in the age field, it is impossible to add to to a none existing number");
            errorAlert.showAndWait();
        }
    }
    private void createUser() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        boolean active = cbx.isSelected();
        storedStudent = new Student(name, age,active);
        studentArea.setText(this.getDescription());
        clearInput();
        createButton.setDisable(true);
    }
    private void updateUser() {
        if (nameField.getText().length() > 0) {
            String name = nameField.getText();
            storedStudent.setName(name);
        }
        if (ageField.getText().length() > 0) {
            int age = Integer.parseInt(ageField.getText());
            storedStudent.setAge(age);
        }
        boolean active = cbx.isSelected();
        storedStudent.setActive(active);
        studentArea.setText(this.getDescription());
        clearInput();
    }

    private void deleteUser() {
        storedStudent = null;
        studentArea.setText("");
        clearInput();
        createButton.setDisable(false);
    }

    private void clearInput() {
        nameField.setText("");
        ageField.setText("");
        cbx.setSelected(false);
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + storedStudent.getName() + "\n");
        sb.append("Age: " + storedStudent.getAge() + "\n");
        sb.append("Active: " + storedStudent.isActive() + "\n");
        return sb.toString();
    }
}
