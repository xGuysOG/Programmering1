package playdice.crapsgame;

import java.util.Arrays;
import java.util.Scanner;

public class Craps {
    public static int gamesWon = 0;
    public static int gamesLost = 0;
    public static void main(String[] args) {
        System.out.println("Welcome to the game of Craps");
        printRules();
        System.out.println();

        playCraps();

        System.out.println();
        System.out.println("Thank you for playing Craps");
    }
    public static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOn = true;
        while (gameOn) {
            System.out.print("Roll? ('no' stops) ");
            String answer = scanner.nextLine();
            int[] faces = rollDice();
            int sum = sum(faces);
            System.out.println("Eyes: " + Arrays.toString(faces));
            System.out.println("Total: " + sum);
            System.out.println();
            if (sum == 7 || sum == 11) {
                System.out.println("Congratulations you have won!");
                gamesWon++;
            }
            else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You sadly lost!");
                gamesLost++;
            }
            else if (rollforPoint(sum)) {
                System.out.println("You have Won!");
                gamesWon++;
            } else {
                System.out.println("You have Lost!");
                gamesLost++;
            }
            System.out.println("Would you like to play again? ('no' stops 'yes starts')");
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                gameOn = false;
            } else if (answer.equalsIgnoreCase("yes")) {
                gameOn = true;
            } else {
                System.out.println("ERROR wrong input");
                gameOn = false;
            }
        }
        //print stats
        System.out.println("The game is over here is yoru total score");
        System.out.println("Games won " + gamesWon + "/" + (gamesWon + gamesLost));
        System.out.println("Games lost " + gamesLost + "/" + (gamesWon + gamesLost));
        scanner.close();
    }
    // Roll the 2 dice until point or 7 is rolled.
    // Return true, if point is rolled.
    public static boolean rollforPoint(int point) {
        System.out.println("You have rolled " + point);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? You need to roll " + point + " to win or 7 to lose ('no' stops) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] faces = rollDice();
            int sum = sum(faces);
            System.out.println("Eyes: " + Arrays.toString(faces));
            System.out.println("Total: " + sum);
            System.out.println();
            if (sum == point) {
                return true;
            }
            if (sum == 7){
                return false;
            }
            System.out.print("Roll? You need to roll " + point + " to win or 7 to lose ('no' stops) ");
            answer = scanner.nextLine();
         }
        return false;
    }

    private static int[] rollDice() {
        int[] dice = new int[2];
        dice[0] = randomDice();
        dice[1] = randomDice();
        return dice;
    }

    public static int randomDice() {
        return (int) (Math.random() * 6 + 1);
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
        System.out.println("Rules of crab:");
        System.out.println("if the sum is 7 or 11 the player has won.");
        System.out.println("if the sum is 2, 3 or 12 the player has lost.");
        System.out.println("if the sum is something else the sum is now his point.");
        System.out.println("the player throws again and again until the sum is 7 or the sum equals the point");
        System.out.println("if the sum is 7 the player has lost.");
        System.out.println("if the sum is equal to the point the player has won.");
        System.out.println("=====================================================");
    }

}
