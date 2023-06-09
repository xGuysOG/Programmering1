package Opgave3;

import java.util.Scanner;

public class E36 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in pounds: ");
        double weight = input.nextDouble();
        System.out.print("Enter feet: ");
        double feet = input.nextDouble();
        System.out.print("Enter inches: ");
        double inches = input.nextDouble();

        double kgPrPound = 0.45359237;
        double meterPrInch = 0.0254;
        double FeetPrInch = 0.0833333;

        weight *= kgPrPound;
        double height = (inches += feet / FeetPrInch) * meterPrInch;
        double bmi = weight / (Math.pow(height, 2));

        System.out.println("BMI is " + bmi);
        if (bmi < 18.5)
            System.out.println("Underweight");
        else if (bmi < 25)
            System.out.println("Normal");
        else if (bmi < 30)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
    }
}
