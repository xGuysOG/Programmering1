package opg3;

import opg3.model.*;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Mechanic m1 = new Mechanic("Arne", "Sønderhøj 69", 2015, 180);
        Mechanic m2 = new Mechanic("Bjørk", "Vandmandvej 420", 2010, 200);
        Foreman f1 = new Foreman("Torben", "Ildevej 1337", 100, 2, 80);
        LookMan lm1 = new LookMan("Steve", "Solspurgtvej 9", 2008, 150, 15);
        ChildWorker cw1 = new ChildWorker("Sejt navn", "NA", 20);
        ChildWorker cw2 = new ChildWorker("Bruh", "NA", 20);
        ChildWorker cw3 = new ChildWorker("Jeg ve sku ik", "NA", 15);

        ArrayList<Employee> mechanics = new ArrayList<>();
        mechanics.add(m1);
        mechanics.add(m2);
        mechanics.add(f1);
        mechanics.add(lm1);
        mechanics.add(cw1);
        mechanics.add(cw2);
        mechanics.add(cw3);

        System.out.println(totalWeeklyWage(mechanics));
    }

    public static double totalWeeklyWage(ArrayList<Employee> list) {
        double weeklyWage = 0.0;

        for (Employee e : list) {
            System.out.println(e.getName() + ": " + e.calculateSalary());
            weeklyWage += e.calculateSalary();
        }

        return weeklyWage;
    }

    ;
}