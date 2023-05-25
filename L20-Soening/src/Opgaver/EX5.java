package Opgaver;

import java.util.ArrayList;

public class EX5 {

//    Exercise 5
//    Write a method that returns all indexes of a given String in a given ArrayList<String>.
//    The header of the method:
//    public static ArrayList<Integer> findAllIndices(ArrayList<String> list, String target)
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add("banana");
        list.add("apple");

        String target = "banana";

        ArrayList<Integer> indices = findAllIndices(list, target);

        System.out.println("Indices of \"" + target + "\": " + indices);
    }
    public static ArrayList<Integer> findAllIndices(ArrayList<String> list, String target) {
        ArrayList<Integer> indices = new ArrayList<>();
        String element = "";
        for(int i = 0; i < list.size(); i++) {
            element = list.get(i);
            if (element.equals(target)){
                indices.add(i);
            }
        }
        return indices;
    }
}
