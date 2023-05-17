package PigGame;

import java.util.Scanner;

public class PigGame {
    private Player player1;
    private Player player2;
    private int maxPoints;
    private int rounds = 0;
    private Scanner scan;

    public PigGame(Player player1, Player player2, int maxPoints) {
        this.player1 = player1;
        this.player2 = player2;
        this.maxPoints = maxPoints;
        scan = new Scanner(System.in);
    }

    public void startGame() {
        boolean finished = false;
        Player turn;

        while (!finished) {
            if (rounds % 2 == 0) {
                turn = player1;
            } else {
                turn = player2;
            }

            turn.takeTurn();
            rounds++;

            if (checkWinner(turn)) {
                System.out.println("Skal vi spille igen? (Ja/Nej):");

                String input = scan.nextLine();
                if (input.equalsIgnoreCase("Nej")) {
                    finished = true;
                } else {
                    player1 = player1.reset();
                    player2 = player2.reset();
                    rounds = 0;
                }
            }

        }
    }

    private boolean checkWinner(Player player) {
        boolean winner = player.getTotalPoints() >= maxPoints;
        if (winner) {
            System.out.println(player.getPlayerName() + " vandt spillet!");
        }
        return winner;
    }
}
