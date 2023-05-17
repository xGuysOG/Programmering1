package opg2;

public class Foreman extends Mechanic {
    private int declarationInYears;
    private double weeklyBonus;

    public Foreman(String name, String adress, int apprenticeYears, double hourlyPay, int declarationInYears, double weeklyBonus) {
        super(name, adress, apprenticeYears, hourlyPay);
        this.declarationInYears = declarationInYears;
        this.weeklyBonus = weeklyBonus;
    }

    @Override
    public double calculateSalary() {
        double salary = super.calculateSalary();
        return salary + weeklyBonus;
    }

    public int getDeclarationInYears() {
        return declarationInYears;
    }

    public void setDeclarationInYears(int declarationInYears) {
        this.declarationInYears = declarationInYears;
    }

    public double getWeeklyBonus() {
        return weeklyBonus;
    }

    public void setWeeklyBonus(double weeklyBonus) {
        this.weeklyBonus = weeklyBonus;
    }
}
