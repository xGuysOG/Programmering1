package application;

import application.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Controller {
    public static Festival createFestival(String navn, LocalDate fra, LocalDate til) {
        Festival festival = new Festival(navn, fra, til);
        Storage.addFestival(festival);
        return festival;
    }

    public static Frivillig createFrivillig(String navn, String mobil, int maksTimer) {
        Frivillig frivillig = new Frivillig(navn, mobil, maksTimer);
        Storage.addFrivilig(frivillig);
        return frivillig;
    }

    public static FrivilligForening createFrivilligForening(String navn, String mobil, int maksTimer, String foreningNavn, int antalFrivillige) {
        FrivilligForening forening = new FrivilligForening(navn, mobil, maksTimer, foreningNavn, antalFrivillige);
        Storage.addFrivilig(forening);
        return forening;
    }

    public static void createJob(Festival festival, String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        festival.createJob(kode, beskrivelse, dato, timeHonorar, antalTimer);
    }

    public static Vagt tagVagt(Job job, Frivillig frivillig, int timer) {
        if (job.ikkeBesatteTimer() < timer)
            throw new RuntimeException("Den ønskede antal time overskrider jobbets begrænsning på 5 timer");

        if (frivillig.ledigeTimer() < timer)
            throw new RuntimeException("Den frivillige har ikke nok ledige timer til at tage dette job");

        return job.createVagt(timer, frivillig);
    }

    public static boolean findFrivillig(Festival festival, String navn) {
        ArrayList<Frivillig> list = festival.frivilligeAnsat();
        if (list.isEmpty()) return false;

        Frivillig frivillig = null;
        int left = 0;
        int right = list.size() - 1;
        int middle;
        while (frivillig == null && left <= right) {
            middle = (left + right) / 2;
            Frivillig k = list.get(middle);

            int comp = k.getNavn().compareTo(navn);
            if (comp == 0)
                frivillig = k;
            else if (comp > 0)
                right = middle - 1;
            else
                left = middle + 1;
        }

        return frivillig != null;
    }

    public static ArrayList<Frivillig> getFrivillige() {
        return Storage.getFrivillige();
    }

    public static ArrayList<Festival> getFestivaller() {
        return Storage.getFestivaler();
    }

    public static void initStorage() {
        Festival festival = createFestival("Northside", LocalDate.of(2020, Month.JUNE, 4),
                LocalDate.of(2020, Month.JUNE, 6));

        Frivillig janeJensen = createFrivillig("Jane Jensen", "12345677", 20);
        Frivillig loneHansen = createFrivillig("Lone Hansen", "78787878", 25);
        Frivillig andersMikkelsen = createFrivillig("Anders Mikkelsen", "55555555", 10);

        FrivilligForening christianMadsen = createFrivilligForening("Christian Madsen", "23232323", 100, "Erhvervsakademi Aarhus", 40);

        for (int i = 1; i <= 9; i++) {
            int antalTimer = 5;
            int timeHonorar = 100;

            if (i <= 3) {
                createJob(festival, "T" + i, "Toilet rengøring " + antalTimer, LocalDate.of(2020, Month.JUNE, 4), timeHonorar, antalTimer);
            } else if (i <= 6) {
                createJob(festival, "T" + i, "Toilet rengøring " + antalTimer, LocalDate.of(2020, Month.JUNE, 5), timeHonorar, antalTimer);
            } else {
                createJob(festival, "T" + i, "Toilet rengøring " + antalTimer, LocalDate.of(2020, Month.JUNE, 6), timeHonorar, antalTimer);
            }
        }

        tagVagt(festival.getJobs().get(4), janeJensen, 5);
        tagVagt(festival.getJobs().get(2), loneHansen, 5);
        tagVagt(festival.getJobs().get(0), andersMikkelsen, 5);
        tagVagt(festival.getJobs().get(8), christianMadsen, 5);

        ArrayList<String> gaver = festival.gaverTilFrivillige();
        for (String person : gaver) {
            System.out.println(person);
        }

        System.out.println("Find frivillige Lone Hansen");
        System.out.println("Expected: true");
        System.out.println("Faktisk: " + findFrivillig(festival, "Lone Hansen"));
        System.out.println("Find frivillige Christian Madsen");
        System.out.println("Expected: true");
        System.out.println("Faktisk: " + findFrivillig(festival, "Christian Madsen"));
        System.out.println("Find frivillige Karsten Olsen");
        System.out.println("Expected: false");
        System.out.println("Faktisk: " + findFrivillig(festival, "Karsten Olsen"));
    }
}
