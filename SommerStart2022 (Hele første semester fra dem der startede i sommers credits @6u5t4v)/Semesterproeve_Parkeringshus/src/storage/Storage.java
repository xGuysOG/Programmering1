package storage;

import application.model.Bil;
import application.model.Parkeringshus;

import java.util.ArrayList;

public class Storage {
    private final static ArrayList<Parkeringshus> parkeringshuse = new ArrayList<>();
    private final static ArrayList<Bil> biler = new ArrayList<Bil>();

    public static void addParkeringshus(Parkeringshus parkeringshus) {
        if (!parkeringshuse.contains(parkeringshus)) {
            parkeringshuse.add(parkeringshus);
        }
    }

    public static void addBil(Bil bil) {
        if (!biler.contains(bil)) {
            biler.add(bil);
        }
    }

    public static ArrayList<Parkeringshus> getParkeringshuse() {
        return new ArrayList<>(parkeringshuse);
    }

    public static ArrayList<Bil> getBiler() {
        return new ArrayList<>(biler);
    }
}
