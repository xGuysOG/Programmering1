package gui;

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
import model.Deltagelse;
import model.DeltagerStatus;
import model.Fag;
import model.Lektion;
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
    private final ListView<Fag> lvwFag = new ListView<Fag>();
    private final ListView<Lektion> lvwLektion = new ListView<Lektion>();
    private final ListView<Deltagelse> lvwDeltagelse = new ListView<Deltagelse>();
    private final Label lblError = new Label("");
    private final Label lblFag = new Label("Fag");
    private final Label lblLektioner = new Label("Lektioner");
    private final Label lblDeltagelse = new Label("Deltagelse");
    private final Label lblFravær = new Label("Fraværsårsager");

    private final Button btnFravær = new Button("Fravær");

    private final ToggleGroup toggleGroup = new ToggleGroup();



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

        // Labels
        pane.add(lblFag, 0, 0);

        // Listview
        pane.add(lvwFag, 0, 1, 3, 5);
        lvwFag.setPrefHeight(200);
        lvwFag.setPrefWidth(300);
        lvwFag.getItems().setAll(Storage.getFagene());

        lvwFag.setOnMouseClicked(mouseEvent -> fagClicked(mouseEvent));

        // Hoteller listview
        pane.add(lblLektioner, 4, 0);
        pane.add(lvwLektion, 4, 1, 3, 5);
        lvwLektion.setPrefHeight(200);
        lvwLektion.setPrefWidth(300);
        lvwLektion.setOnMouseClicked(mouseEvent -> lektionClicked(mouseEvent));


        // Udflugter listview
        pane.add(lblDeltagelse, 8, 0);
        pane.add(lvwDeltagelse, 8, 1, 3, 5);
        lvwDeltagelse.setPrefHeight(200);
        lvwDeltagelse.setPrefWidth(300);

        pane.add(lblFravær, 11,0);
        RadioButton checkBox1 = new RadioButton (DeltagerStatus.TILSTEDE.toString());
        RadioButton checkBox2 = new RadioButton (DeltagerStatus.FRAVÆR.toString());
        RadioButton checkBox3 = new RadioButton (DeltagerStatus.SYG.toString());
        RadioButton checkBox4 = new RadioButton (DeltagerStatus.AFBUD.toString());


        // Create a toggle group
        checkBox1.setToggleGroup(toggleGroup);
        checkBox2.setToggleGroup(toggleGroup);
        checkBox3.setToggleGroup(toggleGroup);
        checkBox4.setToggleGroup(toggleGroup);

        // Create a vertical layout
        VBox vbox = new VBox(10); // 10 is the spacing between checkboxes
        vbox.setPadding(new Insets(10)); // Add padding around the layout
        vbox.getChildren().addAll(checkBox1, checkBox2, checkBox3, checkBox4);

        pane.add(vbox,11, 1);
        pane.add(btnFravær, 11,3);
        btnFravær.setOnAction(event -> this.setFravær());

        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 11, 3, 1);
    }

    private void setFravær(){
        if(lvwDeltagelse.getSelectionModel().isEmpty()){
            return;
        }
        Deltagelse deltagelse = lvwDeltagelse.getSelectionModel().getSelectedItem();
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();

        if (selectedRadioButton != null) {
            String selectedOption = selectedRadioButton.getText();
            // Execute code based on the selected option
            DeltagerStatus status = DeltagerStatus.valueOf(selectedOption);;
            deltagelse.registerFravær(status);
            lvwDeltagelse.refresh();
        } else {
            // No RadioButton selected
            System.out.println("No option selected");
        }

    }

    private void fagClicked(MouseEvent event) {
        System.out.println("Called");
        ListView<Fag> fagene = (ListView) event.getSource();
        if (fagene.getSelectionModel().isEmpty()){
            System.out.println("weird");
            return;
        }
        Fag faget = fagene.getSelectionModel().getSelectedItem();
        System.out.println("Faget clicked " + faget);
        if (faget != null) {
            lvwLektion.getItems().clear();
            lvwDeltagelse.getItems().clear();
            lvwLektion.getItems().addAll(faget.getLektioner());
        }
    }

    private void lektionClicked(MouseEvent event) {
        System.out.println("Called1");
        ListView<Lektion> lektioner = (ListView) event.getSource();
        if (lektioner.getSelectionModel().isEmpty()){
            System.out.println("weird1");
            return;
        }
        Lektion lektion = lektioner.getSelectionModel().getSelectedItem();
        System.out.println("Lektion clicked1 " + lektioner);
        if (lektion != null) {
            lvwDeltagelse.getItems().clear();
            lvwDeltagelse.getItems().addAll(lektion.getDeltagelser());
        }
    }
}
