package com.demo.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("santhosh-test-device");
        options.setApp(System.getProperty("user.dir")+"/apps/Android-MyDemoApp.apk");
        try {
            return new io.appium.java_client.android.AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
