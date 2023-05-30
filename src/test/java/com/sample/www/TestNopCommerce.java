package com.sample.www;

import com.sample.www.PageObjects.*;
import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import static com.sample.www.BluePrints.UserData.em;


public class TestNopCommerce extends TestBase {

    RegisterPageObject registerPageObject;
    HomePageObject homePageObject;
    LoginPageObject loginPageObject;
    MyAccountPageObject myAccountPageObject;
    ShoppingCartPageObject shoppingCartPageObject;

    int actualItemsDisplayed;


    @Test
    public void registerUserTest() throws InterruptedException {
        registerPageObject = new RegisterPageObject(driver);
        homePageObject = new HomePageObject(driver);

        //navigate and register user
        homePageObject.clickLoginMenu();
        registerPageObject.clickRegisterMenu();
        registerPageObject.insertDataOfUser();
        registerPageObject.clickRegisterButton();


    }

    @Test
    public void loginUserTest() throws InterruptedException {
        registerUserTest();
        loginPageObject = new LoginPageObject(driver);

        //navigate and login user by entering email, password
        loginPageObject.clickLoginMenu();
        loginPageObject.insertEmail();
        loginPageObject.insertPassword();
        loginPageObject.clickLoginButton();

        //verify that Welcome text is displayed after logging in
        Assert.assertEquals(loginPageObject.getWelcomeText(), "Welcome to our store");
        //verify logout menu is displayed
        Assert.assertTrue(loginPageObject.isLogoutDisplayed());

    }

    @Test
    public void myAccountTest() throws InterruptedException {
        //open page, register user and login
       // registerUserTest();
        loginUserTest();

        //open my account menu and verify the user information
        myAccountPageObject = new MyAccountPageObject(driver);
        myAccountPageObject.clickMyAccount();

        //verify title is displayed as expected
        Assert.assertEquals(myAccountPageObject.getMyAccountTitle(), "My account - Customer info");

        //verify the fields are the same as in Register test
        Assert.assertEquals(myAccountPageObject.getGender(), "Female");

        Assert.assertEquals(myAccountPageObject.getFirstName(), "Arjola");

        Assert.assertEquals(myAccountPageObject.getLastName(),"Avdulaj");

        Assert.assertEquals(myAccountPageObject.getDay(), "2");

        Assert.assertEquals(myAccountPageObject.getMonth(), "1");

        Assert.assertEquals(myAccountPageObject.getYear(),"2002");
        Thread.sleep(3000);


        Assert.assertEquals(myAccountPageObject.getEmail(), em);
        Thread.sleep(3000);

        Assert.assertEquals(myAccountPageObject.getCompany(),"Google");
        Thread.sleep(3000);
        //logout
        myAccountPageObject.clickLogout();
    }

    @Test
    public void dashboardTest() throws InterruptedException {
        //registerUserTest();
        loginUserTest();

        homePageObject = new HomePageObject(driver);
        homePageObject.hoverToComputersMenu();
        homePageObject.clickNotebooksMenu();
        Thread.sleep(5000);

        //verify title of the opened page
        Assert.assertEquals(homePageObject.getNotebooksTitle(),"Notebooks");

        //choose 9 on display
        homePageObject.clickDisplayDropdownMenu();
        homePageObject.clickDisplayDropdownNine();

        //verify 6 items are displayed
        Assert.assertEquals(homePageObject.numberOfProductItems(),6);
        Thread.sleep(4000);

        //filter to 16 GB and verify 1 item is displayed
        homePageObject.filterCapacityTo16();
        Thread.sleep(4000);
        Assert.assertEquals(homePageObject.numberOfProductItems(),1);
        Thread.sleep(4000);

        //unselect 16 and verify
        homePageObject.filterCapacityTo16();
        actualItemsDisplayed = homePageObject.numberOfProductItems();


        //add items 2 and 3 to wishlist and verify a notification is displayed
        homePageObject.addItemToWishList(2);
        Assert.assertTrue(homePageObject.isWishListNotificationDisplayed());

        homePageObject.addItemToWishList(3);
        Assert.assertTrue(homePageObject.isWishListNotificationDisplayed());

        //add items 4 5 6 to cart and verify notification is displayed
        homePageObject.addItemToCartList(4);
        Assert.assertTrue(homePageObject.isShoppingCartNotificationDisplayed());

        homePageObject.addItemToCartList(5);
        Assert.assertTrue(homePageObject.isShoppingCartNotificationDisplayed());

        homePageObject.addItemToCartList(6);
        Assert.assertTrue(homePageObject.isShoppingCartNotificationDisplayed());


        //verify number of items in each menu
        String numOfWishlistItems = homePageObject.getNrItemsOnWishlistLabel();
        Assert.assertEquals(numOfWishlistItems, "(2)");
        Thread.sleep(5000);

        String numOfCartItems = homePageObject.getNrItemsOnCartLabel();
        Assert.assertEquals(numOfCartItems, "(3)");
    }

    @Test
    public void shoppingCartTest() throws InterruptedException {
        //precondition: dashboard test
        dashboardTest();

        //hover to shopping cart and verify go to cart is displayed then click it
        shoppingCartPageObject = new ShoppingCartPageObject(driver);
        shoppingCartPageObject.hoverToShoppingCart();
        Assert.assertTrue(shoppingCartPageObject.isGoToCartDisplayed());
        shoppingCartPageObject.clickGoToCart();

        //verifyTitle
        String actualShoppingCartTitle = shoppingCartPageObject.getShoppingCartTitle();
        Assert.assertEquals(actualShoppingCartTitle, "Shopping cart");

        //verify elements are displayed
        Assert.assertTrue(shoppingCartPageObject.isUpdateCartDisplayed());
        Assert.assertTrue(shoppingCartPageObject.isContinueShoppingDisplayed());
        Assert.assertTrue(shoppingCartPageObject.isEstimateShippingDisplayed());
        Assert.assertEquals(shoppingCartPageObject.getPricesSum(),shoppingCartPageObject.getTotalAmount());
    }

    @Test
    public void emptyShoppingCartTest() throws InterruptedException {
        //precondition: dashboard test and shopping cart test
        shoppingCartTest();

        //empty shopping cart
        shoppingCartPageObject = new ShoppingCartPageObject(driver);
        //remove first item
        shoppingCartPageObject.removeItemFromCart(1);

        //verify nr is decreased by 1
        Assert.assertEquals(shoppingCartPageObject.getNrItemsOnCart(), 2);

        //repeat second time
        shoppingCartPageObject.removeItemFromCart(1);
        //verify nr is decreased by 1
        Assert.assertEquals(shoppingCartPageObject.getNrItemsOnCart(), 1);

        //repeat third time -> empty list
        shoppingCartPageObject.removeItemFromCart(1);
        Assert.assertEquals(shoppingCartPageObject.getNrItemsOnCart(), 0);


    }

    public static void nopCommerceSetup() {
        test = extent.createTest("Verify URL", "Case 1: User needs to verify if Amazon homepage works as expected.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Arjola");

        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String baseUrl = "https://demo.nopcommerce.com/";
        driver.get(baseUrl);
    }
}
