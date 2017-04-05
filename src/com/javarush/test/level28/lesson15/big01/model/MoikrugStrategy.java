package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.Console;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by promoscow on 05.04.17.
 */
public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    private static final String REFERRER = "none";

    @Override
    public List<Vacancy> getVacancies(String searchString, String searchVacancy) {
        Console.message("Парсим Мой Круг...");
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            for (int i = 0; true; i++) {

                Document document = getDocument(searchString, i);
                List<Element> list = document.getElementsByAttributeValue("class", "job  ");
                List<Element> listMarket = document.getElementsByAttributeValue("class", "job marked");

                if (list.isEmpty() && listMarket.isEmpty()) break;

                for (Element element : list) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue("class", "title").text());

                    Elements salary = element.getElementsByAttributeValue("class", "salary");
                    vacancy.setSalary(salary.text());

                    Elements city = element.getElementsByAttributeValue("class", "location");
                    vacancy.setCity(city.text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    vacancy.setSiteName(document.title());
                    Elements s = element.getElementsByAttributeValue("class", "title");
                    Elements tag = s.select("*");
                    vacancy.setUrl("https://moikrug.ru" + tag.attr("href"));
                    vacancies.add(vacancy);

                }

                for (Element element : listMarket) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue("class", "title").text());

                    Elements salary = element.getElementsByAttributeValue("class", "salary");
                    vacancy.setSalary(salary.text());

                    Elements city = element.getElementsByAttributeValue("class", "location");
                    vacancy.setCity(city.text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    vacancy.setSiteName(document.title());
                    Elements s = element.getElementsByAttributeValue("class", "title");
                    Elements tag = s.select("*");
                    vacancy.setUrl("https://moikrug.ru" + tag.attr("href"));
                    vacancies.add(vacancy);
                }

            }
        } catch (IOException e) {
        }
        Console.message("Мой Круг успешно распарсен. Вакансий: " + vacancies.size());
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, page, searchString)).userAgent(USER_AGENT).referrer(REFERRER).get();
    }
}
