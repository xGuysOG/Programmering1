package Opgave1;

import java.util.ArrayList;

public class EX1 {
    public static ArrayList<String> stringList = new ArrayList<>();
    public static void main(String[] args) {
        stringList.add("Hans");
        stringList.add("Viggo");
        stringList.add("Jens");
        stringList.add("Bente");
        stringList.add("Bent");

        System.out.println("Size " + stringList.size());

        stringList.add(2, "Jane");

        System.out.println(stringList);

        stringList.remove(1);
        stringList.add(0,"Pia");
        stringList.add("Ib");
        System.out.println("Size " + stringList.size());

        stringList.set(2, "Hansi");
        System.out.println("Size " + stringList.size());

        System.out.println(stringList);

        for(int i = 0; i < stringList.size(); i++) {
            System.out.println("For " + stringList.get(i).length());
        }

        for (String string : stringList) {
            System.out.println("foreach " + string.length());
        }


    }
}
