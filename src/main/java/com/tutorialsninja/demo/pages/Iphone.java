package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
public class Iphone extends Utility {
    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement iPhoneQuantity;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement iPhoneAddToCart;
    @CacheLookup
    @FindBy(className = "hidden-xs hidden-sm hidden-md")
    WebElement shoppingCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement addToCartSuccessMessage;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "(//a[contains(text(),'iPhone')])[2]")
    WebElement iphoneProductNameText;
    @CacheLookup
    @FindBy(xpath = "(//td[normalize-space()='product 11']")
    WebElement iphoneModelNameText;

    @CacheLookup
    @FindBy(css = "tbody tr td:nth-child(6)")
    WebElement iphoneTotal;

    public void clickOnIphoneAddToCart() {
        clickOnElement(iPhoneAddToCart);
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCart);
    }

    public String iphoneAddToCartSuccessMessage() {
        String actualText = getTextFromElement(addToCartSuccessMessage);
        return actualText;
    }

    public String verifyTheShoppingCartText() {
        String actualText = getTextFromElement(shoppingCartText);
        return actualText;
    }

    public String verifyIphoneProductNameText() {
        String actualText = getTextFromElement(iphoneProductNameText);
        return actualText;
    }

    public String verifyIphoneModelNameText() {
        String actualText = getTextFromElement(iphoneProductNameText);
        return actualText;
    }

    public String verifyIphoneTotal() {
        String actualText = getTextFromElement(iphoneTotal);
        return actualText;
    }

    public void clickOnQuantity() {
        clickOnElement(iPhoneQuantity);
    }

    public void enterIphoneQuantity(String value) {
        sendTextToElement(iPhoneQuantity, value);
    }
}
