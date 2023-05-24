package Opgave6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class EX1 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] ints = random.ints(1000, 1, 10000).toArray();
        ArrayList<Integer> numbers1 = new ArrayList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();
        ArrayList<Integer> numbers3 = new ArrayList<>();
        ArrayList<Integer> numbers4 = new ArrayList<>();

        for (int e : ints) {
            numbers1.add(e);
            numbers2.add(e);
            numbers3.add(e);
            numbers4.add(e);
        }

        long startTime, endTime, elapsedTime;

        System.out.println("Size " + numbers1.size());
        // Bubble Sort
        startTime = System.currentTimeMillis();
        bubbleSort(numbers1);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Bubble Sort Execution Time: " + elapsedTime + " milliseconds");

        // Selection Sort
        startTime = System.currentTimeMillis();
        selectionSort(numbers2);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Selection Sort Execution Time: " + elapsedTime + " milliseconds");

        // Insertion Sort
        startTime = System.currentTimeMillis();
        insertionSort(numbers3);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Insertion Sort Execution Time: " + elapsedTime + " milliseconds");

        // collections Sort
        startTime = System.currentTimeMillis();
        Collections.sort(numbers4);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Collections Sort Execution Time: " + elapsedTime + " milliseconds");
    }

    public static void bubbleSort(ArrayList<Integer> arr) {
        int n = arr.size();
        boolean isSorted = false;
        int temp = 0;
        for (int i = n - 1; i > 0; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void selectionSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);
            }
        }
    }

    public static void insertionSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 1; i < n; i++) {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
        }
    }
}
