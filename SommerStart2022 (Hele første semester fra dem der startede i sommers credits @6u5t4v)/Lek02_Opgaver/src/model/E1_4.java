package application.model;

public class E1_4 {
    public static void main(String[] args) {
        double balance = 1000;
        double interest = 1.05;

        for(int year = 1; year <= 3; year++){
            balance *= interest;
            System.out.println("year " + year + ": " + balance);
        }
    }
}
