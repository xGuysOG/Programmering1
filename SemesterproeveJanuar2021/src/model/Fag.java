package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Dictionary;

public class Fag {
    private String navn;
    private String klasse;

    private ArrayList<Lektion> lektioner;


    public Fag(String navn, String klasse){
        this.navn = navn;
        this.klasse = klasse;
        this.lektioner = new ArrayList<>();
    }

    public ArrayList<Studerende> sygdomPåDato(LocalDate dato){
        ArrayList<Studerende> studerendeListe = new ArrayList<>();
        for(Lektion lektion : lektioner){
            if (lektion.getDato().equals(dato)) {
                for(Deltagelse deltagelse : lektion.getDeltagelser()) {
                    if (deltagelse.isRegisteret()) {
                        if (deltagelse.getStatus().equals(DeltagerStatus.SYG)) {
                            if (!studerendeListe.contains(deltagelse.getStuderende())) {
                                studerendeListe.add(deltagelse.getStuderende());
                            }
                        }
                    }
                }
            }
        }
        return studerendeListe;
    }
}
