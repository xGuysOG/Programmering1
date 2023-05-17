package opg1;

public class BankAccountApp {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount(1000);
        BankAccount ba2 = new BankAccount(1000);
        BankAccount ba3 = new BankAccount(1000);

        ba1.deposit(10);
        System.out.println("Deposit 10 into BankAccount1: " + ba1.getBalance());

        ba2.withdraw(50);
        System.out.println("Withdraw 50 from BankAccount2: " + ba2.getBalance());

        System.out.println("Id of BankAccount1: " + ba1.getId());
        System.out.println("Id of BankAccount2: " + ba2.getId());
        System.out.println("Id of BankAccount2: " + ba3.getId());
        System.out.println("Last accessed id: " + BankAccount.getLastAccessedAccount());
    }
}
