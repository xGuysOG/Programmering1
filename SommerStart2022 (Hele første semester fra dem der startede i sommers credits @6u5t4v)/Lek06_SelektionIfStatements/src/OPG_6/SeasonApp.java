package OPG_6;

import java.util.Scanner;

public class SeasonApp {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Skriv en måned (1 - 12)");
            int month = input.nextInt();

            System.out.println("Skriv en dag (1 - 31)");
            int day = input.nextInt();

            String season = Date.getSeason(month, day);

            System.out.println("Sæsonen er " + season);
        }
    }

}
