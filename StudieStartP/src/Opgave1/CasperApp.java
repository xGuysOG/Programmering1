package Opgave1;

import java.util.Scanner;

public class CasperApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast navn");
        String name = scanner.next();
        System.out.println("Indtast løn:");
        Double salary = scanner.nextDouble();
        System.out.println("Indtast alder:");
        int age = scanner.nextInt();

        System.out.println(name + " din nye løn er: " + salary(age, salary));


    }
    public static double salary(int age, double salary) {
        double newSalary = 0;
        if (age >= 50) {
            newSalary = salary * 1.10;

        } else if (age < 35) {
            newSalary = salary * 1.05;
        } else {
            newSalary = salary * 1.08;
        }
        return newSalary;
    }

}
