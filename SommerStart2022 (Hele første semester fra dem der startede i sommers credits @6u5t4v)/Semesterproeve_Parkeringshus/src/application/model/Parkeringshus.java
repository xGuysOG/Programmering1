package application.model;

import java.util.ArrayList;

public class Parkeringshus {
    private String adresse;

    private ArrayList<Parkeringsplads> parkeringspladser = new ArrayList<>();

    private double saldo;

    public Parkeringshus(String adresse) {
        this.adresse = adresse;
    }

    public ArrayList<String> optagnePladser() {
        ArrayList<String> optaget = new ArrayList<>();

        for (Parkeringsplads pp : parkeringspladser) {
            if (pp.getBil() != null) {
                String plads = "Plads " + pp.getNummer() + ": " + pp.getBil();
                optaget.add(plads);
            }
        }

        return optaget;
    }


    public int findAntalBiler(BilMærke brand) {
        int antal = 0;
        for (Parkeringsplads pp : parkeringspladser) {
            if (pp.getBil() == null && pp.getBil().getBrand() == brand) antal++;
        }
        return antal;
    }

    public int antalLedigePladser() {
        int ledige = 0;
        for (Parkeringsplads pp : parkeringspladser) {
            if (pp.getBil() == null) ledige++;
        }
        return ledige;
    }

    public int findPladsMedBil(String regNummer) {
        int i = 0;
        int plads = -1;

//        int optagetPladser = parkeringspladser.size() - antalLedigePladser();
//        System.out.println(optagetPladser);

        while (plads == -1 && i < parkeringspladser.size()) {
            Parkeringsplads k = parkeringspladser.get(i);
            Bil bil = k.getBil();

            if (bil != null && bil.getRegNr().equals(regNummer)) {
                plads = k.getNummer();
            } else {
                i++;
            }
        }

        return plads;
    }


    public ArrayList<Parkeringsplads> getParkeringspladser() {
        return new ArrayList<>(parkeringspladser);
    }

    public Parkeringsplads createParkeringsplads(int nummer) {
        Parkeringsplads pp = new Parkeringsplads(nummer, this);
        parkeringspladser.add(pp);
        return pp;
    }

    public Invalideplads createInvalideplads(int nummer, int areal) {
        Invalideplads pp = new Invalideplads(nummer, areal, this);
        parkeringspladser.add(pp);
        return pp;
    }

    public void addParkeringsplads(Parkeringsplads pp) {
        if (!parkeringspladser.contains(pp)) {
            pp.setParkeringshus(this);
            parkeringspladser.add(pp);
        }
    }

    public void removeParkeringsplads(Parkeringsplads pp) {
        if (parkeringspladser.contains(pp)) {
            pp.setParkeringshus(null);
            parkeringspladser.remove(pp);
        }
    }

    public String getAdresse() {
        return adresse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return adresse;
    }
}
