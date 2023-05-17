package application;

import application.model.Fag;
import application.model.Lektion;
import application.model.Studerende;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Studerende createStuderende(String navn, String email) {
        Studerende studerende = new Studerende(navn, email);
        Storage.addStuderende(studerende);
        return studerende;
    }

    public static Fag createFag(String fagNavn, String klasse) {
        Fag fag = new Fag(fagNavn, klasse);
        Storage.addFag(fag);
        return fag;
    }

    public static Lektion opretLektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag) {
        Lektion lektion = new Lektion(dato, startTid, lokale, fag);
        return lektion;
    }

    public static void opretDeltagelser(Fag fag, Studerende studerende) {
        for (Lektion lektion : fag.getLektioner()) {
            lektion.createDeltagelse(studerende);
        }
    }

    public ArrayList<Studerende> studerendeTilObservation(int graense) {
        ArrayList<Studerende> resultListe = new ArrayList<>();

        ArrayList<Studerende> studerendeListe = getStuderende();
        for (Studerende studerende : studerendeListe) {
            if (studerende.antalFravaersLektioner() > graense) {
                resultListe.add(studerende);
            }
        }

        studerendeSorteret(resultListe);

        return resultListe;
    }

    public static void studerendeSorteret(ArrayList<Studerende> studerende) {
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

    public static void fraværOmgængere(String[] omgængere, ArrayList<Studerende> megetFravær, String filNavn) {
        ArrayList<Studerende> resultList = new ArrayList<>();
        for (int i = 0; i < omgængere.length; i++) {
            String omgængerNavn = omgængere[i];

            for (Studerende studerende : megetFravær) {
                if (studerende.getNavn().equals(omgængerNavn)) {
                    resultList.add(studerende);
                }
            }
        }

        studerendeSorteret(resultList);

        try (PrintWriter out = new PrintWriter(filNavn)) {
            for (Studerende studerende : resultList) {
                out.println(studerende.getNavn() + " " + studerende.antalFravaersLektioner());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Studerende> getStuderende() {
        return Storage.getStuderende();
    }

    public static void initStorage() {
        Studerende peterHansen = createStuderende("Peter Hansen", "ph@stud.dk");
        Studerende tinaJensen = createStuderende("Tina Jensen", "tj@stud.dk");
        Studerende saschaPetersen = createStuderende("Sasch Petersen", "sp@stud.dk");

        Fag pro120S = createFag("PRO1", "20S");
        Fag pro120T = createFag("PRO1", "20T");
        Fag SU120S = createFag("SU1", "20S");

        opretLektion(LocalDate.of(2021, 2, 1), LocalTime.of(8, 30, 0),
                "A1.32", pro120S);
        opretLektion(LocalDate.of(2021, 2, 1), LocalTime.of(10, 30, 0),
                "A1.32", pro120S);
        opretLektion(LocalDate.of(2021, 2, 3), LocalTime.of(8, 30, 0),
                "A1.32", pro120S);
        opretLektion(LocalDate.of(2021, 2, 3), LocalTime.of(8, 30, 0),
                "A1.32", pro120S);

        opretDeltagelser(pro120S, peterHansen);
        opretDeltagelser(pro120S, tinaJensen);
        opretDeltagelser(pro120S, saschaPetersen);
    }
}
