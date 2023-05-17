package application.model;

import java.util.ArrayList;

public class Uddannelse {
    private String navn;

    private ArrayList<Hold> holdListe = new ArrayList<>();

    public Uddannelse(String navn) {
        this.navn = navn;
    }

    public ArrayList<String> tutorOversigt() {
        ArrayList<String> oversigt = new ArrayList<>();

        for (Hold hold : holdListe) {
            if (!hold.getTutore().isEmpty()) {
                for (Tutor tutor : hold.getTutore()) {
                    String tutorOversigt = String.format("%-15s %-4s %-8s %-21s %s", tutor.getNavn(), navn, hold.getBetegnelse(), tutor.getEmail(), hold.getHoldLeder());
                    oversigt.add(tutorOversigt);
                }
            }
        }

        return oversigt;
    }


    public ArrayList<Hold> holdUdenTutorer() {
        ArrayList<Hold> holdUden = new ArrayList<>();

        for (Hold hold : holdListe) {
            if (hold.getTutore().isEmpty()) {
                holdUden.add(hold);
            }
        }

        return holdUden;
    }

    public Hold createHold(String betegnelse, String holdLeder) {
        Hold hold = new Hold(betegnelse, holdLeder, this);
        holdListe.add(hold);
        return hold;
    }

    public void addHold(Hold hold) {
        if (!holdListe.contains(hold)) {
            holdListe.add(hold);
            hold.setUddannelse(this);
        }
    }

    public void removeHold(Hold hold) {
        if (holdListe.contains(hold)) {
            holdListe.remove(hold);
            hold.setUddannelse(null);
        }
    }

    public ArrayList<Hold> getHoldListe() {
        return new ArrayList<>(holdListe);
    }

    public String getNavn() {
        return navn;
    }
}
