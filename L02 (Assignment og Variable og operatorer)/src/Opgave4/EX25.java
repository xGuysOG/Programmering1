package Opgave4;
import java.util.Scanner;

public class EX25 {
    //	 (Financial application: calculate tips) Write a program that reads the subtotal and
//	 the gratuity rate and then computes the gratuity and total. For example, if the user
//	 enters 10 for subtotal and 12% for gratuity rate, the program displays $1.2 as gratuity and
//	 $11.2 as total. Here is a sample run:
    public static void main(String[] args) {
        System.out.println("Enter subtotal and gratuity rate");
        Scanner input = new Scanner(System.in);
        double subtotal = input.nextDouble();
        double gratuityRate = input.nextDouble();

        double gratuity = subtotal * (gratuityRate/100);
        double total = subtotal + gratuity;
        System.out.println("gratuity is " + gratuity + " total is " + total);
    }

}
