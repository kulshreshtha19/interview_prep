package com.systemdesign.atm.ATMStates;

import com.systemdesign.atm.ATM;
import com.systemdesign.atm.ATMState;
import com.systemdesign.atm.Card;

public class CashWithDrawlState extends ATMState {
    @Override
    public void withDrawCash(ATM atm, Card card, Integer drawCash) {
        Integer atmBalance = atm.getBalance();
        Integer cardBalance = card.getBankAccount().getBalance();

        if (cardBalance < drawCash) {
            System.out.println("InSufficient Balance");
            atm.setAtmState(new IdleState());
            return;
        }

        if (atmBalance < drawCash) {
            System.out.println("ATM Balance is not sufficient to fulfill the request");
            atm.setAtmState(new IdleState());
            return;
        }

        atm.updateBalance(atmBalance - drawCash);
        card.getBankAccount().updateBalance(cardBalance - drawCash);
        System.out.println("ATM withdrawal done");
        atm.setAtmState(new IdleState());
    }

    @Override
    public void printCurrentState() {

    }
}
