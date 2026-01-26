import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test(groups = "smoke", dataProvider = "validLoginData")
    public void loginTestWithValidCreds(String userName, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtn(userName,password);
    }
    @DataProvider(name = "validLoginData")
    public Object[][] validloginDataProvider(){
        return ExcelUtils.getExcelData("ValidLoginData");
    }

    @Test(groups = "Regression", dataProvider = "InvalidLoginData")
    public void Login(String userName, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        String alertText = driver.findElement(By.cssSelector("#alert-message")).getText();
        Assert.assertEquals(alertText,"⚠️ Invalid username or password. Please try again.");
    }
    @DataProvider(name = "InvalidLoginData")
    public Object[][] InvalidloginDataProvider(){
        return ExcelUtils.getExcelData("InvalidLoginData");
    }

}
