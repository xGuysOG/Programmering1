package Opgave3;
import java.util.Scanner;
public class AscendingOrder {
    public static void main(String[] args) {
        System.out.println("Enter 1 digit");
        Scanner input = new Scanner(System.in);
        int digit1 = input.nextInt();
        System.out.println("Enther another digit");
        input = new Scanner(System.in);
        int digit2 = input.nextInt();
        System.out.println("Enter the last digit");
        input = new Scanner(System.in);
        int digit3 = input.nextInt();

        int temp;
        if (digit2 < digit1 || digit3 <digit1) {
            if (digit2 < digit1) {
                temp = digit1;
                digit1 = digit2;
                digit2 = temp;
            }

            if (digit3 < digit1) {
                temp = digit1;
                digit1 = digit3;
                digit3 = temp;
            }
        }
        if (digit3 < digit2) {
            temp = digit2;
            digit2 = digit3;
            digit3 = temp;
        }


        System.out.print("The tree digits now are " + digit1 + ", " + digit2 + ", " + digit3);

    }
}
