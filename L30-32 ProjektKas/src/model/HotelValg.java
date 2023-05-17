package model;

import java.util.ArrayList;

public class HotelValg {
    private Hotel hotel;
    private ArrayList<Service> chosenServices;

    public HotelValg(Hotel hotel) {
        this.hotel = hotel;
        chosenServices = new ArrayList<>();
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Service> getChosenServices() {
        return chosenServices;
    }

    public void addService(Service service) {
        chosenServices.add(service);
    }

    public double getServicePrices() {
        double price = 0;
        for (Service s : chosenServices) {
            price += s.getPrice();
        }
        return price;
    }
}
