package application.model;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private int singleRoomPrice;
    private int doubleRoomPrice;

    private ArrayList<HotelReservation> reservations = new ArrayList<>();

    private Address address;
    private ArrayList<Conference> conferences = new ArrayList<>();

    private Conference conference;

    private ArrayList<HotelService> hotelServices = new ArrayList<>();

    public Hotel(String name, int singleRoomPrice, int doubleRoomPrice, Address address) {
        this.name = name;
        this.singleRoomPrice = singleRoomPrice;
        this.doubleRoomPrice = doubleRoomPrice;
        this.address = address;
    }

    public void addToConference(Conference conference) {
        if (!conferences.contains(conference)) {
            conferences.add(conference);
            conference.addHotel(this);
        }
    }

    public void removeFromConference(Conference conference) {
        if (conferences.contains(conference)) {
            conferences.remove(conference);
            conference.removeHotel(this);
        }
    }


    public void addReservation(HotelReservation reservation) {
        if (!reservations.contains(reservation)) {
            reservations.add(reservation);
        }
    }

    public void removeReservation(HotelReservation reservation) {
        reservations.remove(reservation);
    }

    public HotelService createService(String name, int price) {
        HotelService service = new HotelService(name, price);
        hotelServices.add(service);
        return service;
    }


    public String getName() {
        return name;
    }

    public int getDoubleRoomPrice() {
        return doubleRoomPrice;
    }

    public int getSingleRoomPrice() {
        return singleRoomPrice;
    }

    public Address getAddress() {
        return address;
    }

    public ArrayList<HotelReservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    public ArrayList<Conference> getConferences() {
        return new ArrayList<>(conferences);
    }


    public ArrayList<HotelService> getHotelServices() {
        return new ArrayList<>(hotelServices);
    }

    @Override
    public String toString() {
        return name + " \nSingle Room: " + singleRoomPrice + " kr\nDouble Room: " + doubleRoomPrice + " kr";
    }
}
