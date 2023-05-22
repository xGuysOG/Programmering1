package model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private LocalDate date;
    private ArrayList<Seat> seats = new ArrayList<>();
    private Customer customer;
    private Show show;



    public Order(LocalDate date, Show show, Customer customer) {
        this.date = date;
        this.show = show;
        this.customer = customer;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public LocalDate getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer){
            this.customer = customer;
    }

    public void addSeat(Seat seat){
        seats.add(seat);
    }

    public void setSeats(ArrayList<Seat> seats)  {
        this.seats = seats;

    }

    public int totalPrice() {
        int price = 0;
        for(Seat seat : seats) {
            price += seat.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", seats=" + seats +
                ", customer=" + customer +
                ", show=" + show +
                '}';
    }
}
