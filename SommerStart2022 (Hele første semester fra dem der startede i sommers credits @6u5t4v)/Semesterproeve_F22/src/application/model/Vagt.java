package application.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Vagt {
    private String navn;
    private LocalDateTime tidFra;
    private LocalDateTime tidTil;

    private ArrayList<Antal> antalListe = new ArrayList<>();
    private ArrayList<Medarbejder> medarbejdere = new ArrayList<>();

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
    }

    public String status() {
        String status = "Resourcer tildelt";
        int antalIndex = 0;

        while (antalIndex < antalListe.size()) {
            Antal antal = antalListe.get(antalIndex);

            int tilknyttetFunktion = 0;

            for (Medarbejder medarbejder : medarbejdere) {
                if (medarbejder.getFunktioner().contains(antal.getFunktion())) {
                    tilknyttetFunktion++;
                }
            }

            if (tilknyttetFunktion < antal.getAntal()) {
                return "Manglende resourcer";
            }

            antalIndex++;
        }

        return status;
    }

    public Medarbejder[] skalAdviseresOmMødetid() {
        ArrayList<Medarbejder> list = new ArrayList<>();

        LocalTime tidFraTidspunkt = tidFra.toLocalTime();
        for (Medarbejder medarbejder : medarbejdere) {
            if (medarbejder.getTypiskMødetid().isAfter(tidFraTidspunkt)) {
                list.add(medarbejder);
            }
        }

        Medarbejder[] medarbejdere = new Medarbejder[list.size()];
        for (int i = 0; i < list.size(); i++) {
            medarbejdere[i] = list.get(i);
        }

        return medarbejdere;
    }

    public int antalMedarbejdereMedFunktion(Funktion funktion) {
        int count = 0;
        for (Medarbejder medarbejder : medarbejdere) {
            if (medarbejder.getFunktioner().contains(funktion)) count++;
        }

        return count;
    }

    public int beregnTimeforbrug() {
        long hours = tidFra.until(tidTil, ChronoUnit.HOURS);
        return (int) hours;
    }

    public Medarbejder findMedarbejder(LocalTime tidspunkt, int antalTimer) {
        Medarbejder medarbejder = null;
        int index = 0;
        while (medarbejder == null || index < medarbejdere.size()) {
            Medarbejder kandidat = medarbejdere.get(index);
            if (kandidat.getTypiskMødetid().equals(tidspunkt) &&
                    kandidat.getAntalTimerPrDag() >= antalTimer) {
                medarbejder = kandidat;
            } else index++;
        }

        return medarbejder;
    }

    public void addMedarbejder(Medarbejder medarbejder) {
        if (!medarbejdere.contains(medarbejder)) {
            medarbejdere.add(medarbejder);
            medarbejder.addVagt(this);
        }
    }

    public void removeMedarbejder(Medarbejder medarbejder) {
        if (medarbejdere.contains(medarbejder)) {
            medarbejdere.remove(medarbejder);
            medarbejder.removeVagt(this);
        }
    }

    public ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    public Antal createAntal(int antalMedarbejdere, Funktion funktion) {
        Antal antal = new Antal(antalMedarbejdere, funktion);
        antalListe.add(antal);
        return antal;
    }

    public ArrayList<Antal> getAntalListe() {
        return new ArrayList<>(antalListe);
    }

    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }

    public String description() {
        StringBuilder desc = new StringBuilder("Navn: " + navn + "\n" +
                "Fra: " + tidFra + "\n" +
                "Til: " + tidTil + "\n" +
                "Status: " + status() + "\n" +
                "Tilknyttede medarbejdere: \n");

        for (Medarbejder medarbejder : medarbejdere) {
            desc.append(medarbejder.getNavn()).append(" ");
        }

        return desc.toString();
    }

    @Override
    public String toString() {
        return navn;
    }
}
