package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by promoscow on 23.02.17.
 */
public interface Strategy {
    public List<Vacancy> getVacancies(String searchString, String searchVacancy);
}
