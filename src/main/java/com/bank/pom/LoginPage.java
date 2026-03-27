package com.bank.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ProjectBasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*************Locators**************************
    //Username Field
    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;
    //password Field
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordFeild;
    //LoginButton
    @FindBy(xpath = "//button[@id='login-btn']")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    private WebElement loginHomeBtn;
    @FindBy(xpath = "//p[contains(text(), 'Practice Selenium')]")
    private WebElement paragraphTxt;

// *********   Actions   ************************

    public void clickOnLoginBtn(String userName, String password) {
        waitOfVisible(usernameField);
        usernameField.sendKeys(userName);
        waitOfVisible(passwordFeild);
        passwordFeild.sendKeys(password);
        click(loginBtn);
    }
    public void clickHomeBtn(){
        click(loginHomeBtn);

    }
    public String paragraphText(){
        return getText(paragraphTxt);
    }
}
