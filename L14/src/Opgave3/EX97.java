package Opgave3;

public class EX97 {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);

        account.withdraw(2500);

        account.deposit(3000);

        System.out.println("Balane " + account.balance);
        System.out.println("Monthly interest " + account.getMonthlyInterest());
        System.out.println("Created at " + account.getDateCrated());

    }
}
