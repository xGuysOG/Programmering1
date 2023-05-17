package opg3.model;

public class Foreman extends Employee {
    private int declarationInYears;
    private double weeklyBonus;

    public Foreman(String name, String adress, double hourlyWage, int declarationInYears, double weeklyBonus) {
        super(name, adress, hourlyWage);
        this.declarationInYears = declarationInYears;
        this.weeklyBonus = weeklyBonus;
    }

    @Override
    public double calculateSalary() {
        return getHourlyWage() + weeklyBonus;
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
