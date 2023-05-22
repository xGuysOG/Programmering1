package application;

import application.model.Deltagelse;
import application.model.Kamp;
import application.model.ProfSpiller;
import application.model.Spiller;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Spiller createSpiller(String navn, int årgang) {
        Spiller spiller = new Spiller(navn, årgang);
        Storage.addSpiller(spiller);
        return spiller;
    }

    public static ProfSpiller createSpiller(String navn, int årgang, int kampHonorar) {
        ProfSpiller profSpiller = new ProfSpiller(navn, årgang, kampHonorar);
        Storage.addSpiller(profSpiller);
        return profSpiller;
    }

    public static Kamp createKamp(String sted, LocalDate dato, LocalTime tid) {
        Kamp kamp = new Kamp(sted, dato, tid);
        Storage.addKamp(kamp);
        return kamp;
    }

    public static void createDeltagelse(Kamp kamp, Spiller spiller) {
        createDeltagelse(kamp, false, "", spiller);
    }

    public static void createDeltagelse(Kamp kamp, boolean afbud, String begrundelse, Spiller spiller) {
        kamp.createDeltagelse(afbud, begrundelse, spiller);
    }

    /**
     * Opdaterer sammenhængen mellem spiller og deltagelse så de * linker til hinanden
     * Precondition: spiller != null og deltagelse != null
     */
    public static void updateSpillerDeltagelse(Spiller spiller, Deltagelse deltagelse) {
        deltagelse.setSpiller(spiller);
    }


    public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> list1, ArrayList<Kamp> list2) {
        ArrayList<Kamp> alleKamp = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;

        while (i1 < list1.size() && i2 < list2.size()) {
            Kamp k1 = list1.get(i1);
            Kamp k2 = list2.get(i2);

            if (k1.compareTo(k2) < 0) {
                i1++;
            } else if (k1.compareTo(k2) > 0) {
                i2++;
            } else {
                alleKamp.add(k1);
                i1++;
                i2++;
            }
        }

        return alleKamp;
    }

    /**
     * Precondition: kamp != null og dato != null og tid != null
     *
     * @param kamp kamp som skal opdateres
     * @param sted nyt sted
     * @param dato ny dato
     * @param tid  ny tidspunkt
     */
    public static void opdaterKamp(Kamp kamp, String sted, LocalDate dato, LocalTime tid) {
        kamp.setSted(sted);
        kamp.setDato(dato);
        kamp.setTid(tid);
    }

    public static ArrayList<Kamp> getKampe() {
        return Storage.getKampe();
    }

    public static void lavFil(Kamp kamp) {
        kamp.spillerHonorar("spiller-deltagelse");
    }

    public static void initStorage() {
        Spiller janeJensen = createSpiller("Jane Jensen", 1999);
        Spiller leneHansen = createSpiller("Lene Hansen", 2000);
        Spiller mettePedersen = createSpiller("Mette Pedersen", 1999);

        ProfSpiller sofiaKjeldsen = createSpiller("Sofia Kjeldsen", 1999, 50);
        ProfSpiller mariaNielsen = createSpiller("Maria Nielsen", 2000, 55);

        Kamp herning = createKamp("Herning", LocalDate.of(2015, 1, 26), LocalTime.of(10, 30, 0));
        Kamp ikast = createKamp("Ikast", LocalDate.of(2015, 1, 27), LocalTime.of(13, 30, 0));

        createDeltagelse(herning, true, "Moster Oda har fødselsdag", janeJensen);
        createDeltagelse(herning, leneHansen);
        createDeltagelse(herning, mettePedersen);
        createDeltagelse(herning, sofiaKjeldsen);
        createDeltagelse(herning, mariaNielsen);

        createDeltagelse(ikast, janeJensen);
        createDeltagelse(ikast, leneHansen);
        createDeltagelse(ikast, mettePedersen);
        createDeltagelse(ikast, true, "Dårlig form", sofiaKjeldsen);
        createDeltagelse(ikast, mariaNielsen);

        herning.spillerHonorar("januar2015");
    }
}
