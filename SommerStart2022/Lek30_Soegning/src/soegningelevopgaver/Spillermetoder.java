package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        int i = 0;
        while (i < spillere.size()) {
            Spiller k = spillere.get(i);
            if (k.getMaal() == score) {
                return k;
            }
            i++;
        }

        return null;
    }

    // Her tilføjes metoder der løser opgve 4.2 og 4.3
    public Spiller findScoreBinear(ArrayList<Spiller> spillere, int score) {
        int i = 0;
        int left = 0;
        int right = spillere.size() - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            Spiller k = spillere.get(middle);

            if (k.getMaal() == score) {
                return k;
            } else if (k.getMaal() < score) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            i++;
        }

        return null;
    }

    public String godSpiller(ArrayList<Spiller> spillere) {
        int i = 0;
        while (i < spillere.size()) {
            Spiller k = spillere.get(i);

            if (k.getHoejde() < 170 && k.getMaal() > 50) {
                return k.getNavn();
            } else {
                i++;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));

        System.out.println("Spiller der har scoret 35 mål(linear): " + metoder.findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål(linear): " + metoder.findScoreLinear(spillerListe, 30));

        // Tilføj kode der afprøver opgaver 4.2 og 4.3
        System.out.println("Spiller der har scoret 35 mål(binær): " + metoder.findScoreBinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål(binær): " + metoder.findScoreBinear(spillerListe, 30));

        System.out.println("God Spiller under 170 og mere end 50 mål: " + metoder.godSpiller(spillerListe));
        spillerListe.add(new Spiller("Bruh", 165, 56, 54));
        System.out.println("God Spiller under 170 og mere end 50 mål: " + metoder.godSpiller(spillerListe));
    }


}
