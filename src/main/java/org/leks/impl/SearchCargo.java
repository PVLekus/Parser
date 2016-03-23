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

        String data = URLEncoder.encode("ctl00_tksm_HiddenField", "UTF-8")
                + "=" + URLEncoder.encode(filter.getHiddenField(), "UTF-8");
        data += "&" + URLEncoder.encode("__EVENTTARGET", "UTF-8")
                + "=" + URLEncoder.encode(filter.getEventTarget(), "UTF-8");
        data += "&" + URLEncoder.encode("__EVENTARGUMENT", "UTF-8")
                + "=" + URLEncoder.encode(filter.getEventArgument(), "windows-1251");
        data += "&" + URLEncoder.encode("__VIEWSTATE", "windows-1251")
                + "=" + URLEncoder.encode(filter.getState(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtFromGeo$txtAutoComplete", "windows-1251")
                + "=" + URLEncoder.encode(filter.getFromGeo(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtFromGeo$hdnSelectedValue", "windows-1251")
                + "=" + URLEncoder.encode("0", "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtFromGeoRadius", "UTF-8")
                + "=" + URLEncoder.encode(filter.getFromGeoRadius(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtToGeo$txtAutoComplete", "windows-1251")
                + "=" + URLEncoder.encode(filter.getToGeo(), "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$atxtToGeo$hdnSelectedValue", "windows-1251")
                + "=" + URLEncoder.encode("0", "windows-1251");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtToGeoRadius", "UTF-8")
                + "=" + URLEncoder.encode(filter.getToGeoRadius(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtWeightFrom", "UTF-8")
                + "=" + URLEncoder.encode(filter.getWeightFrom(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtWeightTo", "UTF-8")
                + "=" + URLEncoder.encode(filter.getWeightTo(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtVolumeFrom", "UTF-8")
                + "=" + URLEncoder.encode(filter.getVolumeFrom(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtVolumeTo", "UTF-8")
                + "=" + URLEncoder.encode(filter.getVolumeTo(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$mselCarTypes$hdnSelItems", "UTF-8")
                + "=" + URLEncoder.encode(filter.getCarTypes(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$mselLoadTypes$hdnSelItems", "UTF-8")
                + "=" + URLEncoder.encode(filter.getLoadTypes(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtFirstDate", "UTF-8")
                + "=" + URLEncoder.encode(filter.getFirstDateDay(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlFirstDate", "UTF-8")
                + "=" + URLEncoder.encode(filter.getFirstDateMonth(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$txtLastDate", "UTF-8")
                + "=" + URLEncoder.encode(filter.getLastDateDay(), "UTF-8");
        data += "&" + URLEncoder.encode("ctl00$cphMain$ctlSearch$ddlLastDate", "UTF-8")
                + "=" + URLEncoder.encode(filter.getLastDateMonth(), "UTF-8");
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
        while ((line = rd.readLine()) != null) {
            page+=rd.readLine();
            page+="\n";
        }

        wr.close();
        rd.close();


        return page;
    }
}
