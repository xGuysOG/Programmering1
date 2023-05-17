package opg4;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan {
    private char level;
    private int weeklyWaterHours;
    private int weeklyStrengthHours;

    private ArrayList<Swimmer> swimmers = new ArrayList<>();

    public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
        this.level = level;
        this.weeklyWaterHours = weeklyWaterHours;
        this.weeklyStrengthHours = weeklyStrengthHours;
    }

    public char getLevel() {
        return level;
    }

    public void setLevel(char niveau) {
        this.level = niveau;
    }

    public int getWeeklyStrengthHours() {
        return weeklyStrengthHours;
    }

    public void setWeeklyStrengthHours(int weeklyStrengthHours) {
        this.weeklyStrengthHours = weeklyStrengthHours;
    }

    public int getWeeklyWaterHours() {
        return weeklyWaterHours;
    }

    public void setWeeklyWaterHours(int weeklyWaterHours) {
        this.weeklyWaterHours = weeklyWaterHours;
    }

    public ArrayList<Swimmer> getSwimmers() {
        return new ArrayList<>(swimmers);
    }

    public Swimmer createSwimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
        Swimmer swimmer = new Swimmer(name, yearGroup, lapTimes, club);
        swimmers.add(swimmer);

        return swimmer;
    }

    public void removeSwimmer(Swimmer swimmer) {
        swimmers.remove(swimmer);
    }
}
