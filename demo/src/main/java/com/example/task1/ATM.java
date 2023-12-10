package com.example.task1;

public class ATM {
    private Tray firstTray;
    private int cashQuantity;

    public ATM() {
        this.cashQuantity = Integer.MAX_VALUE;
        firstTray = new Tray500().setNext(new Tray200().setNext(
                            new Tray20().setNext(new Tray5())));
    }

    public ATM(int cashQuantity) {
        this.cashQuantity = cashQuantity;
        firstTray = new Tray500().setNext(new Tray200().setNext(new Tray5()));
    }

    public void process(int amount) {
        if (cashQuantity >= amount) {
            firstTray.process(amount);
            this.cashQuantity -= amount;
        } else {
            System.out.println("Not enough cash in ATM");
        }
    }
}