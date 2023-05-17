package application.model;

import java.util.ArrayList;

public class Studerende implements Comparable<Studerende> {
    private String navn;
    private String email;

    private ArrayList<Deltagelse> deltagelsesListe = new ArrayList<>();

    public Studerende(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public int antalFravaersLektioner() {
        int antalFravaersLektioner = 0;

        for (Deltagelse deltagelse : deltagelsesListe) {
            if (deltagelse.erRegistreretFravarende()) {
                antalFravaersLektioner++;
            }
        }

        return antalFravaersLektioner;
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        if (!deltagelsesListe.contains(deltagelse)) {
            deltagelsesListe.add(deltagelse);
        }
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int compareTo(Studerende o) {
        return navn.compareTo(o.navn);
    }
}
