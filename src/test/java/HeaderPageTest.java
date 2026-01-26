import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderPageTest extends BaseClass{

    @Test
    public void verifySecureBankHdr(){
        LoginPage lp=new LoginPage(driver);
        lp.clickOnLoginBtn("admin", "admin123");
        HeaderPage hp=new HeaderPage(driver);
        Assert.assertEquals(hp.getHdrText(), "SecureBank");
        Assert.assertEquals(hp.getTotalBalText(), "Total Balance");
        Assert.assertEquals(hp.getAccountNumberText(), "Account Number");
        Assert.assertEquals(hp.getTransactionIdText(), "Transaction ID");
    }
 }
