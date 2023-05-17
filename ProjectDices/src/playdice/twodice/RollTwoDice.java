package playdice.twodice;

import java.util.Arrays;
import java.util.Scanner;

public class RollTwoDice {

    private static int rollCount = 0;
    private static int rollSum = 0;

    private static int rollSame = 0;

    private static int[] diceStats = new int[6];

    public static int higestRoll = 0;
    //5
    //diceStats[5 - 1] = ++;


    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollTwoDice");
        printRules();
        System.out.println();

        rollTwoDice();

        System.out.println();
        System.out.println("Thank you for playing RollTwoDice");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollTwoDice:");
        System.out.println("The player throws two dice as long as he/she/it/they/them/Apache attack helicopter wants.");
        System.out.println("=====================================================");
    }

    private static void rollTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] faces = rollDice();


            System.out.println("Eyes: " + Arrays.toString(faces));
//            System.out.println("Total: " + sum(faces));
            System.out.println();

            updateStatistics(faces);

            System.out.print("Roll? ('no' stops) ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }
    public static int sum(int[] t) {
        int sums = 0;
        for (int i = 0; i < t.length; i++) {
            sums += t[i];
        }
        return sums;
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

    private static void updateStatistics(int[] faces) {
        rollSum += sum(faces);
        rollCount += 2;
        rollAmount(faces);
        sameRolls(faces);
        setHigestRoll(sum(faces));
    }

    public static void sameRolls(int[] faces)
    {
        if (faces[0] == faces[1]) {
            rollSame++;
        }
    }
    public static void rollAmount(int[] faces) {
        //loop through the array
        //for hver int minus 1 gå i index og tilføj 1;
        for (int i = 0; i < faces.length; i++) {
            diceStats[faces[i] - 1]++;
        }
    }

    public static void setHigestRoll(int eyes){
        if (eyes > higestRoll) {
            higestRoll = eyes;
        }
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.println("Roll count: " + rollCount);
        System.out.println("Roll sum: " + rollSum);
        System.out.println("Identical roll sum: " + rollSame);
        System.out.println("Higest sum of eyes: " + higestRoll);
        for (int i = 0; i < diceStats.length; i++) {
                System.out.println((i + 1) + " occurs " + diceStats[i] + " time" + (diceStats[i] > 1 ? "s" : ""));
        }
        System.out.println("-------");
    }
}
