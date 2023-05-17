package Opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.plaf.FontUIResource;

public class TextAreaDemo extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Excerise 3");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField investField = new TextField();
    private final TextField yearField = new TextField();
    private final TextField interestField = new TextField();
    private final TextField futureField = new TextField();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label investText = new Label("Investment:");
        pane.add(investText, 0, 0);
        pane.add(investField, 1, 0);
        investField.setEditable(true);
        investField.setText("1200");

        Label yearText = new Label("Years:");
        pane.add(yearText, 0, 1);
        pane.add(yearField, 1, 1);
        yearField.setEditable(true);
        yearField.setText("2");

        Label interestText = new Label("Interest (%):");
        pane.add(interestText, 0, 2);
        pane.add(interestField, 1,2);
        interestField.setEditable(false);
        interestField.setText("2.4");

        Button combineButton = new Button("Calculate");
        pane.add(combineButton, 1, 3);
        combineButton.centerShapeProperty();
        GridPane.setMargin(combineButton, new Insets(0, 0, 0, 40));
        combineButton.setOnAction(event -> this.calculateInterest());


        Label futureText = new Label("Future value:");
        pane.add(futureText, 0, 4);
        pane.add(futureField, 1,4);
        futureField.setEditable(false);
    }
    // ------------------------------------------------------------------------
    private void calculateInterest() {
        double investment = Double.parseDouble(investField.getText());
        double years = Double.parseDouble(yearField.getText());
        double interest = Double.parseDouble(interestField.getText());

        double futureInvestmentValue = (double) (investment * Math.pow(1 + interest, years));
        futureField.setText(String.valueOf(futureInvestmentValue));

    }
}
