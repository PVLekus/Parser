package org.leks.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lekus on 23.03.16.
 */
public  class SearchCargo  {


    public static String getResultSearch(CargoFilterImpl filter) throws IOException {

        String page;


        String data = URLEncoder.encode("ctl00_tksm_HiddenField", "windows-1251")
                + "=" + URLEncoder.encode(filter.getHiddenField(), "windows-1251");
        data += "&" + URLEncoder.encode("__EVENTTARGET", "windows-1251")
                + "=" + URLEncoder.encode(filter.getEventTarget(), "windows-1251");
        data += "&" + URLEncoder.encode("__EVENTARGUMENT", "windows-1251")
                + "=" + URLEncoder.encode(filter.getEventArgument(), "windows-1251");
        data += "&" + URLEncoder.encode("__VIEWSTATE", "windows-1251")
                + "=" + URLEncoder.encode(filter.getState(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtFromGeo$txtAutoComplete", "windows-1251")
                + "=" + URLEncoder.encode(filter.getFromGeo(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtFromGeo$hdnSelectedValue", "windows-1251")
                + "=" + URLEncoder.encode("0", "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtFromGeoRadius", "windows-1251")
                + "=" + URLEncoder.encode(filter.getFromGeoRadius(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtToGeo$txtAutoComplete", "windows-1251")
                + "=" + URLEncoder.encode(filter.getToGeo(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtToGeo$hdnSelectedValue", "windows-1251")
                + "=" + URLEncoder.encode("0", "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtToGeoRadius", "windows-1251")
                + "=" + URLEncoder.encode(filter.getToGeoRadius(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtWeightFrom", "windows-1251")
                + "=" + URLEncoder.encode(filter.getWeightFrom(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtWeightTo", "windows-1251")
                + "=" + URLEncoder.encode(filter.getWeightTo(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtVolumeFrom", "windows-1251")
                + "=" + URLEncoder.encode(filter.getVolumeFrom(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtVolumeTo", "windows-1251")
                + "=" + URLEncoder.encode(filter.getVolumeTo(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$mselCarTypes$hdnSelItems", "windows-1251")
                + "=" + URLEncoder.encode(filter.getCarTypes(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$mselLoadTypes$hdnSelItems", "windows-1251")
                + "=" + URLEncoder.encode(filter.getLoadTypes(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtFirstDate", "windows-1251")
                + "=" + URLEncoder.encode(filter.getFirstDateDay(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlFirstDate", "windows-1251")
                + "=" + URLEncoder.encode(filter.getFirstDateMonth(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtLastDate", "windows-1251")
                + "=" + URLEncoder.encode(filter.getLastDateDay(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlLastDate", "windows-1251")
                + "=" + URLEncoder.encode(filter.getLastDateMonth(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlSortingType", "windows-1251")
                + "=" + URLEncoder.encode(filter.getSortingTypes(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlChangeDates", "windows-1251")
                + "=" + URLEncoder.encode(filter.getChangeDate(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$btnFind", "windows-1251")
                + "=" + URLEncoder.encode("Найти груз", "windows-1251");


        page = SearchCargo.sendPost("http://m.ati.su/Tables/Default.aspx?EntityType=Load", data);

        return page;
    }

    public static String getUrl(CargoFilterImpl filter) throws UnsupportedEncodingException {

        String data = URLEncoder.encode("ctl00_tksm_HiddenField", "windows-1251")
                + "=" + URLEncoder.encode(filter.getHiddenField(), "windows-1251");
        data += "\n" + URLEncoder.encode("__EVENTTARGET", "windows-1251")
                + "=" + URLEncoder.encode(filter.getEventTarget(), "windows-1251");
        data += "\n" + URLEncoder.encode("__EVENTARGUMENT", "windows-1251")
                + "=" + URLEncoder.encode(filter.getEventArgument(), "windows-1251");
        data += "\n" + URLEncoder.encode("__VIEWSTATE", "windows-1251")
                + "=" + URLEncoder.encode(filter.getState(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtFromGeo$txtAutoComplete", "windows-1251")
                + "=" + URLEncoder.encode(filter.getFromGeo(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtFromGeo$hdnSelectedValue", "windows-1251")
                + "=" + URLEncoder.encode("0", "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtFromGeoRadius", "windows-1251")
                + "=" + URLEncoder.encode(filter.getFromGeoRadius(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtToGeo$txtAutoComplete", "windows-1251")
                + "=" + URLEncoder.encode(filter.getToGeo(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtToGeo$hdnSelectedValue", "windows-1251")
                + "=" + URLEncoder.encode("0", "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtToGeoRadius", "windows-1251")
                + "=" + URLEncoder.encode(filter.getToGeoRadius(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtWeightFrom", "windows-1251")
                + "=" + URLEncoder.encode(filter.getWeightFrom(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtWeightTo", "windows-1251")
                + "=" + URLEncoder.encode(filter.getWeightTo(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtVolumeFrom", "windows-1251")
                + "=" + URLEncoder.encode(filter.getVolumeFrom(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtVolumeTo", "windows-1251")
                + "=" + URLEncoder.encode(filter.getVolumeTo(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$mselCarTypes$hdnSelItems", "windows-1251")
                + "=" + URLEncoder.encode(filter.getCarTypes(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$mselLoadTypes$hdnSelItems", "windows-1251")
                + "=" + URLEncoder.encode(filter.getLoadTypes(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtFirstDate", "windows-1251")
                + "=" + URLEncoder.encode(filter.getFirstDateDay(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlFirstDate", "windows-1251")
                + "=" + URLEncoder.encode(filter.getFirstDateMonth(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtLastDate", "windows-1251")
                + "=" + URLEncoder.encode(filter.getLastDateDay(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlLastDate", "windows-1251")
                + "=" + URLEncoder.encode(filter.getLastDateMonth(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlSortingType", "windows-1251")
                + "=" + URLEncoder.encode(filter.getSortingTypes(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlChangeDates", "windows-1251")
                + "=" + URLEncoder.encode(filter.getChangeDate(), "windows-1251");
        data += "\n" + URLEncoder.encode("ctl00$cphMain$ctlSearch$btnFind", "windows-1251")
                + "=" + URLEncoder.encode("Найти груз", "windows-1251");

        return data;

    }

    public static int getPageCount(Document doc){

        Element elementPages = doc.getElementById("ctl00_cphMain_lblRowsCount");
        String countStr = elementPages.text();

        String[] first = countStr.split("\\(");
        String[] second = first[1].split(" ");
        int pageCount = Integer.parseInt(second[0]);
        return pageCount;

    }

    public static String getState(Document doc){

        //get state
        Element elementState = doc.getElementById("__VIEWSTATE");
        return elementState.attr("value");


    }

    public static String getSearchUrl (Document doc) {

        String url = "http://m.ati.su/Tables/";

        //get search url for next page
        Element elementSearchUrl = doc.getElementById("aspnetForm");
        url += elementSearchUrl.attr("action");

        return url;

    }

    public  static String sendPost (String pageUrl, String data) throws IOException {

        URL url = new URL(pageUrl);
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();

        //метод для куки
        Map<String, List<String>> map = conn.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() +
                    ", Value : " + entry.getValue());
        }
        String cookie = conn.getHeaderField("Set-Cookie");
        System.out.println(cookie);


        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "windows-1251"));
        String page="";
        while (rd.ready()) {
            page+=rd.readLine();
            page+="\n";
        }

        wr.close();
        rd.close();

        return page;
    }
    //доделать
    public static String getAuthPage (String login, String pass) throws IOException {

        String page;
        String vs = "/wEPDwULLTE2NDQ5MTQxNDQPZBYCZg9kFgQCAQ8WAh4HVmlzaWJsZWhkAgIPZBYGAgMPDxYIHghDc3NDbGFzcwUFbG9naW4eCkxvZ291dFRleHQFCtCS0YvQudGC0LgeCUxvZ2luVGV4dAUK0JLQvtC50YLQuB4EXyFTQgICZGQCBQ8PFgIfAGhkZAIJD2QWAgIBD2QWAmYPZBYKAgEPDxYCHgxFcnJvck1lc3NhZ2UFO9Cf0L7Qu9C1INC+0LHRj9C30LDRgtC10LvRjNC90L4g0LTQu9GPINC30LDQv9C+0LvQvdC10L3QuNGPZGQCAw8PFgIfBQU70J/QvtC70LUg0L7QsdGP0LfQsNGC0LXQu9GM0L3QviDQtNC70Y8g0LfQsNC/0L7Qu9C90LXQvdC40Y9kZAIED2QWAmYPZBYGZg8VAU7QktCy0LXQtNC40YLQtSDRgdC40LzQstC+0LvRiywg0LjQt9C+0LHRgNCw0LbQtdC90L3Ri9C1INC90LAg0LrQsNGA0YLQuNC90LrQtTpkAgEPZBYCZg9kFgYCBw9kFgICAQ8WAh4FdGl0bGUFI9CU0YDRg9Cz0L7QtSDQuNC30L7QsdGA0LDQttC10L3QuNC1ZAILDxYCHgV2YWx1ZQUDMjQwZAINDxYCHwdkZAIDDw8WAh4EVGV4dAUs0J3QtdCy0LXRgNC90L4g0LLQstC10LTQtdC90Ysg0YHQuNC80LLQvtC70YtkZAIGDw8WAh8IBSDQkNCy0YLQvtGA0LjQt9C40YDQvtCy0LDRgtGM0YHRj2RkAgcPEA8WAh8IBRvQt9Cw0L/QvtC80L3QuNGC0Ywg0LzQtdC90Y9kZGRkGAEFHl9fQ29udHJvbHNSZXF1aXJlUG9zdEJhY2tLZXlfXxYDBRpjdGwwMCRjdGxMb2dpblN0YXR1cyRjdGwwMQUaY3RsMDAkY3RsTG9naW5TdGF0dXMkY3RsMDMFIWN0bDAwJGNwaE1haW4kY3RsTG9naW4kUmVtZW1iZXJNZQ==";
        String data = URLEncoder.encode("ctl00_tksm_HiddenField", "windows-1251")
                + "=" + URLEncoder.encode(";;AjaxControlToolkit, Version=3.5.40412.0, Culture=neutral, PublicKeyToken=28f01b0e84b6d53e:ru-RU:1547e793-5b7e-48fe-8490-03a375b13a33:e4031945", "windows-1251");
        data += "&" + URLEncoder.encode("__EVENTTARGET", "windows-1251")
                + "=" + URLEncoder.encode("", "windows-1251");
        data += "&" + URLEncoder.encode("__EVENTARGUMENT", "windows-1251")
                + "=" + URLEncoder.encode("", "windows-1251");
        data += "&" + URLEncoder.encode("__VIEWSTATE", "windows-1251")
                + "=" + URLEncoder.encode(vs, "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlLogin$UserName", "windows-1251")
            + "=" + URLEncoder.encode(login, "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlLogin$Password", "windows-1251")
            + "=" + URLEncoder.encode(pass, "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlLogin$btnLogin", "windows-1251")
            + "=" + URLEncoder.encode("Авторизоваться", "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlLogin$RememberMe", "windows-1251")
            + "=" + URLEncoder.encode("on", "windows-1251");

        page = SearchCargo.sendPost("http://m.ati.su/Login/Login.aspx?ReturnUrl=%2f", data);

        return page;



    }

    public static Elements getListElements(Elements list, String page){

        Document document = Jsoup.parse(page);
        Elements elements = document.getElementsByClass("search-result");
        list.addAll(elements);
        return list;

    }

    public static ArrayList<String> getSplitList(ArrayList<String> list, String page) {

        String[] listOfCargo = page.split("<table class=\"sr-header\">");

        for (int i = 1; i < listOfCargo.length; i++) {
            list.add(listOfCargo[i]);
        }

        return list;
    }

    public static String getNextPage(String state, String urlSearch) throws IOException {

        String page;

        String data = URLEncoder.encode("ctl00_tksm_HiddenField", "windows-1251")
                + "=" + URLEncoder.encode(";;AjaxControlToolkit, Version=3.5.40412.0, Culture=neutral, PublicKeyToken=28f01b0e84b6d53e:ru-RU:1547e793-5b7e-48fe-8490-03a375b13a33:e4031945:475a4ef5:effe2a26:3ac3e789", "windows-1251");
        data += "&" + URLEncoder.encode("__EVENTTARGET", "windows-1251")
                + "=" + URLEncoder.encode("ctl00$cphMain$lbtNextPage", "windows-1251");
        data += "&" + URLEncoder.encode("__EVENTARGUMENT", "windows-1251")
                + "=" + URLEncoder.encode("", "windows-1251");
        data += "&" + URLEncoder.encode("__VIEWSTATE", "windows-1251")
                + "=" + URLEncoder.encode(state, "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlChangeCookieParams$ddlSortingType", "windows-1251")
                + "=" + URLEncoder.encode("2", "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlChangeCookieParams$ddlChangeDates", "windows-1251")
                + "=" + URLEncoder.encode("0", "windows-1251");

        page = SearchCargo.sendPost(urlSearch, data);

        return page;
    }

    public static Elements getListOfCargoElements(String page) throws IOException {

        Elements list = new Elements();
        String state;
        String url;
        String nextPage;
        Document doc = Jsoup.parse(page);

        state = SearchCargo.getState(doc);
        url = SearchCargo.getSearchUrl(doc);
        int pageCount = SearchCargo.getPageCount(doc);

        //add cargo elements from first page
        list = SearchCargo.getListElements(list, page);

        for (int i = 1; i < pageCount; i++) {
            //method to all next page
            nextPage = SearchCargo.getNextPage(state, url);
            Document nextDoc = Jsoup.parse(nextPage);
            state = SearchCargo.getState(nextDoc);
            list = getListElements(list, nextPage);
        }

        return list;

    }

}
