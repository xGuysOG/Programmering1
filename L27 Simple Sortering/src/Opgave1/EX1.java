package Opgave1;

import java.util.ArrayList;

public class EX1 {
//    Write a bubble sort method that can sort an ArrayList<String> containing strings.
//    Test your method in a test class with a main method.

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Apple");
        strings.add("Orange");
        strings.add("Banana");
        strings.add("Pineapple");
        strings.add("Mango");

        System.out.println("Before sorting: " + strings);

        bubbleSort(strings);

        System.out.println("After sorting: " + strings);
    }



    public static void bubbleSort(ArrayList<String> list) {
        int n = list.size();

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                String current = list.get(j);
                String next = list.get(j + 1);
                if (current.compareTo(next) > 0) {
                    // Swap elements
                    list.set(j, next);
                    list.set(j + 1, current);
                }
            }
        }
    }

}
