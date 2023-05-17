package Opgave1;

public class EX2 {
    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int square = 0;
        int finalInt = 0;
        while (min <= max) {
            square = (min * min);
            if (square <= 100) {
                finalInt = finalInt + square;
            }
            min++;
        }
        System.out.println("Result is " + finalInt);
    }
}
