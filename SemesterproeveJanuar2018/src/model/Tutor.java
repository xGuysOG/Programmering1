package model;

import java.util.ArrayList;

public class Tutor {
    private String navn;
    private String email;

    private Hold hold;

    private ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public boolean harTidsOverlap(Arrangement tilmeldt, Arrangement arrangement) {
        return tilmeldt.getStartTid().isBefore(arrangement.getSlutTid()) && tilmeldt.getSlutTid().isAfter(tilmeldt.getStartTid());
    }


    public double arrangementsPris(){
        double totalPris = 0;
        for(Arrangement arrangement : arrangementer) {
            totalPris += arrangement.getPris();
        }
        return totalPris;
    }

    public String getNavn(){
        return navn;
    }

    public String getEmail(){
        return email;
    }

    public void addArrangement(Arrangement arrangement){
        arrangementer.add(arrangement);
    }

    public void setHold(Hold hold){
        this.hold = hold;
    }

    public ArrayList<Arrangement> getArrangementer() {
        return arrangementer;
    }

    public void setArrangementer(ArrayList<Arrangement> arrangementer) {
        this.arrangementer = arrangementer;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "navn='" + navn + '\'' +
                ", email='" + email + '\'' +
                ", hold=" + hold +
                ", arrangementer=" + arrangementer +
                '}';
    }
}