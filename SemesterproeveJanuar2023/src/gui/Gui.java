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
import model.Salgsannonce;
import model.Vare;
import storage.Storage;


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
    private final ListView<Salgsannonce> lvwSalgsannonce = new ListView<Salgsannonce>();
    private final ListView<Vare> lvwVarer = new ListView<Vare>();
    private final Label lblError = new Label("");
    private final Label lblSalgsannonce = new Label("Aktive Salgsannonce: ");
    private final Label lblVarer = new Label("Varer");

    private final Label lblKøber = new Label("Køber");
    private final Label lblAftaltPris = new Label("Aftalt pris");
    private final TextField txfKøber = new TextField();
    private final TextField txfAftaltPris = new TextField();
    private final Label lblFilnavn = new Label("Fil navn");
    private final TextField txfFilNavn = new TextField();
    private final Button btnOpretSalg = new Button("Opret salg");
    private final Button btnSalgsFil = new Button("Salgs fil");



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



        //Salgsannonce
        pane.add(lblSalgsannonce, 0, 0);

        pane.add(lvwSalgsannonce, 0, 1, 3, 5);
        lvwSalgsannonce.setPrefHeight(200);
        lvwSalgsannonce.setPrefWidth(300);
        lvwSalgsannonce.getItems().setAll(Controller.getAktiveSalgsannoncer());
        lvwSalgsannonce.getSelectionModel().selectFirst();


        //Varer
        pane.add(lblVarer, 4, 0);
        pane.add(lvwVarer, 4, 1, 3, 5);
        lvwVarer.setPrefHeight(200);
        lvwVarer.setPrefWidth(300);
        lvwVarer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        pane.add(lblKøber, 7,1);
        pane.add(txfKøber,8,1);
        pane.add(lblAftaltPris, 7,2);
        pane.add(txfAftaltPris,8,2);

        pane.add(btnOpretSalg, 7,3);

        pane.add(lblFilnavn, 7,6);
        pane.add(txfFilNavn,8,6);

        pane.add(btnSalgsFil, 7, 7);


        // Error stuff
        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 11, 3, 1);



    }
}
