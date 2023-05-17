package opg2;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Mechanic m1 = new Mechanic("Arne", "Sønderhøj 69", 2015, 180);
        Mechanic m2 = new Mechanic("Bjørk", "Vandmandvej 420", 2010, 200);
        Foreman f1 = new Foreman("Torben", "Ildevej 1337", 2001, 250, 2, 80);
        LookMan lm1 = new LookMan("Steve", "Solspurgtvej 9", 2008, 150, 15);

        ArrayList<Mechanic> mechanics = new ArrayList<>();
        mechanics.add(m1);
        mechanics.add(m2);
        mechanics.add(f1);
        mechanics.add(lm1);

        System.out.println(totalSalary(mechanics));
    }

    public static double totalSalary(ArrayList<Mechanic> list) {
        double totalSalary = 0;
        for (Mechanic m : list) {
            totalSalary += m.calculateSalary();
        }

        return totalSalary;
    }
}