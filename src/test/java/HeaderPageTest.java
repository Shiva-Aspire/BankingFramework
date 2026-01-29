import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderPageTest extends BaseClass{
    @Test(dataProvider = "validLoginData")
    public void verifySecureBankHdr(String userName, String password){
        LoginPage lp=new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        HeaderPage hp=new HeaderPage(driver);
        Assert.assertEquals(hp.getHdrText(), GlobalProperties.getExpvalues("header.txt"));
        Assert.assertEquals(hp.getTotalBalText(), GlobalProperties.getExpvalues("totalbalence.txt"));
        Assert.assertEquals(hp.getAccountNumberText(), GlobalProperties.getExpvalues("accountNumber.txt"));
        Assert.assertEquals(hp.getTransactionIdText(), GlobalProperties.getExpvalues("transactionId.txt"));
    }
 }
