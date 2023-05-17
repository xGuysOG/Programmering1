package Opgave3;

public class Program {
    public static void main(String[] arg) {
        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";

        //A
        System.out.println(ord1.toUpperCase());

        //B
        System.out.println(ord2.toLowerCase());

        //C
        System.out.println(ord1 + " " + ord2);

        //D
        String ord3 = ord1 + ord2.toLowerCase();

        //E
        System.out.println(ord3.length());

        //F
        String firstSevenLetters = ord1.substring(0, 7);
        System.out.println(firstSevenLetters);

        //G
        String letters37 = ord2.substring(2, 7);
        System.out.println(letters37);

        //H
        int halfway = ord3.length() / 2;
        String lastHalf = ord3.substring(halfway);
        System.out.println(lastHalf);

    }
}
