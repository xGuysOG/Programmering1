package Opgave2;

import java.util.ArrayList;

public class Konto {


    private int nr;
    private KontoType kontoType;
    private ArrayList<Transaktion> transaktioner = new ArrayList<>();

    public Konto(int nr, KontoType kontoType) {
        this.nr = nr;
        this.kontoType = kontoType;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public KontoType getKontoType() {
        return kontoType;
    }

    public void setKontoType(KontoType kontoType) {
        this.kontoType = kontoType;
    }

    public ArrayList<Transaktion> getTransaktioner() {
        return transaktioner;
    }

    public void addTransaktion(Transaktion transaktion) {
        transaktioner.add(transaktion);
    }

    public void removeTransaktion(Transaktion transaktion) {
        transaktioner.remove(transaktion);
    }

    public void setTransaktioner(ArrayList<Transaktion> transaktioner) {
        this.transaktioner = transaktioner;
    }

    @Override
    public String toString() {
        return "Konto{" +
                "nr=" + nr +
                ", kontoType=" + kontoType +
                ", transaktioner=" + transaktioner +
                '}';
    }
}
