package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private static final SelenideElement PRODUCT_NAME=$(byClassName("inventory_item_name"));
    private static final SelenideElement CHECKOUT_BUTTON=$(byTagAndText("button","Checkout"));

    public CartPage verifyProductInCartPage(String product){
        PRODUCT_NAME.shouldHave(Condition.text(product));
        return this;
    }

    public CheckoutPage checkout(){
        CHECKOUT_BUTTON.shouldBe(Condition.enabled).click();
        return new CheckoutPage();
    }
}
