package application.model;

import java.util.ArrayList;

public class Frivillig implements Comparable<Frivillig> {
    private String navn;
    private String mobil;
    private int maksAntalTimer;

    private final ArrayList<Vagt> vagter = new ArrayList<>();

    public Frivillig(String navn, String mobil, int maksAntalTimer) {
        this.navn = navn;
        this.mobil = mobil;
        this.maksAntalTimer = maksAntalTimer;
    }

    public int ledigeTimer() {
        int ledigeTimer = maksAntalTimer;

        for (Vagt vagt : vagter) {
            ledigeTimer -= vagt.getTimer();
        }

        return ledigeTimer;
    }

    public void addVagt(Vagt vagt) {
        if (!vagter.contains(vagt)) {
            vagter.add(vagt);
            vagt.setFrivillig(this);
        }
    }

    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagt.setFrivillig(null);
            vagter.remove(vagt);
        }
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public int getMaksAntalTimer() {
        return maksAntalTimer;
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public String gaver() {
        return navn + " 1";
    }

    @Override
    public int compareTo(Frivillig o) {
        return navn.compareTo(o.navn);
    }

    @Override
    public String toString() {
        return navn + " " + mobil + " " + maksAntalTimer;
    }
}
