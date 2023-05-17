package OPG_6;

public class Date {
    public static String getSeason(int month, int day) {
        String season = "";

        if (month <= 3) season = "Winter";
        else if (month <= 6) season = "Spring";
        else if (month <= 9) season = "Summer";
        else if (month <= 12) season = "Fall";
        if (month % 3 == 0 && day >= 21) {
            season = switch (season) {
                case "Winter" -> "Spring";
                case "Spring" -> "Summer";
                case "Summer" -> "Fall";
                default -> "Winter";
            };
        }

        return season;
    }
}
