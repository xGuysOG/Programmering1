package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Deltager;
import model.Ledsager;
import model.Udflugt;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ShowLedsagerWindow extends Stage {

    public ShowLedsagerWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private boolean isEditing = false;
    private Ledsager ledsager;
    private final TextField txfName = new TextField();
    ;
    private final Label lblDeltager = new Label();
    private final ListView<Udflugt> lvwUdflugter = new ListView<>();
    private final Label lblError = new Label("");
    private final Label lblText = new Label("Ledsager: ");
    private final Button btnEdit = new Button("Edit Mode");

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }

    @Override
    public void showAndWait() {
        // Run code before showing the separate window
        populateData();
        editable();
        super.showAndWait(); // Show the separate window
        // Run code after the separate window is closed
        // This code will execute when showAndWait() returns
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(lblText, 0, 0);
        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 4, 3, 1);

        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 1);
        pane.add(txfName, 1, 1);

        Label lblEndDate = new Label("Deltager: ");
        pane.add(lblEndDate, 0, 2);
        pane.add(lblDeltager, 1, 2);

        pane.add(lvwUdflugter, 2, 1, 2, 4);
        lvwUdflugter.setPrefHeight(100);

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 5, 5, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().add(btnEdit);
        btnEdit.setOnAction(event -> this.editButton());

        Button btnClose = new Button("Close");
        buttonBox.getChildren().add(btnClose);
        btnClose.setOnAction(event -> this.closeAction());

    }

    private void closeAction() {
        txfName.clear();
        lblDeltager.setText("");
        lvwUdflugter.getItems().clear();
        ShowLedsagerWindow.this.hide();
    }

    private void editButton() {
        if (isEditing) {
            isEditing = false;
        } else {
            isEditing = true;
        }
        editable();
    }

    private void editable() {
        if (isEditing) {
            btnEdit.setText("Read Mode");
            txfName.setEditable(true);
            txfName.setDisable(false);
        } else {
            btnEdit.setText("Edit Mode");
            txfName.setEditable(false);
            txfName.setDisable(true);
            saveData();
        }
    }

    private void saveData() {
        boolean hasBeenEdited = false;
        if (!txfName.getText().equals(ledsager.getName())) {
            ledsager.setName(txfName.getText());
            hasBeenEdited = true;
        }

        if (hasBeenEdited) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Edit Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("You have made some edits.");
            alert.showAndWait();
        }
    }

    private void populateData() {
        lblText.setText(ledsager.getName());
        txfName.setText(ledsager.getName());
        lblDeltager.setText(ledsager.getDeltager().getName());
        lvwUdflugter.getItems().setAll(ledsager.getUdflugter());
    }
}
