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


import java.util.ArrayList;

public class AddHotelWindow extends Stage {

    public AddHotelWindow(String title, Stage owner) {
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
        serviceWindow = new AddServiceWindow("Add hotel", owner);
    }

    private final TextField txfName = new TextField();
    private final TextField txfLocation = new TextField();
    private final TextField txfPrice = new TextField();
    private final TextField txfDoublePrice = new TextField();

    private final ListView lvwServices = new ListView();
    private final ArrayList<Service> services = new ArrayList<>();
    // AddServiceWindow
    private AddServiceWindow serviceWindow;

    // Konference
    private Hotel hotel = null;

    // Label
    private final Label lblError = new Label("");

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Labels
        Label lblHotel = new Label("Add hotel:");
        pane.add(lblHotel, 0, 0);

        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 4, 3, 1);

        // Textfields & Labels added to pane
        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 1);
        pane.add(txfName, 1, 1);

        Label lblLocation = new Label("Location: ");
        pane.add(lblLocation, 0, 2);
        pane.add(txfLocation, 1, 2);

        Label lblPrice = new Label("Price: ");
        pane.add(lblPrice, 0, 3);
        pane.add(txfPrice, 1, 3);

        Label lblDoublePrice = new Label("Double Price: ");
        pane.add(lblDoublePrice, 0, 4);
        pane.add(txfDoublePrice, 1, 4);

        Label lblServices = new Label("Services:");
        pane.add(lblServices, 2, 0);
        pane.add(lvwServices, 2, 1, 5, 4);
        lvwServices.setPrefHeight(100);

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

        // Add service button

        Button btnAddService = new Button("Add service");
        pane.add(btnAddService, 6, 5);
        btnAddService.setAlignment(Pos.BOTTOM_LEFT);
        btnAddService.setOnAction(event -> this.addServiceAction());

    }

    // ---------------------------
    // Button actions

    private void okAction() {
        String name = txfName.getText().trim();
        String location = txfLocation.getText().trim();
        String priceString = txfPrice.getText().trim();
        String doublePriceString = txfDoublePrice.getText().trim();
        double price = 0;
        double doublePrice = 0;

        try {
            if (name.isEmpty()) {
                lblError.setText("Name is required");
            } else if (location.isEmpty()) {
                lblError.setText("Location is required");
            } else {
                price = Integer.parseInt(priceString);
                if (price < 0) {
                    lblError.setText("Price cannot be negative");
                } else {
                    lblError.setText("");
                }

                doublePrice = Integer.parseInt(priceString);
                if (doublePrice < 0) {
                    lblError.setText("doublePrice cannot be negative");
                } else {
                    lblError.setText("");
                }
            }
        } catch (NumberFormatException ex) {
            lblError.setText("Price is not a double");
            return;
        }
        if (name.length() > 0 && location.length() > 0 && price > 0) {
            hotel = Controller.createHotel(name, location, price, doublePrice, services);
            txfName.clear();
            txfName.requestFocus();
            txfLocation.clear();
            txfPrice.clear();
            AddHotelWindow.this.hide();
        }
    }

    private void cancelAction() {
        txfName.clear();
        txfName.requestFocus();
        txfLocation.clear();
        txfPrice.clear();
        lblError.setText("");
        AddHotelWindow.this.hide();
    }

    private void addServiceAction() {
        serviceWindow.showAndWait();

        if (serviceWindow.getService() != null) {
            Service service = serviceWindow.getService();
            services.add(service);
            lvwServices.getItems().setAll(services);
        }
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
