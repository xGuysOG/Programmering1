package opg2;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Customer c1 = new Customer("Arne", "jørgensen", 36);
        Customer c2 = new Customer("Bjarne", "Boense", 24);
        Customer c3 = new Customer("Dennis", "Arne", 30);
        Customer c4 = new Customer("Arne", "Fuck", 51);

        Customer[] customers = new Customer[4];
        customers[0] = c1;
        customers[1] = c2;
        customers[2] = c3;
        customers[3] = c4;

        System.out.println(lastCustomer(customers));
        System.out.println(Arrays.toString(afterCustomer(customers, c2)));
    }

    public static Customer lastCustomer(Customer[] customers) {
        Customer last = customers[0];

        for (int i = 1; i < customers.length; i++) {
            Customer current = customers[i];

            if (current.compareTo(last) > 0) {
                last = current;
            }
        }

        return last;
    }

    public static Customer[] afterCustomer(Customer[] customers, Customer customer) {
        ArrayList<Customer> list = new ArrayList<>();
        boolean found = false;

        for (Customer current : customers) {
            if (found) {
                list.add(current);
            }

            if (current.equals(customer)) {
                found = true;
            }
        }

        return list.toArray(new Customer[0]);
    }
}
