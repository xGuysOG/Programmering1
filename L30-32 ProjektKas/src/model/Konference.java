package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String name;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private double pricePrDay;
    private ArrayList<Hotel> hoteller;
    private ArrayList<Udflugt> udflugter;
    private ArrayList<Deltager> deltagere;

    public Konference(String name, String location, LocalDate startDate, LocalDate endDate, double pricePrDay) {
        this.name = name;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePrDay = pricePrDay;
        this.udflugter = new ArrayList<>();
        this.deltagere = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setPricePrDay(double pricePrDay) {
        this.pricePrDay = pricePrDay;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public double getPricePrDay() {
        return pricePrDay;
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    public void addDeltager(Deltager deltager) {
        this.deltagere.add(deltager);
    }

    @Override
    public String toString() {
        return name + " (" + startDate + " til " + endDate + ")";
    }
}
