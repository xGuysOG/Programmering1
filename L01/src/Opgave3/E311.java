package Opgave3;

import java.sql.Date;
import java.time.Month;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Scanner;

public class E311 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a month nr");
        int month = input.nextInt();
        System.out.print("Enter a year");
        int year = input.nextInt();

        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth(); //28
        System.out.println("The amount of days in " + yearMonthObject.getMonth().name() + " is " + daysInMonth);

    }
}
