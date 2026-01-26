import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass{
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        GlobalProperties.loadProp();
        String browser = GlobalProperties.getConfig("browser").toLowerCase();
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
        driver.get(GlobalProperties.getConfig("url"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
