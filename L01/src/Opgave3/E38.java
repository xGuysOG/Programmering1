package Opgave3;

import java.util.ArrayList;
import java.util.Scanner;

public class E38 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer");
        int int1 = input.nextInt();
        System.out.print("Enter another integer");
        int int2 = input.nextInt();
        System.out.print("Enter a third integer");
        int int3 = input.nextInt();
        //int1 = 10, int2 = 5, int3 = 15;
        int temp;
        if (int2 < int1 || int3 < int1) {
            if (int2 < int1) {
                temp = int1;
                int1 = int2;
                int2 = temp;
            }
            if (int3 < int1) {
                temp = int1;
                int1 = int3;
                int3 = temp;
            }
        }
        if (int3 < int2) {
            temp = int2;
            int2 = int3;
            int3 = temp;
        }
        System.out.println("ints " + int1 + ", " + int2 + ", " + int3);
    }
}
