package Opgave1;

public class EX2 {
    public static void main(String[] args) {
        printPowersOfTwo();
    }

    public static void printPowersOfTwo(){
        int max = 20;
        int result = 1;

        for(int min = 0; min <= max; min++) {
            int min1 = 0;
            result = 1;
            while (min1 != min) {
                result = result * 2;
                min1++;
            }
            System.out.println("Result is of 20  " + result + " || " + min + "/" + 20);
        }
    }
}
