package storage;

import application.model.Arrangement;
import application.model.Tutor;
import application.model.Uddannelse;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Uddannelse> UDDANNELSER = new ArrayList<>();
    private static final ArrayList<Tutor> TUTORER = new ArrayList<>();
    private static final ArrayList<Arrangement> ARRANGEMENTER = new ArrayList<>();

    public static void addUddannelse(Uddannelse uddannelse) {
        UDDANNELSER.add(uddannelse);
    }

    public static void addTutor(Tutor tutor) {
        TUTORER.add(tutor);
    }

    public static void addArrangement(Arrangement arrangement) {
        ARRANGEMENTER.add(arrangement);
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(ARRANGEMENTER);
    }

    public static ArrayList<Tutor> getTutorer() {
        return new ArrayList<>(TUTORER);
    }

    public static ArrayList<Uddannelse> getUddannelser() {
        return new ArrayList<>(UDDANNELSER);
    }
}
