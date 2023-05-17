package Opgave2.storage;

import Opgave2.Konto;
import Opgave2.KontoType;

import java.util.ArrayList;

public class Storage {

    public static ArrayList<Konto> kontos = new ArrayList<>();
    public static ArrayList<KontoType> kontoTypes = new ArrayList<>();

    public static void storeKonto(Konto konto) {
        kontos.add(konto);
    }

    public static void removeKonto(Konto konto) {
        kontos.remove(konto);
    }

    public static ArrayList<Konto> getKontos() {
        return kontos;
    }

    public static ArrayList<KontoType> getKontoTypes() {
        return kontoTypes;
    }

    public static void removeKontoTypes(KontoType kontoType) {
        kontoTypes.remove(kontoType);
    }

    public static void storeKontoType(KontoType kontoType) {
        kontoTypes.add(kontoType);
    }
}
