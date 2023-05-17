package application.model;

public class ProfSpiller extends Spiller {
    private double kampHonorar;

    public ProfSpiller(String navn, int årgang, double kampHonorar) {
        super(navn, årgang);
        this.kampHonorar = kampHonorar;
    }

    @Override
    public double kampHonorar() {
        int missed = getDeltagelser().size() - deltager().size();

        double reduce = kampHonorar * missed / 100d;

        return kampHonorar - reduce;
    }

    public double getKampHonorar() {
        return kampHonorar;
    }
}
