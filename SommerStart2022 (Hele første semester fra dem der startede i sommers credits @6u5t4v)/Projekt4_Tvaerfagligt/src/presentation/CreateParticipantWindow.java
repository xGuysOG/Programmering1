package presentation;

import application.controller.Controller;
import application.model.Address;
import application.model.Participant;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateParticipantWindow extends Stage {

    private Participant participant;

    public CreateParticipantWindow(String title, Participant participant) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.participant = participant;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------


    private TextField txfName;
    private TextField txfAddress;
    private TextField txfCity;
    private TextField txfPhoneNumber;
    private TextField txfCompany;
    private TextField txfCompanyPhoneNumber;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblParticipant = new Label("Deltager Information");
        pane.add(lblParticipant, 0, 0, 2, 1);
        lblParticipant.setFont(Font.font(20));

        VBox hbName = new VBox();
        pane.add(hbName, 0, 1);
        Label lblName = new Label("Fulde navn:");
        txfName = new TextField();
        hbName.getChildren().addAll(lblName, txfName);

        VBox hbPhoneNumber = new VBox();
        pane.add(hbPhoneNumber, 1, 1);
        Label lblPhoneNumber = new Label("Telefon nr:");
        txfPhoneNumber = new TextField();
        hbPhoneNumber.getChildren().addAll(lblPhoneNumber, txfPhoneNumber);

        VBox hbAdress = new VBox();
        pane.add(hbAdress, 0, 2);
        Label lblAddress = new Label("Adresse:");
        txfAddress = new TextField();
        hbAdress.getChildren().addAll(lblAddress, txfAddress);

        VBox hbCompany = new VBox();
        pane.add(hbCompany, 1, 2);
        Label lblCompany = new Label("Firma:");
        txfCompany = new TextField();
        hbCompany.getChildren().addAll(lblCompany, txfCompany);

        VBox hbCity = new VBox();
        pane.add(hbCity, 0, 3);
        Label lblCity = new Label("By:");
        txfCity = new TextField();
        hbCity.getChildren().addAll(lblCity, txfCity);

        VBox hbCompanyPhoneNumber = new VBox();
        pane.add(hbCompanyPhoneNumber, 1, 3);
        Label lblCompanyPhoneNumber = new Label("Firma nr:");
        txfCompanyPhoneNumber = new TextField();
        hbCompanyPhoneNumber.getChildren().addAll(lblCompanyPhoneNumber, txfCompanyPhoneNumber);

        initFields();

        Button btnCancel = new Button("Annuller");
        pane.add(btnCancel, 1, 4);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(actionEvent -> this.hide());

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 1, 4);
        btnOpret.setOnAction(actionEvent -> createAction());
        GridPane.setHalignment(btnOpret, HPos.RIGHT);
//        GridPane.setMargin(btnOpret, new Insets(20, 0, 0, 0));
    }

    private void createAction() {
        // Gem alle tekst feldernes strenge i variable
        String name = txfName.getText().trim();
        String phoneNr = txfPhoneNumber.getText().trim();
        String company = txfCompany.getText().trim();
        String companyNr = txfCompanyPhoneNumber.getText().trim();
        String addressStr = txfAddress.getText().trim();
        String city = txfCity.getText().trim();

        // Returner en fejl hvis navn og nummer ikke er angivet
        if (name.isEmpty() || phoneNr.isEmpty()) {
            Alert empty = new Alert(Alert.AlertType.INFORMATION);
            empty.setTitle("Fejl");
            empty.setHeaderText("Mangler at udfylde fulde navn eller telefon nr");
            empty.show();
            return;
        }

        // Returner en fejl til brugeren hvis adresse og by ikke er angivet
        if (addressStr.isEmpty() || city.isEmpty()) {
            Alert empty2 = new Alert(Alert.AlertType.INFORMATION);
            empty2.setTitle("Fejl");
            empty2.setHeaderText("Mangler at udfylde adresse eller by");
            empty2.show();
            return;
        }

        // Opret adresse objekt, zip code bliver ikke brugt, så det er bare sat til 0
        Address address = Controller.createAddress(addressStr, city, "Danmark", 0);
        participant = Controller.createParticipant(name, phoneNr, address);

        // Hvis der er angivet et firma og firma nummer, så sættes dette på vores deltager,
        // da disse oplysninger er valgfri, og dermed ikke krævet til at lave en deltager objekt.
        if (!companyNr.isEmpty() && !companyNr.trim().isEmpty()) {
            participant.setCompany(company, companyNr);
        }

        hide();
    }

    private void initFields() {
        if (participant != null) {
            txfName.setText(participant.getName());
            txfAddress.setText(participant.getAddress().getRoad());
            txfCity.setText(participant.getAddress().getCity());
            txfPhoneNumber.setText(participant.getPhoneNr());
            txfCompany.setText(participant.getCompanyName());
            txfCompanyPhoneNumber.setText(participant.getCompanyNr());
        }
    }

    public Participant getParticipant() {
        return participant;
    }
}
