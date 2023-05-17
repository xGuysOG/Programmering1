package Opgave4;

import java.util.Scanner;

public class EX22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the lenght of the sides of the3 triangle");
        double lenght = input.nextDouble();
        double area = (Math.sqrt(3) / 4) * (Math.pow(lenght, 2));
        System.out.println("Area of the triangle is " + area);
        double volume = area * lenght;
        System.out.println("volume of the triangle is " + volume);
    }

}
