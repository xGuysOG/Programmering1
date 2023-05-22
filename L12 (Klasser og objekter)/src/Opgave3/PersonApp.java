package Opgave3;

public class PersonApp {
    public static void main(String[] args) {
        Person person1 = new Person("Hans Jensen", "xD street 52");
        Person person2 = new Person("Jens Jensen");
        System.out.println("Test: " + person1);
        System.out.println("Test: " + person2);
        System.out.println();
        person1.monthlySalary = 10;
        person2.monthlySalary = 20;
        person2.addresse = "Lol street 52";
        System.out.println("Name: " + person1.name);
        System.out.println("addresse? " + person1.addresse);
        System.out.println("monthlySalary " + person1.monthlySalary);
        System.out.println("Yearly salary? " + person1.yearlySalary());
        
        System.out.println("Name: " + person2.name);
        System.out.println("addresse? " + person2.addresse);
        System.out.println("monthlySalary " + person2.monthlySalary);
        System.out.println("Yearly salary? " + person2.yearlySalary());
        person1.printPerson();
        person2.printPerson();
        
        System.out.println();
    }
}
