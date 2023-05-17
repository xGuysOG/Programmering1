package Opgave4;

import java.util.Scanner;

public class EX67 {
    public static void main(String[] args) {
        System.out.print("Please input investment amount ");
        Scanner input = new Scanner(System.in);
        double investment = input.nextDouble();
        System.out.println("Please input the anual interest rate in % ");
        input = new Scanner(System.in);
        double interest = input.nextDouble();
        double monthlyInt = (interest / 100) / 12;
        //10000, 0,05, 5 returns 12833,59
        System.out.println("The amount invested: " + investment);
        System.out.println("Annual interest rate: " + interest);
        System.out.println("Years               Future value");
        int i = 1;
        while (i <= 30){
            System.out.println("" + i +"               " + futureInvestmentValue(investment, monthlyInt, i));
            i++;
        }
//        System.out.println("future investment return " + futureInvestmentValue(10000, 0.05/12, 5));
    }
    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        double result = investmentAmount * Math.pow((1 + monthlyInterestRate), years * 12);
        return result;
    }
}
