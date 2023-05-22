package application.model;

import java.util.ArrayList;

public class Sælger implements Comparable<Sælger> {
    private String navn;
    private int studiekortNummer;
    private String mobil;

    private final ArrayList<SalgsAnnounce> salgsAnnouncer = new ArrayList<>();

    public Sælger(String navn, int studiekortNummer, String mobil) {
        this.navn = navn;
        this.studiekortNummer = studiekortNummer;
        this.mobil = mobil;
    }

    public ArrayList<SalgsAnnounce> aktiveSalgsAnnouncer() {
        ArrayList<SalgsAnnounce> aktiveSalgsAnnouncer = new ArrayList<>();

        for (SalgsAnnounce salgsAnnounce : salgsAnnouncer) {
            if (salgsAnnounce.isAktiv()) {
                aktiveSalgsAnnouncer.add(salgsAnnounce);
            }
        }

        return salgsAnnouncer;
    }

    public ArrayList<Vare> alleIkkeSolgteVarerIKategori(VareKategori kategori) {
        ArrayList<Vare> varerIkkeSolgt = new ArrayList<>();

        for (SalgsAnnounce salgsAnnounce : salgsAnnouncer) {
            if (salgsAnnounce.isAktiv()) {
                ArrayList<Vare> vareIKategori = salgsAnnounce.varerIKategori(kategori);

                for (Vare vare : vareIKategori) {
                    if (!vare.isSolgt()) {
                        varerIkkeSolgt.add(vare);
                    }
                }
            }
        }

        return varerIkkeSolgt;
    }

    public SalgsAnnounce createSalgsAnnounce() {
        SalgsAnnounce salgsAnnounce = new SalgsAnnounce(this);
        salgsAnnouncer.add(salgsAnnounce);
        return salgsAnnounce;
    }

    public void addSalgsAnnounce(SalgsAnnounce salgsAnnounce) {
        if (!salgsAnnouncer.contains(salgsAnnounce)) {
            salgsAnnouncer.add(salgsAnnounce);
            salgsAnnounce.setSælger(this);
        }
    }

    public void removeSalgsAnnounce(SalgsAnnounce salgsAnnounce) {
        salgsAnnouncer.remove(salgsAnnounce);
    }

    public ArrayList<SalgsAnnounce> getSalgsAnnouncer() {
        return new ArrayList<>(salgsAnnouncer);
    }

    public String getNavn() {
        return navn;
    }

    public int getStudiekortNummer() {
        return studiekortNummer;
    }

    public String getMobil() {
        return mobil;
    }

    @Override
    public int compareTo(Sælger o) {
        return navn.compareTo(o.getNavn());
    }
}
