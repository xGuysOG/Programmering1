package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class SalgsAnnounce {
    private static int AntalAnnouncer = 0;
    private int announceNummer;
    private boolean aktiv;
    private LocalDate udløbsDato;

    private final ArrayList<Vare> varer = new ArrayList<>();
    private Sælger sælger;

    public SalgsAnnounce(Sælger sælger) {
        AntalAnnouncer++;
        this.announceNummer = AntalAnnouncer;
        this.aktiv = true;
        this.udløbsDato = LocalDate.now().plusMonths(1);
        this.sælger = sælger;
    }

    public void opdatereAnnounceStatus() {
        aktiv = LocalDate.now().isAfter(udløbsDato) || varerSolgt();
    }

    public boolean varerSolgt() {
        boolean solgt = false;

        Iterator<Vare> iterator = varer.iterator();
        while (!solgt && iterator.hasNext()) {
            Vare k = iterator.next();

            if (!k.isSolgt()) solgt = true;
        }

        return solgt;
    }

    public ArrayList<Vare> varerIKategori(VareKategori kategori) {
        ArrayList<Vare> varerIKategori = new ArrayList<>();

        for (Vare vare : varer) {
            if (vare.getKategori() == kategori) {
                varerIKategori.add(vare);
            }
        }

        return varerIKategori;
    }

    // TODO DOUBLE TJEK SENERE
    public int samletAnnounceUdbud() {
        int samletUdbud = 0;

        for (Vare vare : varer) {
            samletUdbud += vare.getUdbudsPris();
        }

        return samletUdbud;
    }

    public void setSælger(Sælger sælger) {
        this.sælger = sælger;
    }

    public void addVare(Vare vare) {
        if (!varer.contains(vare)) {
            varer.add(vare);
            vare.setSalgsAnnounce(this);
        }
    }


    public void removeVare(Vare vare) {
        if (varer.contains(vare)) {
            varer.remove(vare);
            vare.setSalgsAnnounce(null);
        }
    }


    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public void setUdløbsDato(LocalDate udløbsDato) {
        this.udløbsDato = udløbsDato;
    }

    public int getAntalAnnouncer() {
        return AntalAnnouncer;
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

    @Override
    public String toString() {
        return announceNummer + " " + sælger.getNavn() + " " + udløbsDato;
    }
}
