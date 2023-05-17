package Opgave5;
import java.util.Scanner;

public class EX75 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num, evenCount = 0, oddCount = 0;

        System.out.print("Enter ten integers (input ends with 0): ");
        do {
            num = input.nextInt();
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        } while (num != 0);

        System.out.println("The number of even numbers: " + evenCount);
        System.out.println("The number of odd numbers: " + oddCount);
    }
}
