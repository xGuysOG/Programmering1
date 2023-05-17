package application.model;

import java.util.ArrayList;

public class MethodsArrayList {

    /**
     * @param list
     * @return sums the mumbers in the list using a for loop
     */
    public int sumListe(ArrayList<Integer> list) {
        int resultat = 0;
        for (int i = 0; i < list.size(); i++) {
            int tal = list.get(i);
            resultat = resultat + list.get(i);
        }
        return resultat;
    }

    /**
     * @param list
     * @return sums the mumbers in the list using a forEach loop
     */
    public int sumListe2(ArrayList<Integer> list) {
        int resultat = 0;
        for (int tal : list) {
            resultat = resultat + tal;
        }
        return resultat;
    }

    /**
     * @param list
     * @return index at the first even number
     */
    public int hasEvenAtIndex(ArrayList<Integer> list) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < list.size()) {
            if (list.get(i) % 2 == 0) {
                index = i;
            }
            i++;
        }
        return index;

    }

    /**
     * Returnerer det mindste tal i liste
     */
    public int min(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int number = list.get(i);
            if (number < min) {
                min = number;
            }
        }

        return min;
    }

    /**
     * Returnerer gemmensnittet af tallene i listen
     */
    public double average(ArrayList<Integer> list) {
        double average = 0.0;
        for (int n : list) {
            average += n;
        }

        return average / list.size();
    }

    /**
     * Returnerer antallet af gange 0 er i listen
     */
    public int countZeros(ArrayList<Integer> list) {
        int zeros = 0;
        for (int n : list) {
            if (n == 0) {
                zeros++;
            }
        }

        return zeros;
    }

    /**
     * Opdater listen så alle lige tal erstattes med 0
     */
    public void swapEvenWithZero(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            final int number = list.get(i);

            if (number % 2 == 0) {
                list.set(i, 0);
            }
        }
    }

    /**
     * Returnerer en ny liste indeholdende alle de lige tal
     * fra list
     */
    public ArrayList<Integer> aEvenList(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>();

        for (int n : list) {
            if (n % 2 == 0) {
                newList.add(n);
            }
        }

        return newList;
    }
}
