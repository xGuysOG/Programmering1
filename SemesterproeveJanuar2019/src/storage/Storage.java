package storage;

import model.Forestilling;
import model.Kunde;

import java.util.ArrayList;

public class Storage {

    private static final ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private static final ArrayList<Kunde> kunder = new ArrayList<>();

    public static void storeForestilling(Forestilling forestilling){
        forestillinger.add(forestilling);
    }

    public static void storeKunde(Kunde kunde){
        kunder.add(kunde);
    }

    public static ArrayList<Kunde> getKunder(){
        return kunder;
    }

    public static ArrayList<Forestilling> getForestillinger(){
        return forestillinger;
    }
//    Tilføj klassen Storage i pakken storage. Klassen skal indeholde lister med systemets forestillinger
//    og kunder. Klassen skal også indeholde metoder til at gemme objekter af klasserne Forestilling
//    og Kunde, og metoder til at hente alle forestillinger og kunder. Lav ikke metoder til at slette
//    objekterne fra Storage.

}
