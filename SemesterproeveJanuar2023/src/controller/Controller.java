package controller;

import model.*;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ServiceLoader;

public class Controller {

    /**
     * Lav en vare
     * Pre: navn ikke er tom  udbudspris >= 0
     */
    public static Vare createVare(Varekategori kategori, String navn, int udbudspris) {
        Vare vare = new Vare(kategori, navn, udbudspris);
        Storage.storeVare(vare);
        return vare;
    }

    /**
     * Lav en sælger
     * Pre: navn ikke er tom
     */
    public static Sælger createSælger(String navn, int studiekortNummer, String mobil) {
        Sælger sælger = new Sælger(navn, studiekortNummer, mobil);
        Storage.storeSælger(sælger);
        return sælger;
    }

    /**
     * Lav en Salgsannonce
     * Pre: Sælger ikke er null
     */
    public static Salgsannonce createSalgsannonce(Sælger sælger, Vare... varer) {
        Salgsannonce salgsannonce = new Salgsannonce(sælger);
        sælger.AddSalgsannonce(salgsannonce);
        for(Vare vare : varer) {
            salgsannonce.addVare(vare);
            vare.setSalgsannonce(salgsannonce);
        }
        return salgsannonce;
    }

    /**
     * Lav et Salgs objekt
     * Pre: SNavn ikke er tom. varer listen ikke er null
     */
    public static Salg createSalg(String navn, int aftaltSamletPris, ArrayList<Vare> varer) {
        Salg salg = new Salg(navn, aftaltSamletPris, varer);
        Storage.storeSalg(salg);
        return salg;
    }

    public static ArrayList<Salgsannonce> getAktiveSalgsannoncer() {
        ArrayList<Salgsannonce> Salgsannoncer = new ArrayList<>();
        for (Sælger sælger : Storage.getSælgere()) {
            for(Salgsannonce salgsannonce : sælger.getSalgsAnoncer()) {
                if (salgsannonce.isAktiv()){
                    Salgsannoncer.add(salgsannonce);
                }
            }
        }
        return Salgsannoncer;
    }


