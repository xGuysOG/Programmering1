package Opgave1;


import java.util.Arrays;
import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        int[] a = {0,0,0,0,0,0,0,0,0,0};
        int[] b = {2,44,-23,99,8,-5,7,10,20,30};
        int[] c = new int[10];
        //c
        for (int i = 0; i < c.length; i++) {
            c[i] = i;
        }
        //d
        int[] d = new int[10];
        int d2 = 2;
        for (int i = 0; i < d.length; i++) {
            d[i] = d2;
            d2 += d2 + 2;
        }

        int[] e = new int[10];
        for (int i = 0; i < e.length; i++) {
            e[i] = (int) Math.pow(i + 1 , 2);
        }
        int[] f = new int[10];
        for (int i = 0; i < f.length; i++) {
            if (i % 2 == 0) {
                f[i] = 0;
            } else {
                f[i] = 1;
            }
        }
        int[] g = new int[10];
        for (int i = 0; i < g.length; i++) {
            g[i] = i % 5;
        }
        int[] h = new int[10];
        for (int i = 0; i < h.length; i++) {
            if (i == 0) {
                h[i] = 0;
            } else if (i == 1) {
                h[i] = 3;
            } else if (i == 2) {
                h[i] = 4;
            } else if (i == 3) {
                h[i] = 7;
            } else if (i == 4) {
                h[i] = 8;
            } else if (i == 5) {
                h[i] = 11;
            } else if (i == 6) {
                h[i] = 12;
            } else if (i == 7) {
                h[i] = 15;
            } else if (i == 8) {
                h[i] = 16;
            } else {
                h[i] = 19;
            }
        }


        System.out.println("End me A" + Arrays.toString(a));
        System.out.println("End me B" + Arrays.toString(b));
        System.out.println("End me C" + Arrays.toString(c));
        System.out.println("End me D" + Arrays.toString(d));
        System.out.println("End me E" + Arrays.toString(e));
        System.out.println("End me F" + Arrays.toString(f));
        System.out.println("End me G" + Arrays.toString(g));
        System.out.println("End me H" + Arrays.toString(h));
    }

}