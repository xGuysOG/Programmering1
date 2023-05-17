package application.model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Parkeringsplads {
    private int nummer;
    private LocalTime ankomst;
    private double pris;
    private Bil bil;
    private Parkeringshus parkeringshus;

    public Parkeringsplads(int nummer, Parkeringshus phus) {
        this.nummer = nummer;
        this.parkeringshus = phus;
        this.pris = 6;
    }

    public void hentBil(LocalTime afgangsTidspunkt) {
        double ophold = prisForOphold(afgangsTidspunkt);
        double saldo = parkeringshus.getSaldo();

        parkeringshus.setSaldo(saldo + ophold);

        parkeringshus.removeParkeringsplads(this);
    }

    public double prisForOphold(LocalTime leave) {
        int minutes = (int) ankomst.until(leave, ChronoUnit.MINUTES);
        int tenth = (minutes / 10) + 1;
        return tenth * pris;
    }

    public void setBil(Bil bil) {
        if (bil != null) {
            ankomst = LocalTime.now();
        } else {
            ankomst = null;
        }

        this.bil = bil;
    }

    public int getNummer() {
        return nummer;
    }

    public LocalTime getAnkomst() {
        return ankomst;
    }

    public Bil getBil() {
        return bil;
    }

    public void setParkeringshus(Parkeringshus parkeringshus) {
        this.parkeringshus = parkeringshus;
    }
}
