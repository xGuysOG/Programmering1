package gui;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.YatzyDice;

import javax.imageio.ImageIO;
import java.net.URL;
import java.util.ArrayList;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();

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

    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();

    private final Label lblThrowCount = new Label();
    private final Button btnThrow = new Button(" Throw ");

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
        addDiceFields(dicePane);
//        addDiceCheckBoxes(dicePane);
        addThrowBtn(dicePane);

        // add txfValues, chbHolds
        // TODO
        // add lblThrowCount and btnThrow
        // TODO

        // ---------------------------------------------------------------------


        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int width = 50; // width of the text fields
        addLabelsAndResults(scorePane);
        txfSumSame.setFocusTraversable(false);
        txfSumSame.setText("0");
        txfSumSame.setEditable(false);
        txfBonus.setFocusTraversable(false);
        txfBonus.setText("0");
        txfBonus.setEditable(false);
        txfSumOther.setFocusTraversable(false);
        txfSumOther.setText("0");
        txfSumOther.setEditable(false);
        txfTotal.setFocusTraversable(false);
        txfTotal.setText("0");
        txfTotal.setEditable(false);

        // add labels for results
        // add txfResults,
        // TODO
        // add labels and text fields for sums, bonus and total.
        // TODO

    }

    public void addDiceFields(GridPane dicePane){
        for(int i = 0; i < 5; i++){
            this.txfValues[i] = new TextField();
            txfValues[i].setEditable(false);
            txfValues[i].setPrefHeight(40);
            txfValues[i].setPrefWidth(40);
            txfValues[i].setUserData(false);
            txfValues[i].setOnMouseClicked(this::lockingDie);
            txfValues[i].setStyle("-fx-border-color: Black;");
            txfValues[i].setFocusTraversable(false);
            dicePane.add(txfValues[i],i,1);
        }
    }

    public void addThrowBtn(GridPane dicePane){
        dicePane.add(this.btnThrow,5,2);
        btnThrow.setFocusTraversable(false);
        btnThrow.setOnAction(x -> rollDice());
    }

