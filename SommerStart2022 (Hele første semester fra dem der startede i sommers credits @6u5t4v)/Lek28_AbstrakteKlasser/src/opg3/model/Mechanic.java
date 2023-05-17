package opg3.model;

public class Mechanic extends Employee {
    private int apprenticeYear;

    public Mechanic(String name, String adress, int apprenticeYear, double hourlyPay) {
        super(name, adress, hourlyPay);
        this.apprenticeYear = apprenticeYear;
    }

    public double calculateSalary() {
        return getHourlyWage() * 37;
    }

    public int getApprenticeYear() {
        return apprenticeYear;
    }

    public void setApprenticeYear(int apprenticeYear) {
        this.apprenticeYear = apprenticeYear;
    }
}
