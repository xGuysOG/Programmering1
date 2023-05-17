package Opgave2;

public class E14 {
    public static void main(String[] args) {
        //Fun stuff
        int balance = 1000;
        double interest = 1.05;
        double year1 = balance * interest;
        double year2 = year1 * interest;
        double year3 = year2 * interest;
        System.out.println("E.1.4");
        System.out.println("Year 1 " + year1);
        System.out.println("Year 2 " + year2);
        System.out.println("Year 3 " + year3);
    }
}
