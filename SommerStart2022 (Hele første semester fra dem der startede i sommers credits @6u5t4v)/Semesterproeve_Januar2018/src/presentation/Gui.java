package presentation;

import application.Controller;
import application.model.Arrangement;
import application.model.Tutor;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
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
        stage.setTitle("Administration af tutorer og arrangementer");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private ListView<Tutor> lvwTutorer;
    private ListView<Arrangement> lvwArrangementerTildelt;
    private ListView<Arrangement> lvwArrangementer;

    private TextField txfNavn, txfEmail;

    private Tutor tutor;

    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblTutorer = new Label("Tutorer"),
                lblNavn = new Label("Navn"),
                lblEmail = new Label("Email"),
                lblTildelteArrangementer = new Label("Arrangementer"),
                lblArrangementer = new Label("Alle mulige Arrangementer");

        GridPane.setValignment(lblTildelteArrangementer, VPos.TOP);


        pane.add(lblTutorer, 0, 0);
        pane.add(lblNavn, 1, 0);
        pane.add(lblEmail, 1, 1);
        pane.add(lblTildelteArrangementer, 1, 2);
        pane.add(lblArrangementer, 3, 1);

        lvwTutorer = new ListView<>();
        lvwTutorer.getItems().setAll(Controller.getTutorer());
        lvwTutorer.getSelectionModel().selectFirst();
        tutor = lvwTutorer.getSelectionModel().getSelectedItem();
        lvwTutorer.setMaxHeight(300);
        GridPane.setValignment(lvwTutorer, VPos.TOP);

        lvwArrangementerTildelt = new ListView<>();
        lvwArrangementerTildelt.getItems().setAll(tutor.getArrangementer());
        lvwArrangementerTildelt.setMaxHeight(200);
        GridPane.setValignment(lvwArrangementerTildelt, VPos.TOP);

        lvwArrangementer = new ListView<>();
        lvwArrangementer.getItems().setAll(Controller.getArrangementer());
        lvwArrangementer.setMaxHeight(200);
        GridPane.setValignment(lvwArrangementer, VPos.TOP);

        pane.add(lvwTutorer, 0, 1, 1, 3);
        pane.add(lvwArrangementerTildelt, 2, 2);
        pane.add(lvwArrangementer, 3, 2);

        txfNavn = new TextField(tutor.getNavn());
        txfNavn.setEditable(false);
        txfEmail = new TextField(tutor.getEmail());
        txfEmail.setEditable(false);

        pane.add(txfNavn, 2, 0);
        pane.add(txfEmail, 2, 1);

        Button btnFjernArrangement = new Button("Fjern");
        Button btnTilføjArrangement = new Button("Tilføj");

        pane.add(btnFjernArrangement, 2, 3);
        pane.add(btnTilføjArrangement, 3, 3);

        btnFjernArrangement.setOnAction(e -> this.fjernArrangementAction());
        btnTilføjArrangement.setOnAction(e -> this.tilføjArrangementAction());

        ChangeListener<Tutor> listener = (ov, old, newVagt) -> this.selectTutor();
        lvwTutorer.getSelectionModel().selectedItemProperty().addListener(listener);
    }

    private void tilføjArrangementAction() {
        Arrangement selected = lvwArrangementer.getSelectionModel().getSelectedItem();

        if (selected != null) {
            try {
                Controller.tilføjTilArrangement(selected, tutor);
                lvwArrangementerTildelt.getItems().add(selected);
            } catch (RuntimeException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                alert.setTitle("Tildel arrangement");
                alert.setHeaderText("Kunne ikke tildele arrangement til tutor");
                alert.show();
            }
        }
    }

    private void fjernArrangementAction() {
        Arrangement selected = lvwArrangementerTildelt.getSelectionModel().getSelectedItem();

        if (selected != null) {
            tutor.removeArrangement(selected);
            lvwArrangementerTildelt.getItems().remove(selected);
        }
    }

    private void selectTutor() {
        tutor = lvwTutorer.getSelectionModel().getSelectedItem();

        if (tutor != null) {
            txfNavn.setText(tutor.getNavn());
            txfEmail.setText(tutor.getEmail());
            lvwArrangementerTildelt.getItems().setAll(tutor.getArrangementer());
        } else {
            txfNavn.setText("");
            txfEmail.setText("");
            lvwArrangementerTildelt.getItems().setAll(new ArrayList<>());
        }
    }
}
