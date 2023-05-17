package Opgave5;
import java.util.Scanner;

public class EX73 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] counts = new int[49];

        System.out.print("Enter the integers between 1 and 50: ");
        int num = input.nextInt();
        if (num > 49) {
            System.out.println("The max input you can use is 49");
            return;
        }

        while (num != 0) {
            if (num >= 1 && num <= 49) {
                counts[num - 1]++;
            }
            num = input.nextInt();
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.println((i + 1) + " occurs " + counts[i] + " time" + (counts[i] > 1 ? "s" : ""));
            }
        }
    }
}