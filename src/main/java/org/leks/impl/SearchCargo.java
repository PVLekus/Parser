package org.leks.impl;

import com.sun.org.apache.regexp.internal.RE;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lekus on 23.03.16.
 */
public  class SearchCargo  {

    public static void twoFactor (Connection.Response response) throws IOException {

        String cookies = response.cookies().toString();
        cookies = cookies.substring(1, cookies.length() - 1);
        String[] str = cookies.split(", ");
        String cookie = "";
        for (int i = 0; i < str.length; i++) {

            cookie += str[i] + "; ";

        }

        System.out.println(cookie);

        URL url = new URL("http://ati.su/WebServices/Firms/FirmService.asmx/SendAuthCodeSms");

        URLConnection connection;
        String data = "{\"serializedPhoneDescriptor\":\"1;-1;1\"}";
        System.out.println(data);

        connection = url.openConnection();
        connection.setRequestProperty("Cookie", cookie);
        connection.setRequestProperty("Content-Type", "application/json; charset=windows-1251");

        connection.setDoOutput(true);
        connection.setDoInput(true);
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(data);
        wr.flush();

        BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "windows-1251"));
        String line = "";
        while (rd.ready()) {

            line += rd.readLine() + "\n";
        }
        wr.close();
        rd.close();

        System.out.println(line);


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String code = reader.readLine();


        SearchCargo.validateCode(cookie, code);


    }

    public static boolean validateCode (String cookies, String code) throws IOException {

        boolean isValidate = false;

        URL url = new URL("http://ati.su/WebServices/Firms/FirmService.asmx/ValidateTwoFactorAuthCode");

        URLConnection connection;
        String data = "{\"code\":\"" + code + "\"}";
        System.out.println(data);

        connection = url.openConnection();
        connection.setRequestProperty("Cookie", cookies);
        connection.setRequestProperty("Content-Type", "application/json; charset=windows-1251");

        connection.setDoOutput(true);
        connection.setDoInput(true);
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(data);
        wr.flush();

        BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "windows-1251"));
        String line = "";
        while (rd.ready()) {

            line += rd.readLine() + "\n";
        }
        wr.close();
        rd.close();

        isValidate = true;

        return isValidate;


    }

    public static Map<String, String> getCookie (String login, String pass) throws IOException {

        Connection conn = Jsoup.connect("http://m.ati.su/Login/Login.aspx");
        conn.data("ctl00_tksm_HiddenField", ";;AjaxControlToolkit, Version=3.5.40412.0, Culture=neutral, PublicKeyToken=28f01b0e84b6d53e:ru-RU:1547e793-5b7e-48fe-8490-03a375b13a33:e4031945");
        conn.data("__EVENTTARGET", "");
        conn.data("__EVENTARGUMENT", "");
        conn.data("__VIEWSTATE", "/wEPDwULLTE2NDQ5MTQxNDQPZBYCZg9kFgQCAQ8WAh4HVmlzaWJsZWhkAgIPZBYGAgMPDxYIHghDc3NDbGFzcwUFbG9naW4eCkxvZ291dFRleHQFCtCS0YvQudGC0LgeCUxvZ2luVGV4dAUK0JLQvtC50YLQuB4EXyFTQgICZGQCBQ8PFgIfAGhkZAIJD2QWAgIBD2QWAmYPZBYKAgEPDxYCHgxFcnJvck1lc3NhZ2UFO9Cf0L7Qu9C1INC+0LHRj9C30LDRgtC10LvRjNC90L4g0LTQu9GPINC30LDQv9C+0LvQvdC10L3QuNGPZGQCAw8PFgIfBQU70J/QvtC70LUg0L7QsdGP0LfQsNGC0LXQu9GM0L3QviDQtNC70Y8g0LfQsNC/0L7Qu9C90LXQvdC40Y9kZAIED2QWAmYPZBYGZg8VAU7QktCy0LXQtNC40YLQtSDRgdC40LzQstC+0LvRiywg0LjQt9C+0LHRgNCw0LbQtdC90L3Ri9C1INC90LAg0LrQsNGA0YLQuNC90LrQtTpkAgEPZBYCZg9kFgYCBw9kFgICAQ8WAh4FdGl0bGUFI9CU0YDRg9Cz0L7QtSDQuNC30L7QsdGA0LDQttC10L3QuNC1ZAILDxYCHgV2YWx1ZQUDMjQwZAINDxYCHwdkZAIDDw8WAh4EVGV4dAUs0J3QtdCy0LXRgNC90L4g0LLQstC10LTQtdC90Ysg0YHQuNC80LLQvtC70YtkZAIGDw8WAh8IBSDQkNCy0YLQvtGA0LjQt9C40YDQvtCy0LDRgtGM0YHRj2RkAgcPEA8WAh8IBRvQt9Cw0L/QvtC80L3QuNGC0Ywg0LzQtdC90Y9kZGRkGAEFHl9fQ29udHJvbHNSZXF1aXJlUG9zdEJhY2tLZXlfXxYDBRpjdGwwMCRjdGxMb2dpblN0YXR1cyRjdGwwMQUaY3RsMDAkY3RsTG9naW5TdGF0dXMkY3RsMDMFIWN0bDAwJGNwaE1haW4kY3RsTG9naW4kUmVtZW1iZXJNZQ==");
        conn.data("ctl00$cphMain$ctlLogin$UserName", login);
        conn.data("ctl00$cphMain$ctlLogin$Password", pass);
        conn.data("ctl00$cphMain$ctlLogin$btnLogin", "Авторизироваться");
        conn.data("ctl00$cphMain$ctlLogin$RememberMe", "on");
        conn.method(Connection.Method.POST);
        conn.referrer("http://m.ati.su/Login/Login.aspx");

        Connection.Response resp = conn.execute();

        Document document = resp.parse();

        Elements elements = document.getElementsByClass("smtitlecon");
        System.out.println(elements.size());

        if (elements.size() != 0) {

            System.out.println(elements.get(0).text());
            SearchCargo.twoFactor(resp);

        }

        return resp.cookies();

    }

    public static String getResultSearch(CargoFilterImpl filter, Map<String, String> cookies) throws IOException {

        String page = "";
        String url;
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        //Создание POST запроса на поиск
        map.put(URLEncoder.encode("ctl00_tksm_HiddenField", "windows-1251"),
                URLEncoder.encode(filter.getHiddenField(), "windows-1251"));
        map.put(URLEncoder.encode("__EVENTTARGET", "windows-1251"),
                URLEncoder.encode(filter.getEventTarget(), "windows-1251"));
        map.put(URLEncoder.encode("__EVENTARGUMENT", "windows-1251"),
                URLEncoder.encode(filter.getEventArgument(), "windows-1251"));
        map.put(URLEncoder.encode("__VIEWSTATE", "windows-1251"),
                URLEncoder.encode("", "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtFromGeo$txtAutoComplete", "windows-1251"),
                URLEncoder.encode(filter.getFromGeo(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtFromGeo$hdnSelectedValue", "windows-1251"),
                URLEncoder.encode("0", "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$txtFromGeoRadius", "windows-1251"),
                URLEncoder.encode(filter.getFromGeoRadius(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtToGeo$txtAutoComplete", "windows-1251"),
                URLEncoder.encode(filter.getToGeo(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtToGeo$hdnSelectedValue", "windows-1251"),
                URLEncoder.encode("0", "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$txtToGeoRadius", "windows-1251"),
                URLEncoder.encode(filter.getToGeoRadius(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$txtWeightFrom", "windows-1251"),
                URLEncoder.encode(filter.getWeightFrom(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$txtWeightTo", "windows-1251"),
                URLEncoder.encode(filter.getWeightTo(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$txtVolumeFrom", "windows-1251"),
                URLEncoder.encode(filter.getVolumeFrom(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$txtVolumeTo", "windows-1251"),
                URLEncoder.encode(filter.getVolumeTo(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$mselCarTypes$hdnSelItems", "windows-1251"),
                URLEncoder.encode(filter.getCarTypes(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$mselLoadTypes$hdnSelItems", "windows-1251"),
                URLEncoder.encode(filter.getLoadTypes(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$txtFirstDate", "windows-1251"),
                URLEncoder.encode(filter.getFirstDateDay(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlFirstDate", "windows-1251"),
                URLEncoder.encode(filter.getFirstDateMonth(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$txtLastDate", "windows-1251"),
                URLEncoder.encode(filter.getLastDateDay(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlLastDate", "windows-1251"),
                URLEncoder.encode(filter.getLastDateMonth(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlSortingType", "windows-1251"),
                URLEncoder.encode(filter.getSortingTypes(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlChangeDates", "windows-1251"),
                URLEncoder.encode(filter.getChangeDate(), "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlItemsCount", "windows-1251"),
                URLEncoder.encode("10", "windows-1251"));
        map.put(URLEncoder.encode("ctl00$cphMain$ctlSearch$btnFind", "windows-1251"),
                URLEncoder.encode("Найти груз", "windows-1251"));

        url = SearchCargo.getUrl(filter);

        page = SearchCargo.sendPost(url, cookies, map);

        return page;

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

    public static String sendPost (String url, Map<String, String> cookies, LinkedHashMap<String, String> map) throws IOException {

        Document document = Jsoup.connect(url)
                .data(map)
                .method(Connection.Method.POST)
                .cookies(cookies)
                .post();

        return document.toString();

    }

    public static Elements getListElements(Elements list, String page){

        Document document = Jsoup.parse(page);
        Elements elements = document.getElementsByClass("search-result");
        list.addAll(elements);
        return list;

    }

    public static String getNextPage (String state, Map<String, String> cookies, String url) throws IOException {

        String nextPage;
        Connection nextConn = Jsoup.connect(url);
        nextConn.data("ctl00_tksm_HiddenField", ";;AjaxControlToolkit, Version=3.5.40412.0, Culture=neutral, PublicKeyToken=28f01b0e84b6d53e:ru-RU:1547e793-5b7e-48fe-8490-03a375b13a33:e4031945:475a4ef5:effe2a26:3ac3e789");
        nextConn.data("__EVENTTARGET", "ctl00$cphMain$lbtNextPage");
        nextConn.data("__EVENTARGUMENT", "");
        nextConn.data("__VIEWSTATE", state);
        nextConn.data("ctl00$cphMain$ctlChangeCookieParams$ddlSortingType", "2");
        nextConn.data("ctl00$cphMain$ctlChangeCookieParams$ddlChangeDates", "0");
        nextConn.data("ctl00$cphMain$ctlChangeCookieParams$ddlItemsCount", "10");
        nextConn.method(Connection.Method.POST);
        nextConn.cookies(cookies);
        Connection.Response nextResp = nextConn.execute();
        Document nextDoc = nextResp.parse();

        nextPage = nextDoc.toString();

        return nextPage;
    }

    public static Elements getListOfCargoElements(String page, Map<String, String> cookies, CargoFilterImpl filter) throws IOException {

        Elements list = new Elements();
        String url;
        String nextPage;
        String state;
        Document doc = Jsoup.parse(page);

        state = SearchCargo.getState(doc);
        url = SearchCargo.getUrl(filter);
        System.out.println(url);
        int pageCount = SearchCargo.getPageCount(doc);

        //add cargo elements from first page
        list = SearchCargo.getListElements(list, page);

        for (int i = 1; i < pageCount; i++) {
            //method to all next page
            nextPage = SearchCargo.getNextPage(state, cookies, url);
            Document nextDoc = Jsoup.parse(nextPage);
            state = SearchCargo.getState(nextDoc);
            list = getListElements(list, nextPage);
        }

        return list;

    }

    public static String getUrl (CargoFilterImpl filter) throws UnsupportedEncodingException {

        String url = "http://m.ati.su/Tables/Default.aspx?EntityType=Load";

        if (filter.getWeightFrom() != "") url += "&Weight=" + filter.getWeightFrom();

        if (filter.getWeightTo() != "") url += "$Weight2=" + filter.getWeightTo();

        if (filter.getVolumeFrom() != "") url += "&Volume" + filter.getVolumeFrom();

        if (filter.getWeightTo() != "") url += "&Volume2" + filter.getWeightTo();

        if (filter.getRate() == true) url += "&Rate=true";

        if (filter.getChangeDate() != "") url += "&ChangeDate=" + filter.getChangeDate();

        if (filter.getLoadTypes() != "") url += "&LoadType=" + filter.getLoadTypes();

        if (filter.getCarTypes() != "") url += "&CarType=" + filter.getCarTypes();

        //do fo date

        if (filter.getFromGeo() != "") url += "&FromGeo=" + URLEncoder.encode(filter.getFromGeo(), "windows-1251");

        if (filter.getToGeo() != "") url += "&ToGeo=" + URLEncoder.encode(filter.getToGeo(), "windows-1251");

        if (filter.getFromGeoRadius() != "") url += "&FromGeoRadius=" + filter.getFromGeoRadius();

        if (filter.getToGeoRadius() != "") url += "&ToGeoRadius=" + filter.getToGeoRadius();

        url += "&SortingType=" + filter.getSortingTypes();

        System.out.println(url);

        return url;

    }

}
