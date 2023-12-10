package com.example.tasktwo;

import java.util.function.Consumer;

public class Signature<T> extends Task<T> {
    private Consumer<T> consumer;
    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    public void apply(T arg) {
        this.freeze();
        onSignature();
        consumer.accept(arg);
    }

    public void onSignature() {
        this.setHeader("Singature", this.getId());
        System.err.println("Calling signature: " + this.getId());
    }
}
