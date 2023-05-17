package Opgave1;

public class CarApp {

    public static void main(String[] args) {
        Car myCar = new Car("VW UP", "White", "AB 12.345", 50000);
        Car newCar = new Car("Toyota Yaris", "Sort", "DB26769", 0);
        System.out.println("Test: " + myCar.toString());
        System.out.println();

        String brand = myCar.brand;
        System.out.println("Brand " + brand);
        System.out.println("My car: " + myCar.brand + ", " + myCar.color);
        System.out.println("New car: " + newCar.brand + ", " + newCar.color);

        myCar.km = 65000;
        newCar.km = 500;
        System.out.println("Km nu myCar: " + myCar.km);
        System.out.println("Km nu newCar: " + newCar.km);
        newCar.printCarInfo();
        myCar.printCarInfo();
    }
}
