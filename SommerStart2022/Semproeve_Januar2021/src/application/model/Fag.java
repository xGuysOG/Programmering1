package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {
    private String fag;
    private String klasse;

    private ArrayList<Lektion> lektioner = new ArrayList<>();

    public Fag(String fag, String klasse) {
        this.fag = fag;
        this.klasse = klasse;
    }

    public Lektion lektionMedMestFravære() {
        Lektion mindstPopulærLektion = null;
        int mestFravær = 0;

        for (Lektion lektion : lektioner) {
            int totalFravær = lektion.totalFravær();
            if (totalFravær > mestFravær) {
                mindstPopulærLektion = lektion;
                mestFravær = totalFravær;
            }
        }

        return mindstPopulærLektion;
    }

    public ArrayList<Studerende> sygdomPåDato(LocalDate dato) {
        ArrayList<Studerende> syge = new ArrayList<>();

        for (Lektion lektion : lektioner) {
            if (lektion.getDato().equals(dato)) {

                for (Deltagelse deltagelse : lektion.getDeltagelseList()) {
                    if (!syge.contains(deltagelse.getStuderende()) && deltagelse.erRegistreretFravarende()) {
                        syge.add(deltagelse.getStuderende());
                    }
                }
            }
        }

        return syge;
    }

    public void addLektion(Lektion lektion) {
        if (!lektioner.contains(lektion)) {
            lektioner.add(lektion);
        }
    }

    public String getFag() {
        return fag;
    }

    public String getKlasse() {
        return klasse;
    }

    public ArrayList<Lektion> getLektioner() {
        return new ArrayList<>(lektioner);
    }
}
