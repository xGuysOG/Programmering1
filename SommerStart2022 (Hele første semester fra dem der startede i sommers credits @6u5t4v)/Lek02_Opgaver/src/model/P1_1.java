package application.model;

public class P1_1 {
    public static void main(String[] args) {
        int gasPerGallon = 4;
        double carMaintenancePerMile = 0.05;
        double milesPerGallon = 26.5;
        double distance = 118; // miles from work to home
        double trainTicket = 30;

        double carMaintenance = distance * carMaintenancePerMile;
        double gallonPrice = (distance / milesPerGallon) * gasPerGallon;

        double costInCar = (carMaintenance + gallonPrice);

        String fastestTransport = costInCar > trainTicket ? "Train" : "Car";

        System.out.println(fastestTransport);
    }
}
