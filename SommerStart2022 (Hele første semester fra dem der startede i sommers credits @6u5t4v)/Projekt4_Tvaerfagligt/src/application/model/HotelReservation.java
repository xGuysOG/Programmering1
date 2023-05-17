package application.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class HotelReservation {
    private Hotel hotel;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private HotelService[] services;
    private Registration registration;
    private boolean doubleRoom;

    // TODO make registration nullable
    public HotelReservation(Hotel hotel, LocalDate checkIn, LocalDate checkOut, HotelService[] selectedServices, boolean doubleRoom, Registration registration) {
        this.hotel = hotel;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.registration = registration;
        this.services = selectedServices;
        this.doubleRoom = doubleRoom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public HotelService[] getServices() {
        return services;
    }

    public void setServices(HotelService[] services) {
        this.services = services;
    }

    public boolean isDoubleRoom() {
        return doubleRoom || registration.hasCompanion();
    }

    public int hotelStayPrice() {
        int totalPrice = dayPrice() + priceServices();

        int days = Period.between(checkIn, checkOut).getDays();

        return totalPrice * days;
    }

    public int dayPrice() {
        return isDoubleRoom() ? hotel.getDoubleRoomPrice() : hotel.getSingleRoomPrice();
    }

    public int priceServices() {
        int price = 0;
        for (HotelService service : services) {
            price += service.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        String content = registration.getParticipant().getName();
        if (registration.hasCompanion()) {
            content += "\nLedsager: " + registration.getCompanion().getName();
        }

        content += "\nDobbelt værelse: " + isDoubleRoom();
        content += "\nTjenester: " + Arrays.toString(services);

        return content;
    }
}
