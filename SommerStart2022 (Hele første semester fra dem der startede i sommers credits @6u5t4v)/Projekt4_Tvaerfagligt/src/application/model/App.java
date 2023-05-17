package application.model;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Address address = new Address("Campusvej 55", "Odense", "Danmark", 5230);
        LocalDate startDate = LocalDate.of(2022, 5, 18);
        LocalDate endDate = LocalDate.of(2022, 5, 20);

        Conference conference = new Conference(
                "Hav og Himmel",
                1500,
                startDate,
                endDate,
                address);

        System.out.println("Test 1 - Finn Madsen");

        // Test 1
        Participant finnMadsen = new Participant("Finn Madsen", "", null);
        Registration finnMadsenTilmelding = new Registration(finnMadsen, 0, false, startDate, endDate, conference);

        System.out.println("Forventning: " + 4500);
        System.out.println("Resultat: " + finnMadsenTilmelding.totalPrice());
        // -----------

        System.out.println("Test 2 - Niels Petersen");

        // Test 2
        Participant nielsPetersen = new Participant("Niels Petersen", "", null);
        Registration nielsPetersenTilmelding = new Registration(finnMadsen, 0, false, startDate, endDate, conference);

        Hotel denHvideSvane = new Hotel("Den Hvide Svane", 1050, 1250, null);
        conference.addHotel(denHvideSvane);
        HotelReservation hotelReservation = new HotelReservation(denHvideSvane, startDate, endDate, new HotelService[0], false, nielsPetersenTilmelding);
        nielsPetersenTilmelding.setReservedHotel(hotelReservation);


        System.out.println("Forventning: " + 6600);
        System.out.println("Resultat: " + nielsPetersenTilmelding.totalPrice());
        // -----------

        System.out.println("Test 3 - Peter Sommer");

        // Test 3
        Participant peterSommer = new Participant("Peter Sommer", "", null);
        Registration peterSommerTilmelding = new Registration(peterSommer, 0, false, startDate, endDate, conference);

        Companion mieSommer = peterSommerTilmelding.createCompanion("Mie Sommer");

        Trip egeskov = new Trip(
                "Egeskov",
                startDate.plusDays(1),
                75);

        Trip trapHolt = new Trip(
                "Trapholt Museum, Kolding",
                startDate.plusDays(2),
                200);
        mieSommer.addTrip(egeskov);
        mieSommer.addTrip(trapHolt);

        HotelService wifiTjeneste = denHvideSvane.createService("Wifi", 50);

        hotelReservation = new HotelReservation(denHvideSvane, startDate, endDate, new HotelService[]{wifiTjeneste}, false, peterSommerTilmelding);
        peterSommerTilmelding.setReservedHotel(hotelReservation);

        System.out.println("Forventning: " + 7375);
        System.out.println("Resultat: " + peterSommerTilmelding.totalPrice());
        // -----------

        System.out.println("Test 4 - Lone Jensen");

        // Test 3
        Participant loneJensen = new Participant("Lone Jensen", "", null);
        Registration loneJensenTilmelding = new Registration(loneJensen, 0, true, startDate, endDate, conference);

        Companion janMadsen = loneJensenTilmelding.createCompanion("Jan Madsen");

        Trip byTurOdense = new Trip(
                "Byrundtur, Odense",
                startDate,
                125);

        janMadsen.addTrip(byTurOdense);
        janMadsen.addTrip(egeskov);

        hotelReservation = new HotelReservation(denHvideSvane, startDate, endDate, new HotelService[]{wifiTjeneste}, false, loneJensenTilmelding);
        loneJensenTilmelding.setReservedHotel(hotelReservation);

        System.out.println("Forventning: " + 2800);
        System.out.println("Resultat: " + loneJensenTilmelding.totalPrice());
        // -----------

    }
}
