package com.bank.Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Utils{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Utils(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitOfVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitOfClickable(WebElement element){
        wait.until((ExpectedConditions.elementToBeClickable(element)));
    }
    public String getText(WebElement element){
        waitOfVisible(element);
        return element.getText();
    }
    public void click(WebElement element){
        waitOfClickable(element);
        element.click();
    }
    public void jsClick(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }
    public void takesScreenShot(String screenShotName){
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File dest=new File("src/test/resources/Screenshots"+screenShotName+".png");
        try {
            FileUtils.copyFile(src, dest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
