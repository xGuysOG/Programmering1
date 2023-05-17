package Opgave4;
import java.util.Scanner;

public class EX26 {
//	(Sum the digits in an integer) Write a program that reads an integer between 0 and 1000
//	and adds all the digits in the integer. For example, if an integer is 932, the sum of all its
//	digits is 14. Hint: Use the % operator to extract digits, and use the / operator to remove
//	the extracted digit. For instance, 932 % 10 = 2 and 932 / 10 = 93. Here is a sample run:

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000: ");
        int number = input.nextInt();
        String numberString = Integer.toString(number);
        char[] digits = numberString.toCharArray();
        int finalNumber = 0;
        for (char c : digits) {
            int charToInt = Character.getNumericValue(c);
            System.out.println("Char is " + c);
            finalNumber = finalNumber + charToInt;
        }
        System.out.print("Enter final number is " + finalNumber);
    }


}
