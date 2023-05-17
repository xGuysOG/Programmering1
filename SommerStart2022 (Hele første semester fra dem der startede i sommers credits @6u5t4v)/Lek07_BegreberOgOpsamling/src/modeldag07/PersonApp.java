package modeldag07;

public class PersonApp {

    public static void main(String[] args) {
        Person p = new Person("Gustav", "Knutz", "Haavik", 7, 8, 2000);
        p.printPerson();
        System.out.println("Initialer: " + p.getInit());
        System.out.println("Username: " + p.getUserName());

        System.out.println("Age: " + p.age(7, 8, 2022)); // p's age today
        int year = 1969;
        System.out.println("Er " + year + " skudår: " + p.leapYear(year));
    }
}
