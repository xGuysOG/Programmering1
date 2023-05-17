package gui;

import controller.Controller;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
import storage.Storage;

public class AddDeltagerSecondStageWindow extends Stage {

    public AddDeltagerSecondStageWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public void setGeneration(boolean setLedsager, boolean setHotel, Deltager deltager, Konference konference) {
        this.setLedsager = setLedsager;
        this.setHotel = setHotel;
        this.deltager = deltager;
        this.konference = konference;
    }

    private Deltager deltager;
    private Konference konference;

    private boolean setHotel;
    private boolean setLedsager;
    private final ListView lvwHotel = new ListView();
    private final ListView lvwUdflugt = new ListView<Udflugt>();

    private final ListView lvwServices = new ListView();

    private final Label lblError = new Label("");

    private boolean firstClick = false;

    private final Label lblHotel = new Label("Choose hotel:");

    private final Label lblUdflugt = new Label("Choose Udflugt:");

    @Override
    public void showAndWait() {
        // Run code before showing the separate window
        populateData();
        super.showAndWait(); // Show the separate window
        // Run code after the separate window is closed
        // This code will execute when showAndWait() returns
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        //pane.setGridLinesVisible(true);

        // Labels
        pane.add(lblHotel, 0, 0);
        lblHotel.setVisible(false);

        pane.add(lblUdflugt, 3, 0);
        lblUdflugt.setVisible(false);

        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 5, 3, 1);

        // Textfields & Labels added to pane
        pane.add(lvwHotel, 0, 2);
        lvwHotel.setPrefHeight(100);
        lvwHotel.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //lvwHotel.setPrefWidth(100);
        EventHandler<MouseEvent> deltagereClickHandler = onHotelClick(lvwHotel);
        lvwHotel.setOnMouseClicked(deltagereClickHandler);
        lvwHotel.setVisible(false);

        pane.add(lvwUdflugt, 3, 2);
        lvwUdflugt.setPrefHeight(100);
        lvwUdflugt.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvwUdflugt.setVisible(false);


        pane.add(lvwServices, 0, 3);
        lvwServices.setPrefHeight(100);
        lvwServices.setVisible(false);
        lvwServices.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //lvwUdflugt.setPrefWidth(100);


        // Buttons


        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 5, 5, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());
    }

    private EventHandler<MouseEvent> onHotelClick(ListView<Hotel> hotels) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Hotel hotel = hotels.getSelectionModel().getSelectedItem();
                if (hotel != null) {
                    lvwServices.setVisible(true);
                    lvwServices.getItems().setAll(hotel.getServices());
                }
            }
        };
    }




    private void okAction() {
        if (setLedsager) {
            if (!firstClick && lvwUdflugt.getSelectionModel().isEmpty()) {
                firstClick = true;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Didnt select udflugt");
                alert.setHeaderText(null);
                alert.setContentText("You have not selected a udflugt, are you sure?");
                alert.showAndWait();
                return;
            }
            if (!lvwUdflugt.getSelectionModel().isEmpty()) {
                for(Object selectedItem : lvwUdflugt.getSelectionModel().getSelectedItems()){
                    if (selectedItem instanceof Udflugt) {
                        Udflugt udflugt = (Udflugt) selectedItem;
                        deltager.getLedsager().setUdflugt(udflugt);
                    }
                }
            }
        }

        if (setHotel) {
            if (lvwHotel.getSelectionModel().isEmpty()){
                lblError.setText("You have to choose a hotel");
                return;
            }
                //then we check services
                Hotel hotel = (Hotel) lvwHotel.getSelectionModel().getSelectedItem();
                if (hotel == null) {
                }
                HotelValg hotelValg = Controller.createHotelValg(hotel, deltager);
                if (!lvwServices.getSelectionModel().isEmpty()) {
                    for(Object selectedItem : lvwServices.getSelectionModel().getSelectedItems()){
                        if (selectedItem instanceof Service) {
                            Service service = (Service) selectedItem;
                            hotelValg.addService(service);
                        }
               }
            }

        }
        clearData();
        AddDeltagerSecondStageWindow.this.hide();
    }

    private void cancelAction(){
        clearData();
    }

    private void clearData(){
        lvwServices.setVisible(false);
        lvwUdflugt.setVisible(false);
        lvwHotel.setVisible(false);
        lblUdflugt.setVisible(false);
        lblHotel.setVisible(false);
        lvwUdflugt.getItems().clear();
        lvwHotel.getItems().clear();
        lvwServices.getItems().clear();
    }

    private void populateData() {
        if (setHotel) {
            lvwHotel.setVisible(true);
            lblHotel.setVisible(true);
            lvwHotel.getItems().addAll(Storage.getHotels());
        }
        if (setLedsager){
            lvwUdflugt.setVisible(true);
            lblUdflugt.setVisible(true);
            lvwUdflugt.getItems().addAll(konference.getUdflugter());
        }

    }
}