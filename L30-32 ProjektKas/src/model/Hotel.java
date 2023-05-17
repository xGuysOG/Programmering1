package model;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private String location;
    private double price;
    private double doublePrice;
    private ArrayList<Service> services;
    private ArrayList<Deltager> deltagere;

    public String getLocation() {
        return location;
    }

    public Hotel(String name, String location, double price, double doublePrice, ArrayList<Service> services) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.doublePrice = doublePrice;
        this.services = services;
        this.deltagere = new ArrayList<>();
    }

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    public void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public double getPrice() {
        return price;
    }

    public double getDoublePrice() {
        return doublePrice;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hotel " + name + " på adressen " + location + ". Pris pr. nat (single) " + price + "kr " + ". Pris pr. nat (double) " + doublePrice +
                "kr";
    }
}
