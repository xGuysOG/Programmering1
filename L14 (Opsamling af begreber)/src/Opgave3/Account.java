package Opgave3;

import java.util.Date;
//UML


// https://prnt.sc/7Cpn2bxPJ3W5

public class Account {
    int id;
    double balance;
    double annualInterestRate;
    Date dateCrated;

    public Account(){
        dateCrated = new Date();
        id = 0;
        balance = 0;
        annualInterestRate = 0;
    }

    public Account(int id, double balance) {
        dateCrated = new Date();
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public void withdraw(double toWithdraw) {
        this.balance -= toWithdraw;
    }

    public void deposit(double toAdd) {
        this.balance += toAdd;
    }

    public double getMonthlyInterest() {
        return balance * (getMonthlyInterestRate() / 100);
    }

    public Date getDateCrated() {
        return dateCrated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}
