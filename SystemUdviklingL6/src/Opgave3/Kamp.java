package Opgave3;

import java.time.LocalDate;

public class Kamp {

    String status;
    String score;
    Klub klub1;
    Klub klub2;
    String resultat;
    Medarbejder dommer;
    String domme;
    String bane;
    LocalDate afholdesestidspunkt;

    public Kamp(Klub klub1, Klub klub2) {
        this.klub1 = klub1;
        this.klub2 = klub2;
        this.status = "WAITING FOR DATA";
        this.bane = "WAITING FOR DATA";
    }

    public Kamp(Klub klub1, Klub klub2, LocalDate afholdesestidspunkt, String bane, Medarbejder dommer){
        this.klub1 = klub1;
        this.klub2 = klub2;
        this.status = "WAITING FOR DATA";
        this.bane = bane;
        this.afholdesestidspunkt = afholdesestidspunkt;
        this.dommer = dommer;
    }
    public Kamp(Klub klub1, Klub klub2, LocalDate afholdesestidspunkt){
        this.klub1 = klub1;
        this.klub2 = klub2;
        this.status = "WAITING FOR DATA";
        this.bane = "WAITING FOR DATA";
        this.afholdesestidspunkt = afholdesestidspunkt;
    }

    public void startKamp() {
        this.status = "ONGOING";

    }

    public void slutKamp() {
        this.status = "ENDED";
        String[] scores = score.split(" | ");
        if (Integer.parseInt(scores[0]) > Integer.parseInt(scores[1])) {
            klub1.setWins(klub1.getWins() + 1);
            klub2.setLosses(klub2.getLosses() + 1);
            resultat = "Klub 1 wins with a score of " + scores[0] + " - " + scores[1];
        } else {
            klub2.setWins(klub2.getWins() + 1);
            klub1.setLosses(klub1.getLosses() + 1);
            resultat = "Klub 2 wins with a score of " + scores[1] + " - " + scores[0];
        }
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Klub getKlub1() {
        return klub1;
    }

    public void setKlub1(Klub klub1) {
        this.klub1 = klub1;
    }

    public Klub getKlub2() {
        return klub2;
    }

    public void setKlub2(Klub klub2) {
        this.klub2 = klub2;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Medarbejder getDommer() {
        return dommer;
    }

    public void setDommer(Medarbejder dommer) {
        this.dommer = dommer;
    }

    public String getDomme() {
        return domme;
    }

    public void setDomme(String domme) {
        this.domme = domme;
    }

    public String getBane() {
        return bane;
    }

    public void setBane(String bane) {
        this.bane = bane;
    }

    public LocalDate getAfholdesestidspunkt() {
        return afholdesestidspunkt;
    }

    public void setAfholdesestidspunkt(LocalDate afholdesestidspunkt) {
        this.afholdesestidspunkt = afholdesestidspunkt;
    }



}
