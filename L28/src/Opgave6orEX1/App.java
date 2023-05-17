package Opgave6orEX1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        try (Scanner scanner = new Scanner(System.in)) {
            int index = -1;
            while (index < 0 || index > 9) {
                System.out.println("Type in an index (0..9): ");
                index = scanner.nextInt();
                if (index >= 0 && index <= 9) {
                    System.out.printf("Prime at index %d is %d", index, primes[index]);
                } else {
                    System.out.println("You input a number outside of the allowed index");
                }
            }
        } catch(InputMismatchException exception) {
            System.out.println("Error you did not input a number");
        }
//        catch (ArrayIndexOutOfBoundsException exception) {
//            System.out.println("You input a number outside of the allowed index");
//        }
    }

    //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    //	at Opgave6orEX1.App.main(App.java:13)

    //Exception in thread "main" java.util.InputMismatchException
}
