package Opgave2;

public class Employee {
    // The name of the employee.
    String name;
    // Whether the employee is a trainee or not.
    boolean trainee;
    // age
    int age;

    /** Create an employee. */
    public Employee(String name, boolean trainee, int age) {
        this.name = name;
        this.trainee = true;
        this.age = age;
    }
    
    public void birthday() {
    	age++;
    }

    @Override
    public String toString() {
        return String.format("Employee(%s, %s, %s)", name, trainee, age);
    }

    /** Print a description of the employee. */
    public void printEmployee() {
    	String[] splited = name.split(" ");
        System.out.println("*******************");
        System.out.println("First Name: " + splited[0]);
        System.out.println("Last Name: " + splited[1]);
        System.out.println("Age: " + age);
        System.out.println("Trainee: " + trainee);
        System.out.println("*******************");
    }
}
