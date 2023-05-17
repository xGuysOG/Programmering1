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
import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ShowHotelDetailWindow extends Stage {

    public ShowHotelDetailWindow(String title, Stage owner) {
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

    private Hotel hotel;
    private final TextArea hotelArea = new TextArea();

    private Label lblName = new Label("Hotel: ");

    @Override
    public void showAndWait() {
        // Run code before showing the separate window
        populateData();
        super.showAndWait(); // Show the separate window
        hotelArea.setText("");
        // Run code after the separate window is closed
        // This code will execute when showAndWait() returns
    }


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(lblName, 0, 0);
        lblName.setAlignment(Pos.CENTER);
        pane.add(hotelArea, 0, 1);
        hotelArea.setEditable(false);

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 5, 5, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnClose = new Button("Close");
        buttonBox.getChildren().add(btnClose);

        btnClose.setOnAction(event -> this.closeAction());

    }

    public void setCurrentHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    private void closeAction() {
        ShowHotelDetailWindow.this.hide();
        lblName.setText("");
        hotelArea.setText("");
    }

    private void populateData() {
        lblName.setText(hotel.getName());
        for (Deltager deltager : hotel.getDeltagere()) {
            if (deltager.getLedsager() == null) {
                hotelArea.appendText(deltager.getName() + " and " + "No ledsager \n");
            } else {
                hotelArea.appendText(deltager.getName() + " and " + deltager.getLedsager().getName() + "\n");
            }
            hotelArea.appendText("From " + deltager.getArrivalDate().toString() + " to " + deltager.getLeaveDate().toString() + "\n");
            if (deltager.getHotelValg().getChosenServices().size() > 0){
                hotelArea.appendText("Chosen services: " + deltager.getHotelValg().getChosenServices().toString() + "\n");
            } else {
                hotelArea.appendText(deltager.getName() + " has not chosen any services \n");
            }
            if (deltager.isForedragsholder()) {
                hotelArea.appendText(deltager.getName() + " is foredragsholder \n");
            } else {
                hotelArea.appendText(deltager.getName() + " is not foredragsholder \n");
            }
            if (deltager.hasCompany()) {
                hotelArea.appendText(deltager.getName() + " is part of a company \n");
            } else {
                hotelArea.appendText(deltager.getName() + " is not part of a company \n");
            }
            hotelArea.appendText("---------------------------------------------------------- \n");
        }
    }
}

