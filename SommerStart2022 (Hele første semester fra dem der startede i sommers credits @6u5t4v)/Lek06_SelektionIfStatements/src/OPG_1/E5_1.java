package OPG_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class E5_1 {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Write a number: ");
            double number = input.nextDouble();

            if (number > 0) {
                System.out.println(number + " is positive");
            } else if (number < 0) {
                System.out.println(number + " is negative");
            } else {
                System.out.println(number + " is zero");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Du SKAL inputte et tal");
        }
    }
}
