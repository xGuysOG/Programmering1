package Opgave10;

import java.util.Random;
import java.util.Scanner;

public class EX1 {

//    (Game: scissor, rock, paper) Write a program that plays the popular scissor–rock–paper game. (A scissor can cut a paper,
//    a rock can knock a scissor, and a paper can wrap a rock.) The program randomly generates a number 0, 1, or 2 representing
//    scissor, rock, and paper. The program prompts the user to enter a number 0, 1, or 2 and displays a message indicating whether
//    the user or the computer wins, loses, or draws. Here are sample runs:
//    scissor (0), rock (1), paper (2): 1 The computer is scissor. You are rock. You won
//    scissor
    public static void main(String[] args) {
        Random r = new Random();
        int low = 0;
        int high = 2;
        int cpu = r.nextInt(high-low) + low;
        System.out.println("Pease input your choice (Scissor (0), Rock(1), Paper(2))");
        Scanner scanner = new Scanner(System.in);
        int guess = scanner.nextInt();
        if (guess > 2) {
            System.out.println("Error your input nr is bigger then 2");
            return;
        }
        System.out.println("You input " + guess + " against " + cpu + " and " + rockPaperScissor(guess, cpu));


    }

    public static String rockPaperScissor(int player, int cpu) {
        //return true if won
        if (player == 2 && cpu == 1) {
            return "Won";
        }
        if (player == 0 && cpu == 2) {
            return "Won";
        }
        if (player == 1 && cpu == 0) {
            return "Won";
        }
        if (player == cpu) {
            return "Tie";
        }

        return "Losts";
    }
}
