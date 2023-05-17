package gui;

import application.Controller;
import application.model.Bil;
import application.model.BilMærke;
import application.model.Parkeringshus;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {


    @Override
    public void init() {
        Controller.createSomeObjects();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Boys and Girls");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private ListView<Parkeringshus> lvwParkeringshus = new ListView<>();
    private ListView<String> lvwPladser = new ListView<>();

    private TextField txfOpretBil;
    private Button btnOpret = new Button("Opret");

    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblParkeringshus = new Label("Parkeringshuse");
        pane.add(lblParkeringshus, 0, 0);

        Label lblPladser = new Label("Optagne Pladser");
        pane.add(lblPladser, 1, 0);

        lvwParkeringshus.prefHeight(60);
        lvwParkeringshus.getItems().setAll(Controller.getParkeringshuse());

        lvwPladser.prefHeight(60);

        pane.add(lvwParkeringshus, 0, 1);
        pane.add(lvwPladser, 1, 1);

        Label lblOpretBil = new Label("Opret bil med nummer:");
        pane.add(lblOpretBil, 0, 2);

        txfOpretBil = new TextField();
        pane.add(txfOpretBil, 1, 2);

        btnOpret.setDisable(true);
        pane.add(btnOpret, 1, 3);

        btnOpret.setOnAction(e -> opretBilAction());

        ChangeListener<Parkeringshus> listener = (ov, oldParkhouse, newParkhouse) -> this.selectionChanged();
        lvwParkeringshus.getSelectionModel().selectedItemProperty().addListener(listener);
    }

    private void selectionChanged() {
        Parkeringshus selected = lvwParkeringshus.getSelectionModel().getSelectedItem();

        if (selected != null) {
            lvwPladser.getItems().setAll(Controller.getOptagnePladser(selected));
            btnOpret.setDisable(false);
        } else {
            // Clear fields
            lvwPladser.getItems().setAll(new ArrayList<>());
            btnOpret.setDisable(true);
        }
    }

    private void opretBilAction() {
        String regNr = txfOpretBil.getText().trim();
        if (regNr.isEmpty()) return;

        Parkeringshus selected = lvwParkeringshus.getSelectionModel().getSelectedItem();

        Bil bil = Controller.createBil(regNr, BilMærke.AUDI);
        Controller.parkerBilLedigPlads(selected, bil);

        lvwPladser.getItems().setAll(Controller.getOptagnePladser(selected));
    }
}
