package pairofdices;

import java.util.Scanner;

public class PlayPairOfDice {
    private int rolls;
    private Scanner scan;
    private PairOfDices pod;

    public PlayPairOfDice() {
        scan = new Scanner(System.in);
        pod = new PairOfDices();
    }

    private void welcomeToGame() {
        System.out.println("Velkommen til spillet Pair of Dices");
    }

    private void gameOver() {

        System.out.println("Tak for spillet, du kastede " + rolls + " "
                + "gange.");

        System.out.println("1'er = " + pod.getOnes());
        System.out.println("2'er = " + pod.getTwoes());
        System.out.println("3'er = " + pod.getThrees());
        System.out.println("4'er = " + pod.getFours());
        System.out.println("5'er = " + pod.getFives());
        System.out.println("6'er = " + pod.getSixes());
        System.out.println("Højeste kast: " + pod.getHighestThrow());
        System.out.println("Kast med samme antal øjne: " + pod.getSameEyedDices());

        scan.close();
    }

    private void takeTurn() {
        pod.rollBothDices();
        int sum = pod.sumOfDices();
        rolls++;
        System.out.println("Du har kastet: " + sum);
    }

    public void startGame() {
        welcomeToGame();

        boolean finished = false;

        while (!finished) {
            System.out.println("Vil du kaste dine terninger? Angiv Ja eller Nej: ");
            String goOn = scan.nextLine();
            if (goOn.equalsIgnoreCase("Nej")) {
                finished = true;
            } else {
                takeTurn();
            }
        }
        gameOver();
    }
}
