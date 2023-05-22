package PigGame;

import java.util.Scanner;

public class Player {
    private Die die;
    private String playerName;
    private int totalPoints;
    private Scanner scan;
    private boolean computer;

    public Player(String playerName, boolean computer) {
        this.die = new Die();
        this.playerName = playerName;
        this.computer = computer;
        this.totalPoints = 0;
        scan = new Scanner(System.in);
    }

    public void takeTurn() {
        System.out.println(playerName + "'s tur");

        if (computer) {
            computerTurn();
        } else {
            playerTurn();
        }
    }

    private void playerTurn() {
        boolean stop = false;

        int collectedPoints = 0;
        int hit = 0;

        while (!stop) {
            System.out.println("Vil du slå? (Ja eller Nej):");
            String response = scan.nextLine();
            if (response.equalsIgnoreCase("Nej")) {
                stop = true;
            } else {
//                die.roll();
//                hit = die.getFaceValue();
//
//                if (hit == 1) {
//                    points = 0;
//                    stop = true;
//                    System.out.println(playerName + " rullede 1, og mistede sine point");
//                } else {
//                    points += hit;
//                    System.out.println(playerName + " rullede " + hit + ", og samlet " + points + " point");
//                }
                int rolled = roll(collectedPoints);
                if (rolled == 0) {
                    collectedPoints = 0;
                    stop = true;
                } else {
                    collectedPoints += rolled;
                }
            }
        }

        totalPoints += collectedPoints;
        System.out.println(playerName + "'s total point: " + totalPoints);
    }

    private void computerTurn() {
        int hit;
        int points = 0;

        int totalAttempts = (int) (Math.random() * 20) + 1;
//        System.out.println(totalAttempts);

        int attempts = 0;

        while (attempts < totalAttempts) {
            attempts++;

            int rolled = roll(points);
            if (rolled == 0) {
                points = 0;
                break;
            } else {
                points += rolled;
            }
        }

        System.out.println("Computeren rullede " + attempts + " gange og modtog " + points);
        totalPoints += points;
        System.out.println("Computeren har " + totalPoints + " point");
    }

    private int roll(int points) {
        die.roll();
        int hit = die.getFaceValue();

        if (hit == 1) {
            hit = 0;
            System.out.println(playerName + " rullede 1, og mistede sine point");
        } else {
            points += hit;
            System.out.println(playerName + " rullede " + hit + ", og samlet " + points + " point");
        }

        return hit;
    }

    public Player reset() {
        return new Player(playerName, computer);
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public String getPlayerName() {
        return playerName;
    }
}

