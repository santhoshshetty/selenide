package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class CheckoutPage {
    private static final SelenideElement FIRST_NAME=$(byAttribute("data-test","firstName"));
    private static final SelenideElement LAST_NAME=element("input[placeholder='Last Name']");
    private static final SelenideElement POSTAL_CODE=element(byId("postal-code"));
    private static final SelenideElement CONTINUE_BUTTON=element(byValue("Continue"));

    public CheckoutPage fillInConfirmationDetails(String firstName, String lastName, String zipCode){
        this.FIRST_NAME.shouldBe(editable).setValue(firstName);
        this.LAST_NAME.shouldBe(editable).setValue(lastName);
        this.POSTAL_CODE.should(editable).setValue(zipCode);
        return this;
    }

    public CheckoutOverviewPage continueToConfirmation(){
        this.CONTINUE_BUTTON.shouldBe(enabled).click();
        return new CheckoutOverviewPage();
    }
}
