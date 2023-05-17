package application.model;

public class Deltagelse {
    private boolean afbud;
    private String begrundelse;

    private Spiller spiller;

    public Deltagelse(boolean afbud, String begrundelse, Spiller spiller) {
        this.afbud = afbud;
        this.begrundelse = begrundelse;
        this.spiller = spiller;
    }

    public void setSpiller(Spiller spiller) {
        if (this.spiller != spiller) {
            Spiller oldSpiller = this.spiller;
            if (oldSpiller != null) {
                oldSpiller.removeDeltagelse(this);
            }

            this.spiller = spiller;
            if (spiller != null) {
                spiller.addDeltagelse(this);
            }
        }
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public boolean isAfbud() {
        return afbud;
    }

    public String getBegrundelse() {
        return begrundelse;
    }
}
