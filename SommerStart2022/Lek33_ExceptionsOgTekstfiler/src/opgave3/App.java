package opgave3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File file = new File("Lek33_ExceptionsOgTekstfiler/src/opgave2/numbers.txt");
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextInt()) {
                list.add(in.nextInt());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}
