package opg3.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FlightTest {

    public static void main(String[] args) {
        Flight flight = new Flight("AY025", "Seoul");
        flight.createPassenger("Arnold", 31);
        flight.createPassenger("Bruce", 59);
        flight.createPassenger("Dolph", 24);
        flight.createPassenger("Linda", 59);
        flight.createPassenger("Jennifer", 65);

        flight.setDepartDate(LocalDateTime.now());
        flight.setFlightLandDate(LocalDateTime.now().plusHours(3).plusMinutes(40));

        System.out.println(flight.averagePassengerAge());

        long hours = ChronoUnit.HOURS.between(flight.getDepartDate(), flight.getArrivalDate());
        System.out.println("It takes " + hours + " hours, to fly to " + flight.getDestination());
    }

}
