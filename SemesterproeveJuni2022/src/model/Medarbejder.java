package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {
    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;
    private ArrayList<Vagt> vagter = new ArrayList<>();
    private ArrayList<Funktion> funktioner = new ArrayList<>();

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid){
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
                throw new RuntimeException(navn + " Vagt overlapper ");
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
    public ArrayList<Vagt> getVagter() {
        return vagter;
    }
    public ArrayList<Funktion> getFunktioner() {
        return funktioner;
    }
    public int getAntalTimerPrDag(){
        return antalTimerPrDag;
    }
    public LocalTime getTypiskMødetid(){
        return typiskMødetid;
    }
    public String getNavn(){
        return navn;
    }

    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
            vagt.removeMedarbejder(this);
        }
    }

    public void addFunktion(Funktion funktion) {
        if (!funktioner.contains(funktion)) {
            funktioner.add(funktion);
        }
    }

    @Override
    public String toString() {
        return navn +", " + "Typisk mødetid: "+ typiskMødetid;
    }
}
