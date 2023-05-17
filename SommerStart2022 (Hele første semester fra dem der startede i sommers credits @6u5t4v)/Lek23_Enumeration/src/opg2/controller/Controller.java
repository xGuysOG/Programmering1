package opg2.controller;

import opg2.model.Event;
import opg2.model.Reservation;
import opg2.model.Seat;
import opg2.model.Zone;
import opg2.storage.Storage;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

    public static Seat createSeat(int nr, Zone zone) {
        Seat seat = new Seat(nr, zone);
        Storage.addSeat(seat);
        return seat;
    }

    public static boolean seatExists(int nr) {
        final ArrayList<Seat> seats = Storage.getSeats();
        for (Seat s : seats) {
            if (s.getNr() == nr) return true;
        }
        return false;
    }

    public static void updateSeat(Seat seat, int nr, Zone zone) {
        seat.setNr(nr);
        seat.setZone(zone);
    }

    public static void addSeatToReservation(Seat seat, Reservation reservation) {
        reservation.addSeat(seat);
    }

    public static void addReservation(Event event, Reservation reservation) {
        event.addReservation(reservation);
    }

    /**
     * @param start
     * @param end
     * @return
     */
    public static Reservation createReservation(LocalDateTime start, LocalDateTime end) {
        Reservation reservation = new Reservation(start, end);
        Storage.addReservation(reservation);
        return reservation;
    }

    public static void updateReservation(Reservation reservation, LocalDateTime start, LocalDateTime end) {
        reservation.setStartDate(start);
        reservation.setEndDate(end);
    }

    public static Event createEvent(String name, boolean isPublic) {
        Event event = new Event(name, isPublic);
        Storage.addEvent(event);
        return event;
    }

    public static void updateEvent(Event event, String name, boolean isPublic) {
        event.setName(name);
        event.setPublic(isPublic);
    }

    public static ArrayList<Seat> getSeats() {
        return Storage.getSeats();
    }

    public static ArrayList<Seat> getSeats(Zone zone) {
        ArrayList<Seat> seats = new ArrayList<>();
        for (Seat s : getSeats()) {
            if (s.getZone() == zone) {
                seats.add(s);
            }
        }

        return seats;
    }

    public static void initStorage() {
        Seat nr1 = createSeat(1, Zone.TOURNAMENT);
        Seat nr2 = createSeat(2, Zone.TOURNAMENT);
        Seat nr3 = createSeat(3, Zone.STANDARD);
        Seat nr4 = createSeat(4, Zone.STANDARD);
        Seat nr5 = createSeat(5, Zone.KIDS);
        Seat nr6 = createSeat(6, Zone.VIP);

        Event dota2 = createEvent("Dota 2 Tournament", true);
        Event csgo = createEvent("CS GO Tournament", false);

        LocalDateTime resStart = LocalDateTime.of(2019, 8, 12, 20, 00);
        Reservation reservation1 = createReservation(
                resStart,
                resStart.plusHours(3));

        addSeatToReservation(nr1, reservation1);
        addSeatToReservation(nr2, reservation1);

        addReservation(dota2, reservation1);
        resStart.withHour(19).withDayOfMonth(13);

        Reservation reservation2 = createReservation(
                resStart,
                resStart.withHour(6).withDayOfMonth(14)
        );

        addSeatToReservation(nr3, reservation2);
        addSeatToReservation(nr4, reservation2);

        Reservation reservation3 = createReservation(
                resStart.withHour(19),
                resStart.withHour(6).withDayOfMonth(15)
        );

        addSeatToReservation(nr6, reservation3);
    }
}
