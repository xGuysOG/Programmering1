package Opgave2.ui;

import Opgave2.Konto;
import Opgave2.KontoType;
import Opgave2.Transaktion;

public class mainStuff {
    public static void main(String[] args) {
        KontoType kontoType = new KontoType("Test1", "A test konto type");
        KontoType kontoType2 = new KontoType("Test2", "A test konto type2");

        Konto konto = new Konto(1,kontoType);
        Konto konto2 = new Konto(2, kontoType2);

        Transaktion transaktion = new Transaktion(100);
        Transaktion transaktion1 = new Transaktion(500);

        System.out.println("konto type " + kontoType.toString());
        System.out.println("konto type2 " + kontoType2.toString());

        System.out.println("konto " + konto.toString());
        System.out.println("konto 2  " + kontoType2.toString());

        System.out.println("Transaktion " + transaktion.toString());
        System.out.println("Transaktion1 " + transaktion1.toString());

        konto.addTransaktion(transaktion);
        konto.addTransaktion(transaktion1);


        System.out.println("konto " + konto.toString());
        System.out.println("konto 2  " + kontoType2.toString());
    }
}
