package gui;

import controller.Controller;
import model.*;
import storage.Storage;

import javax.naming.ldap.Control;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();
        Gui.launch(Gui.class);
    }

    public static void initStorage() {
        Konference himmeloghav = Controller.createKonference("Himmel og Hav", "xyz", LocalDate.now(), LocalDate.now().plusDays(2), 1500);

        Udflugt byrundtur = Controller.createUdflugt("Byrundtur", LocalDate.now(), 125, himmeloghav);
        Udflugt egeskov = Controller.createUdflugt("Egeskov", LocalDate.now(), 75, himmeloghav);
        Udflugt trapholtMuseum = Controller.createUdflugt("Trapholt Museum", LocalDate.now(), 200, himmeloghav);


        ArrayList<Service> svaneService = new ArrayList<>();
        Service svaneWifi = Controller.createService("WIFI", 50);
        svaneService.add(svaneWifi);
        Hotel denHvideSvane = Controller.createHotel("Den Hvide Svane", "idk", 1050, 1250, svaneService);
        ArrayList<Service> phonixService = new ArrayList<>();
        Service pWifi = Controller.createService("WIFI", 75);
        Service pBad = Controller.createService("Bad", 200);
        phonixService.add(pWifi);
        phonixService.add(pBad);
        Hotel hotelPhonix = Controller.createHotel("Hotel Phønix", "idk", 700, 800, phonixService);

        ArrayList<Service> tusindService = new ArrayList<>();
        Service tMorgenmad = Controller.createService("Breakfast", 100);
        tusindService.add(pBad);
        Hotel pensionTusindfryd = Controller.createHotel("Pension Tusindfryd", "idk", 500, 600, tusindService);


        Deltager finnMadsen = Controller.createDeltager("Finn Madsen", "Søndervangen 12", "xD", LocalDate.now(), LocalDate.now().plusDays(2), "2120", himmeloghav, false, false, false);
        System.out.println(finnMadsen);
        System.out.println(finnMadsen.totalUdflugtPrice());
        System.out.println(finnMadsen.totalHotelBookingPrice());
        System.out.println(finnMadsen.totalKonferencePrice());
        System.out.println(finnMadsen.totalPrice());

        Deltager nielsPetersen = Controller.createDeltager("Niels Petersen", "Søndervangen 12", "xD", LocalDate.now(), LocalDate.now().plusDays(2), "2120", himmeloghav, false, false, false);
        HotelValg nHotelValg = Controller.createHotelValg(denHvideSvane, nielsPetersen);

        System.out.println(nielsPetersen);
        System.out.println(nielsPetersen.totalUdflugtPrice());
        System.out.println(nielsPetersen.totalHotelBookingPrice());
        System.out.println(nielsPetersen.totalKonferencePrice());
        System.out.println(nielsPetersen.totalPrice());

        Deltager ullaHansen = Controller.createDeltager("Ulla Hansen", "Søndervangen 12", "xD", LocalDate.now(), LocalDate.now().plusDays(1), "2120", himmeloghav, false, true, false);
        Ledsager ledsager = Controller.createLedsager("Hans Hansen", ullaHansen);
        ledsager.setUdflugt(byrundtur);

        System.out.println(ullaHansen);
        System.out.println(ullaHansen.totalUdflugtPrice());
        System.out.println(ullaHansen.totalHotelBookingPrice());
        System.out.println(ullaHansen.totalKonferencePrice());
        System.out.println(ullaHansen.totalPrice());

        Deltager peterSommer = Controller.createDeltager("Peter Sommer", "Søndervangen 12", "xD", LocalDate.now(), LocalDate.now().plusDays(2), "2120", himmeloghav, false, true, false);
        HotelValg pHotelValg = Controller.createHotelValg(denHvideSvane, peterSommer);

        pHotelValg.addService(svaneWifi);
        Ledsager pLedsager = Controller.createLedsager("Mie Sommer", peterSommer);
        pLedsager.setUdflugt(egeskov);
        pLedsager.setUdflugt(trapholtMuseum);

        System.out.println(peterSommer);
        System.out.println(peterSommer.totalUdflugtPrice());
        System.out.println(peterSommer.totalHotelBookingPrice());
        System.out.println(peterSommer.totalKonferencePrice());
        System.out.println(peterSommer.totalPrice());

        Deltager loneJensen = Controller.createDeltager("Lone Jensen", "Søndervangen 12", "xD", LocalDate.now(), LocalDate.now().plusDays(2), "2120", himmeloghav, false, true, true);
        HotelValg lHotelValg = Controller.createHotelValg(denHvideSvane, loneJensen);
        lHotelValg.addService(svaneWifi);
        Ledsager lLedsager = Controller.createLedsager("Jan Madsen", loneJensen);
        lLedsager.setUdflugt(egeskov);
        lLedsager.setUdflugt(byrundtur);

        System.out.println(loneJensen);
        System.out.println(loneJensen.totalUdflugtPrice());
        System.out.println(loneJensen.totalHotelBookingPrice());
        System.out.println(loneJensen.totalKonferencePrice());
        System.out.println(loneJensen.totalPrice());
    }
}