package opg2.storage;

import opg2.model.Event;
import opg2.model.Reservation;
import opg2.model.Seat;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Event> events = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static ArrayList<Seat> seats = new ArrayList<>();

    // SEATS -------------------
    public static void addSeat(Seat seat) {
        seats.add(seat);
    }

    public static void removeSeat(Seat seat) {
        seats.remove(seat);
    }

    public static ArrayList<Seat> getSeats() {
        return new ArrayList<>(seats);
    }

    // EVENTS -------------------
    public static void addEvent(Event event) {
        events.add(event);
    }

    public static void removeEvent(Event event) {
        events.remove(event);
    }

    public static ArrayList<Event> getEvents() {
        return new ArrayList<>(events);
    }

    // Reservation -------------------
    public static void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public static void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public static ArrayList<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

}
