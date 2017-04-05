package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.Console;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by promoscow on 30.03.17.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=%s+%s&page=%d";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    private static final String REFERRER = "none";

    @Override
    public List<Vacancy> getVacancies(String searchString, String searchVacancy) {
        Console.message("Парсим HeadHunter...");
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        try {
            for (int i = 0; true; i++) {
                Document document = getDocument(searchVacancy, searchString, i);
                List<Element> list = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");

                if (list.isEmpty()) break;
                for (Element element : list) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue
                            ("data-qa", "vacancy-serp__vacancy-title").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue
                            ("data-qa", "vacancy-serp__vacancy-employer").text());
                    vacancy.setCity(element.getElementsByAttributeValue
                            ("data-qa", "vacancy-serp__vacancy-address").text());
                    if (element.getElementsByAttributeValue
                            ("data-qa", "vacancy-serp__vacancy-compensation").text() != null) {
                        vacancy.setSalary(element.getElementsByAttributeValue
                                ("data-qa", "vacancy-serp__vacancy-compensation").text());
                    } else vacancy.setSalary("");
                    vacancy.setUrl(element.getElementsByAttributeValue
                            ("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                    vacancy.setSiteName(document.title());
                    vacancies.add(vacancy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Console.message("HH успешно распарсен. Вакансий: " + vacancies.size());
        return vacancies;
    }

    protected Document getDocument(String searchVacancy, String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchVacancy, searchString, page)).userAgent(USER_AGENT).referrer(REFERRER).get();
    }
}
