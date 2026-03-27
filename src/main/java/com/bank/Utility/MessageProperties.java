package com.bank.Utility;
import com.bank.Utility.Logger;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageProperties {
    private static final Logger logger = Logger.getLogger(MessageProperties.class);
    public static ResourceBundle rb;

    public static void load(String propertyfileName) {
        load(propertyfileName, (String) null);
    }

    public static void load(String propertyfileName, String language) {
        try {
            if (language != null && language.equals("")) {
                Locale.setDefault(new Locale(language));
            }
            logger.info("Current Lacale: " + Locale.getDefault());
            rb = ResourceBundle.getBundle(propertyfileName);
        } catch (Exception var3) {
            logger.error("file load failed");
        }
    }

    public static String getProperty(String key) {
        try {
            return rb.getString(key);
        } catch (Exception var2) {
            return null;
        }
    }
}
