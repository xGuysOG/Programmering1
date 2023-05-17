package gui;

import application.Controller;
import application.model.Løb;
import application.model.Note;
import application.model.Tilmelding;
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

public class Gui extends Application {


    @Override
    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("OCR Administrationssystem");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Løb> lvwLøb = new ListView<>();
    private final ListView<Tilmelding> lvwTilmeldinger = new ListView<>();
    private final ListView<Note> lvwNoter = new ListView<>();

    private TextField txfForhindring, txfStrafSekund;
    private Button btnRegisterNote;

    private Løb løb;

    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblLøb = new Label("Løb");
        pane.add(lblLøb, 0, 0);

        Label lblTilmeldinger = new Label("Tilmeldinger");
        pane.add(lblTilmeldinger, 1, 0);

        Label lblNoter = new Label("Noter");
        pane.add(lblNoter, 2, 0);

        lvwLøb.getItems().setAll(Controller.getLøb());
        lvwLøb.getSelectionModel().selectFirst();
        løb = lvwLøb.getSelectionModel().getSelectedItem();
        pane.add(lvwLøb, 0, 1);

        lvwTilmeldinger.getItems().setAll(løb.getTilmeldinger());
        pane.add(lvwTilmeldinger, 1, 1);

        lvwNoter.setDisable(true);
        pane.add(lvwNoter, 2, 1);

        btnRegisterNote = new Button("Registrer Note");
        pane.add(btnRegisterNote, 2, 2);

        ChangeListener<Løb> løbListener = (ov, old, newLøb) -> this.selectLøb();
        lvwLøb.getSelectionModel().selectedItemProperty().addListener(løbListener);

        ChangeListener<Tilmelding> tilmeldingListener = (ov, old, newTilmelding) -> this.selectTilmelding();
        lvwTilmeldinger.getSelectionModel().selectedItemProperty().addListener(tilmeldingListener);
    }

    private void selectTilmelding() {
        Tilmelding tilmelding = lvwTilmeldinger.getSelectionModel().getSelectedItem();

        if (tilmelding != null) {
            lvwNoter.getItems().setAll(tilmelding.getNoter());
        } else {
            lvwNoter.getItems().clear();
        }
    }

    private void selectLøb() {
        løb = lvwLøb.getSelectionModel().getSelectedItem();
        if (løb != null) {
            lvwTilmeldinger.getItems().setAll(løb.getTilmeldinger());
        } else {
            lvwTilmeldinger.getItems().clear();
        }
    }
}
