package opg1;

public class Hund {

    private String name;
    private boolean stamTavle;
    private int pris;
    private final Race race;


    public Hund(String name, boolean stamTavle, int pris, Race race) {
        this.name = name;
        this.stamTavle = stamTavle;
        this.pris = pris;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public boolean isStamTavle() {
        return stamTavle;
    }

    public int getPris() {
        return pris;
    }

    public Race getRace() {
        return race;
    }
}
