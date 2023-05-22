package OPG_4;

public class RadiatorApp {
    public static void main(String[] args) {
        Radiator radiator1 = new Radiator();
        Radiator radiator2 = new Radiator(22);

        radiator1.skruOp(14);
        System.out.println("Radiator1 er Skruet op til: " + radiator1.getTemperature());
        radiator1.skruNed(3);
        System.out.println("Radiator1 er Skruet ned til: " + radiator1.getTemperature());

        radiator2.skruOp(14);
        System.out.println("Radiator2 er Skruet op til: " + radiator1.getTemperature());
        radiator2.skruNed(6);
        System.out.println("Radiator2 er Skruet ned til: " + radiator2.getTemperature());

    }
}
