package opg5;

import java.util.ArrayList;

public class Episode {
    private int number;
    private ArrayList<String> guestActors = new ArrayList<>();
    private int lengthMinutes;

    Episode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        this.number = number;
        this.guestActors = guestActors;
        this.lengthMinutes = lengthMinutes;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<String> getGuestActors() {
        return guestActors;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }
}
