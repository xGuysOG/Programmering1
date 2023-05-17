package Opgave1;

public class EX1 {
    public static void main(String[] args) {
        int min = 2;
        int max = 100;
        int finalInt = 0;
        while (min <= max) {
            if ((min % 2) == 0) {
                finalInt = finalInt + min;
            }
            min++;
        }
        System.out.println("Result is " + finalInt);
    }
}
