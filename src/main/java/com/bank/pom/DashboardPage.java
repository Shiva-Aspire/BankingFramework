package com.bank.pom;

import com.bank.Utility.GlobalProperties;
import com.bank.Utility.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utils {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    //*************Locators**************
    @FindBy(css="#nav-menu li:nth-child(1)")
    private WebElement tabdashBoard;

    @FindBy(css="#accounts-count-title")
    private WebElement activeAccount;

    @FindBy(css="#transactions-count-title")
    private WebElement totalTransactions;

    @FindBy(xpath = "//a[@id='add-account-link']")
    WebElement addAccountbtn;

    @FindBy(xpath = "//input[@id='account-name']")
    private WebElement accountName;

    @FindBy(xpath = "//button[@id='account-type']")
    private WebElement selectAccountType;

    @FindBy(xpath = "//div[normalize-space()='Savings Account']")
    private WebElement savingsAccountDd;

    @FindBy(xpath = "//input[@id='initial-balance']")
    private WebElement initalBal;

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
        accountName.sendKeys(GlobalProperties.getExpvalues("accountName.txt"));
    }
    public void clickOnSelectAccountType(){
        click(selectAccountType);
        jsClick(savingsAccountDd);
    }
    public void initalBal(){
        click(initalBal);
        initalBal.sendKeys(GlobalProperties.getExpvalues("initalBalinput.txt"));
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
