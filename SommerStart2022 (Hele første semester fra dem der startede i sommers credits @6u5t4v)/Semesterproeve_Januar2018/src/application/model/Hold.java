package application.model;

import java.util.ArrayList;

public class Hold {
    private String betegnelse;
    private String holdLeder;

    private Uddannelse uddannelse;
    private final ArrayList<Tutor> tutore = new ArrayList<>();

    public Hold(String betegnelse, String holdLeder, Uddannelse uddannelse) {
        this.betegnelse = betegnelse;
        this.holdLeder = holdLeder;
        this.uddannelse = uddannelse;
    }

    public boolean harTidsoverlap(Arrangement arrangement) {
        int index = 0;
        boolean overlap = false;

        while (!overlap && index < tutore.size()) {
            Tutor tutor = tutore.get(index);

            overlap = tutor.tidsOverlap(arrangement);
        }

        return overlap;
    }

    public double arrangementsPris() {
        double pris = 0;

        for (Tutor tutor : tutore) {
            pris += tutor.arrangementPris();
        }

        return pris;
    }

    public void addTutor(Tutor tutor) {
        if (!tutore.contains(tutor)) {
            tutore.add(tutor);
            tutor.setHold(this);
        }
    }

    public void removeTutor(Tutor tutor) {
        if (tutore.contains(tutor)) {
            tutore.remove(tutor);
            tutor.setHold(null);
        }
    }

    public void setUddannelse(Uddannelse uddannelse) {
        if (this.uddannelse != uddannelse) {
            Uddannelse oldUddannelse = this.uddannelse;

            if (oldUddannelse != null) {
                oldUddannelse.removeHold(this);
            }

            this.uddannelse = uddannelse;
            if (uddannelse != null) {
                uddannelse.addHold(this);
            }
        }
    }

    public ArrayList<Tutor> getTutore() {
        return new ArrayList<>(tutore);
    }

    public Uddannelse getUddannelse() {
        return uddannelse;
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public String getHoldLeder() {
        return holdLeder;
    }
}
