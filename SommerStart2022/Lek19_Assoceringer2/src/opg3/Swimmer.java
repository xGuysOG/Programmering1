package opg3;

import java.util.ArrayList;

/**
 * Modeling a Swimmer
 */
public class Swimmer {
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;

    private TrainingPlan plan;

    /**
     * Initialize a new swimmer with name, club, yearGroup, and lap times.
     */

    public Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
        this.name = name;
        this.yearGroup = yearGroup;
        this.lapTimes = lapTimes;
        this.club = club;
    }

    /**
     * Return the name of the swimmer
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the yearGroup of the swimmer
     */
    public int getYearGroup() {
        return this.yearGroup;
    }

    /**
     * Return the club of the swimmer
     */
    public String getClub() {
        return this.club;
    }

    /**
     * Register the club of the swimmer
     *
     * @param club
     */
    public void setClub(String club) {
        this.club = club;
    }

    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
        double best = Double.MAX_VALUE;
        for (double time : lapTimes) {
            if (best > time) {
                best = time;
            }
        }
        return best;
    }

    public int allTrainingHours() {
        return plan.getWeeklyWaterHours() + plan.getWeeklyStrengthHours();
    }

    public TrainingPlan getPlan() {
        return plan;
    }

    public void setPlan(TrainingPlan plan) {
        if (this.plan != plan) {
            final TrainingPlan oldPlan = this.plan;
            if (oldPlan != null) {
                plan.removeSwimmer(this);
            }
            this.plan = plan;
            plan.addSwimmer(this);
        }
    }
}
