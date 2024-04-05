package com.saucedemo.screens;

import com.codeborne.selenide.Condition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class PDPScreen {
    @AndroidFindBy(accessibility = "Add To Cart button")
    private WebElement addToCartButton;

    public void addToCart(){
        $(addToCartButton).shouldHave(Condition.enabled).click();
    }
}
