package presentation;

import application.controller.Controller;
import application.model.Conference;
import application.model.Participant;
import application.model.Registration;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SignupPane extends GridPane {

    private TabPane tabPane;

    private Registration registration;
    private Participant participant;
    private Conference conference;


    private ListView<Conference> lvwConferences = new ListView<>();
    private DatePicker arrivalDate, departureDate;
    private TextArea txaDescription;
    private CheckBox cbLecture;


    public SignupPane(TabPane tabPane) {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.tabPane = tabPane;

        // <konferencer>
        Label lblConference = new Label("Konferencer");
        lblConference.setFont(Font.font(20));
        this.add(lblConference, 0, 0);
        this.add(lvwConferences, 0, 1);

        lvwConferences.setPrefWidth(200);
        lvwConferences.getItems().setAll(Controller.getConferences());
        lvwConferences.getSelectionModel().selectFirst();
        conference = lvwConferences.getSelectionModel().getSelectedItem();

        ChangeListener<Conference> listener = (ov, oldConference, newConference) -> this.selectedConferenceChanged(newConference);
        lvwConferences.getSelectionModel().selectedItemProperty().addListener(listener);
        // </konferencer>

        Label lblInformation = new Label("Informationer");
        lblInformation.setFont(Font.font(20));
        this.add(lblInformation, 1, 0);

        GridPane infoBox = new GridPane();
        infoBox.setVgap(15);
        this.add(infoBox, 1, 1);

        // <dato>
        GridPane dateSelectPane = new GridPane();
        infoBox.add(dateSelectPane, 0, 0, 2, 1);

        Label lblDate = new Label("Ankomst Dato");
        dateSelectPane.add(lblDate, 0, 0);

        arrivalDate = new DatePicker(conference.getStartDate());
        arrivalDate.setOnAction(event -> update());
        arrivalDate.setPrefWidth(120);
        dateSelectPane.add(arrivalDate, 0, 1);
        dateSelectPane.setHgap(10);

        lblDate = new Label("Afrejse Dato");
        dateSelectPane.add(lblDate, 1, 0);

        departureDate = new DatePicker(conference.getEndDate());
        departureDate.setOnAction(event -> update());
        departureDate.setPrefWidth(120);
        dateSelectPane.add(departureDate, 1, 1);
        // </dato>

        // <deltager>
        Label lblParticipant = new Label("Opret Deltager");
        lblParticipant.setFont(Font.font(15));
        infoBox.add(lblParticipant, 0, 1);

        Button btnParticipant = new Button("Opret");
        infoBox.add(btnParticipant, 1, 1);
        btnParticipant.setOnAction(event -> createParticipantAction());
        // </deltager>

        // <ledsager>
        Label lblLedsager = new Label("Ledsager:");
        lblLedsager.setFont(Font.font(15));

        infoBox.add(lblLedsager, 0, 2);
        Button btnLedsager = new Button("Tilmeld");
        infoBox.add(btnLedsager, 1, 2);
        // </ledsager>


        // <hotel>
        Label lblHotel = new Label("Overnatnings:");
        lblHotel.setFont(Font.font(15));

        infoBox.add(lblHotel, 0, 3);
        Button btnHotel = new Button("Reserver");
        infoBox.add(btnHotel, 1, 3);
        // </hotel>


        cbLecture = new CheckBox("Foredragsholder");
        cbLecture.setOnAction(event -> update());
        infoBox.add(cbLecture, 0, 4);

        // <tilmeldings beskrivelse>
        VBox vbDesc = new VBox();
        infoBox.add(vbDesc, 0, 5, 2, 1);

        Label lblDescription = new Label("Total Order");
        lblDescription.setFont(Font.font(15));

        txaDescription = new TextArea();
        txaDescription.setPrefWidth(50);
        txaDescription.setPrefWidth(200);
        txaDescription.setEditable(false);
        vbDesc.getChildren().addAll(lblDescription, txaDescription);
        // </tilmeldings beskrivelse>

        Button btnCreate = new Button("Videre");
        btnCreate.setFont(Font.font(15));
        btnCreate.setPadding(new Insets(10));
        this.add(btnCreate, 1, 2);
        GridPane.setHalignment(btnCreate, HPos.RIGHT);

        clear();
        updateDescription();

        btnLedsager.setOnAction(event -> registerCompanionAction());
        btnHotel.setOnAction(event -> reserveHotelAction());
        btnCreate.setOnAction(event -> this.createAction());
    }

    private void selectedConferenceChanged(Conference newConference) {
        conference = newConference;
        clear();
    }

    private void update() {
        registration.setJoinDate(arrivalDate.getValue());
        registration.setLeaveDate(departureDate.getValue());
        registration.setLecture(cbLecture.isSelected());
        updateDescription();
    }

    // -------------------------------------------------------------------------

    private void createParticipantAction() {
        CreateParticipantWindow window = new CreateParticipantWindow("Opret Deltager", participant);

        window.showAndWait();

        if (window.getParticipant() != null) {
            participant = window.getParticipant();
            registration.setParticipant(participant);
        }
    }

    private void createAction() {
        if (conference == null) return;

        if (registration.getParticipant() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Du kan ikke fortsætte før du har oprettet en deltager!", ButtonType.CLOSE);
            alert.show();
            return;
        }

        update();
        Controller.registerParticipant(conference, participant, cbLecture.isSelected(), arrivalDate.getValue(), departureDate.getValue());

        SignUpWindow dia = new SignUpWindow("Tilmeldt Konference", registration);
        dia.showAndWait();

        if (dia.isSignedUp()) {
            tabPane.getTabs().get(1).setContent(new OverviewPane());
            clear();
        }
    }

    private void registerCompanionAction() {
        CompanionWindow dia = new CompanionWindow("Ledsager Program", conference, registration);

        dia.showAndWait();

        updateDescription();
    }

    private void reserveHotelAction() {
        HotelWindow dia = new HotelWindow("Reserver Hotel", conference, registration);

        dia.showAndWait();

        updateDescription();
    }

    private void updateDescription() {
        txaDescription.setText(Controller.printPricing(registration));
    }

    private void clear() {
        cbLecture.setSelected(false);
        registration = new Registration(null, -1, cbLecture.isSelected(), arrivalDate.getValue(), departureDate.getValue(), conference);
        updateDescription();
    }
}
