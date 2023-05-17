package storage;

import application.model.Funktion;
import application.model.Medarbejder;
import application.model.Vagt;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Funktion> funktioner = new ArrayList<>();
    private static ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
    private static ArrayList<Vagt> vagter = new ArrayList<>();

    public static void addFunktion(Funktion funktion) {
        funktioner.add(funktion);
    }

    public static void addMedarbejder(Medarbejder medarbejder) {
        medarbejdere.add(medarbejder);
    }

    public static void addVagt(Vagt vagt) {
        vagter.add(vagt);
    }

    public static ArrayList<Funktion> getFunktioner() {
        return new ArrayList<>(funktioner);
    }

    public static ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    public static ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }
}
