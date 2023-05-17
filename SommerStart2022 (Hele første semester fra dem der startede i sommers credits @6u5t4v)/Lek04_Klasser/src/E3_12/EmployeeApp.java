package E3_12;

public class EmployeeApp {
    public static void main(String[] args) {
        Employee harry = new Employee("Harry", 4000);
        harry.raiseSalary(10);
        System.out.println("New Salary: " + harry.salary);
    }
}
