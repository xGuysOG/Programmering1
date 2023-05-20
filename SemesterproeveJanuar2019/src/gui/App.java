package gui;

import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
    }
    public static void initStorage(){
        Forestilling forestilling = new Forestilling("Evita", LocalDate.parse("2019-01-10 "), LocalDate.parse("2019-01-20"));
        Forestilling forestilling1 = new Forestilling("Lykke Per", LocalDate.parse("2019-02-01"), LocalDate.parse("2019-02-10"));
        Forestilling forestilling2 = new Forestilling("Chess", LocalDate.parse("2019-01-21"), LocalDate.parse("2019-01-30"));


        Kunde kunde = new Kunde("Anders Hansen", "11223344");
        Kunde kunde1 = new Kunde("Peter Jensen", "12345678");
        Kunde kunde2 = new Kunde("Niels Madsen", "12341234");




        Bestilling bestilling = new Bestilling(LocalDate.parse("2023-05-22"), forestilling,kunde);
        Bestilling bestilling2 = new Bestilling(LocalDate.parse("2023-05-24"), forestilling1,kunde1);

        System.out.println(bestilling.toString());
        System.out.println(bestilling2.toString());


        Plads plads = new Plads(10, 10, 200);
        Plads plads1 = new Plads(10, 10, 200);

        System.out.println(plads.toString());
        System.out.println(plads1.toString());

        System.out.println("overall stuff now");

        System.out.println(forestilling1.toString());
        System.out.println(forestilling.toString());
        System.out.println(bestilling.toString());
        System.out.println(bestilling2.toString());



    }
}
