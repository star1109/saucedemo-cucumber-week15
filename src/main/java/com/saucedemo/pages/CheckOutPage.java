package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public CheckOutPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "first-name")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "last-name")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "postal-code")
    WebElement postCode;

    @CacheLookup
    @FindBy(id = "continue")
    WebElement continueButton;

    public void enterFirstNameLastNamePostCode(String fname,String lname,String pcode)
    {
        log.info("enter first name: " + firstName.toString());
        sendTextToElement(firstName,fname);
        log.info("enter last name: " + lastName.toString());
        sendTextToElement(lastName,lname);
        log.info("enter postal code: " + postCode.toString());
        sendTextToElement(postCode,pcode);
    }

    public void clickOnContinueButton()
    {
        log.info("click on continue button: "  + continueButton.toString());
        clickOnElement(continueButton);
    }


}
