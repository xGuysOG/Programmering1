package model;

public class Indtag {
    private int vejetFørIndtagelse;
    private int vejetEfterIndtagelse;
    private String beskrivelse;
    private int anslåetAntalKalorier;
    private PersonligtMåltid personligtMåltid;

    public Indtag(int vejetFørIndtagelse, int vejetEfterIndtagelse, String beskrivelse, int anslåetAntalKalorier, PersonligtMåltid personligtMåltid){
        this.vejetEfterIndtagelse = vejetEfterIndtagelse;
        this.vejetFørIndtagelse = vejetFørIndtagelse;
        this.beskrivelse = beskrivelse;
        this.anslåetAntalKalorier = anslåetAntalKalorier;
        this.personligtMåltid = personligtMåltid;
    }

    public int getVejetFørIndtagelse() {
        return vejetFørIndtagelse;
    }

    public int getVejetEfterIndtagelse() {
        return vejetEfterIndtagelse;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getAnslåetAntalKalorier() {
        return anslåetAntalKalorier;
    }

    public PersonligtMåltid getPersonligtMåltid() {
        return personligtMåltid;
    }

    @Override
    public String toString() {
        return "Indtag{" +
                "vejetFørIndtagelse=" + vejetFørIndtagelse +
                ", vejetEfterIndtagelse=" + vejetEfterIndtagelse +
                ", beskrivelse='" + beskrivelse + '\'' +
                ", anslåetAntalKalorier=" + anslåetAntalKalorier +
                ", personligtMåltid=" + personligtMåltid +
                '}';
    }
}
