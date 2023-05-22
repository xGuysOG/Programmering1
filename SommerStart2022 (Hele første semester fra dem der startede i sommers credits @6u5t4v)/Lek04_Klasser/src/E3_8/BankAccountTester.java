package E3_8;

public class BankAccountTester {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        account.addInterest(10);

        System.out.println("Expected 1100");
        System.out.println(account.getBalance());
    }
}
