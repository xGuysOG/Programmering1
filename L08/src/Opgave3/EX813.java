package Opgave3;

import java.util.Scanner;

public class EX813 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of rows and colums of the array: ");
        int x = input.nextInt();
        int y = input.nextInt();

        // create array
        double[][] numbers = new double[x][y];

        //now we want to add numbers
        for (int i = 0; i < x; i++) {
            System.out.print("Enter " + y + " numbers");
            for (int i2 = 0; i2 < y; i2++) {
                numbers[i][i2] = input.nextDouble();
            }
        }
        print(numbers);
        int[] smallestCache = locateSmallest(numbers);
        System.out.println("The smallest element is = " + getValueAt(numbers, smallestCache[0], smallestCache[1]) + " and is located at (" + smallestCache[0] + ", " + smallestCache[1] + ")");

    }
    public static int[] locateSmallest(double[][] a) {
        double value = Double.MAX_VALUE;
        int[] cache = new int[2];
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                if (a[row][col] < value) {
                    value = a[row][col];
                    cache[0] = row;
                    cache[1] = col;
                }
            }
        }
        return cache;
    }

    public static double getValueAt(double[][] numbers, int row, int col) {
        return numbers[row][col];
    }

    public static void print(double[][] numbers) {
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                System.out.print(numbers[row][col] + "  ");
            }
            System.out.println();
        }
    }
}
