package gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Hotel;
import model.Konference;
import model.Ledsager;
import model.Udflugt;
import storage.Storage;


public class Gui extends Application {
    public void start(Stage stage) {
        stage.setTitle("Konferencer");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        konferenceWindow = new AddKonferenceWindow("Add konference", stage);
        udflugtWindow = new AddUdflugtWindow("Add udflugt", stage);
        hotelWindow = new AddHotelWindow("Add hotel", stage);
        deltagerWindow = new AddDeltagerWindow("Add deltager", stage);
        showKonferenceDetailWindow = new ShowKonferenceDetailWindow("Konference detail", stage);
        showHotelDetailWindow = new ShowHotelDetailWindow("Hotel detail",stage);
//        addDeltagerSecondStageWindow.setGeneration(true, true, Storage.getKonferencer().get(0).getDeltagere().get(2), Storage.getKonferencer().get(0));
//        addDeltagerSecondStageWindow.showAndWait();

    }
    // -----------------------------------------------------------
    private final ListView<Konference> lvwKonferencer = new ListView<>();
    private final ListView<Hotel> lvwHoteller = new ListView<Hotel>();
    private final TextArea udflugtArea = new TextArea();
    private AddKonferenceWindow konferenceWindow;
    private AddUdflugtWindow udflugtWindow;
    private AddHotelWindow hotelWindow;
    private AddDeltagerWindow deltagerWindow;
    private ShowKonferenceDetailWindow showKonferenceDetailWindow;
    private ShowHotelDetailWindow showHotelDetailWindow;
    private ShowUdflugterWindow showUdflugterWindow;
    private ShowTilmeldingerWindow showTilmeldingerWindow;
    private AddDeltagerSecondStageWindow addDeltagerSecondStageWindow;
    private final Label lblError = new Label("");
    private final Label lblHoteller = new Label("Hoteller: ");
    private final Label lblUdflugter = new Label("Udflugter");



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
        Label lblKonferenceListe = new Label("Konference liste:");
        pane.add(lblKonferenceListe, 0, 0);

        // Listview
        pane.add(lvwKonferencer, 0, 1, 3, 5);
        lvwKonferencer.setPrefHeight(200);
        lvwKonferencer.setPrefWidth(300);
        lvwKonferencer.getItems().setAll(Storage.getKonferencer());

        EventHandler<MouseEvent> doubleClickHandler = onKonferenceDoubleClick(lvwKonferencer);
        lvwKonferencer.setOnMouseClicked(doubleClickHandler);

        // Hoteller listview
        pane.add(lblHoteller, 4, 0);
        pane.add(lvwHoteller, 4, 1, 3, 5);
        lvwHoteller.setPrefHeight(200);
        lvwHoteller.setPrefWidth(550);
        lvwHoteller.getItems().setAll(Storage.getHotels());


        // Udflugter listview
        pane.add(lblUdflugter, 8, 0);
        pane.add(udflugtArea, 8, 1, 3, 5);
        udflugtArea.setPrefHeight(200);
        udflugtArea.setPrefWidth(300);
        udflugtArea.setEditable(false);
        populateUdflugter();

        EventHandler<MouseEvent> doubleClickHandlerHotel = onHotellerDoubleClick(lvwHoteller);
        lvwHoteller.setOnMouseClicked(doubleClickHandlerHotel);

        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 11, 3, 1);


        // Buttons
        HBox buttonBox = new HBox(25);
        pane.add(buttonBox, 0, 6, 3, 3);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnAddUdflugt = new Button("Add Udflugt");
        buttonBox.getChildren().add(btnAddUdflugt);
        btnAddUdflugt.setOnAction(event -> this.addUdflugtAction());
        // -------------------
        Button btnAddHotel = new Button("Add Hotel");
        buttonBox.getChildren().add(btnAddHotel);
        btnAddHotel.setOnAction(event -> this.addHotelAction());
        //--------------------
        Button btnAddKonference = new Button("Add Konference");
        buttonBox.getChildren().add(btnAddKonference);
        btnAddKonference.setOnAction(event -> this.addKonferenceAction());
        //--------------------
        Button btnAddDeltager = new Button("Add Deltager");
        buttonBox.getChildren().add(btnAddDeltager);
        btnAddDeltager.setOnAction(event -> this.addDeltagerAction());
        // Sidebuttons

        VBox sideButtonBox = new VBox(25);
        sideButtonBox.setAlignment(Pos.CENTER);
        pane.add(sideButtonBox, 3, 1, 3, 3);

    }
    private void populateUdflugter(){
        String spaces = "     ";
        for(Udflugt udflugt : Storage.getUdflugter()){
            udflugtArea.appendText(udflugt.getName() + "\n");
            for(Ledsager ledsager : udflugt.getDeltagere()){
                udflugtArea.appendText(spaces + ledsager.toString() + "\n");
            }
        }
    }

    private EventHandler<MouseEvent> onKonferenceDoubleClick(ListView<Konference> konferencer) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    Konference konference = konferencer.getSelectionModel().getSelectedItem();
                    if (konference != null) {
                        showKonferenceDetailWindow.setCurrentKonference(konference);
                        showKonferenceDetailWindow.showAndWait();
                    }
                }
            }
        };
    }

    private EventHandler<MouseEvent> onHotellerDoubleClick(ListView<Hotel> hoteller) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    Hotel hotel = hoteller.getSelectionModel().getSelectedItem();
                    if (hotel != null) {
                        showHotelDetailWindow.setCurrentHotel(hotel);
                        showHotelDetailWindow.showAndWait();
                    }
                }
            }
        };
    }

    private void addUdflugtAction() {
        udflugtWindow.showAndWait();
    }

    private void addHotelAction() {
        hotelWindow.showAndWait();
        updateHotelList();
    }
    private void updateHotelList() {
        lvwHoteller.getItems().clear();
        lvwHoteller.getItems().setAll(Storage.getHotels());
    }

    private void updateKonferenceList() {
        lvwKonferencer.getItems().clear();
        lvwKonferencer.getItems().setAll(Storage.getKonferencer());
    }

    private void addKonferenceAction() {
        konferenceWindow.showAndWait();
        updateKonferenceList();
    }

    private void addDeltagerAction() {
        if (lvwKonferencer.getSelectionModel().isEmpty()) {
            lblError.setText("You need to select a konference");
            return;
        }
        Konference selectedKonference = (Konference) lvwKonferencer.getSelectionModel().getSelectedItem();
        deltagerWindow.setKonference(selectedKonference);
        deltagerWindow.showAndWait();
        lblError.setText("");
    }
}
