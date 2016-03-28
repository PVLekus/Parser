package org.leks.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mb on 28.03.16.
 */
public class SearchCargoTest {

    @Test
    public void getPageCount() throws Exception {

        String str = "17 res (123 str.)";
        int countPages = SearchCargo.getPageCount(str);
        assertEquals(123, countPages);

    }
}