package Opgave4;

import java.util.Scanner;

public class EX66 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create a Scanner

        // Prompt the user to enter the number of rows
        System.out.print("Enter the number of rows: ");
        int numberOfRows = input.nextInt();

        // Display pattern
        displayPatternRight(numberOfRows);
        displayPatternLeft(numberOfRows);
    }
    public static void displayPatternRight(int n) {
        int padding = n - 1;
        for (int r = 1; r <= n; r++) {
            for (int p = 0; p < padding; p++) {
                System.out.print("  ");
            }

            // Print numbers
            for (int i = r; i > 0; i--) {
                System.out.print(i + " ");
            }
            System.out.println();
            padding--;
        }
    }

    public static void displayPatternLeft(int n) {
        int padding = n - 1;
        for (int r = 1; r <= n; r++) {

            for (int i = r; i > 0; i--) {
                System.out.print(i + " ");
            }
            for (int p = 0; p < padding; p++) {
                System.out.print("  ");
            }

            // Print numbers
            System.out.println();
            padding--;
        }
    }
}
