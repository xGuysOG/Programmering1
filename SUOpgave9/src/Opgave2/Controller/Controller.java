package Opgave2.Controller;

import Opgave2.Konto;
import Opgave2.KontoType;
import Opgave2.storage.Storage;

public class Controller {

    public static Konto createKonto(int nr, KontoType kontoType){
        Konto konto = new Konto(nr, kontoType);
        Storage.storeKonto(konto);
        return konto;
    }

    public static void updateKonto(Konto konto, int nr, KontoType kontoType) {
        konto.setNr(nr);
        konto.setKontoType(kontoType);
    }

    public void deleteKonto(Konto konto) {
        if (konto != null) {
            konto = null;
        }
        Storage.removeKonto(konto);
    }

    public static KontoType createKontoType(String navn, String beskrivelse) {
        KontoType kontoType = new KontoType(navn, beskrivelse);
        Storage.storeKontoType(kontoType);
        return kontoType;
    }

    public static void updateKontoType(KontoType kontoType, String navn, String beskrivelse) {
        kontoType.setNavn(navn);
        kontoType.setBeskrivelse(beskrivelse);
    }

    public void deleteKontoType(KontoType kontoType) {
        if (kontoType != null) {
            kontoType = null;
        }
        Storage.removeKontoTypes(kontoType);
    }
    //burh idk


}
