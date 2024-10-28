package com.systemdesign.atm;

import com.systemdesign.atm.ATMStates.BankAccount;

public class Card {
    private int pin;
    private BankAccount bankAccount;

    public Card(int pin, BankAccount bankAccount) {
        this.pin = pin;
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public Integer getPin() {
        return this.pin;
    }


}
