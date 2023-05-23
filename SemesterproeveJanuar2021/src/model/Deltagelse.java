package model;

public class Deltagelse {
    private boolean registeret;
    private DeltagerStatus status;
    private Studerende studerende;
    private Lektion lektion;

    public Deltagelse(){
        this.registeret = false;
        this.status = DeltagerStatus.TILSTEDE;
    }
}
