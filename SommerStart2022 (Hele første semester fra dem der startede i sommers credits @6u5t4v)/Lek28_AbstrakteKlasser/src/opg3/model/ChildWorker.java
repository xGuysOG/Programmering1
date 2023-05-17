package opg3.model;

public class ChildWorker extends Employee {
    public ChildWorker(String name, String adress, double hourlyWage) {
        super(name, adress, hourlyWage);
    }

    @Override
    public double calculateSalary() {
        return getHourlyWage() * 25;
    }
}
