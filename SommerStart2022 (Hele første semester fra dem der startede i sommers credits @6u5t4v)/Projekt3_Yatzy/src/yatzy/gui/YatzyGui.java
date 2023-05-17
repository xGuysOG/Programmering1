package yatzy.gui;


import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import yatzy.model.Yatzy;

import java.util.Optional;

public class YatzyGui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // Shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // Shows the hold status of the 5 dice.
//    private CheckBox[] chbHolds;
    // Shows the results previously selected .
    // For free results (results not set yet), the results
    // corresponding to the actual face values of the 5 dice are shown.
    private final TextField[] txfResults = new TextField[15];
    // Shows points in sums, bonus and total.
    private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
    // Shows the number of times the dice has been rolled.
//    private Label lblRolled = new Label("Rolls: 0");

    private final Button btnRoll = new Button("Roll!");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // initialize txfValues, chbHolds, btnRoll and lblRolled
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i] = new TextField();
        }

        Label txtLabel = new Label("Press die to Hold");
        dicePane.add(txtLabel, 0, 0);

        HBox diesBox = new HBox();
        diesBox.setSpacing(8);
        dicePane.add(diesBox, 0, 1);

        for (TextField dieHolder : txfValues) {
            diesBox.getChildren().add(dieHolder);
            dieHolder.setEditable(false);
            dieHolder.setPrefWidth(60);
            dieHolder.setPrefHeight(60);
            dieHolder.setUserData(false);
            dieHolder.setStyle("-fx-border-color: Green;");
            dieHolder.setAlignment(Pos.CENTER);

            dieHolder.setOnMouseClicked(this::lockDieAction);
        }

//        dicePane.add(lblRolled, 1, 2);

        dicePane.add(btnRoll, 0, 2);
        btnRoll.setMaxWidth(Double.MAX_VALUE);
        GridPane.setFillWidth(btnRoll, true);
        btnRoll.setOnAction(event -> rollDiesAction());

        // ---------------------------------------------------------------------

        GridPane scorePane1 = new GridPane();
        pane.add(scorePane1, 0, 1);
        scorePane1.setGridLinesVisible(false);
        scorePane1.setPadding(new Insets(10));
        scorePane1.setVgap(5);
        scorePane1.setHgap(10);
        scorePane1.setStyle("-fx-border-color: black");
        int w = 60; // width of the text fields

        // Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.
        /*
        Placerer
         */
        Label lblResultName;
        int row = 0;

        for (int i = 1; i <= 6; i++) {
            TextField field = new TextField("0");
            field.setEditable(false);
            field.setMaxWidth(w);
            field.setDisable(true);
            field.setUserData(false);
            field.setOnMouseClicked(this::chooseFieldAction);

            lblResultName = new Label(i + "-s");
            lblResultName.setPrefWidth(75);

            if (i % 2 == 0) {
                scorePane1.add(lblResultName, 3, row);
                scorePane1.add(field, 4, row);
                row++;
            } else {
                scorePane1.add(lblResultName, 0, row);
                scorePane1.add(field, 1, row);
            }

            txfResults[i - 1] = field;
        }

        Label lblSum = new Label("Sum:");
        txfSumSame = new TextField("0");
        txfSumSame.setPrefWidth(w);
        txfSumSame.setEditable(false);
        VBox sumOfSame = new VBox(lblSum, txfSumSame);
        scorePane1.add(sumOfSame, 1, 3);

        Label lblBonus = new Label("Bonus:");
        txfBonus = new TextField("0");
        txfBonus.setPrefWidth(w);
        txfBonus.setEditable(false);
        VBox bonusOfSame = new VBox(lblBonus, txfBonus);
        scorePane1.add(bonusOfSame, 4, 3);

