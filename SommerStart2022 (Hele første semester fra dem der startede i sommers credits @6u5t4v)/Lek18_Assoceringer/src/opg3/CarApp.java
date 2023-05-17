package opg3;

public class CarApp {
    public static void main(String[] args) {
        Car c1 = new Car("ABC123", 2003);
        c1.setPricePrDay(25);
        Car c2 = new Car("AJ214", 2018);
        c2.setPricePrDay(50);
        Car c3 = new Car("KG123", 2020);
        c3.setPricePrDay(55);
        Car c4 = new Car("NKA123", 2006);
        c4.setPricePrDay(30);
        Car c5 = new Car("DJ1231", 2011);
        c5.setPricePrDay(45);

        Rental rental1 = new Rental(2, 5, "");
        Rental rental2 = new Rental(1, 2, "");

        rental1.addCar(c1);
        rental1.addCar(c2);
        rental1.addCar(c3);

        rental2.addCar(c4);
        rental2.addCar(c5);

        System.out.println("Price for rental2 " + rental1.getPrice());
        System.out.println("Price for rental1 " + rental2.getPrice());
    }
}
