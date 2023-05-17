package opg4;

public class KollegieApp {
    public static void main(String[] args) {
        Kollegie kollegie1 = new Kollegie("EtKollegie", "derover");
        Kollegie kollegie2 = new Kollegie("EtAndetKollegie", "derhennerover");

        Bolig b1 = kollegie1.createBolig(50, "derover 32", 2500);
        Bolig b2 = kollegie1.createBolig(37, "derhenne 21", 1500);
        Bolig b3 = kollegie1.createBolig(80, "derunder 6", 4000);

        System.out.println("Bolig1 er en del af: " + b1.getKollegie().getNavn());
        b1.setKollegie(kollegie2);

        System.out.println("Bolig1 skiftede kollegie: " + b1.getKollegie().getNavn());

        b1.lavLejeaftale();
        b1.lavLejeaftale();

        b2.lavLejeaftale();
        b2.lavLejeaftale();
        b2.lavLejeaftale();

        kollegie1.removeBolig(b2);

        System.out.println("Lejeaftaler hos " + kollegie1.getNavn() + ": " + kollegie1.getAntalLejeaftaler());
    }
}
