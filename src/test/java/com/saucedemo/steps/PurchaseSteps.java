package com.saucedemo.steps;

import com.saucedemo.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class PurchaseSteps {
    @Given("^I am on saucedemo page$")
    public void iAmOnSaucedemoPage() {
    }

    @When("^I login with credential username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoginWithCredentialUsernameAndPassword(String userName, String password)  {

        new HomePage().enterUserNameAndPassword(userName,password);
    }

    @And("^I click on Login button$")
    public void iClickOnLoginButton() {

        new HomePage().clickOnLoginButton();
    }

    @And("^I filter the products by Price \"([^\"]*)\"$")
    public void iFilterTheProductsByPrice(String filter){
        new InventoryPage().selectPriceHightToLowFromFilter(filter);
    }

    @And("^I select cheapest & costliest products and add to basket$")
    public void iSelectCheapestCostliestProductsAndAddToBasket() throws InterruptedException {
//        new InventoryPage().selectCostliestProduct();
//        new InventoryPage().selectCheapestProduct();
        new InventoryPage().clickOnAddToCart();
    }

    @And("^I open shopping cart$")
    public void iOpenShoppingCart() {
        new InventoryPage().clickOnShoppingCartPicture();
    }

    @And("^I go to checkout$")
    public void iGoToCheckout() {
        new CartPage().clickOnCheckOutButton();

    }

    @And("^I enter details firstname \"([^\"]*)\", lastName \"([^\"]*)\" and zipPostalCode \"([^\"]*)\"$")
    public void iEnterDetailsFirstnameLastNameAndZipPostalCode(String firstName, String lastName, String postCode) {
        new CheckOutPage().enterFirstNameLastNamePostCode(firstName,lastName,postCode);
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() {
        new CheckOutPage().clickOnContinueButton();
    }

    @And("^I click on finish button$")
    public void iClickOnFinishButton() {
        new CheckOutStepTwoPage().clickOnFinishButton();
    }



    @Then("^I should be able to see message \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeMessage(String message) {
        String expectedMessage = message;
        String actualMessage = new CheckOutCompletePage().getThankYouText();
        Assert.assertEquals("page not displayed ",expectedMessage,actualMessage);

    }
}
