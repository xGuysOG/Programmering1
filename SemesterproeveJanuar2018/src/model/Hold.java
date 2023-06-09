package model;

import java.util.ArrayList;

public class Hold {
    private String betegnelsen;
    private String holdLeder;

    private Uddannelse uddannelse;

    private final ArrayList<Tutor> tutore = new ArrayList<>();

    public Hold(String betegnelsen, String holdLeder) {
        this.betegnelsen = betegnelsen;
        this.holdLeder = holdLeder;
    }

    public double arrangementsPris() {
        double totalPris = 0;
        for(Tutor tutor : tutore) {
            totalPris += tutor.arrangementsPris();
        }
        return totalPris;
    }

    public void addTutor(Tutor tutor){
        tutore.add(tutor);
    }

    public boolean harTidsoverlap(Arrangement arrangement){
        for (Tutor tutor : tutore) {
            for (Arrangement tilArrangement : tutor.getArrangementer()) {
                if (arrangement.getDato().equals(tilArrangement.getDato())) {
                    if (tutor.harTidsOverlap(tilArrangement, arrangement)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Tutor> getTutore() {
        return tutore;
    }

    public String getHoldLeder(){
        return holdLeder;
    }
    public String getBetegnelse() {
       return this.betegnelsen;
    }

    @Override
    public String toString() {
        return "Hold{" +
                "betegnelsen='" + betegnelsen + '\'' +
                ", holdLeder='" + holdLeder + '\'' +
                ", uddannelse=" + uddannelse +
                ", tutore=" + tutore +
                '}';
    }
}
