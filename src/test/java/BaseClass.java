import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {
    protected WebDriver driver;
    protected Properties prop;

    @BeforeMethod
    public void setUp() {
        prop = new Properties();
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(("Config.properties"));
            prop.load(is);
            if (is == null) {
                throw new RuntimeException("config properties not found in path");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String browser = prop.getProperty("browser").toLowerCase();
        if (browser == null) {
            throw new RuntimeException("browser key is missing in prop file");
        }
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported which provided " + browser);
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
