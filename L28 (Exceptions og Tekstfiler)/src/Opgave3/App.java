package Opgave3;

import java.io.File;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) {
        File file = new File("L28/src/Opgave3/numbers.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            for (int i = 0; i < 100; i += 3) {
                if (i % 2 != 0) {
                    out.println(i);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
