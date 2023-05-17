package gui;

import application.Controller;
import application.model.Festival;
import application.model.Frivillig;
import application.model.Job;
import application.model.Vagt;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {


    @Override
    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Festival administration af frivillige");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private ListView<Festival> lvwFestivaller = new ListView<>();
    private ListView<Job> lvwJobs = new ListView<>();
    private ListView<Frivillig> lvwFrivillige = new ListView<>();
    private TextArea txaFrivilligInfo = new TextArea();

    private Label lblError;

    private Button btnSubmit = new Button("Tag vagt");
    private TextField txfInput = new TextField();

    private Festival festival;
    private Job job;
    private Frivillig frivillig;

    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblFestivaller = new Label("Festivaller");
        pane.add(lblFestivaller, 0, 0);

        lvwFestivaller.getItems().setAll(Controller.getFestivaller());
        lvwFestivaller.getSelectionModel().selectFirst();
        festival = lvwFestivaller.getSelectionModel().getSelectedItem();
        pane.add(lvwFestivaller, 0, 1);

        Label lblJobs = new Label("Jobs");
        pane.add(lblJobs, 1, 0);

        lvwJobs.getItems().setAll(festival.getJobs());
        pane.add(lvwJobs, 1, 1);

        Label lblFrivillige = new Label("Frivillige");
        pane.add(lblFrivillige, 2, 0);

        lvwFrivillige.getItems().setAll(Controller.getFrivillige());
        pane.add(lvwFrivillige, 2, 1);

        Label lblTildelteJobs = new Label("Tildelte Jobs");
        pane.add(lblTildelteJobs, 3, 0);

        pane.add(txaFrivilligInfo, 3, 1);

        lblError = new Label();
        lblError.setFont(Font.font(16));
        lblError.setTextFill(Color.RED);
        GridPane.setHalignment(lblError, HPos.CENTER);

        pane.add(lblError, 0, 2, 4, 1);

        HBox inputBox = new HBox();
        pane.add(inputBox, 0, 3, 4, 1);

        Label lblTimer = new Label("Timer");
        btnSubmit.setDisable(true);

        inputBox.getChildren().addAll(lblTimer, txfInput, btnSubmit);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setSpacing(20);

        GridPane.setHalignment(inputBox, HPos.CENTER);

        btnSubmit.setOnAction(e -> tagVagtAction());

        ChangeListener<Festival> festivalListener = (ov, old, newFestival) -> this.festivalSelectionChanged();
        lvwFestivaller.getSelectionModel().selectedItemProperty().addListener(festivalListener);

        ChangeListener<Job> jobListener = (ov, old, newJob) -> this.jobSelectionChanged();
        lvwJobs.getSelectionModel().selectedItemProperty().addListener(jobListener);

        ChangeListener<Frivillig> frivilligListener = (ov, old, newFrivillig) -> this.frivilligSelectionChanged();
        lvwFrivillige.getSelectionModel().selectedItemProperty().addListener(frivilligListener);
    }

    private void jobSelectionChanged() {
        job = lvwJobs.getSelectionModel().getSelectedItem();

        updateSubmitButton();
    }

    private void tagVagtAction() {
        String input = txfInput.getText().trim();

        try {
            int hours = Integer.parseInt(input);
            Controller.tagVagt(job, frivillig, hours);
            opdaterFrivilligeOplysninger();
            lblError.setText("");
        } catch (NumberFormatException e) {
            lblError.setText("Inputtet skal skal være et hel tal");
        } catch (RuntimeException e1) {
            lblError.setText(e1.getMessage());
        }
    }

    private void festivalSelectionChanged() {
        festival = lvwFestivaller.getSelectionModel().getSelectedItem();

        if (festival != null) {
            lvwJobs.getItems().setAll(festival.getJobs());
        } else {
            lvwJobs.getItems().clear();
        }
    }

    private void frivilligSelectionChanged() {
        frivillig = lvwFrivillige.getSelectionModel().getSelectedItem();

        if (frivillig != null) {
            opdaterFrivilligeOplysninger();
        } else {
            txaFrivilligInfo.clear();
        }

        updateSubmitButton();
    }

    private void opdaterFrivilligeOplysninger() {
        StringBuilder info = new StringBuilder(frivillig.getNavn() + "\nMaks timer der ønskes er " + frivillig.getMaksAntalTimer() + "\n");
        ArrayList<Vagt> vagter = frivillig.getVagter();
        for (Vagt vagt : vagter) {
            info.append(vagt.getTimer()).append(" på ").append(vagt.getJob().getKode()).append("\n");
        }
        txaFrivilligInfo.setText(info.toString());
    }

    private void updateSubmitButton() {
        btnSubmit.setDisable(frivillig == null || job == null);
    }
}
