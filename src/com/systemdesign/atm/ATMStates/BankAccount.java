package com.systemdesign.atm.ATMStates;

public class BankAccount {

    private Integer balance;

    public BankAccount(Integer balance) {
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void updateBalance(Integer newBalance) {
        System.out.println("Balance before deduction " + this.balance + " Updated Balance " + newBalance);
        this.balance = newBalance;
    }
}
