package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Festival {
    private String navn;
    private LocalDate fraDato;
    private LocalDate tilDato;

    // Link attributer
    private ArrayList<Job> jobs = new ArrayList<>();

    public Festival(String navn, LocalDate fraDato, LocalDate tilDato) {
        this.navn = navn;
        this.fraDato = fraDato;
        this.tilDato = tilDato;
    }

    public ArrayList<String> gaverTilFrivillige() {
        ArrayList<String> gaver = new ArrayList<>();

        ArrayList<Frivillig> frivillige = frivilligeAnsat();
        for (Frivillig frivillig : frivillige) {
            gaver.add(frivillig.gaver());
        }

        return gaver;
    }

    public ArrayList<Frivillig> frivilligeAnsat() {
        ArrayList<Frivillig> frivillige = new ArrayList<>();

        for (Job job : jobs) {
            for (Vagt vagt : job.getVagter()) {
                Frivillig frivillig = vagt.getFrivillig();

                if (!frivillige.contains(frivillig)) {
                    frivillige.add(frivillig);
                }
            }
        }

        Collections.sort(frivillige);

        return frivillige;
    }

    public int realiseretJobUdgift() {
        int budget = 0;

        for (Job job : jobs) {
            int hours = 0;
            for (Vagt vagt : job.getVagter()) {
                hours += vagt.getTimer();
            }

            budget += job.getTimeHonorar() * hours;
        }

        return budget;
    }

    public int budgetteretJobUdgift() {
        int budget = 0;
        for (Job job : jobs) {
            budget += job.getAntalTimer() * job.getTimeHonorar();
        }

        return budget;
    }

    public Job createJob(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        Job job = new Job(kode, beskrivelse, dato, timeHonorar, antalTimer);
        jobs.add(job);
        return job;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public ArrayList<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    @Override
    public String toString() {
        return navn + " " + fraDato + " " + tilDato;
    }
}
