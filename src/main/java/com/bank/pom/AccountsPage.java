package com.bank.pom;

import com.bank.Utility.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class AccountsPage extends Utils {

    public AccountsPage(WebDriver driver){
        super(driver);
    }

    // ********************Locators**********************

    @FindBy(css = "#nav-accounts")
    WebElement accountsTab;

    @FindBy(css = "#search-input")
    WebElement searchInputFld;

    @FindBy(css = "#filter-type")
    WebElement dropDownBtn;

    @FindBy(xpath = "//span[text()='Checking']")
    WebElement checkingAccountTypeFld;

    @FindBy(css = "#sort-by")
    WebElement sortByDD;

    @FindBy(xpath = "//tbody[@id='accounts-tbody']/tr/td[2]")
    WebElement accountNameTxt;

    @FindBy(xpath = "//span[text()='Balance']")
    WebElement sortByBalFld;

    @FindBy(css = "#reset-filters-btn")
    WebElement resetBtn;

    //********************Actions************************
    public void clickOnAccountsTab(String txt, String ddTxt, String sortTxt){
        click(accountsTab);
        click(searchInputFld);
        searchInputFld.sendKeys(txt);
        click(dropDownBtn);
        click(checkingAccountTypeFld);
        click(sortByDD);
        click(sortByBalFld);

    }
    public String getAccNameTxt(){
        return getText(accountNameTxt);
    }
    public void clickOnResetBtn(){
        click(resetBtn);
    }
}
