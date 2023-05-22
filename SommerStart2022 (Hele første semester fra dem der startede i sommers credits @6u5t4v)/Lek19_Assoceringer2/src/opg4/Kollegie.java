package opg4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kollegie {
    private String navn;
    private String adresse;

    private ArrayList<Bolig> boliger = new ArrayList<>();

    public Kollegie(String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    public Bolig createBolig(int kvm, String adresse, int prisPrMaaned) {
        Bolig bolig = new Bolig(kvm, adresse, prisPrMaaned, this);
        boliger.add(bolig);
        return bolig;
    }

    public void addBolig(Bolig bolig) {
        if (!boliger.contains(bolig)) {
            boliger.add(bolig);
            bolig.setKollegie(this);
        }
    }

    public void removeBolig(Bolig bolig) {
        if (boliger.contains(bolig)) {
            boliger.remove(bolig);
//            bolig.setKollegie(this);
        }
    }

    public int getAntalLejeaftaler() {
        int lejeaftaler = 0;

        for (Bolig bolig : boliger) {
            lejeaftaler += bolig.getLejeaftaler().size();
        }

        return lejeaftaler;
    }

    public int gennemsnitligAntalDage() {
        int days = 0;
        int lejeaftaler = 0;

        for (Bolig bolig : boliger) {
            for (Lejeaftale aftale : bolig.getLejeaftaler()) {
                if (aftale.getTilDato() != null) {
                    LocalDate fra = aftale.getFraDato();
                    LocalDate til = aftale.getTilDato();
                    days += fra.until(til).getDays();
                    lejeaftaler++;
                }
            }
        }

        return days / lejeaftaler;
    }

    public String getNavn() {
        return navn;
    }
}
