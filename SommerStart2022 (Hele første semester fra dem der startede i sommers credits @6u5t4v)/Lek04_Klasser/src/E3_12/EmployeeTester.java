package E3_12;

public class EmployeeTester {
    public static void main(String[] args) {
        Employee testPerson = new Employee("Test Person",50000);
        testPerson.raiseSalary(10);

        System.out.println("Expected 55000");
        System.out.println(testPerson.getSalary());
    }
}
