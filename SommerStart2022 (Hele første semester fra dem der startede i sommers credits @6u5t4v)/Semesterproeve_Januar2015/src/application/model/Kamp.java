package application.model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Kamp implements Comparable<Kamp> {
    private String sted;
    private LocalDate dato;
    private LocalTime tid;

    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Kamp(String sted, LocalDate dato, LocalTime tid) {
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    public void spillerHonorar(String tekstFil) {
        try (PrintWriter out = new PrintWriter(tekstFil)) {
            for (Deltagelse deltagelse : deltagelser) {
                Spiller spiller = deltagelse.getSpiller();
                int deltagerI = spiller.deltager().size();

                System.out.println(spiller.getNavn() + " " + spiller.kampHonorar());

                if (deltagerI > 0) {
                    out.println(spiller.getNavn() + " " + spiller.kampHonorar());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> afbud() {
        ArrayList<String> afbud = new ArrayList<>();
        for (Deltagelse deltagelse : deltagelser) {
            if (deltagelse.isAfbud()) {
                Spiller spiller = deltagelse.getSpiller();
                afbud.add(spiller.getNavn() + " " + deltagelse.getBegrundelse());
            }
        }

        return afbud;
    }

    public Deltagelse createDeltagelse(boolean afbud, String begrundelse, Spiller spiller) {
        Deltagelse deltagelse = new Deltagelse(afbud, begrundelse, spiller);
        spiller.addDeltagelse(deltagelse);
        deltagelser.add(deltagelse);
        return deltagelse;
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)) {
            deltagelser.add(deltagelse);
        }
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        deltagelser.remove(deltagelse);
    }

    public String getSted() {
        return sted;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    @Override
    public int compareTo(Kamp o) {
        int comp = dato.compareTo(o.getDato());

        if (comp == 0) {
            comp = tid.compareTo(o.getTid());
            if (comp == 0) {
                return sted.compareTo(o.getSted());
            }
            return comp;
        }

        return comp;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void setTid(LocalTime tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return sted + "  " + dato + "  " + tid;
    }
}
