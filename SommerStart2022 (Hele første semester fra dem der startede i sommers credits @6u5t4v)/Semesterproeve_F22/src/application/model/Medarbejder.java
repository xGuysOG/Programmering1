package application.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {
    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;

    private ArrayList<Funktion> funktioner = new ArrayList<>();
    private ArrayList<Vagt> vagter = new ArrayList<>();

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }

    public void addVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            return;
        }

        for (Vagt tilDeltVagt : vagter) {
            // Datoerne overlapper
            if (overlapperVagterne(tilDeltVagt, vagt)) {
                throw new RuntimeException(navn + " har allerede en vagt i tidsrummet: " + vagt.getTidFra() + " - " + vagt.getTidTil());
            }
        }

        System.out.println("Tilføj vagt");

        vagter.add(vagt);
        vagt.addMedarbejder(this);
    }

    private boolean overlapperVagterne(Vagt tildelt, Vagt nyVagt) {
        return nyVagt.getTidFra().isAfter(tildelt.getTidTil()) ||
                nyVagt.getTidTil().isAfter(tildelt.getTidFra());
    }

    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
            vagt.removeMedarbejder(this);
        }
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public void addFunktion(Funktion funktion) {
        if (!funktioner.contains(funktion)) {
            funktioner.add(funktion);
        }
    }

    public void removeFunktion(Funktion funktion) {
        funktioner.remove(funktion);
    }

    public ArrayList<Funktion> getFunktioner() {
        return new ArrayList<>(funktioner);
    }

    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }

    @Override
    public String toString() {
        return navn + ", Typisk mødetid: " + typiskMødetid;
    }
}
