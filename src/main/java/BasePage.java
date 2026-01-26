import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    BasePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    protected void waitOfVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitOfClickable(WebElement element){
        wait.until((ExpectedConditions.elementToBeClickable(element)));
    }
    protected String getText(WebElement element){
        waitOfVisible(element);
        return element.getText();
    }
    protected void click(WebElement element){
        waitOfClickable(element);
        element.click();
    }

}
