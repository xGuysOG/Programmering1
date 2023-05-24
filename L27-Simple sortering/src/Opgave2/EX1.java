package Opgave2;

import java.util.ArrayList;

public class EX1 {

//    Write two selection sort methods. The first must take an array String[] as parameter, the
//    second must take an ArrayList<Customer> as parameter. Make your own Customer class that
//has a compareTo(Customer): int method (you decide how customers are compared).
//    Test your methods.
public static void main(String[] args) {
    // Example with String[]
    String[] strings = {"Apple", "Orange", "Banana", "Pineapple", "Mango"};

    System.out.println("Before sorting: ");
    for (String str : strings) {
        System.out.println(str);
    }

    selectionSort(strings);

    System.out.println("After sorting: ");
    for (String str : strings) {
        System.out.println(str);
    }

    System.out.println();

    // Example with ArrayList<Customer>
    ArrayList<Customer> customers = new ArrayList<>();
    customers.add(new Customer("John", 25));
    customers.add(new Customer("Alice", 32));
    customers.add(new Customer("Bob", 19));
    customers.add(new Customer("Emily", 41));

    System.out.println("Before sorting: ");
    for (Customer customer : customers) {
        System.out.println(customer);
    }

    selectionSort(customers);

    System.out.println("After sorting: ");
    for (Customer customer : customers) {
        System.out.println(customer);
    }
}

    public static void selectionSort(String[] arr){
        int indexOfMin = 0;
        String temp = "";
        for (int i = 0; i < arr.length - 1; i++) {
            indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                temp = arr[i];
                arr[i] = arr[indexOfMin];
                arr[indexOfMin] = temp;
            }
        }
    }

    //we sort based on age here
    public static void selectionSort(ArrayList<Customer> customers) {
        int n = customers.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (customers.get(j).compareTo(customers.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            Customer temp = customers.get(i);
            customers.set(i, customers.get(minIndex));
            customers.set(minIndex, temp);
        }
    }
    public static void selectionSort(int[] arr) {
// arr has a sorted part followed by an unsorted part
// i is the index of the first number in the unsorted part
        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                int temp = arr[i];
                arr[i] = arr[indexOfMin];
                arr[indexOfMin] = temp;
            }
        }
    }
}
