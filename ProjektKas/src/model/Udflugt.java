package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {

    private String name;
    private LocalDate date;
    private double price;
    private Konference konference;
    private ArrayList<Ledsager> deltagere;

    public Udflugt(String name, LocalDate date, double price, Konference konference) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.konference = konference;
        this.deltagere = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + "(" + date + ") " + price + " kr";
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public Konference getKonference() {
        return konference;
    }
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Ledsager> getDeltagere() {
        return deltagere;
    }

    public void addLedsager(Ledsager ledsager){
        deltagere.add(ledsager);
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }
}
