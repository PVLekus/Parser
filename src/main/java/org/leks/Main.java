package org.leks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.leks.impl.CargoFill;
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
        filter.setToGeo("Пермь");
        filter.setFromGeoRadius("250");
        filter.setToGeoRadius("10");

        //System.out.println(SearchCargo.getUrl(filter));

        //String page = SearchCargo.getResultSearch(filter);

        String auth = SearchCargo.getAuthPage("valdimirp", "VikaVera0804");
        System.out.println(auth);


        //testing JSOUP

        /*Elements cargos = new Elements();
        cargos = SearchCargo.getListOfCargoElements(page);
        System.out.println(cargos.size());

        for (int i = 0; i < cargos.size(); i++) {
            int num = i % 10;
            String attr = "ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_lblLoadNo";

            Element el = cargos.get(i).getElementById(attr);
            //System.out.print(el.text() + " ");
            System.out.print(CargoFill.getWay(cargos.get(i), num) + " ");
            System.out.print(CargoFill.getAllWay(cargos.get(i), num));
            System.out.print(" " + CargoFill.getLblFrom(cargos.get(i), num));
            System.out.print(" " + CargoFill.getLblFromRegion(cargos.get(i), num));
            System.out.print(" " + CargoFill.getLblFromDistance(cargos.get(i), num));
            System.out.print(" " + CargoFill.getLblTo(cargos.get(i), num));
            System.out.print(" " + CargoFill.getLblToRegion(cargos.get(i), num));
            System.out.print(" " + CargoFill.getLblToDistance(cargos.get(i), num));
            //System.out.print(" " + CargoFill.getAdvDate(cargos.get(i), num));
            //System.out.print(" " + CargoFill.getAdvChangeDate(cargos.get(i), num));
            //System.out.print(" " + CargoFill.getCargoParam(cargos.get(i)));
            //System.out.print(" " + CargoFill.getCargoType(cargos.get(i)));
            //System.out.print(" " + CargoFill.getWayDate(cargos.get(i)));
            //System.out.print(" " + CargoFill.getCarType(cargos.get(i), num));
            System.out.print(" " + CargoFill.getCarLoading(cargos.get(i), num));
            System.out.print(" " + CargoFill.getLoadPrice( cargos.get(i), num));
            System.out.print(" " + CargoFill.getLoadPriceWithNds (cargos.get(i), num));
            System.out.print(" " + CargoFill.getLoadPriceWithoutNds (cargos.get(i), num));
            System.out.print(" " + CargoFill.getLblPrePay (cargos.get(i), num));
            System.out.print(" " + CargoFill.getLblPayDays (cargos.get(i), num));
            System.out.print(" " + CargoFill.getLblDirectDog (cargos.get(i), num));

            System.out.println("");
        }*/








        /*Document document = Jsoup.parse(page);
        Elements elements = document.getElementsByClass("search-result");
        System.out.println(elements.size());
        for (Element el:
                elements) {
            Elements elements2 = el.getElementsByTag("div");
            System.out.println(elements2.get(0).attr("id"));
        }*/

    }
}
