package com.bank.Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class GlobalProperties {
    private static Properties configProp;
    private static Properties exeValuesProp;

    public static void loadProp() {
        try {
            FileInputStream configFis = new FileInputStream(("src/test/resources/Config.properties"));
            configProp = new Properties();
            configProp.load(configFis);

            FileInputStream expValuesFis = new FileInputStream(("src/test/resources/ExpValues.properties"));
            exeValuesProp = new Properties();
            exeValuesProp.load(expValuesFis);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties ", e);
        }
    }

    public static String getConfig(String key) {
        if (configProp == null) {
            loadProp();
        }
        return configProp.getProperty(key);
    }

    public static String getExpvalues(String key) {
        if (exeValuesProp == null) {
            loadProp();
        }
        return exeValuesProp.getProperty(key);
    }

}
