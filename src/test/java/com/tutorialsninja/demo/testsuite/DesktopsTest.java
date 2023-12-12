package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.Iphone;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {
    DesktopPage desktopPage;
    HomePage homePage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    Iphone iphone;
    WebElement element;

    @BeforeMethod
    public void inIt() {
        desktopPage = new DesktopPage();
        homePage = new HomePage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        iphone = new Iphone();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //        1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.mouseHooverOnDesktopMenuAndClick();
//        1.1 Mouse hover on Desktops Tab. and click
//        1.2 Click on “Show All Desktops”
        homePage.clickOnShowAllDesktops();
//        1.3 Select Sort By position "Name: Z to A"


//        1.4 Verify the Product will arrange in Descending order.
//
//
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty,
                                                             String successMessage, String productName, String model, String total) {

//            2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHooverAndClickOnCurrency();
//            2.2 Mouse hover on £Pound Sterling and click
        homePage.mouseHooverAndClickOnPoundSterling();
//            2.3 Mouse hover on Desktops Tab.
        homePage.mouseHooverOnDesktops();
//            2.4 Click on “Show All Desktops”
        homePage.mouseHoverOnDesktopsAndClickOnShowAllDesktops();
//            2.5 Select Sort By position "Name: A to Z"
        desktopPage.sortByPositionAtoZ();
//            2.6 Select product <product>
        desktopPage.selectIphoneFromDesktops(product);
//            2.7 Enter Qty <qty> using Select class.
        iphone.clickOnQuantity();
        element.sendKeys(Keys.BACK_SPACE);
        iphone.enterIphoneQuantity(qty);
//            2.8 Click on “Add to Cart” button
        iphone.clickOnIphoneAddToCart();
//            2.9 Verify the Message <successMessage>
        Assert.assertEquals(iphone.iphoneAddToCartSuccessMessage(), "Success: You have added iPhone to your shopping cart!");
//            2.10 Click on link “shopping cart” display into success message
        iphone.clickOnShoppingCart();
//            2.11 Verify the text "Shopping Cart"
        Assert.assertEquals(iphone.verifyTheShoppingCartText(), "Shopping Cart");
//            2.12 Verify the Product name <productName>
        Assert.assertEquals(iphone.verifyIphoneProductNameText(), "iPhone");
//                    2.13 Verify the Model <model>
        Assert.assertEquals(iphone.verifyIphoneModelNameText(), "product 11");
//            2.14 Verify the To
        Assert.assertEquals(iphone.verifyIphoneTotal(), "£150.92");

    }
}

