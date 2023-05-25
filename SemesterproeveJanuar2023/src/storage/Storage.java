package storage;

import model.Salg;
import model.Sælger;
import model.Vare;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Sælger> sælgere = new ArrayList<>();
    private static ArrayList<Vare> varer = new ArrayList<>();
    private static ArrayList<Salg> salgsListe = new ArrayList<Salg>();

    public static void storeSalg(Salg salg) {
        salgsListe.add(salg);
    }

    public static void storeVare(Vare vare) {
        varer.add(vare);
    }

    public static void storeSælger(Sælger sælger) {
        sælgere.add(sælger);
    }

    public static ArrayList<Salg> getSalgsListe() {
        return new ArrayList<>(salgsListe);
    }

    public static ArrayList<Sælger> getSælgere() {
        return new ArrayList<>(sælgere);
    }
    public static ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }
}
