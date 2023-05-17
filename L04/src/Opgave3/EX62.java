package Opgave3;

import java.util.Scanner;

public class EX62 {
//    (Sum the digits in an integer) Write a method that computes the sum of the digits in an integer. Use the following method header:
//    public static int sumDigits(long n)
//    For example, sumDigits(234) returns 9 (= 2 + 3 + 4). (Hint: Use the % op-erator to extract digits and the / operator to remove the extracted digit.
//    For in-stance, to extract 4 from 234, use 234 % 10 (= 4). To remove 4 from 234, use 234 / 10 (= 23). Use a loop to repeatedly extract and remove the
//    digit until all the digits are extracted. Write a test program that prompts the user to enter an integer then displays the sum of all its digits
    public static void main(String[] args) {
        System.out.print("Enter a number ");
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        System.out.println("Summ of the odd digits is " + sumOddDigits(a));
    }


    public static long sumOddDigits(long n) {
        long lenght = String.valueOf(n).length();
        long temp = 0;
        long sum = 0;
        while (n > 0) {
            temp = 0;
            temp = n % 10;
            System.out.println("Temp " + temp);
            n /= 10;
            System.out.println("n " + n);
            if (temp % 2 != 0) {
                System.out.println("adding temp to sum " + temp + " sum " + sum);
                sum += temp;
                System.out.println("adding temp to sum " + temp + " sum " + sum);
            }
        }
        return sum;
    }
}
