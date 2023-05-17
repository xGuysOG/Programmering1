package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {

    /**
     * Create a konference
     * Pre: name is not empty, startDate <= endDate, dayPrice >= 0</=>
     */
    public static Konference createKonference(String name, String location, LocalDate startDate, LocalDate endDate, double pricePrDay) {
        Konference konference = new Konference(name, location, startDate, endDate, pricePrDay);
        Storage.storeKonference(konference);
        return konference;
    }

    /**
     * Create a udflugt and add to konference
     * Pre: Name not empty, dayprice >= 0 date is within konference time
     */
    public static Udflugt createUdflugt(String name, LocalDate date, double price, Konference konference) {
        Udflugt udflugt = new Udflugt(name, date, price, konference);
        konference.addUdflugt(udflugt);
        Storage.storeUdflugt(udflugt);
        return udflugt;
    }

    /**
     * Create a Hotel
     * Pre: Name not empty, location not empty, price >= 0
     */
    public static Hotel createHotel(String name, String location, double price, double doublePrice, ArrayList<Service> services) {
        Hotel hotel = new Hotel(name, location, price, doublePrice, services);
        Storage.storeHotel(hotel);
        return hotel;
    }

    /**
     * Create a Deltager with company info and add to konference
     * Pre: Name not empty, address not empty, location not empty, arrivalDate before leave date, phoneNumber not empty, Konference not null, Ledsager can be null.
     */
    public static Deltager createDeltager(String name, String address, String location, LocalDate arrivalDate,
                                          LocalDate leaveDate, String phoneNumber, Konference konference, boolean hasCompany,
                                          boolean hasLedsager, boolean isForedragsholder, String companyName, String companyPhone) {
        Deltager deltager = new Deltager(
                name, address, location, arrivalDate, leaveDate, phoneNumber, konference, hasCompany,
                hasLedsager, isForedragsholder, companyName, companyPhone);
        konference.addDeltager(deltager);
        return deltager;
    }

    /**
     * Create a Deltager with company info and add to konference
     * Pre: Name not empty, address not empty, location not empty, arrivalDate before leave date, phoneNumber not empty, Konference not null, Ledsager can be null.
     */
    public static Deltager createDeltager(String name, String address, String location, LocalDate arrivalDate,
                                          LocalDate leaveDate, String phoneNumber, Konference konference, boolean hasCompany,
                                          boolean hasLedsager, boolean isForedragsholder) {
        Deltager deltager = new Deltager(
                name, address, location, arrivalDate,
                leaveDate, phoneNumber, konference, hasCompany,
                hasLedsager, isForedragsholder);
        konference.addDeltager(deltager);
        return deltager;
    }

    /**
     * Create a Ledsager and add to deltager
     * Pre: Name not empty, Deltager not null
     */
    public static Ledsager createLedsager(String name, Deltager deltager) {
        Ledsager ledsager = new Ledsager(name, deltager);
        deltager.setLedsager(ledsager);
        return ledsager;
    }

    /**
     * Create a service
     * Pre: Name not empty, Hotel not null
     */
    public static Service createService(String name, double price) {
        Service service = new Service(name, price);
        return service;
    }

    /**
     * Create a hotelvalg and add it to the deltager
     * Pre: Hotel not null, Deltager not null
     */
    public static HotelValg createHotelValg(Hotel hotel, Deltager deltager) {
        HotelValg hotelValg = new HotelValg(hotel);
        hotel.addDeltager(deltager);
        deltager.setHotelValg(hotelValg);
        return hotelValg;
    }
}
