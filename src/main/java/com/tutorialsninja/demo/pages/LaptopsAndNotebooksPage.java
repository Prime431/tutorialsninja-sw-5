package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPath;


    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Laptops & Notebooks']")
    WebElement laptopAndNotebookText;
    @CacheLookup
    @FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space()='Components']")
    WebElement components;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement laptopAndNotebooksSortBy;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBookLink;


    public String componentsText() {
        String actualText = getTextFromElement(components);
        return actualText;
    }

    public String laptopAndNotebooksText() {
        String actualText = getTextFromElement(laptopAndNotebookText);
        return actualText;
    }

    public void getHighToLowPrice() {

        List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='row'])[6]"));
        System.out.println(elements);

    }


    public ArrayList<String> expectedList() {
        // Get all the products name and stored into array list
        List<WebElement> products = productsPath;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        return originalProductsName;
    }

    public void selectPriceHighToLow(String inputSelectPriceOrder) {
        Reporter.log("selecting " + inputSelectPriceOrder.toString());
        selectByVisibleTextFromDropDown(laptopAndNotebooksSortBy, inputSelectPriceOrder);
        CustomListeners.test.log(Status.PASS, "select" + inputSelectPriceOrder);
    }

    public List<Double> beforeSorting() {
        List<WebElement> product = productsPath;
        ArrayList<Double> originalList = new ArrayList<>();
        for (WebElement list : product) {
            String[] arr = list.getText().split("Ex Tax:");
            originalList.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalList;
    }

    public List<Double> afterSorting() {
        Collections.sort(beforeSorting(), Collections.reverseOrder());
        System.out.println(beforeSorting());
        List<WebElement> products = productsPath;
        ArrayList<Double> afterSortingList = new ArrayList<>();
        for (WebElement newSortList : products) {
            String[] arr = newSortList.getText().split("Ex Tax:");
            afterSortingList.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return afterSortingList;
    }

    public void clickOnMacbook() {
        Reporter.log("Clicking on macbook " + macBookLink.toString());
        clickOnElement(macBookLink);
        CustomListeners.test.log(Status.PASS, "Click on macbook");
    }
}

