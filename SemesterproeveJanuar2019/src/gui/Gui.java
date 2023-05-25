package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;


public class Gui extends Application {
    public void start(Stage stage) {
        stage.setTitle("Konferencer");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();


    }
    // -----------------------------------------------------------
    private final ListView<Forestilling> lvwForestilling = new ListView<Forestilling>();
    private final ListView<Kunde> lvwKunder = new ListView<Kunde>();
    private final TextArea txaBestilling = new TextArea();
    private final Label lblError = new Label("");
    private final Label lblForestillinger = new Label("Forestillinger");
    private final Label lblKunder = new Label("kunder");
    private final Label lblDato = new Label("Dato:");
    private final Label lblKundeNavn = new Label("Kunde Navn");
    private final Label lblKundeMobil = new Label("Kunde Mobil");
    private final Label lblBestiltePladser = new Label("Bestilte pladser");

    private final TextField txfDato = new TextField();
    private final TextField txfKundeNavn = new TextField();
    private final TextField txfKundeMobil = new TextField();

    private final Button btnBestiltePladser = new Button("Vis bestilte pladser");
    private final Button btnOpretKunde = new Button("Opret kunde");

    private final ToggleGroup toggleGroup = new ToggleGroup();



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

        // Labels
        pane.add(lblForestillinger, 0, 0);

        // Listview
        pane.add(lvwForestilling, 0, 1, 3, 5);
        lvwForestilling.setPrefHeight(250);
        lvwForestilling.setPrefWidth(250);
        lvwForestilling.getItems().setAll(Storage.getForestillinger());

        lvwForestilling.setOnMouseClicked(mouseEvent -> forestillingerClick(mouseEvent));

        // Hoteller listview
        pane.add(lblKunder, 4, 0);
        pane.add(lvwKunder, 4, 1, 3, 5);
        lvwKunder.setPrefHeight(250);
        lvwKunder.setPrefWidth(250);

        pane.add(lblDato, 8,0);
        pane.add(txfDato, 8,1);
        pane.add(btnBestiltePladser, 8,2);
        btnBestiltePladser.setOnAction(event -> visBestiltePladser());

        // Udflugter listview
        pane.add(lblBestiltePladser, 8, 3);
        pane.add(txaBestilling, 8, 4, 3, 5);
        txaBestilling.setPrefHeight(200);
        txaBestilling.setPrefWidth(250);
        txaBestilling.setEditable(false);

        pane.add(lblKundeNavn,4,6);
        pane.add(txfKundeNavn,4,7);
        pane.add(lblKundeMobil,4,8);
        pane.add(txfKundeMobil,4,9);

        pane.add(btnOpretKunde, 4,10);
        btnOpretKunde.setOnAction(event -> lavKunde());



        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 11, 3, 1);
    }

    private void lavKunde() {
        if (txfKundeNavn.getText().length() < 1) {
            lblError.setText("Error you need to input a navn");
            return;
        }
        if (txfKundeMobil.getText().length() < 1) {
            lblError.setText("Error you need to input a mobile number");
            return;
        }
        String navn = txfKundeNavn.getText();
        String mobil = txfKundeMobil.getText();

        Controller.createKunde(navn, mobil);
        lblError.setText("Worked :)");
    }
    private void visBestiltePladser(){
        LocalDate date = LocalDate.now();
        try {
            date = LocalDate.parse(txfDato.getText());
        } catch(Exception exception){
            lblError.setText("ERROR wrong date input");
            return;
        }
        if (lvwForestilling.getSelectionModel().isEmpty()){
            lblError.setText("Please select a forestilling");
            return;
        }
        Forestilling forestilling = lvwForestilling.getSelectionModel().getSelectedItem();
        if (lvwKunder.getSelectionModel().isEmpty()){
            lblError.setText("Please select a customer");
            return;
        }

        Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
        txaBestilling.clear();
        ArrayList<Plads> bestilte = kunde.bestiltePladserTilForestillingPådag(forestilling,date);
        if (bestilte.size() == 0) {
            lblError.setText("No plads ordered for this customer on this forestilling");
            return;
        }
        for(Plads plads : bestilte) {
            txaBestilling.appendText(plads.toString() +  System.lineSeparator());
        }
    }

    private void forestillingerClick(MouseEvent event) {
        System.out.println("Called");
        ListView<Forestilling> forestillinger = (ListView) event.getSource();
        if (forestillinger.getSelectionModel().isEmpty()){
            System.out.println("weird");
            return;
        }
        Forestilling forestilling = forestillinger.getSelectionModel().getSelectedItem();
        System.out.println("Faget clicked " + forestilling);
        if (forestilling != null) {
            lvwKunder.getItems().clear();
            lvwKunder.getItems().addAll(forestilling.hentKunder());
        }
    }

}