//        HBox scoreOfSame = new HBox(sumOfSame, bonusOfSame);
//        scoreOfSame.setSpacing(10);

        // ---------------------------------------------------------------------

        GridPane scorePane2 = new GridPane();
        pane.add(scorePane2, 0, 2);
        scorePane2.setGridLinesVisible(false);
        scorePane2.setPadding(new Insets(10));
        scorePane2.setVgap(5);
        scorePane2.setHgap(10);
        scorePane2.setStyle("-fx-border-color: black");

        lblResultName = new Label("One Pair");
        scorePane2.add(lblResultName, 0, 0);

        lblResultName = new Label("Two Pair");
        scorePane2.add(lblResultName, 2, 0);

        lblResultName = new Label("Three Same");
        scorePane2.add(lblResultName, 0, 1);

        lblResultName = new Label("Four Same");
        scorePane2.add(lblResultName, 2, 1);

        lblResultName = new Label("Small Straight");
        scorePane2.add(lblResultName, 0, 2);

        lblResultName = new Label("Large Straight");
        scorePane2.add(lblResultName, 2, 2);

        lblResultName = new Label("Full House");
        scorePane2.add(lblResultName, 0, 3);

        lblResultName = new Label("Chance");
        scorePane2.add(lblResultName, 2, 3);

        lblResultName = new Label("Yatzy");
        scorePane2.add(lblResultName, 0, 4);

        row = 0;
        for (int i = 7; i <= 15; i++) {
            TextField resultField = new TextField("0");
            resultField.setEditable(false);
            resultField.setMaxWidth(w);
            resultField.setDisable(true);
            resultField.setUserData(false);
            resultField.setOnMouseClicked(this::chooseFieldAction);

            if (i % 2 == 0) {
                scorePane2.add(resultField, 3, row);
                row++;
            } else {
                scorePane2.add(resultField, 1, row);
            }

            txfResults[i - 1] = resultField;
        }

        lblSum = new Label("Sum:");
        txfSumOther = new TextField("0");
        txfSumOther.setPrefWidth(w);
        txfSumOther.setEditable(false);
        VBox totalSum = new VBox(lblSum, txfSumOther);
        scorePane2.add(totalSum, 1, 8);

        Label lblTotal = new Label("Total:");
        txfTotal = new TextField("0");
        txfTotal.setPrefWidth(w);
        txfTotal.setEditable(false);
        VBox totalBox = new VBox(lblTotal, txfTotal);
        scorePane2.add(totalBox, 3, 8);
    }

    // -------------------------------------------------------------------------

    private Yatzy yatzy = new Yatzy();

    // Create a method for btnRoll's action.
    // Hint: Create small helper methods to be used in the action method.
    private void rollDiesAction() {
        if (yatzy.getThrowCount() == 0) {
            for (TextField txfResult : txfResults) {
                txfResult.setDisable((boolean) txfResult.getUserData());
            }
        }

        boolean[] holds = new boolean[5];
        // [false, false, true, false, true]
        for (int i = 0; i < txfValues.length; i++) {
            holds[i] = (boolean) txfValues[i].getUserData();
        }

        yatzy.throwDice(holds);

        // Display die faces in text fields
        int[] dices = yatzy.getValues();
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i].setText(String.valueOf(dices[i]));
        }

        // Update results, if they are not previously selected
        // They are selected if the field is disabled
        int[] results = yatzy.getResults();
        for (int i = 0; i < txfResults.length; i++) {
            TextField field = txfResults[i];
            if (!field.isDisabled())
                field.setText(String.valueOf(results[i]));
        }

        // If the user have used all their throws
        // then we will disable the button
        if (yatzy.getThrowCount() == 3) {
            btnRoll.setDisable(true);
        }

        // Update text on the roll button
        btnRoll.setText("Roll! " + yatzy.getThrowCount());
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    private void chooseFieldAction(Event event) {
        TextField selectedField = (TextField) event.getSource();
        selectedField.setUserData(true);

        // Disable all fields except previously selected
        // and the currently selected.
        // So the user cant press a field after already selected one.
        for (TextField txfResult : txfResults) {
            if (txfResult != selectedField && !txfResult.isDisabled()) {
                txfResult.setText("0");
                txfResult.setDisable(true);
            }
        }

        // Calculate sum of the results in the "same"-section
        // of the scoreboard
        int sumSame = 0;
        for (int i = 0; i < 6; i++) {
            if ((boolean) txfResults[i].getUserData()) {
                sumSame += Integer.parseInt(txfResults[i].getText());
            }
        }

        // If the sum is atleast 63, we add 50 points to the sum
        // of "same"-section, and set bonus field to "50"
        if (sumSame >= 63) {
            sumSame += 50;
            txfBonus.setText("" + 50);
        }


        // Calculate sum for the "other"-section of the scoreboard
        // based on textfields that are not equals to 0
        int sumOther = 0;
        for (int i = 6; i < 15; i++) {
            if ((boolean) txfResults[i].getUserData()) {
                sumOther += Integer.parseInt(txfResults[i].getText());
            }
        }

        // Set our scores on our textfields.
        txfSumSame.setText("" + sumSame);
        txfSumOther.setText("" + sumOther);

        // The total textfield is the sum of sumSame and sumOther
        txfTotal.setText(sumOther + sumSame + "");

        boolean gameover = true;
//        for (TextField textField : txfResults) {
//            if (!(boolean) textField.getUserData()) {
//                gameover = false;
//                break;
//            }
//        }

        if (gameover) {
            gameOver();
        }

        // Reset the throw counter
        yatzy.resetThrowCount();
        // Reset dies to be empty and the border to green
        resetDies();
        // Enable the roll button again.
        btnRoll.setDisable(false);
    }

    private void lockDieAction(Event event) {
        // If the throw count is 0, we will prevent the user
        // from holding a die.
        if (yatzy.getThrowCount() == 0) return;

        TextField txfDie = (TextField) event.getSource();

        // Get the state of the die(is it holding or not)
        boolean holding = (boolean) txfDie.getUserData();

        // Toggle the state of the die
        txfDie.setUserData(!holding);

        // If we hold the die, the border will be RED otherwise GREEN.
        // Default is GREEN
        if (holding) {
            txfDie.setStyle("-fx-border-color: Green;");
        } else {
            txfDie.setStyle("-fx-border-color: Red;");
        }
    }

    private void resetDies() {
        for (TextField dieHolder : txfValues) {
            dieHolder.setText("");
            dieHolder.setUserData(false);
            dieHolder.setStyle("-fx-border-color: Green;");
        }
    }

    private void gameOver() {
        Alert alert = new Alert(
                Alert.AlertType.INFORMATION,
                "You got " + txfTotal.getText() + " points\nWould you like to play again?",
                ButtonType.OK);

        Optional<ButtonType> button = alert.showAndWait();

        if (button.isPresent()) {
            resetGame();
        }
    }

    private void resetGame() {
        for (TextField txf : txfResults) {
            txf.setUserData(false);
            txf.setDisable(true);
            txf.setText("0");
        }

        txfBonus.setText("0");
        txfTotal.setText("0");
        txfSumSame.setText("0");
        txfSumOther.setText("0");

        yatzy.resetThrowCount();
        btnRoll.setText("Roll!");
    }
}
