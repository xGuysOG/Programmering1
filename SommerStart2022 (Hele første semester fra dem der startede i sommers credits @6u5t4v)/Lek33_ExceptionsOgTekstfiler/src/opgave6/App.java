package opgave6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

    }

    public static int max(String filename) throws IOException {
        File file = new File(filename);

        int max = 0;
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextInt()) {

            }
        }

        return max;
    }
}
