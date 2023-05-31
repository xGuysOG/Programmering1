import java.util.ArrayList;

public class Example {
    /**
     * Returnerer en sorteret ArrayList, der indeholder
     * alle elementer fra s1 og s2.
     * Pre: s1 og s2 er sorterede.
     */
    public static ArrayList<Integer> flet(ArrayList<Integer> s1,
                                          ArrayList<Integer> s2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
// flet sålænge der er noget i begge lister
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1) <= s2.get(i2)) {
// s1's tal er mindst
                result.add(s1.get(i1));
                i1++;
            }
            else {
// s2's tal er mindst
                result.add(s2.get(i2));
                i2++;
            }
        }
// tøm den liste der ikke er tom
        while (i1 < s1.size()) {
            result.add(s1.get(i1));
            i1++;
        }
        while (i2 < s2.size()) {
            result.add(s2.get(i2));
            i2++;
        }
        return result;
    }

    /**
     * Returnerer en sorteret ArrayList, der kun indeholder
     * de elementer, der findes både i s1 og s2.
     * Pre: s1 og s2 er sorterede.
     */
    public ArrayList<Integer> intersection(
            ArrayList<Integer> s1, ArrayList<Integer> s2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1) < s2.get(i2)) {
                i1++;
            } else if (s1.get(i1) > s2.get(i2)) {
                i2++;
            } else {
                result.add(s1.get(i1));
                i1++;
                i2++;
            }
        }
        return result;
    }

    /**
     *Returnerer et sorteret array, der indeholder
     * alle elementer fra s1 og s2.
     * Pre: s1 og s2 er sorterede.
    */
    public int[] flet(int[] s1, int[] s2) {
        int[] result = new int[s1.length + s2.length];
// flet sålænge der er noget i begge arrays
        int i1 = 0;
        int i2 = 0;
        int j = 0;
        while (i1 < s1.length && i2 < s2.length) {
            if (s1[i1] < s2[i2]) {
// s1's tal er mindst
                result[j] = s1[i1];
                i1++;
                j++;
            }
            else {
// s2's første tal er mindst
                result[j] = s2[i2];
                i2++;
                j++;
            }
        }
// tøm det array der ikke er tomt
        while (i1 < s1.length) {
            result[j] = s1[i1];
            i1++;
            j++;
        }
        while (i2 < s2.length) {
            result[j] = s2[i2];
            i2++;
            j++;
        }
        return result;
    }

}
