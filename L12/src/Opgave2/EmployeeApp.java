package Opgave2;

public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Hans Jensen", true, 18);
        System.out.println("Test: " + e1);
        System.out.println();

        System.out.println("Name: " + e1.name);
        System.out.println("Trainee? " + e1.trainee);
        System.out.println("Age " + e1.age);
        e1.birthday();
        
        System.out.println("Age " + e1.age);
        System.out.println();

        e1.trainee = false;
        e1.printEmployee();
        System.out.println();
    }
}
