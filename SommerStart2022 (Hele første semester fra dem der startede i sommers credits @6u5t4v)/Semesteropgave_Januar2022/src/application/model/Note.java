package application.model;

public class Note {
    private int strafSekunder;

    private Forhindring forhindring;

    Note(int strafSekunder, Forhindring forhindring) {
        this.strafSekunder = strafSekunder;
        this.forhindring = forhindring;
    }

    public int getStrafSekunder() {
        return strafSekunder;
    }

    public Forhindring getForhindring() {
        return forhindring;
    }

    @Override
    public String toString() {
        return forhindring.getNavn() + " Straftid: " + strafSekunder + " sek";
    }
}
