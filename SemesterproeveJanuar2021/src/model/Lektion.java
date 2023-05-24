package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {
    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;
    private ArrayList<Deltagelse> deltagelser;
    private Fag fag;

    public Lektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag){
        this.dato = dato;
        this.startTid = startTid;
        this.lokale =lokale;
        this.fag = fag;
        this.deltagelser = new ArrayList<>();
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public String getLokale() {
        return lokale;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return deltagelser;
    }

    public Fag getFag() {
        return fag;
    }

    public void addDeltagelse(Deltagelse deltagelse){
        deltagelser.add(deltagelse);
    }
}
