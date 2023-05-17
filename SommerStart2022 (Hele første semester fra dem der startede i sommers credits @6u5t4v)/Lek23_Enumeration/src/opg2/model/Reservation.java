package opg2.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private ArrayList<Seat> seats = new ArrayList<>();

    public Reservation(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public ArrayList<Seat> getSeats() {
        return new ArrayList<>(seats);
    }

    public void addSeat(Seat seat) {
        if (!seats.contains(seat)) {
            seats.add(seat);
            seat.addToReservation(this);
        }
    }

    public void removeSeat(Seat seat) {
        if (seats.contains(seat)) {
            seats.remove(seat);
            seat.removeReservation(this);
        }
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
