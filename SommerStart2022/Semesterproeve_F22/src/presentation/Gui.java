package presentation;

import application.Controller;
import application.model.Medarbejder;
import application.model.Vagt;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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

    private ListView<Medarbejder> lvwMedarbejdere = new ListView<>();
    private ListView<Vagt> lvwVagter = new ListView<>();
    private TextArea txaVagt = new TextArea("Ingen vagt valgt");

    private Vagt vagt;

    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblMedarbejdere = new Label("Alle Medarbejdere"),
                lblVagter = new Label("Alle Vagter"),
                lblVagt = new Label("Valgt Vagt");

        pane.add(lblMedarbejdere, 0, 0);
        pane.add(lblVagter, 1, 0);
        pane.add(lblVagt, 2, 0);

        lvwMedarbejdere.getItems().setAll(Controller.getAlleMedarbejdere());
        pane.add(lvwMedarbejdere, 0, 1);

        lvwVagter.getItems().setAll(Controller.getAlleVagter());
        pane.add(lvwVagter, 1, 1);

        pane.add(txaVagt, 2, 1);

        Button btnTildelVagt = new Button("Tildel vagt");
        pane.add(btnTildelVagt, 1, 2);

        Button btnUdskriv = new Button("Udskriv vagt til fil");
        pane.add(btnUdskriv, 2, 2);

        btnTildelVagt.setOnAction(e -> this.tildelVagtAction());
        btnUdskriv.setOnAction(e -> this.udskrivAction());

        ChangeListener<Vagt> listener = (ov, old, newVagt) -> this.selectVagt();
        lvwVagter.getSelectionModel().selectedItemProperty().addListener(listener);
    }

    private void udskrivAction() {
        if (vagt != null) {
            Controller.udskrivVagtPlan(vagt, "vagtplan.txt");
            Alert popup = new Alert(Alert.AlertType.INFORMATION, "Fil generet med navnet vagtplan.txt");
            popup.show();
        }
    }

    private void tildelVagtAction() {
        Medarbejder medarbejder = lvwMedarbejdere.getSelectionModel().getSelectedItem();

        if (vagt == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ingen vagt valgt");
            alert.setTitle("Tildel vagt");
            alert.setHeaderText("Vagt kunne ikke tildeles");
            alert.show();
            return;
        }

        if (medarbejder == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ingen medarbejder valgt");
            alert.setTitle("Tildel vagt");
            alert.setHeaderText("Vagt kunne ikke tildeles");
            alert.show();
            return;
        }

        try {
            Controller.tilføjVagt(medarbejder, vagt);
            txaVagt.setText(vagt.description());
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setTitle("Tildel vagt");
            alert.setHeaderText("Vagt kan ikke tildeles");
            alert.show();
        }
    }

    private void selectVagt() {
        vagt = lvwVagter.getSelectionModel().getSelectedItem();

        if (vagt != null) {
            txaVagt.setText(vagt.description());
        } else {
            txaVagt.setText("Ingen vagt valgt");
        }
    }

}
