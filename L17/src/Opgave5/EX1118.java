package Opgave5;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class EX1118 {

    public static void main(String[] args) {
        System.out.println(toCharacterArray("Casper"));
    }
    public static ArrayList<Character> toCharacterArray(String s) {
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0;i < s.length(); i++){
            charList.add(s.charAt(i));
        }
        return charList;
    }
}
