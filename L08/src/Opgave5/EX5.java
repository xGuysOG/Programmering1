package Opgave5;

import java.util.Scanner;

public class EX5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] ints = new int[3];
        String[] strings = new String[3];
        System.out.println("Please enter a string and an int");
        strings[0] = input.next();
        ints[0] = input.nextInt();
        System.out.println("Please enter a string and an int");
        strings[1] = input.next();
        ints[1] = input.nextInt();
        System.out.println("Please enter a string and an int");
        strings[2] = input.next();
        ints[2]  = input.nextInt();
        printData(strings, ints);
    }

    public static int highestSalesNr(int[] ints) {
        int highest = 0;
        for(int i = 0; ints.length > i; i++) {
            if (ints[i] >= highest) {
                highest = ints[i];
            }
        }
        return highest;
    }

    public static void printData(String[] strings, int[] ints) {
        System.out.println("THE HIGHEST NUMBE ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS " + highestSalesNr(ints));
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + "        ");

            while(ints[i] >= 0) {
                System.out.print("*");
                ints[i]--;
            }
            System.out.println("");
        }

    }
}
