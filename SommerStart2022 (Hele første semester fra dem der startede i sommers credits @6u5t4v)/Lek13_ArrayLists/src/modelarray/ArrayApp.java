package modelarray;

import java.util.Arrays;

public class ArrayApp {

    public static void main(String[] args) {
        ArrayMethods metode = new ArrayMethods();

        int[] tabel = metode.fyldArrayA();
        System.out.println("Forventet: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayB();
        System.out.println("Forventet: [2, 44, -23, 99, 8, -5, 7, 10, 20, 30]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayC();
        System.out.println("Forventet: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayD();
        System.out.println("Forventet: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayE();
        System.out.println("Forventet: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayF();
        System.out.println("Forventet: [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayG();
        System.out.println("Forventet: [0, 1, 2, 3, 4, 0, 1, 2, 3, 4]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        System.out.println("Forventet: 22");
        System.out.println("Aktuelt  : " + metode.sum(new int[]{4, 6, 7, 2, 3}));
        System.out.println();

        int[] a = {4, 6};
        int[] b = {3, 2, 9, 5, 5};
//        int[] a = {4, 6, 7, 2, 3};
//        int[] b = {3, 0, 9, 5, 5};
        tabel = metode.makeSum(a, b);
        System.out.println("Forventet: [7, 8, 9, 5, 5]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
//        System.out.println("Forventet: [7, 6, 16, 7, 8]");
        System.out.println();

        System.out.println("Forventet: true");
        System.out.println("Aktuelt  : " + metode.hasUneven(new int[]{4, 6, 7, 2, 3}));
        System.out.println();

        System.out.println("Forventet: false");
        System.out.println("Aktuelt  : " + metode.hasUneven(new int[]{4, 6, 8, 2, 6}));
        System.out.println();

        tabel = metode.swapFirstLast(new int[]{4, 6, 8, 2, 6});
        System.out.println("Forventet: [6, 6, 8, 2, 4]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.pushRight(new int[]{1, 4, 9, 16, 2});
        System.out.println("Forventet: [2, 1, 4, 9, 16]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.replaceZeros(new int[]{1, 4, 9, 16, 2});
        System.out.println("Forventet: [1, 0, 9, 0, 0]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        System.out.println("Forventet: true");
        System.out.println("Aktuelt  : " + metode.isSorted(new int[]{1, 2, 4, 9, 16}));
        System.out.println();

        System.out.println("Forventet: false");
        System.out.println("Aktuelt  : " + metode.isSorted(new int[]{1, 4, 9, 16, 2}));
        System.out.println();

        System.out.println("Forventet: false");
        System.out.println("Aktuelt  : " + metode.hasDuplicates(new int[]{2, 5, 8, 6}));
        System.out.println();

        System.out.println("Forventet: true");
        System.out.println("Aktuelt  : " + metode.hasDuplicates(new int[]{2, 5, 8, 5}));
        System.out.println();
        //         int[] tabel2 = { 78, 23, 1, 4, 65, 3, 87, 5, 12 };
//         metode.printArray(tabel2);
//
//         System.out.println(metode.findMax(tabel2));
    }
}
