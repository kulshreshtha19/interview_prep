package com.systemdesign.atm;

import com.systemdesign.atm.ATMStates.BankAccount;

public class ATMRoom {

    Card card;
    ATM atm;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.getAtmState().printCurrentState();
        atmRoom.atm.getAtmState().insertCard(atmRoom.atm);
        atmRoom.atm.getAtmState().authenticatePin(atmRoom.atm, atmRoom.card, 1011);
        atmRoom.atm.getAtmState().selectOperation(atmRoom.atm, TransactionType.CASHWITHDRAWL);
        atmRoom.atm.getAtmState().withDrawCash(atmRoom.atm, atmRoom.card, 500);
        atmRoom.atm.getAtmState().printCurrentState();

        atmRoom.atm.getAtmState().insertCard(atmRoom.atm);
        atmRoom.atm.getAtmState().authenticatePin(atmRoom.atm, atmRoom.card, 1011);
        atmRoom.atm.getAtmState().selectOperation(atmRoom.atm, TransactionType.BALANCEENQUIRY);
        atmRoom.atm.getAtmState().checkBalance(atmRoom.atm, atmRoom.card);
        atmRoom.atm.getAtmState().printCurrentState();

        atmRoom.atm.getAtmState().insertCard(atmRoom.atm);
        atmRoom.atm.getAtmState().authenticatePin(atmRoom.atm, atmRoom.card, 1012);
        atmRoom.atm.getAtmState().printCurrentState();
    }

    private void initialize() {
        this.atm = new ATM(3000);
        this.card = getCard();
    }

    private Card getCard() {
        BankAccount bankAccount = new BankAccount(1000);
        return new Card(1011, bankAccount);
    }
}
