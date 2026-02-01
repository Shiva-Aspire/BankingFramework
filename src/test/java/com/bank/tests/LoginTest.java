package com.bank.tests;

import com.bank.pom.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

   @Test(groups = {"smoke", "regression"}, dataProvider = "validLoginData")
    public void loginWithValidCreds(String userName, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtn(userName,password);
    }

    @Test(groups = {"regression"}, dataProvider = "InvalidLoginData")
    public void loginWithInvalidCreds(String userName, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        String alertText = driver.findElement(By.cssSelector("#alert-message")).getText();
        Assert.assertEquals(alertText,"⚠️ Invalid username or password. Please try again.");
    }
}
