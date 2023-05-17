package application.model;

import java.time.LocalTime;

public class Invalideplads extends Parkeringsplads {
    private double area;

    public Invalideplads(int nummer, double area, Parkeringshus phus) {
        super(nummer, phus);
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public double prisForOphold(LocalTime leave) {
        return 0.0;
    }
}
