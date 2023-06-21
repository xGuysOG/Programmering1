package gui;

import controller.Controller;
import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        initStorage();
        Gui.launch(Gui.class);
    }

    public static void initStorage() {
        //Generate the data
        Kategori luksus = Controller.createKategori("Luksus", 100, 200);
        Kategori mellem = Controller.createKategori("Mellem", 50, 100);
        Kategori begynder = Controller.createKategori("Begynder", 25, 50);

        Bane bane1 = Controller.createBane(1, true, LocalTime.parse("09:00"),LocalTime.parse("17:00"), luksus);
        Bane bane2 = Controller.createBane(2, true, LocalTime.parse("09:00"),LocalTime.parse("17:00"), luksus);
        Bane bane3 = Controller.createBane(3, true, LocalTime.parse("09:00"),LocalTime.parse("17:00"), mellem);
        Bane bane4 = Controller.createBane(4, false, LocalTime.parse("09:00"),LocalTime.parse("17:00"), mellem);
        Bane bane5 = Controller.createBane(5, false, LocalTime.parse("09:00"),LocalTime.parse("17:00"), begynder);
        Bane bane6 = Controller.createBane(6, false, LocalTime.parse("09:00"),LocalTime.parse("17:00"), begynder);

        Spiller andreas = Controller.createSpiller("Andreas", "DMU");
        Spiller petra = Controller.createSpiller("Petra", "DMU");
        Spiller henrik = Controller.createSpiller("Henrik", "ITA");
        Spiller ulla = Controller.createSpiller("Ulla", "ITA");

        Booking booking1 = Controller.createBooking(LocalDate.parse("2023-06-20"), LocalTime.parse("10:00"),true, bane3, andreas);
        Booking booking2 = Controller.createBooking(LocalDate.parse("2023-06-22"), LocalTime.parse("10:00"),false, bane2, andreas);

        Booking booking3 = Controller.createBooking(LocalDate.parse("2023-06-20"), LocalTime.parse("11:00"),false, bane3, henrik);

        Booking booking4 = Controller.createBooking(LocalDate.parse("2023-06-23"), LocalTime.parse("16:00"),false, bane3, ulla);
        Booking booking5 = Controller.createBooking(LocalDate.parse("2023-06-23"), LocalTime.parse("17:00"),true, bane5, ulla);

        System.out.println(booking1.toString());
        System.out.println(luksus.toString());
        System.out.println(bane1.toString());
        System.out.println(ulla.toString());

        System.out.println("opgave 2 test " + bane3.bookedeTimerPåDato(LocalDate.parse("2023-06-20")));
        System.out.println("opgave 3 test " + andreas.samletPris(luksus));
        System.out.println("opgave 4 test " + Arrays.toString(bane3.antalBookningerPrTime()));
        System.out.println("opgave 7 test " + Controller.samletBooketDoubleTid("DMU", luksus));
        System.out.println("opgave 8 test1 " + bane3.tidLedig(LocalDate.parse("2023-06-20"), LocalTime.parse("10:00")));
        System.out.println("opgave 8 test2 " + bane3.tidLedig(LocalDate.parse("2023-06-20"), LocalTime.parse("15:00")));
        System.out.println("opgave 9 test " + Controller.findLedigbane(LocalDate.parse("2023-06-20"), LocalTime.parse("15:00"), luksus));
        Controller.printAlleBookinger("SemesterProeveJuni2023/src/storage/data.txt");


    }
}
