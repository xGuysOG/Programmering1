package model;

import model.Bestilling;

public class Plads {

    private int række;
    private int nr;
    private int pris;
    private Bestilling bestilling;
    public Plads(int række, int nr, int pris) {
        række = række;
        this.nr = nr;
        this.pris = pris;
    }

    public boolean checkPos(int x, int y){
        return række == x && getNr() == y;
    }

    public int getRække() {
        return række;
    }

    public void setRække(int række) {
        række = række;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Plads{" +
                "række=" + række +
                ", nr=" + nr +
                ", pris=" + pris +
                ", bestilling=" + bestilling +
                '}';
    }
}
