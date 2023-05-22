package application;

import application.model.*;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Controller {
    public static Parkeringshus createParkeringshus(String addresse) {
        Parkeringshus phus = new Parkeringshus(addresse);
        Storage.addParkeringshus(phus);
        return phus;
    }

    public static Bil createBil(String regNr, BilMærke brand) {
        Bil bil = new Bil(regNr, brand);
        Storage.addBil(bil);
        return bil;
    }

    public static Parkeringsplads createParkeringsplads(Parkeringshus phus, int nummer) {
        return phus.createParkeringsplads(nummer);
    }

    public static Invalideplads createInvalideplads(Parkeringshus phus, int nummer, int areal) {
        return phus.createInvalideplads(nummer, areal);
    }

    public static void parkerBil(Parkeringsplads parkeringsplads, Bil bil) {
        parkeringsplads.setBil(bil);
    }

    public static void parkerBilLedigPlads(Parkeringshus phus, Bil bil) {
        Parkeringsplads ledigPlads = null;
        int i = 0;

        ArrayList<Parkeringsplads> pladser = phus.getParkeringspladser();

        while (ledigPlads == null && i < pladser.size()) {
            Parkeringsplads k = pladser.get(i);
            if (k.getBil() == null) ledigPlads = k;
            else i++;
        }

        if (ledigPlads != null) {
            parkerBil(ledigPlads, bil);
        }
    }

    public static ArrayList<Parkeringsplads> getParkeringspladser(Parkeringshus phus) {
        return phus.getParkeringspladser();
    }

    public static ArrayList<String> getOptagnePladser(Parkeringshus phus) {
        return phus.optagnePladser();
    }

    public static void writeOptagnePladser(Parkeringshus hus, String filnavn) {
        try (PrintWriter out = new PrintWriter(filnavn)) {
            ArrayList<String> optaget = hus.optagnePladser();
            for (String plads : optaget) {
                out.println(plads);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Parkeringshus> getParkeringshuse() {
        return Storage.getParkeringshuse();
    }

    public static void createSomeObjects() {
        Bil b1 = createBil("AB 11 222", BilMærke.AUDI);
        Bil b2 = createBil("EF 33 444", BilMærke.CITROEN);
        Bil b3 = createBil("BD 55 666", BilMærke.ZUSUKI);

        Parkeringshus ph = createParkeringshus("Havnegade 12, 8000 Aarhus");

        for (int i = 1; i <= 100; i++) {
            createParkeringsplads(ph, i);
        }

        for (int i = 101; i <= 110; i++) {
            createInvalideplads(ph, i, 18);
        }

        Parkeringsplads p1 = getParkeringspladser(ph).get(0);
        Parkeringsplads p2 = getParkeringspladser(ph).get(1);
        Parkeringsplads p3 = getParkeringspladser(ph).get(2);

        parkerBil(p1, b1);
        parkerBil(p2, b2);
        parkerBil(p3, b3);

        writeOptagnePladser(ph, "Semesterproeve_Parkeringshus/src/parkeringshus.txt");
    }
}
