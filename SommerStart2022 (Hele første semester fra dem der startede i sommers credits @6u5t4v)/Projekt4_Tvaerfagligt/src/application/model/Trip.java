package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trip {
    private String name;
    private LocalDate startDate;
    private int price;

    private ArrayList<Companion> companions = new ArrayList<>();

    public Trip(String name, LocalDate startDate, int price) {
        this.name = name;
        this.startDate = startDate;
        this.price = price;
    }

    public void addCompanion(Companion companion) {
        if (!companions.contains(companion)) {
            companions.add(companion);
            companion.addTrip(this);
        }
    }

    public void removeCompanion(Companion companion) {
        if (companions.contains(companion)) {
            companions.remove(companion);
            companion.removeTrip(this);
        }
    }


    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<Companion> getCompanions() {
        return new ArrayList<>(companions);
    }

    @Override
    public String toString() {
        return name +
                "\nPris: " + price +
                "\nDato: " + startDate.getDayOfMonth() + "/" + startDate.getMonthValue();
    }
}
