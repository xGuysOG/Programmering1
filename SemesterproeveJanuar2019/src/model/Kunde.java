package model;

import model.Bestilling;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Dictionary;

public class Kunde {

    private String navn;
    private String mobil;
    private ArrayList<Bestilling> bestillinger;

    public Kunde(String navn, String mobil){
        this.navn = navn;
        this.mobil = mobil;
        this.bestillinger = new ArrayList<>();
    }

    public ArrayList<Plads> bestiltePladserTilForestillingPådag(Forestilling forestilling, LocalDate localDate){
        ArrayList<Plads> pladser = new ArrayList<>();
        for(Bestilling bestilling : forestilling.getBestillinger()){
            if (bestilling.getDato().equals(localDate)){
                if (bestilling.getKunde().equals(this)){
                    pladser.addAll(bestilling.getPladser());
                }
            }
        }
        return pladser;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "navn='" + navn + '\'' +
                ", mobil='" + mobil + '\'' +
                ", bestillinger=" + bestillinger +
                '}';
    }
}
