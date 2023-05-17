package application.model;

import java.util.ArrayList;

public class MethodsArrayListApp {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(19);
        list.add(35);
        list.add(14);
        list.add(7);
        MethodsArrayList methods = new MethodsArrayList();
//        System.out.println(list);
//        System.out.println("Summen af tallene i listen med for "
//                + methods.sumListe(list));
//        System.out.println("Summen af tallene i listen med forEach "
//                + methods.sumListe2(list));
//
//        System.out.println("Indeks for det første lige tal: "
//                + methods.hasEvenAtIndex(list));


        System.out.println("Mindste tal: " + methods.min(list));
        System.out.println("Gennemsnittet: " + methods.average(list));
        System.out.println("Nuller i listen: " + methods.countZeros(list));

        methods.swapEvenWithZero(list);
        System.out.println("lige tal = nuller: " + list);

        list.add(2);
        list.add(8);
        list.add(10);
        System.out.println("Lige tal: " + methods.aEvenList(list));
    }

}
