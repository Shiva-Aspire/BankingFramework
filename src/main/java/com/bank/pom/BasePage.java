package com.bank.pom;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.Duration;
import java.util.logging.Logger;
import org.testng.*;

import javax.swing.*;

public class BasePage {


//    private static final Logger logger = Logger.getLogger(BasePage.class);
    private static final int DEFAULT_SECS_TO_WAIT=2;
    private int defaultWaitSeconds=2;
    private WebDriverWait defaultWait;
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
        this.pageInitElements(this);
        defaultWait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public <T extends BasePage> T pageInitElements(Class<?> expectedPage){
        T expectedObject=(T)(PageFactory.initElements(this.driver, expectedPage));
        return expectedObject;
    }
    public void pageInitElements(BasePage expectedPage){
        PageFactory.initElements(this.driver, expectedPage);
    }

    public void waitOfVisible(WebElement element){
        defaultWait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitOfClickable(WebElement element){
        defaultWait.until((ExpectedConditions.elementToBeClickable(element)));
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
    protected  WebDriver getDriver(){
        return this.driver;
    }
    protected WebDriver getDriver(int x, int y){
        this.driver.manage().window().setSize(new Dimension(x, y));
        return this.driver;
    }

    protected WebDriver getDriver(boolean isFullScreen){
        if (isFullScreen){
            this.driver.manage().window().maximize();
        }
        return this.driver;
    }
//    protected Logger getLogger(){
//        return logger;
//    }
    protected boolean isPageLoad(){
        return false;
    }
    protected void setStep(String name, String value){
        Reporter.getCurrentTestResult().setAttribute(System.currentTimeMillis()+name,value);
    }
    public void checkCheckBox(WebElement element){
        if (!element.isSelected()){
            element.click();
        }
    }
    public boolean checkPageContainsText(String text){
        return this.driver.getPageSource().contains(text);
    }

    public boolean checkTitle(String expectedTitle){
        if (StringUtils.isBlank(expectedTitle)){
            Assert.fail("the expected title passed in is either null or an empty string. ");
        }
        boolean result=this.driver.getTitle().equalsIgnoreCase(expectedTitle.trim());
        return result;
    }
    public boolean checkTitleContainsText(String text){
        return this.driver.getTitle().contains(text);
    }

    public String getCssValue(WebElement element, String attributename){
//        this.waitforElement(element);
        return element.getCssValue(attributename);
    }
    public boolean checkURIContainsText(String text){
        return this.driver.getCurrentUrl().contains(text);
    }

    public void clear(WebElement element){
        element.clear();
        element.click();
        Actions builder=new Actions(this.driver);
        builder.keyDown(Keys.CONTROL);
        builder.sendKeys(new CharSequence[]{"a"});
        builder.keyUp(Keys.CONTROL);
        builder.sendKeys(new CharSequence[]{Keys.DELETE});
        builder.build();
        builder.perform();
    }

    public void clickWebElement(WebElement element){
        this.clickWebElement(element, this.defaultWaitSeconds);
    }

    public void clickWebElement(WebElement element, int maxWaitSeconds){
        WebDriverWait wait=new WebDriverWait(this.driver, Duration.ofSeconds((long) maxWaitSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean waitForElementVisible(WebElement element){
        return this.waitForElementVisible(30, element);
    }

    public boolean waitForElementVisible(int timeout, WebElement element){
        Wait<WebDriver> wait=(new FluentWait(this.driver)).withTimeout(Duration.ofSeconds((long) timeout)).pollingEvery(Duration.ofSeconds(5L)).ignoring(Exception.class);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));

        }catch (Throwable var5){

        }
        return this.isVisible(element);
    }

    public boolean isVisible(WebElement key){
        for (int x=0; x<=50; x++){
            try {
                boolean display = key.isDisplayed();
                if (display){
                    return true;
                }
            }catch (Exception var4){

            }
            this.waitForSpecifiedDuration(1);
        }
        try {
            Dimension d=key.getSize();
            return d.getHeight()>0&&d.getWidth()>0;
        }catch (Exception var5){
            return false;
        }
    }

    public void waitForSpecifiedDuration(Integer waitSecs){
        Long atualWaitingTime =waitSecs.longValue();
        try {
            Thread.sleep(atualWaitingTime);
        }catch (InterruptedException var4){

        }
    }
}
