package com.systemdesign.atm;

import com.systemdesign.atm.ATMStates.IdleState;

public class ATM {

    private ATMState atmState;
    private Integer balance;

    ATM(Integer balance) {
        atmState = new IdleState();
        this.balance = balance;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public ATMState getAtmState() {
        return this.atmState;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public void updateBalance(Integer newBalance) {
        this.balance = newBalance;
    }
}
