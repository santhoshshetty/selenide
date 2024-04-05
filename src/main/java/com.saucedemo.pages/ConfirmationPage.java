package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.element;

public class ConfirmationPage {

    private static final SelenideElement SUCCESS_MESSAGE=element(byTagName("h2"));

    public void successMessageDisplayed(String message){
        SUCCESS_MESSAGE.shouldHave(visible).shouldHave(text(message));
    }

}
