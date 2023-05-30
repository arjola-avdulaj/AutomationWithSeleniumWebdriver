package com.sample.www.Helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Helper {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public Helper(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        action = new Actions(driver);
    }

    public void waitForAWhile()  {
    //wait

    }


    public void insertDate(WebElement element, String str){
        Select date = new Select(element);
        date.selectByVisibleText(str);
    }
    public void clickElement(WebElement element, By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
    public void clickDropDownElement(WebElement element, By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        this.sleep(2);
    }
    public void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }

    public void insertText(WebElement element, By locator,String str) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.sendKeys(str);
        this.sleep(1);
    }

    public void hoverOver(WebElement element, By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        action.moveToElement(element).perform();
        this.sleep(2);
    }

    public int getNrItems(List<WebElement> elements){
        return elements.size();
    }

    public boolean isDisplayed(WebElement element, By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return(element.isDisplayed());
    }
    public double getTextAndParseToDouble(WebElement element){
        String str= element.getText();
        String newStr = str.replaceAll("[$,]", "");
        return Double.parseDouble(newStr);
    }
    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> getWebElementList(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }

}

