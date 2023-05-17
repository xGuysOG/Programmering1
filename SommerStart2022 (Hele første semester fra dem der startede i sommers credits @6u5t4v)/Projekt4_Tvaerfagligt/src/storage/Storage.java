package storage;

import application.model.Conference;
import application.model.Hotel;
import application.model.Participant;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Conference> conferences = new ArrayList<>();
    private static ArrayList<Participant> participants = new ArrayList<>();
    private static ArrayList<Hotel> hotels = new ArrayList<>();

    // Konference ------------------

    public static void addConference(Conference conference) {
        conferences.add(conference);
    }

    public static void removeConference(Conference conference) {
        conferences.remove(conference);
    }

    public static ArrayList<Conference> getConferences() {
        return new ArrayList<>(conferences);
    }
    // -----------------------------

    // Deltagere -------------------

    public static void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public static void removeParticipant(Participant participant) {
        participants.remove(participant);
    }

    public static ArrayList<Participant> getParticipants() {
        return new ArrayList<>(participants);
    }

    // -----------------------------

    // Hoteller --------------------

    public static void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public static void removeHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    public static ArrayList<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    // -----------------------------
}
