package Opgave1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File file = new File("L28/src/Opgave1/nummer.txt");
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextInt()){
                System.out.println(scanner.nextInt() * 2);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
