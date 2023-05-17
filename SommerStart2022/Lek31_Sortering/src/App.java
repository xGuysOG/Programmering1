import measure.SortMethods;
import application.model.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        System.out.println("Opgave 1 - BubbleSort");
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        System.out.println(Arrays.toString(s));
        SortMethods.bubbleSort(s);
        System.out.println(Arrays.toString(s));

        System.out.println();
        System.out.println("Opgave 2 - SelectionSort - String");

        s = new String[]{"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        System.out.println(Arrays.toString(s));
        SortMethods.selectionSort(s);
        System.out.println(Arrays.toString(s));

        System.out.println("Opgave 2 - SelectionSort - Customers");

        Customer c1 = new Customer("Arne", "jørgensen", 36);
        Customer c2 = new Customer("Bjarne", "Boense", 24);
        Customer c3 = new Customer("Dennis", "Arne", 30);
        Customer c4 = new Customer("Arne", "Fuck", 51);

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c2);
        customers.add(c1);
        customers.add(c3);
        customers.add(c4);

        System.out.println(customers);
        SortMethods.selectionSort(customers);
        System.out.println(customers);

        System.out.println();
        System.out.println("Opgave 3 - InsertionSort - String");
        s = new String[]{"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        System.out.println(Arrays.toString(s));
        SortMethods.insertionSort(s);
        System.out.println(Arrays.toString(s));

        System.out.println("Opgave 3 - InsertionSort - Customers");

        customers.set(0, c2);
        customers.set(1, c1);
        customers.set(2, c3);
        customers.set(3, c4);

        System.out.println(customers);
        SortMethods.insertionSort(customers);
        System.out.println(customers);

        System.out.println();
        System.out.println("Opgave 4 - Collections.sort - String");

        ArrayList<String> list = new ArrayList<String>();
        list.add("Jan");
        list.add("Bent");
        list.add("Thomas");
        list.add("Karsten");
        list.add("Dan");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        System.out.println("Opgave 4 - Collections.sort - Customer");

        customers.set(0, c2);
        customers.set(1, c1);
        customers.set(2, c3);
        customers.set(3, c4);

        System.out.println(customers);
        Collections.sort(customers);
        System.out.println(customers);

        s = new String[]{"e", "f", "a", "d", "b"};
        System.out.println(Arrays.toString(s));
        SortMethods.bubbleSort(s);
        System.out.println(Arrays.toString(s));
    }
}
