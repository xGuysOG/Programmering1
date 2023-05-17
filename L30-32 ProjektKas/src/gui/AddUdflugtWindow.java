package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Hotel;
import model.Konference;
import model.Service;
import storage.Storage;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class AddUdflugtWindow extends Stage {

    public AddUdflugtWindow(String title, Stage owner) {
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

    private final TextField txfName = new TextField();
    private final TextField txfLocation = new TextField();
    private final TextField txfPrice = new TextField();

    private final TextField txfDate = new TextField();

    private final ListView lvwKonference = new ListView();

    private final Label lblError = new Label("");

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Labels
        Label lblUdflugt = new Label("Create Udflugt:");
        pane.add(lblUdflugt, 0, 0);

        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 5, 3, 1);

        // Textfields & Labels added to pane
        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 1);
        pane.add(txfName, 1, 1);

        Label lblDate = new Label("Date: ");
        pane.add(lblDate, 0, 2);
        pane.add(txfDate, 1, 2);
        txfDate.setPromptText("YYYY-MM-DD");

        Label lblPrice = new Label("Price: ");
        pane.add(lblPrice, 0, 3);
        pane.add(txfPrice, 1, 3);

        Label lblLocation = new Label("Location: ");
        pane.add(lblLocation, 0, 4);
        pane.add(txfLocation, 1, 4);

        Label lblKonference = new Label("Konference:");
        pane.add(lblKonference, 2, 0);
        pane.add(lvwKonference, 2, 1, 5, 4);
        lvwKonference.setPrefHeight(100);
        lvwKonference.getItems().setAll(Storage.getKonferencer());

        // Buttons
        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 5, 5, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());


    }

    private void okAction() {
        String name = txfName.getText().trim();
        String location = txfLocation.getText().trim();
        String priceString = txfPrice.getText().trim();
        String date = txfDate.getText().trim();
        double price = 0;
        LocalDate dateFormatted = LocalDate.now();

        if (name.isEmpty()) {
            lblError.setText("Name is required");
            return;
        }
        if (location.isEmpty()) {
            lblError.setText("Location is required");
            return;
        }
        if (date.isEmpty()) {
            lblError.setText("Date is required");
            return;
        }
        if (priceString.isEmpty()) {
            lblError.setText("Price is required");
            return;
        }
        try {
            dateFormatted = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            lblError.setText("Date is wrong format");
            return;
        }
        try {
            price = Integer.parseInt(priceString);
            if (price < 0) {
                lblError.setText("Price cannot be negative");
            } else {
                lblError.setText("");
            }
        } catch (NumberFormatException ex) {
            lblError.setText("Price is not a double");
            return;
        }

        //check if one is selected
        if (lvwKonference.getSelectionModel().isEmpty()) {
            lblError.setText("You need to select a konference");
            return;
        }
        Konference selectedKonference = (Konference) lvwKonference.getSelectionModel().getSelectedItem();
        if (!isWithinRange(dateFormatted, selectedKonference.getStartDate(), selectedKonference.getEndDate())) {
            lblError.setText("Selected konference is not within udflugt date");
            return;
        }
        Controller.createUdflugt(name, dateFormatted, price, selectedKonference);
        txfName.clear();
        txfName.requestFocus();
        txfLocation.clear();
        txfPrice.clear();
        txfDate.clear();
        AddUdflugtWindow.this.hide();
    }

    public boolean isWithinRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return date.isAfter(startDate) && date.isBefore(endDate) || date.equals(startDate) || date.equals(endDate);
    }

    private void cancelAction() {
        txfName.clear();
        txfName.requestFocus();
        txfPrice.clear();
        txfLocation.clear();
        txfDate.clear();
        lblError.setText("");
        AddUdflugtWindow.this.hide();
    }
}
