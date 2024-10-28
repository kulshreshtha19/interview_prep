package com.systemdesign.atm.ATMStates;

import com.systemdesign.atm.ATM;
import com.systemdesign.atm.ATMState;
import com.systemdesign.atm.Card;

public class BalanceEnquiryState extends ATMState {
    @Override
    public void checkBalance(ATM atm, Card card) {
        System.out.println("Balance is " + card.getBankAccount().getBalance());
        atm.setAtmState(new IdleState());
    }

    @Override
    public void printCurrentState() {

    }
}
