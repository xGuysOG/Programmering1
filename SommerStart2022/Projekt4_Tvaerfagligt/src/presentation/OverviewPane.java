package presentation;

import application.controller.Controller;
import application.model.Conference;
import application.model.Hotel;
import application.model.Trip;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;


public class OverviewPane extends GridPane {
    private final ComboBox<Conference> cmbConferences;
    private final ComboBox<Object> cmbOverview;
    private final ListView<Object> lvwContent;

    private final ToggleGroup group = new ToggleGroup();
    private final RadioButton rbConferences, rbTrips, rbHotels;

    private Conference conference;

    public OverviewPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblTitle = new Label("Administration Oversigt");
        lblTitle.setFont(Font.font(20));
        this.add(lblTitle, 0, 0, 2, 1);

        HBox hbOverview = new HBox();
        hbOverview.setSpacing(10);
        this.add(hbOverview, 0, 1);

        cmbConferences = new ComboBox<>();
        cmbConferences.getItems().setAll(Controller.getConferences());
        cmbConferences.getSelectionModel().selectFirst();
        cmbConferences.setOnAction(event -> updateAction());
        conference = cmbConferences.getValue();

        cmbOverview = new ComboBox<>();
        cmbOverview.setOnAction(event -> selectCBOptionAction());
        hbOverview.getChildren().setAll(cmbConferences, cmbOverview);

        VBox vbRadioButtons = new VBox();
        vbRadioButtons.setAlignment(Pos.CENTER_LEFT);
        vbRadioButtons.setSpacing(20);
        this.add(vbRadioButtons, 1, 2);

        rbConferences = new RadioButton("Deltager Oversigt");
        rbConferences.setToggleGroup(group);
        rbConferences.setOnAction(event -> updateCBOptionsActions());
        cmbOverview.setDisable(true);
        rbConferences.setSelected(true);

        rbHotels = new RadioButton("Hotel Oversigt");
        rbHotels.setToggleGroup(group);
        rbHotels.setOnAction(event -> updateCBOptionsActions());
        rbHotels.setUserData(conference.getHotels());

        rbTrips = new RadioButton("Udflugt Oversigt");
        rbTrips.setToggleGroup(group);
        rbTrips.setOnAction(event -> updateCBOptionsActions());
        rbTrips.setUserData(conference.getTrips());
        vbRadioButtons.getChildren().setAll(rbConferences, rbHotels, rbTrips);

        lvwContent = new ListView<>();
        lvwContent.getItems().setAll(conference.getRegistrations());
        this.add(lvwContent, 0, 2);
    }

    private void updateAction() {
        conference = cmbConferences.getSelectionModel().getSelectedItem();

        rbConferences.setUserData(conference.getRegistrations());
        rbHotels.setUserData(conference.getHotels());
        rbTrips.setUserData(conference.getTrips());

        selectCBOptionAction();
    }

    private void selectCBOptionAction() {
        Object overView = cmbOverview.getSelectionModel().getSelectedItem();

        if (overView instanceof Trip trip) {
            lvwContent.getItems().setAll(trip.getCompanions());
        } else if (overView instanceof Hotel hotel) {
            lvwContent.getItems().setAll(hotel.getReservations());
        } else {
            lvwContent.getItems().setAll(conference.getRegistrations());
        }
    }

    private void updateCBOptionsActions() {
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        ArrayList<Object> list = (ArrayList<Object>) rb.getUserData();

        if (rb.equals(rbConferences)) {
            cmbOverview.setDisable(true);
            cmbOverview.getSelectionModel().clearSelection();
        } else {
            cmbOverview.setDisable(false);
            cmbOverview.getItems().setAll(list);
            cmbOverview.getSelectionModel().selectFirst();
        }

        selectCBOptionAction();
    }
}
