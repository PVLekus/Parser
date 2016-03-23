package org.leks;

import org.leks.impl.CargoFilterImpl;
import org.leks.impl.SearchCargo;

import java.io.IOException;

/**
 * Created by lekus on 22.03.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        CargoFilterImpl filter = new CargoFilterImpl();
        filter.setFromGeo("Уфа");
        filter.setToGeo("Москва");

        String page = SearchCargo.getResultSearch(filter);
        System.out.println(page);

    }
}
