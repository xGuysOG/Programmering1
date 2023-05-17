package model;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.time.LocalDate;
import java.util.ArrayList;

public class Show {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<Order> orders = new ArrayList<>();

    public Show(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public boolean equals(Show show){
        return this.name.equals(show.getName()) && this.startDate.equals(show.getStartDate()) && this.endDate.equals(show.getEndDate());
    }

    public int amountOfSeatsPrDay(LocalDate date) {
        int amountOfSeats = 0;
        for(Order order : orders) {
            if (order.getDate().equals(date)) {
                amountOfSeats += order.getSeats().size();
            }
        }
        return amountOfSeats;
    }

    public LocalDate succesDate() {
        //
        int max = Integer.MIN_VALUE;
        int temp;
        LocalDate cachedDate = null;
        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1))
        {
            temp = amountOfSeatsPrDay(date);
            if (temp > max) {
                max = temp;
                cachedDate = date;
            }
        }
        return cachedDate;
    }

    public boolean isSeatFree(int row, int nr, LocalDate date){
        boolean result = true;
        for(Order order : orders){
            if(order.getDate().equals(date)) {
                for (Seat s : order.getSeats()) {
                    if (s.checkPos(row,nr)) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return name + "(fra " + startDate + " til " + endDate + ")";
    }

}
