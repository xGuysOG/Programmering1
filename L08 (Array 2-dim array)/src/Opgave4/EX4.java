package Opgave4;

import java.util.Scanner;

public class EX4 {
    public static int[][] data = {
            {10,10,10,10,10,10,10,10,10,10},
            {10,10,10,10,10,10,10,10,10,10},
            {10,10,10,10,10,10,10,10,10,10},
            {10,10,20,20,20,20,20,20,10,10},
            {10,10,20,20,20,20,20,20,10,10},
            {10,10,20,20,20,20,20,20,10,10},
            {20,20,30,30,40,40,30,30,20,20},
            {20,30,30,40,50,50,40,30,30,20},
            {30,40,50,50,50,50,50,50,40,30}
    };
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the ticket price you would like to buy from");
        int price = input.nextInt();
        if (buyTicket(price)) {
            System.out.println("Succesfully bought the ticket");
        } else {
            System.out.println("Error no ticket available at that price");
        }
        System.out.println("This is the current seats availble");
        printTheaterFloor();
        System.out.println("Please enter the row and seat seat nr that youw would like");
        int row = input.nextInt();
        int seat = input.nextInt();
        if (buyTicket(row,seat)) {
            System.out.println("Succesfully bought the ticket");
        } else {
            System.out.println("Eror the ticket at that interval is not available");
        }

        printTheaterFloor();
    }

    public static boolean buyTicket(int price) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] == price) {
                    data[row][col] = 0;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean buyTicket(int rowNo, int seatNo) {
        if (data[rowNo-1][seatNo-1] == 0) {
            System.out.println("This seat has already been purchased");
            return false;
        }
        data[rowNo-1][seatNo-1] = 0;
        return true;
    }

    public static void printTheaterFloor() {
        System.out.println("De ledige pladser er angivet med deres pris");
        System.out.println("   Sæde : 1   2   3   4   5   6   7   8   9   10");
        System.out.println("        -----------------------------------------");
        for (int row = 0; row < data.length; row++) {
            System.out.print("Række " +  (row + 1) + " : ");
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] == 0) {
                    System.out.print("--");
                } else {
                    System.out.print(data[row][col]);
                }
                if (col != data[row].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }
}
