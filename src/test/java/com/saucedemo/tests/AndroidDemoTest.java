package com.saucedemo.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.ScreenObject;
import com.codeborne.selenide.appium.SelenideAppium;
import com.demo.drivers.AndroidDriver;
import com.saucedemo.screens.HomeScreen;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;

public class AndroidDemoTest {

    @Test
    void launchAndroidTest() throws MalformedURLException {
        Configuration.browser= AndroidDriver.class.getName();
        SelenideAppium.launchApp();
        ScreenObject.screen(HomeScreen.class).selectProduct().addToCart();
    }

    @Test
    public void launchAndroidDeepLinkTest(){
        Configuration.browser=AndroidDriver.class.getName();
        SelenideAppium.openAndroidDeepLink("mydemoapprn://product-details/1", "com.saucelabs.mydemoapp.rn");
        Selenide.sleep(5000);
    }

    @Test
    public void scrollTest(){
        SelenideAppium.launchApp();
        ScreenObject.screen(HomeScreen.class).verifyCopyRightTextPresence();
    }
}
