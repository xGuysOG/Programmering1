package opg4;

import java.util.ArrayList;

public class Bolig {
    private int kvm;
    private String adresse;
    private int prisPrMaaned;

    private Kollegie kollegie;

    private ArrayList<Lejeaftale> lejeaftaler = new ArrayList<Lejeaftale>();

    Bolig(int kvm, String adresse, int prisPrMaaned, Kollegie kollegie) {
        this.kvm = kvm;
        this.adresse = adresse;
        this.prisPrMaaned = prisPrMaaned;
        this.kollegie = kollegie;
    }

    public ArrayList<Lejeaftale> getLejeaftaler() {
        return new ArrayList<>(lejeaftaler);
    }

    public Lejeaftale lavLejeaftale() {
        Lejeaftale lejeaftale = new Lejeaftale(this);
        lejeaftaler.add(lejeaftale);

        return lejeaftale;
    }

    public void setKollegie(Kollegie kollegie) {
        if (this.kollegie != kollegie) {
            Kollegie oldKollegie = this.kollegie;
            if (oldKollegie != null) {
                oldKollegie.removeBolig(this);
            }

            this.kollegie = kollegie;
            if (kollegie != null) {
                kollegie.addBolig(this);
            }
        }
    }

    public Kollegie getKollegie() {
        return kollegie;
    }
}
