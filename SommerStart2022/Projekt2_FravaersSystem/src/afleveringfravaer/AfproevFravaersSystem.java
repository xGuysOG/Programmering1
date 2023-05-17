package afleveringfravaer;

public class AfproevFravaersSystem {

    public static void main(String[] args) {
        int[][] fravaer22S = {{2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0}, {1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0},
                {5, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0}};

        FravaersSystem fraværsSystem = new FravaersSystem();
        fraværsSystem.udskrivFravaer(fravaer22S);
        System.out.println();

        //TODO opgave 7
        System.out.println("Test 1 - Samletfravær for elevNr 1");
        System.out.println("Forventet: 8");
        System.out.println("Aktuelt: " + fraværsSystem.samletFravaer(fravaer22S, 1));

        System.out.println();

        System.out.println("Test 2 - Gennemsnit for elevNr 5");
        /*  Har valgt ikke at begrænse decimalerne fordi metoden skal give det mest præcise resultat, så kan man altid
            formatere det senere, før det bliver vidst med bl.a:

            String.format("%.2f", fraværsSystem.gennemsnit(fravaer22S, 5));
        */
        System.out.println("Forventet: 1.1666666666666667");
        System.out.println("Aktuelt: " + fraværsSystem.gennemsnit(fravaer22S, 5));

        System.out.println();

        System.out.println("Test 3 - Antal uden fravær");
        System.out.println("Forventet: 1");
        System.out.println("Aktuelt: " + fraværsSystem.antalUdenFravaer(fravaer22S));

        System.out.println();

        System.out.println("Test 4 - Mest fravær");
        System.out.println("Forventet: elev 4");
        System.out.println("Aktuelt: elev " + fraværsSystem.mestFravaer(fravaer22S));

        System.out.println();

        System.out.println("Test 5 - Nulstil fravær");
        System.out.println("Forventet: Elev 3:  0  0  0  0  0  0  0  0  0  0  0  0");
        System.out.println("Aktuelt: ");
        fraværsSystem.nulstil(fravaer22S, 3);
        fraværsSystem.udskrivFravaer(fravaer22S);
    }
}
