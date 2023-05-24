package Opgave1;

import java.util.ArrayList;

public class EX1 {

//    Exercise 1
//    In this exercise you are going to merge two lists of Customer objects.
//            a) Make a Customer class that implements Comparable<Customer>. Customers are ordered
//            by last name and then first name.
//    b) Program the following method (use a total merging) in a class with a main() method:
//    /**
//     * Return a sorted list containing all customers
//     * from the lists l1 and l2.
//     * Pre: l1 and l2 are sorted.
//     */
//    public static ArrayList<Customer> mergeAllCustomers (
//            ArrayList<Customer> l1, ArrayList<Customer> l2) {...}
//    c) Test the method mergeAllCustomers() in the main() method (remember that the lists used
//            as parameters must be sorted).
public static void main(String[] args) {
    ArrayList<Customer> l1 = new ArrayList<>();
    l1.add(new Customer("John", "Doe"));
    l1.add(new Customer("Alice", "Smith"));
    l1.add(new Customer("Bob", "Johnson"));

    ArrayList<Customer> l2 = new ArrayList<>();
    l2.add(new Customer("Alice", "Johnson"));
    l2.add(new Customer("Charlie", "Brown"));
    l2.add(new Customer("David", "Davis"));

    ArrayList<Customer> merged = mergeAllCustomers(l1, l2);

    for (Customer customer : merged) {
        System.out.println(customer.getLastName() + ", " + customer.getFirstName());
    }
}

    /**
     * Return a sorted list containing all customers
     * from the lists l1 and l2.
     * Pre: l1 and l2 are sorted.
     */
    public static ArrayList<Customer> mergeAllCustomers(ArrayList<Customer> l1, ArrayList<Customer> l2) {
        ArrayList<Customer> mergedList = new ArrayList<>();

        int i = 0; // Index for l1
        int j = 0; // Index for l2

        while (i < l1.size() && j < l2.size()) {
            Customer customer1 = l1.get(i);
            Customer customer2 = l2.get(j);

            if (customer1.compareTo(customer2) < 0) {
                mergedList.add(customer1);
                i++;
            } else {
                mergedList.add(customer2);
                j++;
            }
        }

        // Add remaining elements from l1, if any
        while (i < l1.size()) {
            mergedList.add(l1.get(i));
            i++;
        }

        // Add remaining elements from l2, if any
        while (j < l2.size()) {
            mergedList.add(l2.get(j));
            j++;
        }

        return mergedList;
    }

}
