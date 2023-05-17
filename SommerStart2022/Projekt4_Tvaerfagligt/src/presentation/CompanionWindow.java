package presentation;

import application.controller.Controller;
import application.model.Companion;
import application.model.Conference;
import application.model.Registration;
import application.model.Trip;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CompanionWindow extends Stage {
    private Conference conference;
    private Registration registration;
    private Companion companion;

    public CompanionWindow(String title, Conference conference, Registration registration) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.conference = conference;
        this.registration = registration;

        if (registration.hasCompanion()) {
            companion = registration.getCompanion();
        }

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
    // -------------------------------------------------------------------------

    private TextField txfName;
    private final ListView<Trip> lvwTrips = new ListView<>();


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblTitle = new Label("Ledsager");
        lblTitle.setFont(Font.font(20));
        pane.add(lblTitle, 0, 0);

        Label lblName = new Label("Navn:");
        lblName.setFont(Font.font(15));

        pane.add(lblName, 0, 1);

        txfName = new TextField();
        pane.add(txfName, 1, 1);

        Label lblTrips = new Label("Udflugter");
        lblTrips.setFont(Font.font(15));
        pane.add(lblTrips, 0, 2);

        lvwTrips.getItems().setAll(conference.getTrips());
        lvwTrips.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        pane.add(lvwTrips, 0, 3, 2, 1);

        initFields();

        Button btnCancel = new Button("Annuller");
        pane.add(btnCancel, 0, 4);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnConfirm = new Button("Bekræft");
        pane.add(btnConfirm, 1, 4);
        GridPane.setHalignment(btnConfirm, HPos.RIGHT);
        btnConfirm.setOnAction(event -> this.okAction());
    }

    private void initFields() {
        if (companion != null) {
            txfName.setText(companion.getName());
            for (Trip trip : companion.getTrips()) {
                lvwTrips.getSelectionModel().select(trip);
            }
        }
    }

    private void okAction() {
        String name = txfName.getText().trim();

        if (!name.isEmpty()) {
            Companion companion = registration.createCompanion(name);
            Controller.setTrips(companion, lvwTrips.getSelectionModel().getSelectedItems());
        }

        this.hide();
    }

    private void cancelAction() {
        this.hide();
    }

//    public Companion getCompanion() {
//        return companion;
//    }
}
