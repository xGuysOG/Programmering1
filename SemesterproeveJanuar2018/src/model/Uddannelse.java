package model;

import java.util.ArrayList;

public class Uddannelse {

    private String navn;

    private ArrayList<Hold> holdListe = new ArrayList<>();
    public Uddannelse(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void addHold(Hold hold){
        this.holdListe.add(hold);
    }

    public ArrayList<Hold> getHoldUdenTutor() {
        ArrayList<Hold> holdne = new ArrayList<>();
        for(Hold hold : holdListe) {
            if (hold.getTutore().size() < 1) {
                holdne.add(hold);
            }
        }
        return holdne;
    }
//    Tilføj følgende metode til klassen Uddannelse der returnerer en ArrayList med String objekter.
//    Hver String i listen skal indeholde oplysninger om en tutor der er tilknyttet et hold. Dvs. navn på
//    tutor, uddannelsens navn, holdets betegnelse, tutorens email og holdets holdleder i den angivne
//    rækkefølge.
//    public ArrayList<String> tutorOversigt()
    public ArrayList<String> tutorOversigt(){
        ArrayList<String> tutorer = new ArrayList<>();
        for(Hold hold : holdListe){
            for(Tutor tutor : hold.getTutore()){
                tutorer.add(tutor.getNavn() +" " + navn + " " + hold.getBetegnelse() +" " + tutor.getEmail() + " " + hold.getHoldLeder());
            }
        }
        return tutorer;
    }

    @Override
    public String toString() {
        return "Uddannelse{" +
                "navn='" + navn + '\'' +
                ", holdListe=" + holdListe +
                '}';
    }
}
