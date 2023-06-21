package controller;

import javafx.scene.layout.BackgroundSize;
import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {
    //create all them objects here

    /**
     * Returnere en ny Kategori
     */
    public static Kategori createKategori(String navn, int prisKrSingle, int prisKrDouble){
        Kategori kategori = new Kategori(navn, prisKrSingle, prisKrDouble);
        Storage.storeKategori(kategori);
        return kategori;
    }

    /**
     * Returnere en ny Bane
     * Pre: førsteTid, sidstetid og kategori må ikke være null,
     */
    public static Bane createBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori){
        Bane bane = new Bane(nummer, inde, førsteTid, sidsteTid, kategori);
        Storage.storeBane(bane);
        return bane;
    }

    /**
     * Returnere en ny spiller
     */
    public static Spiller createSpiller(String navn, String uddannelse){
        Spiller spiller = new Spiller(navn, uddannelse);
        Storage.storeSpiller(spiller);
        return spiller;
    }

    /**
     * Returnere en ny booking
     * Pre: Booking skal være ledig
     * Pre: Spiller, Bane, tid og dato må ikke være null
     */
    public static Booking createBooking(LocalDate dato, LocalTime tid, boolean single, Bane bane, Spiller spiller){
        Booking booking = new Booking(dato, tid, single, bane, spiller);
        spiller.addBooking(booking);
        bane.addBooking(booking);
        return booking;
    }
    
    /**
     * Returnere den samlede tid for bookinger til double spil foretaget af spillere på den givne uddannelse på baner af den givne kategori.
     * Pre: Kategori må ikke være null
     */
    public static int samletBooketDoubleTid(String uddannelse, Kategori kategori){
        //TID? antager der menes antaltider?, og hvis det er tid så det vel bare 1 booking = 1 time så igen bare 1.
        int antalTid = 0;
        for(Spiller spiller : Storage.getSpillere()) {
            for(Booking booking : spiller.getBookinger()) {
                //Fun stuff
                if (booking.getBane().getKategori().equals(kategori) && spiller.getUddannelse().equals(uddannelse)){
                    if (!booking.isSingle()){
                        antalTid++;
                    }
                }
            }
        }
        return antalTid;
    }

    /**
     * Returnere en ledig bane efter dato, tid og kategori hvis der findes en, ellers returnere null
     * Pre: dato, tid og Kategori må ikke være null
     */
    public static Bane findLedigbane(LocalDate dato, LocalTime tid, Kategori kategori){
        Bane bane = null;
        boolean found = false;
        int i = 0;
        ArrayList<Bane> banerFraStorage = Storage.getBaner();
        while(!found && i < banerFraStorage.size()){
            bane = banerFraStorage.get(i);
            if (bane.getKategori().equals(kategori) && bane.tidLedig(dato, tid)) {
                found = true;
            } else {
                bane = null;
                i++;
            }
        }
        return bane;
    }

    /**
     * Printer alle bookinger ind i tekst fil
     * Note. RuntimeException vil blive kaldt ved en FileNotFoundException.
     */
    public static void printAlleBookinger(String filnavn){
        try (PrintWriter out = new PrintWriter(filnavn)) {
            for(Bane bane : Storage.getBaner()){
                for(Booking booking : bane.getBookinger()){
                    out.println("Bane nr: " + bane.getNummer() + ", dag: " + booking.getDato() + " kl. " + booking.getTid() + ", spil: " + booking.singleEllerDouble() + ", spiller: " + booking.getSpiller().getNavn());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




}
