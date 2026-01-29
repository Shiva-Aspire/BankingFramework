import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test(groups = "smoke", dataProvider = "validLoginData")
    public void loginTestWithValidCreds(String userName, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtn(userName,password);
    }

    @Test(groups = "Regression", dataProvider = "InvalidLoginData")
    public void LoginWithInvalidCreds(String userName, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        String alertText = driver.findElement(By.cssSelector("#alert-message")).getText();
        Assert.assertEquals(alertText,"⚠️ Invalid username or password. Please try again.");
    }
}
