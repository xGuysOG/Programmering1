package presentation;

import java.time.LocalTime;

public class TestOverlap {
    private static boolean overlapper(LocalTime start1, LocalTime slut1, LocalTime start2, LocalTime slut2) {
        return start1.isBefore(slut2) && slut1.isAfter(start1);
    }

    public static void main(String[] args) {
        LocalTime start1 = LocalTime.of(13, 30, 0);
        LocalTime slut1 = LocalTime.of(15, 0, 0);

        LocalTime start2 = LocalTime.of(14, 0, 0);
        LocalTime slut2 = LocalTime.of(15, 30, 0);

        System.out.println("Forventet: true");
        System.out.println("Realitet: " + overlapper(start1, slut1, start2, slut2));
        System.out.println();

        start1 = LocalTime.of(14, 15, 0);
        slut1 = LocalTime.of(15, 0, 0);

        System.out.println("Forventet: true");
        System.out.println("Realitet: " + overlapper(start1, slut1, start2, slut2));
        System.out.println();

        start1 = LocalTime.of(15, 31, 0);
        slut1 = LocalTime.of(16, 0, 0);

        System.out.println("Forventet: false");
        System.out.println("Realitet: " + overlapper(start1, slut1, start2, slut2));
        System.out.println();

        start1 = LocalTime.of(15, 29, 59);
        slut1 = LocalTime.of(16, 0, 0);

        System.out.println("Forventet: true");
        System.out.println("Realitet: " + overlapper(start1, slut1, start2, slut2));
        System.out.println();
        start1 = LocalTime.of(15, 30, 0);
        slut1 = LocalTime.of(16, 0, 0);

        System.out.println("Forventet: false");
        System.out.println("Realitet: " + overlapper(start1, slut1, start2, slut2));
        System.out.println();
        start1 = LocalTime.of(13, 30, 0);
        slut1 = LocalTime.of(15, 0, 0);
        slut2 = LocalTime.of(14, 30, 0);

        System.out.println("Forventet: true");
        System.out.println("Realitet: " + overlapper(start1, slut1, start2, slut2));

    }
}
