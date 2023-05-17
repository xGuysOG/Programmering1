package OPG_6;

public class Main {
    public static void main(String[] args) {
        Car tesla = new Car("Tesla", "Black");
        System.out.println("Color: " + tesla);

        tesla.setRegistrationNumber("AB 12345");
        tesla.setKilometer(500);

        tesla.printInformation();
    }
}
