package application.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Conference {
    private String name;
    private int price;
    private LocalDate startDate;
    private LocalDate endDate;
    private Address address;

    private ArrayList<Trip> trips = new ArrayList<>();
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private static int RegistrationNumbers = 0;
    private ArrayList<Registration> registrations = new ArrayList<>();

    public Conference(String name, int price, LocalDate startDate, LocalDate endDate, Address address) {
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
    }

    public Registration createRegistration(Participant participant, boolean isLecture, LocalDate joinDate, LocalDate leaveDate) {
        Registration registration = new Registration(participant, RegistrationNumbers, isLecture, joinDate, leaveDate, this);
        RegistrationNumbers++;
        registrations.add(registration);
        return registration;
    }

    public Trip createTrip(String name, LocalDate start, int price) {
        Trip trip = new Trip(name, start, price);
        trips.add(trip);
        return trip;
    }

    public void addHotel(Hotel hotel) {
        if (!hotels.contains(hotel)) {
            hotels.add(hotel);
            hotel.addToConference(this);
        }
    }

    public void removeHotel(Hotel hotel) {
        if (hotels.contains(hotel)) {
            hotels.remove(hotel);
            hotel.removeFromConference(this);
        }
    }

    public void addTrip(Trip trip) {
        if (!trips.contains(trip)) {
            trips.add(trip);
        }
    }

    public int totalPrice() {
        int days = Period.between(startDate, endDate).getDays() + 1;
        return price * days;
    }


    public void removeTrip(Trip trip) {
        trips.remove(trip);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ArrayList<Trip> getTrips() {
        return new ArrayList<>(trips);
    }

    public ArrayList<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public ArrayList<Registration> getRegistrations() {
        return new ArrayList<>(registrations);
    }

    @Override
    public String toString() {
        return name + " (" + price + " kr)\nStart: " + startDate.toString() + "\nSlut: " + endDate.toString();
    }
}
