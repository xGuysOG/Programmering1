package opg5.model;

public class Electronics extends Product {

    private int energiEfficiency;
    private static final int TAX = 30;


    public Electronics(String name, int price, String description, int energiEfficiency) {
        super(name, price, description);
        this.energiEfficiency = energiEfficiency;
    }

    @Override
    public double calcPrice() {
        double price = getPrice();

        if (price >= 3) {
            price *= 1 + (TAX / 100d);
        }


        return price;
    }

    public int getEnergiEfficiency() {
        return energiEfficiency;
    }
}
