package com.systemdesign.atm.ATMStates;

import com.systemdesign.atm.ATM;
import com.systemdesign.atm.ATMState;
import com.systemdesign.atm.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class PinAuthenticationState extends ATMState {
    @Override
    public void authenticatePin(ATM atm, Card card, Integer pin) {
        if (!Objects.equals(card.getPin(), pin)) {
            System.out.println("Incorrect pin, please try again");
            atm.setAtmState(new IdleState());
            return;
        }

        System.out.println("Pin is authenticated");
        atm.setAtmState(new SelectOperation());
    }

    @Override
    public void printCurrentState() {
        System.out.println("Current State : PinAuthentication");
    }
}
