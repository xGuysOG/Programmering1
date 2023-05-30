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
import model.Medarbejder;
import model.Vagt;
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
    private final ListView<Medarbejder> lvwMedarbejder = new ListView<Medarbejder>();
    private final ListView<Vagt> lvwVagter= new ListView<Vagt>();
    private final TextArea txaValgtVagt = new TextArea();
    private final Label lblError = new Label("");
    private final Label lblAlleMedarbejdere = new Label("Alle medarbejdere");
    private final Label lblVagter = new Label("Alle vagter");
    private final Label lblValgtVagt = new Label("Valgt vagt");
    private final Button btnTildeltVagt = new Button("Tildel vagt");
    private final Button btnUdskriv = new Button("Udskriv vagt til fil");



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
        pane.add(lblAlleMedarbejdere, 0, 0);

        // Listview
        pane.add(lvwMedarbejder, 0, 1, 3, 5);
        lvwMedarbejder.setPrefHeight(250);
        lvwMedarbejder.setPrefWidth(250);
        lvwMedarbejder.getItems().setAll(Storage.getMedarbejdere());


        // Hoteller listview
        pane.add(lblVagter, 4, 0);
        pane.add(lvwVagter, 4, 1, 3, 5);
        lvwVagter.setPrefHeight(250);
        lvwVagter.setPrefWidth(250);;
        lvwVagter.getItems().setAll(Storage.getVagter());

        lvwVagter.setOnMouseClicked(mouseEvent -> vagtClick(mouseEvent));

        pane.add(btnTildeltVagt,4,6);
        btnTildeltVagt.setOnAction(event -> tildelVagt());

        // Udflugter listview
        pane.add(lblValgtVagt, 8, 0);
        pane.add(txaValgtVagt, 8, 1, 3, 5);
        txaValgtVagt.setPrefHeight(200);
        txaValgtVagt.setPrefWidth(250);
        txaValgtVagt.setEditable(false);

        pane.add(btnUdskriv,8,6);
        btnUdskriv.setOnAction(event -> print());



        txaValgtVagt.setText("Ingen vagt valgt");
        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 11, 3, 1);
    }

    private void tildelVagt() {
        if (lvwMedarbejder.getSelectionModel().isEmpty()){
            lblError.setText("Please select a Medarbejder");
            return;
        }

        if (lvwMedarbejder.getSelectionModel().isEmpty()){
            lblError.setText("Please select a Vagt");
            return;
        }
        Medarbejder medarbejder = lvwMedarbejder.getSelectionModel().getSelectedItem();
        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();

        //now we do the fun stuff.

        try {
            Controller.tilføjVagt(medarbejder, vagt);
            txaValgtVagt.setText(vagt.description());
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setTitle("Tildel vagt");
            alert.setHeaderText("Vagt kan ikke tildeles");
            alert.show();
        }

        lblError.setText("Worked :)");
    }

    private void print(){
        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();
        if (vagt != null) {
            Controller.udskrivVagtPlan(vagt, "vagtplan.txt");
            Alert popup = new Alert(Alert.AlertType.INFORMATION, "Fil generet med navnet vagtplan.txt");
            popup.show();
        } else {
            txaValgtVagt.setText("Ingen vagt valgt");
        }
    }

    private void vagtClick(MouseEvent event) {
        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();

        if (vagt != null) {
            txaValgtVagt.setText(vagt.description());
        } else {
            txaValgtVagt.setText("Ingen vagt valgt");
        }
    }

}
