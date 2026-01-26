import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    LoginPage(WebDriver driver) {
        this.driver=driver;
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

// *********   Actions   ************************

    public void clickOnLoginBtn(String userName, String password) {
        usernameField.sendKeys(userName);
        passwordFeild.sendKeys(password);
        loginBtn.click();
    }
}
