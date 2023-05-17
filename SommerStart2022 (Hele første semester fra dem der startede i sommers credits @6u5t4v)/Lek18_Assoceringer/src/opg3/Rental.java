package opg3;

import java.util.ArrayList;

public class Rental {
    private int number;
    private int days;
    private String date;

    private final ArrayList<Car> cars = new ArrayList<>();

    public Rental(int number, int days, String date) {
        this.number = number;
        this.days = days;
        this.date = date;
    }

    public ArrayList<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public double getPrice() {
        double price = 0.0;

        for (Car c : cars) {
            price += c.getPricePrDay();
        }

        return price * days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

}
