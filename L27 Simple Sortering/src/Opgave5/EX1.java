package Opgave5;

import Opgave2.Customer;

import java.util.ArrayList;
import java.util.Collections;

public class EX1 {
//    The sort() method in java.util.Collections is used to sort ArrayLists containing objects that
//implements the Comparable interface.
//    Here is an example of the use of the method:
//    public class Test {
//        public static void main(String[] args) {
//            ArrayList<String> list = new ArrayList<String>();
//// Add some strings to list here
//            System.out.println(list); // print the list before sorting
//            Collections.sort(list);
//            System.out.println(list); // print the list after sorting
//        }
//    }
//    Run the program and look at the output.
//    Change the program to sort an ArrayList<Customer> containing customers from a Customer
//    class that implements Comparable<Customer>.
public static void main(String[] args) {
    ArrayList<Customer> customers = new ArrayList<>();

    // Add some customers to the list
    customers.add(new Customer("John", 25));
    customers.add(new Customer("Alice", 30));
    customers.add(new Customer("Bob", 20));

    System.out.println(customers); // Print the list before sorting

    Collections.sort(customers);

    System.out.println(customers); // Print the list after sorting
}
}
