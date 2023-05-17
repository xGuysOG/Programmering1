package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    private String name;
    private int cellphone;
    private ArrayList<Order> orders = new ArrayList<>();

    public Customer(String name, int cellphone) {
        this.name = name;
        this.cellphone = cellphone;
    }
    public void addOrder(Order order){
        orders.add(order);
    }

    public String getName() {
        return name;
    }

    public int getCellphone() {
        return cellphone;
    }

    public boolean equals(Customer customer){
        return this.name.equals(customer.getName()) && this.cellphone == customer.getCellphone();
    }

    public ArrayList<Seat> OrderedSeatsForShowPrDay(Show show, LocalDate date){
        ArrayList<Seat> seats = new ArrayList<>();
        for(Order order : show.getOrders()) {
            if (order.getDate().equals(date) && order.getCustomer().equals(this)) {
                seats.addAll(order.getSeats());
            }
        }

        return seats;
    }

    @Override
    public String toString() {
        return name + "(" + cellphone + ")";
    }
}
