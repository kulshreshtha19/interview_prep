package com.systemdesign.atm.ATMStates;

import com.systemdesign.atm.ATM;
import com.systemdesign.atm.ATMState;

public class InsertCardState extends ATMState {
    @Override
    public void insertCard(ATM atm) {
        System.out.println("Card is inserted");
        atm.setAtmState(new PinAuthenticationState());
    }

    @Override
    public void printCurrentState() {
        System.out.println("Current State : InsertCard");
    }
}
