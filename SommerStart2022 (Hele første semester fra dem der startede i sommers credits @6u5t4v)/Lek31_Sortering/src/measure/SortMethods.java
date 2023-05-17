package measure;

import application.model.Customer;

import java.util.ArrayList;
import java.util.Collections;

public class SortMethods {
    public static void bubbleSort(String[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String next = array[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(array[j - 1]) >= 0) {
                    found = true;
                } else {
                    array[j] = array[j - 1];
                    j--;
                }
            }
            array[j] = next;
        }
    }

    public static void insertionSort(Customer[] array) {
        for (int i = 1; i < array.length; i++) {
            Customer next = array[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(array[j - 1]) >= 0) {
                    found = true;
                } else {
                    array[j] = array[j - 1];
                    j--;
                }
            }
            array[j] = next;
        }
    }

    public static void insertionSort(ArrayList<Customer> array) {
        for (int i = 1; i < array.size(); i++) {
            Customer next = array.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                Customer k = array.get(j - 1);
                if (next.compareTo(k) >= 0) {
                    found = true;
                } else {
//                    array[j] = array[j - 1];
                    array.set(j, k);
                    j--;
                }
            }
//            array[j] = next;
            array.set(j, next);
        }
    }

    public static void selectionSort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minPos]) < 0) {
                    minPos = j;
                }

            }
            swap(array, i, minPos);
        }
    }

    public static void selectionSort(ArrayList<Customer> array) {
        for (int i = 0; i < array.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j).compareTo(array.get(minPos)) < 0) {
                    minPos = j;
                }

            }

            Collections.swap(array, i, minPos);
//            Customer temp = array.get(i);
//            array.set(i, array.get(minPos));
//            array.set(minPos, temp);
        }
    }

    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private static void swap(Customer[] list, int i, int j) {
        Customer temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
