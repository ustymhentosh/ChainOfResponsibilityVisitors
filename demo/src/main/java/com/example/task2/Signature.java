package com.example.task2;

import java.util.function.Consumer;

public class Signature<T> extends Task<T> {
    public Consumer<T> consumer;
    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    public void apply(T arg) {
        this.freeze();
        onSignature();
        consumer.accept(arg);
    }

    public void onSignature(){
        System.err.println("Calling signature: " + this.getId());
    }
}
