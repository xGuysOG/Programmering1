package Opgave3;

import java.util.Random;

public class E34 {
    public static void main(String[] args) {
        int month = getRandomNumber(1,7);

        switch (month) {
            case 1:
                System.out.println("violet");
                break;
            case 2:
                System.out.println("indigo");
                break;
            case 3:
                System.out.println("blue");
                break;
            case 4:
                System.out.println("green");
                break;
            case 5:
                System.out.println("yellow");
                break;
            case 6:
                System.out.println("orange");
                break;
            case 7:
                System.out.println("red");
                break;
        }

    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
