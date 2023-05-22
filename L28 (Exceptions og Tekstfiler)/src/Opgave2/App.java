package Opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File file = new File("L28/src/Opgave2/nummer.txt");
        ArrayList<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextInt()){
                numbers.add(scanner.nextInt());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.println(numbers.get(i));
        }
    }
}
