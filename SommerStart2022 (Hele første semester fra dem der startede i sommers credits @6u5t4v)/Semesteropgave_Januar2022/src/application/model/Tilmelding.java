package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding implements Comparable<Tilmelding> {
    private String navn;
    private boolean kvinde;
    private LocalDate tilmeldingsDato;
    private int løbeNummer;
    private int løbeTid;

    private ArrayList<Note> noter = new ArrayList<>();
    private Løb løb;

    Tilmelding(String navn, boolean kvinde, LocalDate tilmeldingsDato, int løbeNummer, Løb løb) {
        this.navn = navn;
        this.kvinde = kvinde;
        this.tilmeldingsDato = tilmeldingsDato;
        this.løbeNummer = løbeNummer;
        this.løbeTid = -1;
        this.løb = løb;
    }

    public int resultatTid() {
        int straf = 0;
        for (Note note : noter) {
            straf += note.getStrafSekunder();
        }
        return løbeTid + straf;
    }

    public void registrerStrafPåForhindring(String navnForhindring, int strafSekunder) {
        Forhindring forhindring = løb.findForhindring(navnForhindring);
        createNote(strafSekunder, forhindring);
    }

    public Note createNote(int strafSekunder, Forhindring forhindring) {
        Note note = new Note(strafSekunder, forhindring);
        noter.add(note);
        return note;
    }

    public ArrayList<Note> getNoter() {
        return new ArrayList<>(noter);
    }

    public String getNavn() {
        return navn;
    }

    public boolean isKvinde() {
        return kvinde;
    }

    public LocalDate getTilmeldingsDato() {
        return tilmeldingsDato;
    }

    public int getLøbeNummer() {
        return løbeNummer;
    }

    public int getLøbeTid() {
        return løbeTid;
    }

    public Løb getLøb() {
        return løb;
    }

    public void setLøbeTid(int løbeTid) {
        this.løbeTid = løbeTid;
    }

    public String resultat() {
        return løbeNummer + " " + navn + " " + resultatTid() + " " + noter.size();
    }

    @Override
    public String toString() {
        return løbeNummer + " " + navn;
    }

    @Override
    public int compareTo(Tilmelding o) {
        int comp = kvinde != o.kvinde ? 1 : 0;

        // Dette er ikke rigtigt
        if (comp == 0) {
            return resultatTid() - o.resultatTid();
        }
        return comp;
    }
}
