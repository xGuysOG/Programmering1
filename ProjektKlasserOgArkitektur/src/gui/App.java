package gui;

import controller.Controller;
import javafx.application.Application;
import model.Order;
import model.Seat;
import model.SeatType;
import model.Show;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();
        testPrint();
        testExercise7();
      MainWindow.launch(MainWindow.class);
    }

    private static void testPrint(){
        System.out.println("PRINTING ALL SEATS");
        ArrayList<Seat> seats = Storage.getSeats();
        System.out.println(seats.size());
        for(int i = 1 ; i <= seats.size() ; i++){
            System.out.print(seats.get(i-1) + " ");
            if(i%20==0){
                System.out.println();
            }
        }


    }

    private static void testExercise7(){
        Show show = Storage.getShows().get(1);
        ArrayList<Seat> seats = new ArrayList<>();
        seats.add(Storage.getSeats().get(0));
        seats.add(Storage.getSeats().get(1));
        Controller.createOrderWithSeats(show, Storage.getCustomers().get(0), LocalDate.of(2023, 9, 5), seats);
        System.out.println("Testing totalPrice: " + show.getOrders().get(0).totalPrice());
        ArrayList<Seat> seats2 = new ArrayList<>();
        seats2.add(Storage.getSeats().get(2));
        seats2.add(Storage.getSeats().get(3));
        seats2.add(Storage.getSeats().get(4));
        Controller.createOrderWithSeats(show, Storage.getCustomers().get(0), LocalDate.of(2023, 9, 6), seats2);
        Controller.createOrderWithSeats(show, Storage.getCustomers().get(0), LocalDate.of(2023, 9, 6), seats);

        System.out.println("Testing noOfOrderedSeatsOnDay: " + show.amountOfSeatsPrDay(LocalDate.of(2023, 9, 5)));
        System.out.println("Testing noOfOrderedSeatsOnDay: " + show.amountOfSeatsPrDay(LocalDate.of(2023, 9, 6)));

        System.out.println("Testing successDate: " + show.succesDate());

        System.out.println("Testing orderedSeatsForShowOnDay: " + Storage.getCustomers().get(0).OrderedSeatsForShowPrDay(show, LocalDate.of(2023,9,6)));
    }

    private static void initStorage(){
        Controller.createShow("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 10));
        Controller.createShow("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023,9, 10));
        Controller.createShow("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));

        Controller.createCustomer("Anders Hansen", 11223344);
        Controller.createCustomer("Peter Jensen", 12345678);
        Controller.createCustomer("Niels Madsen", 12341234);

        for(int i = 1 ; i <= 15 ; i++){
            for(int j = 1 ; j <= 20 ; j++){
                if(i<6){
                    if(j>2 && j<19){
                        Controller.createSeat(i, j, 500, SeatType.STANDARD);
                    }else{Controller.createSeat(i, j, 450, SeatType.STANDARD);}
                }else{
                    if(i<11){
                        if(j>2 && j<19){
                            if(i==10 && j>7 && j<13){
                                Controller.createSeat(i, j , 450, SeatType.WHEELCHAIR);
                            }else{Controller.createSeat(i, j , 450, SeatType.STANDARD);}
                        }else{Controller.createSeat(i, j , 400, SeatType.STANDARD);}
                    }else{
                        if(i == 11 && j > 7 && j<13){
                            Controller.createSeat(i, j , 400, SeatType.LONGLEGS);
                        }else{ Controller.createSeat(i, j, 400, SeatType.STANDARD);}
                    }
                }
            }
        }
        Seat seat = Storage.getSeats().get(0);
    }
}
