package com.saucedemo.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CreateOrderTest {

    @Test
    public void createOrder() throws AWTException {
        Configuration.pageLoadTimeout=3000;
        Selenide.open("https://www.saucedemo.com/");
        $(Selectors.byName("user-name")).shouldBe(Condition.visible).setValue("standard_user");
        $(Selectors.byAttribute("id","password")).shouldBe(Condition.visible).setValue("secret_sauce");
        $x("//input[@type='submit']").click();
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        $(Selectors.byText("Swag Labs")).shouldHave(Condition.exist, Duration.ofSeconds(2000));
        String product=$$("div[class='inventory_item_name ']").get(0).getText();
        $$("div[class='inventory_item']").get(0).$(Selectors.byTagAndText("button","Add to cart")).shouldBe(Condition.visible).click();
        $(Selectors.byClassName("shopping_cart_badge")).shouldHave(Condition.text("1"));
        $(Selectors.byClassName("shopping_cart_link")).click();
        $(Selectors.byClassName("inventory_item_name")).shouldHave(Condition.text(product));
        $(Selectors.byTagAndText("button","Checkout")).click();
        $(Selectors.byAttribute("data-test","firstName")).setValue("Santhosh");
        element("input[placeholder='Last Name']").setValue("Ishaan");
        element(Selectors.byId("postal-code")).setValue("13587");
        element(Selectors.byValue("Continue")).click();
        $(Selectors.byClassName("inventory_item_name")).shouldHave(Condition.text(product));
        element(Selectors.byText("Finish")).click();
        element(Selectors.byTagName("h2")).shouldHave(Condition.text("Thank you for your order!"));
    }
}
