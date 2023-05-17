package Opgave2;

import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {
        System.out.print("Enter 2 numbers ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println("reulst is " +sumEventsInts(a,b));
    }

    public static int sumEventsInts(int a, int b) {
        int finalInt = 0;
        while (a <= b) {
            if ((a % 2) == 0) {
                finalInt = finalInt + a;
            }
            a++;
        }
        return finalInt;
    }
}
