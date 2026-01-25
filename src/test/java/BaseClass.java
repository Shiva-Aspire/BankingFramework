import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {
    WebDriver driver;

    Properties prop;
    public void loadProperties(){
        prop=new Properties();
        File file=new File(System.getProperty("user.dir")+"\\src\\main\\java\\Config.properties");
        try {
            FileInputStream fis=new FileInputStream(file);
            prop.load(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public WebDriver initializeBrowser(String browserName) {
        loadProperties();
        if (browserName.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
        }
        return driver;
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
