package de.kacperbak;

import de.kacperbak.domain.PhoneItems;

import java.io.File;

/**
 * Created by bakka on 14.01.16.
 */
public class XmlPhoneListApp {



    public static void main(String[] args) {
        CliUtils.welcome();
        PhoneItems items = CliUtils.testData();
        CliUtils.marshalToFile(items);
    }
}
