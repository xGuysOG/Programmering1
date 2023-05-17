package application.model;

import java.util.ArrayList;

public class Salg {
    private String købersNavn;
    private int aftaltSamletPris;

    private ArrayList<Vare> salgsVarer;

    public Salg(String købersNavn, int aftaltSamletPris, ArrayList<Vare> salgsVarer) {
        this.købersNavn = købersNavn;
        this.aftaltSamletPris = aftaltSamletPris;
        this.salgsVarer = salgsVarer;
    }


    public String getKøbersNavn() {
        return købersNavn;
    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    public ArrayList<Vare> getSalgsVarer() {
        return new ArrayList<>(salgsVarer);
    }
}
