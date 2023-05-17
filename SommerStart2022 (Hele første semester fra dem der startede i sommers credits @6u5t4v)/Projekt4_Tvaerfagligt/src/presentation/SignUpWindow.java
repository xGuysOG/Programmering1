package presentation;

import application.model.Registration;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SignUpWindow extends Stage {
    private Registration registration;

    public SignUpWindow(String title, Registration registration) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.registration = registration;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
    // -------------------------------------------------------------------------

    private boolean signedUp = false;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblDescription = new Label("Succesfuldt tilmeldt konference -");
        pane.add(lblDescription, 0, 0);

        Label lblConferenceName = new Label(registration.getConference().getName());
        lblConferenceName.setFont(Font.font(15));
        pane.add(lblConferenceName, 0, 1);

        Button btnCancel = new Button("Annuller");
        pane.add(btnCancel, 0, 6);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnConfirm = new Button("Bekræft");
        pane.add(btnConfirm, 0, 6);
        GridPane.setHalignment(btnConfirm, HPos.RIGHT);
        btnConfirm.setOnAction(event -> this.okAction());
    }

    private void okAction() {
        signedUp = true;
        this.hide();
    }

    private void cancelAction() {
        this.hide();
    }

    public boolean isSignedUp() {
        return signedUp;
    }
}
