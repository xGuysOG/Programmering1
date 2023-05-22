package application;

import application.model.*;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Controller {
    public static Sælger createSælger(String navn, int studiekortNummer, String mobil) {
        Sælger sælger = new Sælger(navn, studiekortNummer, mobil);
        Storage.addSælger(sælger);
        return sælger;
    }

    public static Vare createVarer(VareKategori kategori, String navn, int udbudsPris) {
        Vare vare = new Vare(kategori, navn, udbudsPris);
        Storage.addVare(vare);
        return vare;
    }

    public static SalgsAnnounce opretSalgsAnnounce(Sælger sælger, Vare... varer) {
        SalgsAnnounce salgsAnnounce = sælger.createSalgsAnnounce();
        for (Vare vare : varer) {
            salgsAnnounce.addVare(vare);
        }
        return salgsAnnounce;
    }

    public static Salg opretSalg(String navn, int aftaltPris, ArrayList<Vare> varer) {
        ArrayList<Vare> købt = new ArrayList<>();
        for (Vare vare : varer) {
            vare.setSolgt(true);
            SalgsAnnounce salgsAnnounce = vare.getSalgsAnnounce();
            salgsAnnounce.opdatereAnnounceStatus();
            købt.add(vare);
        }

        Salg salg = new Salg(navn, aftaltPris, købt);
        Storage.addSalg(salg);
        return salg;
    }

    public static void salgTilFil(String filNavn) {
        try (PrintWriter out = new PrintWriter(filNavn)) {
            ArrayList<Salg> salgList = getSalg();
            sorteretSalgsList(salgList);

            for (Salg salg : salgList) {
                out.println(salg.getKøbersNavn() + ":");

                int totalPris = 0;
                ArrayList<Vare> købteVare = salg.getSalgsVarer();
                for (Vare vare : købteVare) {
                    out.printf("    %-10s %d%n", vare.getNavn(), vare.getUdbudsPris());
                    totalPris += vare.getUdbudsPris();
                }

                int rabat = totalPris - salg.getAftaltSamletPris();
                out.println("Aftalt pris: " + salg.getAftaltSamletPris() + "   rabat er:" + rabat);
            }

            System.out.println("Successfuldt genereret salgs fil");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sorteretSalgsList(ArrayList<Salg> salg) {
        for (int i = 1; i < salg.size(); i++) {
            Salg next = salg.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                String prev = salg.get(j - 1).getKøbersNavn();
                if (next.getKøbersNavn().compareTo(prev) > 0) {
                    found = true;
                } else {
                    salg.set(j, salg.get(j - 1));
                    j--;
                }
            }

            salg.set(j, next);
        }
    }

    public static void sorteretSælgerList(ArrayList<Sælger> sælgere) {
        for (int i = 1; i < sælgere.size(); i++) {
            Sælger next = sælgere.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                String prev = sælgere.get(j - 1).getNavn();
                if (next.getNavn().compareTo(prev) > 0) {
                    found = true;
                } else {
                    sælgere.set(j, sælgere.get(j - 1));
                    j--;
                }
            }

            sælgere.set(j, next);
        }
    }

    public static ArrayList<Sælger> sælgereSomErKøbere(ArrayList<Sælger> l1,
                                                       ArrayList<Salg> l2) {
        int i1 = 0;
        int i2 = 0;
        int j = 0;

        ArrayList<Sælger> result = new ArrayList<>();

        while (i1 < l1.size() && i2 < l2.size()) {
            String sælgerNavn = l1.get(i1).getNavn();
            String køberNavn = l2.get(i2).getKøbersNavn();

            System.out.println(sælgerNavn + " " + køberNavn);

            if (sælgerNavn.compareTo(køberNavn) < 0) {
                i1++;
            } else if (sælgerNavn.compareTo(køberNavn) > 0) {
                i2++;
            } else {
                result.add(l1.get(i1));
                i1++;
                i2++;
                j++;
            }
        }

        System.out.println(result.size());

        return result;
    }

    public static ArrayList<Salg> getSalg() {
        return Storage.getSalg();
    }

    public static ArrayList<Sælger> getSælgere() {
        return Storage.getSælgere();
    }

    public static ArrayList<SalgsAnnounce> aktiveSalgsAnnouncer() {
        ArrayList<SalgsAnnounce> salgsAnnouncer = new ArrayList<>();

        ArrayList<Sælger> sælgere = getSælgere();
        for (Sælger sælger : sælgere) {
            salgsAnnouncer.addAll(sælger.aktiveSalgsAnnouncer());
        }

        return salgsAnnouncer;
    }

    public static void initStorage() {
        Sælger viktor = createSælger("Viktor", 23, "45344247");
        Sælger gustav = createSælger("Gustav", 35, "56124522");

        Vare samsungMobil = createVarer(VareKategori.MOBILTELEFON, "Samsung mobil", 1200);
        Vare iPhone = createVarer(VareKategori.MOBILTELEFON, "IPhone", 2000);
        Vare java = createVarer(VareKategori.STUDIEBOG, "Java", 400);
        Vare android = createVarer(VareKategori.STUDIEBOG, "Android", 300);
        Vare python = createVarer(VareKategori.STUDIEBOG, "Python", 200);
        Vare regnJakke = createVarer(VareKategori.TØJ, "Regnjakke", 100);
        Vare regnbukser = createVarer(VareKategori.TØJ, "Regnbukser", 80);

        opretSalgsAnnounce(viktor, samsungMobil);
        opretSalgsAnnounce(viktor, java, android, python);

        opretSalgsAnnounce(gustav, iPhone);
        opretSalgsAnnounce(gustav, regnJakke, regnbukser);

        ArrayList<Vare> varer = new ArrayList<>();
//        varer.add(android);
//        varer.add(python);
//        opretSalg("Stine", 450, varer);

        varer.clear();
        varer.add(regnbukser);
        varer.add(regnJakke);
        opretSalg("Laura", 120, varer);

        salgTilFil("salgsfil.txt");

        System.out.println("Test til metoden sælgereSomErKøbere");
        createSælger("Stine", 56, "65278276");
        createSælger("Laura", 56, "65278276");

        ArrayList<Sælger> sælgere = getSælgere();
        ArrayList<Salg> salgsListe = getSalg();

        sorteretSælgerList(sælgere);
        sorteretSalgsList(salgsListe);

        ArrayList<Sælger> sælgerSomErKøber = sælgereSomErKøbere(sælgere, salgsListe);
        for (Sælger sælger : sælgerSomErKøber) {
            System.out.println(sælger.getNavn());
        }
    }
}
