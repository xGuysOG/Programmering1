package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Tutor {
    private String navn;
    private String email;

    private Hold hold;

    public ArrayList<Arrangement> getArrangementer() {
        return arrangementer;
    }

    public void setArrangementer(ArrayList<Arrangement> arrangementer) {
        this.arrangementer = arrangementer;
    }

    private ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }


    public double arrangementsPris(){
        double totalPris = 0;
        for(Arrangement arrangement : arrangementer) {
            totalPris += arrangement.getPris();
        }
        return totalPris;
    }
}