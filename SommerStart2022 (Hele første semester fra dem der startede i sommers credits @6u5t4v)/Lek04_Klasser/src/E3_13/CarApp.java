package E3_13;

public class CarApp {
    public static void main(String[] args) {
        Car car = new Car(23);
        car.addGas(15);

        System.out.println("Filled tank with " + 30 + " liters");

        car.drive(100);

        System.out.println("Tank have " + car.getGasTank() + " liters left");

        car.drive(30);
        car.drive(50);
    }
}
