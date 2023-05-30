package com.sample.www.BluePrints;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartBlueprint {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='cart-label']")
    public WebElement shoppingCartMenu;

    @FindBy(xpath = "//button[@class='button-1 cart-button']")
    public WebElement goToCart;

    @FindBy(xpath = "//h1[text()='Shopping cart']")
    public WebElement shoppingCartTitle;

    @FindBy(id = "updatecart")
    public WebElement updateCart;

    @FindBy(name = "continueshopping")
    public WebElement continueShopping;

    @FindBy(id = "open-estimate-shipping-popup")
    public WebElement estimateShipping;

    @FindBy(xpath = "//span//strong")
    public WebElement totalAmount;

    @FindBy(xpath = "//td[@class='remove-from-cart']")
    public List<WebElement> cartItems;

    @FindBy(xpath = "//td[@class='subtotal']//span")
    public List<WebElement> subtotalList;

    public ShoppingCartBlueprint(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
