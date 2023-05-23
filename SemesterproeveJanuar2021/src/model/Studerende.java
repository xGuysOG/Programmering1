package model;

import java.util.ArrayList;

public class Studerende {
    private String navn;
    private String email;

    private ArrayList<Deltagelse> deltagelser;

    public Studerende (String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public int antalFraværsLektioner(){
        int total = 0;
        for(Deltagelse deltagelse : deltagelser){
            if (deltagelse.erRegistreretFraværende()) {
                total++;
            }
        }
        return total;
    }
}
