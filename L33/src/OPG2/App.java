package OPG2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        FindCommonNumbers("L33/src/OPG2/Heltal1.txt", "L33/src/OPG2/Heltal2.txt", "L33/src/OPG2/HeltalDone.txt");
    }

    public static void FindCommonNumbers(String fileName1, String fileName2, String finnishedFile){
        try {
        Scanner scanner1 = new Scanner(new File(fileName1));
        Scanner scanner2 = new Scanner(new File(fileName2));
        PrintWriter writer = new PrintWriter(new FileWriter(finnishedFile));

        int line1 = scanner1.nextInt();
        int line2 = scanner2.nextInt();
        while(line1 != 2147483647 && line2 != 2147483647) {
            if (line1 < line2) {
                writer.println(line1);
            } else if (line2 > line1) {
                writer.println(line2);
            } else {
                writer.println(line1);
            }
            System.out.println(line1);
            System.out.println(line2);
            line1 = scanner1.nextInt();
            line2 = scanner2.nextInt();
        }

        while (line1 != 2147483647) {
            writer.println(line1);
            line1 = scanner1.nextInt();
        }

        while (line2 != 2147483647) {
            writer.println(line2);
            line2 = scanner2.nextInt();
        }
        scanner1.close();
        scanner2.close();
        writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
