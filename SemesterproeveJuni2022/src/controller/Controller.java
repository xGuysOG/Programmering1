package controller;

import model.Antal;
import model.Funktion;
import model.Medarbejder;
import model.Vagt;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Controller {
//    Tilføj en klasse Controller til dit projekt. Klassen skal indeholde metoder til at oprette og
//    skabe sammenhænge imellem de objekter, der indgår i modellen. Tilføj derudover en metode
//    initStorage(), der anvender controller metoder til at oprette og gemme data svarende til
//    nedenstående:

    public static Funktion createFunktion(String navn) {
        Funktion funktion = new Funktion(navn);
        Storage.storeFunktion(funktion);
        return funktion;
    }

    public static Medarbejder createMedarbejder(String navn, LocalTime typiskMødeTidspunkt, int timerPrDag) {
        Medarbejder medarbejder = new Medarbejder(navn, timerPrDag, typiskMødeTidspunkt);
        Storage.storeMedarbejder(medarbejder);
        return medarbejder;
    }

    public static Vagt createVagt(String navn, LocalDateTime fra, LocalDateTime til) {
        Vagt vagt = new Vagt(navn, fra, til);
        Storage.storeVagt(vagt);
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

    public static void createAntal(Vagt vagt, int antal, Funktion funktion) {
        vagt.createAntal(antal, funktion);
    }

    public static void udskrivVagtPlan(Vagt vagt, String filNavn) {
        try (PrintWriter out = new PrintWriter(filNavn)) {
            out.println("------------------------------------------------");
            out.println(vagt.getTidFra() + " (" + vagt.getNavn() + ")");
            out.println("------------------------------------------------");
            out.println();

            out.println("Funktioner:");
            for (Antal antal : vagt.getAntals()) {
                Funktion funktion = antal.getFunktion();
                String line = funktion.getNavn() + "(" + antal.getAntal() + ", " + vagt.antalMedarbejdereMedFunktion(funktion) + " medarbejdere)";
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

    public static void initStorage(){
        Funktion funktion = Controller.createFunktion("Filetering");
        Funktion funktion1 = Controller.createFunktion("Grøntsager");
        Funktion funktion2 = Controller.createFunktion("Sovs og tilbehør");
        Funktion funktion3 = Controller.createFunktion("Buffetopfyldning");

        Medarbejder medarbejder = Controller.createMedarbejder("Peter", LocalTime.parse("08:00"),6);
        Medarbejder medarbejder1 = Controller.createMedarbejder("Anne", LocalTime.parse("08:00"),8);
        Medarbejder medarbejder2 = Controller.createMedarbejder("Marie", LocalTime.parse("10:00"),6);
        Medarbejder medarbejder3 = Controller.createMedarbejder("Torben", LocalTime.parse("07:00"),8);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        Vagt vagt = Controller.createVagt("Røgede ål til medarbejderne", LocalDateTime.parse("24-06-2022 08:00", formatter), LocalDateTime.parse("24-06-2022 12:30", formatter));

        createAntal(vagt, 2, funktion);
        createAntal(vagt, 1, funktion1);
        createAntal(vagt, 1, funktion2);
        createAntal(vagt, 1, funktion3);

        tilføjdMedarbejderTilVagt(vagt, medarbejder, medarbejder1, medarbejder2);

        tilføjFunktioner(medarbejder, funktion1, funktion2, funktion3);
        tilføjFunktioner(medarbejder1, funktion1, funktion2, funktion3);
        tilføjFunktioner(medarbejder2, funktion, funktion1, funktion3);
        tilføjFunktioner(medarbejder3, funktion, funktion2);

        //now all the data has been added.
        udskrivVagtPlan(vagt, "SemesterproeveJuni2022/vagtplan.txt");

    }



}
