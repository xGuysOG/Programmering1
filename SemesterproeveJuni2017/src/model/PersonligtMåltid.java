package model;

import java.util.ArrayList;

public class PersonligtMåltid implements Comparable<PersonligtMåltid>{

    private String navn;
    private String anretterNavn;
    private Patient patient;
    private ArrayList<Indtag> indtagelser = new ArrayList();

    public PersonligtMåltid(String navn, String anretterNavn, Patient patient){
        this.navn = navn;
        this.anretterNavn = anretterNavn;
        this.patient = patient;
    }

    //hvor PersonligtMåltid har ansvaret for at oprette Indtag-objekter.

    public String getNavn() {
        return navn;
    }

    public String getAnretterNavn() {
        return anretterNavn;
    }

    public ArrayList<Indtag> getIndtagelser() {
        return indtagelser;
    }

    public double beregnAntalKalorier() {
        double returnData = 0;
//        Programmer metoden beregnAntalKalorier() på klassen PersonligtMåltid. Metoden skal returnere
//        den samlede mængde af kalorier for de spiste indtag. I beregningen indgår indtag - variablen
//        anslåetAntalKalorier, der for hvert indtag giver den anslåede mængde af kalorier i hele dette
//        indtag.
//                Bemærk: I beregningen indgår også en faktor, der angiver hvor stor en del af indtaget, der er
//        blevet spist.

        //calculate percentage diffrent in numbers and amount of kalorier is then % of original number?

        for(Indtag indtag : indtagelser) {
            double difference =  indtag.getVejetFørIndtagelse() - indtag.getVejetEfterIndtagelse();
            double percentageDifference = (difference / indtag.getVejetFørIndtagelse()) * 100;

            double finalData = (percentageDifference / 100.0) * indtag.getAnslåetAntalKalorier();
            System.out.println("Final difference of this one is " + difference);
            System.out.println("Final percentageDifference of this one is " + percentageDifference);
            System.out.println("Final data of this one is " + finalData);
            returnData += finalData;
        }
        return returnData;
    }
    @Override
    public int compareTo(PersonligtMåltid other) {
        int navneSammenligning = this.navn.compareTo(other.navn);

        if (navneSammenligning == 0) {
            return this.anretterNavn.compareTo(other.anretterNavn);
        }

        return navneSammenligning;
    }

    @Override
    public String toString() {
        return "PersonligtMåltid{" +
                "navn='" + navn + '\'' +
                ", anretterNavn='" + anretterNavn + '\'' +
                ", patient=" + patient +
                '}';
    }
}


