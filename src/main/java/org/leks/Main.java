package org.leks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.leks.impl.CargoFilterImpl;
import org.leks.impl.SearchCargo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lekus on 22.03.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        CargoFilterImpl filter = new CargoFilterImpl();
        filter.setFromGeo("Уфа");
        filter.setToGeo("Москва");
        filter.setFromGeoRadius("10");
        filter.setToGeoRadius("10");

        System.out.println(SearchCargo.getUrl(filter));

        String page = SearchCargo.getResultSearch(filter);

        /*FileWriter writer = new FileWriter("/home/lekus/ati/index.htm");
        writer.write(page);
        writer.close();

        String[] content = page.split("<table class=\"sr-header\">");
        System.out.println(content.length);
        System.out.println(content[1]);*/

        //testing JSOUP
        ArrayList<String> cargos = new ArrayList<>();
        cargos = SearchCargo.getListOfCargoElements(page);
        System.out.println(cargos.size());

        for (int i = 0; i < cargos.size(); i++) {

            int num = i % 10;
            String attr ="ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_lblLoadNo";

            Document doc = Jsoup.parseBodyFragment(cargos.get(i));
            Element el = doc.getElementById(attr);
            System.out.println(el.text());

        }

    }
}
