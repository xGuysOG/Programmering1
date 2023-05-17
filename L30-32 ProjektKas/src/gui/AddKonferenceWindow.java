package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;
import org.w3c.dom.Text;

import java.awt.*;
import java.time.LocalDate;

public class AddKonferenceWindow extends Stage {

    public AddKonferenceWindow(String title, Stage owner) {
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

    // -----------------------------------------------------
    // Textfields
    private final TextField txfName = new TextField();
    private final TextField txfLocation = new TextField();
    private final TextField txfPrice = new TextField();
    private final TextField txfStartDate = new TextField();
    private final TextField txfEndDate = new TextField();

    // Konference
    private Konference konference = null;

    // Label
    private final Label lblError = new Label("");


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        // Labels
        Label lblAddKonference = new Label("Add Konference:");
        pane.add(lblAddKonference, 0, 0);

        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 6, 3, 1);

        // Textfields & Labels added to pane
        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 1);
        pane.add(txfName, 1, 1);

        Label lblLocation = new Label("Location: ");
        pane.add(lblLocation, 0, 2);
        pane.add(txfLocation, 1, 2);

        Label lblStartDate = new Label("Start date: ");
        pane.add(lblStartDate, 0, 3);
        pane.add(txfStartDate, 1, 3);
        txfStartDate.setPromptText("YYYY-MM-DD");

        Label lblEndDate = new Label("End date: ");
        pane.add(lblEndDate, 0, 4);
        pane.add(txfEndDate, 1, 4);
        txfEndDate.setPromptText("YYYY-MM-DD");

        Label lblPrice = new Label("Price: ");
        pane.add(lblPrice, 0, 5);
        pane.add(txfPrice, 1, 5);

        // Buttons
        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 7, 5, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

    }

    // ---------------------------
    // Button actions

    private void okAction() {
        String name = txfName.getText().trim();
        String location = txfLocation.getText().trim();
        String startDate = txfStartDate.getText().trim();
        String endDate = txfEndDate.getText().trim();
        String priceString = txfPrice.getText().trim();
        double price = 0;

        try {
            if (name.isEmpty()) {
                lblError.setText("Name is required");
            } else if (location.isEmpty()) {
                lblError.setText("Location is required");
            } else if (LocalDate.parse(startDate).isAfter(LocalDate.parse(endDate))) {
                lblError.setText("Start date cannot be after end date");
            } else {
                price = Integer.parseInt(priceString);
                if (price < 0) {
                    lblError.setText("Price cannot be negative");
                } else {
                    lblError.setText("");
                }
            }
        } catch (NumberFormatException ex) {
            lblError.setText("Price is not a double");
            return;
        }
        if (name.length() > 0 && location.length() > 0 && price > 0) {
            konference = Controller.createKonference(name, location, LocalDate.parse(startDate), LocalDate.parse(endDate), price);
            txfName.clear();
            txfName.requestFocus();
            txfLocation.clear();
            txfStartDate.clear();
            txfEndDate.clear();
            txfPrice.clear();
            AddKonferenceWindow.this.hide();
        }
    }

    private void cancelAction() {
        txfName.clear();
        txfName.requestFocus();
        txfLocation.clear();
        txfStartDate.clear();
        txfEndDate.clear();
        txfPrice.clear();
        lblError.setText("");
        konference = null;
        AddKonferenceWindow.this.hide();
    }

    // Add Konference
    public Konference getKonference() {
        return konference;
    }
}