//    public void addDiceCheckBoxes(GridPane dicePane){
//        for(int i = 0; i < 5; i++){
//            this.cbxHolds[i] = new CheckBox("Hold");
//            dicePane.add(cbxHolds[i],i,0);
//        }
//    }
    public void addLabelsAndResults(GridPane scorePane){
        for(int i = 0; i < 15; i++){
            var txt = new TextField();
            txt.setEditable(false);
            txt.setPrefWidth(50);
            txt.setOnMouseClicked(mouseEvent -> mouseClicked(mouseEvent));
            txt.setFocusTraversable(false);
            txfResults.add(txt);
        }

        Label lbl1s = new Label("1-s");
        scorePane.add(lbl1s,0,0);
        scorePane.add(txfResults.get(0),1,0);

        Label lbl2s = new Label("2-s");
        scorePane.add(lbl2s,0,1);
        scorePane.add(txfResults.get(1),1,1);

        Label lbl3s = new Label("3-s");
        scorePane.add(lbl3s,0,2);
        scorePane.add(txfResults.get(2),1,2);

        Label lbl4s = new Label("4-s");
        scorePane.add(lbl4s,0,3);
        scorePane.add(txfResults.get(3),1,3);

        Label lbl5s = new Label("5-s");
        scorePane.add(lbl5s,0,4);
        scorePane.add(txfResults.get(4),1,4);

        Label lbl6s = new Label("6-s");
        scorePane.add(lbl6s,0,5);
        scorePane.add(txfResults.get(5),1,5);

        Label lblSum = new Label("Sum");
        scorePane.add(lblSum,2,5);
        scorePane.add(txfSumSame,3,5);

        Label lblBonus = new Label("Bonus");
        scorePane.add(lblBonus,2,6);
        scorePane.add(txfBonus,3,6);

        Label lblOnePair = new Label("One pair");
        scorePane.add(lblOnePair,0,7);
        scorePane.add(txfResults.get(6),1,7);

        Label lblTwoPair = new Label("Two pair");
        scorePane.add(lblTwoPair,0,8);
        scorePane.add(txfResults.get(7),1,8);

        Label lblThreeSame = new Label("Three Same");
        scorePane.add(lblThreeSame,0,9);
        scorePane.add(txfResults.get(8),1,9);

        Label lblFourSame = new Label("Four Same");
        scorePane.add(lblFourSame,0,10);
        scorePane.add(txfResults.get(9),1,10);

        Label lblFullHouse = new Label("Full House");
        scorePane.add(lblFullHouse,0,11);
        scorePane.add(txfResults.get(10),1,11);

        Label lblSmallStr = new Label("Small str");
        scorePane.add(lblSmallStr,0,12);
        scorePane.add(txfResults.get(11),1,12);

        Label lblLargeStr = new Label("Large str");
        scorePane.add(lblLargeStr,0,13);
        scorePane.add(txfResults.get(12),1,13);

        Label lblChance = new Label("Chance");
        scorePane.add(lblChance,0,14);
        scorePane.add(txfResults.get(13),1,14);

        Label lblYatzy = new Label("Yatzy");
        scorePane.add(lblYatzy,0,15);
        scorePane.add(txfResults.get(14),1,15);

        Label lblSumOther = new Label("Sum");
        scorePane.add(lblSumOther,2,15);
        scorePane.add(txfSumOther,3,15);

        Label lblTotal = new Label("Total");
        scorePane.add(lblTotal,2,16);
        scorePane.add(txfTotal,3,16);
    }

    // -------------------------------------------------------------------------

    // Create an action method for btnThrow's action.
    // Hint: Create small helper methods to be used in the action method.
    // TODO
    private YatzyDice yatzyDice = new YatzyDice();
    private void rollDice() {
        lockDies();

        //the dices and if any of them are on hold (example: true, false, false, true, false);
        boolean[] holds = new boolean[5];
        for(int i = 0; i < txfValues.length; i++) {
            holds[i] = (boolean) txfValues[i].getUserData();
        }
        yatzyDice.throwDice(holds);
        int[] dices = yatzyDice.getValues();
        for(int i = 0; i < dices.length; i++) {
            txfValues[i].setText(String.valueOf(dices[i]));
        }
        if (yatzyDice.getThrowCount() == 3) {
            btnThrow.setDisable(true);
        }
        btnThrow.setText("Roll! : " + yatzyDice.getThrowCount());
        int[] results = yatzyDice.getResults();
        for(int i = 0; i < txfResults.size(); i++){
            if (txfResults.get(i).isDisable()) {
                continue;
            }
            txfResults.get(i).setText(String.valueOf(results[i]));
        }
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    // TODO
    private void mouseClicked(MouseEvent event) {
        TextField txf = (TextField) event.getSource();
        if (txf.getText().length() < 1) {
            return;
        }
        //dont have to make? if we add it when we do stuff
        if (txf == txfSumOther ||txf == txfSumSame || txf == txfBonus || txf == txfTotal) {
            return;
        }
        txf.setDisable(true);

        resetDies();
        checkScore(txf);
    }

    private void resetDies() {
        yatzyDice.resetThrowCount();
        btnThrow.setDisable(false);
        btnThrow.setText("Roll!");
        for(TextField textField : txfResults) {
            if (textField.isDisable()) {
                continue;
            }
            textField.setText("0");
        }
        for(TextField textField : txfValues) {
            textField.setText("");
            textField.setStyle("-fx-border-color: Black;");
        }
    }

    private void checkScore(TextField txf) {
        int sum = Integer.parseInt(txfSumSame.getText());
        int secondSum = Integer.parseInt(txfSumOther.getText());
        //check if txfSumSame = txfBonus;
        //Check if all fields are used

        for(int i = 0; i < txfResults.size(); i++){
            if(txfResults.get(i).equals(txf) && i < 6){
                txfSumSame.setText(String.valueOf(sum+Integer.parseInt(txf.getText())));
            }
            if(txfResults.get(i).equals(txf) && i > 5){
                txfSumOther.setText(String.valueOf(secondSum+Integer.parseInt(txf.getText())));
            }
        }
        sum = Integer.parseInt(txfSumSame.getText());
        if (sum >= 63) {
            txfBonus.setText("50");
        }

        int bonusSum = Integer.parseInt(txfBonus.getText());
        //You have won!!!
        for(TextField tx : txfResults) {
            if (!tx.isDisable()) {
                return;
            }
        }
        int totalScore = sum + secondSum + bonusSum;
        txfTotal.setText(String.valueOf(totalScore));
        gameover();
    }

    private void gameover() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Congratulations!");
        alert.setHeaderText(null);
        alert.setContentText("You have finnished the game with a score of: " + txfTotal.getText());

        alert.showAndWait();


        yatzyDice.resetThrowCount();
        btnThrow.setDisable(false);
        btnThrow.setText("Roll!");
        for(TextField textField : txfResults) {
            textField.setText("0");
        }
        for(TextField textField : txfValues) {
            textField.setText("");
            textField.setStyle("-fx-border-color: Black;");
        }

        txfSumSame.setText("0");
        txfBonus.setText("0");
        txfTotal.setText("0");
        txfSumOther.setText("0");

    }

    private void lockingDie(Event event) {
        if (yatzyDice.getThrowCount() == 0 || yatzyDice.getThrowCount() == 3) {
            return;
        }
        //get data
        TextField die = (TextField) event.getSource();
        boolean dieHold = (boolean) die.getUserData();

        if(dieHold) {
            return;
        }
        if (die.getStyle().contains("Red")) {
            die.setStyle("-fx-border-color: Black;");
        } else {
            die.setStyle("-fx-background-color: Red;");
        }
    }

    private void lockDies() {
        for(TextField field : txfValues) {
            if (field.getStyle().contains("Red")) {
                System.out.println("Found one thats red and he has the data " + field.getText());
                field.setUserData(true);
            } else {
                field.setUserData(false);
            }
        }
    }

}
