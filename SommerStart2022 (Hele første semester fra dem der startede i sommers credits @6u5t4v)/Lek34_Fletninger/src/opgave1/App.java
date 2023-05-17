package opgave1;

import helper.Randomizer;
import measure.SortMethods;
import application.model.Customer;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Customer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list1.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));

        SortMethods.insertionSort(list1);

        list2.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list2.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));
        list2.add(new Customer(Randomizer.getRandomLastName(), Randomizer.getRandomFirstName(), Randomizer.randomAge()));

        SortMethods.insertionSort(list2);


        System.out.println("Liste 1: " + list1);
        System.out.println("Liste 2: " + list2);

        ArrayList<Customer> result = fletAlleKunder(list1, list2);
        System.out.println("Result: " + result);
    }

    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * kunder fra både l1 og l2
     * Krav: l1 og l2 er sorterede
     */
    public static ArrayList<Customer> fletAlleKunder(ArrayList<Customer> l1,
                                                     ArrayList<Customer> l2) {
        ArrayList<Customer> result = new ArrayList<>();

        int i1 = 0, i2 = 0;

        while (i1 < l1.size() && i2 < l2.size()) {
            Customer e1 = l1.get(i1);
            Customer e2 = l2.get(i2);

            if (e1.compareTo(e2) <= 0) {
                result.add(e1);
                i1++;
            } else {
                result.add(e2);
                i2++;
            }
        }

        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }

        while (i2 < l2.size()) {
            result.add(l2.get(i2));
            i2++;
        }

        return result;
    }
}
