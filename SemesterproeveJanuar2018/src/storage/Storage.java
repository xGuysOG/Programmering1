package storage;

import model.Arrangement;
import model.Tutor;
import model.Uddannelse;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Uddannelse> uddannelser= new ArrayList<>();
    private static final ArrayList<Tutor> tutorer = new ArrayList<>();
    private static final ArrayList<Arrangement> arrangementer = new ArrayList<>();


    public static void storeUddannelse(Uddannelse uddannelse) {
        uddannelser.add(uddannelse);
    }

    public static void storeTutor(Tutor tutor) {
        tutorer.add(tutor);
    }

    public static void storeArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public static ArrayList<Tutor> getTutorer() {
        return new ArrayList<>(tutorer);
    }

    public static ArrayList<Uddannelse> getUddannelser() {
        return new ArrayList<>(uddannelser);
    }
}
