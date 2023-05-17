package opg3.model;

public abstract class Employee extends Person {

    private double hourlyWage;

    public Employee(String name, String adress, double hourlyWage) {
        super(name, adress);
        this.hourlyWage = hourlyWage;
    }

    public abstract double calculateSalary();

    protected double getHourlyWage() {
        return hourlyWage;
    }
}
