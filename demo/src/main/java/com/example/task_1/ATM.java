package com.example.task_1;

public class ATM {
    public Tray firstTray;
    private int cashQuantity;

    public ATM() {
        this.cashQuantity = 2147483647;
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
