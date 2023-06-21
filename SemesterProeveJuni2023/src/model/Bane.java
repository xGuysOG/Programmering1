package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Bane {

    private int nummer;
    private boolean inde;
    private LocalTime førsteTid;
    private LocalTime sidsteTid;

    private Kategori kategori;

    private ArrayList<Booking> bookinger;

    public Bane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {
        this.nummer = nummer;
        this.inde = inde;
        this.førsteTid = førsteTid;
        this.sidsteTid = sidsteTid;
        this.kategori = kategori;
        this.bookinger = new ArrayList<>();
    }

    public int bookedeTimerPåDato(LocalDate dato) {
        int antal = 0;
        for(Booking booking : bookinger){
            if (dato.equals(booking.getDato())) {
                antal++;
            }
        }
        return antal;
    }

    public boolean indenForÅbningsTid(LocalTime tid) {
        if (tid.isBefore(førsteTid)) {
            System.out.println("Stopping here 2");
            return false;
        }
        if (tid.isAfter(sidsteTid)) {
            System.out.println("Stopping here 1");
            return false;
        }
        return true;
    }


    public boolean tidLedig(LocalDate dato, LocalTime tid){
        boolean ledig = true;
        int i = 0;

        while (ledig && i < bookinger.size()){
            Booking booking = bookinger.get(i);
            if (booking.getDato().equals(dato)){
                //now we check more
                if (booking.getTid().equals(tid) || !indenForÅbningsTid(tid)) {
                    ledig = false;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return ledig;
    }

    public int[] antalBookningerPrTime() {
        // these two lines are equivalent
        int timer = (int) førsteTid.until(sidsteTid, ChronoUnit.HOURS);
        //get amount of hours open
        int[] åbneTimer = new int[timer + 1];
        //make arry
        int sidsteTime = sidsteTid.getHour();
        int arrayIndex = 0;
        for(int i = førsteTid.getHour(); i <= sidsteTime; i++){
            //now we dance
            for(Booking booking : bookinger){
                if (booking.getTid().getHour() == i){
                    åbneTimer[arrayIndex]++;
                }
            }
            arrayIndex++;
        }
        return åbneTimer;
    }
    public String indeEllerUde(){
        if (inde) {
            return "inde";
        } else {
            return "ude";
        }
    }

    @Override
    public String toString() {
        return "Nr." + nummer + " " + indeEllerUde() + " (" + førsteTid.toString() + " -> " + sidsteTid.toString() + ")," + kategori.getNavn();
    }

    public void addBooking(Booking booking){
        this.bookinger.add(booking);
    }

    public int getNummer() {
        return nummer;
    }

    public boolean isInde() {
        return inde;
    }

    public LocalTime getFørsteTid() {
        return førsteTid;
    }

    public LocalTime getSidsteTid() {
        return sidsteTid;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public ArrayList<Booking> getBookinger() {
        return bookinger;
    }
}
