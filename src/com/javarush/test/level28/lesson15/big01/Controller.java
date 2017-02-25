package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;

/**
 * Created by promoscow on 23.02.17.
 */
public class Controller {
    private Provider providers;

    public Controller(Provider providers) throws IllegalArgumentException {
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + providers +
                '}';
    }
}
