package opg2;

import java.util.ArrayList;

public class SwimmerApp {

    public static void main(String[] args) {

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer s2 = new Swimmer("Bo", 1995, lapTimes, "Lyseng");

        TrainingPlan trainingPlan = new TrainingPlan('A', 16, 10);

        trainingPlan.addSwimmer(s1);
        trainingPlan.addSwimmer(s2);

//        ArrayList<Swimmer> levelBSwimmers = levelB.getSwimmers();
//        if (levelBSwimmers.contains(s1)) {
//            levelB.removeSwimmer(s1);
//        }
//        levelA.addSwimmer(s1);
//
//        if (levelBSwimmers.contains(s2)) {
//            levelB.removeSwimmer(s2);
//        }
//        levelA.addSwimmer(s2);

        for (Swimmer s : trainingPlan.getSwimmers()) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
        }
    }
}
