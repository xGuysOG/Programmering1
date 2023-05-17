package application.model;

import java.util.ArrayList;

public class Forhindring {
    private int nummer;
    private String navn;

    private ArrayList<Løb> løbList = new ArrayList<>();

    public Forhindring(int nummer, String navn) {
        this.nummer = nummer;
        this.navn = navn;
    }

    public void addLøb(Løb løb) {
        if (!løbList.contains(løb)) {
            løbList.add(løb);
            løb.addForhindring(this);
        }
    }

    public void removeLøb(Løb løb) {
        if (løbList.contains(løb)) {
            løbList.remove(løb);
            løb.removeForhindring(this);
        }
    }

    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }
}
