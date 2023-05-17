package Opgave3;

public class Klub {
    String navn;

    int wins;

    int losses;
    String[] spillere;
    String[] bænken;
    String division;

    public Klub(String navn, String division) {
        this.navn = navn;
        this.division = division;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String[] getSpillere() {
        return spillere;
    }

    public void setSpillere(String[] spillere) {
        this.spillere = spillere;
    }

    public String[] getBænken() {
        return bænken;
    }

    public void setBænken(String[] bænken) {
        this.bænken = bænken;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
