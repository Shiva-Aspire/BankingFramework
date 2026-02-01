package com.bank.tests;
import com.bank.Utility.ExcelUtils;
import com.bank.Utility.GlobalProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class BaseClass {
    public WebDriver driver;
    public static String browser;
    @BeforeMethod
    public void setUp() {
        GlobalProperties.loadProp();
        String browser = GlobalProperties.getConfig("browser").toLowerCase();
        if (browser == null || browser.isEmpty()) {
            browser="chrome";
        }
        if (System.getenv("browser")!=null && !System.getenv("browser").isBlank()){
            browser=System.getenv("browser");
        }else {
            browser=GlobalProperties.getConfig("browser");
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
        driver.get(GlobalProperties.getConfig("url"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @DataProvider(name = "validLoginData")
    public Object[][] validloginDataProvider() {
        return ExcelUtils.getExcelData("ValidLoginData");
    }
    @DataProvider(name = "InvalidLoginData")
    public Object[][] InvalidloginDataProvider() {
        return ExcelUtils.getExcelData("InvalidLoginData");
    }

}





