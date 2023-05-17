package Opgave2;

import java.time.LocalDate;

public class Rental {

    int number;
    int days;
    LocalDate startDate;
    double price;

    public Rental(int number, int days, double price, LocalDate startDate) {
        this.number = number;
        this.days = days;
        this.price = price;
        this.startDate = startDate;
    }

    public double getPricePrDay() {
        return price;
    }

    public void setDays(int days) {

    }

    public int getDays() {
        return days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public double getTotalPrice() {
        return price * days;
    }

    public LocalDate getEndDate() {
        return startDate.plusDays(days);
    }
}
