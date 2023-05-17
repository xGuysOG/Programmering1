package application;

import application.model.Antal;
import application.model.Funktion;
import application.model.Medarbejder;
import application.model.Vagt;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {
    public static Funktion createFunktion(String navn) {
        Funktion funktion = new Funktion(navn);
        Storage.addFunktion(funktion);
        return funktion;
    }

    public static Medarbejder createMedarbejder(String navn, LocalTime typiskMødeTidspunkt, int timerPrDag) {
        Medarbejder medarbejder = new Medarbejder(navn, timerPrDag, typiskMødeTidspunkt);
        Storage.addMedarbejder(medarbejder);
        return medarbejder;
    }

    public static Vagt createVagt(String navn, LocalDateTime fra, LocalDateTime til) {
        Vagt vagt = new Vagt(navn, fra, til);
        Storage.addVagt(vagt);
        return vagt;
    }

    public static void tilføjFunktioner(Medarbejder medarbejder, Funktion... funktioner) {
        for (Funktion funktion : funktioner) {
            medarbejder.addFunktion(funktion);
        }
    }

    public static void tilføjdMedarbejderTilVagt(Vagt vagt, Medarbejder... medarbejdere) {
        for (Medarbejder medarbejder : medarbejdere) {
            medarbejder.addVagt(vagt);
        }
    }

    public static void tilføjVagt(Medarbejder medarbejder, Vagt vagt) throws RuntimeException {
        try {
            medarbejder.addVagt(vagt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void udskrivVagtPlan(Vagt vagt, String filNavn) {
        try (PrintWriter out = new PrintWriter(filNavn)) {
            out.println("------------------------------------------------");
            out.println(vagt.getTidFra() + " (" + vagt.getNavn() + ")");
            out.println("------------------------------------------------");
            out.println();

            out.println("Funktioner:");
            for (Antal antal : vagt.getAntalListe()) {
                Funktion funktion = antal.getFunktion();

                int medarbejdere = vagt.antalMedarbejdereMedFunktion(funktion);

                String line = funktion.getNavn() + "(" + antal.getAntal() + ", " + medarbejdere + " medarbejdere";

                out.println("  " + line);
            }
            out.println();

            out.print("Medarbejdere: ");
            for (Medarbejder medarbejder : vagt.getMedarbejdere()) {
                out.print(medarbejder.getNavn() + " ");
            }
            out.println();
            out.println();

            out.println("Status: " + vagt.status());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createAntal(Vagt vagt, int antal, Funktion funktion) {
        vagt.createAntal(antal, funktion);
    }

    public static ArrayList<Medarbejder> getAlleMedarbejdere() {
        return Storage.getMedarbejdere();
    }

    public static ArrayList<Vagt> getAlleVagter() {
        return Storage.getVagter();
    }

    public static void initStorage() {
        Funktion filetering = createFunktion("Filetering");
        Funktion grønsager = createFunktion("Grønsager");
        Funktion sovsOgTilbehør = createFunktion("Sovs og tilbehør");
        Funktion buffetOpfyldning = createFunktion("Buffetopfyldning");

        Medarbejder peter = createMedarbejder("Peter", LocalTime.of(8, 0, 0), 6);
        Medarbejder anne = createMedarbejder("Anne", LocalTime.of(8, 0, 0), 8);
        Medarbejder marie = createMedarbejder("Marie", LocalTime.of(10, 0, 0), 6);
        Medarbejder torben = createMedarbejder("Torben", LocalTime.of(7, 0, 0), 8);

        LocalDateTime vagtDato = LocalDateTime.of(2022, 6, 24, 8, 0);
        Vagt vagt = createVagt("Røgede ål til medarbejderne", vagtDato, vagtDato.withHour(12).withMinute(30));
        Vagt sommerfest = createVagt("Sommerfest", vagtDato, vagtDato.withHour(12).withMinute(30));

        createAntal(vagt, 2, filetering);
        createAntal(vagt, 1, grønsager);
        createAntal(vagt, 1, sovsOgTilbehør);
        createAntal(vagt, 1, buffetOpfyldning);

        tilføjdMedarbejderTilVagt(vagt, peter, anne, marie);

        tilføjFunktioner(peter, grønsager, sovsOgTilbehør, buffetOpfyldning);
        tilføjFunktioner(anne, grønsager, sovsOgTilbehør, buffetOpfyldning);
        tilføjFunktioner(marie, filetering, grønsager, buffetOpfyldning);
        tilføjFunktioner(torben, filetering, sovsOgTilbehør);

        udskrivVagtPlan(vagt, "vagtplan");
    }
}
