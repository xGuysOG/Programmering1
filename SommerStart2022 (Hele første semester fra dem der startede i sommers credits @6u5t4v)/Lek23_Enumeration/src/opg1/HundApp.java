package opg1;

import java.util.ArrayList;

public class HundApp {
    public static void main(String[] args) {
        Hund hund1 = new Hund("Kenneth", true, 3000, Race.BOKSER);
        Hund hund2 = new Hund("Bjarne", true, 2000, Race.TERRIER);
        Hund hund3 = new Hund("Bjarke", true, 6000, Race.TERRIER);
        Hund hund4 = new Hund("Kent", true, 10000, Race.PUDDEL);
        Hund hund5 = new Hund("Bruh", true, 3500, Race.PUDDEL);

        ArrayList<Hund> hunde = new ArrayList<>();
        hunde.add(hund1);
        hunde.add(hund2);
        hunde.add(hund3);
        hunde.add(hund4);
        hunde.add(hund5);

        System.out.println(samletPrise(hunde, Race.PUDDEL));
    }

    private static int samletPrise(ArrayList<Hund> hunde, Race race) {
        int totalPrice = 0;
        for (Hund hund : hunde) {
            if (hund.getRace() == race) {
                totalPrice += hund.getPris();
            }
        }

        return totalPrice;
    }
}
