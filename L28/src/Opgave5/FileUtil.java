package Opgave5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {
    public static int max(String filename) throws IOException {
        File file = new File(filename);
        int max = Integer.MIN_VALUE;
        int temp = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                temp = scanner.nextInt();
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public static int min(String filename) throws IOException {
        File file = new File(filename);
        int min = Integer.MAX_VALUE;
        int temp = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                temp = scanner.nextInt();
                if (temp < min) {
                    min = temp;
                }
            }
        }
        return min;
    }

    public static double average(String filename) throws IOException {
        File file = new File(filename);
        double amount = 0;
        double total = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                amount++;
                total += scanner.nextInt();
            }
        }
        System.out.println("total " + total);
        return total/amount;
    }
}
