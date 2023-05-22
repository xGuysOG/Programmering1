package OPG4;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Kunde[] kunder = new Kunde[5];
        kunder[0] = new Kunde("John", "Aoe");
        kunder[1] = new Kunde("Alice", "Smith");
        kunder[2] = new Kunde("Bob", "Johnson");
        System.out.println(Arrays.toString(kunder));
        Kunde nyKunde = new Kunde("Charlie", "Brown");
        indsætKunde(kunder, nyKunde);
        System.out.println(Arrays.toString(kunder));
    }

    /**
     * Indsætter kunde i kunder.
     * Pre: kunder er sorteret
     */
    public static void indsætKunde(Kunde[] kunder, Kunde kunde){
        int index = 0;
        for (index = 0; index < kunder.length; index++) {
            if (kunder[index] == null || kunde.getLastName().compareTo(kunder[index].getLastName()) < 0){
                //if its null or there is no one to add it after then we break
                break;
            }
            if (kunde.getLastName().compareTo(kunder[index].getLastName()) == 0) {
                //if last name == 0 that means someone has the same lastname so we need to check firstname
                if (kunde.getFirstName().compareTo(kunder[index].getFirstName()) < 0) {
                    //if there is no one to add it after then we break
                    break;
                }
            }
        }
        //Now we have the index to work with

        //so now we can and it

        System.out.println(index);
        for (int i = kunder.length - 1; i > index; i--) {
            kunder[i] = kunder[i - 1];
        }
        kunder[index] = kunde;
    }
}
