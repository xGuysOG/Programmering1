package opg5.model;

public class Food extends Product {
    private int expiration;

    private static int TAX = 5;

    public Food(String name, int price, String description, int expiration) {
        super(name, price, description);
        this.expiration = expiration;
    }

    @Override
    public double calcPrice() {
        double price = getPrice();
        return price * 1+(TAX / 100d);
    }
}
