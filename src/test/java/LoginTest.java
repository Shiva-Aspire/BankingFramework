import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test(groups = "smoke")
    public void loginTestWithValidCreds() {
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtn("admin", "admin123");
    }

    @Test
    public void loginTestWithInvalidCreds() {
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtnWithInvalidCred("shiva", "shiva123");
        String alertText = driver.findElement(By.cssSelector("#alert-message")).getText();
        Assert.assertEquals(alertText, "⚠\uFE0F Invalid username or password. Please try again.");
    }

}
