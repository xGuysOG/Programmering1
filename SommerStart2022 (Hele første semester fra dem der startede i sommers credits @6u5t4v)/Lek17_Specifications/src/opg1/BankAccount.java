package opg1;

public class BankAccount {
    private static int LastAccessedAccount;
    private int id;
    private double balance;

    /**
     * Models the class
     *
     * @param initialBalance the initital balance of the bankaccount
     */
    public BankAccount(double initialBalance) {
        balance = initialBalance;
        id = ++LastAccessedAccount;
    }

    /**
     * Deposit an amount into the balance
     * Requires: amount > 0
     *
     * @param amount to deposit
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraw amount from balance
     * Requires: amount <= balance
     *
     * @param amount to withdraw
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * Returns the balance of the bankaccount
     *
     * @return the balance of bankaccount
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the bankaccount's unique id
     *
     * @return id of the bankaccount
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the last accessed bank account id
     *
     * @return the last accessed bank account id
     */
    public static int getLastAccessedAccount() {
        return LastAccessedAccount;
    }
}
