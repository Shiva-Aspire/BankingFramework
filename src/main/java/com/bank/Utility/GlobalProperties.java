package com.bank.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bank.Utility.Logger;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

import static java.lang.System.getProperty;
//import com.bank.Utility.BaseLogger;

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
            e.printStackTrace();
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

    private static final Logger logger = Logger.getLogger(GlobalProperties.class);
    public static HashMap<String, String> runtimeParams = new HashMap();

    public static HashMap<String, String> getRunTimeParams() {
        return runtimeParams;
    }

    public static void setRunTimeParams(String key, String val) {
        runtimeParams.put(key, val);
    }

    private static Properties testProperties;

    public static synchronized void initProperties(String propertyFileName) {
        if (testProperties == null) {
            testProperties = new Properties();
            try {
                testProperties.load(GlobalProperties.class.getClassLoader().getResourceAsStream(propertyFileName));
            } catch (Exception var2) {
                logger.error("Fatal to load " + propertyFileName);
            }
        }
    }

    public static void loadProp1(String propertyFileName) {
        try {
            testProperties.load(GlobalProperties.class.getClassLoader().getResourceAsStream(propertyFileName));
        } catch (Exception var2) {
            logger.warn("fail to load " + propertyFileName);
        }
    }

    public static String getCapabilities() {
        return getProperty("test.capabilities", (String) null);
    }

    public static int getSeleniumImplicitWait() {
        return Integer.parseInt(getProperty("ImplicitWait", "1"));
    }

    public static final String getTestOutputDir() {
        String directory = getProperty("testOutputDir", "test-output");
        File f = new File(directory);
        return FilenameUtils.normalize(f.getAbsolutePath());
    }

    public static String getProperty(String keyName, String defaultValue) {
        String propertyValue = getProperty(keyName);
        return StringUtils.isNotBlank(propertyValue) ? propertyValue.trim() : defaultValue;
    }

    public static void setProperty(String keyName, String value) {
        testProperties.setProperty(keyName, value);
    }

    public static String getAllPropertiesAsString() {
        if (testProperties == null) {
            return "";
        } else {
            Map<String, String> map = new HashMap<>();
            for (String name : testProperties.stringPropertyNames()) {
                map.put(name, testProperties.getProperty(name));
            }
            StringBuilder stringBuilder = new StringBuilder();

            for (String name : map.keySet()) {
                if (!name.toLowerCase().contains("password") && !name.toLowerCase().contains("salt")) {
                    String var10001 = name.toString();
                    stringBuilder.append(var10001 + " : " + ((String) map.get(name)).toString());
                    stringBuilder.append(", ");
                }
            }
            return StringUtils.removeEnd(stringBuilder.toString(), ", ");
        }

    }

    public static String getProperty(String keyName) {
        String key = keyName.trim();
        String value = System.getenv(key);
        if (!StringUtils.isBlank(value)) {
            return value.trim();
        } else {
            value = System.getProperty(key);
            if (!StringUtils.isBlank(value)) {
                return value.trim();
            } else if (testProperties == null) {
                return null;
            } else {
                value = testProperties.getProperty(keyName.trim());
                if (value != null) {
                    if (keyName.contains("encrypted")) {
//                        value=PasswordUtil.decrypt(value.trim(), getProperty("salt"));
                    }
                    return replaceParams(value.trim());
                } else {
                    return null;
                }
            }
        }
    }

    private static String replaceParams(String str) {
        if (str != null && str.length() != 0) {
            Pattern r = Pattern.compile("\\{[a-zA-Z0-9_]+(.msg)?\\}");
            Matcher m = r.matcher(str);

            while (m.find()) {
                String key = m.group();
                String trimkey = key.replace("{", "").replace("}", "").trim();
                String replaceStr = null;
                if (trimkey.endsWith(".msg")) {
                    replaceStr = MessageProperties.getProperty(trimkey.replace(".msg", ""));
                } else {
                    replaceStr = (String) runtimeParams.get(trimkey);
                    if (replaceStr == null) {
                        replaceStr = getProperty(trimkey);
                    }
                }
                if (replaceStr != null) {
                    if (trimkey.contains("nostr_")) {
                        str = str.replace("\"" + key + "\"", replaceStr);
                    } else {
                        str = str.replace(key, replaceStr);
                    }
                }
            }
            return str;
        } else {
            return str;
        }
    }
}
