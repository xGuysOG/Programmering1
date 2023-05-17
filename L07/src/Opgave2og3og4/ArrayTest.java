package Opgave2og3og4;


import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of items (>= 1): ");
        int n = input.nextInt();

        // create array
        int[] numbers = new int[n];
        // print array

        // fill array with numbers
        System.out.print("Enter " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt();
        }

        System.out.println("Aight true = has uneven false = has even " + hasUneven(numbers));

//        System.out.print("Enter the number of items (>= 1): ");
//        int n2 = input.nextInt();
//
//        // create array
//        int[] numbers2 = new int[n2];
//        // print array
//
//        // fill array with numbers
//        System.out.print("Enter " + n2 + " numbers: ");
//        for (int i = 0; i < n; i++) {
//            numbers2[i] = input.nextInt();
//        }
//        // print array
//        System.out.println("\tSum of numbers is  " + Arrays.toString(sumUnEvenArrays(numbers, numbers2)));
    }
    public static int sum(int[] t) {
        int sums = 0;
        for (int i = 0; i < t.length; i++) {
            sums += t[i];
        }
        return sums;
    }

    public static double sum(double[] t) {
        double sums = 0;
        for (int i = 0; i < t.length; i++) {
            sums += t[i];
        }
        return sums;
    }
    public static int[] sumUnEvenArrays(int[] a, int[] b) {
        int[] min;
        int[] max;
        if (a.length > b.length) {
            min = b;
            max = a;
            System.out.println("xD1" + " " + max.length + " also min " + min.length);
        } else {
            min = a;
            max = b;
            System.out.println("xD2" + " " + max.length + " also min " + min.length);
        }
        System.out.println("Max is " + max.length);
        int[] result = new int[max.length];
        for (int i = 0; i < max.length; i++) {
            int sum = 0;
            if (i < a.length) {
                sum += a[i];
            }
            if (i < b.length) {
                sum += b[i];
            }
            result[i] = sum;
        }
        return result;
    }

    public static int[] sumArrays(int[] a, int[] b) {
        int[] numbers = new int[a.length];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            numbers[i] = a[i] + b[i];
        }
        return numbers;
    }

    public static boolean hasUneven(int[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.println("xD2" + " " + t[i] + " also ");
            if (t[i] % 2 != 0) {
                System.out.println("Un even");
                return true;
            }
        }
        System.out.println("Un Even");
        return false;
    }

}
