package com.saucedemo.tests;

import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(TextReportExtension.class)
public class BaseTest {

    @BeforeAll
    static void setupAllureReports(){
        SelenideLogger.addListener("AllureSelenide",new AllureSelenide());
        SelenideLogger.addListener("AllureSelenide",new AllureSelenide().screenshots(false).savePageSource(true));
    }

    @BeforeEach
    public void setup(){
        open("https://www.saucedemo.com/");
    }
}
