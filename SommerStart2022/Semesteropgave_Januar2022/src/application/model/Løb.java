package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Løb {
    private LocalDate dato;
    private String sted;
    private int normalPris;
    private LocalDate earlyBirdDate;
    private int earlyBirdPris;

    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private ArrayList<Forhindring> forhindringer = new ArrayList<>();

    public Løb(LocalDate dato, String sted, int normalPris, LocalDate earlyBirdDate, int earlyBirdPris) {
        this.dato = dato;
        this.sted = sted;
        this.normalPris = normalPris;
        this.earlyBirdDate = earlyBirdDate;
        this.earlyBirdPris = earlyBirdPris;
    }

    public String resultatForTilmelding(String navn) {
        String resultat = "Deltageren findes ikke";
        boolean found = false;
        int i = 0;

        while (!found && i < tilmeldinger.size()) {
            Tilmelding k = tilmeldinger.get(i);

            if (k.getNavn().equals(navn)) {
                resultat = k.resultat();
                found = true;
            } else i++;
        }

        return resultat;
    }

    public String findVinder() {
        Tilmelding vinder = tilmeldinger.get(0);

        for (int i = 1; i < tilmeldinger.size(); i++) {
            Tilmelding k = tilmeldinger.get(i);

            if (k.getLøbeTid() != -1 && k.getLøbeTid() < vinder.getLøbeTid()) {
                vinder = k;
            }
        }

        return vinder.resultat();
    }

    public double gennemsnitStrafSekunder(Forhindring forhindring) {
        double strafSekunder = 0;
        int straffet = 0;

        for (Tilmelding tilmelding : tilmeldinger) {
            for (Note note : tilmelding.getNoter()) {
                if (note.getForhindring().equals(forhindring)) {
                    strafSekunder += note.getStrafSekunder();
                    straffet++;
                }
            }
        }

        return strafSekunder / straffet;
    }

    public int earlyBirdIndtjening() {
        int indtjening = 0;

        for (Tilmelding tilmelding : tilmeldinger) {
            // Går ud fra earlyBirdDato også altid vil være før dato
            if (tilmelding.getTilmeldingsDato().isBefore(dato)) {
                indtjening += earlyBirdPris;
            }
        }

        return indtjening;
    }

    public Forhindring findForhindring(String navn) {
        Forhindring forhindring = null;
        int i = 0;

        while (forhindring == null && i < forhindringer.size()) {
            Forhindring k = forhindringer.get(i);
            if (k.getNavn().equals(navn))
                forhindring = k;
            else i++;
        }

        return forhindring;
    }

    public void addForhindring(Forhindring forhindring) {
        if (!forhindringer.contains(forhindring)) {
            forhindringer.add(forhindring);
            forhindring.addLøb(this);
        }
    }

    public void removeForhindring(Forhindring forhindring) {
        if (forhindringer.contains(forhindring)) {
            forhindringer.remove(forhindring);
            forhindring.removeLøb(this);
        }
    }


    public Tilmelding createTilmelding(String navn, boolean kvinde, LocalDate tilmeldingsDato, int løbeNummer) {
        Tilmelding tilmelding = new Tilmelding(navn, kvinde, tilmeldingsDato, løbeNummer, this);
        tilmeldinger.add(tilmelding);
        return tilmelding;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public LocalDate getDato() {
        return dato;
    }

    public String getSted() {
        return sted;
    }

    public int getNormalPris() {
        return normalPris;
    }

    public LocalDate getEarlyBirdDate() {
        return earlyBirdDate;
    }

    public int getEarlyBirdPris() {
        return earlyBirdPris;
    }

    @Override
    public String toString() {
        return sted + " " + dato + " " + normalPris;
    }
}
