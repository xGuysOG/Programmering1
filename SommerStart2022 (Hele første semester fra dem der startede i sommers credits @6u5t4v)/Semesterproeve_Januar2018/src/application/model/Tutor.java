package application.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Tutor {
    private String navn;
    private String email;

    private Hold hold;
    private ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public double arrangementPris() {
        double totalPris = 0;

        for (Arrangement arrangement : arrangementer) {
            totalPris += arrangement.getPris();
        }

        return totalPris;
    }

    public void addArrangement(Arrangement arrangement) {
        if (!arrangementer.contains(arrangement)) {
            arrangementer.add(arrangement);
        }
    }

    public boolean tidsOverlap(Arrangement arrangement) {
        for (Arrangement tilmeldtArr : arrangementer) {
            if (arrangement.getDato().equals(tilmeldtArr.getDato())) {
                if (overlapper(tilmeldtArr, arrangement)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean overlapper(Arrangement tilmeldt, Arrangement arrangement) {
        LocalTime start1 = tilmeldt.getStartTid(), slut1 = tilmeldt.getSlutTid(),
                slut2 = arrangement.getSlutTid();

        return start1.isBefore(slut2) && slut1.isAfter(start1);
    }

    public void removeArrangement(Arrangement arrangement) {
        arrangementer.remove(arrangement);
    }

    public void setHold(Hold hold) {
        if (this.hold != hold) {
            Hold oldHold = this.hold;
            if (oldHold != null) {
                oldHold.removeTutor(this);
            }

            this.hold = hold;
            if (hold != null) {
                hold.addTutor(this);
            }
        }
    }

    public Hold getHold() {
        return hold;
    }

    public ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return navn + " " + email;
    }
}
