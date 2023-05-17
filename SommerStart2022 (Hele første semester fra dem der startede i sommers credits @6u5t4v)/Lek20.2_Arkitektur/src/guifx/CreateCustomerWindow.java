package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateCustomerWindow extends Stage {
    private Company company;

    public CreateCustomerWindow(String title, Company company) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.company = company;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private TextField txfCustomerName;
    private Label lblError;


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Customer Name");
        pane.add(lblName, 0, 0);

        txfCustomerName = new TextField();
        pane.add(txfCustomerName, 0, 1);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 2);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 2);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        lblError = new Label();
        pane.add(lblError, 0, 3);
        lblError.setStyle("-fx-text-fill: red");
    }

    private void okAction() {
        String name = txfCustomerName.getText().trim();
        if (!name.isEmpty()) {
            Customer customer = Controller.createCustomer(name);
            Controller.addCustomerToCompany(customer, company);
            this.hide();
        } else {
            lblError.setText("Name cannot be empty");
        }
    }

    private void cancelAction() {
        this.hide();
    }
}
