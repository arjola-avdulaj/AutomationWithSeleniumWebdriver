package com.sample.www.BluePrints;

import com.sample.www.Helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountBlueprint {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='ico-account']")
    WebElement myAccountMenu;
    @FindBy(xpath = "//h1[text()='My account - Customer info']")
    WebElement pageTitle;
    @FindBy(xpath = "//a[@class='ico-logout']")
    WebElement logoutMenu;
    @FindBy(id = "gender-male")
    WebElement radioM;
    @FindBy(xpath="//input[@id=\"gender-female\"]")
    WebElement radioF;
    @FindBy(id = "FirstName")
    WebElement firstname;
    @FindBy(id = "LastName")
    WebElement lastName;
    @FindBy(name = "DateOfBirthDay")
    WebElement day;
    @FindBy(name = "DateOfBirthMonth")
    WebElement month;
    @FindBy(name = "DateOfBirthYear")
    WebElement year;
    @FindBy(id = "Email")
    WebElement email;
    @FindBy(id = "Company")
    WebElement company;

    public MyAccountBlueprint(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public WebElement getRadioM() {
        return radioM;
    }

    public WebElement getRadioF() {
        return radioF;
    }

    public WebElement getDay() {
        return day;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getYear() {
        return year;
    }

    public WebElement getMonth() {
        return month;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getMyAccountMenu() {
        return myAccountMenu;
    }

    public WebElement getLogoutMenu() {
        return logoutMenu;
    }
}
