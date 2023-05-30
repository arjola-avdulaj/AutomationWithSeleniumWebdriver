package com.sample.www.PageObjects;

import com.sample.www.BluePrints.HomeBlueprint;
import com.sample.www.Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageObject {
    WebDriver driver;
    HomeBlueprint homeBlueprint;
    Helper helper;
    public List<WebElement> cartListItems;
    public List<WebElement> wishListItems;
    public List<WebElement> productItems;



    public HomePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        homeBlueprint = new HomeBlueprint(driver);
        helper = new Helper(driver);
    }

    public void clickLoginMenu() {
        helper.clickElement(homeBlueprint.loginMenu, By.className("ico-login"));
    }


    public void hoverToComputersMenu()  {
        helper.hoverOver(homeBlueprint.computersMenu,By.xpath("//a[@href='/computers']") );
    }

    public void clickNotebooksMenu(){
        helper.clickElement(homeBlueprint.notebooksMenu, By.xpath("//a[@href='/notebooks']"));
    }
    public void clickDisplayDropdownMenu(){
        helper.clickDropDownElement(homeBlueprint.displayDropdownMenu, By.id("products-pagesize"));
    }
    public void clickDisplayDropdownNine(){
        helper.clickDropDownElement(homeBlueprint.displayDropdownNine, By.xpath("//select[@id='products-pagesize']/option[@value='9']"));
    }

    public void addToCart(List<WebElement> elements,int position){
        WebElement myElement = elements.get(position);
        myElement.click();
    }

    public void addToWishList(List<WebElement> elements,int position){
        WebElement myElement = elements.get(position);
        myElement.click();
    }



    public void filterCapacityTo16(){
        helper.clickElement(homeBlueprint.filterCapacityTo16, By.xpath("//input[@id='attribute-option-10']"));
    }

    public void waitForVisibilityOfNotebooksMenu(){
        helper.waitForElementToBeVisible(By.xpath("//a[@href='/notebooks']"));
    }
    public void waitForVisibilityOfDropdownNine(){
        helper.waitForElementToBeVisible(By.xpath("//select[@id='products-pagesize']/option[@value='9']"));
    }

    public String getNotebooksTitle(){
        return homeBlueprint.notebooksTitle.getText();
    }
    public String getNrItemsOnWishlistLabel(){
        return homeBlueprint.wishlistLabel.getText();
    }
    public String getNrItemsOnCartLabel(){
        return homeBlueprint.cartLabel.getText();
    }

    public boolean isWishListNotificationDisplayed() {
        return helper.isDisplayed(homeBlueprint.wishListNotification, By.xpath("//p[text()='The product has been added to your ']"));
    }

    public boolean isShoppingCartNotificationDisplayed() {
        return helper.isDisplayed(homeBlueprint.shoppingCartNotification,By.xpath("//p//a[text()='shopping cart']"));
    }

    public int numberOfProductItems(){
        List<WebElement> items = homeBlueprint.productItems;
        int actual = helper.getNrItems(items);
        return actual;
    }
    public void addItemToWishList(int num) {
        List<WebElement> items = homeBlueprint.wishListItems;
        helper.sleep(3);
        addToWishList(items,num-1);
        helper.sleep(3);
    }

    public void addItemToCartList(int num)  {
        List<WebElement> items = homeBlueprint.cartListItems;
        helper.sleep(3);
        addToCart(items,num-1);
        helper.sleep(3);
    }

}