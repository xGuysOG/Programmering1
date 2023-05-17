package opg3.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Models a Customer with Orders.
 */
public class Customer {
    private String name;
    private LocalDate birthday;
    private List<Order> orders = new ArrayList<Order>();

    private Discount discount;

    /**
     * Create a new Customer.
     *
     * @param name     the name.
     * @param birthday birthday of the customer.
     */
    public Customer(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.discount = null;
    }

    public double totalBuy() {
        double sum = 0;
        for (Order o : orders) {
            sum += o.getOrderPrice();
        }

        return sum;
    }

    public double totalBuyWithDiscount() {
        double totalPrice = totalBuy();
        return totalPrice - discount.getDiscount(totalPrice);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public List<Order> getOrders() {
        return new ArrayList<Order>(orders);
    }

    public void addOrder(Order order) {
        if (!orders.contains(order)) {
            orders.add(order);
        }
    }

    public void removeOrder(Order order) {
        if (orders.contains(order)) {
            orders.remove(order);
        }
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
