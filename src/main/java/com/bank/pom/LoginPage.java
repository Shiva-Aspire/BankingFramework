package com.bank.pom;

import com.bank.Utility.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utils {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
    @FindBy(xpath = "//button[contains(text(), 'Home')]")
    private WebElement loginHomeBtn;
    @FindBy(xpath = "//p[contains(text(), 'Learn and')]")
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
    public String getCoffeeImgTxt(){
        return getText(paragraphTxt);
    }
}
