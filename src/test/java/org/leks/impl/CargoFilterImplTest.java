package org.leks.impl;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lekus on 23.03.16.
 */
public class CargoFilterImplTest {

    @Test
    public void testGetWeightFrom() throws Exception {

        CargoFilterImpl filter = new CargoFilterImpl();
        filter.setWeightFrom(6);
        Assert.assertEquals("6", filter.getWeightFrom());
    }
}