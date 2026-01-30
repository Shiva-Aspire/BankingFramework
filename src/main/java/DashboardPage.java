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

    @FindBy(xpath = "//a[@id='add-account-link']")
    WebElement addAccountbtn;

    @FindBy(xpath = "//input[@id='account-name']")
    WebElement accountName;

    @FindBy(xpath = "//button[@id='account-type']")
    WebElement selectAccountType;

    @FindBy(xpath = "//div[normalize-space()='Savings Account']")
    WebElement savingsAccountDd;

    @FindBy(xpath = "//input[@id='initial-balance']")
    WebElement initalBal;

    @FindBy(xpath = "//button[@id='status-active']")
    WebElement statuActiveRBtn;

    @FindBy(css = "#overdraft-label")
    WebElement enableOverdraftProtectionCheckBox;

    @FindBy(xpath = "//button[@id='save-account-btn']")
    WebElement saveAccountBtn;

    //*************Actions***************
    public String getActiveAccountTxt(){
        click(tabdashBoard);
        return getText(activeAccount);

    }
    public String getTotalTransactionTxt(){
        click(tabdashBoard);
        return getText(totalTransactions);
    }
    public void clickOnAddAccountQuickAction(){
        click(addAccountbtn);
    }
    public void clickOnAccountName(){
        click(accountName);
    }
    public void clickOnSelectAccountType(){
        click(selectAccountType);
        jsClick(savingsAccountDd);
    }
    public void initalBal(){
        click(initalBal);
    }
    public void clickonStatusActiveRBtn(){
        click(statuActiveRBtn);
    }
    public void clickOnEnableProtectionCheckbox(){
        click(enableOverdraftProtectionCheckBox);
    }
    public void clickOnSaveAccountBtn(){
        click(saveAccountBtn);
    }





}
