package application.model;

import java.util.ArrayList;

public class Companion {
    private String name;
    private Registration registration;
    private ArrayList<Trip> trips = new ArrayList<>();

    public Companion(String name, Registration registration) {
        this.name = name;
        this.registration = registration;
    }

    public void addTrip(Trip trip) {
        if (!trips.contains(trip)) {
            trips.add(trip);
            trip.addCompanion(this);
        }
    }

    public void removeTrip(Trip trip) {
        if (trips.contains(trip)) {
            trips.remove(trip);
            trip.removeCompanion(this);
        }
    }

    public int priceForTrips() {
        int total = 0;

        for (Trip trip : trips) {
            total += trip.getPrice();
        }

        return total;
    }


    public ArrayList<Trip> getTrips() {
        return new ArrayList<>(trips);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + registration.getParticipant().getName() + " " + registration.getParticipationNr() + ")";
    }
}
