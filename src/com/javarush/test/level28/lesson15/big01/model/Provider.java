package com.javarush.test.level28.lesson15.big01.model;

/**
 * Created by promoscow on 23.02.17.
 */
public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public Provider() {

    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
