package application.controller;

import application.model.*;
import javafx.collections.ObservableList;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Address createAddress(String road, String city, String country, int zipCode) {
        return new Address(road, city, country, zipCode);
    }

    public static Address createAddress(String road, String city) {
        return new Address(road, city, "Danmark", 0);
    }

    // Konference ---------------


    public static Conference createConference(String name, int price, LocalDate start, LocalDate end, Address address) {
        Conference conference = new Conference(name, price, start, end, address);
        Storage.addConference(conference);
        return conference;
    }

    public static void updateConferece(Conference conference, String name, int price, LocalDate start, LocalDate end, Address address) {
        if (conference != null) {
            conference.setName(name);
            conference.setPrice(price);
            conference.setStartDate(start);
            conference.setEndDate(end);
            conference.setAddress(address);
        }
    }

    public static Participant createParticipant(String name, String phoneNr, Address address) {
        return createParticipant(name, phoneNr, address, "", "");
    }

    public static void addTripsToCompanion(Companion companion, Trip... trips) {
        if (companion != null) {
            for (Trip t : trips) {
                companion.addTrip(t);
            }
        }
    }

    public static void setTrips(Companion companion, ObservableList<Trip> trips) {
        for (Trip oldTrip : companion.getTrips()) {
            if (!trips.contains(oldTrip)) {
                companion.removeTrip(oldTrip);
            }
        }

        for (Trip newTrip : trips) {
            if (!companion.getTrips().contains(newTrip)) {
                companion.addTrip(newTrip);
            }
        }
    }

    public static Participant createParticipant(String name, String phoneNr, Address address, String company, String companyNr) {
        Participant participant = new Participant(name, phoneNr, address, company, companyNr);
        Storage.addParticipant(participant);
        return participant;
    }

    public static Registration registerParticipant(Conference conference, Participant participant, boolean isLecture, LocalDate joinDate, LocalDate leaveDate) {
        if (conference != null) {
            // Datoen for hvornår man forlader, kan ikke være før man kommer
            if (leaveDate.isBefore(joinDate)) return null;
            // Datoen for hvornår kommer, kan ikke være før konferencen starter
            if (joinDate.isBefore(conference.getStartDate())) return null;
            // Datoen for hvornår kommer, kan ikke være efter konferencen er slut
            if (joinDate.isAfter(conference.getEndDate())) return null;

            return conference.createRegistration(participant, isLecture, joinDate, leaveDate);
        }

        return null;
    }

    public static String printPricing(Registration registration) {
        StringBuilder description;

        if (registration.isLecture()) {
            description = new StringBuilder(registration.getConference().getName() + ": gratis for foredragsholder");
        } else {
            description = new StringBuilder(registration.getConference().getName() + ": " + registration.getConference().getPrice() + " kr");
        }

        if (registration.hasCompanion()) {
            Companion companion = registration.getCompanion();
            if (!companion.getTrips().isEmpty()) {
                description.append("\nUdflugter:");
                for (Trip trip : companion.getTrips()) {
                    description.append("\n -").append(trip.getName()).append(": ").append(trip.getPrice());
                }
                description.append("\nUdflugter Pris: ").append(companion.priceForTrips());
            }
        }

        if (registration.getReservedHotel() != null) {
            HotelReservation reservation = registration.getReservedHotel();

            description.append("\n").append(reservation.getHotel().getName()).append(": ").append(reservation.dayPrice());

            if (reservation.getServices().length > 0) {
                description.append("\nTilvalgte Tjeneste(r):");
                for (HotelService service : reservation.getServices()) {
                    description.append("\n -").append(service.getName()).append(": ").append(service.getPrice());
                }
            }

            description.append("\nHotel Pris: ").append(reservation.hotelStayPrice());
        }

        description.append("\nTotal Pris: ").append(registration.totalPrice());
        return description.toString();
    }

    public static Trip createTrip(Conference conference, String name, LocalDate start, int price) {
        if (conference != null) {
            // En udflugt kan ikke foregå før konferencen starter
            if (start.isBefore(conference.getStartDate())) return null;
            // En udflugt kan ikke starte efter konference er slut
            if (start.isAfter(conference.getEndDate())) return null;

            return conference.createTrip(name, start, price);
        }

        return null;
    }

    public static void addTrip(Conference conference, Trip trip) {
        if (conference != null)
            conference.addTrip(trip);
    }

    public static void removeTrip(Conference conference, Trip trip) {
        if (conference != null)
            conference.removeTrip(trip);
    }

    public static ArrayList<Conference> getConferences() {
        return Storage.getConferences();
    }

    public static HotelReservation reserveHotel(Registration registration, Hotel hotel, LocalDate checkIn, LocalDate checkOut, HotelService[] selectedServices, boolean doubleRoom) {
        // Man kan ikke tjekke ud før man har tjekket ind
        if (checkOut.isBefore(checkIn)) return null;
        return registration.reserveHotel(hotel, checkIn, checkOut, selectedServices, doubleRoom);
    }

    public static HotelReservation reserveHotel(Registration registration, Hotel hotel, LocalDate checkIn, LocalDate checkOut, boolean doubleRoom) {
        return reserveHotel(registration, hotel, checkIn, checkOut, new HotelService[0], doubleRoom);
    }

    public static void addHotel(Conference conference, Hotel hotel) {
        conference.addHotel(hotel);
    }

    public static void removeHotel(Conference conference, Hotel hotel) {
        conference.removeHotel(hotel);
    }

    public static Hotel createHotel(String name, int priceForOne, int priceForTwo, Address address) {
        return new Hotel(name, priceForOne, priceForTwo, address);
    }

    public static ArrayList<Trip> tripsInEnlistedConference(Registration registration) {
        return registration.getConference().getTrips();
    }

    // --------------------------


    public static void addToTrip(Trip trip, Companion companion) {
        trip.addCompanion(companion);
    }


    public static void initStorage() {
        Address address = createAddress("Campusvej 55", "Odense", "Danmark", 5230);
        LocalDate startDate = LocalDate.of(2022, 5, 18);
        LocalDate endDate = LocalDate.of(2022, 5, 20);
        Conference conference = createConference(
                "Hav og Himmel",
                1500,
                startDate,
                endDate,
                address);

        Conference conference2 = createConference(
                "Røv og baller",
                1000,
                startDate,
                endDate,
                address);

        System.out.println();
        // Test 1 - Finn Madsen
        Participant participant = createParticipant("Finn Madsen", "", null);
        Registration finnMadsen = Controller.registerParticipant(conference, participant, false, startDate, endDate);

        System.out.println("Forventet: " + 4500);
        System.out.println("Resultat: " + finnMadsen.totalPrice());

        System.out.println();
        // Test 2 - Niels Petersen

        participant = createParticipant("Niels Petersen", "", null);
        Registration nielsPetersen = Controller.registerParticipant(conference, participant, false, startDate, endDate);

        Hotel denHvideSvane = Controller.createHotel("Den Hvide Svane", 1050, 1250, null);
        conference.addHotel(denHvideSvane);

        Controller.reserveHotel(nielsPetersen, denHvideSvane, startDate, endDate, false);
        
        System.out.println("Forventet: " + 6600);
        System.out.println("Resultat: " + nielsPetersen.totalPrice());

        System.out.println();
        // Test 3 - Peter Sommer
        participant = createParticipant("Peter Sommer", "", null);
        Registration peterSommer = Controller.registerParticipant(conference, participant, false, startDate, endDate);

        Trip egeSkov = conference.createTrip(
                "Egeskov",
                startDate.plusDays(1),
                75);

        Trip trapholt = conference.createTrip(
                "Trapholt Museum, Kolding",
                startDate.plusDays(2),
                200);

        Companion mieSommer = peterSommer.createCompanion("Mie Sommer");
        addTripsToCompanion(mieSommer, egeSkov, trapholt);

        HotelService wifiService = denHvideSvane.createService("Wifi", 50);
        Controller.reserveHotel(peterSommer, denHvideSvane, startDate, endDate, new HotelService[]{wifiService}, false);

        System.out.println("Forventet: " + 7375);
        System.out.println("Resultat: " + peterSommer.totalPrice());


        System.out.println();
        // Test 4 - Lone Jensen
        participant = createParticipant("Lone Jensen", "", null);
        Registration loneJensen = Controller.registerParticipant(conference, participant, true, startDate, endDate);

        Trip odenseRundtur = conference.createTrip(
                "Byrundtur, Odense",
                startDate,
                125);

        Companion janMadsen = loneJensen.createCompanion("Jan Madsen");
        addTripsToCompanion(janMadsen, egeSkov, odenseRundtur);

        Controller.reserveHotel(loneJensen, denHvideSvane, startDate, endDate, new HotelService[]{wifiService}, false);

        System.out.println("Forventet: " + 2800);
        System.out.println("Resultat: " + loneJensen.totalPrice());


        Hotel hotelPhoenix = Controller.createHotel("Hotel Phønix", 700, 800, null);
        hotelPhoenix.createService("Bad", 200);
        hotelPhoenix.createService("Wifi", 75);
        Hotel pensionTusindfryd = Controller.createHotel("Pension Tusindfryd", 500, 600, null);
        pensionTusindfryd.createService("Morgenmad", 100);

        conference.addHotel(hotelPhoenix);
        conference.addHotel(pensionTusindfryd);
    }

    public static ArrayList<Hotel> getHotels() {
        return Storage.getHotels();
    }
}
