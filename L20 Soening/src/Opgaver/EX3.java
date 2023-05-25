package Opgaver;

public class EX3 {

//    Exercise 3
//    Write a linear search method that returns true, if two adjacent numbers are the same. The
//    method must take an array of integer numbers as parameter.
//    Test the method.
//    If the array is [7, 9, 13, 7, 9, 13], the method must return false. If the array is [7, 9, 13, 13, 9,
//            7], the method must returns true.
//    Write another method that returns true, if the same number exists in n adjacent places. The
//    method must take an array of integer numbers and the number n as parameters.
//    Test the method.
    public static void main(String[] args) {
        int[] numbers = {7, 56, 34, 7, 7, 14, 13, 4};
        System.out.println("Yo is there adjeDup? " + hasAdjacentDuplicates(numbers));
    }

//    public static boolean hasAdjacentDuplicates(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] == arr[i + 1]) {
//                return true;
//            }
//        }
//        return false;
//    }
    public static boolean hasAdjacentDuplicates(int[] arr) {
        boolean found = false;
        int i = 0;
        while (!found && (i + 1) < arr.length) {
            int k = arr[i];
            if (arr[i] == arr[i + 1]) {
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }
}
