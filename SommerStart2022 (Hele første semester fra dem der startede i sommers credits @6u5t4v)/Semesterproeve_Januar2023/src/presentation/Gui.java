package presentation;

import application.Controller;
import application.model.SalgsAnnounce;
import application.model.Vare;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {


    @Override
    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Handelsplatform");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private ListView<SalgsAnnounce> lvwAnnouncer = new ListView<>();
    private ListView<Vare> lvwVarer = new ListView<>();

    private TextField txfKøberNavn = new TextField();
    private TextField txfAftaltPris = new TextField();
    private TextField txfFilNavn = new TextField();

    private SalgsAnnounce salgsAnnounce;
    private ArrayList<Vare> valgteVarer = new ArrayList<>();

    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblAktive = new Label("Aktive announcer"),
                lblVarer = new Label("Varer"), lblKøber = new Label("Køber"),
                lblAftaltPris = new Label("Aftalt pris"), lblFilNavn = new Label("Fil navn");

        pane.add(lblAktive, 0, 0);
        pane.add(lblVarer, 1, 0);
        pane.add(lblKøber, 2, 1);
        pane.add(lblAftaltPris, 2, 2);
        pane.add(lblFilNavn, 2, 5);


        pane.add(lvwAnnouncer, 0, 1, 1, 4);
        lvwAnnouncer.getItems().setAll(Controller.aktiveSalgsAnnouncer());
        lvwAnnouncer.getSelectionModel().selectFirst();
        salgsAnnounce = lvwAnnouncer.getSelectionModel().getSelectedItem();
        lvwAnnouncer.setPrefHeight(200);

        pane.add(lvwVarer, 1, 1, 1, 4);
        lvwVarer.getItems().setAll(salgsAnnounce.getVarer());
        lvwVarer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvwVarer.setPrefHeight(200);

        pane.add(txfKøberNavn, 3, 1);
        pane.add(txfAftaltPris, 3, 2);
        pane.add(txfFilNavn, 3, 5);

        Button btnOpretSalg = new Button("Opret salg");
        pane.add(btnOpretSalg, 2, 3);

        Button btnOpretFil = new Button("Salgs fil");
        pane.add(btnOpretFil, 2, 6);

        btnOpretSalg.setOnAction(e -> opretSalgAction());
        btnOpretFil.setOnAction(e -> opretSalgsFil());

        ChangeListener<SalgsAnnounce> listener = (ov, old, newAnnonce) -> this.selectAnnonce();
        lvwAnnouncer.getSelectionModel().selectedItemProperty().addListener(listener);

//        ChangeListener<Vare> vareChangeListener = (ov, old, newVare) -> this.selectVare();
//        lvwVarer.getSelectionModel().selectedItemProperty().addListener(vareChangeListener);
    }

    private void opretSalgsFil() {
        String filNavn = txfFilNavn.getText().trim();
        if (filNavn.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Udfyld feltet \"Fil navn\"");
            alert.setHeaderText("Fil navn ikke angivet");
            alert.show();
            return;
        }

        Controller.salgTilFil(filNavn);
    }

    private void opretSalgAction() {
        ObservableList<Vare> varer = lvwVarer.getSelectionModel().getSelectedItems();

        valgteVarer.clear();
        valgteVarer.addAll(varer);

        String køberNavn = txfKøberNavn.getText().trim();
        String aftaltPrisInput = txfAftaltPris.getText().trim();

        if (køberNavn.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Køber navn må ikke være tomt");
            alert.setHeaderText("Køber navn ikke angivet");
            alert.show();
            return;
        }

        if (aftaltPrisInput.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Der skal være aftalt en pris");
            alert.setHeaderText("Aftalt pris ikke angivet");
            alert.show();
            return;
        }

        if (!tilgængeligVarer()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "En af de valgte vare er solgt i forvejen");
            alert.setHeaderText("Vare allerede solgt");
            alert.show();
            return;
        }

        try {
            int aftaltPris = Integer.parseInt(aftaltPrisInput);

            Controller.opretSalg(køberNavn, aftaltPris, valgteVarer);
            lvwVarer.getItems().setAll(salgsAnnounce.getVarer());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, valgteVarer.size() + " varer solgt for " + aftaltPris + " til " + køberNavn);
            alert.setHeaderText("Salg oprettet!");
            alert.show();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Prisen skal være et hel tal");
            alert.setHeaderText("Aftalt pris ikke et heltal");
            alert.show();
        }
    }

    private boolean tilgængeligVarer() {
        boolean tilgængelig = true;

        int index = 0;
        while (tilgængelig && index < valgteVarer.size()) {
            Vare vare = valgteVarer.get(index);
            if (vare.isSolgt()) tilgængelig = false;
            else index++;
        }

        return tilgængelig;
    }

    private void selectVare() {
        ObservableList<Vare> varer = lvwVarer.getSelectionModel().getSelectedItems();

        valgteVarer.clear();
        valgteVarer.addAll(varer);
    }

    private void selectAnnonce() {
        salgsAnnounce = lvwAnnouncer.getSelectionModel().getSelectedItem();

        if (salgsAnnounce != null) {
            lvwVarer.getItems().setAll(salgsAnnounce.getVarer());
        } else {
            lvwVarer.getItems().clear();
        }

    }


}
