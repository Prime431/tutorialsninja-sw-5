package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DesktopPage extends Utility {

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;
    @CacheLookup
    @FindBy(className = "img-responsive")
    WebElement iPhone;
    @CacheLookup
    @FindBy(css = "div[id='content'] h2")
    WebElement desktopsText;

    public String desktopsText() {
        String actualText = getTextFromElement(desktopsText);
        return actualText;
    }

    public void sortByPositionAtoZ() {
        selectByVisibleTextFromDropDown(sortBy, "Name (A - Z)");
    }

    public void selectIphoneFromDesktops(String value) {
        clickOnElement(iPhone);
    }
}