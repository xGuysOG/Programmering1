package Opgave2;

public class Customer implements Comparable<Customer> {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Customer other) {
        // Compare customers based on their age
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", age=" + age + "]";
    }
}