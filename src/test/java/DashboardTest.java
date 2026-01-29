
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseClass{

    @Test(dataProvider = "validLoginData")
    public void verifyDashboardPage(String userName, String password){
        LoginPage lp=new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        DashboardPage dp=new DashboardPage(driver);
        Assert.assertEquals(dp.getActiveAccountTxt(),GlobalProperties.getExpvalues("activeAccount.txt"));
        Assert.assertEquals(dp.getTotalTransactionTxt(),GlobalProperties.getExpvalues("totalTransaction.txt"));
    }
}
