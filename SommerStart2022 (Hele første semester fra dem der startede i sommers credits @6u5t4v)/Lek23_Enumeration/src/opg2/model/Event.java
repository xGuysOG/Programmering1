package opg2.model;

import java.util.ArrayList;

public class Event {
    private String name;
    private boolean isPublic;

    private ArrayList<Reservation> reservations = new ArrayList<>();

    public Event(String name, boolean isPublic) {
        this.name = name;
        this.isPublic = isPublic;
    }

    public int amountReservedSeats() {
        int seats = 0;
        for (Reservation r : reservations) {
            seats += r.getSeats().size();
        }

        return seats;
    }

    public void addReservation(Reservation reservation) {
        if (!reservations.contains(reservation)) {
            reservations.add(reservation);
        }
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getName() {
        return name;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public ArrayList<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }
}
