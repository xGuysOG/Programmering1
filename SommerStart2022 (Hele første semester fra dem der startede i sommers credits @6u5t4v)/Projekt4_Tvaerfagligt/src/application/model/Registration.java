package application.model;

import java.time.LocalDate;
import java.time.Period;

public class Registration {
    private Participant participant;
    private boolean isLecture;
    //    private boolean doubleRoom;
    private int participationNr;
    private LocalDate joinDate;
    private LocalDate leaveDate;

    private Conference conference;
    private Companion companion;
    private HotelReservation reservedHotel;

    // TODO Fjernede doubleRoom attribut
    // TODO tilføjer en setter til companion
    public Registration(Participant participant, int participationNr, boolean isLecture, LocalDate join, LocalDate leave, Conference conference) {
        this.participant = participant;
        this.participationNr = participationNr;
        this.isLecture = isLecture;
        this.joinDate = join;
        this.leaveDate = leave;
        this.conference = conference;
    }

    public HotelReservation reserveHotel(Hotel hotel, LocalDate checkIn, LocalDate checkOut, HotelService[] selectedServices, boolean doubleRoom) {
        reservedHotel = new HotelReservation(hotel, checkIn, checkOut, selectedServices, doubleRoom, this);
        hotel.addReservation(reservedHotel);
        return reservedHotel;
    }

    public Companion createCompanion(String name) {
        companion = new Companion(name, this);
        return companion;
    }

    public Participant getParticipant() {
        return participant;
    }

    public boolean isLecture() {
        return isLecture;
    }

    public Companion getCompanion() {
        return companion;
    }

    public int totalPrice() {
        // Hvis man er foredragsholder, så skal man ikke betale for konferencen
        int days = Period.between(joinDate, leaveDate).getDays() + 1;

        int totalPrice = isLecture ? 0 : conference.getPrice() * days;

        // Har lavet denne variable for læselighed og genanvendelighed

        // Tilføj den totale pris for udflugterne til den overordnet pris.
        if (hasCompanion()) {
            totalPrice += companion.priceForTrips();
        }

        // Hvis man har reserveret et hotel, tilføjes omkostninger derfra heraf
        // hotellets pris plus tilvalgte tjenester til den totale pris.
        if (reservedHotel != null) {
            totalPrice += reservedHotel.hotelStayPrice();
        }

        return totalPrice;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setLecture(boolean lecture) {
        isLecture = lecture;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    public HotelReservation getReservedHotel() {
        return reservedHotel;
    }

    public void setReservedHotel(HotelReservation reservedHotel) {
        this.reservedHotel = reservedHotel;
    }

    public int getParticipationNr() {
        return participationNr;
    }

    public Conference getConference() {
        return conference;
    }

    public boolean hasCompanion() {
        return companion != null;
    }

    public void setCompanion(Companion companion) {
        this.companion = companion;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    @Override
    public String toString() {
        String s = participant.getName() + " (" + participationNr + ")\n" + "Foredragsholder: " + isLecture + "\nTelefonNr: " + participant.getPhoneNr();

        if (hasCompanion()) {
            s += "\nLedsager: " + companion.getName();
        }

        return s;
    }
}
