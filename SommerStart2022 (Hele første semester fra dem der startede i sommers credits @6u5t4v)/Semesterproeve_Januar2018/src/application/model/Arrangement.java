package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Arrangement {
    private String titel;
    private LocalDate dato;
    private LocalTime startTid, slutTid;
    private double pris;

    public Arrangement(String titel, LocalDate dato, LocalTime startTid, LocalTime slutTid, double pris) {
        this.titel = titel;
        this.dato = dato;
        this.startTid = startTid;
        this.slutTid = slutTid;
        this.pris = pris;
    }

    public String getTitel() {
        return titel;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public LocalTime getSlutTid() {
        return slutTid;
    }

    public double getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return titel + " " + dato.toString() + " " + startTid + " " + slutTid;
    }
}
