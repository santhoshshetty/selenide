package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class CheckoutOverviewPage {

    private static final SelenideElement PRODUCT_NAME=$(byClassName("inventory_item_name"));
    private static final SelenideElement FINISH_BUTTON=element(byText("Finish"));

    public CheckoutOverviewPage verifyProductInOverviewPage(String product){
        this.PRODUCT_NAME.shouldHave(text(product));
        return this;
    }

    public ConfirmationPage finishOrder(){
        FINISH_BUTTON.shouldBe(enabled).click();
        return new ConfirmationPage();
    }
}
