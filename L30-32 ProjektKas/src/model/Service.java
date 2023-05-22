package model;

public class Service {
    private double price;
    private String name;

    public Service(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }
    @Override
    public String toString() {
        return name + " (" + price + ")";
    }
}
