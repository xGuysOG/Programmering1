package controller;

import model.Indtag;
import model.Patient;
import model.PersonligtMåltid;

import java.util.ArrayList;

public class Controller {

    public static Patient createPatient(String navn, double vægt, int vægtFaktor){
        Patient patient = new Patient(navn, vægt, vægtFaktor);
        //make links later
        return patient;
    }

    public static PersonligtMåltid createPersonligtMåltid(String navn, String anretterNavn, Patient patient){
        PersonligtMåltid personligtMåltid = new PersonligtMåltid(navn, anretterNavn, patient);
        return personligtMåltid;
    }

    public static Indtag createIndtag(int vejetFørIndtagelse, int vejetEfterIndtagelse, String beskrivelse, int anslåetAntalKalorier, PersonligtMåltid personligtMåltid){
        Indtag indtag = new Indtag(vejetFørIndtagelse, vejetEfterIndtagelse, beskrivelse, anslåetAntalKalorier, personligtMåltid);
        return indtag;
    }

    //Præ arraylist skal være sorteret
    public static void indsætMåltid(ArrayList<PersonligtMåltid> personligtMåltider, PersonligtMåltid personligtMåltid){
        //indsæt i en sortere arraylist
        int indsætningsIndeks = 0;

        // Find det rigtige sted at indsætte det nye måltid
        while (indsætningsIndeks < personligtMåltider.size() && personligtMåltider.get(indsætningsIndeks).compareTo(personligtMåltid) < 0) {
            indsætningsIndeks++;
        }

        // Indsæt det nye måltid på det rigtige sted
        personligtMåltider.add(indsætningsIndeks, personligtMåltid);

    }

    public static ArrayList<Indtag> findIndtagMedKalorier(ArrayList<Indtag> indtaget, double mål){
        ArrayList<Indtag> indtagToReturn = new ArrayList<>();
        for(Indtag indtag : indtaget) {
            if (indtag.getAnslåetAntalKalorier() >= mål){
                indtagToReturn.add(indtag);
            }
        }
        return indtagToReturn;
    }

    //relevante link metoder??

    public static void initStorage(){
        Patient patient1 = Controller.createPatient("Jens Jensen",98.9,26);
        Patient patient2 = Controller.createPatient("Jens Hansen",56.5,38);

        PersonligtMåltid personligtMåltid1 = Controller.createPersonligtMåltid("Morgenmad", "Katrine",patient1);
        PersonligtMåltid personligtMåltid2 = Controller.createPersonligtMåltid("Middagsmad", "Karen",patient2);
        PersonligtMåltid personligtMåltid3 = Controller.createPersonligtMåltid("Aftensmad", "Simon",patient2);

        Indtag indtag1 = Controller.createIndtag(290,0,"Cornflakes",850, personligtMåltid1);
        Indtag indtag2 = Controller.createIndtag(100,0,"AppelsinJuice",250, personligtMåltid1);
        Indtag indtag3 = Controller.createIndtag(350,100,"Leverpostej",1200, personligtMåltid2);
        Indtag indtag4 = Controller.createIndtag(150,0,"Bacon",600, personligtMåltid2);
        Indtag indtag5 = Controller.createIndtag(450,150,"Forloren hare",1500, personligtMåltid3);
        Indtag indtag6 = Controller.createIndtag(100,0,"Flødesovs",300, personligtMåltid3);


        System.out.println(patient1.toString());
        System.out.println(patient2.toString());
        System.out.println("-------------------------------------------");
        System.out.println(personligtMåltid1.toString());
        System.out.println(personligtMåltid2.toString());
        System.out.println(personligtMåltid3.toString());
        System.out.println("-------------------------------------------");
        System.out.println(indtag1.toString());
        System.out.println(indtag2.toString());
        System.out.println(indtag3.toString());
        System.out.println(indtag4.toString());
        System.out.println(indtag5.toString());
        System.out.println(indtag6.toString());

        //indtag stuff now zZZZzz
    }
}
