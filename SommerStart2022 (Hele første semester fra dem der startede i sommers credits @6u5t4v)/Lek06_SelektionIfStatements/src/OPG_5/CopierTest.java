package OPG_5;

public class CopierTest {
    public static void main(String[] args) {
        Copier testCopier = new Copier(3);

        System.out.println("Test makeCopy()");
        System.out.println("Expected: " + 2);
        testCopier.makeCopy();
        System.out.println(testCopier.getPaper());

        System.out.println("=============================");

        System.out.println("Test insertPaper(500) (overfyld maskinen)");
        System.out.println("Expected: \"Ikke plads til mere papir\"");
        testCopier.insertPaper(500);

        System.out.println("=============================");

        testCopier.insertPaper(48);
        System.out.println("Test makeCopy(15) (50 papir i maskinen)");
        System.out.println("Expected: " + 35);
        testCopier.makeCopy(15);
        System.out.println(testCopier.getPaper());

        System.out.println("=============================");

        System.out.println("Test makeCopy(485) (too many copies)");
        System.out.println("Expected: \"Ikke nok papir til at lave \" + 485 + \" kopier\"");
        testCopier.makeCopy(485);
    }
}
