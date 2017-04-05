package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by promoscow on 23.02.17.
 */
public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();

        Provider moiKrugProvider = new Provider(new MoikrugStrategy());
        Provider provider = new Provider(new HHStrategy());

        Model model = new Model(view, provider, moiKrugProvider);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userDataSelectEmulationMethod();
    }
}
