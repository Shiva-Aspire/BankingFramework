package com.bank.tests;

import com.bank.Utility.GlobalProperties;
import com.bank.pom.AccountsPage;
import com.bank.pom.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountsTest extends BaseClass {

    @Test(dataProvider = "validLoginData", groups = {"smoke"})
    public void verifyAccountsTab(String userName, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        AccountsPage ap = new AccountsPage(driver);
        ap.clickOnAccountsTab("ch", "Checking", "Account Name");
        Assert.assertEquals(ap.getAccNameTxt(), GlobalProperties.getExpvalues("accountNameExp.txt"));
        ap.takesScreenShot("accountTab_SS");
        ap.clickOnResetBtn();
        ap.takesScreenShot("accountTab_SS_afterReset");
    }

    @Test(dataProvider = "validLoginData", groups = {"regression"})
    public void verifyEditBtn(String userName, String password){
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        AccountsPage ap=new AccountsPage(driver);
        ap.clickOnEditBtn();
        ap.takesScreenShot("checkEditBtn");
        ap.clickOnDeleteBtn();
        ap.takesScreenShot("checkDelete");
    }
}
