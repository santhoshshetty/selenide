package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private static final SelenideElement USER_NAME=$(byName("user-name"));
    private static final SelenideElement PASSWORD=$(byAttribute("id","password"));
    private static final SelenideElement SUBMIT_BUTTON=$x("//input[@type='submit']");

    public InventoryPage login(String userName, String password){
        this.USER_NAME.shouldBe(visible).setValue(userName);
        this.PASSWORD.shouldBe(visible).setValue(password);
        this.SUBMIT_BUTTON.click();
        return new InventoryPage();
    }
}
