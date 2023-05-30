package com.sample.www.BluePrints;

import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Scanner;

public class HomeBlueprint {
    WebDriver driver;
    Helper helper;


    @FindBy(className = "ico-login")
    public WebElement loginMenu;
    @FindBy(xpath = "//a[@href='/computers']")
    public WebElement computersMenu;
    @FindBy(xpath = "//a[@href='/notebooks']")
    public WebElement notebooksMenu;
    @FindBy(xpath = "//h1[text()='Notebooks']")
    public WebElement notebooksTitle;
    @FindBy(id = "products-pagesize")
    public WebElement displayDropdownMenu;
    @FindBy(xpath="//select[@id='products-pagesize']/option[@value='9']")
    public WebElement displayDropdownNine;
    @FindBy(xpath = "//input[@id='attribute-option-10']")
    public WebElement filterCapacityTo16;
    @FindBy (xpath = "//p[text()='The product has been added to your ']")
    public WebElement wishListNotification;
    @FindBy (xpath = "//p//a[text()='shopping cart']")
    public  WebElement shoppingCartNotification;
    @FindBy(xpath = "//span[@class='wishlist-qty']")
    public WebElement wishlistLabel;
    @FindBy (xpath = "//span[@class='cart-qty']")
    public WebElement cartLabel;
    @FindBy (xpath = "//div[@class='product-item']")
    public List<WebElement> productItems;
    @FindBy (xpath = "//button[@title='Add to wishlist']")
    public List<WebElement> wishListItems;
    @FindBy (xpath = "//button[text()='Add to cart']")
    public List<WebElement> cartListItems;

    public HomeBlueprint(WebDriver driver){
        PageFactory.initElements(driver, this);
        helper = new Helper(driver);
    }

}
