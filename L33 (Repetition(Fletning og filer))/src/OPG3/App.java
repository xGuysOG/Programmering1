package OPG3;

import java.util.ArrayList;

public class App {

    public static ArrayList<Kunde> kundeListen = new ArrayList<>();
    public static void main(String[] args) {
        kundeListen.add(new Kunde("Ole", "Andersen"));
        kundeListen.add(new Kunde("Jens", "Fogh"));
        kundeListen.add(new Kunde("Alexander", "Hilfe"));
        Kunde kunde = new Kunde("Vicor", "Børgesen");
        System.out.println(kundeListen);
        indsætKunde(kundeListen, kunde);
        System.out.println(kundeListen);
        Kunde kunde2 = new Kunde("Alexander", "Børgesen");
        indsætKunde(kundeListen, kunde2);
        System.out.println(kundeListen);
    }

    /**
     * Indsæt kunde i kunder.
     * Pre: kunder er sorteret.
     */
    public static void indsætKunde(ArrayList<Kunde> kunder, Kunde kunde){
        //loop trough list, find where to add
        int index = 0;
        for (index = 0; index < kunder.size(); index++) {
            if (kunde.compareTo(kunder.get(index)) <= 0) {
                break;
            }
        }
        kunder.add(index, kunde);
    }
}
