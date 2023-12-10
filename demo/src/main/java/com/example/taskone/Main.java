package com.example.taskone;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        final int RIGHTAMOUNT = 755;
        final int BADAMOUNT = 756;
        System.out.println("For " + RIGHTAMOUNT);
        atm.process(RIGHTAMOUNT);
        System.out.println("\nFor " + BADAMOUNT);
        atm.process(BADAMOUNT);
    }
}