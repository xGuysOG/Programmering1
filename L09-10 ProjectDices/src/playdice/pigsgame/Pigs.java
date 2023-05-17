package playdice.pigsgame;

import java.util.Arrays;
import java.util.Scanner;

public class Pigs {

    //This array contains the players points.
    //players[0] = 1?
    //[players[1] = 2?

    public static boolean p1Playing = true;
    //Player scores index 0 = player 1 etc.
    public static int[] playerScores = new int[2];

    //2 dim array. playerNr, turnAmount, throwAmount
    //so playerDiceThrows[0][0] gives you player1(0)s turns


    public static double[][] turnAndThrowStats = new double[2][2];
    // 1 1
    // 1 1
    public static int winAmount = 100;
    public static void main(String[] args) {
        System.out.println("Welcome to the game of Pigs");
        System.out.println("How many points would you like to play to?");
        Scanner scanner = new Scanner(System.in);
        winAmount = scanner.nextInt();

        printRules();
        System.out.println();

        gameOfPig();

        System.out.println();
        System.out.println("Thank you for playing Pigs");
    }


    public static void gameOfPig() {
        //logic is handled so if p1Playing (p1 is playing)
        if (p1Playing) {
            playerScores[0] = playerTurn() + playerScores[0];
        } else {
            playerScores[1] = playerTurn() + playerScores[1];
        }
        //check for win condition
        if (winCondition()) {
            printFinalScore();
            return;
        }
        switchPlayers();
        gameOfPig();
    }
    public static void switchPlayers() {
        printScore();
        if (p1Playing) {
            p1Playing = false;
        } else {
            p1Playing = true;
        }
    }
    public static void printScore() {
        //calc averge throws
        System.out.println("");
        System.out.println("---------------Current Score---------------");
        System.out.println("Player 1: " + playerScores[0]);
        System.out.println("Player 2: " + playerScores[1]);
        System.out.println("---------------Score---------------");
        System.out.println("");
    }

    public static void printFinalScore() {
        //calc averge throws
        //calc averge throws
        System.out.println("");
        System.out.println("---------------Final Score---------------");
        if (turnAndThrowStats[0][0] == 0) {
            System.out.println("Player 1: " + playerScores[0]);
        } else {
            System.out.println("Player 1: " + playerScores[0] + " Amount of throws " + turnAndThrowStats[0][1] + " Average Throws " + ( turnAndThrowStats[0][1] / turnAndThrowStats[0][0]));
        }
        if (turnAndThrowStats[1][0] == 0) {
            System.out.println("Player 2: " + playerScores[1]);
        } else {
            System.out.println("Player 2: " + playerScores[1] + " Amount of throws " + turnAndThrowStats[1][1] + " Average Throws " + (turnAndThrowStats[1][1] / turnAndThrowStats[1][0]));
        }
        System.out.println("---------------Final Score---------------");
        System.out.println("");
    }

    public static boolean winCondition() {
        if (playerScores[0] >= winAmount) {
            System.out.println("Player 1 has won");
            return true;
        }
        if (playerScores[1] >= winAmount) {
            System.out.println("Player 2 has won");
            return true;
        }
        return false;
    }



    public static int playerTurn() {
        //here we count stuff and return the value of their turn.'
        int playerNr = 0;
        int sum = 0;
        if (p1Playing) {
            System.out.println("Player1s turn.");
            playerNr = 0;
        }else {
            System.out.println("Player2s turn.");
            playerNr = 1;
        }
        turnAndThrowStats[playerNr][0]++;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? ('no' stops your turn) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] faces = rollDice();
            turnAndThrowStats[playerNr][1]++;
            System.out.println("Eyes: " + Arrays.toString(faces));

            if (faces[0] == 1 && faces[1] == 1) {
                playerScores[playerNr] = 0;
                System.out.println("You rolled 1,1 so you get no points and lose all points data is " + playerNr + " amount is " + playerScores[playerNr]);
                return 0;
            }
            if (faces[0] == 1 || faces[1] == 1) {
                System.out.println("You rolled 1, so you get no points");
                return 0;
            }
            sum += sum(faces);
            System.out.print("Roll? Your current score is " + (playerScores[playerNr] + sum) + " out of " + winAmount + " ('no' stops your turn) ");
            answer = scanner.nextLine();
        }
        return sum;
    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static int[] rollDice() {
        int[] dice = new int[2];
        dice[0] = rollDie();
        dice[1] = rollDie();
        return dice;
    }

    public static int sum(int[] t) {
        int sums = 0;
        for (int i = 0; i < t.length; i++) {
            sums += t[i];
        }
        return sums;
    }
    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of PIGs:");
        System.out.println("first player throws 1 dice.");
        System.out.println("if the dice is 1 he loses.");
        System.out.println("if the dice is something else it now becomes the sum.");
        System.out.println("the player then throws 1 dice if it's 1 he has no point and loses");
        System.out.println("if it's anything else it gets added to his old points and he throws again.");
        System.out.println("the player can choose to stop throwing the dice when they want.");
        System.out.println("first player to get " + winAmount + " wins.");
        System.out.println("=====================================================");
    }

}
