package application.model;

public class Deltagelse {
    private boolean registreret;
    private DeltagerStatus status;
    private Lektion lektion;
    private Studerende studerende;

    Deltagelse(boolean registreret, DeltagerStatus status, Studerende studerende, Lektion lektion) {
        this.registreret = registreret;
        this.status = status;
        this.studerende = studerende;
        studerende.addDeltagelse(this);
        this.lektion = lektion;
    }

    public boolean erRegistreretFravarende() {
        return status != DeltagerStatus.TILSTEDE && registreret;
    }

    public Lektion getLektion() {
        return lektion;
    }

    public Studerende getStuderende() {
        return studerende;
    }

    public boolean isRegistreret() {
        return registreret;
    }

    public DeltagerStatus getStatus() {
        return status;
    }
}
