package OPG_5;

public class CopierApp {
    public static void main(String[] args) {
        Copier copier = new Copier();

        System.out.println("Papir i maskinen: " + copier.getPaper());

        System.out.println("Fylder maskinen med papir");

        copier.insertPaper(500);
        System.out.println("Papir i maskinen: " + copier.getPaper());

        System.out.println("Overfylder den");
        copier.insertPaper(1);

        System.out.println("Lav en copy");
        copier.makeCopy();
        System.out.println("Ny mængde papir i maskinen: " + copier.getPaper());

        System.out.println("Laver 15 kopier");
        copier.makeCopy(15);
        System.out.println("Ny mængde papir i maskinen: " + copier.getPaper());

        System.out.println("Lav for mange kopier");
        copier.makeCopy(485);
    }
}
