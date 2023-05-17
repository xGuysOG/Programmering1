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
}
