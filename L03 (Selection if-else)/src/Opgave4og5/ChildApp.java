package Opgave4og5;

public class ChildApp {
    public static String institution(int age) {
        if (age == 0) {
            return "Home";
        } else if (age <= 2) {
            return "Nursery";
        } else if (age <= 5) {
            return "Kindergarten";
        } else if (age <= 16) {
            return "School";
        } else {
            return "Out of school";
        }
    }
    public static String team(boolean isBoy, int age) {
        if (!isBoy) {
            if (age >= 8) {
                return "Springy girls";
            } else {
                return "Tumbling girls";
            }
        } else {
            if (age >= 8) {
                return "Cool boys";
            } else {
                return "Young cubs";
            }
        }
    }

}
