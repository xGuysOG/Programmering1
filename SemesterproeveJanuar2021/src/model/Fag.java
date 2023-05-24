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

//    For det enkelte fag ønskes en metode, der finder den Lektion, hvor der er registreret mest fravær.
//    Tilføj til klassen Fag en metode, der returnerer den Lektion, hvor der har været registreret mest
//    fravær. Hvis flere lektioner har det samme fravær, returneres blot en af disse, og hvis ingen
//    lektioner har fravær, returneres null.

    public Lektion lektionMedMestFravær(){
        Lektion cachedLektion = null;
        int amount = 0;
        int antalFraværende = 0;
        //so that we dont call antalFraværende contantly we cache it here,
        for(Lektion lektion : lektioner){
            antalFraværende = lektion.antalFraværende();
            //antalFraværende != 0 behøver vi nok ikke da vi allrede tjekker om den er størrer end amount som starter med 0.
            if (antalFraværende != 0 && antalFraværende > amount) {
                cachedLektion = lektion;
                amount = antalFraværende;
            }
        }
        return cachedLektion;
    }




    public String getNavn() {
        return navn;
    }

    public String getKlasse() {
        return klasse;
    }

    public ArrayList<Lektion> getLektioner() {
        return lektioner;
    }
}
