package storage;

import application.model.Festival;
import application.model.Frivillig;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Festival> festivaler = new ArrayList<>();
    private static ArrayList<Frivillig> frivillige = new ArrayList<>();

    public static void addFestival(Festival festival) {
        if (!festivaler.contains(festival))
            festivaler.add(festival);

    }

    public static void addFrivilig(Frivillig frivillig) {
        if (!frivillige.contains(frivillig))
            frivillige.add(frivillig);
    }

    public static ArrayList<Festival> getFestivaler() {
        return new ArrayList<>(festivaler);
    }

    public static ArrayList<Frivillig> getFrivillige() {
        return new ArrayList<>(frivillige);
    }
}

