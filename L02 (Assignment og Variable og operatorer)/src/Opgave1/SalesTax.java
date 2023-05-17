package Opgave1;

import java.util.Scanner;

public class SalesTax {
    public static void main(String[] args) {
        System.out.println("Please input the price of your item");
        Scanner input = new Scanner(System.in);
        int price = input.nextInt();
        double newPrice = price * 0.06;
        System.out.println("Tax of this item is " + newPrice);
    }
	/*
	 Make a program, that inputs purchased amount
	 and calculates sales tax (6%).
	 */
}
