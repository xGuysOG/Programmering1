package presentation;

import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class HotelWindow extends Stage {
    private Conference conference;
    private Registration registration;
    private HotelReservation reservation;

    public HotelWindow(String title, Conference conference, Registration registration) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.conference = conference;
        this.registration = registration;
        if (registration.getReservedHotel() != null) {
            this.reservation = registration.getReservedHotel();
        }

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
    // -------------------------------------------------------------------------

    private final CheckBox cbDoubleRoom = new CheckBox("Dobbelt Værelse");
    private final ComboBox<Hotel> cmbHotels = new ComboBox<>();
    private final ListView<HotelService> lvwServices = new ListView<>();

    private DatePicker checkInDate, checkOutDate;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblTitle = new Label("Overnatning");
        lblTitle.setFont(Font.font(20));
        pane.add(lblTitle, 0, 0);

        GridPane dateSelectPane = new GridPane();
        pane.add(dateSelectPane, 0, 1);

        Label lblDate = new Label("Ankomst Dato");
        dateSelectPane.add(lblDate, 0, 0);

        checkInDate = new DatePicker(conference.getStartDate());
        checkInDate.setPrefWidth(120);
        dateSelectPane.add(checkInDate, 0, 1);
        dateSelectPane.setHgap(10);

        lblDate = new Label("Afrejse Dato");
        dateSelectPane.add(lblDate, 1, 0);

        checkOutDate = new DatePicker(conference.getEndDate());
        checkOutDate.setPrefWidth(120);
        dateSelectPane.add(checkOutDate, 1, 1);

        Label lblHotels = new Label("Hoteller");
        pane.add(lblHotels, 0, 2);

        cmbHotels.getItems().setAll(conference.getHotels());
        cmbHotels.getSelectionModel().selectFirst();

        ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> this.selectedHotelChanged(newHotel);
        cmbHotels.getSelectionModel().selectedItemProperty().addListener(listener);

        Hotel hotel = cmbHotels.getSelectionModel().getSelectedItem();
        pane.add(cmbHotels, 0, 3);


        Label lblServices = new Label("Tilvælg Tjenester");
        pane.add(lblServices, 0, 4);

        pane.add(lvwServices, 0, 5);
        lvwServices.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvwServices.setPrefHeight(100);
        lvwServices.getItems().setAll(hotel.getHotelServices());

        pane.add(cbDoubleRoom, 0, 6);

        initFields();

        Button btnCancel = new Button("Annuller");
        pane.add(btnCancel, 0, 7);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnConfirm = new Button("Bekræft");
        pane.add(btnConfirm, 0, 7);
        GridPane.setHalignment(btnConfirm, HPos.RIGHT);
        btnConfirm.setOnAction(event -> this.okAction());
    }

    private void initFields() {
        if (registration.hasCompanion()) {
            cbDoubleRoom.setDisable(true);
            cbDoubleRoom.setSelected(true);
        }

        if (reservation != null) {
            cmbHotels.getSelectionModel().select(reservation.getHotel());
            cbDoubleRoom.setSelected(reservation.isDoubleRoom());

            checkInDate.setValue(reservation.getCheckIn());
            checkOutDate.setValue(reservation.getCheckOut());

            for (HotelService service : reservation.getServices()) {
                lvwServices.getSelectionModel().select(service);
            }
        }
    }

    private void selectedHotelChanged(Object newValue) {
        Hotel hotel = (Hotel) newValue;
        lvwServices.getItems().setAll(hotel.getHotelServices());
    }


    private void okAction() {
        Hotel hotel = cmbHotels.getSelectionModel().getSelectedItem();
        boolean doubleRoom = cbDoubleRoom.isSelected();

        LocalDate checkIn = checkInDate.getValue();
        LocalDate checkOut = checkOutDate.getValue();

        ObservableList<HotelService> selectedItems = lvwServices.getSelectionModel().getSelectedItems();
        HotelService[] selectedServices = selectedItems.toArray(new HotelService[0]);

        Controller.reserveHotel(registration, hotel, checkIn, checkOut, selectedServices, doubleRoom);

        this.hide();
    }

    private void cancelAction() {
        this.hide();
    }
}
