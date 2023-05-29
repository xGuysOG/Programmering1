package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Vagt {
    private String navn;
    private LocalDateTime tidFra;


    private LocalDateTime tidTil;

    private ArrayList<Antal> antals = new ArrayList<>();
    private ArrayList<Medarbejder> medarbejdere = new ArrayList<>();

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil){
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
    }

    public void removeMedarbejder(Medarbejder medarbejder) {
        if (medarbejdere.contains(medarbejder)) {
            medarbejdere.remove(medarbejder);
            medarbejder.removeVagt(this);
        }
    }

    public Antal createAntal(int antalMedarbejdere, Funktion funktion) {
        Antal antal = new Antal(antalMedarbejdere, funktion);
        antals.add(antal);
        return antal;
    }

    public Medarbejder findMedarbejder(LocalTime tidspunkt, int antalTimer) {
        Medarbejder medarbejderToReturn = null;
        int index = 0;
        while (medarbejderToReturn == null || index < medarbejdere.size()) {
            Medarbejder medarbejder = medarbejdere.get(index);
            if (medarbejder.getTypiskMødetid().equals(tidspunkt) &&
                medarbejder.getAntalTimerPrDag() >= antalTimer) {
                medarbejderToReturn = medarbejder;
            } else index++;
        }
        return medarbejderToReturn;
    }

    public int beregnTimeforbrug(){
        Duration duration = Duration.between(tidFra, tidTil);
        int math = (int) (duration.toHours() * medarbejdere.size());
        return (int) Math.ceil(math);
    }

    public int antalMedarbejdereMedFunktion(Funktion funktion){
        int amount = 0;
        for(Medarbejder medarbejder : medarbejdere){
            for(Funktion funktion1 : medarbejder.getFunktioner()){
                if(funktion1.equals(funktion)){
                    amount++;
                    break;
                }
            }
        }
        return amount;
    }
    public Medarbejder[] skalAdviseresOmMødetid(){
        Medarbejder[] medarbejdereMedSenereMødetid = new Medarbejder[medarbejdere.size()];
        int sizeNeeded = 0;
        //we make an array thats too big

        for(Medarbejder medarbejder : medarbejdere){
            if (medarbejder.getTypiskMødetid().isAfter(LocalTime.from(tidFra))) {
                medarbejdereMedSenereMødetid[sizeNeeded] = medarbejder;
                sizeNeeded++;
            }
        }
        //then we fill it up starting at 0 and save the size

        Medarbejder[] trimmedArray = new Medarbejder[sizeNeeded];
        for (int i = 0; i < sizeNeeded; i++) {
            trimmedArray[i] = medarbejdereMedSenereMødetid[i];
        }
        //since we started at 0 before we can now just move them from the array and return it

        return trimmedArray;

    }

    public void addMedarbejder(Medarbejder medarbejder) {
        if (!medarbejdere.contains(medarbejder)) {
            medarbejdere.add(medarbejder);
            medarbejder.addVagt(this);
        }
    }
    public String status() {
        int index = 0;
        //fuck this shit im out mhmm
        String status = "Resourcer tildelt";
        while (index < antals.size()) {
            Antal antal = antals.get(index);
            //we need to check if antal is bigger or smaller then amount of functions
            int antalFunktioner = 0;
            for(Medarbejder medarbejder : medarbejdere){
                if (medarbejder.getFunktioner().contains(antal.getFunktion())){
                    //the antal connected to this vagt fits so now we add one to the amount
                    antalFunktioner++;
                }
            }
            if (antalFunktioner < antal.getAntal()){
                status = "Manglende resourcer";
            }
            index++;
        }
        return status;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }

    public ArrayList<Antal> getAntals() {
        return antals;
    }

    public ArrayList<Medarbejder> getMedarbejdere() {
        return medarbejdere;
    }


}
