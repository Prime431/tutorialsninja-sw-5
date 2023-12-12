package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(className = "dropdown-toggle")
    WebElement desktops;

    @CacheLookup
    @FindBy(className = "see-all")
    WebElement showAllDesktops;
    @CacheLookup
    @FindBy(className = "dropdown-toggle")
    WebElement laptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space()='Components']")
    WebElement components;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement loginAccountText;
    @CacheLookup
    @FindBy(className = "hidden-xs hidden-sm hidden-md")
    WebElement currency;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccounts;
    @CacheLookup
    @FindBy(className = "currency-select btn btn-link btn-block")
    WebElement poundSterling;

    @CacheLookup
    @FindBy(css = "li[class='dropdown open'] a[class='see-all']")
    WebElement showAllLaptopsAndNotebooks;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;

    public void clickOnMyAccount() {
        Reporter.log("Clicking on my account " + myAccounts.toString());
        clickOnElement(myAccounts);
        CustomListeners.test.log(Status.PASS, "Click on my accounts tab");
    }
    public void clickOnShowAllLaptopsAndNotebooks(){
        clickOnElement(showAllLaptopsAndNotebooks);
    }
    public void mouseHooverOnDesktops() {
        mouseHoverToElementAndClick(desktops);
    }

    public void mouseHoverOnDesktopsAndClickOnShowAllDesktops() {
        mouseHoverToElementAndClick(showAllDesktops);
    }

    public void mouseHooverAndClickOnPoundSterling() {
        mouseHoverToElementAndClick(poundSterling);
    }

    public void mouseHooverAndClickOnCurrency() {
        mouseHoverToElementAndClick(currency);
    }
    public String getLoginAccountText() {
        Reporter.log("Getting login account text " + loginAccountText.toString());
        CustomListeners.test.log(Status.PASS, "Get login account text");
        return getTextFromElement(loginAccountText);
    }
    public void mouseHooverAndClickOnShowAllDesktops() {
        mouseHoverToElementAndClick(desktops);
    }
    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountsList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }
    public void mouseHoverAndClickOnComponents() {
        mouseHoverToElementAndClick(components);
    }
    public String getRegisterAccountText() {
        Reporter.log("Getting register account text " + registerAccountText.toString());
        CustomListeners.test.log(Status.PASS, "Get register account text");
        return getTextFromElement(registerAccountText);
    }
    public void mouseHooverOnDesktopMenuAndClick() {
        mouseHoverToElementAndClick(desktops);
    }

    public void clickOnShowAllDesktops() {
        clickOnElement(showAllDesktops);
    }

    public void mouseHooverOnLaptopsAndNotebooksAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooks);
    }

    public void selectMenu(String menu) {
        if (menu == "Desktops") {
            //Find Desktop tab, hover and click on "Show All Desktops"
            clickOnElement(desktops);

        } else if (menu == "Laptops & Notebooks") {
            //Find Laptops & Notebooks tab, hover and click on "Show All Laptops & Notebooks"
            clickOnElement(laptopsAndNotebooks);

        } else if (menu == "Components") {
            //Find Components tab, hover and click on "Show All Components"
            clickOnElement(components);

        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }
}
