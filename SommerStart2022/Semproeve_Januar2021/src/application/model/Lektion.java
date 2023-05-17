package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {
    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;

    private ArrayList<Deltagelse> deltagelseList = new ArrayList<>();

    public Lektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag) {
        this.dato = dato;
        this.startTid = startTid;
        this.lokale = lokale;
        fag.addLektion(this);
    }

    public int totalFravær() {
        int total = 0;

        for (Deltagelse deltagelse : deltagelseList) {
            if (deltagelse.erRegistreretFravarende()) {
                total++;
            }
        }

        return total;
    }

    public Deltagelse createDeltagelse(Studerende studerende) {
        Deltagelse deltagelse = new Deltagelse(false, DeltagerStatus.TILSTEDE, studerende, this);
        deltagelseList.add(deltagelse);
        return deltagelse;
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        deltagelseList.remove(deltagelse);
    }

    public ArrayList<Deltagelse> getDeltagelseList() {
        return new ArrayList<>(deltagelseList);
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public String getLokale() {
        return lokale;
    }
}
