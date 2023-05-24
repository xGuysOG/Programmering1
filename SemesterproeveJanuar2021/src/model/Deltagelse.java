package model;

public class Deltagelse {
    private boolean registeret;

    private DeltagerStatus status;
    private Studerende studerende;
    private Lektion lektion;

    public Deltagelse(Lektion lektion, Studerende studerende){
        this.studerende = studerende;
        this.lektion = lektion;
        this.registeret = false;
        this.status = DeltagerStatus.TILSTEDE;
    }

    public boolean erRegistreretFraværende(){
        if (registeret){
            if (status == DeltagerStatus.FRAVÆR){
                return true;
            }
        }
        return false;
    }

    public boolean isRegisteret() {
        return registeret;
    }

    public DeltagerStatus getStatus() {
        return status;
    }

    public Studerende getStuderende() {
        return studerende;
    }

    public Lektion getLektion() {
        return lektion;
    }

    @Override
    public String toString() {
        return studerende.getNavn() + " " + registeret + " " + status;
    }
}
