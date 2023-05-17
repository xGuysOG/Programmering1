package opg5;

import opg5.model.*;

public class App {
    public static void main(String[] args) {
        Product apple = new Food("Apple", 5, "very delicious", 10);
        Product bread = new Food("Bread", 16, "dat gud", 9);
        Product orange = new Food("Orange", 3, "dat bitch juicy af", 12);
        Product macbook = new Electronics("Macbook", 10499, "very modern", 70);
        Product vacuum = new Electronics("Vacuum", 2600, "sucking good", 120);
        Product gin = new Liquore("Gin", 89, "good med tonic", 45);
        Product vodka = new Liquore("Vodka", 150, ":O", 70);
        Product rom = new Liquore("Rom", 90, "god med cola", 65);
        Product toiletpaper = new OtherProduct("Toiletpaper", 30, "god til røven");

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(apple);
        cart.addProduct(bread);
        cart.addProduct(orange);
        cart.addProduct(macbook);
        cart.addProduct(vacuum);
        cart.addProduct(gin);
        cart.addProduct(vodka);
        cart.addProduct(rom);
        cart.addProduct(toiletpaper);

        System.out.println(cart.totalPrice());
    }
}
