package Opgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File file = new File("L28/src/Opgave4/numbers.txt");

        try (PrintWriter out = new PrintWriter(file); Scanner in = new Scanner(System.in)) {
            boolean escape = false;
            while (!escape && in.hasNext()) {
                try {
                    System.out.println("Tal ind: ");
                    int input = Integer.parseInt(in.next());
                    System.out.println("køre stadig");
                    if (input == -1) escape = true;
                    else if (input < 0) {
                        System.out.println("Tallet skal være positivt");
                    } else {
                        out.println(input);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input skal være et tal");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

