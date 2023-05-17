package opg2;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;

    private ArrayList<Gift> received = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sendGift(Gift gift) {
        if (!received.contains(gift)) {
            received.add(gift);
        }
    }

    public double giftTotalPrice() {
        int price = 0;

        for (Gift gift : received) {
            price += gift.getPrice();
        }

        return price;
    }

    public void receiveGift(Gift gift) {
        received.add(gift);
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + " years old)";
    }
}
