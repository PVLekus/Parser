package org.leks.impl;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by mb on 29.03.16.
 */
public class CargoFill {

    public static String getId(Element element) {

        String id;

        Elements div = element.getElementsByTag("div");
        id = div.get(0).attr("id");

        return id;

    }

    public static String getAdvDate(Element element, int num) {

        String advDate;
        String [] array;
        Element date;

        date = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_ctlLoadDates_Label3");

        if (date == null) advDate = "";
        else {
            array = date.text().split("\\.:");
            advDate = array[1];
        }

        return advDate;

    }

    public static String getAdvChangeDate (Element element, int num) {

        String advChangeDate;
        String [] array;
        Element date;

        date = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_ctlLoadDates_Label2");

        if (date == null) advChangeDate = "";
        else {
            array = date.text().split("\\.:");
            advChangeDate = array[1];
        }

        return advChangeDate;

    }

    public static String getWay(Element element, int num) {

        String way;
        way = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_hlkDistance").text();

        return way;

    }

    public static String getAllWay(Element element, int num) {

        String allWay;
        Element way;

        way = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_HyperLink2");

        if ( way == null ) allWay ="";
        else allWay = way.text();

        return allWay;

    }

    public static String getLblFrom(Element element, int num) {

        String lblFrom;

        lblFrom = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_rptLoadLoading_ctl00_lblFrom").text();

        return lblFrom;

    }

    public static String getLblFromRegion(Element element, int num) {

        String lblFromRegion;
        Element region;

        region = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_rptLoadLoading_ctl00_lblFromRegion");

        if (region == null) lblFromRegion = "";
        else lblFromRegion = region.text();

        return lblFromRegion;

    }

    public static String getLblFromDistance (Element element, int num) {

        String lblDistance;
        Element distance;

        distance = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_rptLoadLoading_ctl00_lblDistance");

        if (distance == null) lblDistance ="";
        else lblDistance = distance.text();

        return lblDistance;

    }

    public static String getLblTo (Element element, int num) {

        String lblTo;

        lblTo = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_rptLoadUnloading_ctl00_divTo").text();

        return lblTo;

    }

    public static String getLblToRegion (Element element, int num) {

        String lblToRegion;
        Element region;

        region = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_rptLoadUnloading_ctl00_divToRegion");

        if (region == null) lblToRegion = "";
        else lblToRegion = region.text();

        return lblToRegion;

    }

    public static String getLblToDistance (Element element, int num) {

        String lblToDistance;
        Element distance;

        distance = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_rptLoadUnloading_ctl01_divLoadDistance");

        if (distance == null) lblToDistance = "";
        else lblToDistance = distance.text();

        return lblToDistance;

    }

    public static String getCargoParam (Element element) {

        String cargoParam;
        String[] array;
        Elements table;
        Elements options;

        options = element.getElementsByClass("sr-options");
        table = options.get(0).getElementsByTag("td");
        array = table.get(0).text().split(" ");
        cargoParam = array[0];

        return cargoParam;

    }

    public static String getCargoType (Element element) {

        String cargoType;
        Elements table;
        Elements options;

        options = element.getElementsByClass("sr-options");
        table = options.get(0).getElementsByTag("td");
        cargoType = table.get(1).text();

        return cargoType;

    }

    public static String getWayDate (Element element) {

        String wayDate;
        Elements date;

        date = element.getElementsByClass("sr-way-date");

        if (date == null) wayDate = "";
        else wayDate = date.get(0).text();

        return wayDate;

    }

    public  static String getCarType (Element element, int num) {

        String carType;
        Element type;

        type = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_lblLoadCarTypes");

        if (type == null) carType = "";
        else carType = type.text();

        return carType;

    }

    public static String getCarLoading (Element element, int num) {

        String carLoading;
        Element load;

        load = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_lblLoadingUnloading");

        if (load == null) carLoading = "";
        else carLoading = load.text();

        return carLoading;

    }

    public static String getLoadPrice (Element element, int num) {

        String loadPrice;
        Element price;

        price = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_divLoadPrice");

        if (price == null) loadPrice = "";
        else loadPrice = price.text();

        return loadPrice;

    }

    public static String getLoadPriceWithNds (Element element, int num) {

        String loadPriceWithNds;
        Element price;

        price = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_divLoadPriceWithNDS");
        if (price == null) loadPriceWithNds = "";
        else loadPriceWithNds = price.text();

        return loadPriceWithNds;

    }

    public static String getLoadPriceWithoutNds (Element element, int num) {

        String loadPriceWithoutNds;
        Element price;

        price = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_divLoadPriceWithoutNDS");

        if (price == null) loadPriceWithoutNds = "";
        else loadPriceWithoutNds = price.text();

        return loadPriceWithoutNds;

    }

    public static String getLblPrePay (Element element, int num) {

        String lblPrePay;
        Element prePay;

        prePay = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_lblPrePay");

        if (prePay == null) lblPrePay = "";
        else lblPrePay = prePay.text();

        return lblPrePay;

    }

    public static String getLblPayDays (Element element, int num) {

        String lblPayDays;
        Element payDays;

        payDays = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_lblPayDays");

        if (payDays == null) lblPayDays = "";
        else lblPayDays = payDays.text();

        return lblPayDays;

    }

    public static String getLblDirectDog (Element element, int num) {

        String lblDirectDog;
        Element directDog;

        directDog = element.getElementById("ctl00_cphMain_rptEntities_ctl0" + num + "_ctlOrderDetails_lblDirectDog");

        if (directDog == null) lblDirectDog = "";
        else lblDirectDog = directDog.text();

        return lblDirectDog;

    }


}
