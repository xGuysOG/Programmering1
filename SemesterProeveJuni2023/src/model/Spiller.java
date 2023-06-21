package model;

import java.util.ArrayList;

public class Spiller {
    private String navn;
    private String uddannelse;
    private ArrayList<Booking> bookinger;

    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
        this.bookinger = new ArrayList<>();
    }

    public int samletPris(Kategori kategori) {
        int total = 0;
        for(Booking booking : bookinger){
            if (booking.getBane().getKategori() == kategori){
                if (booking.isSingle()) {
                    total += booking.getBane().getKategori().getPrisKrSingle();
                } else {
                    total += booking.getBane().getKategori().getPrisKrDouble();
                }
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return navn + "(" + uddannelse + ")";
    }

    public void addBooking(Booking booking){
        this.bookinger.add(booking);
    }
    public String getNavn() {
        return navn;
    }

    public String getUddannelse() {
        return uddannelse;
    }

    public ArrayList<Booking> getBookinger() {
        return bookinger;
    }
}
