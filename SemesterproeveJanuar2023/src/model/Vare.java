package model;

public class Vare {

    private Varekategori kategori;
    private String navn;
    private int udbudspris;
    private boolean solgt = false;
    private Salgsannonce salgsannonce;

    public Salg salg;

    public Vare(Varekategori kategori, String navn, int udbudspris){
        this.kategori = kategori;
        this.navn = navn;
        this.udbudspris = udbudspris;
    }

    public void setSalgsannonce(Salgsannonce salgsannonce) {
        if (this.salgsannonce != salgsannonce) {
            if (this.salgsannonce != null) {
                this.salgsannonce.tømVarer();
            }
            this.salgsannonce = salgsannonce;
        }
    }

    public void setSalg(Salg salg){
        this.salg = salg;
    }
    public void setSolgt(boolean solgt) {
        this.solgt = solgt;
    }
    public Varekategori getKategori() {
        return kategori;
    }

    public String getNavn() {
        return navn;
    }

    public int getUdbudspris() {
        return udbudspris;
    }

    public boolean isSolgt() {
        return solgt;
    }

    public Salgsannonce getSalgsannonce() {
        return salgsannonce;
    }

    @Override
    public String toString() {
        return "Vare{" +
                "kategori=" + kategori +
                ", navn='" + navn + '\'' +
                ", udbudspris=" + udbudspris +
                ", solgt=" + solgt +
                '}';
    }
}
