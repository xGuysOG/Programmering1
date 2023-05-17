package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Job {
    private String kode;
    private String beskrivelse;
    private LocalDate dato;
    private int timeHonorar;
    private int antalTimer;

    // Link attributer
    private ArrayList<Vagt> vagter = new ArrayList<>();


    public Job(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        this.kode = kode;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.timeHonorar = timeHonorar;
        this.antalTimer = antalTimer;
    }

    public int ikkeBesatteTimer() {
        int timer = antalTimer;

        for (Vagt vagt : vagter) {
            timer -= vagt.getTimer();
        }

        return timer;
    }


    public Vagt createVagt(int timer, Frivillig frivillig) {
        Vagt vagt = new Vagt(timer, frivillig, this);
        vagter.add(vagt);
        return vagt;
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public String getKode() {
        return kode;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getTimeHonorar() {
        return timeHonorar;
    }

    public int getAntalTimer() {
        return antalTimer;
    }

    @Override
    public String toString() {
        return kode + " " + beskrivelse;
    }
}
