package storage;

import application.model.Salg;
import application.model.Sælger;
import application.model.Vare;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Sælger> sælgere = new ArrayList<>();
    private static ArrayList<Vare> varer = new ArrayList<>();
    private static ArrayList<Salg> salgListe = new ArrayList<Salg>();

    public static void addSælger(Sælger sælger) {
        sælgere.add(sælger);
    }

    public static void addVare(Vare vare) {
        varer.add(vare);
    }

    public static void addSalg(Salg salg) {
        salgListe.add(salg);
    }

    public static ArrayList<Sælger> getSælgere() {
        return new ArrayList<>(sælgere);
    }

    public static ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public static ArrayList<Salg> getSalg() {
        return new ArrayList<>(salgListe);
    }

}
