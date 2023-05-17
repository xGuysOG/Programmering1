package soegningelevopgaver;

import java.util.ArrayList;
import java.util.Collections;

public class Soegning {

    public boolean findUlige(int[] tabel) {
        // TODO Opgave1
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length - 1) {
            if (tabel[i] % 2 != 0) found = true;
            else i++;
        }
        return found;
    }

    // her skriver du metoder til opgaverne 2,3,5,6 og 7
    public int findHeltal(int[] tabel, int low, int high) {
        int number = -1;
        int i = 0;

        while (number == -1 && i < tabel.length) {
            int k = tabel[i];
            if (k >= low && k <= high) number = k;
            else i++;
        }

        return number;
    }

    public boolean toEnsTal(int[] tabel) {
        int i = 0;
        boolean found = false;

        while (!found && i < tabel.length - 1) {
            int k = tabel[i];
            if (k == tabel[i + 1]) found = true;
            else i++;
        }

        return found;
    }

    public int linearSqrt(int n) {
        int r = 0;

        while (!((r * r) <= n && n < (r + 1) * (r + 1))) {
            r++;
        }

        return r;
    }

    public int binearSqrt(int n) {
        int r = -1;

        int left = 0;
        int right = n;

        while (r == -1 && left <= right) {
            int middle = (left + right) / 2;

            int middleSqrt = middle * middle;

            if (middleSqrt <= n && n < (middle + 1) * (middle + 1)) {
                r = middle;
            } else if (middleSqrt > n) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return r;
    }

    public int find(ArrayList<Integer> list, int n) {
        int target = -1;
        int i = 0;

        while (target == -1 && i < list.size()) {
            int k = list.get(i);

            if (k == n && i != 0) {
                Collections.swap(list, i, i - 1);
//                int temp = list.get(i - 1);
//                list.set(i - 1, k);
//                list.set(i, temp);
                target = i;
            }

            i++;
        }

        return target;
    }
}
