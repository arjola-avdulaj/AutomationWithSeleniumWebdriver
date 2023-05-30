package com.sample.www.PageObjects;

import com.sample.www.BluePrints.LoginBlueprint;
import com.sample.www.BluePrints.UserData;
import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPageObject {

    WebDriver driver;
    LoginBlueprint loginBlueprint;
    Helper helper;
    UserData userData;

    public LoginPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
        loginBlueprint = new LoginBlueprint(driver);
        helper = new Helper(driver);
        userData = new UserData();
    }

    public void insertEmail()  {
        helper.insertText(loginBlueprint.getEmail(), By.xpath("//input[@class='email']") , userData.getEmail());
    }

    public void insertPassword() {
        helper.insertText(loginBlueprint.getPassword(), By.xpath("//input[@class='password']") , userData.getPassword());
    }

    public String getWelcomeText(){
        helper.waitForElementToBeVisible(By.xpath("//div[@class='topic-block-title']/h2"));
        return loginBlueprint.getWelcome().getText();
    }

    public boolean isLogoutDisplayed() {
        return helper.isDisplayed(loginBlueprint.getLogout(), By.className("ico-logout"));
    }

    public void clickLoginButton(){
        helper.clickElement(loginBlueprint.getLoginButton(), By.xpath("//button[@class='button-1 login-button']"));
    }

    public void clickLoginMenu(){
        helper.clickElement(loginBlueprint.getLoginMenu(), By.xpath("//a[@href='/login?returnUrl=%2F']"));
    }

}
