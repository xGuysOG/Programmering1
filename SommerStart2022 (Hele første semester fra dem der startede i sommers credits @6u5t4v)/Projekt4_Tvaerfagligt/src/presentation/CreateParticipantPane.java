package presentation;

import application.controller.Controller;
import application.model.Address;
import application.model.Participant;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class CreateParticipantPane extends GridPane {
    private final TabPane tabPane;

    private final TextField txfName, txfAddress, txfCity, txfPhoneNumber, txfCompany, txfCompanyPhoneNumber;

    public CreateParticipantPane(TabPane tabPane) {
        this.tabPane = tabPane;

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblParticipant = new Label("Deltager Information");
        this.add(lblParticipant, 0, 0, 2, 1);
        lblParticipant.setFont(Font.font(20));

        VBox hbName = new VBox();
        this.add(hbName, 0, 1);
        Label lblName = new Label("Fulde navn:");
        txfName = new TextField();
        hbName.getChildren().addAll(lblName, txfName);

        VBox hbPhoneNumber = new VBox();
        this.add(hbPhoneNumber, 1, 1);
        Label lblPhoneNumber = new Label("Telefon nr:");
        txfPhoneNumber = new TextField();
        hbPhoneNumber.getChildren().addAll(lblPhoneNumber, txfPhoneNumber);

        VBox hbAdress = new VBox();
        this.add(hbAdress, 0, 2);
        Label lblAddress = new Label("Adresse:");
        txfAddress = new TextField();
        hbAdress.getChildren().addAll(lblAddress, txfAddress);

        VBox hbCompany = new VBox();
        this.add(hbCompany, 1, 2);
        Label lblCompany = new Label("Firma:");
        txfCompany = new TextField();
        hbCompany.getChildren().addAll(lblCompany, txfCompany);

        VBox hbCity = new VBox();
        this.add(hbCity, 0, 3);
        Label lblCity = new Label("By:");
        txfCity = new TextField();
        hbCity.getChildren().addAll(lblCity, txfCity);

        VBox hbCompanyPhoneNumber = new VBox();
        this.add(hbCompanyPhoneNumber, 1, 3);
        Label lblCompanyPhoneNumber = new Label("Firma nr:");
        txfCompanyPhoneNumber = new TextField();
        hbCompanyPhoneNumber.getChildren().addAll(lblCompanyPhoneNumber, txfCompanyPhoneNumber);

        Button btnOpret = new Button("Opret");
        this.add(btnOpret, 1, 4);
        btnOpret.setOnAction(actionEvent -> createAction());
        GridPane.setHalignment(btnOpret, HPos.RIGHT);
        GridPane.setMargin(btnOpret, new Insets(20, 0, 0, 0));
    }


    // -------------------------------------------------------------------------

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
        Participant participant = Controller.createParticipant(name, phoneNr, address);

        // Hvis der er angivet et firma og firma nummer, så sættes dette på vores deltager,
        // da disse oplysninger er valgfri, og dermed ikke krævet til at lave en deltager objekt.
        if (!companyNr.isEmpty() && !companyNr.trim().isEmpty()) {
            participant.setCompany(company, companyNr);
        }

//        // Enable tilmelding tab i vinduet
//        tabPane.getTabs().get(1).setDisable(false);
//        // Lav en ny instance af tilmeldings tab.
//        SignupPane signupPane = new SignupPane(participant, tabPane);
//        tabPane.getTabs().get(1).setContent(signupPane);
    }
}
