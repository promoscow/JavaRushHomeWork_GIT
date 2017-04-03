package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by promoscow on 23.02.17.
 */
public class Controller {
    private Provider[] providers;

    public Controller(Provider... providers) throws IllegalArgumentException {
        if (providers == null || providers.length == 0) throw new IllegalArgumentException();
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        try {
            List<Vacancy> list = null;
            for (Provider provider : providers) {
                List<Vacancy> vacOfProv = provider.getJavaVacancies("Киев");
                for (Vacancy vacancy : vacOfProv) {
                    list.add(vacancy);
                }
            }
            System.out.println(list.size());
        } catch (NullPointerException e) {
//            System.out.println("0");
        }
    }
}
