package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {

    private LocalDate dato;
    private ArrayList<Plads> pladser;
    private Kunde kunde;
    private Forestilling forestilling;

    public Bestilling(LocalDate dato, Forestilling forestilling, Kunde kunde, ArrayList<Plads> pladse) {
        this.forestilling = forestilling;
        this.dato = dato;
        this.kunde = kunde;
        this.pladser = pladse;
    }

    public Kunde getKunde(){
        return this.kunde;
    }

    public int samletPris(){
        int totalPris = 0;
        for(Plads plads : pladser){
            totalPris += plads.getPris();
        }
        return totalPris;
    }
    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public ArrayList<Plads> getPladser() {
        return pladser;
    }

    public void setPladser(ArrayList<Plads> pladser) {
        this.pladser = pladser;
    }


    public Forestilling getForestilling() {
        return forestilling;
    }

    public void setForestilling(Forestilling forestilling) {
        this.forestilling = forestilling;
    }

    @Override
    public String toString() {
        return "Bestilling{" +
                "dato=" + dato +
                ", pladser=" + pladser +
                ", kunde=" + kunde +
                ", forestilling=" + forestilling +
                '}';
    }
}
