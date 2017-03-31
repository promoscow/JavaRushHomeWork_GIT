package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * Created by promoscow on 30.03.17.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        try {
            String s = String.format(URL_FORMAT, searchString, 0);
            System.out.println(s);

            Document doc = Jsoup.connect(s)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("none")
                    .get();

            System.out.println(doc.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
