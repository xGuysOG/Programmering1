package storage;

import model.Hotel;
import model.HotelValg;
import model.Konference;
import model.Udflugt;

import java.util.ArrayList;

public abstract class Storage {
    private static ArrayList<Konference> konferencer = new ArrayList<Konference>();
    private static ArrayList<Hotel> hoteller = new ArrayList<Hotel>();
    private static ArrayList<Udflugt> udflugter = new ArrayList<Udflugt>();

    public static void storeKonference(Konference konference) {
        konferencer.add(konference);
    }
    public static void storeHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    public static void storeUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public static ArrayList<Hotel> getHotels(){
        return hoteller;
    }

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }
}
