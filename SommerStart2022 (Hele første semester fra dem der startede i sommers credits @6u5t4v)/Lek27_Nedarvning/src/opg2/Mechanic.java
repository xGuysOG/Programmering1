package opg2;

public class Mechanic extends Person {
    private int apprenticeYear;
    private double hourlyPay;

    public Mechanic(String name, String adress, int apprenticeYear, double hourlyPay) {
        super(name, adress);
        this.apprenticeYear = apprenticeYear;
        this.hourlyPay = hourlyPay;
    }

    public double calculateSalary() {
        return hourlyPay * 37;
    }

    public int getApprenticeYear() {
        return apprenticeYear;
    }

    public void setApprenticeYear(int apprenticeYear) {
        this.apprenticeYear = apprenticeYear;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(int hourlyPay) {
        this.hourlyPay = hourlyPay;
    }
}
