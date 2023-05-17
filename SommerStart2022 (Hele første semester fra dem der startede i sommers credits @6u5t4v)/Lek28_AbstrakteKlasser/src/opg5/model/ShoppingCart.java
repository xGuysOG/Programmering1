package opg5.model;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (!products.contains(product)) {
            products.add(product);
        }
    }


    public double totalPrice() {
        double total = 0;

        for (Product p : products) {
            System.out.println(p.calcPrice());
            total += p.calcPrice();
        }

        return total;
    }
}
