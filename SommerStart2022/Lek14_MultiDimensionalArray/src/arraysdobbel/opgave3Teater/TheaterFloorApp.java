package arraysdobbel.opgave3Teater;

import java.util.Scanner;

public class TheaterFloorApp {

    public static void main(String[] args) {
        TheaterFloor theater = new TheaterFloor();
        theater.printTheaterFloor();

        Scanner input = new Scanner(System.in);

        boolean foundSeat = false;

        while (!foundSeat) {
            System.out.println("Vil du finde et sæde, baseret på pris?");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("Nej")) {
                System.out.println("Indtast et række nummer");
                int row = input.nextInt();

                System.out.println("Indtast et sæde nummer");
                int seat = input.nextInt();

                if (theater.buySeat(row, seat)) {
                    System.out.println("Du har reserveret sædet: " + row + " " + seat);
                    foundSeat = true;
                } else {
                    System.out.println("Sædet " + row + " " + seat + " er desværre reserveret");
                }
            } else {
                System.out.println("Priserne kan være 10, 20, 30, 40 eller 50");
                int price = input.nextInt();
                if (theater.buySeat(price)) {
                    System.out.println("Du har reserveret sædet det første sæde til " + price + "kr");
                    foundSeat = true;
                } else {
                    System.out.println("Intet sæde til " + price + " kunne findes desværre");
                }
            }
        }
        input.close();


        theater.printTheaterFloor();
        // TODO
    }
}
