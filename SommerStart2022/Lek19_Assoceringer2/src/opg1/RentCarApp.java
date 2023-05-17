package opg1;

public class RentCarApp {
    public static void main(String[] args) {
        Car c1 = new Car("ABC123", 25, 2003);
        Car c2 = new Car("AJ214", 50, 2018);
        Car c3 = new Car("KG123", 55, 2020);
        Car c4 = new Car("NKA123", 30, 2006);
        Car c5 = new Car("DJ1231", 45, 2011);

        Rental rental1 = new Rental(2, 5, "");
        Rental rental2 = new Rental(1, 2, "");

        c1.addRental(rental1);
        c1.addRental(rental2);


        System.out.println(c1.maxRentalCount());
        System.out.println(c2.maxRentalCount());
    }
}
