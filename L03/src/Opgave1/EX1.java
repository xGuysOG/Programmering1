package Opgave1;

import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number ");

        int numb = input.nextInt();
        if (numb > 0) {
            System.out.print("Positiv");
        }
        else if (numb < 0) {
            System.out.print("Negativ");
        }
        else {
            System.out.print("0");
        }
    }

}
