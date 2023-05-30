package com.sample.www.PageObjects;

import com.sample.www.BluePrints.MyAccountBlueprint;
import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageObject {
    WebDriver driver;
    MyAccountBlueprint myAccountBlueprint;
    Helper helper;

    public MyAccountPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        myAccountBlueprint = new MyAccountBlueprint(driver);
        helper = new Helper(driver);
    }

    public void clickMyAccount() {
        helper.clickElement(myAccountBlueprint.getMyAccountMenu(), By.xpath("//a[@class='ico-account']"));
    }

    public void clickLogout() {
        helper.clickElement(myAccountBlueprint.getLogoutMenu(),By.xpath("//a[@class='ico-logout']"));
    }

    public String getGender(){
        if(myAccountBlueprint.getRadioF().isSelected())
            return "Female";
        else return "Male";
    }

    public String getFirstName(){
        return myAccountBlueprint.getFirstname().getAttribute("value");
    }
    public String getLastName(){
        return myAccountBlueprint.getLastName().getAttribute("value");
    }
    public String getDay(){
        return myAccountBlueprint.getDay().getAttribute("value");
    }
    public String getMonth(){
        return myAccountBlueprint.getMonth().getAttribute("value");
    }
    public String getYear(){
        return myAccountBlueprint.getYear().getAttribute("value");
    }
    public String getEmail(){
        String email = myAccountBlueprint.getEmail().getAttribute("value");
        return email;
    }

    public String getCompany(){
        return myAccountBlueprint.getCompany().getAttribute("value");
    }

    public String getMyAccountTitle(){
        return myAccountBlueprint.getPageTitle().getText();
    }


}
