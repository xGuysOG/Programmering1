package OPG_4;

public class Radiator {
    private int temperature;

    public Radiator(int temperature) {
        this.temperature = temperature;
    }

    public Radiator() {
        this.temperature = 20;
    }

    public int getTemperature() {
        return temperature;
    }

    public void skruOp(int grader) {
        temperature += grader;
    }

    public void skruNed(int grader) {
        temperature -= grader;
    }
}
