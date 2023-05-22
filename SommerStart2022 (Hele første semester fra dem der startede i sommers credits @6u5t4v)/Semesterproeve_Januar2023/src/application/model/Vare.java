package application.model;

public class Vare {
    private VareKategori kategori;
    private String navn;
    private int udbudsPris;
    private boolean solgt;

    private SalgsAnnounce salgsAnnounce;

    public Vare(VareKategori kategori, String navn, int udbudsPris) {
        this.kategori = kategori;
        this.navn = navn;
        this.udbudsPris = udbudsPris;
        this.solgt = false;
    }

    public void setSalgsAnnounce(SalgsAnnounce salgsAnnounce) {
        if (this.salgsAnnounce != salgsAnnounce) {
            SalgsAnnounce old = this.salgsAnnounce;
            if (old != null) {
                old.removeVare(this);
            }
            this.salgsAnnounce = salgsAnnounce;
            if (salgsAnnounce != null) {
                salgsAnnounce.addVare(this);
            }
        }
    }

    public void setSolgt(boolean solgt) {
        this.solgt = solgt;
    }

    public SalgsAnnounce getSalgsAnnounce() {
        return salgsAnnounce;
    }

    public VareKategori getKategori() {
        return kategori;
    }

    public String getNavn() {
        return navn;
    }

    public int getUdbudsPris() {
        return udbudsPris;
    }

    public boolean isSolgt() {
        return solgt;
    }

    @Override
    public String toString() {
        String status = solgt ? "solgt" : "til salg";
        return navn + " " + udbudsPris + " " + status;
    }
}
