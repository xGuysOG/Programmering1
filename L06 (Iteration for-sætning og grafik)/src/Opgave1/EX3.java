package Opgave1;

import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) {
        System.out.print("Enter 2 numbers ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println("reulst is " +sumEventsInts(a,b));
    }

    public static int sumEventsInts(int a, int b) {
        int finalInt = 0;
        // 7 - 24
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        for(int i = a; a <= b; a++) {
            if ((a % 2) == 0) {
                finalInt = finalInt + a;
            }
        }
        return finalInt;
    }
}
