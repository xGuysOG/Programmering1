package Opgave3;

import java.lang.reflect.Array;
import java.time.YearMonth;
import java.util.Scanner;

public class E312 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 3 digigt nr");
        int nr = input.nextInt();
        String lenght = String.valueOf(nr);
        int length = lenght.length();
        if (length != 3) {
            System.out.println("Nr is not 3 digits long");
            return;
        }

        char[] digits1 = lenght.toCharArray();
        if (Array.getChar(digits1,0) == Array.getChar(digits1,2)) {
            System.out.println(nr + " is palindrome");
        } else {
            System.out.println(nr + " is not palindrome");
        }

    }
}
