package opg1;

public class Mechanic extends Person {
    private int apprenticeYears;
    private int hourlyPay;

    public Mechanic(String name, String adress, int apprenticeYears, int hourlyPay) {
        super(name, adress);
        this.apprenticeYears = apprenticeYears;
        this.hourlyPay = hourlyPay;
    }

    public int getApprenticeYears() {
        return apprenticeYears;
    }

    public void setApprenticeYears(int apprenticeYears) {
        this.apprenticeYears = apprenticeYears;
    }

    public int getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(int hourlyPay) {
        this.hourlyPay = hourlyPay;
    }
}
