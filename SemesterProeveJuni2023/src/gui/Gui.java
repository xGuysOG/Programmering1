package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Bane;
import model.Booking;
import model.Spiller;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Gui extends Application {
    public void start(Stage stage) {
        stage.setTitle("Bane bookings");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();


    }
    // -----------------------------------------------------------
    private final ListView<Bane> lvwBaner = new ListView<Bane>();
    private final TextArea antalBookinger = new TextArea();
    private final ListView<Spiller> lvwSpillere = new ListView<Spiller>();
    private final TextArea bookingerAfSpiller = new TextArea();
    private final Label lblError = new Label("");
    private final Label lblBaner = new Label("Baner");
    private final Label lblSpillere = new Label("Spillere");
    private final Label lblSpillernesBokinger = new Label("Spillernes bookinger");
    private final Label lblAntalBookingerPåbane = new Label("Antal bookinger på banen");
    private final Label lblOpretBooking = new Label("Opret booking:");
    private final Label lblDato = new Label("Dato:");
    private final Label lblTid = new Label("Tid:");

    private final TextField txfDato = new TextField();
    private final TextField txfTid = new TextField();

    private final CheckBox chxSingle = new CheckBox("single");
    private final Button btxBook = new Button("Book bane til spiller");


    // -----------------------------------------------------------

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(lblBaner, 0,0);
        pane.add(lvwBaner, 0,1);
        lvwBaner.setPrefHeight(200);
        lvwBaner.setPrefWidth(200);
        lvwBaner.getItems().addAll(Storage.getBaner());
        lvwBaner.setOnMouseClicked(mouseEvent -> baneClick(mouseEvent));

        pane.add(lblSpillere, 1,0);
        pane.add(lvwSpillere, 1, 1);
        lvwSpillere.setPrefHeight(200);
        lvwSpillere.setPrefWidth(150);
        lvwSpillere.getItems().addAll(Storage.getSpillere());
        lvwSpillere.setOnMouseClicked(mouseEvent -> spillerClick(mouseEvent));

        pane.add(lblSpillernesBokinger,2,0);
        pane.add(bookingerAfSpiller,2,1);
        bookingerAfSpiller.setPrefHeight(200);
        bookingerAfSpiller.setPrefWidth(300);
        bookingerAfSpiller.setEditable(false);

        pane.add(lblAntalBookingerPåbane, 3,0);
        pane.add(antalBookinger, 3,1);
        antalBookinger.setPrefHeight(150);
        antalBookinger.setPrefWidth(200);
        antalBookinger.setEditable(false);

        pane.add(lblOpretBooking, 2, 2);
        pane.add(lblDato, 2, 3);
        pane.add(lblTid, 2, 4);
        pane.add(txfDato, 3,3);
        pane.add(txfTid, 3,4);
        pane.add(chxSingle, 2,5);
        pane.add(btxBook, 2,6);
        btxBook.setOnAction(event -> bookBane());

        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 6, 3, 1);
    }


    private void bookBane(){
        if (lvwBaner.getSelectionModel().isEmpty()) {
            lblError.setText("FEJL! du skal vælge en bane");
            return;
        }

        if (lvwSpillere.getSelectionModel().isEmpty()) {
            lblError.setText("FEJL! du skal vælge en spiller");
            return;
        }

        Spiller spiller = lvwSpillere.getSelectionModel().getSelectedItem();
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();

        LocalDate dato = LocalDate.now();
        try {
            dato = LocalDate.parse(txfDato.getText());
        } catch (Exception exception) {
            lblError.setText("Dato format er forkert");
        }

        LocalTime tid = LocalTime.now();
        try {
            tid = LocalTime.parse(txfTid.getText());
        } catch (Exception exception) {
            lblError.setText("Tid format er forkert");
        }

        boolean single = chxSingle.isSelected();

        if(!bane.tidLedig(dato, tid)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Booking ikke ledig");
            alert.setTitle("Booking ikke ledig");
            alert.setHeaderText("Den valgte booking er ikke ledig");
            alert.show();
            return;
        }
        Controller.createBooking(dato, tid, single, bane, spiller);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Booking bekræftiget");
        alert.setTitle("Booking bekræftiget");
        alert.setHeaderText("Den valgte booking er oprettet og bekræftiget");
        alert.show();
        updateSpillerBooking(spiller);
        updateBaneListe(bane);
        clearDataFields();
        lblError.setText("");


    }
    private void baneClick(MouseEvent event) {
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();

        if (bane == null) {
            return;
        }
        updateBaneListe(bane);
    }
    private void updateBaneListe(Bane bane) {
        antalBookinger.clear();
        int index = 0;
        for(int i : bane.antalBookningerPrTime()){

            antalBookinger.appendText("Tid: " + (index+9) + " antal: " + i + System.lineSeparator());
            index++;
        }
    }

    private void updateSpillerBooking(Spiller spiller) {
        bookingerAfSpiller.clear();
        for(Booking booking : spiller.getBookinger()){
            bookingerAfSpiller.appendText(booking.toString() + System.lineSeparator());
        }
    }

    private void spillerClick(MouseEvent event) {
        Spiller spiller = lvwSpillere.getSelectionModel().getSelectedItem();

        if (spiller == null) {
            return;
        }
        updateSpillerBooking(spiller);
    }

    private void clearDataFields(){
        txfDato.clear();
        txfTid.clear();
        chxSingle.setSelected(false);
    }

}
