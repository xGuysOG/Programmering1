package Opgave2;

import java.time.LocalDate;

public class EX2 {
    public static void main(String[] args) {
        Rental rental = new Rental(1, 10, 30000.0, LocalDate.now().plusMonths(10));
        Rental rental1 = new Rental(1, 10, 30000.0, LocalDate.now().plusMonths(1));

        // Display the distance between point1 and point2
        System.out.println("I total price " + rental.getTotalPrice() + " endate " + rental.getEndDate() + " startdate " + rental.getStartDate().minusDays(1));
        System.out.println("Itotal price " + rental1.getTotalPrice() + " endate " + rental1.getEndDate() + " startdate - 1" + rental1.getStartDate().minusDays(1));
    }

}
