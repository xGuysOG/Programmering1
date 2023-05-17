package opgave3;

import helper.Randomizer;
import measure.SortMethods;
import application.model.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        // Bad customers
        Customer c1 = new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge());
        Customer c2 = new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge());
        Customer c3 = new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge());
        Customer c4 = new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge());

        ArrayList<Customer> list1 = new ArrayList<>();
        list1.add(c1);
        list1.add(c2);
        list1.add(c3);
        list1.add(c4);
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        Collections.sort(list1);

        Customer[] badBoys = new Customer[]{c1, c2, c3, c4};
        SortMethods.insertionSort(badBoys);

        System.out.println("List: (" + list1.size() + ")" + list1);
        System.out.println("Array: (" + badBoys.length + ")" + Arrays.toString(badBoys));

        ArrayList<Customer> result = goodCustomers(list1, badBoys);
        System.out.println("Result: (" + result.size() + ")" + result);
    }

    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * customers fra l1 der ikke er i l2
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */
    public static ArrayList<Customer> goodCustomers(ArrayList<Customer> l1,
                                                    Customer[] l2) {
        ArrayList<Customer> result = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.length) {
            if (l1.get(i1).compareTo(l2[i2]) > 0) {
                result.add(l1.get(i1));
                i1++;
            } else if (l1.get(i1).compareTo(l2[i2]) < 0) {
                result.add(l2[i2]);
                i2++;
            } else {
                i1++;
                i2++;
            }
        }

        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }

        return result;
    }
}
