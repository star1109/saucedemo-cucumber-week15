package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement userName;

    @CacheLookup
    @FindBy(id = "password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "login-button")
    WebElement loginButton;


    public void enterUserNameAndPassword(String uname,String pwd) {
        log.info("Enter User name :" + userName.toString() + "<br>");
        sendTextToElement(userName,uname);
        log.info("Enter Password :" + password.toString() + "<br>");
        sendTextToElement(password,pwd);
    }

    public void clickOnLoginButton()
    {
        log.info("i clicked on the login button " + loginButton.toString());
        clickOnElement(loginButton);
    }

}
