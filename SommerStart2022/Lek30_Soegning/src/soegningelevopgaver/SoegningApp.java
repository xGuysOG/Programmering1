package soegningelevopgaver;

import java.util.ArrayList;

public class SoegningApp {


    public static void main(String[] args) {
        Soegning s = new Soegning();

        // Kode til afprøvning af opgave 1
        int[] talArray = {2, 4, 8, 2};
        System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
        talArray[2] = 15;
        System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));

        // Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7
        talArray = new int[]{7, 56, 34, 3, 7, 14, 13, 4};
        System.out.println("Er der et tal indenfor [10,15] ? " + s.findHeltal(talArray, 10, 15));

        talArray = new int[]{7, 9, 13, 7, 9, 13};
        System.out.println("Indeholder 2 ens tal ? " + s.toEnsTal(talArray));
        talArray = new int[]{7, 9, 13, 13, 9, 7};
        System.out.println("Indeholder 2 ens tal ? " + s.toEnsTal(talArray));

        System.out.println();

        System.out.println("Heltalskvadratrod (linear): ");
//       {0, 1, 3, 4, 7, 8, 9, 10, 111};
        System.out.println("Forventet: " + 0);
        System.out.println("Realitet: " + s.linearSqrt(0));

        System.out.println("Forventet: " + 1);
        System.out.println("Realitet: " + s.linearSqrt(1));

        System.out.println("Forventet: " + 1);
        System.out.println("Realitet: " + s.linearSqrt(3));

        System.out.println("Forventet: " + 2);
        System.out.println("Realitet: " + s.linearSqrt(4));

        System.out.println("Forventet: " + 2);
        System.out.println("Realitet: " + s.linearSqrt(7));

        System.out.println("Forventet: " + 2);
        System.out.println("Realitet: " + s.linearSqrt(8));

        System.out.println("Forventet: " + 3);
        System.out.println("Realitet: " + s.linearSqrt(9));

        System.out.println("Forventet: " + 3);
        System.out.println("Realitet: " + s.linearSqrt(10));

        System.out.println("Forventet: " + 10);
        System.out.println("Realitet: " + s.linearSqrt(111));

        System.out.println("Heltalskvadratrod (binær): ");
//       {0, 1, 3, 4, 7, 8, 9, 10, 111};
        System.out.println("Forventet: " + 0);
        System.out.println("Realitet: " + s.binearSqrt(0));

        System.out.println("Forventet: " + 1);
        System.out.println("Realitet: " + s.binearSqrt(1));

        System.out.println("Forventet: " + 1);
        System.out.println("Realitet: " + s.binearSqrt(3));

        System.out.println("Forventet: " + 2);
        System.out.println("Realitet: " + s.binearSqrt(4));

        System.out.println("Forventet: " + 2);
        System.out.println("Realitet: " + s.binearSqrt(7));

        System.out.println("Forventet: " + 2);
        System.out.println("Realitet: " + s.binearSqrt(8));

        System.out.println("Forventet: " + 3);
        System.out.println("Realitet: " + s.binearSqrt(9));

        System.out.println("Forventet: " + 3);
        System.out.println("Realitet: " + s.binearSqrt(10));

        System.out.println("Forventet: " + 10);
        System.out.println("Realitet: " + s.binearSqrt(111));

        ArrayList<Integer> list = new ArrayList<>() {{
            add(6);
            add(4);
            add(8);
            add(13);
            add(2);
        }};
        System.out.println(list);
        System.out.println(s.find(list, 13));
        System.out.println(list);
    }

}
