package opg2.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import opg2.controller.Controller;
import opg2.model.Seat;
import opg2.model.Zone;

import java.util.ArrayList;

public class Gui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Netcafe Adminstration");
        GridPane pane = new GridPane();
        Controller.initStorage();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private ToggleGroup group = new ToggleGroup();
    private ArrayList<Seat> seatsList = new ArrayList<>();
    private ListView<Seat> lvwSeats = new ListView<>();
    private TextField txfNumber = new TextField();
    private Button btnCreate = new Button("Opret");


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        Label lblSeats = new Label("Pladser:");
        pane.add(lblSeats, 0, 0, 2, 1);

        pane.add(lvwSeats, 0, 1, 2, 1);

        Label lblZone = new Label("Område:");
        pane.add(lblZone, 0, 2, 2, 1);

        HBox rBBox = new HBox();
        rBBox.setSpacing(10);
        pane.add(rBBox, 0, 3, 2, 1);

        lvwSeats.getItems().setAll(Controller.getSeats());

        RadioButton btnStandard = new RadioButton("Standard");
        rBBox.getChildren().add(btnStandard);
        btnStandard.setUserData(Zone.STANDARD);
        btnStandard.setToggleGroup(group);
        btnStandard.setOnAction(event -> setListAction());
//        btnStandard.setSelected(true);

        RadioButton btnVip = new RadioButton("VIP");
        rBBox.getChildren().add(btnVip);
        btnVip.setUserData(Zone.VIP);
        btnVip.setToggleGroup(group);
        btnVip.setOnAction(event -> setListAction());

        RadioButton btnKids = new RadioButton("Børn");
        rBBox.getChildren().add(btnKids);
        btnKids.setUserData(Zone.KIDS);
        btnKids.setToggleGroup(group);
        btnKids.setOnAction(event -> setListAction());

        RadioButton btnTournament = new RadioButton("Turnering");
        rBBox.getChildren().add(btnTournament);
        btnTournament.setUserData(Zone.TOURNAMENT);
        btnTournament.setToggleGroup(group);
        btnTournament.setOnAction(event -> setListAction());

        Label lblNumber = new Label("Nummer:");
        pane.add(lblNumber, 0, 4);
        txfNumber.setDisable(true);
        pane.add(txfNumber, 1, 4);

        pane.add(btnCreate, 0, 5);
        btnCreate.setOnAction(event -> createSeat());
    }

    private void setListAction() {
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        Zone zone = (Zone) rb.getUserData();

        lvwSeats.getItems().setAll(Controller.getSeats(zone));
        txfNumber.setDisable(false);
    }

    private void createSeat() {
        String input = txfNumber.getText().trim();
        if (!input.isEmpty()) {
            int number;
            try {
                number = Integer.parseInt(input);

                if (Controller.seatExists(number)) {
                    System.out.println("exists");
                    return;
                }

            } catch (NumberFormatException e) {
                return;
            }

            RadioButton rb = (RadioButton) group.getSelectedToggle();
            Zone zone = (Zone) rb.getUserData();

            System.out.println("test");

            Controller.createSeat(number, zone);
            setListAction();
        }
    }
}
