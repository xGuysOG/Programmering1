package model;

import java.util.ArrayList;

public class Sælger {
    private String navn;
    private int studiekortNummer;
    private String mobil;

    private ArrayList<Salgsannonce> salgsAnoncer;

    public Sælger(String navn, int studiekortNummer, String mobil) {
        this.navn = navn;
        this.studiekortNummer = studiekortNummer;
        this.mobil = mobil;
        this.salgsAnoncer = new ArrayList<>();
    }

    public ArrayList<Vare> alleIkkesolgteVarerIKategori(Varekategori kategori){
        ArrayList<Vare> varene = new ArrayList<>();

        for(Salgsannonce salgsAnonce : salgsAnoncer) {
            if (salgsAnonce.isAktiv()){
                for(Vare vare : salgsAnonce.getVarer()) {
                    if (!vare.isSolgt() && vare.getKategori() == kategori) {
                        varene.add(vare);
                    }
                }
            }
        }
        return varene;
    }

    public void AddSalgsannonce(Salgsannonce salgsannonce){
        this.salgsAnoncer.add(salgsannonce);
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

    public ArrayList<Salgsannonce> getSalgsAnoncer() {
        return salgsAnoncer;
    }

    @Override
    public String toString() {
        return "Sælger{" +
                "navn='" + navn + '\'' +
                ", studiekortNummer=" + studiekortNummer +
                ", mobil='" + mobil + '\'' +
                ", salgsAnoncer=" + salgsAnoncer +
                '}';
    }
}
