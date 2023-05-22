package Opgave3;

import java.util.Scanner;

public class EX107 {
    public static void main(String[] args) {
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM please input the account id");
        do {
            // Prompt user to enter an id
            System.out.print("Enter an id: ");
            int id = scanner.nextInt();

            if (isValidID(id, accounts)) {
                int choice;
                do {
                    // Get user choice
                    choice = printMenu(accounts[id]);
                    if (isTransaction(choice)) {
                        executeTransaction(choice, accounts[id], scanner);
                    }
                } while (choice != 4); // If 4 exit main menu
            }
            // Once you exit, the system will prompt for an id again
        } while (true);
    }

    public static void executeTransaction(
            int in, Account account, Scanner input) {
        switch (in) {
            case 1: // Viewing the current balance
                System.out.println("The balance is " + account.getBalance());
                break;
            case 2: // Withdraw money
                System.out.print("Enter an amount to withdraw: ");
                account.withdraw(input.nextDouble());
                break;
            case 3: // Deposit money
                System.out.print("Enter an amount to deposit: ");
                account.deposit(input.nextDouble());
                break;
            case 4: // Deposit money
                System.out.print("Exiting system");
        }
    }

    public static boolean isValidID(int id, Account[] a) {
        for (int i = 0; i < a.length; i++) {
            if (id == a[i].getId())
                return true;
        }
        return false;
    }

    public static boolean isTransaction(int choice) {
        return choice > 0 && choice < 4;
    }

    public static int printMenu(Account account) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to account " + account.id);
        System.out.println("Here are your options: ");
        System.out.println("- 1 - view current balance");
        System.out.println("- 2 - withdraw money from balance");
        System.out.println("- 3 - deposit money to balance");
        System.out.println("- 4 - exit main menu");

        System.out.println("Please input your response");
        return scanner.nextInt();
    }
}
