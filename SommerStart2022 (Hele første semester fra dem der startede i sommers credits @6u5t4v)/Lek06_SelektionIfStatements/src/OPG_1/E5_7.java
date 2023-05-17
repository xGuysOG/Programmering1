package OPG_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class E5_7 {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Feed me 3 numbers");

            System.out.print("1st number: ");
            double number1 = input.nextDouble();
            System.out.print("2nd number: ");
            double number2 = input.nextDouble();
            System.out.print("3rd number: ");
            double number3 = input.nextDouble();

            if (number2 > number1 && number3 > number2) {
                System.out.println("Increasing");
            } else if (number1 > number2 && number2 > number3) {
                System.out.println("Decreasing");
            } else {
                System.out.println("Neither");
            }

        } catch (InputMismatchException e) {
            System.out.println("ERROR: Du SKAL inputte et tal");
        }
    }
}
