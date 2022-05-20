package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepTwoPage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public CheckOutStepTwoPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "finish")
    WebElement finishButton;

    public void clickOnFinishButton()
    {
        log.info("click on finish button" + finishButton.toString());
        clickOnElement(finishButton);
    }
}
