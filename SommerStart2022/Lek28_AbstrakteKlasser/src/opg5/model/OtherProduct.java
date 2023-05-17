package opg5.model;

public class OtherProduct extends Product {
    private static final int TAX = 25;

    public OtherProduct(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public double calcPrice() {
        return getPrice() * (1 + (TAX / 100d));
    }
}
