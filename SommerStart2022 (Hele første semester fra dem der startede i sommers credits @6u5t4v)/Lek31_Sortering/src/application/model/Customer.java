package application.model;

public class Customer implements Comparable<Customer> {
    private String lastName;
    private String firstName;
    private int age;

    public Customer(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    @Override
    public int compareTo(Customer customer) {
        int comp = lastName.compareTo(customer.getLastName());
        if (comp == 0) {
            comp = firstName.compareTo(customer.getFirstName());
            if (comp == 0) {
                comp = age - customer.getAge();
            }
        }
        return comp;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + age;
    }
}
