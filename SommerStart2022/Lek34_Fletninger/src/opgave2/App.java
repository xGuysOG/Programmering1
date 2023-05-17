package opgave2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 10, 12, 14}, arr2 = {1, 2, 4, 5, 6, 9, 12, 17};

        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));

        int[] result = commonNumber(arr1, arr2);
        System.out.println("Result: " + Arrays.toString(result));
    }

    public static int[] commonNumber(int[] l1, int[] l2) {
        int i1 = 0;
        int i2 = 0;
        int j = 0;

        int[] result = new int[l1.length + l2.length];

        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] < l2[i2]) {
                i1++;
            } else if (l1[i1] > l2[i2]) {
                i2++;
            } else {
                result[j] = l1[i1];
                i1++;
                i2++;
                j++;
            }
        }

        int[] finalResult = new int[j];
        System.arraycopy(result, 0, finalResult, 0, j);

        return finalResult;
    }
}
