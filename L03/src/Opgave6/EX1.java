package Opgave6;

import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number ");

        int numb = input.nextInt();
        System.out.print("Answer is " + sign(numb));
    }

    public static String sign(int numb) {
        if (numb > 0) {
            return"Positiv";
        }
        else if (numb < 0) {
            return"Negativ";
        }
        else {
            return "0";
        }
    }

}
