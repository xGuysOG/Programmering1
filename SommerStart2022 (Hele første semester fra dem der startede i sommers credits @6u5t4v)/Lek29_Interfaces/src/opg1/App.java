package opg1;

public class App {
    public static void main(String[] args) {
        Chili[] chilies = new Chili[3];
        chilies[0] = new Chili("Bruh", 100);
        chilies[1] = new Chili("yeet", 146310);
        chilies[2] = new Chili("hjælp", 13000);

        System.out.println(max(chilies).getMeasure());
        System.out.println(avg(chilies));
    }

    public static Measurable max(Measurable[] objects) {
        Measurable max = objects[0];

        for (int i = 1; i < objects.length; i++) {
            if (objects[i].getMeasure() > max.getMeasure()) {
                max = objects[i];
            }
        }

        return max;
    }

    public static double avg(Measurable[] objects) {
        int avg = 0;

        for (Measurable m : objects) {
            avg += m.getMeasure();
        }
        return (double) avg / objects.length;
    }
}
