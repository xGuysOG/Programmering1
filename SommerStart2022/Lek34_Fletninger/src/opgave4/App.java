package opgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String path = "Lek34_Fletninger/src/opgave4/talfil.txt";

        System.out.println("Is 9140 in file: " + inFileSearch(path, 9140));
        System.out.println("Is 959 in file: " + inFileSearch(path, 959));
        System.out.println("Is 69 in file: " + inFileSearch(path, 69));
    }

    public static boolean inFileSearch(String fileName, int target) {
        boolean found = false;

        File file = new File(fileName);
        try (Scanner in = new Scanner(file)) {
            while (!found && in.hasNextInt()) {
                if (in.nextInt() == target) found = true;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return found;
    }
}
