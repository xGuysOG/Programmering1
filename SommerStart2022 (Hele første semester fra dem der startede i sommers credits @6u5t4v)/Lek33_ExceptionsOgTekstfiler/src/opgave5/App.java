package opgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
        File file = new File("Lek33_ExceptionsOgTekstfiler/src/opgave5/numbers.txt");

        try (PrintWriter out = new PrintWriter(file); Scanner in = new Scanner(System.in)) {
            boolean escape = false;
            while (!escape && in.hasNext()) {
                try {
                    int input = Integer.parseInt(in.next());
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
