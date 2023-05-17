package opg2;

public class GiftApp {
    public static void main(String[] args) {
        Gift gift1 = new Gift("lol en god gave");
        gift1.setPrice(50);

        Gift gift2 = new Gift("nice gave");
        gift2.setPrice(69);

        Gift gift3 = new Gift("damn en ny blazer");
        gift3.setPrice(420);

        Person person = new Person("Bruh", 25);

        System.out.println(person);

        gift1.sendGift(person);
        gift2.sendGift(person);
        gift3.sendGift(person);

        System.out.println("gift price total: " + person.giftTotalPrice());
    }
}
