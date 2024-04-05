package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryPage {

    private static final SelenideElement LOGO_TEXT= $(byText("Swag Labs"));
    private static final ElementsCollection PRODUCT_NAME=$$("div[class='inventory_item_name ']");
    private static final SelenideElement FIRST_PRODUCT=$$("div[class='inventory_item']").get(0).$(byTagAndText("button","Add to cart"));
    private static final SelenideElement SHOPPING_CART_BADGE =$(byClassName("shopping_cart_badge"));
    private static final SelenideElement SHOPPING_CART=$(byClassName("shopping_cart_link"));

    public String productName;


    public InventoryPage verifyHomePage(){
        LOGO_TEXT.shouldHave(exist, Duration.ofSeconds(2000));
        return this;
    }
    public InventoryPage addProduct() {
        productName=PRODUCT_NAME.get(0).getText();
        FIRST_PRODUCT.shouldBe(visible).click();
        return this;
    }
    public InventoryPage verifyCartCount(int count){
        SHOPPING_CART_BADGE.shouldHave(text(String.valueOf(count)));
        return this;
    }

    public CartPage selectCart(){
        SHOPPING_CART.click();
        return new CartPage();
    }
}
