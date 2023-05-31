package model;

import java.util.ArrayList;
import java.util.Collections;

public class Patient {

    private String navn;
    private double vægt;
    private int vægtFaktor;

    private ArrayList<PersonligtMåltid> personligtMåltider = new ArrayList<>();

    public Patient(String navn, double vægt, int vægtFaktor){
        this.navn = navn;
        this.vægt = vægt;
        this.vægtFaktor = vægtFaktor;
    }

    public double beregnAnbefaletKalorierPerDag(){
        return vægtFaktor * vægt;
    }

    public double beregnDagensAntalKalorier(){
        double toReturn = 0;
        for(PersonligtMåltid personligtMåltid : personligtMåltider){
            toReturn += personligtMåltid.beregnAntalKalorier();
        }
        return toReturn;
    }

    public void addMåltid(PersonligtMåltid personligtMåltid){
        personligtMåltider.add(personligtMåltid);
    }

    public void sortMåltider(){
        Collections.sort(personligtMåltider);
    }

    public double beregnProcentDagligAnbefalet(){
        double anbefalet = beregnAnbefaletKalorierPerDag();
        double indtaget = beregnDagensAntalKalorier();
        double procent = (indtaget / anbefalet) * 100.0;
        return procent;

    }

    public String getNavn() {
        return navn;
    }

    public double getVægt() {
        return vægt;
    }

    public int getVægtFaktor() {
        return vægtFaktor;
    }

    public ArrayList<PersonligtMåltid> getPersonligtMåltider() {
        return personligtMåltider;
    }

    @Override
    public String toString() {
        return navn + " - " + vægtFaktor + " - " + vægt;
    }
}
