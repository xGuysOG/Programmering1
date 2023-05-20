package controller;

import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato){
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.storeForestilling(forestilling);
        return forestilling;
    }

    public static Kunde createKunde(String navn, String mobil){
        Kunde kunde = new Kunde(navn, mobil);
        Storage.storeKunde(kunde);
        return kunde;
    }

    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser) {
        if (dato.isAfter(forestilling.getStartDato().minusDays(1)) && dato.isBefore(forestilling.getSlutDato().plusDays(1))) {
            throw new RuntimeException("Dato passer ikke ind i forestilling");
        }
        //then check if seat is free
        for (Bestilling bestilling : forestilling.getBestillinger()){
            for(Plads plads : pladser){
                if (!forestilling.erPladsLedig(plads.getRække(), plads.getNr(), dato)) {
                    throw new RuntimeException("Plads er ikke ledig");
                }
            }
        }

        Bestilling bestilling = new Bestilling(dato, forestilling, kunde);
        forestilling.addBestilling(bestilling);
        return bestilling;

//        Metoden skal checke, om de givne pladser er ledige, og at den ønskede dato er i den periode,
//        hvor forestillingen vises. Hvis en af de givne pladser ikke er ledige på den givne dato, eller
//        forestillingen ikke vises på den givne dato, skal metoden kaste en RuntimeException med en
//        passende tekst.
    }
}
