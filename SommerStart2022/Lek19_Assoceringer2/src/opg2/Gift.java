package opg2;

public class Gift {
    private String description;
    private double price;

    public Gift(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void sendGift(Person person) {
        person.receiveGift(this);
    }
}
