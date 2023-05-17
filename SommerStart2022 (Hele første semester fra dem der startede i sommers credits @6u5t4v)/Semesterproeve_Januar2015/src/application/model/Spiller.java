package application.model;

import java.util.ArrayList;

public class Spiller {
    private String navn;
    private int årgang;

    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Spiller(String navn, int årgang) {
        this.navn = navn;
        this.årgang = årgang;
    }

    public double kampHonorar() {
        int count = deltager().size();
        return count * 10;
    }

    public ArrayList<Deltagelse> deltager() {
        ArrayList<Deltagelse> deltagerI = new ArrayList<>();

        for (Deltagelse deltagelse : deltagelser) {
            if (!deltagelse.isAfbud()) deltagerI.add(deltagelse);
        }
        return deltagerI;
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)) {
            deltagelser.add(deltagelse);
            deltagelse.setSpiller(this);
        }
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        if (deltagelser.contains(deltagelse)) {
            deltagelser.remove(deltagelse);
            deltagelse.setSpiller(null);
        }
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public String getNavn() {
        return navn;
    }

    public int getÅrgang() {
        return årgang;
    }
}
