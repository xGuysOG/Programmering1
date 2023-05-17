package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {
    public static Show createShow(String name, LocalDate startDate, LocalDate endDate){
        Show show = new Show(name, startDate, endDate);
        Storage.storeShow(show);
        return show;
    }
    public static Customer createCustomer(String name, int cellphone){
        Customer customer = new Customer(name, cellphone);
        Storage.storeCustomer(customer);
        return customer;
    }
    public static Seat createSeat(int row, int nr, int price, SeatType seatType){
        Seat seat = new Seat(row, nr, price, seatType);
        Storage.storeSeat(seat);
        return seat;
    }

    public static Order createOrderWithSeats(Show show, Customer customer, LocalDate date, ArrayList<Seat> seats){
        boolean returnNull = false;
        boolean validDate = date.isAfter(show.getStartDate().minusDays(1)) && date.isBefore(show.getEndDate().plusDays(1));
        if(!validDate){returnNull = true;}

        Order order = new Order(date, show, customer);

        for (Order o : show.getOrders()){
            for(Seat s : seats){
                if(!show.isSeatFree(s.getRow(), s.getNr(), date)) {
                    returnNull=true;
                }
            }
        }

        if(!returnNull) {
            for (Seat s : seats) {
                order.addSeat(s);
            }
        }

        if(!returnNull) {
            show.addOrder(order);
            customer.addOrder(order);
        }
        return (returnNull ? null : order);

    }





    /**
     *Helper method find if exists
     * Param: leave two null
     */
    private static boolean exists(Show show, Customer customer, Seat seat){
        boolean result = false;
        if(show!=null){
            for(Show show1 : Storage.getShows()){
                if(show.equals(show1)){
                    result = true;
                }
            } //lav EN stor if sætning
        }
        if(seat!=null){
            for(Seat seat1 : Storage.getSeats()){
                if(seat.equals(seat1)){
                    result = true;
                }
            }
        }
        if(customer!=null){
            for(Customer customer1 : Storage.getCustomers()){
                if(customer.equals(customer1)){
                    result = true;
                }
            }
        }
        return result;
    }
}
