package Opgave3;

import java.util.ArrayList;

public class EX1 {
//    Write two insertion sort methods. The first must take an array String[] as parameter, the
//    second must take an ArrayList<Customer> as parameter. Make your own Customer class that
//has a compareTo(Customer): int method (you decide how customers are compared).
//    Test your methods.
public static void main(String[] args) {
    // Testing insertion sort for String[]
    String[] strings = {"banana", "apple", "grape", "cherry"};
    insertionSort(strings);
    for (String str : strings) {
        System.out.println(str);
    }

    // Testing insertion sort for ArrayList<Customer>
    ArrayList<Customer> customers = new ArrayList<>();
    customers.add(new Customer("Alice", 25));
    customers.add(new Customer("Bob", 35));
    customers.add(new Customer("Charlie", 20));
    customers.add(new Customer("David", 30));
    insertionSort(customers);
    for (Customer customer : customers) {
        System.out.println(customer);
    }
}


    public static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String temp = arr[i];
            int j = i;
            while (j > 0 && temp.compareTo(arr[j - 1]) < 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void insertionSort(ArrayList<Customer> customers) {
        for (int i = 1; i < customers.size(); i++) {
            Customer temp = customers.get(i);
            int j = i;
            while (j > 0 && temp.compareTo(customers.get(j - 1)) < 0) {
                customers.set(j, customers.get(j - 1));
                j--;
            }
            customers.set(j, temp);
        }
    }
}
