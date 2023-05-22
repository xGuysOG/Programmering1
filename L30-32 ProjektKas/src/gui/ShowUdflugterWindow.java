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
import model.Konference;
import model.Ledsager;
import model.Udflugt;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ShowUdflugterWindow extends Stage {

    public ShowUdflugterWindow(String title, Stage owner) {
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
        showLedsagerWindow = new ShowLedsagerWindow("Ledsager detail", owner);
    }

    private boolean isEditing = false;
    private Udflugt udflugt;
    private final TextField txfName = new TextField();
    private final TextField txfDate = new TextField();
    private final TextField txfPrice = new TextField();
    private final Label lblKonference = new Label();
    private final ListView<Ledsager> lvwLedsager = new ListView<>();
    private final Label lblError = new Label("");
    private final Label lblText = new Label("Udflugt: ");
    private final Button btnEdit = new Button("Edit Mode");

    private ShowLedsagerWindow showLedsagerWindow;

    public void setUdflugt(Udflugt udflugt) {
        this.udflugt = udflugt;
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

        Label lblLocation = new Label("Date: ");
        pane.add(lblLocation, 0, 2);
        pane.add(txfDate, 1, 2);

        Label lblStartDate = new Label("Price: ");
        pane.add(lblStartDate, 0, 3);
        pane.add(txfPrice, 1, 3);

        Label lblEndDate = new Label("Konference: ");
        pane.add(lblEndDate, 0, 4);
        pane.add(lblKonference, 1, 4);

        pane.add(lvwLedsager, 2, 1, 2, 4);
        lvwLedsager.setPrefHeight(100);

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 5, 5, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().add(btnEdit);
        btnEdit.setOnAction(event -> this.editButton());

        Button btnClose = new Button("Close");
        buttonBox.getChildren().add(btnClose);

        btnClose.setOnAction(event -> this.closeAction());

        EventHandler<MouseEvent> ledsagerClickHandler = onLedsagerDoubleClick(lvwLedsager);
        lvwLedsager.setOnMouseClicked(ledsagerClickHandler);
    }

    private EventHandler<MouseEvent> onLedsagerDoubleClick(ListView<Ledsager> ledsagerer) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    Ledsager ledsager = ledsagerer.getSelectionModel().getSelectedItem();
                    if (ledsager != null) {
                        showLedsagerWindow.setLedsager(ledsager);
                        showLedsagerWindow.showAndWait();
                        populateData();
                    }
                }
            }
        };
    }

    private void closeAction() {
        txfName.clear();
        txfPrice.clear();
        txfDate.clear();
        lblKonference.setText("");
        lvwLedsager.getItems().clear();
        ShowUdflugterWindow.this.hide();
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

            txfDate.setEditable(true);
            txfDate.setDisable(false);


            txfPrice.setEditable(true);
            txfPrice.setDisable(false);
        } else {
            btnEdit.setText("Edit Mode");
            txfName.setEditable(false);
            txfName.setDisable(true);

            txfDate.setEditable(false);
            txfDate.setDisable(true);


            txfPrice.setEditable(false);
            txfPrice.setDisable(true);
            saveData();
        }
    }

    private void saveData() {
        boolean hasBeenEdited = false;
        if (!txfName.getText().equals(udflugt.getName())) {
            udflugt.setName(txfName.getText());
            hasBeenEdited = true;
        }


        if (!txfDate.getText().equals(udflugt.getDate().toString())) {
            LocalDate date = LocalDate.now();
            try {
                date = LocalDate.parse(txfDate.getText());
            } catch (DateTimeParseException e) {
                lblError.setText("date is wrongly formatted");
                return;
            }
            udflugt.setDate(date);
            hasBeenEdited = true;
        }

        if (!txfPrice.getText().equals(String.valueOf(udflugt.getPrice()))) {
            double price = 0;
            try {
                price = Integer.parseInt(txfPrice.getText());
            } catch (NumberFormatException e) {
                lblError.setText("price is wrongly formatted");
                return;
            }
            udflugt.setPrice(price);
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
        lblText.setText(udflugt.getName());
        txfName.setText(udflugt.getName());
        txfDate.setText(udflugt.getDate().toString());
        txfPrice.setText(String.valueOf(udflugt.getPrice()));
        lblKonference.setText(udflugt.getKonference().getName());
        lvwLedsager.getItems().setAll(udflugt.getDeltagere());
    }
}