package Opgave1;

import java.util.ArrayList;

public class Person {
    private String name;
    private String cpr;
    private String phone;

    private ArrayList<Dog> dogs = new ArrayList<>();


    public Person(String name, String cpr, String phone) {
        this.name = name;
        this.cpr = cpr;
        this.phone = phone;
    }

    public void addDog(Dog dog) {
        dog.setOwner(this);
        dogs.add(dog);
    }

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public void removeDog(Dog dog) {
        dogs.remove(dog);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cpr='" + cpr + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }




}
