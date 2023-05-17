package helper;

import java.util.Random;

public class Randomizer {
    final static Random random = new Random();

    static String[] firstNames = new String[]{
            "Gustav", "Josefine", "Henrik", "Bo", "Arne", "Hjalte", "Cecilie", "Marie", "Isabell", "Frederik", "Jens", "Morten",
            "Henning", "Benny", "Bent"
    };

    static String[] lastNames = new String[]{
            "Gustavsen", "Frederiksen", "Jensen", "Dolph", "Frank", "Poulsen", "Fuck"
    };

    public static String getRandomFirstName() {
        return firstNames[random.nextInt(firstNames.length - 1)];
    }

    public static String getRandomLastName() {
        return lastNames[random.nextInt(lastNames.length - 1)];
    }

    public static int randomAge() {
        return random.nextInt(15, 39);
    }
}
