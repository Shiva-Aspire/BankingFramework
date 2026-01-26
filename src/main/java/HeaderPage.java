import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends Utils {
    HeaderPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //*************Locators**************************
    //Elements
    @FindBy(xpath="//span[@id='brand-name']")
    private WebElement hdrSecureBank;

    @FindBy(css="#nav-menu li:nth-child(1)")
    private WebElement tabdashBoard;

    @FindBy(css="#nav-menu li:nth-child(2)")
    private WebElement tabAccount;

    @FindBy(css="#nav-menu li:nth-child(3)")
    private WebElement tabTransactions;

    @FindBy(css="#header-account-number")
    private WebElement accountNumber;

    @FindBy(css="#total-balance-title")
    private WebElement totalBal;

    @FindBy(css="#header-transaction-id")
    private WebElement transactionId;


    // *********   Actions   ************************
    public String getHdrText(){

        return getText(hdrSecureBank);
    }
    public String getTotalBalText(){
        click(tabdashBoard);
        return getText(totalBal);
    }
    public String getAccountNumberText(){
        click(tabAccount);
        return getText(accountNumber);
    }
    public String getTransactionIdText(){
        click(tabTransactions);
        return getText(transactionId);
    }
}
