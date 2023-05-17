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

    private boolean overlapperTiden(Arrangement tilmeldt, Arrangement arrangement) {
        return tilmeldt.getStartTid().isBefore(arrangement.getSlutTid()) && tilmeldt.getSlutTid().isAfter(tilmeldt.getStartTid());
    }

    public boolean harTidsoverlap(Arrangement arrangement){
        for (Tutor tutor : tutore) {
            for (Arrangement tilArrangement : tutor.getArrangementer()) {
                if (arrangement.getDato().equals(tilArrangement.getDato())) {
                    if (overlapperTiden(tilArrangement, arrangement)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
