package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public CheckOutCompletePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//*[@id='checkout_complete_container']/h2")
    WebElement thankYouText;

    public String getThankYouText()
    {
        log.info("I can see the thank you text " + thankYouText.toString());
        return getTextFromElement(thankYouText);
    }


}
