package model;

import model.Bestilling;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {

    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private ArrayList<Bestilling> bestillinger;

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato){
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
        bestillinger = new ArrayList<>();
    }

    public int antalBestiltePladserPåDag(LocalDate dato) {
        int antalPladser = 0;

        for(Bestilling bestilling : bestillinger){
            if (bestilling.getDato().equals(dato)) {
                antalPladser += bestilling.getPladser().size();
            }
        }
        return antalPladser;
    }

    public LocalDate succesDato() {
        int max = Integer.MIN_VALUE;
        int temp;
        LocalDate cachedDate = null;
        for (LocalDate date = startDato; date.isBefore(slutDato.plusDays(1)); date = date.plusDays(1))
        {
            temp = antalBestiltePladserPåDag(date);
            if (temp > max) {
                max = temp;
                cachedDate = date;
            }
        }
        return cachedDate;
    }

    public boolean erPladsLedig(int række,int nr, LocalDate dato) {
        boolean result = true;
        for(Bestilling bestilling : bestillinger){
            if(bestilling.getDato().equals(dato)) {
                for (Plads plads : bestilling.getPladser()) {
                    if (plads.checkPos(række,nr)) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }

    public void setBestillinger(ArrayList<Bestilling> bestillinger) {
        this.bestillinger = bestillinger;
    }

    public void addBestilling(Bestilling bestilling) {
        this.bestillinger.add(bestilling);
    }


    @Override
    public String toString() {
        return "Forestilling{" +
                "navn='" + navn + '\'' +
                ", startDato=" + startDato +
                ", slutDato=" + slutDato +
                ", bestillinger=" + bestillinger +
                '}';
    }

    //Tilføj til klassen Forestilling metoden antalBestiltePladserPåDag(LocalDate dato): int,
    //der returnerer, hvor mange pladser der er bestilt til forestillingen på den pågældende dato.
}
