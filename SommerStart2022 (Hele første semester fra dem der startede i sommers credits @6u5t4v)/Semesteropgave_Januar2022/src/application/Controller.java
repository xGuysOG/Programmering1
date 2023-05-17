package application;

import application.model.Forhindring;
import application.model.Løb;
import application.model.Tilmelding;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Controller {
    public static Løb createLøb(LocalDate dato, String sted, int normalPris, LocalDate earlyBirdDate, int earlyBirdPris) {
        Løb løb = new Løb(dato, sted, normalPris, earlyBirdDate, earlyBirdPris);
        Storage.addLøb(løb);
        return løb;
    }

    public static Forhindring createForhindring(int nummer, String navn) {
        Forhindring forhindring = new Forhindring(nummer, navn);
        Storage.addForhindring(forhindring);
        return forhindring;
    }

    public static Forhindring addForhindringTilLøb(Løb løb, int nummer, String navn) {
        Forhindring forhindring = createForhindring(nummer, navn);
        løb.addForhindring(forhindring);

        return forhindring;
    }

    public static Tilmelding createTilmelding(Løb løb, String navn, boolean kvinde, LocalDate tilmeldingsDato, int løbeNummer) {
        Tilmelding tilmelding = løb.createTilmelding(navn, kvinde, tilmeldingsDato, løbeNummer);
        return tilmelding;
    }

    public static void registreStraf(Tilmelding tilmelding, Forhindring forhindring, int strafSekunder) {
        tilmelding.registrerStrafPåForhindring(forhindring.getNavn(), strafSekunder);
    }

    public static void resultaterTilFil(Løb løb, String filNavn) {
        File file = new File(filNavn);
        try (PrintWriter out = new PrintWriter(file)) {
            ArrayList<Tilmelding> tilmeldinger = løb.getTilmeldinger();
            tilmeldingerSorteret(tilmeldinger);

            for (Tilmelding tilmelding : tilmeldinger) {
                int resultatTid = tilmelding.resultatTid();
                if (resultatTid != -1) {
                    out.printf("%-10s %s\n", tilmelding.getNavn(), resultatTid);
                }
            }

            System.out.println("En ny fil er generet: " + file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tilmeldingerSorteret(ArrayList<Tilmelding> tilmeldinger) {
        for (int i = 1; i < tilmeldinger.size(); i++) {
            Tilmelding next = tilmeldinger.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                Tilmelding k = tilmeldinger.get(j - 1);
                if (next.compareTo(k) >= 0) {
                    found = true;
                } else {
                    tilmeldinger.set(j, k);
                    j--;
                }
            }
            tilmeldinger.set(j, next);
        }
    }

    public static ArrayList<Løb> getLøb() {
        return Storage.getLøb();
    }

    public static void initStorage() {
        Løb løb = createLøb(LocalDate.of(2021, Month.AUGUST, 23),
                "Hasle Bakker", 500,
                LocalDate.of(2021, Month.JUNE, 23), 350);

        Forhindring stejlBakke = addForhindringTilLøb(løb, 1, "Stejl bakke");
        Forhindring megetStejlBakke = addForhindringTilLøb(løb, 2, "Meget stejl bakke");
        Forhindring mudderpøl = addForhindringTilLøb(løb, 3, "Mudderpøl");
        Forhindring overMur = addForhindringTilLøb(løb, 4, "Over mur");
        Forhindring underGitter = addForhindringTilLøb(løb, 5, "Under gitter");

        Tilmelding sune = createTilmelding(løb, "Sune", false,
                LocalDate.of(2021, Month.MAY, 12), 1);
        Tilmelding anne = createTilmelding(løb, "Anne", true,
                LocalDate.of(2021, Month.JULY, 12), 2);
        Tilmelding bent = createTilmelding(løb, "Bent", false,
                LocalDate.of(2021, Month.JULY, 14), 3);
        Tilmelding ole = createTilmelding(løb, "Ole", false,
                LocalDate.of(2021, Month.MAY, 10), 4);
        Tilmelding lars = createTilmelding(løb, "Lars", false,
                LocalDate.of(2021, Month.APRIL, 8), 5);
        Tilmelding mette = createTilmelding(løb, "Mette", true,
                LocalDate.of(2021, Month.AUGUST, 20), 6);

        sune.setLøbeTid(8733);
        anne.setLøbeTid(9132);
        registreStraf(anne, overMur, 90);
        ole.setLøbeTid(8280);
        registreStraf(ole, overMur, 220);
        lars.setLøbeTid(9126);
        registreStraf(lars, overMur, 180);
        registreStraf(lars, underGitter, 410);
        mette.setLøbeTid(12732);

        System.out.println("Gennemsnit forhindrigs tid for Over mur");
        System.out.println("Forventet: 163.33");
        System.out.println("Faktisk: " + løb.gennemsnitStrafSekunder(overMur));

        System.out.println();
        System.out.println("Vinder af Løb Test");
        System.out.println("Forventet: 4 Ole 8500 1");
        System.out.println("Faktisk: " + løb.findVinder());

        System.out.println();
        System.out.println("Resultat for Lars");
        System.out.println("Forventet: 5 Lars 9716 2");
        System.out.println("Faktisk: " + løb.resultatForTilmelding("Lars"));

        System.out.println();
        System.out.println("Resultat for ikke eksisterende");
        System.out.println("Forventet: Deltageren findes ikke");
        System.out.println("Faktisk: " + løb.resultatForTilmelding("Arne"));

        resultaterTilFil(løb, "løber.txt");
    }
}
