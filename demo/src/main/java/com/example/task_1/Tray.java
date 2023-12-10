package com.example.task_1;

public abstract class Tray {
    private int denomination;
    private Tray next;

    public Tray(int denomination) {
        this.denomination = denomination;
    }

    public Tray setNext(Tray next) {
        this.next = next;
        return this;
    }

    public void process(int amount) {
        if (next != null) {
            next.process(amount % denomination);
        } else if (amount % denomination > 0) {
            System.err.println("Bad number entered");
            System. exit(0);
        }
        System.out.println("You sholuld take " + amount / denomination + " of denomination " + denomination);
    }
}
