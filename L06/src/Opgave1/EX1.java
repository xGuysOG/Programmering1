package Opgave1;

public class EX1 {
    public static void main(String[] args) {
        int max = 100;
        int finalInt = 0;
        for(int i = 2; i <= max; i++) {
            if ((i % 2) == 0) {
                finalInt = finalInt + i;

            }
        }
        System.out.println("Result is " + finalInt);
    }
}
