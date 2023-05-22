package storage;

import application.model.Kamp;
import application.model.Spiller;

import java.util.ArrayList;

public class Storage {

    private static final ArrayList<Kamp> KAMPE = new ArrayList<>();
    private static final ArrayList<Spiller> SPILLERE = new ArrayList<>();

    public static void addKamp(Kamp kamp) {
        KAMPE.add(kamp);
    }

    public static void addSpiller(Spiller spiller) {
        SPILLERE.add(spiller);
    }

    public static ArrayList<Kamp> getKampe() {
        return new ArrayList<>(KAMPE);
    }

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<>(SPILLERE);
    }
}
