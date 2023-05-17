package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Deltager;
import model.Konference;
import model.Ledsager;
import storage.Storage;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AddDeltagerWindow extends Stage {
    public AddDeltagerWindow(String title, Stage owner) {
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
        addDeltagerSecondStageWindow = new AddDeltagerSecondStageWindow("Finnish Add Deltager", owner);
    }

    private AddDeltagerSecondStageWindow addDeltagerSecondStageWindow;
    // Textfields

    private final TextField txfName = new TextField();
    private final TextField txfAddress = new TextField();
    private final TextField txfLocation = new TextField();
    private final TextField txfArrival = new TextField();
    private final TextField txfDeparture = new TextField();
    private final TextField txfPhone = new TextField();

    // Checkboxes
    private final CheckBox cbxCompany = new CheckBox();
    private final TextField txfCompanyName = new TextField();
    private final TextField txfCompanyPhone = new TextField();
    private final CheckBox cbxCompanion = new CheckBox();
    private final TextField txfCompanionName = new TextField();
    private final CheckBox cbxLecturer = new CheckBox();
    private final CheckBox cbxHotel = new CheckBox();

    private final Label lblError = new Label("");

    private Deltager deltager = null;
    private Konference konference;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Textfields & Labels added to pane
        lblError.setTextFill(Color.RED);
        pane.add(lblError, 0, 12, 3, 1);

        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 1);
        pane.add(txfName, 1, 1);

        Label lblAddress = new Label("Address: ");
        pane.add(lblAddress, 0, 2);
        pane.add(txfAddress, 1, 2);

        Label lblLocation = new Label("Location: ");
        pane.add(lblLocation, 0, 3);
        pane.add(txfLocation, 1, 3);

        Label lblArrival = new Label("Arrival: ");
        pane.add(lblArrival, 0, 4);
        pane.add(txfArrival, 1, 4);
        txfArrival.setPromptText("YYYY-MM-DD");

        Label lblDeparture = new Label("Departure: ");
        pane.add(lblDeparture, 0, 5);
        pane.add(txfDeparture, 1, 5);
        txfDeparture.setPromptText("YYYY-MM-DD");

        Label lblPhone = new Label("Phone: ");
        pane.add(lblPhone, 0, 6);
        pane.add(txfPhone, 1, 6);


        // Checkboxes & Labels added to pane
        pane.add(cbxCompany, 0, 7);
        cbxCompany.setText("Company");
        cbxCompany.setSelected(false);

        pane.add(cbxCompanion, 0, 9);
        cbxCompanion.setText("Companion");
        cbxCompanion.setSelected(false);

        pane.add(cbxLecturer, 0, 10);
        cbxLecturer.setText("Lecturer");
        cbxLecturer.setSelected(false);

        pane.add(cbxHotel, 0, 11);
        cbxHotel.setText("Hotel");
        cbxHotel.setSelected(false);

        // Popup labels og textfields
        Label lblCompanyName = new Label("Company name: ");
        pane.add(lblCompanyName, 1, 7);
        pane.add(txfCompanyName, 2, 7);
        lblCompanyName.visibleProperty().bind(cbxCompany.selectedProperty());
        txfCompanyName.visibleProperty().bind(cbxCompany.selectedProperty());

        Label lblCompanyPhone = new Label("Company phone: ");
        pane.add(lblCompanyPhone, 1, 8);
        pane.add(txfCompanyPhone, 2, 8);
        lblCompanyPhone.visibleProperty().bind(cbxCompany.selectedProperty());
        txfCompanyPhone.visibleProperty().bind(cbxCompany.selectedProperty());

        Label lblCompanionName = new Label("Companion name: ");
        pane.add(lblCompanionName, 1, 9);
        pane.add(txfCompanionName, 2, 9);
        lblCompanionName.visibleProperty().bind(cbxCompanion.selectedProperty());
        txfCompanionName.visibleProperty().bind(cbxCompanion.selectedProperty());


        // Buttons
        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 12, 3, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

    }

    public void setKonference(Konference konference) {
        this.konference = konference;
    }

    private void okAction() {
        String name = txfName.getText().trim();
        String address = txfAddress.getText().trim();
        String location = txfLocation.getText().trim();
        String arrival = txfArrival.getText().trim();
        String departure = txfDeparture.getText().trim();

        LocalDate arrivalDate = LocalDate.now();
        LocalDate departureDate = LocalDate.now();
        String phoneString = txfPhone.getText().trim();
        int phone = 0;

        boolean hasCompany = cbxCompany.isSelected();
        boolean hasCompanion = cbxCompanion.isSelected();
        boolean isLecturer = cbxLecturer.isSelected();
        boolean hasHotel = cbxHotel.isSelected();

        String companyName = txfCompanyName.getText().trim();
        String companyPhone = txfCompanyPhone.getText().trim();
        String companionName = txfCompanionName.getText().trim();


        try {
            if (name.isEmpty()) {
                lblError.setText("Name is required");
            } else if (address.isEmpty()) {
                lblError.setText("Address is required");
            } else if (location.isEmpty()) {
                lblError.setText("Location is required");
            } else if (arrival.isEmpty()) {
                lblError.setText("Arrival date is required");
            } else if (departure.isEmpty()) {
                lblError.setText("Departure date is required");
            } else {
                phone = Integer.parseInt(phoneString);
                if (phone < 0) {
                    lblError.setText("Phone number cannot be negative");
                } else {
                    lblError.setText("");
                }
            }
            arrivalDate = LocalDate.parse(arrival);
            departureDate = LocalDate.parse(departure);
            System.out.println(arrivalDate.toString());
            System.out.println(departure.toString());
            if (arrivalDate.isAfter(departureDate)) {
                lblError.setText("Arrival cannot be after departure");
                return;
            }
        } catch (NumberFormatException ex) {
            lblError.setText("Phone number is not an integer");
            return;
        } catch (DateTimeParseException e) {
            lblError.setText("Date is invalid");
            return;
        }
        if (!canBook(arrivalDate, departureDate)) {
            lblError.setText("Selected arrivalDate and depaatureDate is not within konference date");
            return;
        }
        if (name.length() > 0 && address.length() > 0 && location.length() > 0) {
            deltager = Controller.createDeltager(name, address, location, arrivalDate, departureDate, phoneString, konference, hasCompanion, hasCompany, isLecturer, companyName, companyPhone);
            if (hasCompanion) {
                Ledsager ledsager = Controller.createLedsager(companionName, deltager);
            }
            txfName.clear();
            txfName.requestFocus();
            txfAddress.clear();
            txfLocation.clear();
            txfArrival.clear();
            txfDeparture.clear();
            txfCompanionName.clear();
            txfCompanyPhone.clear();
            txfCompanyName.clear();
            cbxCompany.setSelected(false);
            cbxHotel.setSelected(false);
            cbxLecturer.setSelected(false);
            cbxCompanion.setSelected(false);
            txfPhone.clear();
            lblError.setText("");
            addDeltagerSecondStageWindow.setGeneration(hasCompanion, hasHotel, deltager, konference);
            addDeltagerSecondStageWindow.showAndWait();
            AddDeltagerWindow.this.hide();
        }
    }

    public boolean canBook(LocalDate arrivalDate, LocalDate departureDate) {
        LocalDate minDate = konference.getStartDate();
        LocalDate maxDate = konference.getEndDate();

        return !(arrivalDate.isBefore(minDate) || departureDate.isAfter(maxDate));
    }

    private void cancelAction() {
        txfName.clear();
        txfName.requestFocus();
        txfAddress.clear();
        txfLocation.clear();
        txfArrival.clear();
        txfDeparture.clear();
        txfCompanionName.clear();
        txfCompanyPhone.clear();
        txfCompanyName.clear();
        cbxCompany.setSelected(false);
        cbxHotel.setSelected(false);
        cbxLecturer.setSelected(false);
        cbxCompanion.setSelected(false);
        AddDeltagerWindow.this.hide();
    }

}

