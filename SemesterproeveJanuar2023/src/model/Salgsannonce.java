package model;

import javax.lang.model.element.Name;
import javax.naming.InvalidNameException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Salgsannonce {
    private static int antalAnnouncer = 0;
    private int announceNummer;
    private boolean aktiv;
    private LocalDate udløbsDato;
    private final ArrayList<Vare> varer = new ArrayList<>();
    private Sælger sælger;

    public Salgsannonce(Sælger sælger) {
        antalAnnouncer++;
        this.announceNummer = antalAnnouncer;
        this.aktiv = true;
        this.udløbsDato = LocalDate.now().plusMonths(1);
        this.sælger = sælger;
    }

    public int samletAnnonceUdbud(){
        int udbud = 0;
        for(Vare vare : varer) {
            udbud += vare.getUdbudspris();
        }
        return udbud;
    }

    public void updaterSalgsannonce() {
        if (LocalDate.now().isAfter(udløbsDato)) {
            aktiv = false;
        }

        boolean solgt = false;
        for(Vare vare : varer) {
            solgt = vare.isSolgt();
            if (!solgt) {
                return;
            }
        }
        if (solgt) {
            aktiv = false;
        }
    }

    public void tømVarer() {
        this.varer.clear();
    }


    public void addVare(Vare vare){
        varer.add(vare);
    }

    public static int getAntalAnnouncer() {
        return antalAnnouncer;
    }

    public int getAnnounceNummer() {
        return announceNummer;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public LocalDate getUdløbsDato() {
        return udløbsDato;
    }

    public ArrayList<Vare> getVarer() {
        return varer;
    }

    public Sælger getSælger() {
        return sælger;
    }

    @Override
    public String toString() {
        return announceNummer + " " + sælger.getNavn() + " " + udløbsDato.toString();
    }
}
