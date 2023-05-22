package Opgave1;

public class Car {
    String brand;
    String color;
    String regNo; // registration number
    int km;

    public Car(String brand, String color, String regNo, int km) {
        this.brand = brand;
        this.color = color;
        this.regNo = regNo;
        this.km = km;
    }

    @Override
    public String toString() {
        return String.format("Car(%s, %s, %s, %d km)", brand, color, regNo, km);
    }

    public void printCarInfo () {
        System.out.println("****************");
        System.out.println("* " + brand + ", " + color);
        System.out.println("* " + regNo);
        System.out.println("* " + km + " km");
        System.out.println("****************");
    }
}
