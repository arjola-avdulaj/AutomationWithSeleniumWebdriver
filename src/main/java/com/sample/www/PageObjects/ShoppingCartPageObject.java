package com.sample.www.PageObjects;

import com.sample.www.BluePrints.ShoppingCartBlueprint;
import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class ShoppingCartPageObject {
    WebDriver driver;
    ShoppingCartBlueprint shoppingCartBlueprint;
    Helper helper;

    public List<WebElement> removeButtonsList;
    public List<WebElement> subtotalList;

    public ShoppingCartPageObject(WebDriver driver) {
        PageFactory.initElements(driver,this);
        shoppingCartBlueprint=new ShoppingCartBlueprint(driver);
        helper = new Helper(driver);
    }

    public void hoverToShoppingCart()  {
        helper.hoverOver(shoppingCartBlueprint.shoppingCartMenu, By.xpath("//span[@class='cart-label']"));
        helper.sleep(2);
    }

    public String getShoppingCartTitle(){
        return shoppingCartBlueprint.shoppingCartTitle.getText();
    }



    public List<Double> getSubtotals(List<WebElement> elements){
        List<Double> subtotals = new ArrayList<>();
        for(int i=0; i< elements.size(); i++){
            subtotals.add(helper.getTextAndParseToDouble(elements.get(i)));
        }
        return subtotals;
    }

    public double getSum(List<Double> elements){
        double sum=0;
        for(int i=0; i< elements.size(); i++){
            sum+=elements.get(i);
        }
        return sum;
    }

    public double getTotalAmount(){
        return helper.getTextAndParseToDouble(shoppingCartBlueprint.totalAmount);
    }

    public int getNrItemsOnCart(){
        removeButtonsList = shoppingCartBlueprint.cartItems;

        if(removeButtonsList.size()<1)
            return 0;
        return removeButtonsList.size();
    }

    public boolean isGoToCartDisplayed(){
        return helper.isDisplayed(shoppingCartBlueprint.goToCart, By.xpath("//button[@class='button-1 cart-button']"));
    }

    public boolean isUpdateCartDisplayed(){
        return helper.isDisplayed(shoppingCartBlueprint.updateCart, By.id("updatecart"));
    }

    public boolean isContinueShoppingDisplayed(){
        return helper.isDisplayed(shoppingCartBlueprint.continueShopping, By.name("continueshopping"));
    }
    public boolean isEstimateShippingDisplayed(){
        return helper.isDisplayed(shoppingCartBlueprint.estimateShipping, By.id("open-estimate-shipping-popup"));
    }
    public void clickGoToCart(){
        helper.clickElement(shoppingCartBlueprint.goToCart, By.xpath("//button[@class='button-1 cart-button']"));
    }

    public void removeElementFromCart(List<WebElement> elements,int position){
        WebElement myElement = elements.get(position);
        myElement.click();
    }

    public void removeItemFromCart(int position){
        List<WebElement> elements = shoppingCartBlueprint.cartItems;
        helper.sleep(3);
        removeElementFromCart(elements,position-1);
        helper.sleep(3);
    }

    public double getPricesSum(){
        List<WebElement> elements = shoppingCartBlueprint.subtotalList;
        List<Double> subtotals = getSubtotals(elements);
        double sum = getSum(subtotals);
        return sum;
    }

}

