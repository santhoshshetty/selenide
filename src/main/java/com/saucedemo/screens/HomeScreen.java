package com.saucedemo.screens;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.appium.*;
import com.codeborne.selenide.appium.conditions.CombinedAttribute;
import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;

public class HomeScreen {
    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"store item\"]")
    private WebElement products;

    private final By productAndroid= AppiumSelectors.byAttribute("content-desc","store item");
    private final By productiOS= AppiumSelectors.withAttribute("content-desc","store item");
    private final By copyRightText=By.xpath("//android.widget.TextView[@text='© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy.']");

    public PDPScreen selectProduct(){
        CombinedBy product=CombinedBy.android(productAndroid).ios(productiOS);
        $(product).shouldBe(visible).click(AppiumClickOptions.tap());
        return screen(PDPScreen.class);
    }

    private CombinedBy copyRightCombinedBy=CombinedBy.android(copyRightText);

    public void verifyCopyRightTextPresence(){
        CombinedAttribute attribute=CombinedAttribute.android("text").ios("name");
        SelenideAppium.$(copyRightCombinedBy).scroll(AppiumScrollOptions.down(10))
                .shouldHave(AppiumCondition.attribute(attribute,"© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy."));
    }
}
