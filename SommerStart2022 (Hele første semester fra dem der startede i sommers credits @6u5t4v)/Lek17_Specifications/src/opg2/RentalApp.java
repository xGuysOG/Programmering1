package opg2;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class RentalApp {
    public static void main(String[] args) {
        Rental r1 = new Rental(
                1,
                100,
                LocalDate.now().plusMonths(1).withDayOfMonth(1),
//                LocalDate.of(2022,11,01),
                100);
        Rental r2 = new Rental(
                2,
                100,
                LocalDate.now().plusMonths(10),
                100);

        System.out.println(r1.getTotalPrice());
        System.out.println(r1.getStartDate().minusDays(1));
        System.out.println(r1.getEndDate());
        System.out.println();

        System.out.println(r2.getTotalPrice());
        System.out.println(r2.getStartDate().minusDays(1));
        System.out.println(r2.getEndDate());
        System.out.println("-".repeat(20));

        Period period = r1.getStartDate().until(r2.getStartDate());

        System.out.println(period.getDays() + " dage " + period.getMonths() + " måneder " + period.getYears() + " år");
        System.out.println("-".repeat(20));

        long daysBetween = r1.getStartDate().until(r2.getStartDate(), ChronoUnit.DAYS);
        System.out.println(daysBetween + " dage");
    }
}
