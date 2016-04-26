package org.leks;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.leks.impl.CargoFill;
import org.leks.impl.CargoFilterImpl;
import org.leks.impl.SearchCargo;

import java.io.*;
import java.util.Map;

/**
 * Created by lekus on 22.03.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Map<String , String> cookies;

        CargoFilterImpl filter = new CargoFilterImpl();
        filter.setFromGeo("2_286");
        filter.setToGeo("2_3611");
        filter.setFromGeoRadius("10");
        filter.setToGeoRadius("10");
        filter.setChangeDate(4);

        cookies = SearchCargo.getCookie("valdimirp", "VikaVera0804");


        /*String firstPage = SearchCargo.getResultSearch(filter, cookies);

        //System.out.println(firstPage);

        Elements elements = SearchCargo.getListOfCargoElements(firstPage, cookies, filter);

        System.out.println(elements.size());

        FileWriter writer = new FileWriter("/Users/mb/IntelliJIDEAProjects/atiparser/Parser/src/main/resources/1.txt", false);

        for (int i = 0; i < elements.size(); i++) {

            int num = CargoFill.getNum(elements.get(i));
            Element element = elements.get(i);

            writer.write("------------------------ #" + i);
            writer.append('\n');
            writer.write (CargoFill.getLblFrom(element, num) + " - " + CargoFill.getLblTo(element, num));
            writer.append('\n');
            writer.write (CargoFill.getCargoParam(element));
            writer.append('\n');
            writer.write (CargoFill.getCargoType(element));
            writer.append('\n');
            writer.write (CargoFill.getCargoDimensions(element));
            writer.append('\n');
            writer.write (CargoFill.getLoadPrice(element, num) + " " + CargoFill.getLoadPriceWithNds(element, num) + " " + CargoFill.getLoadPriceWithoutNds(element, num));
            writer.append('\n');


        }
        writer.flush();
        writer.close();*/

    }
}
