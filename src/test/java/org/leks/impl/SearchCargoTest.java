package org.leks.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.net.URI;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created by mb on 28.03.16.
 */
public class SearchCargoTest {

    static Document document;

    @BeforeClass
    public static void arseHtml() throws IOException {

        String page = "";
        URL url = ClassLoader.getSystemResource("ati.html");
        BufferedReader reader = new BufferedReader(new FileReader(url.getPath()));
        while (reader.ready()) {
            page += reader.readLine();
            page += "\n";
        }
        reader.close();
        document = Jsoup.parse(page);

    }

    @Test
    public void testGetPageCount () {

        int pageCount = SearchCargo.getPageCount(document);
        assertEquals(29, pageCount);

    }

    @Test
    public void testGetState() {

        String state = SearchCargo.getState(document);
        assertEquals("12345", state);

    }

    @Test
    public void testGetSearchUrl() {

        String url = SearchCargo.getSearchUrl(document);
        assertEquals("http://m.ati.su/Tables/Default.aspx?EntityType=Load", url);

    }


}