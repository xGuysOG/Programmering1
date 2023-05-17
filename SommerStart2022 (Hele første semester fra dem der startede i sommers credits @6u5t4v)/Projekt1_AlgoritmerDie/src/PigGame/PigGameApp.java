package PigGame;

import java.util.Scanner;

public class PigGameApp {
    public static void main(String[] args) {
        boolean computer = false;
        String player1 = "Player1";
        String player2 = "Player2";
        int maxPoints = 100;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Vælg et Username: ");
            player1 = scan.next();

            System.out.println("Hvor meget vil du spille til: ");
            maxPoints = scan.nextInt();

            System.out.println("Vil du spille mod computer? (ja / nej):");
            String computerInput = scan.next();

            if (computerInput.equalsIgnoreCase("Nej")) {
                System.out.println("Vælg et username til spiller 2:");
                player2 = scan.next();
            } else {
                computer = true;
                System.out.println("Du spiller mod computeren");

                player2 = "Computer";
            }

            PigGame game = new PigGame(
                    new Player(player1, false),
                    new Player(player2, computer),
                    maxPoints);
            game.startGame();
        }


    }
}
