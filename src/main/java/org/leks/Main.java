package org.leks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.leks.impl.CargoFilterImpl;
import org.leks.impl.SearchCargo;

import java.io.File;
import java.io.IOException;

/**
 * Created by lekus on 22.03.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        CargoFilterImpl filter = new CargoFilterImpl();
        filter.setFromGeo("Уфа");
        filter.setToGeo("Москва");

        String page = SearchCargo.getResultSearch(filter);

        /*FileWriter writer = new FileWriter("/home/lekus/ati/index.htm");
        writer.write(page);
        writer.close();

        String[] content = page.split("<table class=\"sr-header\">");
        System.out.println(content.length);
        System.out.println(content[1]);*/

        //testing JSOUP
        Document doc = Jsoup.parse(new File("/home/lekus/ati/index.htm"),"UTF-8");
        System.out.println(doc.toString());

    }
}
