package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }


    @CacheLookup
    @FindBy(className = "product_sort_container")
    WebElement filterDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    List<WebElement> addToCartList;

    @CacheLookup
    @FindBy(xpath = "//button[text() = 'Add to cart']")
    WebElement addToCartButtonForCostliestProduct;

    @CacheLookup
    @FindBy(xpath = "//div[@class='inventory_list']/div[6]/descendant::button")
   WebElement addToCartButtonForCheapestProduct;

    @CacheLookup
    @FindBy(id = "shopping_cart_container")
    WebElement shoppingCartPicture;


    public void selectPriceHightToLowFromFilter(String filter) {
        log.info("select price from the filter: high to low" + filterDropDown.toString());
        selectByVisibleTextFromDropDown(filterDropDown, filter);
    }

    public void selectCostliestProduct()
    {
        log.info("Select the costliest product :" + addToCartButtonForCostliestProduct.toString());
        clickOnElement(addToCartButtonForCostliestProduct);
    }

    public void selectCheapestProduct()
    {
        log.info("Select the cheapest product : " + addToCartButtonForCheapestProduct.toString());
        clickOnElement(addToCartButtonForCheapestProduct);
    }

    public void clickOnShoppingCartPicture()
    {
        log.info("click on the shopping cart picture : " + shoppingCartPicture.toString());
        clickOnElement(shoppingCartPicture);
    }


    public void clickOnAddToCart() throws InterruptedException {
        log.info("add to cat cheapest & costliest products ");
        addToCartList.get(0).click();
        addToCartList.get(addToCartList.size() - 1).click();
        Thread.sleep(5000);
    }

}
