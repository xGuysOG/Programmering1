package opg4;

public class Data {
    public static Measurable max(Measurable[] objects, Filter filter) {
        Measurable max = objects[0];

        for (int i = 1; i < objects.length; i++) {
            Measurable current = objects[i];
            if (filter.accept(current) && current.getMeasure() > max.getMeasure()) {
                max = current;
            }
        }

        return max;
    }

    public static double avg(Measurable[] objects, Filter filter) {
        int avg = 0;
        int amount = 0;

        for (Measurable m : objects) {
            if (filter.accept(m)) {
                avg += m.getMeasure();
                amount++;
            }
        }
        return (double) avg / amount;
    }
}
