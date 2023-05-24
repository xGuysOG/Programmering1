package controller;

import model.Deltagelse;
import model.Fag;
import model.Lektion;
import model.Studerende;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

public class Controller {
    public static Fag createFag(String navn, String klasse){
        Fag fag = new Fag(navn,klasse);
        Storage.storeFag(fag);
        return fag;
    }

    public static Lektion createLektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag){
        Lektion lektion = new Lektion(dato,startTid,lokale,fag);
        return lektion;
    }

    public static Studerende createStuderende(String navn, String email){
        Studerende studerende = new Studerende(navn, email);
        Storage.storeStuderende(studerende);
        return studerende;
    }

    public static void opretDeltagelser(Fag fag, Studerende studerende){
        for(Lektion lektion : fag.getLektioner()){
            Deltagelse deltagelse = new Deltagelse(lektion, studerende);
            lektion.addDeltagelse(deltagelse);
        }
    }

    public static void initStorage() {
        Studerende peterHansen = createStuderende("Peter Hansen", "ph@stud.dk");
        Studerende tinaJensen = createStuderende("Tina Jensen", "tj@stud.dk");
        Studerende saschaPetersen = createStuderende("Sasch Petersen", "sp@stud.dk");

        Fag pro120S = createFag("PRO1", "20S");
        Fag pro120T = createFag("PRO1", "20T");
        Fag SU120S = createFag("SU1", "20S");

        createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(8, 30, 0),
                "A1.32", pro120S);
        createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(10, 30, 0),
                "A1.32", pro120S);
        createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(8, 30, 0),
                "A1.32", pro120S);
        createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(8, 30, 0),
                "A1.32", pro120S);

        opretDeltagelser(pro120S, peterHansen);
        opretDeltagelser(pro120S, tinaJensen);
        opretDeltagelser(pro120S, saschaPetersen);
    }
}
