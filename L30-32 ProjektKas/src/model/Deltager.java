package model;

import java.time.LocalDate;
import java.time.Period;

public class Deltager {
    private String name;
    private String address;
    private String location; // City/country
    private LocalDate arrivalDate;
    private LocalDate leaveDate;
    private String phoneNumber;
    private boolean hasLedsager;
    private Ledsager ledsager;
    private boolean isForedragsholder;
    private Konference konference;
    private boolean hasCompany;
    private String companyName;
    private String companyPhone;
    private HotelValg hotelValg;
    private Hotel hotel;


    public Deltager(String name, String address, String location, LocalDate arrivalDate,
                    LocalDate leaveDate, String phoneNumber, Konference konference, boolean hasCompany,
                    boolean hasLedsager, boolean isForedragsholder) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.arrivalDate = arrivalDate;
        this.leaveDate = leaveDate;
        this.phoneNumber = phoneNumber;
        this.konference = konference;
        this.hasCompany = hasCompany;
        this.hasLedsager = hasLedsager;
        this.isForedragsholder = isForedragsholder;
    }

    public Deltager(String name, String address, String location, LocalDate arrivalDate,
                    LocalDate leaveDate, String phoneNumber, Konference konference, boolean hasCompany,
                    boolean hasLedsager, boolean isForedragsholder, String companyName, String companyPhone) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.arrivalDate = arrivalDate;
        this.leaveDate = leaveDate;
        this.phoneNumber = phoneNumber;
        this.konference = konference;
        this.hasCompany = hasCompany;
        this.hasLedsager = hasLedsager;
        this.isForedragsholder = isForedragsholder;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
    }

    public void setHotelValg(HotelValg hotelValg) {
        this.hotelValg = hotelValg;
        this.hotel = hotelValg.getHotel();
    }

    public boolean hasHotel() {
        if (hotel == null) {
            return false;
        } else {
            return true;
        }
    }


    public Ledsager getLedsager() {
        return ledsager;
    }

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    public HotelValg getHotelValg() {
        return this.hotelValg;
    }

    public int amountOfDaysBooked() {
        Period period = Period.between(arrivalDate, leaveDate);
        int antalDage = period.getDays() + 1;
        return antalDage;
    }

    public double totalKonferencePrice() {
        if (isForedragsholder) {
            return 0;
        } else {
            double numberOfDaysBooked = amountOfDaysBooked();
            double conferencePricePerDay = konference.getPricePrDay();
            return (numberOfDaysBooked * conferencePricePerDay);
        }
    }

    public double totalUdflugtPrice() {
        if (!hasLedsager) {
            return 0;
        }
        if (ledsager.getUdflugter().size() == 0) {
            return 0;
        }
        double cost = 0;
        for (Udflugt udflugt : ledsager.getUdflugter()) {
            cost += udflugt.getPrice();
        }

        return cost;
    }

    public double totalHotelBookingPrice() {
        if (!hasHotel()) {
            return 0;
        }
        double costForStaying = 0;
        double hotelPrice = hotel.getPrice();
        double hotelDoublePrice = hotel.getDoublePrice();
        double servicePrice = hotelValg.getServicePrices();
        int antalDageHotel = amountOfDaysBooked() - 1;

        // Det koster dobbelt at have en ledsager med på hotellet
        if (hasLedsager) {
            costForStaying += (servicePrice * antalDageHotel) + (hotelDoublePrice * antalDageHotel);
        } else {
            costForStaying += (servicePrice * antalDageHotel) + (hotelPrice * antalDageHotel);
        }

        return costForStaying;
    }

    public double totalPrice() {
        double cost = totalHotelBookingPrice() + totalUdflugtPrice() + totalKonferencePrice();
        return cost;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (ledsager != null) {
            return name + "(" + ledsager.getName() + ") " + amountOfDaysBooked() + " dage";
        } else {
            return name + "(ingen ledsager) " + amountOfDaysBooked() + " dage";
        }
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public boolean isForedragsholder() {
        return isForedragsholder;
    }

    public boolean hasCompany() {
        return hasCompany;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasLedsager() {
        return hasLedsager;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    public void setHasCompany(boolean hasCompany) {
        this.hasCompany = hasCompany;
    }

    public void setForedragsholder(boolean foredragsholder) {
        isForedragsholder = foredragsholder;
    }

    public void setHasLedsager(boolean hasLedsager) {
        this.hasLedsager = hasLedsager;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Konference getKonference() {
        return konference;
    }
}
