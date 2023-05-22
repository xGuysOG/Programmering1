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
import model.Service;

public class AddServiceWindow extends Stage {

    public AddServiceWindow(String title, Stage owner) {
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


    private Hotel hotel = null;
    private final TextField txfName = new TextField();
    private final TextField txfPrice = new TextField();

    private final ListView lvwServices = new ListView();
    private Service service = null;
    private final Label lblError = new Label("");

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblHotel = new Label("Add services:");
        pane.add(lblHotel, 0, 0);


        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 4, 3, 1);

        // Textfields & Labels added to pane
        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 1);
        pane.add(txfName, 1, 1);

        Label lblPrice = new Label("Price: ");
        pane.add(lblPrice, 0, 2);
        pane.add(txfPrice, 1, 2);


        // Buttons
        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 5, 5, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnAdd = new Button("Add service");
        buttonBox.getChildren().add(btnAdd);
        btnAdd.setOnAction(event -> this.addServiceAction());

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        // Add service button

    }

    // ---------------------------
    // Button actions

    private void addServiceAction() {
        String name = txfName.getText().trim();
        String priceString = txfPrice.getText().trim();
        double price = 0;

        try {
            if (name.isEmpty()) {
                lblError.setText("Name is required");
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
        if (name.length() > 0 && price > 0) {
            service = Controller.createService(name, price);
            txfName.clear();
            txfName.requestFocus();
            txfPrice.clear();
            AddServiceWindow.this.hide();

        }
    }

    private void cancelAction() {
        txfName.clear();
        txfName.requestFocus();
        txfPrice.clear();
        lblError.setText("");
        service = null;
        AddServiceWindow.this.hide();
    }

    public Service getService() {
        return service;
    }
}

