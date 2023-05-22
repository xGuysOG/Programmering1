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
import model.Ledsager;
import model.Udflugt;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ShowDeltagerWindow extends Stage {

    public ShowDeltagerWindow(String title, Stage owner) {
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
        showLedsagerWindow = new ShowLedsagerWindow("Ledsager detail", owner);
    }

    private boolean isEditing = false;
    private Deltager deltager;
    private final TextField txfName = new TextField();
    private final TextField txfAddress = new TextField();
    private final TextField txfLocation = new TextField();
    private final TextField txfArrivalDate = new TextField();
    private final TextField txfLeaveDate = new TextField();
    private final TextField txfPhoneNumber = new TextField();
    private final CheckBox cbxHasLedsager = new CheckBox();
    private final Label lblLedsager = new Label();
    private final CheckBox cbxIsForedrasHolder = new CheckBox();
    private final Label lblKonference = new Label();
    private final CheckBox cbxHasCompany = new CheckBox();
    private final TextField txfCompanyName = new TextField();
    private final TextField txfCompanyPhone = new TextField();
    private final Label lblHotelValg = new Label();

    private final ListView<Ledsager> lvwLedsager = new ListView<>();
    private final Label lblError = new Label("");
    private final Label lblText = new Label("Udflugt: ");
    private final Button btnEdit = new Button("Edit Mode");

    private ShowLedsagerWindow showLedsagerWindow;
    //private final TextField txfPrice = new TextField();

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
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
        pane.add(lblError, 0, 17, 3, 1);

        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 1);
        pane.add(txfName, 1, 1);

        Label lblAddress = new Label("Address: ");
        pane.add(lblAddress, 0, 2);
        pane.add(txfAddress, 1, 2);

        Label lblLocation = new Label("Location: ");
        pane.add(lblLocation, 0, 3);
        pane.add(txfLocation, 1, 3);

        Label lblArrivalDate = new Label("ArrivalDate: ");
        pane.add(lblArrivalDate, 0, 4);
        pane.add(txfArrivalDate, 1, 4);

        Label lblLeaveDate = new Label("LeaveDate: ");
        pane.add(lblLeaveDate, 0, 5);
        pane.add(txfLeaveDate, 1, 5);

        Label lblPhoneNumber = new Label("PhoneNumber: ");
        pane.add(lblPhoneNumber, 0, 6);
        pane.add(txfPhoneNumber, 1, 6);

        Label lblHasLedsager = new Label("HasLedsager: ");
        pane.add(lblHasLedsager, 0, 7);
        pane.add(cbxHasLedsager, 1, 7);

        Label lblLedsagerText = new Label("Ledsager: ");
        pane.add(lblLedsagerText, 0, 8);
        pane.add(lblLedsager, 1, 8);

        Label lblIsForedragsholder = new Label("IsForedragsholder: ");
        pane.add(lblIsForedragsholder, 0, 9);
        pane.add(cbxIsForedrasHolder, 1, 9);

        Label lblKonferenceText = new Label("Konference: ");
        pane.add(lblKonferenceText, 0, 10);
        pane.add(lblKonference, 1, 10);

        Label lblHasCompany = new Label("HasCompany: ");
        pane.add(lblHasCompany, 0, 11);
        pane.add(cbxHasCompany, 1, 11);

        Label lblCompanyName = new Label("CompanyName: ");
        pane.add(lblCompanyName, 0, 12);
        pane.add(txfCompanyName, 1, 12);

        Label lblCompanyPhone = new Label("CompanyPhone: ");
        pane.add(lblCompanyPhone, 0, 13);
        pane.add(txfCompanyPhone, 1, 13);

        Label lblHotelValgText = new Label("HotelValg: ");
        pane.add(lblHotelValgText, 0, 14);
        pane.add(lblHotelValg, 1, 14);


        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 15, 5, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().add(btnEdit);
        btnEdit.setOnAction(event -> this.editButton());

        Button btnClose = new Button("Close");
        buttonBox.getChildren().add(btnClose);

        btnClose.setOnAction(event -> this.closeAction());

        EventHandler<MouseEvent> ledsagerClickHandler = onLedsagerDoubleClick(lvwLedsager);
        lvwLedsager.setOnMouseClicked(ledsagerClickHandler);
    }

    private EventHandler<MouseEvent> onLedsagerDoubleClick(ListView<Ledsager> ledsagerer) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    Ledsager ledsager = ledsagerer.getSelectionModel().getSelectedItem();
                    if (ledsager != null) {
                        showLedsagerWindow.setLedsager(ledsager);
                        showLedsagerWindow.showAndWait();
                        populateData();
                    }
                }
            }
        };
    }

    private void closeAction() {
        txfName.clear();
        lblKonference.setText("");
        lvwLedsager.getItems().clear();
        ShowDeltagerWindow.this.hide();
    }

    private void editButton() {
        if (isEditing) {
            isEditing = false;
        } else {
            isEditing = true;
        }
        editable();
    }

    private void editable() {
        if (isEditing) {
            btnEdit.setText("Read Mode");
            txfName.setEditable(true);
            txfName.setDisable(false);

            txfAddress.setEditable(true);
            txfAddress.setDisable(false);

            txfLocation.setEditable(true);
            txfLocation.setDisable(false);

            txfArrivalDate.setEditable(true);
            txfArrivalDate.setDisable(false);

            txfLeaveDate.setEditable(true);
            txfLeaveDate.setDisable(false);

            txfPhoneNumber.setEditable(true);
            txfPhoneNumber.setDisable(false);

            cbxHasLedsager.setDisable(false);

            cbxIsForedrasHolder.setDisable(false);

            cbxHasCompany.setDisable(false);

            txfCompanyName.setEditable(true);
            txfCompanyName.setDisable(false);

            txfCompanyPhone.setEditable(true);
            txfCompanyPhone.setDisable(false);

        } else {
            btnEdit.setText("Edit Mode");
            txfName.setEditable(false);
            txfName.setDisable(true);

            txfAddress.setEditable(false);
            txfAddress.setDisable(true);

            txfLocation.setEditable(false);
            txfLocation.setDisable(true);

            txfArrivalDate.setEditable(false);
            txfArrivalDate.setDisable(true);

            txfLeaveDate.setEditable(false);
            txfLeaveDate.setDisable(true);

            txfPhoneNumber.setEditable(false);
            txfPhoneNumber.setDisable(true);

            cbxHasLedsager.setDisable(true);

            cbxIsForedrasHolder.setDisable(true);

            cbxHasCompany.setDisable(true);

            txfCompanyName.setEditable(false);
            txfCompanyName.setDisable(true);

            txfCompanyPhone.setEditable(false);
            txfCompanyPhone.setDisable(true);
            saveData();
        }
    }

    private void saveData() {
        boolean hasBeenEdited = false;
        if (!txfName.getText().equals(deltager.getName())) {
            deltager.setName(txfName.getText());
            hasBeenEdited = true;
        }

        if (!txfAddress.getText().equals(deltager.getAddress())) {
            deltager.setAddress(txfAddress.getText());
            hasBeenEdited = true;
        }

        if (!txfLocation.getText().equals(deltager.getLocation())) {
            deltager.setLocation(txfLocation.getText());
            hasBeenEdited = true;
        }


        if (!txfArrivalDate.getText().equals(deltager.getArrivalDate().toString())) {
            LocalDate arrivalDate = LocalDate.now();
            try {
                arrivalDate = LocalDate.parse(txfArrivalDate.getText());
            } catch (DateTimeParseException e) {
                lblError.setText("arrivalDate is wrongly formatted");
                return;
            }
            if (!arrivalDate.isBefore(deltager.getLeaveDate())) {
                lblError.setText("arrivalDate has to be before leaveDate");
                return;
            }
            deltager.setArrivalDate(arrivalDate);
            hasBeenEdited = true;
        }
        if (!txfLeaveDate.getText().equals(deltager.getLeaveDate().toString())) {
            LocalDate leaveDate = LocalDate.now();
            try {
                leaveDate = LocalDate.parse(txfLeaveDate.getText());
            } catch (DateTimeParseException e) {
                lblError.setText("leaveDate is wrongly formatted");
                return;
            }
            if (leaveDate.isBefore(deltager.getArrivalDate())) {
                lblError.setText("leaveDate has to be after arrivalDate");
                return;
            }
            deltager.setLeaveDate(leaveDate);
            hasBeenEdited = true;
        }
        if (!txfPhoneNumber.getText().equals(deltager.getPhoneNumber())) {
            deltager.setPhoneNumber(txfPhoneNumber.getText());
            hasBeenEdited = true;
        }
        if (cbxHasLedsager.isSelected() != deltager.hasLedsager()) {
            deltager.setHasLedsager(cbxHasLedsager.isSelected());
            if (!deltager.hasLedsager()) {
                deltager.setLedsager(null);
            }
            hasBeenEdited = true;
        }
        if (cbxIsForedrasHolder.isSelected() != deltager.isForedragsholder()) {
            deltager.setForedragsholder(cbxIsForedrasHolder.isSelected());
            hasBeenEdited = true;
        }

        if (cbxHasCompany.isSelected() != deltager.hasCompany()) {
            deltager.setHasCompany(cbxHasCompany.isSelected());
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
        lblText.setText(deltager.getName());
        txfName.setText(deltager.getName());
        txfAddress.setText(deltager.getAddress());
        txfLocation.setText(deltager.getLocation());
        txfArrivalDate.setText(deltager.getArrivalDate().toString());
        txfLeaveDate.setText(deltager.getLeaveDate().toString());
        txfPhoneNumber.setText(deltager.getPhoneNumber());
        cbxHasLedsager.setSelected(deltager.hasLedsager());
        if (deltager.hasLedsager()) {
            lblLedsager.setText(deltager.getLedsager().getName());
        } else {
            lblLedsager.setText("No Ledsager");
        }
        cbxIsForedrasHolder.setSelected(deltager.isForedragsholder());
        lblKonference.setText(deltager.getKonference().getName());
        cbxHasCompany.setSelected(deltager.hasCompany());
        txfCompanyName.setText(deltager.getCompanyName());
        txfCompanyPhone.setText(deltager.getCompanyPhone());
        if (deltager.hasHotel()) {
            lblHotelValg.setText(deltager.getHotelValg().getHotel().getName());
        } else {
            lblHotelValg.setText("No hotel chosen");
        }
    }
}
