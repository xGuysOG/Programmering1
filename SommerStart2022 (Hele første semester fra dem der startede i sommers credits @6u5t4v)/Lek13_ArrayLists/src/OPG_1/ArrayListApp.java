package OPG_1;

import java.util.ArrayList;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hans");
        arrayList.add("Viggo");
        arrayList.add("Jens");
        arrayList.add("Børge");
        arrayList.add("Bent");

        System.out.println("Elementer i listen: " + arrayList.size());

        arrayList.add(2, "Jane");

        System.out.println(arrayList);

        arrayList.remove(1);

        arrayList.add(0, "Pia");
        arrayList.add("Ib");

        System.out.println("Elementer i listen: " + arrayList.size());

        arrayList.set(2, "Hansi");
        System.out.println("Elementer i listen: " + arrayList.size());

        System.out.println(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).length() + " ");
        }
        System.out.println();

        for (String s : arrayList) {
            System.out.print(s.length() + " ");
        }
        System.out.println();

    }
}
