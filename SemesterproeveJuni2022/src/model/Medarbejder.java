package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {
    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;

    public ArrayList<Vagt> getVagter() {
        return vagter;
    }

    public ArrayList<Funktion> getFunktioner() {
        return funktioner;
    }

    private ArrayList<Vagt> vagter = new ArrayList<>();
    private ArrayList<Funktion> funktioner = new ArrayList<>();

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid){
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }

    public int getAntalTimerPrDag(){
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid(){
        return typiskMødetid;
    }



}
