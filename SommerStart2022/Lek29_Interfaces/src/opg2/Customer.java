package opg2;

public class Customer implements Comparable<Customer> {
    private String firstName, lastName;
    private int age;

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Customer o) {
        int comp = lastName.compareTo(o.getLastName());
        if (comp == 0) {
            comp = firstName.compareTo(o.getFirstName());

            if (comp == 0) {
                comp = age - o.getAge();
            }
        }


        return comp;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
