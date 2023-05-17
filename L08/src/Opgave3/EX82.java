package Opgave3;

import java.util.Scanner;

public class EX82 {
    public static void main(String[] args) {
        double[][] data = new double[4][4];
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 4 numbers");
        //now we get the input 4 times
        for (int i = 0; i < 4; i++) {
            data[0][i] = input.nextDouble();
        }

        System.out.print("Enter 4 numbers");
        //now we get the input 4 times
        for (int i = 0; i < 4; i++) {
            data[1][i] = input.nextDouble();
        }

        System.out.print("Enter 4 numbers");
        //now we get the input 4 times
        for (int i = 0; i < 4; i++) {
            data[2][i] = input.nextDouble();
        }

        System.out.print("Enter 4 numbers");
        //now we get the input 4 times1
        for (int i = 0; i < 4; i++) {
            data[3][i] = input.nextDouble();
        }
        print(data);
        System.out.println("The averageMajorDiagonal = " + averageMajorDiagonal(data));
    }
    public static double averageMajorDiagonal(double[][] m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        double average = sum / m.length;
        return average;
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
