package Opgave6;
import java.util.Arrays;

public class Ex7Test {
    public static void main(String[] args) {
        int[] test = {1, 3, 3, 4};
//    	switchFirstAndLast(test);
//    	replaceEvenWithZero(test);
        shiftArrayElements(test);
        System.out.println("result is " + hasDoublets(test));

    }

    public static void switchFirstAndLast(int[] arr) {
        if (arr.length < 2) {
            // nothing to switch if array has less than 2 elements
            return;
        }

        // swap first and last elements
        int temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
    }

    public static void replaceEvenWithZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = 0;
            }
        }
    }

    public static int getSecondHighest(int[] arr) {
        if (arr.length < 2) {
            // array must have at least two elements
            return 0;
        }

        int highest = 0;
        int secondHighest = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > highest) {
                secondHighest = highest;
                highest = arr[i];
            } else if (arr[i] > secondHighest && arr[i] != highest) {
                secondHighest = arr[i];
            }
        }

        return secondHighest;
    }

    public static boolean isSortedAscending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void shiftArrayElements(int[] arr) {
        int temp = arr[arr.length-1];
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

    public static boolean hasDoublets(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
