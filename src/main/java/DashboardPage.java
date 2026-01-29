import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends Utils{
    DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    //*************Locators**************
    @FindBy(css="#nav-menu li:nth-child(1)")
    private WebElement tabdashBoard;

    @FindBy(css="#accounts-count-title")
    WebElement activeAccount;

    @FindBy(css="#transactions-count-title")
    WebElement totalTransactions;

    //*************Actions***************
    public String getActiveAccountTxt(){
        click(tabdashBoard);
        return getText(activeAccount);
    }
    public String getTotalTransactionTxt(){
        click(tabdashBoard);
        return getText(totalTransactions);
    }



}
