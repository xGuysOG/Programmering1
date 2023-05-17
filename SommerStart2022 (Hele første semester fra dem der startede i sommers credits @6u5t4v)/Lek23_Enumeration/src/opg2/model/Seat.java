package opg2.model;

import java.util.ArrayList;

public class Seat {
    private static int StandardHourlyPrice = 50;

    private int nr;
    private Zone zone;

    private ArrayList<Reservation> reservations = new ArrayList<>();

    public Seat(int nr, Zone zone) {
        this.nr = nr;
        this.zone = zone;
    }

    public double price(int hours) {
        double price = StandardHourlyPrice * hours;

        switch (zone) {
            case VIP -> price = StandardHourlyPrice * 1.25;
            case KIDS -> price = StandardHourlyPrice * (-1.20);
            case TOURNAMENT -> price = StandardHourlyPrice * 1.10;
            default -> {
                return price;
            }
        }
        return price;
    }

    public static int getStandardHourlyPrice() {
        return StandardHourlyPrice;
    }

    public static void setStandardHourlyPrice(int standardHourlyPrice) {
        Seat.StandardHourlyPrice = standardHourlyPrice;
    }

    public void addToReservation(Reservation reservation) {
        if (!reservations.contains(reservation)) {
            reservations.add(reservation);
            reservation.addSeat(this);
        }
    }

    public void removeReservation(Reservation reservation) {
        if (reservations.contains(reservation)) {
            reservations.remove(reservation);
            reservation.removeSeat(this);
        }
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public ArrayList<Reservation> getReservations() {
        return new ArrayList<>(reservations);

    }

    @Override
    public String toString() {
        return "Plads " + nr + ", " + zone.name();
    }
}
