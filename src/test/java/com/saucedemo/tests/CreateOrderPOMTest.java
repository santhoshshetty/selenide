package com.saucedemo.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateOrderPOMTest extends BaseTest{

    @Test
    public void createOrders() {
        new LoginPage().
                login("standard_user","secret_sauce").
                verifyHomePage();
        InventoryPage inventory=new InventoryPage();
        String productName=inventory.addProduct().productName;
        inventory.verifyCartCount(1).
                selectCart().
                verifyProductInCartPage(productName).
                checkout();
        new CheckoutPage().fillInConfirmationDetails("Selenide","Berlin","13587").
                continueToConfirmation().
                verifyProductInOverviewPage(productName).
                finishOrder().
                successMessageDisplayed("Thank you for your order!");
    }
}
