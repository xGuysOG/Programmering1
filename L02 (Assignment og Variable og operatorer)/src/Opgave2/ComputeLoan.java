package Opgave2;
import java.util.Scanner;

public class ComputeLoan{
    /*
     Make a program, that inputs a loan amount, the annual interest rate
     and the number of years, and calculates the monthly payment and
     the total payment.
     Monthly payment = loan amount * interest rate pr month / denumerator
     where denumerator = 1 - 1 / (1 + interest rate pr month) ^ number of
     months).
     Use Math.pow(a, b) to calculate a ^ b (example: 2 ^ 3 = 8).
     */
    public static void main(String[] args) {
        System.out.println("Please input the loan amount");
        Scanner input = new Scanner(System.in);
        double loanAmount = input.nextDouble();
        System.out.println("Please input the anual interest rate");
        input = new Scanner(System.in);
        double anaualInterest = input.nextDouble();
        System.out.println("Please input the amount of years of your loan");
        input = new Scanner(System.in);
        double Years = input.nextDouble();
        double monthlyRate = anaualInterest/12;
        double monthPay = loanAmount * monthlyRate /(1 - 1 / Math.pow(1 + monthlyRate, Years * 12));
        double totalPayment = monthPay * Years * 12;

        System.out.println("MonthlyPay is " + monthPay);
        System.out.println("TotalPay is " + totalPayment);
    }

}
