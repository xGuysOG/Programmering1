package Opgave4;

import java.util.Scanner;

public class EX26Other {
    public static void main(String[] args) {
        System.out.println("Input a integer ");
        Scanner scanner = new Scanner(System.in);
        int integer = scanner.nextInt();
        //we har tilføjet 932
        int a = integer % 10; // = 2 (det % betyder er at den dividere 10 med et tal og så får vi resten så 10 / 932 efterlader 2.
        int b = integer / 10; // = 93 //ved at dividere uden komma tal får vi så fjernet slutningen af den

        //vi skal bare gør det sammen vi gjorde lige før for at spillet 93 op
        int c = b % 10;
        int d = b / 10;

        System.out.println("Answer is " + (a + c +d));

        //så skal vi bare lave lidt sjovt matematik og så er vi done


    }

}
