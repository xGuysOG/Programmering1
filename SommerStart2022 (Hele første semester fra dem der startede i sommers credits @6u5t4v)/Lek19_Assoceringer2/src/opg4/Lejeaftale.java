package opg4;

import java.time.LocalDate;

public class Lejeaftale {
    private LocalDate fraDato;
    private LocalDate tilDato;

    private Bolig bolig;

    private int lejereIBolig = 0;
    private Lejer[] lejere = new Lejer[2];

    Lejeaftale(Bolig bolig) {
        this.fraDato = LocalDate.now();
        this.tilDato = null;
        this.bolig = bolig;
    }

    public void addLejer(Lejer lejer) {
        if (lejereIBolig < 2) {
            lejere[lejereIBolig] = lejer;
            lejereIBolig++;
        }
    }

    public void opsig() {
        tilDato = LocalDate.now();
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }
}