    public static void salgTilFil(String filNavn) {
        ArrayList<Salg> salgsListe = Storage.getSalgsListe();
        System.out.println(salgsListe);
        try (PrintWriter out = new PrintWriter(filNavn)) {
            sorterSalgsListen(salgsListe);
            System.out.println("Trying again " + salgsListe);
            //now we need to print
            for(Salg salg : salgsListe){
                out.println(salg.getKøbersNavn() + ":");
                for(Vare vare : salg.getVarene()) {
                    out.printf("      %-10s %d%n", vare.getNavn(), vare.getUdbudspris());
                }
                int salgRabatten = salg.orignalPris() - salg.getAftaltSamletPris();
                out.println("Aftalt pris: " + salg.getAftaltSamletPris() + " rabat er " + salgRabatten);
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public static void sorterSalgsListen(ArrayList<Salg> salg) {
        boolean fandt = false;
        int cachedIndex = 0;
        Salg cachedSalg = null;
        for (int i = 1; i < salg.size(); i++) {
            //vi started med 1 da vi får den næste i index og den første self er 0.
            Salg næste = salg.get(i);
            System.out.println("Næste er " + næste.getKøbersNavn());
            int j = i;
            fandt = false;
            while(!fandt && j > 0) {
                cachedIndex = j - 1;
                cachedSalg = salg.get(cachedIndex);
                //index for den "gamle".
                String sidsteNavn = cachedSalg.getKøbersNavn();
                System.out.println("It gives us " + næste.getKøbersNavn().compareTo(sidsteNavn));
                if (næste.getKøbersNavn().compareTo(sidsteNavn) > 0) {
                    //er som det skal, vi done.
                    fandt = true;
                } else {
                    //vi skal flytte elementet
                    System.out.println("Vi skal flytte " + cachedSalg.getKøbersNavn() + " til " + j);
                    salg.set(cachedIndex, salg.get(j));
                    salg.set(j, cachedSalg);
                    j--;
                }
            }
        }
    }

    public static void sorterSælgerListen(ArrayList<Sælger> sælgere) {
        boolean fandt = false;
        int cachedIndex = 0;
        Sælger cachedSælger = null;
        for (int i = 1; i < sælgere.size(); i++) {
            //vi started med 1 da vi får den næste i index og den første self er 0.
            Sælger næste = sælgere.get(i);
            System.out.println("Næste er " + næste.getNavn());
            int j = i;
            fandt = false;
            while(!fandt && j > 0) {
                cachedIndex = j - 1;
                cachedSælger = sælgere.get(cachedIndex);
                //index for den "gamle".
                String sidsteNavn = cachedSælger.getNavn();
                System.out.println("sidste er " + sidsteNavn);
                System.out.println("It gives us " + næste.getNavn().compareTo(sidsteNavn));
                if (næste.getNavn().compareTo(sidsteNavn) > 0) {
                    //er som det skal, vi done.
                    fandt = true;
                } else {
                    //vi skal flytte elementet
                    System.out.println("Vi skal flytte " + cachedSælger.getNavn() + " til " + j);
                    sælgere.set(cachedIndex, sælgere.get(j));
                    sælgere.set(j, cachedSælger);
                    j--;
                }
            }
        }
    }
    /**
     *  Anden måde at lave sælgereSomOgsåErKøbere
     * @param sælgerListe skal være sorteret
     * @param salgsListe skal være sortere
     * @return
     */
    public static ArrayList<Sælger> sælgereSomOgsåErKøbereUdenFletning(ArrayList<Sælger> sælgerListe, ArrayList<Salg> salgsListe) {
        ArrayList<Sælger> resultat = new ArrayList<>();
        //da de er præ sorteret
        for(Sælger sælger : sælgerListe) {
            for (Salg salg : salgsListe) {
                if (sælger.getNavn().equals(salg.getKøbersNavn())){
                    resultat.add(sælger);
                }
            }
        }
        System.out.println("Færdige resultat " + resultat);
        return resultat;
    }


    /**
     * Havde ikke lavet den med flette skabelonen hvis jeg måtte vælge zzZZz
     * @param sælgerListe skal være sorteret
     * @param salgsListe skal være sortere
     * @return
     */
    public static ArrayList<Sælger> sælgereSomOgsåErKøbere(ArrayList<Sælger> sælgerListe, ArrayList<Salg> salgsListe) {
        ArrayList<Sælger> resultat = new ArrayList<>();
        //i står for index
        int sælgerI = 0;
        int salgI = 0;

        //now we loop

        int forskæl = 0;
        //forskæl på navne
        while(sælgerI < sælgerListe.size() && salgI < salgsListe.size()) {

            String salg = salgsListe.get(salgI).getKøbersNavn();
            String sælger = sælgerListe.get(sælgerI).getNavn();

            forskæl = sælger.compareTo(salg);
            if (forskæl > 0) {
                salgI++;
            } else if (forskæl < 0) {
                sælgerI++;
            } else {
                resultat.add(sælgerListe.get(sælgerI));
                salgI++;
                sælgerI++;
            }
        }
        System.out.println("flettede resultat " + resultat);
        return resultat;
    }




    public static void initStorage(){
        Sælger sælgerViktor = Controller.createSælger("Viktor",23, "45344247");
        Sælger sælgerGustav = Controller.createSælger("Gustav",35, "56124522");

        System.out.println(sælgerViktor.toString());
        Vare samsungMobile = Controller.createVare(Varekategori.MOBILTELEFON, "Samsung mobil", 1200);
        Vare iPhoneMobile = Controller.createVare(Varekategori.MOBILTELEFON, "IPhone", 2000);
        Vare javaBog = Controller.createVare(Varekategori.STUDIEBOG, "Java", 400);
        Vare androidBog = Controller.createVare(Varekategori.STUDIEBOG, "Android", 300);
        Vare pythonBog = Controller.createVare(Varekategori.STUDIEBOG, "Python", 200);
        Vare regnjakkeTøj = Controller.createVare(Varekategori.TØJ, "Regnjakke", 100);
        Vare regnbukserTøj = Controller.createVare(Varekategori.TØJ, "Regnbukser", 80);

        Salgsannonce salgsannonceSamsung = Controller.createSalgsannonce(sælgerViktor, samsungMobile);
        Salgsannonce salgsannonceBøger = Controller.createSalgsannonce(sælgerViktor, androidBog, javaBog, pythonBog);

        Salgsannonce salgsannonceIphone = Controller.createSalgsannonce(sælgerGustav, iPhoneMobile);
        Salgsannonce salgsannonceTøj = Controller.createSalgsannonce(sælgerGustav, regnjakkeTøj, regnbukserTøj);

        System.out.println(salgsannonceBøger.toString());


        ArrayList<Vare> vareneStine = new ArrayList<>();
        vareneStine.add(androidBog);
        vareneStine.add(pythonBog);
        Salg salgStine = Controller.createSalg("Stine", 450, vareneStine);

        ArrayList<Vare> vareneLaura = new ArrayList<>();
        vareneLaura.add(regnbukserTøj);
        vareneLaura.add(regnjakkeTøj);
        Salg salgLaura = Controller.createSalg("Laura", 120, vareneLaura);

        System.out.println(salgStine);
        System.out.println(salgLaura);

        System.out.println(salgsannonceBøger.toString());

        System.out.println(sælgerViktor.toString());
        System.out.println(sælgerGustav.toString());

        System.out.println("Salg print til fil");

        salgTilFil("SemesterproeveJanuar2023/src/controller/testFile.txt");


        System.out.println("Sælger som er også er købere");
        createSælger("Stine", 69, "11233412534");
        createSælger("Laura", 420, "2345678976543");

        ArrayList<Salg> salgsListen = Storage.getSalgsListe();
        ArrayList<Sælger> sælgere = Storage.getSælgere();

        sorterSalgsListen(salgsListen);
        sorterSælgerListen(sælgere);

        System.out.println(salgsListen);

        System.out.println(sælgere);
        //Burde være Gustav
        //Burde væer Laura
        //Burde være stine
        //burde være viktor

        //men vi får
        //Gustav
        //Stine
        //Viktor
        //Laura

        //ahh fixed it

        //now we do the fletning

        ArrayList<Sælger> sælgereneSomKøber = new ArrayList<>();
        sælgereneSomKøber = sælgereSomOgsåErKøbere(sælgere, salgsListen);
    }
}



