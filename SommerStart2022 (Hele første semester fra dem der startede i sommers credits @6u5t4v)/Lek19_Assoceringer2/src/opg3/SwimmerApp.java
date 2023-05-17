package opg3;

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

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer s3 = new Swimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");

        TrainingPlan levelA = new TrainingPlan('A', 16, 10);
        TrainingPlan levelB = new TrainingPlan('B', 10, 6);

        s1.setPlan(levelA);
        levelA.addSwimmer(s2);
        s3.setPlan(levelB);

        System.out.println("Svømmere på Level A");
        System.out.println();
        for (Swimmer s : levelA.getSwimmers()) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
            System.out.println(s.getName() + "'s ugentlige trænings timer: " + s.allTrainingHours());
            System.out.println("---------");
        }

        System.out.println("Svømmere på Level B");
        System.out.println();
        for (Swimmer s : levelB.getSwimmers()) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
            System.out.println(s.getName() + "'s ugentlige trænings timer: " + s.allTrainingHours());
            System.out.println("---------");
        }
    }

}
