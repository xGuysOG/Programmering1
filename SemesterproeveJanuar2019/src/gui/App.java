package gui;

import controller.Controller;
import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();
        Gui.launch(Gui.class);
    }
    public static void initStorage(){
        Forestilling forestilling = Controller.createForestilling("Evita", LocalDate.parse("2019-01-10"), LocalDate.parse("2019-01-20"));

        System.out.println(forestilling);
        Forestilling forestilling1 = Controller.createForestilling("Lykke Per", LocalDate.parse("2019-02-01"), LocalDate.parse("2019-02-10"));
        Forestilling forestilling2 = Controller.createForestilling("Chess", LocalDate.parse("2019-01-21"), LocalDate.parse("2019-01-30"));


        Kunde kunde = Controller.createKunde("Anders Hansen", "11223344");

        System.out.println(kunde);
        Kunde kunde1 = Controller.createKunde("Peter Jensen", "12345678");
        Kunde kunde2 = Controller.createKunde("Niels Madsen", "12341234");

        ArrayList<Plads> pladser = new ArrayList<>();
        pladser.add(new Plads(10,10,100));
        pladser.add(new Plads(10,11,100));
        System.out.println(pladser);

        Bestilling bestilling = Controller.opretBestillingMedPladser(forestilling, kunde, LocalDate.parse("2019-01-15"),pladser);
        System.out.println(bestilling);

        Controller.oversigtOverForestillinger("SemesterproeveJanuar2019/src/controller/testFile.txt");



    }
}
