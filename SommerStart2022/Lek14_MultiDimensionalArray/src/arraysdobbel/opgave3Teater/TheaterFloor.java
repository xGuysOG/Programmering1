package arraysdobbel.opgave3Teater;

public class TheaterFloor {
    int[][] seats = {{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10}, {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {20, 20, 30, 30, 40, 40, 30, 30, 20, 20}, {20, 30, 30, 40, 50, 50, 40, 30, 30, 20},
            {30, 40, 50, 50, 50, 50, 50, 50, 40, 30}};

    /**
     * Hvis plads seat på række row er ledig reserveres pladsen og der returneres true
     * Der returneres false hvis pladsen er optaget.
     *
     * @param row
     * @param seat
     * @return
     */

    public boolean buySeat(int row, int seat) {
        if (seats[row - 1][seat - 1] != 0) {
            seats[row - 1][seat - 1] = 0;
            return true;
        }

        return false;
    }

    /**
     * Hvis der er en plads ledig med den pågældende pris, reserveres pladsen og
     * der returneres true. Der returneres false, hvis der ikke er nogen pladser ledige
     * til den pågældende pris.
     *
     * @param price
     * @return
     */
    public boolean buySeat(int price) {
        for (int i = 1; i < seats.length; i++) {
            for (int j = 1; j < seats[i].length; j++) {
                if (seats[i - 1][j - 1] == price) {
                    seats[i - 1][j - 1] = 0;
                    return true;
                }
            }
        }

        return false;

    }

    public void printTheaterFloor() {
        System.out.println("De ledige pladser er angivet med deres pris");

        System.out.print("Sæder:");
        for (int i = 1; i <= seats[0].length; i++) {

            System.out.print("   ");
//            if (i < 10) {
//            } else {
//                System.out.print("    ");
//            }
            System.out.print(i);
        }

        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            System.out.print("Række " + (i + 1) + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                int price = seats[i][j];
                if (price == 0) {
                    System.out.print("--");
                } else {
                    System.out.print(price);
                }

                if (j < seats[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
