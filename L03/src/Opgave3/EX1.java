package Opgave3;

import java.util.Random;
import java.util.Scanner;

//Generate a lottery number (in 10..99)
//(as test, not in the finished program: Print the lottery number)
//Prompt the user for a guess of the lottery number
//Read the guess
//if (guess == lottery number)
//  print YOU WIN $10.000
//else if guess has the same digits as lottery number (in reversed order)
//  print YOU WIN $3.000
//else if guess has one of the digits in lottery number
//  print YOU WIN $1.000
//else
//  print SORRY, YOU LOOSE


public class EX1 {

    public static void main(String[] args) {
        Random r = new Random();
        int low = 10;
        int high = 99;
        int lotteryNumber = r.nextInt(high-low) + low;

        System.out.println("Please guess the lottery number");
        Scanner scanner = new Scanner(System.in);
        int guess = scanner.nextInt();
        if (guess == lotteryNumber) {
            System.out.println("YOU WIN $10.000");
        } else if (isReverse(guess, lotteryNumber)) {
            System.out.println("YOU WIN $3.000");
        } else if (hasValidNr(guess, lotteryNumber)) {
            System.out.println("YOU WIN $1.000");
        } else {
            System.out.println("SORRY, YOU LOOSE");
        }

    }

    public static boolean isReverse(int guess, int lotteryNumber) {
        int a = guess % 10;
        int b = guess / 10;
        String reverseString = "" + a +"" + b;
        System.out.println("xD " + reverseString);
        int reverseInt = Integer.parseInt(reverseString);
        if (lotteryNumber == reverseInt) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean hasValidNr(int guess, int lotteryNumber) {
        int a = guess % 10;
        int b = guess / 10;
        int a1 = lotteryNumber % 10;
        int b1 = lotteryNumber / 10;

        boolean oneDigigtFits =
                a1 == a ||
                        a1 == b ||
                        b1 == a ||
                        b1 == a1;
        return oneDigigtFits;

    }
}
