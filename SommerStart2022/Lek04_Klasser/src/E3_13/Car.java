package E3_13;

public class Car {
    private final double fuelEfficiency; // Liters/km
    private double gasTank;

    public Car(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public double getGasTank() {
        return gasTank;
    }

    public void addGas(double gas) {
        gasTank += gas;
    }

    public void drive(double distance) {
        double gasUsed = distance / fuelEfficiency;

        if(gasUsed > gasTank){
            System.out.println("Not enough gas to drive " + distance + "km");
            return;
        }

        gasTank -= gasUsed;
        System.out.println("Car drove " + distance + "km, used " + gasUsed + " liters");
    }
}
