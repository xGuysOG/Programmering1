package model;

import java.util.ArrayList;

public class Uddannelse {

    private String navn;

    private ArrayList<Hold> holdListe = new ArrayList<>();
    public Uddannelse(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void addHold(Hold hold){
        this.holdListe.add(hold);
    }

    public ArrayList<Hold> getHoldUdenTutor() {
        ArrayList<Hold> holdne = new ArrayList<>();
        for(Hold hold : holdListe) {
            if (hold.getTutore().size() < 1) {
                holdne.add(hold);
            }
        }
        return holdne;
    }
}
