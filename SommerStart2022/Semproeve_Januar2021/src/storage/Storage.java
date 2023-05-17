package storage;

import application.model.Fag;
import application.model.Studerende;

import java.util.ArrayList;

public class Storage {
    private final static ArrayList<Studerende> STUDERENDES = new ArrayList<>();
    private final static ArrayList<Fag> FAG = new ArrayList<>();

    public static void addStuderende(Studerende studerende) {
        STUDERENDES.add(studerende);
    }

    public static void addFag(Fag fag) {
        FAG.add(fag);
    }

    public static ArrayList<Studerende> getStuderende() {
        return new ArrayList<>(STUDERENDES);
    }

    public static ArrayList<Fag> getFag() {
        return new ArrayList<>(FAG);
    }
}
