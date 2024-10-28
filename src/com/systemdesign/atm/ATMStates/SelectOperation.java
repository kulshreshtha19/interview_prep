package com.systemdesign.atm.ATMStates;

import com.systemdesign.atm.ATM;
import com.systemdesign.atm.ATMState;
import com.systemdesign.atm.TransactionType;

public class SelectOperation extends ATMState {
    @Override
    public void selectOperation(ATM atm, TransactionType transactionType) {
        System.out.println("Selected operation " + transactionType.name());
        switch (transactionType) {
            case CASHWITHDRAWL -> atm.setAtmState(new CashWithDrawlState());
            case BALANCEENQUIRY -> atm.setAtmState(new BalanceEnquiryState());
        }
    }

    @Override
    public void printCurrentState() {
        System.out.println("Current State : SelectOperation");
    }
}
