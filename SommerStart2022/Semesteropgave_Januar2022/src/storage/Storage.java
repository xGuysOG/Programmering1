package storage;

import application.model.Forhindring;
import application.model.Løb;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Løb> løbArrayList = new ArrayList<>();
    private static ArrayList<Forhindring> forhindringer = new ArrayList<>();

    public static void addLøb(Løb løb) {
        løbArrayList.add(løb);
    }

    public static void addForhindring(Forhindring forhindring) {
        forhindringer.add(forhindring);
    }

    public static ArrayList<Løb> getLøb() {
        return new ArrayList<>(løbArrayList);
    }

    public static ArrayList<Forhindring> getForhindringer() {
        return new ArrayList<>(forhindringer);
    }
}
