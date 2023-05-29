package storage;

import model.Funktion;
import model.Medarbejder;
import model.Vagt;

import java.util.ArrayList;

public class Storage {

    private static final ArrayList<Funktion> funktioner = new ArrayList<>();
    private static final ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
    private static final ArrayList<Vagt> vagter = new ArrayList<>();

    public static void storeFunktion(Funktion funktion){
        funktioner.add(funktion);
    }

    public static void storeMedarbejder(Medarbejder medarbejder){
        medarbejdere.add(medarbejder);
    }

    public static void storeVagt(Vagt vagt){
        vagter.add(vagt);
    }

    public static ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public static ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    public static ArrayList<Funktion> getFunktioner() {
        return new ArrayList<>(funktioner);
    }



}
