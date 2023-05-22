package application;

import application.model.Arrangement;
import application.model.Hold;
import application.model.Tutor;
import application.model.Uddannelse;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Uddannelse opretUddannelse(String navn) {
        Uddannelse uddannelse = new Uddannelse(navn);
        Storage.addUddannelse(uddannelse);
        return uddannelse;
    }

    public static Hold opretHold(Uddannelse uddannelse, String betegnelse, String holdLeder) {
        return uddannelse.createHold(betegnelse, holdLeder);
    }

    public static Tutor opretTutor(String navn, String email) {
        Tutor tutor = new Tutor(navn, email);
        Storage.addTutor(tutor);
        return tutor;
    }

    public static Arrangement opretArrangement(String titel, LocalDate dato, LocalTime startTid, LocalTime slutTid, double pris) {
        Arrangement arrangement = new Arrangement(titel, dato, startTid, slutTid, pris);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static void tilføjTilArrangement(Arrangement arrangement, Tutor... tutore) throws RuntimeException {
        for (Tutor tutor : tutore) {
            if (tutor.tidsOverlap(arrangement)) {
                throw new RuntimeException(tutor.getNavn() + " Kan ikke tilføjes til " + arrangement.getTitel() + " pågrund af tider overlapper");
            }

            tutor.addArrangement(arrangement);
        }
    }

    public static void tilføjTilHold(Hold hold, Tutor... tutore) {
        for (Tutor tutor : tutore) {
            tutor.setHold(hold);
        }
    }

    public static ArrayList<Hold> holdUdenTutorer() {
        ArrayList<Hold> holdListe = new ArrayList<>();

        ArrayList<Uddannelse> uddannelser = getUddannelser();
        for (Uddannelse uddannelse : uddannelser) {
            ArrayList<Hold> udenTutoreList = uddannelse.holdUdenTutorer();
            holdListe.addAll(udenTutoreList);
        }

        return holdListe;
    }

    public static ArrayList<Uddannelse> getUddannelser() {
        return Storage.getUddannelser();
    }

    public static ArrayList<Tutor> getTutorer() {
        return Storage.getTutorer();
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return Storage.getArrangementer();
    }

    public static void tutorOversigtTilFil(String filNavn) {
        try (PrintWriter out = new PrintWriter(filNavn)) {
            ArrayList<Uddannelse> uddannelser = getUddannelser();
            for (Uddannelse uddannelse : uddannelser) {
                ArrayList<String> oversigt = uddannelse.tutorOversigt();
                for (String line : oversigt) {
                    out.println(line);
                }
            }
            System.out.println("Successfuldt oprette fil");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initStorage() {
        Uddannelse DMU = opretUddannelse("DMU");
        Uddannelse FINØ = opretUddannelse("FINØ");

        Hold hold1 = opretHold(DMU, "1dmE17S", "Margrethe Dybdahl");
        opretHold(DMU, "1dmE17T", "Kristian Dorland");
        Hold hold3 = opretHold(DMU, "1dmE17U", "Kell Ørhøj");
        Hold hold4 = opretHold(FINØ, "1fiE17B", "Karen Jensen");

        Tutor andersHansen = opretTutor("Anders Hansen", "aaa@students.eaaa.dk");
        Tutor peterJensen = opretTutor("Peter Jensen", "ppp@students.eaaa.dk");
        Tutor nielsMadsen = opretTutor("Niels Madsen", "nnn@students.eaaa.dk");
        Tutor loneAndersen = opretTutor("Lone Andersen", "lll@students.eaaa.dk");
        Tutor madsMiller = opretTutor("Mads Miller", "mmm@students.eaaa.dk");

        Arrangement rusfest = opretArrangement("Rusfest", LocalDate.of(2017, 8, 31), LocalTime.of(18, 0, 0), LocalTime.of(23, 30, 0), 250);
        Arrangement fodbold = opretArrangement("Fodbold", LocalDate.of(2017, 8, 30), LocalTime.of(14, 0, 0), LocalTime.of(17, 30, 0), 100);
        Arrangement brætspil = opretArrangement("Brætspil", LocalDate.of(2017, 8, 29), LocalTime.of(12, 0, 0), LocalTime.of(16, 30, 0), 25);
        Arrangement mindeparken = opretArrangement("Mindeparken", LocalDate.of(2017, 8, 30), LocalTime.of(18, 0, 0), LocalTime.of(22, 0, 0), 25);

        tilføjTilHold(hold1, andersHansen, loneAndersen);
        tilføjTilHold(hold3, peterJensen, nielsMadsen);
        tilføjTilHold(hold4, madsMiller);

        tilføjTilArrangement(rusfest, andersHansen, peterJensen, madsMiller);
        tilføjTilArrangement(fodbold, nielsMadsen);
        tilføjTilArrangement(brætspil, loneAndersen, nielsMadsen);
        tilføjTilArrangement(mindeparken, madsMiller, andersHansen);

        System.out.println("Hold uden tutore");
        ArrayList<Hold> udenTutore = Controller.holdUdenTutorer();
        for (Hold hold : udenTutore) {
            System.out.println(hold.getBetegnelse());
        }
        System.out.println();

        System.out.println("Tutor oversigt for DMU");
        ArrayList<String> oversigt = DMU.tutorOversigt();
        for (String str : oversigt) {
            System.out.println(str);
        }
        System.out.println();

        System.out.println("Tutor oversigt for til fil");
        tutorOversigtTilFil("tutoroversigt.txt");
    }
}
