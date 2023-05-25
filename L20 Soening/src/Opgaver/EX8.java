package Opgaver;

public class EX8 {

//    Write a linear search method that finds a number in an array. If the number does not exists the
//    method returns -1. If the number is found, it should swap place with the number before, and
//return the new index of the number. In case the number is found on index 0, it should not
//    swap place, but just return 0.
//    Example:
//    Array before searching for 13:
//            6 4 8 13 7
//    Array after searching 13:
//            6 4 13 8 7
//    In this case the method returns 2.
//    Repeat the exercise with an ArrayList instead of an array.
public static void main(String[] args) {
    int[] arr = {6, 4, 8, 13, 7};
    int target = 13;

    System.out.println("Array before searching for " + target + ":");
    for (int num : arr) {
        System.out.print(num + " ");
    }

    System.out.println();
    int resultIndex = searchAndSwap(arr, target);

    System.out.println("Array after searching " + target + ":");
    for (int num : arr) {
        System.out.print(num + " ");
    }

    System.out.println("\nIn this case, the method returns: " + resultIndex);
}

    public static int searchAndSwap(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (i != 0) {
                    //If the number is found, it should swap place with the number before, and
                    //return the new index of the number
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    return i - 1;
                } else {
                    //In case the number is found on index 0, it should not
                    //swap place, but just return 0.
                    return 0;
                }
            }
        }
        return -1;
    }


}
