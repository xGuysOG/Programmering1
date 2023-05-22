package opg1;

import java.util.ArrayList;

public class Car {

    private String license;
    private double pricePrDay;
    private int purchaseYear;

    private ArrayList<Rental> rentals = new ArrayList<>();

    public Car(String license, double pricePrDay, int purchaseYear) {
        this.license = license;
        this.pricePrDay = pricePrDay;
        this.purchaseYear = purchaseYear;
    }

    public void addRental(Rental rental) {
        if (!rentals.contains(rental)) {
            rentals.add(rental);
            rental.addCar(this);
        }
    }

    public void removeRental(Rental rental) {
        if (rentals.contains(rental)) {
            rentals.remove(rental);
            rental.removeCar(this);
        }
    }


    public int maxRentalCount() {
        int largest = 0;
        for (Rental rental : rentals) {
            if (rental.getDays() > largest) {
                largest = rental.getDays();
            }
        }

        return largest;
    }

    public String getLicense() {
        return license;
    }

    public void setDailyPrice(double price) {
        this.pricePrDay = price;
    }

    public double getDailyPrice() {
        return pricePrDay;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }
}
