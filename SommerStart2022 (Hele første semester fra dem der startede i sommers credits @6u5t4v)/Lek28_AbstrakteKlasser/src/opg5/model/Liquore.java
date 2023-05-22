package opg5.model;

public class Liquore extends Product {
    private int alcoholPercentage;


    public Liquore(String name, int price, String description, int alcoholPercentage) {
        super(name, price, description);
        this.alcoholPercentage = alcoholPercentage;
    }

    @Override
    public double calcPrice() {
        double price = getPrice();

        if (price > 90) {
            price *= 1 + (120 / 100d);
        } else {
            price *= 1 + (80 / 100d);
        }


        return price;
    }

    public int getAlcoholPercentage() {
        return alcoholPercentage;
    }
}
