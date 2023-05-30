package com.sample.www.PageObjects;

import com.sample.www.BluePrints.HomeBlueprint;
import com.sample.www.BluePrints.RegisterBlueprint;
import com.sample.www.BluePrints.UserData;
import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject {
    WebDriver driver;
    HomeBlueprint home;
    RegisterBlueprint registerBlueprint;
    Helper helper;

    public RegisterPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
        registerBlueprint=new RegisterBlueprint(driver);
        home=new HomeBlueprint(driver);
        helper=new Helper(driver);
    }

    public void clickRegisterMenu(){
        helper.clickElement(registerBlueprint.getRegisterMenu(), By.xpath("//button[@class='button-1 register-button']"));
    }
    public void clickLogout(){
        helper.clickElement(registerBlueprint.logout, By.className("ico-logout"));
    }


    public void clickRegisterButton(){
        helper.clickElement(registerBlueprint.getRegisterButton(), By.id("register-button"));
    }

    public WebElement getRegistrationCompleteText(){
        return registerBlueprint.getRegistrationCompleteText();
    }

    public void insertDataOfUser()  {
        UserData userdata = new UserData();
        if(userdata.getGender().equals("Female"))
            helper.clickElement(registerBlueprint.getRadioF(), By.id("gender-female"));
        else helper.clickElement(registerBlueprint.getRadioM(), By.id("gender-male"));

        helper.insertText(registerBlueprint.getFirstname(), By.id("FirstName") , userdata.getFirstName());
        helper.insertText(registerBlueprint.getLastName(), By.id("LastName") , userdata.getLastName());
        helper.insertText(registerBlueprint.getDay(), By.name("DateOfBirthDay") , userdata.getDay());
        helper.insertText(registerBlueprint.getMonth(), By.name("DateOfBirthMonth") , userdata.getMonth());
        helper.insertText(registerBlueprint.getYear(), By.name("DateOfBirthYear") , userdata.getYear());
        helper.insertText(registerBlueprint.getEmail(), By.id("Email"), userdata.getEmail());
        helper.insertText(registerBlueprint.getCompany(), By.id("Company"), userdata.getCompany());
        helper.insertText(registerBlueprint.getPassword(),By.id("Password"), userdata.getPassword());
        helper.insertText(registerBlueprint.getConfirmPassword(),By.id("ConfirmPassword"), userdata.getConfirmPassword());

    }




}
