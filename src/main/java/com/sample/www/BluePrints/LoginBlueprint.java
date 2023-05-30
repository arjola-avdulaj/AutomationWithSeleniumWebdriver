package com.sample.www.BluePrints;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginBlueprint {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='/login?returnUrl=%2F']")
    private WebElement loginMenu;
    @FindBy(xpath = "//input[@class='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@class='password']")
    private WebElement password;
    @FindBy(xpath = "//div[@class='topic-block-title']/h2")
    private WebElement welcome;
    @FindBy(xpath = "//button[@class='button-1 login-button']")
    private WebElement loginButton;
    @FindBy(className = "ico-logout")
    private WebElement logout;

    public LoginBlueprint(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoginMenu() {
        return loginMenu;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getWelcome() {
        return welcome;
    }

    public WebElement getPassword() {
        return password;
    }
}
