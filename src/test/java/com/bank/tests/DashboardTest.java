package com.bank.tests;

import com.bank.Utility.GlobalProperties;
import com.bank.pom.DashboardPage;
import com.bank.pom.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseClass {


    @Test(groups = "regression", dataProvider = "validLoginData")
    public void verifyDashboardTopPage(String userName, String password){
        LoginPage lp=new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        DashboardPage dp=new DashboardPage(driver);
        Assert.assertEquals(dp.getActiveAccountTxt(), GlobalProperties.getExpvalues("activeAccount.txt"));
        Assert.assertEquals(dp.getTotalTransactionTxt(), GlobalProperties.getExpvalues("totalTransaction.txt"));
    }
    //End-to-End test Automation Script for creating a new account
    @Test(groups = {"smoke", "regression"}, dataProvider = "validLoginData")
    public void verifyAddAccountQuickAction(String userName, String password) {
        LoginPage lp=new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        DashboardPage dp=new DashboardPage(driver);
        dp.clickOnAddAccountQuickAction();
        dp.clickOnAccountName();
        dp.clickOnSelectAccountType();
        dp.initalBal();
        dp.clickonStatusActiveRBtn();
        dp.clickOnEnableProtectionCheckbox();
        dp.clickOnSaveAccountBtn();
    }
}
