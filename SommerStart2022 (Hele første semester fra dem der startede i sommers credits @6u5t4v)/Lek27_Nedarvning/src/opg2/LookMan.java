package opg2;

public class LookMan extends Mechanic {
    // (Inspector)

    private int inspections;

    public LookMan(String name, String adress, int apprenticeYears, int hourlyPay, int inspections) {
        super(name, adress, apprenticeYears, hourlyPay);
        this.inspections = inspections;
    }


    @Override
    public double calculateSalary() {
        double salary = super.calculateSalary();
        return salary + 29 * inspections;
    }

    public int getInspections() {
        return inspections;
    }

    public void setInspections(int inspections) {
        this.inspections = inspections;
    }
}
