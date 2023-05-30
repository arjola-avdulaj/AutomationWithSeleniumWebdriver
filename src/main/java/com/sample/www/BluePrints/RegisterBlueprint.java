package com.sample.www.BluePrints;

import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterBlueprint {

    WebDriver driver;
    Helper helper;

    @FindBy(xpath = "//button[@class='button-1 register-button']")
    WebElement registerMenu;
    @FindBy(id = "gender-male")
    WebElement radioM;
    @FindBy(id = "gender-female")
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
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;
    @FindBy(id = "register-button")
    WebElement registerButton;
    @FindBy(xpath = "//div[@class='result']")
    WebElement registrationCompleteText;
    @FindBy(className = "ico-logout")
    public WebElement logout;


    public RegisterBlueprint(WebDriver driver){
        PageFactory.initElements(driver, this);
        helper=new Helper(driver);
    }

    public WebElement getRegisterMenu() {
        return registerMenu;
    }

    public WebElement getRadioF() {
        return radioF;
    }

    public WebElement getRadioM() {
        return radioM;
    }

    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getDay() {
        return day;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getMonth() {
        return month;
    }

    public WebElement getYear() {
        return year;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getPassword() {
        return password;
    }


    public WebElement getRegistrationCompleteText() {
        return registrationCompleteText;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }
}
