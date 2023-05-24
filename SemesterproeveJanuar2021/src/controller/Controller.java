package controller;

import model.Deltagelse;
import model.Fag;
import model.Lektion;
import model.Studerende;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {
    public static Fag createFag(String navn, String klasse){
        Fag fag = new Fag(navn,klasse);
        Storage.storeFag(fag);
        return fag;
    }

    public static Lektion createLektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag){
        Lektion lektion = new Lektion(dato,startTid,lokale,fag);
        fag.addLektion(lektion);
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

//    Tilføj til klassen Controller metoden studerendeTilObservation(int grænse) der skal
//    returnere en sorteret ArrayList af Studerende. Listen skal indeholde de studerende, der har et
//    antal fraværslektioner der er over den i parameteren angivne grænse. Det er et krav at listen er
//    sorteret efter de studerendes navne
    public static ArrayList<Studerende> studerendeTilObservation(int grænse){
        ArrayList<Studerende> resultListe = new ArrayList<>();

        ArrayList<Studerende> studerendeListe = Storage.getStuderendene();
        for (Studerende studerende : studerendeListe) {
            if (studerende.antalFraværsLektioner() > grænse) {
                resultListe.add(studerende);
            }
        }
        sorterStuderende(resultListe);

        return resultListe;
    }

//    Der ønskes til administrationen en fil indeholdende navn og fravær for de studerende, der tidligere
//    har taget et fag (omgængere) og også har meget fravær.
//    Tilføj til klassen Controller en metode, der givet et array med navne på omgængere og en ArrayList
//    af studerende med meget fravær, laver en fil med navn og antal fraværslektioner for alle de
//    studerende, der findes i begge lister. Det kan antages, at såvel array som ArrayList er sorteret på
//    studerendes navn. Desuden er det et krav, at filen med resultatet også skal være sorteret på navn.
//    Metoden skal have nedenstående signatur:
    public static void fraværOmgængere(String[] omgængere, ArrayList<Studerende> megetFravær, String filnavn) {
        ArrayList<Studerende> resultList = new ArrayList<>();
        //loop omgængee and fravær if they have the same name, add them to the result list.
        for (String omgænger : omgængere) {
            for (Studerende studerende : megetFravær) {
                if (studerende.getNavn().equals(omgænger)) {
                    resultList.add(studerende);
                }
            }
        }

        sorterStuderende(resultList);

        try (PrintWriter out = new PrintWriter(filnavn)) {
            for (Studerende studerende : resultList) {
                out.println(studerende.getNavn() + " " + studerende.antalFraværsLektioner());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static void sorterStuderende(ArrayList<Studerende> studerende) {
        for (int i = 1; i < studerende.size(); i++) {
            Studerende next = studerende.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                Studerende k = studerende.get(j - 1);
                if (next.compareTo(k) >= 0) {
                    found = true;
                } else {
                    studerende.set(j, k);
                    j--;
                }
            }
            studerende.set(j, next);
        }
    }

    public static void initStorage() {
        Studerende peterHansen = createStuderende("Peter Hansen", "ph@stud.dk");
        Studerende tinaJensen = createStuderende("Tina Jensen", "tj@stud.dk");
        Studerende saschaPetersen = createStuderende("Sasch Petersen", "sp@stud.dk");

        Fag pro120S = createFag("PRO1", "20S");
        Fag pro120T = createFag("PRO1", "20T");
        Fag SU120S = createFag("SU1", "20S");

        Lektion lektion = createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(8, 30, 0),
                "A1.32", pro120S);
        Lektion lektion1 = createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(10, 30, 0),
                "A1.32", pro120S);
        Lektion lektion2 = createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(8, 30, 0),
                "A1.32", pro120S);
        Lektion lektion3 = createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(8, 30, 0),
                "A1.32", pro120S);

        opretDeltagelser(pro120S, peterHansen);
        opretDeltagelser(pro120S, tinaJensen);
        opretDeltagelser(pro120S, saschaPetersen);


    }
}
