package model;

import java.util.ArrayList;

public class Salg {
    private String købersNavn;
    private int aftaltSamletPris;
    private ArrayList<Vare> varene;

    public Salg(String købersNavn, int aftaltSamletPris, ArrayList<Vare> varene){
        this.købersNavn = købersNavn;
        this.aftaltSamletPris = aftaltSamletPris;
        this.varene = varene;
        for (Vare vare : varene) {
            vare.setSolgt(true);
            vare.setSalg(this);
            Salgsannonce salgsAnnounce = vare.getSalgsannonce();
            salgsAnnounce.updaterSalgsannonce();
        }
    }

    public int orignalPris() {
        int total = 0;
        for(Vare vare : varene) {
            total += vare.getUdbudspris();
        }
        return total;
    }

    public String getKøbersNavn() {
        return købersNavn;
    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    public ArrayList<Vare> getVarene() {
        return varene;
    }

    @Override
    public String toString() {
        return "Salg{" +
                "købersNavn='" + købersNavn + '\'' +
                ", aftaltSamletPris=" + aftaltSamletPris +
                ", varene=" + varene +
                '}';
    }
}
