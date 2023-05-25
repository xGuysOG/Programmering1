package Opgaver;

public class EX2 {

//    Write a linear search method that finds the first number belonging to the interval [10;15]. The
//    method must return the number found in the interval, and take an array of integer numbers as
//    parameter. If a number in the interval is not found, the method must return -1.
//    Test the method.
//    If the array is [7, 56, 34, 3, 7, 14, 13, 4], the method should return 14.
    public static void main(String[] args) {
        int[] numbers = {7, 56, 34, 3, 7, 14, 13, 4};
        System.out.println("Yo data? " + linearSearchArrayWithinValue(numbers));
    }

    public static int linearSearchArrayWithinValue(int[] arr) {
        int indeks = -1;
        int i = 0;
        while (indeks == -1 && i < arr.length) {
            int k = arr[i];
            if (k >= 10 && k <= 15)
                indeks = k;
            else
                i++;
        }
        return indeks;
    }
}
