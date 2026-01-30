import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseClass{

    @Test(dataProvider = "validLoginData")
    public void verifyDashboardTopPage(String userName, String password){
        LoginPage lp=new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        DashboardPage dp=new DashboardPage(driver);
        Assert.assertEquals(dp.getActiveAccountTxt(),GlobalProperties.getExpvalues("activeAccount.txt"));
        Assert.assertEquals(dp.getTotalTransactionTxt(),GlobalProperties.getExpvalues("totalTransaction.txt"));
    }
    //End-to-End test Automation Script for creating a new account
    @Test(groups = "smoke", dataProvider = "validLoginData")
    public void verifyAddAccountQuickAction(String userName, String password) {
        LoginPage lp=new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        DashboardPage dp=new DashboardPage(driver);
        dp.clickOnAddAccountQuickAction();
        dp.clickOnAccountName();
        dp.accountName.sendKeys(GlobalProperties.getExpvalues("accountName.txt"));
        dp.clickOnSelectAccountType();
        dp.initalBal();
        dp.initalBal.sendKeys(GlobalProperties.getExpvalues("initalBalinput.txt"));
        dp.clickonStatusActiveRBtn();
        dp.clickOnEnableProtectionCheckbox();
        dp.clickOnSaveAccountBtn();
    }
}
