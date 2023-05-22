import measure.SortMethods;
import application.model.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class Opg1 {
    public static void main(String[] args) {
        Customer c1 = new Customer("Arne", "jørgensen", 36);
        Customer c2 = new Customer("Bjarne", "Boense", 24);
        Customer c3 = new Customer("Dennis", "Arne", 30);
        Customer c4 = new Customer("Arne", "Fuck", 51);

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);

//        opgave1(customers);

//        opgave2();

        opgave3("Jubiiii", 4);
        opgave3("Jubiiii", 5);
        opgave3("Jubiiiiiii", 5);
        opgave3("Jubi", 2);
        opgave3("Jubi", 1);
    }

    private static void opgave1(ArrayList<Customer> arrayList) {
        System.out.println("usorteret:" + arrayList);

        SortMethods.insertionSort(arrayList);

        System.out.println("Sorteret: " + arrayList);

        Customer c5 = new Customer("aGustav", "aBruh", 38);
        indsætKunde(arrayList, c5);

        System.out.println("Indsættet ny kunde: " + arrayList);
    }

    private static void opgave2() {
        Customer[] customers = new Customer[5];

        customers[0] = new Customer("Arne", "Fuck", 51);
        customers[1] = new Customer("Arne", "jørgensen", 36);
        customers[2] = new Customer("Bjarne", "Boense", 24);
        customers[3] = new Customer("Dennis", "Arne", 30);
        customers[4] = null;

        System.out.println("Sorteret: " + Arrays.toString(customers));

        Customer customer = new Customer("Arne", "lruh", 38);
        indsætKunde(customers, customer);
        System.out.println("Indsættet ny kunde: " + Arrays.toString(customers));

    }

    private static void opgave3(String sm, int repeat) {
        System.out.println("Søg " + repeat + " gentagelser i \"" + sm + "\"");
        System.out.println(kens(sm, repeat));
    }

    public static void indsætKunde(ArrayList<Customer> list, Customer e) {
        boolean found = false;
        int i = 0;
        while (!found && i < list.size()) {
            if (list.get(i).compareTo(e) > 0) {
                found = true;
            } else {
                i++;
            }
        }
        list.add(i, e);
    }

    public static void indsætKunde(Customer[] tabel, Customer e) {
        int j = tabel.length - 1;
        while (j >= 0 && tabel[j] == null) {
            j--;
        }
        j++;
        boolean found = false;
        while (!found && j > 0) {
            Customer k = tabel[j - 1];
            if (e.compareTo(k) > 0) {
                found = true;
            } else {
                tabel[j] = tabel[j - 1];
                j--;
            }
        }
        tabel[j] = e;
    }

    private static boolean kens(String sm, int repeat) {
        int i = 0;
        boolean found = false;

        while (!found && i <= sm.length() - repeat) {
            if (countRepeated(sm, sm.charAt(i), i) >= repeat) {
                found = true;
            }

            i++;
        }

        return found;
    }


    private static int countRepeated(String sm, char c, int i) {
        int occured = 0;
        int j = 0;
        boolean diff = false;

        while (!diff && (j + i) < sm.length()) {
            if (sm.charAt(j + i) == c) {
                occured++;
            } else {
                diff = true;
            }

            j++;
        }

        return occured;
    }
}
