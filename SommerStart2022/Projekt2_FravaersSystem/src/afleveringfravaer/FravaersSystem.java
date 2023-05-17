package afleveringfravaer;

public class FravaersSystem {
    /**
     * Fraværstallene udskrives på skærmen
     *
     * @param fravaer
     */
    public void udskrivFravaer(int[][] fravaer) {
        System.out.print("Måneder:");
        for (int i = 1; i <= 12; i++) {
            if (i < 10) {
                System.out.print("  ");
            } else {
                System.out.print(" ");
            }

            System.out.print(i);
        }
        System.out.println();

        for (int i = 0; i < fravaer.length; i++) {
            System.out.print("Elev " + (i + 1) + ": ");
            for (int j = 0; j < fravaer[0].length; j++) {
                int absence = fravaer[i][j];
                if (i < 10) {
                    System.out.print("  ");
                } else {
                    System.out.print(" ");
                }
                System.out.print(absence);
            }
            System.out.println();
        }
    }

    /**
     * Returnerer det samlede antal fravaerdage over 12 måneder for eleven med
     * elevnr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public int samletFravaer(int[][] fravaer, int elevNr) {
        int totalAbsence = 0;

        for (int i = 0; i < 12; i++) {
            totalAbsence += fravaer[elevNr - 1][i];
        }

        return totalAbsence;
    }

    /**
     * Returnerer det gennemsnitlige antal fraværsdage pr måned for eleven med
     * elevNr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public double gennemsnit(int[][] fravaer, int elevNr) {
        // TODO opgave 3
        return samletFravaer(fravaer, elevNr) / 12.0;
    }

    /**
     * Returnerer antallet af elever der ikke har haft fravær i de 12 måneder.
     *
     * @param fravaer
     * @return
     */
    public int antalUdenFravaer(int[][] fravaer) {
        int students = 0;

        for (int i = 0; i < fravaer.length; i++) {
            if (samletFravaer(fravaer, i + 1) == 0) {
                students++;
            }
        }

        return students;
    }

    /**
     * Returnerer elevNr for den elev der har haft mest fravær igennem de 12
     * måneder. Hvis flere elever har haft højst fravær, returneres elevnummer
     * for en af disse.
     *
     * @param fravaer
     * @return
     */
    public int mestFravaer(int[][] fravaer) {
        int mostAbsence = 0;
        int id = 0;

        for (int i = 0; i < fravaer.length; i++) {
            int absence = samletFravaer(fravaer, i + 1);
            if (absence > mostAbsence) {
                mostAbsence = absence;
                id = i + 1;
            }
        }
        return id;
    }

    /**
     * Registrerer at elenven med elevNr ikke har haft fravær i nogen af de 12
     * måneder.
     *
     * @param fravaer
     * @param elevNr
     */
    public void nulstil(int[][] fravaer, int elevNr) {
        // TODO opgave 6
        for (int i = 0; i < fravaer[elevNr - 1].length/*kunne også bare være 12*/; i++) {
            fravaer[elevNr - 1][i] = 0;
        }
    }
}
