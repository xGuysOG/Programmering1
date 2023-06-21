package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {

    private LocalDate dato;
    private LocalTime tid;
    private boolean single;

    private Bane bane;
    private Spiller spiller;
    public Booking(LocalDate dato, LocalTime tid, boolean single, Bane bane, Spiller spiller) {
        this.dato = dato;
        this.tid = tid;
        this.single = single;
        this.bane = bane;
        this.spiller = spiller;
    }
    public String singleEllerDouble(){
        if (single) {
            return "single";
        } else {
            return "double";
        }
    }

    @Override
    public String toString() {
        return dato.toString() + " kl. " + tid.toString() + ", " + singleEllerDouble() + ", bane nr. " + bane.getNummer() + ", " + spiller.getNavn();
    }


    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public boolean isSingle() {
        return single;
    }

    public Bane getBane() {
        return bane;
    }

    public Spiller getSpiller() {
        return spiller;
    }


}
