package Opgave8;

import java.util.Scanner;

public class EX1 {

//    ellers hvis årstid er ”Forår”, så ændres årstid til ”Sommer”
//    ellers hvis årstid er ”Sommer”, så ændres årstid til ”Efterår”
//    ellers ændres årstid til ”Vinter”
//    Skriv er metode der tager to heltal som parametre (måned og dag) og returnerer en
//    String, der beskriver årstiden.
//    Skriv en main() metode, der spørger brugeren efter måned og år, kalder metoden og
//    udskriver resultatet af metode kaldet.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a month");
        int month = input.nextInt();
        if (month > 12) {
            System.out.println("Error month cannot be bigger then 12");
            return;
        }
        input = new Scanner(System.in);
        System.out.print("Enter a day nr");
        int day = input.nextInt();
        if (day > 31) {
            System.out.println("Error day cannot be bigger then 31");
            return;
        }
        System.out.println("The time of year is " + monthToSeason(month,day));
    }


    public static String monthToSeason(int month, int day) {
        String timeOfYear = "";
        if (month == 12 || month == 1 || month == 2) {
            timeOfYear = "Vinter";
        }
        else if (month == 3 || month == 4 || month == 5){
            timeOfYear = "Forår";
        }
        else if (month == 6 || month == 7 || month == 8){
            timeOfYear = "Sommer";
        }
        else {
            timeOfYear = "Efterår";
        }
        if (month == 2 || month == 5 || month == 8 || month == 11) {
            if (day < 21) {
                return timeOfYear;
            }
            else if (timeOfYear.equals("Vinter")) {
                timeOfYear = "Forår";
            }
            else if (timeOfYear.equals("Forår")) {
                timeOfYear = "Sommer";
            }
            else if (timeOfYear.equals("Sommer")) {
                timeOfYear = "Efterår";
            }
            else {
                timeOfYear = "Vinter";
            }
        }
        return timeOfYear;
    }
}
