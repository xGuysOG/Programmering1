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
import model.Patient;
import model.PersonligtMåltid;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;


public class Gui extends Application {
    public void start(Stage stage) {
        stage.setTitle("Kantinens vagtplanlægning");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();


    }
    // -----------------------------------------------------------
    private final ListView<Patient> lvwPatienter = new ListView<Patient>();
    private final ListView<PersonligtMåltid> lvwMåltider= new ListView<PersonligtMåltid>();

    private final Label lblError = new Label("");
    private final Label lblNavn = new Label("Navn:");
    private final Label lblAnbefaletDaglige = new Label("Anbefalet Daglige:");
    private final Label lblDagligIndtaget = new Label("Daglig Indtaget:");
    private final Label lblProcentAnbefalet = new Label("Procent Anbefalet:");
    private final Label lblPatienter = new Label("Patienter:");

    private final TextField txfNavn = new TextField();
    private final TextField txfAnbefaletDaglig = new TextField();
    private final TextField txfDagligIndtaget = new TextField();
    private final TextField txfProcentAnbefalet = new TextField();
    private final Button btnVisMåltider = new Button("Vis Måltider");


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

        pane.add(lblNavn, 0,0);
        pane.add(txfNavn,1,0);

        pane.add(lblAnbefaletDaglige, 0,1);
        pane.add(txfAnbefaletDaglig,1,1);

        pane.add(lblDagligIndtaget, 0,2);
        pane.add(txfDagligIndtaget, 1,2);

        pane.add(lblProcentAnbefalet, 0,3);
        pane.add(txfProcentAnbefalet, 1,3);

        pane.add(lblPatienter, 0,4);
        pane.add(lvwPatienter, 1,4);
        lvwPatienter.setPrefHeight(150);
        lvwPatienter.setPrefWidth(150);
        lvwPatienter.getItems().addAll(Storage.getPatienter());
        lvwPatienter.setOnMouseClicked(mouseEvent -> patientClick(mouseEvent));

        pane.add(btnVisMåltider, 3,3);
        btnVisMåltider.setOnAction(event -> visMåltider());
        pane.add(lvwMåltider, 3,4);
        lvwMåltider.setPrefHeight(200);
        lvwMåltider.setPrefWidth(150);
        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 11, 3, 1);
    }


    private void visMåltider(){
        if (lvwPatienter.getSelectionModel().isEmpty()) {
            lblError.setText("ERROR you need ot select a patient");
            return;
        }
        Patient patient = lvwPatienter.getSelectionModel().getSelectedItem();

        if (patient == null) {
            lblError.setText("ERROR you need ot select a patient2");
            return;
        }
        if (patient.getPersonligtMåltider().isEmpty()) {
            lblError.setText("ERROR No måltid for this person");
            return;
        }
        lvwMåltider.getItems().setAll(patient.getPersonligtMåltider());

    }
    private void patientClick(MouseEvent event) {
        Patient patient = lvwPatienter.getSelectionModel().getSelectedItem();

        if (patient == null) {
            return;
        }
        clearDataFields();
        //Clear data

        //Fill data
        txfNavn.setText(patient.getNavn());
        txfAnbefaletDaglig.setText(String.valueOf(patient.beregnAnbefaletKalorierPerDag()));
        txfDagligIndtaget.setText(String.valueOf(patient.beregnDagensAntalKalorier()));
        txfProcentAnbefalet.setText(String.valueOf(patient.beregnProcentDagligAnbefalet()));
    }

    private void clearDataFields(){
        txfNavn.clear();
        txfAnbefaletDaglig.clear();
        txfDagligIndtaget.clear();
        txfProcentAnbefalet.clear();
    }

}
