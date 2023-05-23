package Opgave1;

public class EX1 {
    //Write a linear search method that returns, whether an uneven number exists in an array. The
    //method must return true or false, and take an array of integer numbers as parameter.
    //Test the method.
    public static void main(String[] args) {
        int[] numbers = {12, 4, 8, 2, 4, 24, 14, 8, 10};
        System.out.println("yo does it have negativ? " + linearSearchArrayUneven(numbers));
    }

    public static boolean linearSearchArrayUneven(int[] arr) {
        boolean found = false;
        int i = 0;
        while (!found && i < arr.length) {
            int k = arr[i];
            if (k % 2 == 1)
                found = true;
            else
                i++;
        }
        return found;
    }
}
