package demospecifications;

public class App {

    public static void main(String[] args) {
        int year = 2023;
        System.out.println(year + " is leap year? " + App.isLeapYear(year));
        System.out.println();

        System.out.println("Month: length");
        for (int i = 1; i <= 12; i++) {
            System.out.printf("%5d: %2d\n", i, App.monthLength(i, year));
        }
    }

    /**
     * Return true, if the year is a leap year.<br />
     * Pre: Param year > 1582.
     */
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    /**
     * Return the length of the given month in the given year.<br/>
     * Pre: 1 <= month <= 12, year > 1582.<br/>
     * Note: Uses the Gregorian calendar rule for leap years.
     */
    public static int monthLength(int month, int year) {
        int length = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            length = 30;
        } else if (month == 2) {
            if (App.isLeapYear(year)) {
                length = 29;
            } else {
                length = 28;
            }
        }
        return length;
    }

    /**
     * Return the length of the given month in the given year.<br/>
     * Pre: 1 <= month <= 12, year > 1582.<br/>
     * Note: Uses the Gregorian calendar rule for leap years.
     */
    public static int monthLength1(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> App.isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> -1;
        };
    }
}
