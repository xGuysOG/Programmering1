package Opgave1;

public class main {
    public static void main(String[] args) {
        Dog dog = new Dog(1 , "Miley");
        Dog dog1 = new Dog(2 , "Miley1");
        Dog dog2 = new Dog(3 , "Miley2");
        Dog dog3 = new Dog(4 , "Miley3");

        Person person = new Person("Casper", "xD", "21284586");
        Person person1 = new Person("Casper2", "xD", "21284586");

        person.addDog(dog);
        person.addDog(dog1);

        person1.addDog(dog2);
        person1.addDog(dog3);

        System.out.println(person.getDogs());

        System.out.println("other-");
        System.out.println(person1.getDogs());

        dog.setOwner(person1);

        System.out.println(person.getDogs());

        System.out.println("other2-");
        System.out.println(person1.getDogs());
    }
}
