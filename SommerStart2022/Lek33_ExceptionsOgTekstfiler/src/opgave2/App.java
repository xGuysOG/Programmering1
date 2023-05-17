package opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File file = new File("Lek33_ExceptionsOgTekstfiler/src/opgave2/numbers.txt");
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextInt()) {
                System.out.println(in.nextInt() * 2);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
