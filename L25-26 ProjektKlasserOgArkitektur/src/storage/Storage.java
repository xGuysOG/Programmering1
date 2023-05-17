package storage;

import model.*;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Seat> seats = new ArrayList<>();
    private static final ArrayList<Customer> customers = new ArrayList<>();
    private static final ArrayList<Show> shows = new ArrayList<>();

    public static void storeSeat(Seat seat){
        seats.add(seat);
    }
    public static void storeCustomer(Customer customer) {
        customers.add(customer);
    }
    public static void storeShow(Show show){
        shows.add(show);
    }
    public static ArrayList<Seat> getSeats() {
        return new ArrayList<>(seats);
    }
    public static ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }
    public static ArrayList<Show> getShows() {
        return new ArrayList<>(shows);
    }
}
