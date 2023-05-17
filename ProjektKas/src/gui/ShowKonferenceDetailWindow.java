package gui;

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
import model.Deltager;
import model.Konference;
import model.Ledsager;
import model.Udflugt;
import storage.Storage;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ShowKonferenceDetailWindow extends Stage {

    public ShowKonferenceDetailWindow(String title, Stage owner) {
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
        showUdflugterWindow = new ShowUdflugterWindow("Udflugt detail", owner);
        showDeltagerWindow = new ShowDeltagerWindow("Deltager detail", owner);
    }

    private boolean isEditing = false;

    private ShowUdflugterWindow showUdflugterWindow;
    private ShowDeltagerWindow showDeltagerWindow;
    private Konference konference;
    private final TextField txfName = new TextField();
    private final TextField txfLocation = new TextField();
    private final TextField txfStartDate = new TextField();
    private final TextField txfEndDate = new TextField();
    private final TextField txfPricePrDay = new TextField();

    private final ListView lvwudflugter = new ListView();
    private final ListView lvwdeltagere = new ListView();

    private final Label lblError = new Label("");
    private final Label lblText = new Label("Konference: ");
    private final Button btnEdit = new Button("Edit Mode");

    public void setCurrentKonference(Konference konference) {
        this.konference = konference;
    }

    @Override
    public void showAndWait() {
        // Run code before showing the separate window
        populateData();
        editable();
        super.showAndWait(); // Show the separate window
        // Run code after the separate window is closed
        // This code will execute when showAndWait() returns
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(lblText, 0, 0);
        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 5, 3, 1);

        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 1);
        pane.add(txfName, 1, 1);

        Label lblLocation = new Label("Location: ");
        pane.add(lblLocation, 0, 2);
        pane.add(txfLocation, 1, 2);

        Label lblStartDate = new Label("StartDate: ");
        pane.add(lblStartDate, 0, 3);
        pane.add(txfStartDate, 1, 3);

        Label lblEndDate = new Label("EndDate: ");
        pane.add(lblEndDate, 0, 4);
        pane.add(txfEndDate, 1, 4);

        pane.add(lvwudflugter, 2, 1, 2, 4);
        lvwudflugter.setPrefHeight(100);

        EventHandler<MouseEvent> udflugterClickHandler = onUdflugterDoubleClick(lvwudflugter);
        lvwudflugter.setOnMouseClicked(udflugterClickHandler);

        pane.add(lvwdeltagere, 4, 1, 2, 4);
        lvwdeltagere.setPrefHeight(100);

        EventHandler<MouseEvent> deltagereClickHandler = onDeltagereDoubleClick(lvwdeltagere);
        lvwdeltagere.setOnMouseClicked(deltagereClickHandler);

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 5, 5, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().add(btnEdit);
        btnEdit.setOnAction(event -> this.editButton());

        Button btnClose = new Button("Close");
        buttonBox.getChildren().add(btnClose);
        btnClose.setOnAction(event -> this.closeAction());
    }

    private EventHandler<MouseEvent> onUdflugterDoubleClick(ListView<Udflugt> udflugter) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    Udflugt udflugt = udflugter.getSelectionModel().getSelectedItem();
                    if (udflugt != null) {
                        showUdflugterWindow.setUdflugt(udflugt);
                        showUdflugterWindow.showAndWait();
                        populateData();
                    }
                }
            }
        };
    }

    private EventHandler<MouseEvent> onDeltagereDoubleClick(ListView<Deltager> deltagere) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    Deltager deltager = deltagere.getSelectionModel().getSelectedItem();
                    if (deltager != null) {
                        showDeltagerWindow.setDeltager(deltager);
                        showDeltagerWindow.showAndWait();
                        populateData();
                    }
                }
            }
        };
    }

    private void editButton() {
        if (isEditing) {
            isEditing = false;
        } else {
            isEditing = true;
        }
        editable();
    }

    private void closeAction() {
        txfEndDate.clear();
        txfLocation.clear();
        txfName.clear();
        txfStartDate.clear();
        txfPricePrDay.clear();
        lvwdeltagere.getItems().clear();
        lvwudflugter.getItems().clear();
        ShowKonferenceDetailWindow.this.hide();
    }

    private void editable() {
        if (isEditing) {
            btnEdit.setText("Read Mode");
            txfName.setEditable(true);
            txfName.setDisable(false);
            txfLocation.setEditable(true);
            txfLocation.setDisable(false);
            txfStartDate.setEditable(true);
            txfStartDate.setDisable(false);
            txfEndDate.setEditable(true);
            txfEndDate.setDisable(false);
            txfPricePrDay.setEditable(true);
            txfPricePrDay.setDisable(false);
        } else {
            btnEdit.setText("Edit Mode");
            txfName.setEditable(false);
            txfName.setDisable(true);

            txfLocation.setEditable(false);
            txfLocation.setDisable(true);


            txfStartDate.setEditable(false);
            txfStartDate.setDisable(true);

            txfEndDate.setEditable(false);
            txfEndDate.setDisable(true);

            txfPricePrDay.setEditable(false);
            txfPricePrDay.setDisable(true);
            saveData();
        }
    }

    private void saveData() {
        boolean hasBeenEdited = false;
        if (!txfName.getText().equals(konference.getName())) {
            konference.setName(txfName.getText());
            hasBeenEdited = true;
        }

        if (!txfLocation.getText().equals(konference.getLocation())) {
            konference.setLocation(txfLocation.getText());
            hasBeenEdited = true;
        }

        if (!txfStartDate.getText().equals(konference.getStartDate().toString())) {
            LocalDate startDate = LocalDate.now();
            try {
                startDate = LocalDate.parse(txfStartDate.getText());
            } catch (DateTimeParseException e) {
                lblError.setText("startDate is wrongly formatted");
                return;
            }
            if (!startDate.isBefore(konference.getEndDate())) {
                lblError.setText("StartDate has to be before enddate");
                return;
            }
            konference.setStartDate(startDate);
            hasBeenEdited = true;
        }

        if (!txfEndDate.getText().equals(konference.getEndDate().toString())) {
            LocalDate endDate = LocalDate.now();
            try {
                endDate = LocalDate.parse(txfEndDate.getText());
            } catch (DateTimeParseException e) {
                lblError.setText("endDate is wrongly formatted");
                return;
            }
            if (endDate.isBefore(konference.getStartDate())) {
                lblError.setText("enddate has to be before startDate");
                return;
            }
            konference.setEndDate(endDate);
            hasBeenEdited = true;
        }

        if (!txfPricePrDay.getText().equals(String.valueOf(konference.getPricePrDay()))) {
            double pricePrDay = 0;
            try {
                pricePrDay = Integer.parseInt(txfPricePrDay.getText());
            } catch (NumberFormatException e) {
                lblError.setText("pricePrDay is wrongly formatted");
                return;
            }
            konference.setPricePrDay(pricePrDay);
            hasBeenEdited = true;
        }
        if (hasBeenEdited) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Edit Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("You have made some edits.");
            alert.showAndWait();
        }
    }

    private void populateData() {
        lblText.setText(konference.getName());
        txfName.setText(konference.getName());
        txfLocation.setText(konference.getLocation());
        txfStartDate.setText(konference.getStartDate().toString());
        txfEndDate.setText(konference.getEndDate().toString());
        txfPricePrDay.setText(String.valueOf(konference.getPricePrDay()));
        lvwudflugter.getItems().setAll(konference.getUdflugter());
        lvwdeltagere.getItems().setAll(konference.getDeltagere());
    }
}