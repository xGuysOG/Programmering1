package opg3;

import opg3.model.*;

import java.time.LocalDate;
import java.time.Month;

public class App {
    public static void main(String[] args) {
        Product macbook = new Product(69420, "Macbook Pro", 10000);
        Product apple = new Product(1337, "Æble", 2.5);
        Product bottle = new Product(10, "Flaske", 50);
        Product beer = new Product(420, "Tuborg Classic", 5);
        Product bag = new Product(69, "Gucci Taske", 6000);

        Customer customer = new Customer("Arne", LocalDate.of(2000, Month.APRIL, 3));
        Customer customer2 = new Customer("Frank", LocalDate.of(1989, Month.JANUARY, 15));
        Customer customer3 = new Customer("Bjarne", LocalDate.of(1969, Month.DECEMBER, 12));

        customer.setDiscount(new PercentDiscount(15));
        customer2.setDiscount(new FixedDiscount(250, 1000));
        customer3.setDiscount(new AgeDiscount(1969));

        Order order1 = new Order(10);
        order1.createOrderLine(1, macbook);
        order1.createOrderLine(2, apple);
        order1.createOrderLine(1, bag);

        Order order2 = new Order(69);
        order2.createOrderLine(1, bag);
        order2.createOrderLine(2, bottle);

        customer.addOrder(order1);
        customer.addOrder(order2);

        Order order3 = new Order(15);
        order3.createOrderLine(4, apple);
        order3.createOrderLine(24, beer);
        order3.createOrderLine(1, bag);

        Order order4 = new Order(15);
        order4.createOrderLine(1, apple);
        order4.createOrderLine(3, beer);

        Order order5 = new Order(15);
        order5.createOrderLine(3, apple);
        order5.createOrderLine(9, beer);

        Order order6 = new Order(15);
        order6.createOrderLine(5, apple);
        order6.createOrderLine(24, beer);

        customer2.addOrder(order3);
        customer2.addOrder(order4);
        customer2.addOrder(order5);
        customer2.addOrder(order6);

        customer3.addOrder(order3);
        customer3.addOrder(order4);
        customer3.addOrder(order5);
        customer3.addOrder(order6);


        System.out.println("Arne total buy: " + customer.totalBuy());
        System.out.println("Arne total buy with 15% discount: " + customer.totalBuyWithDiscount());

        System.out.println("Frank total buy: " + customer2.totalBuy());
        System.out.println("Frank total buy with discount: " + customer2.totalBuyWithDiscount());

        System.out.println("Bjarne total buy: " + customer3.totalBuy());
        System.out.println("Bjarne total buy with discount: " + customer3.totalBuyWithDiscount());

    }
}
