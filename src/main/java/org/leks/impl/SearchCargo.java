package org.leks.impl;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by lekus on 23.03.16.
 */
public  class SearchCargo  {


    public static String getResultSearch(CargoFilterImpl filter) throws IOException {

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


        URL url = new URL("http://m.ati.su/Tables/Default.aspx?EntityType=Load");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "windows-1251"));
        String line;
        String page="";
        while (rd.ready()) {
            page+=rd.readLine();
            page+="\n";
        }

        wr.close();
        rd.close();


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

}
