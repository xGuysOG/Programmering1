package Opgave3;

import java.util.Scanner;

public class E35 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the day as int ");
        int day = input.nextInt();

        System.out.println("Enter the amount of days from today ");
        int daysSince = input.nextInt();

        int future = (day + daysSince) % 7;

        System.out.println("Todays day is: " + Day(day));

        System.out.println("Future day is: " + Day(future));


    }

    public static String Day(int day) {
        switch (day) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
        }
        return "Error";
    }
}
