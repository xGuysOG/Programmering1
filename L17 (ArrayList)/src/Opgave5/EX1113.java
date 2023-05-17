package Opgave5;

import java.util.ArrayList;
import java.util.List;

public class EX1113 {
    public static void main(String[] args) {
        //Gem tallene i en arraylist, der må kun bruges denne arraylist
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(34,5,3,5,6,4,33,2,2,4));
        System.out.println(list);
        removeDuplicate(list);
        System.out.println(list);

    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(j);
                }
            }
        }
    }
}
