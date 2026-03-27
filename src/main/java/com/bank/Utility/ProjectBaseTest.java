package com.bank.Utility;
import com.bank.Utility.MessageProperties;
import com.bank.Utility.GlobalProperties;
import com.bank.Utility.GlobalPropertyNames;
import com.bank.Utility.BaseTest;

public class ProjectBaseTest {
    protected static String SALT;
    protected static String LANGUAGE;
    protected static String envURL;

    static {
        SALT=GlobalProperties.getProperty("salt");
        LANGUAGE = GlobalProperties.getProperty("language");
        MessageProperties.load("messages/common", LANGUAGE);
        envURL = GlobalProperties.getProperty("envURL");
        System.out.println("Test Env: " + GlobalProperties.getProperty(GlobalPropertyNames.ENV, ""));
    }
}
