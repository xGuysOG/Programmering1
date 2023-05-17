package presentation;

import application.Controller;
import application.model.Kamp;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;

public class Gui extends Application {


    @Override
    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Administration af spiller deltagelse");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Kamp> lvwKampe = new ListView<>();

    private TextField txfSted, txfDato, txfTid;

    private Kamp kamp;

    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblKampe = new Label("Kampe"),
                lblSted = new Label("Spillested:"),
                lblDato = new Label("Spilledato:"),
                lblTid = new Label("Spilletid:");

        pane.add(lblKampe, 0, 0);
        pane.add(lblSted, 1, 0);
        pane.add(lblDato, 1, 1);
        pane.add(lblTid, 1, 2);

        pane.add(lvwKampe, 0, 1, 1, 5);
        lvwKampe.setMaxHeight(200);
        lvwKampe.getItems().setAll(Controller.getKampe());
        lvwKampe.getSelectionModel().selectFirst();
        kamp = lvwKampe.getSelectionModel().getSelectedItem();


        txfSted = new TextField(kamp.getSted());
        pane.add(txfSted, 2, 0);

        txfDato = new TextField(kamp.getDato().toString());
        pane.add(txfDato, 2, 1);

        txfTid = new TextField(kamp.getTid().toString());
        pane.add(txfTid, 2, 2);


        HBox hBox = new HBox();
        hBox.setSpacing(8);
        pane.add(hBox, 2, 3);

        Button btnOpret = new Button("Opret");
        Button btnOpdater = new Button("Opdater");
        hBox.getChildren().setAll(btnOpret, btnOpdater);

        Button btnLavFil = new Button("Lav fil");
        pane.add(btnLavFil, 2, 4);

        btnOpret.setOnAction(e -> opretKampAction());
        btnOpdater.setOnAction(e -> opdaterKampAction());
        btnLavFil.setOnAction(e -> lavFilAction());


        ChangeListener<Kamp> listener = (ov, old, newKamp) -> this.selectKamp();
        lvwKampe.getSelectionModel().selectedItemProperty().addListener(listener);
    }

    private void lavFilAction() {
        if (kamp != null) {
            Controller.lavFil(kamp);
        }
    }

    private void opretKampAction() {
        String sted = txfSted.getText().trim();
        String datoStr = txfDato.getText().trim();
        String tidStr = txfTid.getText().trim();

        LocalDate dato = null;
        try {
            dato = LocalDate.parse(datoStr);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Dato kan ikke parses til en valid dato");
            alert.show();
            return;
        }

        LocalTime tid = null;
        try {
            tid = LocalTime.parse(tidStr);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Tid kan ikke parses til en valid tid");
            alert.show();
            return;
        }

        Kamp kamp = Controller.createKamp(sted, dato, tid);
        lvwKampe.getItems().add(kamp);
        lvwKampe.getSelectionModel().select(kamp);
    }

    private void selectKamp() {
        kamp = lvwKampe.getSelectionModel().getSelectedItem();

        System.out.println("selected");

        if (kamp != null) {
            txfSted.setText(kamp.getSted());
            txfDato.setText(kamp.getDato().toString());
            txfTid.setText(kamp.getTid().toString());
        } else {
            txfSted.setText("");
            txfDato.setText("");
            txfTid.setText("");
        }
    }

    private void opdaterKampAction() {
        kamp = lvwKampe.getSelectionModel().getSelectedItem();

        if (kamp != null) {
            String sted = txfSted.getText().trim();
            String datoStr = txfDato.getText().trim();
            String tidStr = txfTid.getText().trim();

            LocalDate dato = null;
            try {
                dato = LocalDate.parse(datoStr);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Dato kan ikke parses til en valid dato");
                alert.show();
                return;
            }

            LocalTime tid = null;
            try {
                tid = LocalTime.parse(tidStr);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Tid kan ikke parses til en valid tid");
                alert.show();
                return;
            }

            Controller.opdaterKamp(kamp, sted, dato, tid);
            lvwKampe.getItems().setAll(Controller.getKampe());
            lvwKampe.getSelectionModel().select(kamp);
        }
    }
}
