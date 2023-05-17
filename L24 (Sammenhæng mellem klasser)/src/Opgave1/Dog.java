package Opgave1;

public class Dog {

    private int number;
    private String name;

    private Person owner;

    public Dog(int number,String name) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person person) {
        if (owner != null) {
            owner.getDogs().remove(this);
        }
        this.owner = person;
        this.owner.addDog(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

}

