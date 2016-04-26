package org.leks;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by mb on 04.04.16.
 */
public class MainTest {

    public static void main(String[] args) throws IOException {

        URL url = new URL("http://m.ati.su/Services/ATIGeoService.asmx/GetGeoCompletionList");
        URLConnection conn;
        String data = "{ 'prefixText': 'Москва', 'count': '10', 'contextKey': 'All_0$Rus' }";
        conn = url.openConnection();
        conn.setRequestProperty ("Content-Type", "application/json; charset=utf-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();
        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "windows-1251"));
        String line = "";
        while (rd.ready()) {

         line += rd.readLine() + "\n";
        }
        wr.close();
        rd.close();

        System.out.println(line);

        JsonParser parser = new JsonParser();
        JsonObject object = parser.parse(line).getAsJsonObject();
        JsonArray array = object.getAsJsonArray("d");

        for (JsonElement city : array) {

            JsonObject object1 = city.getAsJsonObject();
            System.out.println(object1.get("Text") + " " + object1.get("Value"));

        }
    }

}
