package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import com.javarush.test.level28.lesson15.big01.Console;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

/**
 * Created by promoscow on 03.04.17.
 */
public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./src/" + String.valueOf(this
            .getClass()
            .getPackage()
            .getName()
            .replace(".", "/") + "/vacancies.html");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userDataSelectEmulationMethod() {
        String city = null;
        String vacancy = null;
        try {
            Console.message("Введите город: ");
            city = reader.readLine().toLowerCase();
            Console.message("Введите вакансию: ");
            vacancy = reader.readLine().replaceAll(" ", "+").toLowerCase();
            System.out.println();
        } catch (IOException e) {
            Console.message("Input/Output exception");
        }
        controller.onCitySelect(city, vacancy);
    }

    private String getUpdatedFileContent(List<Vacancy> list) throws IOException {
        Console.message("Всего вакансий: " + list.size());
        Console.message("Компилируем HTML...");
        String result = null;
        try {
            Document document = getDocument();
            Elements clone = document.getElementsByAttributeValue("class", "vacancy template");
            Elements template = clone.clone();
            Elements elements = clone.clone();
            clone.removeAttr("style");
            clone.removeClass("template");
            elements.removeAttr("style");
            elements.removeClass("template");
            Elements sh = elements.clone();
            for (Element element : document.select("*")) if (element.attr("class").equals("vacancy")) element.remove();

            Element out = document.select("tbody").last();
            for (Vacancy vacancy : list) {
                Elements cloneVacancy = sh.clone();

                Element city = cloneVacancy.select("td").get(1);
                city.text(vacancy.getCity());

                Element companyName = cloneVacancy.select("td").get(2);
                companyName.text(vacancy.getCompanyName());

                Element salary = cloneVacancy.select("td").get(3);
                salary.text(vacancy.getSalary());

                Element title = cloneVacancy.select("a").get(0);
                title.text(vacancy.getTitle());
                title.attr("href", vacancy.getUrl());

                out.append(cloneVacancy.outerHtml());
            }
            out.append(template.outerHtml());

            result = document.html();
        } catch (Exception e) {
            e.printStackTrace();
            result = "Some exception occurred";
        }
        Console.message("HTML-файл успешно скомпилирован.");
        return result;
    }

    private void updateFile(String s) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
