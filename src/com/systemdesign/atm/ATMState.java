package com.systemdesign.atm;

public abstract class ATMState {

    public void insertCard(ATM atm) {
        System.out.println("OOPS ATM is in incorrect state");
    }

    public void authenticatePin(ATM atm, Card card, Integer pin) {
        System.out.println("OOPS ATM is in incorrect state");
    }

    public void selectOperation(ATM atm, TransactionType transactionType) {
        System.out.println("OOPS ATM is in incorrect state");
    }

    public void withDrawCash(ATM atm, Card card, Integer drawCash) {
        System.out.println("OOPS ATM is in incorrect state");
    }

    public void checkBalance(ATM atm, Card card) {
        System.out.println("OOPS ATM is in incorrect state");
    }

    abstract public void printCurrentState();
}
