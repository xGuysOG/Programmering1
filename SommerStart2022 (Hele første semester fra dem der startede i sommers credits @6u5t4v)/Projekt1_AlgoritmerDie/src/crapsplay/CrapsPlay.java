package crapsplay;

import java.util.Scanner;

public class CrapsPlay {
    Scanner scan;

    private Die die1;
    private Die die2;
    private int rolls;
    private int point;
    private int lostGames;
    private int wonGames;

    private boolean winner = false;
    private boolean lost = false;
    private boolean finished = false;


    public CrapsPlay() {
        this.die1 = new Die();
        this.die2 = new Die();
        scan = new Scanner(System.in);
    }

    private void welcomeToGame() {
        System.out.println("Velkommen til spillet Crabs!");
    }

    private void takeTurn() {
        die1.roll();
        die2.roll();

        int roll = die1.getFaceValue() + die2.getFaceValue();
        System.out.println("Du kastede med terningerne og slog " + roll);
        rolls++;

        if (rolls == 1) {
            if (roll == 7 || roll == 11) {
                // Winner
                winner = true;
            } else if (roll == 2 || roll == 3 || roll == 12) {
                // Loser
                lost = true;
            } else {
                point = roll;
            }
        } else {
            if (roll == point) {
                winner = true;
            } else if (roll == 7) {
                lost = true;
            }
        }
    }

    public void startGame() {
        welcomeToGame();

        while (!finished) {
            System.out.println("Vil du kaste en terning? Angiv Ja eller Nej: ");
            String goOn = scan.nextLine();
            if (goOn.equalsIgnoreCase("Nej")) {
                finished = true;
            } else {
                takeTurn();
                if (winner) {
                    System.out.println("Winner winner chicken dinner!");
                    wonGames++;
                    tryAgain();
                } else if (lost) {
                    System.out.println("Gameover your lost!");
                    lostGames++;
                    tryAgain();
                }
            }
        }

        gameOver();
    }

    private void gameOver() {
        System.out.println("Tak for spillet, du rullede " + rolls + " gange");
    }

    private void tryAgain() {
        System.out.println("Vil du tage endnu et spil ? (Ja eller Nej):");
        String input = scan.nextLine();
        if (input.equals("Nej")) {
            finished = true;

            System.out.println("Du har vundet: " + wonGames);
            System.out.println("Du har tabt: " + wonGames);

            scan.close();
        } else {
            rolls = 0;
            winner = false;
            lost = false;
        }
    }
}
