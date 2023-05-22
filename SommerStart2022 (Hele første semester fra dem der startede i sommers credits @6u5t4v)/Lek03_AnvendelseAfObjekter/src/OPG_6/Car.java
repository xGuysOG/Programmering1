package OPG_6;

public class Car {
    private final String brand;
    private String color;
    private double kilometer;
    private String registrationNumber;

    public Car(String model, String color) {
        this.brand = model;
        this.color = color;
        this.kilometer = 120;
        this.registrationNumber = "";
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getKilometer() {
        return kilometer;
    }

    public void setKilometer(double kilometer) {
        this.kilometer = kilometer;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void printInformation() {
        final String longestLine = registrationNumber + " har kørt " + kilometer;

        StringBuilder border = new StringBuilder();
        border.append("*".repeat(longestLine.length()));

        System.out.println(border);
        System.out.println(brand + " " + color);
        System.out.println(longestLine);
        System.out.println(border);
    }
}
